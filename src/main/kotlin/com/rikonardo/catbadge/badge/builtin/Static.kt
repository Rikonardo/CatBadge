package com.rikonardo.catbadge.badge.builtin

import com.rikonardo.catbadge.badge.*
import java.awt.Color

@RegisterBadge(
    category = "Builtin",
    name = "Static",
    description = "Make badge with static text\nStructure: <label>-<message>-<color>\nUse \"--\" for dashes, \"__\" for underscores, \"_\" for spaces",
)
@Suppress("DuplicatedCode")
class Static : BadgeProvider {
    @BadgeProperty("text")
    lateinit var text: String
    override fun make(): Badge {
        val parts = " $text ".split("(?<=[^-])-(?=[^-])".toRegex()).map {
            it
                .replace("--", "-")
                .replace("(?<=[^_])_(?=[^_])".toRegex(), " ")
                .replace("__", "_")
        }.toMutableList()
        parts[0] = parts[0].substring(1)
        parts[parts.size - 1] = parts[parts.size - 1].substring(0, parts[parts.size - 1].length - 1)
        if (parts.size > 3) throw BadgeError("Invalid syntax")
        return Badge(
            label = if (parts.isNotEmpty()) parts[0] else null,
            message = if (parts.size > 1) parts[1] else null,
            messageBackgroundColor = if (parts.size > 2) {
                try {
                    ColorCollection.valueOf(parts[2].uppercase()).color
                } catch (_: Exception) {
                    try {
                        Color(Integer.parseInt(parts[2], 16))
                    } catch (_: Exception) {
                        null
                    }
                }
            } else null
        )
    }
}
