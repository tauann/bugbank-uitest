package utils

import java.io.FileInputStream
import java.util.*

val HEADLESS by lazy { get("headless").toBoolean() }
val TIMEOUT by lazy { get("timeout")!!.toLong() }

private val properties = Properties()

private fun get(property: String): String? {
    FileInputStream("src/main/resources/config.properties").use { inputStream ->
        properties.load(inputStream)
        return properties.getProperty(property)
    }
}
