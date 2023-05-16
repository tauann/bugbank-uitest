package pages

private const val CONTAINER = "[class*='home__Container']"

class HomePage : BasePage() {

    private val nameText = "$CONTAINER #textName"
    private val accountNumberText = "$CONTAINER #textAccountNumber > span"
    private val balanceText = "$CONTAINER #textBalance"
    private val transferButton = "$CONTAINER #btn-TRANSFERÊNCIA"

    fun getUserName(): String {
        waitForLocatorToBeVisible(nameText)
        return getText(nameText)
    }

    fun getAccountNumber(): String {
        waitForLocatorToBeVisible(accountNumberText)
        return getText(accountNumberText)
    }

    fun getBalanceText(): String {
        waitForLocatorToBeVisible(balanceText)
        return getText(balanceText)
    }

    fun clickTranfer() = click(transferButton)

}