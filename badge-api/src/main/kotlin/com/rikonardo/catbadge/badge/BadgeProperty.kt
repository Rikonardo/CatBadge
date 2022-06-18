package com.rikonardo.catbadge.badge

@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
annotation class BadgeProperty(
    val name: String
)
