package com.rikonardo.catbadge.config

import dev.virefire.kson.KSON
import java.io.File

object Config {
    private val file = File("config.json")
    private val default = mapOf(
        "catbadge_version" to "1.0.0",
        "server" to mapOf(
            "port" to 8080,
            "host" to "0.0.0.0",
            "proxy" to mapOf(
                "trust_proxy" to true,
                "proxy_header" to "X-Forwarded-For"
            )
        )
    )

    val serverPort: Int
    val serverHost: String
    val trustProxy: Boolean
    val proxyHeader: String

    init {
        if (!file.exists()) {
            file.writeText(KSON.stringify(default, " ".repeat(4)))
        }
        val cfg = KSON.parse(file.readText())
        serverPort = cfg["server"]["port"].int!!
        serverHost = cfg["server"]["host"].string!!
        trustProxy = cfg["server"]["proxy"]["trust_proxy"].boolean!!
        proxyHeader = cfg["server"]["proxy"]["proxy_header"].string!!
    }
}
