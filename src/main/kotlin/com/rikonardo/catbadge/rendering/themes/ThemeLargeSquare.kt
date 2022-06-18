package com.rikonardo.catbadge.rendering.themes

import com.rikonardo.catbadge.badge.Badge
import com.rikonardo.catbadge.rendering.*
import java.awt.Color
import java.awt.Font
import java.awt.Graphics2D

@Suppress("DuplicatedCode")
object ThemeLargeSquare : RenderingTheme {
    override fun render(badge: Badge, gp: GraphicsProvider): Graphics2D {
        val verdana = Fonts.verdana.deriveFont(10f)
        val verdanaBold = Fonts.verdana.deriveFont(Font.BOLD, 10f)

        val label = badge.label?.uppercase() ?: ""
        val message = badge.message?.uppercase() ?: ""
        val height = 28
        var leftWidth = textWidth(gp, label, verdana).toInt()
        // Using PNG provider, because SVG have problems with bold font
        var rightWidth = textWidth(GraphicsProvider.PNG, message, verdanaBold).toInt()
        val leftColor = badge.labelBackgroundColor ?: Color(85, 85, 85)
        val rightColor = badge.messageBackgroundColor ?: Color(0, 126, 198)
        val iconHeight = height - 3 * 2
        val iconWith = (if (badge.icon != null)
            badge.icon!!.width.toDouble() * iconHeight / badge.icon!!.height else 0.0).toInt()
        if (iconWith > 0) {
            if (leftWidth != 0) leftWidth += iconWith + 5
            else rightWidth += iconWith + 5
        }
        val leftWidthFull = if (leftWidth != 0) leftWidth + 28 else 0
        val rightWidthFull = if (rightWidth != 0) rightWidth + 28 else 0
        val totalWidth = leftWidthFull + rightWidthFull

        val g = gp.create(totalWidth, height)
        g.color = leftColor
        g.fillRect(0, 0, leftWidthFull, height)
        g.color = rightColor
        g.fillRect(leftWidthFull, 0, totalWidth, height)
        g.paint = null
        g.color = Color(255, 255, 255)
        if (badge.icon != null) g.drawImage(badge.icon, 5, 3, iconWith, iconHeight, null)
        g.font = verdana
        g.color = badge.labelTextColor ?: getForeground(leftColor)
        g.drawString(label, 14 + (if (badge.icon != null && leftWidth != 0) iconWith + 5 else 0), height - 10)

        g.font = verdanaBold
        g.color = badge.messageTextColor ?: getForeground(rightColor)
        g.drawString(message, 14 + leftWidthFull + (if (badge.icon != null && leftWidth == 0) iconWith + 5 else 0), height - 10)

        return g
    }
}
