package utils

import io.github.bonigarcia.wdm.WebDriverManager
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeOptions


object DriverManager {

    private var driver: WebDriver? = null

    fun getDriver(): WebDriver {
        if (driver == null) setupDriver()
        return driver!!
    }

    fun closeDriver() {
        driver!!.quit()
        driver = null
    }

    private fun setupDriver() {
        val options = chromeOptions()
        driver = WebDriverManager.chromedriver().capabilities(options).create()
        driver!!.manage().window().maximize()
    }

    private fun chromeOptions(): ChromeOptions {
        val options = ChromeOptions()
        if (ENABLE_HEADLESS) options.addArguments("--headless=new")
        return options
    }


}