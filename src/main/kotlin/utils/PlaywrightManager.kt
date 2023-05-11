package utils

import com.microsoft.playwright.BrowserType.LaunchOptions
import com.microsoft.playwright.Page
import com.microsoft.playwright.Playwright

object PlaywrightManager {

    var page: Page? = null
        get() {
            if (field == null) setupPlaywright()
            return field
        }
        private set

    fun closePage() {
        page?.close()
        page = null
    }

    private fun setupPlaywright() {
        val pw = Playwright.create().chromium()
        val browser = pw.launch(chromiumOptions())
        val context = browser.newContext()
        page = context.newPage()
    }

    private fun chromiumOptions() = LaunchOptions().setHeadless(true)

}