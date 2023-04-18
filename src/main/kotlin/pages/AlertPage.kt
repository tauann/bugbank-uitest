package pages

import org.openqa.selenium.By

private const val CONTAINER = "[class*='styles__Container']"

class AlertPage : BasePage() {

    private val bodyText = By.cssSelector("$CONTAINER #modalText")
    private val closeButton = By.cssSelector("$CONTAINER #btnCloseModal")


    fun getBodyText(): String = getText(bodyText)

    fun clickClose() = click(closeButton)

}