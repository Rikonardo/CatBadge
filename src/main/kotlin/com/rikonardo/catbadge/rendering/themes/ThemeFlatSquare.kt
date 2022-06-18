package com.rikonardo.catbadge.rendering.themes

import com.rikonardo.catbadge.badge.Badge
import com.rikonardo.catbadge.rendering.*
import java.awt.Color
import java.awt.Graphics2D

@Suppress("DuplicatedCode")
object ThemeFlatSquare : RenderingTheme {
    override fun render(badge: Badge, gp: GraphicsProvider): Graphics2D {
        val verdana = Fonts.verdana.deriveFont(11f)

        val label = badge.label?.lowercase() ?: ""
        val message = badge.message?.lowercase() ?: ""
        val height = 20
        var leftWidth = textWidth(gp, label, verdana).toInt()
        var rightWidth = textWidth(gp, message, verdana).toInt()
        val leftColor = badge.labelBackgroundColor ?: Color(85, 85, 85)
        val rightColor = badge.messageBackgroundColor ?: Color(0, 126, 198)
        val iconHeight = height - 3 * 2
        val iconWith = (if (badge.icon != null)
            badge.icon!!.width.toDouble() * iconHeight / badge.icon!!.height else 0.0).toInt()
        if (iconWith > 0) {
            if (leftWidth != 0) leftWidth += iconWith + 5
            else rightWidth += iconWith + 5
        }
        val leftWidthFull = if (leftWidth != 0) leftWidth + 11 else 0
        val rightWidthFull = if (rightWidth != 0) rightWidth + 11 else 0
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
        g.color = Color(1, 1, 1, (0.3 * 255).toInt())
        g.drawString(label, 5 + (if (badge.icon != null && leftWidth != 0) iconWith + 5 else 0), height - 5)
        g.color = badge.labelTextColor ?: getForeground(leftColor)
        g.drawString(label, 5 + (if (badge.icon != null && leftWidth != 0) iconWith + 5 else 0), height - 6)

        g.color = Color(1, 1, 1, (0.3 * 255).toInt())
        g.drawString(message, 5 + leftWidthFull + (if (badge.icon != null && leftWidth == 0) iconWith + 5 else 0), height - 5)
        g.color = badge.messageTextColor ?: getForeground(rightColor)
        g.drawString(message, 5 + leftWidthFull + (if (badge.icon != null && leftWidth == 0) iconWith + 5 else 0), height - 6)

        return g
    }
}
