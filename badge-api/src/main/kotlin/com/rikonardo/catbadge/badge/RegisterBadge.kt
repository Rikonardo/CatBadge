package com.rikonardo.catbadge.badge

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class RegisterBadge(
    val category: String,
    val name: String,
    val description: String
)
