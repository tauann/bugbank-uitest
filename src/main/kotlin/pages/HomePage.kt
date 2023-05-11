package pages

import org.openqa.selenium.By

private const val CONTAINER = "[class*='home__Container']"

class HomePage : BasePage() {

    private val nameText = By.cssSelector("$CONTAINER #textName")
    private val accountNumberText = By.cssSelector("$CONTAINER #textAccountNumber > span")
    private val balanceText = By.cssSelector("$CONTAINER #textBalance")
    private val transferButton = By.cssSelector("$CONTAINER #btn-TRANSFERÊNCIA")

    fun getUserName(): String = getText(nameText)

    fun getAccountNumber() = getText(accountNumberText)

    fun getBalanceText() = getText(balanceText)

    fun clickTranfer() = click(transferButton)

}