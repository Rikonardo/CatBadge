package com.rikonardo.catbadge.server

import com.rikonardo.catbadge.badge.ProviderFactory
import com.rikonardo.catbadge.config.Config
import dev.virefire.viira.application

fun setupServer(providers: List<ProviderFactory>) {
    val app = application {
        trustProxy = Config.trustProxy
        proxyHeader = Config.proxyHeader
    }

    app.get("/") {
        res.status(200).type("text/html").body(homePage(providers))
    }

    handleBadges(app, providers)

    println("Starting server on port ${Config.serverPort}")
    app.start(Config.serverHost, Config.serverPort, wait = true)
}
