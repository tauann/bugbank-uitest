package pages

private const val CONTAINER = "[class*='styles__ContainerContent']"

class AlertPage : BasePage() {

    private val alertText = "$CONTAINER #modalText"
    private val closeButton = "$CONTAINER #btnCloseModal"

    fun getAlertText(): String {
        val alertText = getText(alertText)
        click(closeButton)
        return alertText
    }

}