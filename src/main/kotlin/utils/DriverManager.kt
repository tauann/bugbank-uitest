package utils

import io.github.bonigarcia.wdm.WebDriverManager
import org.openqa.selenium.WebDriver

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
        driver = WebDriverManager.chromedriver().create()
        driver!!.manage().window().maximize()
    }

}