package pages

import org.openqa.selenium.By
import org.openqa.selenium.support.pagefactory.ByChained
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import utils.DriverManager.getDriver
import java.time.Duration

abstract class BasePage {

    private val wait = WebDriverWait(getDriver(), Duration.ofSeconds(10))


    protected fun click(by: By, wait: Boolean = true) {
        if (wait) waitVisibilityOf(by)
        getDriver().findElement(by).click()
    }

    protected fun type(text: String, by: By) {
        waitVisibilityOf(by)
        getDriver().findElement(by).clear()
        getDriver().findElement(by).sendKeys(text)
    }

    protected fun getText(by: By): String {
        waitVisibilityOf(by)
        return getDriver().findElement(by).text
    }

    protected fun getFieldError(by: By): String {
        val errorBy = By.xpath("./..//p")
        val chainedBy = ByChained(by, errorBy)
        waitVisibilityOf(chainedBy)
        return getText(chainedBy)
    }

    protected fun waitVisibilityOf(by: By) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(by))
    }

}