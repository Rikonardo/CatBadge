package com.rikonardo.catbadge.server

import com.rikonardo.catbadge.badge.Badge
import com.rikonardo.catbadge.badge.BadgeError
import com.rikonardo.catbadge.badge.ColorCollection
import com.rikonardo.catbadge.badge.ProviderFactory
import com.rikonardo.catbadge.rendering.GraphicsProvider
import com.rikonardo.catbadge.rendering.RenderingTheme
import dev.virefire.viira.Application
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.awt.Color
import java.io.ByteArrayInputStream
import java.util.*
import javax.imageio.ImageIO

private fun getColor(color: String): Color? {
    return try {
        ColorCollection.valueOf(color.uppercase()).color
    } catch (_: Exception) {
        try {
            Color(Integer.parseInt(color, 16))
        } catch (_: Exception) {
            null
        }
    }
}

private fun badgeOverrides(query: Map<String, String>, badge: Badge) {
    if (query.containsKey("labelColor")) {
        val color = getColor(query["labelColor"]!!)
        if (color != null) badge.labelBackgroundColor = color
    }
    if (query.containsKey("messageColor")) {
        val color = getColor(query["messageColor"]!!)
        if (color != null) badge.messageBackgroundColor = color
    }
    if (query.containsKey("labelTextColor")) {
        val color = getColor(query["labelTextColor"]!!)
        if (color != null) badge.labelTextColor = color
    }
    if (query.containsKey("messageTextColor")) {
        val color = getColor(query["messageTextColor"]!!)
        if (color != null) badge.messageTextColor = color
    }
    if (query.containsKey("icon")) {
        val icon = query["icon"]!!
        if (icon.isEmpty()) badge.icon = null
        else try {
            val base64Image = (if (icon.contains(",")) icon.split(",")[1] else icon).replace(" ", "+")
            val imageBytes = Base64.getDecoder().decode(base64Image)
            badge.icon = ImageIO.read(ByteArrayInputStream(imageBytes))
        } catch (e: Exception) {
            println(e)
            badge.icon = null
        }
    }
}

fun handleBadges(app: Application, providers: List<ProviderFactory>) {
    providers.forEach { p ->
        app.get("/${
            p.category.replace(' ', '-').lowercase()
        }/${
            p.name.replace(' ', '-').lowercase()
        }${
            if (p.props.isNotEmpty())
                "/" + p.props.joinToString("/") { ":$it" }
            else ""
        }") {
            // Set format
            var format = GraphicsProvider.SVG
            if (req.query.containsKey("format")) when (req.query["format"]) {
                "svg" -> format = GraphicsProvider.SVG
                "png" -> format = GraphicsProvider.PNG
                "webp" -> format = GraphicsProvider.WEBP
            }
            // Set theme
            var theme: RenderingTheme = RenderingTheme.FLAT
            if (req.query.containsKey("style")) when (req.query["style"]) {
                "flat" -> theme = RenderingTheme.FLAT
                "flat-square" -> theme = RenderingTheme.FLAT_SQUARE
                "large-square" -> theme = RenderingTheme.LARGE_SQUARE
            }
            // Make and render badge
            val result = withContext(Dispatchers.IO) {
                val gr = try {
                    val badge = p.create(req.params).make()
                    badgeOverrides(req.query, badge)
                    theme.render(badge, format)
                } catch (e: Exception) {
                    if (e is BadgeError) {
                        theme.render(
                            Badge(
                                label = "error",
                                message = e.message?.lowercase() ?: "failed to generate badge",
                                messageBackgroundColor = ColorCollection.RED.color
                            ), format
                        )
                    } else {
                        e.printStackTrace()
                        theme.render(
                            Badge(
                                label = "error",
                                message = "failed to generate badge",
                                messageBackgroundColor = ColorCollection.RED.color
                            ), format
                        )
                    }
                }
                return@withContext format.bake(gr)
            }
            res.status(200).type(result.first).body(result.second)
        }
    }
}
