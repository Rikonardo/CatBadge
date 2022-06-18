package com.rikonardo.catbadge.rendering

import com.rikonardo.catbadge.badge.Badge
import com.rikonardo.catbadge.rendering.themes.ThemeFlat
import com.rikonardo.catbadge.rendering.themes.ThemeFlatSquare
import com.rikonardo.catbadge.rendering.themes.ThemeLargeSquare
import java.awt.Graphics2D

interface RenderingTheme {
    companion object {
        val FLAT = ThemeFlat
        val FLAT_SQUARE = ThemeFlatSquare
        val LARGE_SQUARE = ThemeLargeSquare
    }

    fun render(badge: Badge, gp: GraphicsProvider): Graphics2D
}
