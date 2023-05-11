package utils

import io.github.bonigarcia.wdm.WebDriverManager
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeOptions


object DriverManager {

    var driver: WebDriver? = null
        get() {
            if (field == null) setupDriver()
            return field
        }
        private set

    fun closeDriver() {
        driver?.quit()
        driver = null
    }

    private fun setupDriver() {
        val options = chromeOptions()
        driver = WebDriverManager.chromedriver().capabilities(options).create()
    }

    private fun chromeOptions(): ChromeOptions {
        val options = ChromeOptions()
        options.addArguments("--headless=new")
        return options
    }

}