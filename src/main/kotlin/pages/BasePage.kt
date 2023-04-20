package pages

import utils.PlaywrightManager.page

abstract class BasePage {

    protected fun click(locator: String) {
        page!!.locator(locator).click()
    }

    protected fun type(text: String, locator: String) {
        page!!.locator(locator).clear()
        page!!.locator(locator).fill(text)
    }

    protected fun getText(locator: String): String = page!!.locator(locator).textContent().trim()

    protected fun getFieldError(locator: String): String {
        val errorLocator = "//..//p"
        val chainedLocator = "$locator >> $errorLocator"
        return getText(chainedLocator)
    }

}