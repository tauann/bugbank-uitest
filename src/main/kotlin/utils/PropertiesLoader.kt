package utils

import java.io.FileInputStream
import java.util.*

val BROWSER_HEADLESS by lazy { get("browser.headless").toBoolean() }

private val properties = Properties()

private fun get(property: String): String? {
    FileInputStream("src/main/resources/config.properties").use { inputStream ->
        properties.load(inputStream)
        return properties.getProperty(property)
    }
}
