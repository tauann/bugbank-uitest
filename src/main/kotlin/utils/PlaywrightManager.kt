package utils

import com.microsoft.playwright.BrowserType.LaunchOptions
import com.microsoft.playwright.Page
import com.microsoft.playwright.Playwright

object PlaywrightManager {

    var page: Page? = null
        get() {
            if (field == null) setupPW()
            return field
        }
        private set

    fun closePage() {
        page?.close()
        page = null
    }

    private fun setupPW() {
        val pw = Playwright.create().chromium()
        val browser = pw.launch(chromiumOptions())
        val context = browser.newContext()
        page = context.newPage()
    }

    private fun chromiumOptions(): LaunchOptions = LaunchOptions().setHeadless(BROWSER_HEADLESS)
}