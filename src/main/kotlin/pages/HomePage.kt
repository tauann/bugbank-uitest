package pages

private const val CONTAINER = "[class*='home__Container']"

class HomePage : BasePage() {

    private val nameText = "$CONTAINER #textName"
    private val accountNumberText = "$CONTAINER #textAccountNumber > span"
    private val balanceText = "$CONTAINER #textBalance"
    private val transferButton = "$CONTAINER #btn-TRANSFERÊNCIA"
    private val statementButton = "$CONTAINER #btn-EXTRATO"


    fun getUserName(): String = getText(nameText)

    fun getAccountNumber() = getText(accountNumberText)

    fun getBalanceText() = getText(balanceText)

    fun clickTranfer() = click(transferButton)

    fun clickStatement() = click(statementButton)

}