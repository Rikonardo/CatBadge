package com.rikonardo.catbadge

import com.rikonardo.catbadge.badge.loadProviders
import com.rikonardo.catbadge.server.setupServer

fun main() {
    println("Initializing...")
    val providers = loadProviders()
    println("${providers.size} badge(s) loaded")
    setupServer(providers)
}
