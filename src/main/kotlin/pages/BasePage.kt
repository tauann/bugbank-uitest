package pages

import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import utils.DriverManager.driver
import java.time.Duration

abstract class BasePage {

    protected fun click(by: By) {
        waitVisibilityOf(by)
        driver!!.findElement(by).click()
    }

    protected fun jsClick(by: By) {
        val element = driver!!.findElement(by)
        val executor = driver as JavascriptExecutor
        executor.executeScript("arguments[0].click();", element)
    }

    protected fun type(text: String, by: By) {
        waitVisibilityOf(by)
        driver!!.findElement(by).clear()
        driver!!.findElement(by).sendKeys(text)
    }

    protected fun getText(by: By): String {
        waitVisibilityOf(by)
        return driver!!.findElement(by).text.trim()
    }

    private fun waitVisibilityOf(by: By) {
        val wait = WebDriverWait(driver, Duration.ofSeconds(10))
        wait.until(ExpectedConditions.visibilityOfElementLocated(by))
    }

}