package pages

private const val CONTAINER = "[class*='transfer__Container']"

class TransferPage : BasePage() {

    private val backButton = "$CONTAINER #btnBack"
    private val accountNumberInput = "$CONTAINER input[name='accountNumber']"
    private val digitInput = "$CONTAINER input[name='digit']"
    private val transferAmountInput = "$CONTAINER input[name='transferValue']"
    private val descriptionInput = "$CONTAINER input[name='description']"
    private val transferNowButton = "$CONTAINER button[type='submit']"

    fun clickBack() = click(backButton)

    fun makeTransfer(
        destinationAccountNumber: String,
        destinationAccountDigit: String,
        transferAmount: String,
        description: String = "",
    ) {
        type(destinationAccountNumber, accountNumberInput)
        type(destinationAccountDigit, digitInput)
        type(transferAmount, transferAmountInput)
        type(description, descriptionInput)
        click(transferNowButton)
    }

}