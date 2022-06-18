package com.rikonardo.catbadge.server

import com.rikonardo.catbadge.badge.ProviderFactory

private fun toHtml(html: String): String {
    return html
        .replace("&", "&amp;")
        .replace("<", "&lt;")
        .replace(">", "&gt;")
        .replace("\n", "<br>")
}

fun homePage(providers: List<ProviderFactory>): String {
    //language=HTML
    return """
        <html lang="en">
            <head>
                <title>Badge List</title>
                <style>
                    body {
                        font-family: Calibri, sans-serif;
                        font-size: 14pt;
                    }
                    .category {
                        margin-bottom: 16px;
                    }
                    .category h1 {
                        font-size: 30pt;
                        margin-top: 16px;
                        margin-bottom: 20px;
                        text-align: center;
                    }
                    .badge {
                        margin: 10px;
                        padding: 10px;
                        border: solid 1px #222222;
                        border-radius: 3px;
                    }
                    .badge h2 {
                        font-size: 22pt;
                        margin-bottom: 0;
                        margin-top: -4px;
                    }
                    .badge p {
                        margin-top: 0;
                    }
                    .badge span {
                        font-size: 9pt;
                        color: #fff;
                        font-family: monospace;
                        margin: -10px;
                        background: #222222;
                        display: block;
                        padding: 10px;
                    }
                    a {
                        text-decoration: none;
                        color: #0066ff;
                    }
                    a:hover {
                        text-decoration: underline;
                    }
                    .powered-by {
                        text-align: center;
                        font-weight: bold;
                    }
                </style>
            </head>
            <body>
                ${
                    run {
                        val grouped = providers.groupBy { it.category }
                        grouped.keys.sorted().joinToString("\n") { key ->
                            val group = grouped[key]!!.sortedBy { it.name }
                            """
                                <div class="category">
                                    <h1>${toHtml(key)}</h1>
                                    ${
                                        group.joinToString("\n") { provider ->
                                            """
                                                <div class="badge">
                                                    <h2>${toHtml(provider.name)}</h2>
                                                    <p>
                                                        ${toHtml(provider.description)}
                                                    </p>
                                                    <span>
                                                        <script>document.write(location.origin)</script>/${
                                                            key.replace(' ', '-').lowercase()
                                                        }/${
                                                            provider.name.replace(' ', '-').lowercase()
                                                        }${
                                                            if (provider.props.isNotEmpty())
                                                                "/" + provider.props.joinToString("/") { "{$it}" }
                                                            else ""
                                                        }
                                                    </span>
                                                </div>
                                            """.trimIndent()
                                        }
                                    }
                                </div>
                            """.trimIndent()
                        }
                    }
                }
                <p class="powered-by">Powered by <a href="https://github.com/Rikonardo/CatBadge" target="_blank">CatBadge</a></p>
            </body>
        </html>
    """.trimIndent().replace(" ".repeat(4), "")
}
