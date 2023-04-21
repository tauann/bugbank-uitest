package pages

import utils.PlaywrightManager.page

abstract class BasePage {

    protected fun click(locatorString: String) {
        page!!.locator(locatorString).click()
    }

    protected fun type(text: String, locatorString: String) {
        page!!.locator(locatorString).clear()
        page!!.locator(locatorString).fill(text)
    }

    protected fun getText(locatorString: String): String = page!!.locator(locatorString).textContent().trim()

    protected fun getFieldError(locatorString: String): String {
        val errorLocator = "//..//p"
        val chainedLocator = "$locatorString >> $errorLocator"
        return getText(chainedLocator)
    }

}