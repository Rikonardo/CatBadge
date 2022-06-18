package com.rikonardo.catbadge.badge

import org.reflections.Reflections
import java.io.File
import java.net.URLClassLoader
import java.util.zip.ZipFile

@Suppress("UNCHECKED_CAST")
fun loadProviders(): List<ProviderFactory> {
    val classes = mutableListOf<String>()
    val classLoader = URLClassLoader(
        File("extensions").listFiles().orEmpty().mapNotNull { file ->
            if (file.isDirectory || !file.name.endsWith(".jar")) return@mapNotNull null
            ZipFile(file).use { zip ->
                classes.addAll(
                    zip.entries().asSequence()
                        .filter { !it.isDirectory && it.name.endsWith(".class") && !it.name.startsWith("META-INF/") }
                        .map { it.name.replace("/", ".").substringBeforeLast(".") }
                )
            }
            file.toURI().toURL()
        }.toTypedArray(),
        ::loadProviders::class.java.classLoader
    )

    val providers = mutableListOf<ProviderFactory>()
    providers.addAll(
        Reflections("com.rikonardo.catbadge.badge.builtin")
            .getSubTypesOf(BadgeProvider::class.java)
            .filter { it.isAnnotationPresent(RegisterBadge::class.java) }
            .map { ProviderFactory(it as Class<BadgeProvider>) }
    )

    classes.forEach {
        try {
            val c = Class.forName(it, false, classLoader)
            if (c.isAnnotationPresent(RegisterBadge::class.java) && BadgeProvider::class.java.isAssignableFrom(c))
                providers.add(ProviderFactory(c as Class<BadgeProvider>))
        } catch (_: Throwable) { }
    }

    return providers
}
