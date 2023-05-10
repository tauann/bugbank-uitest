package pages

import org.openqa.selenium.By
import org.openqa.selenium.ElementClickInterceptedException
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.pagefactory.ByChained
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import utils.DriverManager.driver
import utils.TIMEOUT
import java.time.Duration

abstract class BasePage {

    protected fun click(by: By, wait: Boolean = true) {
        if (wait) waitVisibilityOf(by)
        val element = driver!!.findElement(by)
        try {
            element.click()
        } catch (_: ElementClickInterceptedException) {
            jsClick(element)
        }
    }

    protected fun type(text: String, by: By) {
        waitVisibilityOf(by)
        driver!!.findElement(by).clear()
        driver!!.findElement(by).sendKeys(text)
    }

    protected fun getText(by: By): String {
        waitVisibilityOf(by)
        return driver!!.findElement(by).text
    }

    protected fun getFieldError(by: By): String {
        val errorBy = By.xpath("./..//p")
        val chainedBy = ByChained(by, errorBy)
        waitVisibilityOf(chainedBy)
        return getText(chainedBy)
    }

    protected fun waitVisibilityOf(by: By) {
        val wait = WebDriverWait(driver, Duration.ofSeconds(TIMEOUT))
        wait.until(ExpectedConditions.visibilityOfElementLocated(by))
    }

    private fun jsClick(element: WebElement) {
        val executor = driver as JavascriptExecutor
        executor.executeScript("arguments[0].click();", element)
    }

}