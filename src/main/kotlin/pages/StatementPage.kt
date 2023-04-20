package pages

import utils.PlaywrightManager.page

class StatementPage : BasePage() {

    private val transferDescriptionText = "[class*='bank-statement__Container'] #textDescription"


    fun getTransferDescriptions(): MutableList<String> {
        page!!.locator(transferDescriptionText).last().waitFor()
        val locators = page!!.locator(transferDescriptionText).all()
        val descriptions = mutableListOf<String>()
        locators.mapTo(descriptions) { it.textContent() }
        return descriptions
    }

}