package pages

import org.openqa.selenium.By

private const val CONTAINER = "[class*='styles__Container']"

class AlertPage : BasePage() {

    private val alertText = By.cssSelector("$CONTAINER #modalText")
    private val closeButton = By.cssSelector("$CONTAINER #btnCloseModal")

    fun getAlertText(): String {
        val alertText = getText(alertText)
        click(closeButton)
        return alertText
    }

}