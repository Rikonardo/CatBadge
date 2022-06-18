package com.rikonardo.catbadge.badge

import java.awt.Color

enum class ColorCollection(val color: Color) {
    BRIGHTGREEN(Color(68, 204, 17)),
    GREEN(Color(151, 202, 0)),
    YELLOWGREEN(Color(164, 166, 29)),
    YELLOW(Color(223, 179, 23)),
    ORANGE(Color(254, 125, 55)),
    RED(Color(224, 93, 68)),
    BLUE(Color(0, 126, 198)),
    LIGHTGREY(Color(159, 159, 159)),

    SUCCESS(GREEN.color),
    IMPORTANT(ORANGE.color),
    CRITICAL(RED.color),
    INFORMATIONAL(BLUE.color),
    INACTIVE(LIGHTGREY.color)
}
