package com.rikonardo.catbadge.badge

class ProviderFactory(
    private val provider: Class<BadgeProvider>
) {
    private val properties = provider.declaredFields
        .filter { it.isAnnotationPresent(BadgeProperty::class.java) }
        .onEach { if (it.type != String::class.java) throw IllegalArgumentException("Property type must be String") }
        .associateBy { it.getAnnotation(BadgeProperty::class.java).name }

    val category: String
    val name: String
    val description: String
    val props: List<String>
        get() = properties.keys.toList()

    init {
        val declaration = provider.getAnnotation(RegisterBadge::class.java)
        category = declaration.category
        name = declaration.name
        description = declaration.description
    }

    fun create(props: Map<String, String>): BadgeProvider {
        val instance = provider.getConstructor().newInstance()
        properties.forEach { (name, field) ->
            field.isAccessible = true
            field.set(instance, props[name])
        }
        return instance
    }
}
