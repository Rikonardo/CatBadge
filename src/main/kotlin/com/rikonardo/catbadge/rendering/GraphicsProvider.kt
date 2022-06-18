package com.rikonardo.catbadge.rendering

import org.jfree.graphics2d.svg.SVGGraphics2D
import java.awt.Graphics2D
import java.awt.image.BufferedImage
import java.io.ByteArrayOutputStream
import javax.imageio.ImageIO

enum class GraphicsProvider {
    SVG,
    PNG,
    WEBP;

    fun create(width: Int, height: Int) = when (this) {
        SVG -> SVGGraphics2D(width, height)
        PNG -> WrappedGraphics2D(width, height, BufferedImage.TYPE_INT_ARGB)
        WEBP -> WrappedGraphics2D(width, height, BufferedImage.TYPE_INT_ARGB)
    }

    fun bake(g: Graphics2D): Pair<String, ByteArray> {
        return when (this) {
            SVG -> "image/svg+xml" to (g as SVGGraphics2D).svgDocument.toByteArray()
            PNG -> {
                val stream = ByteArrayOutputStream()
                ImageIO.write((g as WrappedGraphics2D).image, "png", stream)
                "image/png" to stream.toByteArray()
            }
            WEBP -> {
                val stream = ByteArrayOutputStream()
                ImageIO.write((g as WrappedGraphics2D).image, "webp", stream)
                "image/webp" to stream.toByteArray()
            }
        }
    }
}
