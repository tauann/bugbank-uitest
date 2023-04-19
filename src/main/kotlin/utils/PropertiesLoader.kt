package utils

import java.io.FileInputStream
import java.util.*

val ENABLE_HEADLESS by lazy { get("browser.enable.headless").toBoolean() }

private val properties = Properties()

private fun get(property: String): String? {
    FileInputStream("src/main/resources/config.properties").use { inputStream ->
        properties.load(inputStream)
        return properties.getProperty(property)
    }
}
