package page

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.PageFactory

@Suppress("LeakingThis")
abstract class BasePage(driver: WebDriver) {

    init {
        PageFactory.initElements(driver, this)
    }

    fun click(element: WebElement) = element.click()

    fun type(text: String, element: WebElement) {
        element.clear()
        element.sendKeys(text)
    }

    fun getText(element: WebElement): String = element.text

}