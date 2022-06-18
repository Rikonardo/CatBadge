package com.rikonardo.catbadge.badge

import java.awt.Color
import java.awt.image.BufferedImage

data class Badge(
    var label: String? = null,
    var message: String? = null,
    var icon: BufferedImage? = null,
    var labelBackgroundColor: Color? = null,
    var messageBackgroundColor: Color? = null,
    var labelTextColor: Color? = null,
    var messageTextColor: Color? = null
)
