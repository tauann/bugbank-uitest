package pages

private const val CONTAINER = "[class*='styles__ContainerContent']"

class AlertPage : BasePage() {

    private val bodyText = "$CONTAINER #modalText"
    private val closeButton = "$CONTAINER #btnCloseModal"


    fun getBodyText(): String = getText(bodyText)

    fun clickClose() = click(closeButton)

}