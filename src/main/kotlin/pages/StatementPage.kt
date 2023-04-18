package pages

import org.openqa.selenium.By
import utils.DriverManager.getDriver

class StatementPage : BasePage() {

    private val transferDescriptionText = By.cssSelector("[class*='bank-statement__Container'] #textDescription")


    fun getTransferDescriptions(): MutableList<String> {
        waitVisibilityOf(transferDescriptionText)
        val elements = getDriver().findElements(transferDescriptionText)
        val descriptions = mutableListOf<String>()
        elements.mapTo(descriptions) { it.text }
        return descriptions
    }

}