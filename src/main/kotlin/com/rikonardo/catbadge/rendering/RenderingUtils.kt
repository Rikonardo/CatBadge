package com.rikonardo.catbadge.rendering

import java.awt.Color
import java.awt.Font
import java.awt.Graphics2D

object Fonts {
    val verdana = Font.createFont(
        Font.TRUETYPE_FONT,
        javaClass.getResourceAsStream("/com/rikonardo/catbadge/verdana.ttf")
    )
}

fun getForeground(background: Color): Color {
    val r = background.red
    val g = background.green
    val b = background.blue
    val a = background.alpha
    val max = maxOf(r, g, b)
    val min = minOf(r, g, b)
    val avg = (max + min) / 2
    return if (avg > 200)
        Color(0, 0, 0, a)
    else
        Color(255, 255, 255, a)
}

private val contextGraphics = mutableMapOf<GraphicsProvider, Graphics2D>()
private fun contextGraphics(gp: GraphicsProvider): Graphics2D {
    if (!contextGraphics.containsKey(gp)) {
        contextGraphics[gp] = gp.create(1, 1)
    }
    return contextGraphics[gp]!!
}

fun textWidth(gp: GraphicsProvider, text: String, font: Font): Double {
    val ctx = contextGraphics(gp)
    return /*if (gp == GraphicsProvider.SVG) {
        val ctx2 = contextGraphics(GraphicsProvider.PNG)
        font.getStringBounds(text, ctx2.fontRenderContext).width
    } else */font.getStringBounds(text, ctx.fontRenderContext).width
}
