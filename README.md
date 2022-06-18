# CatBadge ✨
A selfhosted lightweight custom badges generator, powered by catboys cuteness 😻

[![Live Example](https://cat.rikonardo.com/builtin/static/CLICK_TO_VISIT-EXAMPLE_SITE_?style=large-square)](https://cat.rikonardo.com)

**Note, that CatBadge is just an engine and doesn't include any badges except static one by default. In order to add custom dynamic badges, you need to write an extension. For example, [this is my extension](https://github.com/Rikonardo/MyCatBadges).**

[How to make an extension?](#developing-extension)

## Formats
CatBadge supports **svg**, **webp** and **png** formats out of the box:

| Format | URL param      | Example                                                                               |
|--------|----------------|---------------------------------------------------------------------------------------|
| SVG    | `?format=svg`  | ![SVG example](https://cat.rikonardo.com/builtin/static/mutiple-formats?format=svg)   |
| WEBP   | `?format=webp` | ![WebP example](https://cat.rikonardo.com/builtin/static/mutiple-formats?format=webp) |
| PNG    | `?format=png`  | ![PNG example](https://cat.rikonardo.com/builtin/static/mutiple-formats?format=png)   |
This can be useful when SVG format not supported by website. By default, CatBadge uses SVG format.

## Styles
CatBadge supports three styles inspired by [shields.io](https://shields.io/):

| Theme        | URL param             | Example                                                                                     |
|--------------|-----------------------|---------------------------------------------------------------------------------------------|
| Flat         | `?style=flat`         | ![Flat](https://cat.rikonardo.com/builtin/static/mutiple-styles?style=flat)                 |
| Flat Square  | `?style=flat-square`  | ![Flat Square](https://cat.rikonardo.com/builtin/static/mutiple-styles?style=flat-square)   |
| Large Square | `?style=large-square` | ![Large Square](https://cat.rikonardo.com/builtin/static/mutiple-styles?style=large-square) |

## Icon
CatBadge allows to set icon from base64 encoded image via ``?icon=data:image/png;base64,iVBORw0KGg...`` parameter.

If badge serves icon by default, you can remove it by adding empty icon param (`?icon=`).

If badge has no label, icon will be placed in the message section.

![Icon Example](https://cat.rikonardo.com/builtin/static/cat-icon?icon=data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAYAAAAf8/9hAAAABHNCSVQICAgIfAhkiAAAAAlwSFlzAAAAbgAAAG4BI+U+pwAAABl0RVh0U29mdHdhcmUAd3d3Lmlua3NjYXBlLm9yZ5vuPBoAAAGvSURBVDiNnZA9axRRFIafc2fGRdyPmWww2Q/SqqmE4G7QQH6ArYVgJQQ7BX+GlaBYueAIpogk/gdBkCRsYSFikRQirolNdtysJvNxLCbuR0YWzOnOc+773HOvqM8O8AXlLQ4t7uhXJtWq1AlZQVgG5kR9esCFk3EItAh4yH09Ggs+lRxFHgMrgHNCD0V9OsDs2GGRLQr5NxiZR0mI4o/86t8i0eapfb7bQG/Q2jbMXIRioUE3aPCtk/JaFebqcNCF/R8Qx38TvaHALcHsDBjDoI+itC8VU+a5UCxAZw+CYCD4ST4P1Ur2w6bLWWZZUKuk8n6/Z8jlYmr/CE8qEahXwXFCQ9krY1mD2bNXUzxf8zKZJy/L+BvuENg2THklg1sK/u/6kXK9fdGty7+B3BkVewY4PvMG6LENrAN3R3H/UR49MGNHTSXm/IPDU3lZN0ALiEe5s5RdyrmRYSEWL0RVYfvKMrAK1ABIIHx3juiDAxbYV0Oc62OCXUhuc+3zdioAaF+aRo2PcnPyu+U15ugeCztdgKEgHQrt+QZJvIhKE2ERiEA2Ed0k5j3NT+1R3R/Kw4h8lIQ4mgAAAABJRU5ErkJggg==) ![Icon Example](https://cat.rikonardo.com/builtin/static/-cat_icon?icon=data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAYAAAAf8/9hAAAABHNCSVQICAgIfAhkiAAAAAlwSFlzAAAAbgAAAG4BI+U+pwAAABl0RVh0U29mdHdhcmUAd3d3Lmlua3NjYXBlLm9yZ5vuPBoAAAGvSURBVDiNnZA9axRRFIafc2fGRdyPmWww2Q/SqqmE4G7QQH6ArYVgJQQ7BX+GlaBYueAIpogk/gdBkCRsYSFikRQirolNdtysJvNxLCbuR0YWzOnOc+773HOvqM8O8AXlLQ4t7uhXJtWq1AlZQVgG5kR9esCFk3EItAh4yH09Ggs+lRxFHgMrgHNCD0V9OsDs2GGRLQr5NxiZR0mI4o/86t8i0eapfb7bQG/Q2jbMXIRioUE3aPCtk/JaFebqcNCF/R8Qx38TvaHALcHsDBjDoI+itC8VU+a5UCxAZw+CYCD4ST4P1Ur2w6bLWWZZUKuk8n6/Z8jlYmr/CE8qEahXwXFCQ9krY1mD2bNXUzxf8zKZJy/L+BvuENg2THklg1sK/u/6kXK9fdGty7+B3BkVewY4PvMG6LENrAN3R3H/UR49MGNHTSXm/IPDU3lZN0ALiEe5s5RdyrmRYSEWL0RVYfvKMrAK1ABIIHx3juiDAxbYV0Oc62OCXUhuc+3zdioAaF+aRo2PcnPyu+U15ugeCztdgKEgHQrt+QZJvIhKE2ERiEA2Ed0k5j3NT+1R3R/Kw4h8lIQ4mgAAAABJRU5ErkJggg==)

## Color overriding
You can override colors for any badge.

| URL params                                      | Example                                                                                                           |
|-------------------------------------------------|-------------------------------------------------------------------------------------------------------------------|
| `?labelColor=FFFFFF`                            | ![Example](https://cat.rikonardo.com/builtin/static/color-overriding?labelColor=FFFFFF)                           |
| `?labelColor=FFFFFF&labelTextColor=2288EE`      | ![Example](https://cat.rikonardo.com/builtin/static/color-overriding?labelColor=FFFFFF&labelTextColor=2288EE)     |
| `?messageColor=111111`                          | ![Example](https://cat.rikonardo.com/builtin/static/color-overriding?messageColor=111111)                         |
| `?&messageColor=111111&messageTextColor=22BBEE` | ![Example](https://cat.rikonardo.com/builtin/static/color-overriding?messageColor=111111&messageTextColor=22BBEE) |

CatBadge also has same pre-defined colors as [shields.io](https://shields.io/#colors) (brightgreen, green, yellowgreen, yellow, orange, red, blue, lightgrey, success, important, critical, informational, inactive).

## Developing Extension
As I said, CatBadge doesn't include any dynamic badges by default, so you need to make extension yourself.

To make an extension, create empty Kotlin/JVM project.

To start, we gonna add CatBadge api as compile-time dependency.

```kotlin
repositories {
    maven {
        url = uri("https://maven.rikonardo.com/releases")
    }
}

dependencies {
    compileOnly("com.rikonardo.catbadge:badge-api:1.0.0")
}
```

If you are new to Kotlin, I highly recommend using [Yok](https://github.com/Virefire/Yok) HTTP request library to make API requests. So we gonna add it and KSON json parsing library as runtime dependencies.

```kotlin
dependencies {
    implementation("dev.virefire.yok:Yok:1.0.4")
    implementation("dev.virefire.kson:KSON:1.3.1")
}
```

Because we are using some libraries, let's install Gradle Shadow plugin to include them in our extension jar.

```kotlin
plugins {
    id("com.github.johnrengelman.shadow") version "7.1.2"
}

tasks.build {
    dependsOn(tasks.getByName("shadowJar")) // Autorun shadowJar on build
}

tasks.withType<com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar> {
    archiveClassifier.set("") // Replace our common jar with a bundled one
}
```

Now, let's create a Kotlin class, representing our badge. It must implement `BadgeProvider` interface and have the `@RegisterBadge` annotation.

```kotlin
@RegisterBadge(
    category = "My Badges",
    name = "My Badge",
    description = "It's my awesome badge",
)
class MyBadge : BadgeProvider {
    override fun make(): Badge {
        return Badge(
            label = "hello",
            message = "world",
        )
    }
}
```

We can also accept parameters by adding variable class field with `@BadgeProperty` annotation. You can add as many properties as you want.

```kotlin
class MyBadge : BadgeProvider {
    @BadgeProperty("name") lateinit var name: String
    
    override fun make(): Badge {
        return Badge(
            label = "hello",
            message = name,
        )
    }
}
```

And here is an example of badge that displays current time in Amsterdam:

```kotlin
@RegisterBadge(
    category = "My Badges",
    name = "Time In Amsterdam",
    description = "Display current time in Amsterdam",
)
class TimeInAmsterdam : BadgeProvider {
    override fun make(): Badge {
        val res = Yok.get("https://timeapi.io/api/Time/current/zone?timeZone=Europe/Amsterdam")
        return Badge(
            label = "time",
            message = res.body.json["time"].string!!,
        )
    }
}
```

To install your extension, simply place it in the "extensions" directory located in the folder where your CatBadge instance is running. Extension does not require any configuration or manifest to work.

---

> P.S. Cat icon form [Icon](#icon) example created by [Pixel perfect](https://www.flaticon.com/free-icon/cat_725058).
