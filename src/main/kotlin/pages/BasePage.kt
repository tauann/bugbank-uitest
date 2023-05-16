package pages

import com.microsoft.playwright.Locator
import com.microsoft.playwright.options.WaitForSelectorState
import utils.PlaywrightManager.page

abstract class BasePage {

    protected fun click(locatorString: String) = page!!.locator(locatorString).click()

    protected fun type(text: String, locatorString: String) {
        page!!.locator(locatorString).clear()
        page!!.locator(locatorString).fill(text)
    }

    protected fun getText(locatorString: String) = page!!.locator(locatorString).textContent().trim()

    protected fun waitVisibilityOf(locatorString: String) =
        page!!.locator(locatorString).waitFor(Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE))

}