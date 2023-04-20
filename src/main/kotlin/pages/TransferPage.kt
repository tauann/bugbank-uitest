package pages

private const val CONTAINER = "[class*='transfer__Container']"

class TransferPage : BasePage() {

    private val backButton = "$CONTAINER #btnBack"
    private val accountNumberInput = "$CONTAINER input[name='accountNumber']"
    private val digitInput = "$CONTAINER input[name='digit']"
    private val transferValueInput = "$CONTAINER input[name='transferValue']"
    private val descriptionInput = "$CONTAINER input[name='description']"
    private val transferNowButton = "$CONTAINER button[type='submit']"


    fun clickBack() = click(backButton)

    fun typeAccountNumber(accountNumber: String) = type(accountNumber, accountNumberInput)

    fun typeDigit(digit: String) = type(digit, digitInput)

    fun typeTransferValue(transferValue: String) = type(transferValue, transferValueInput)

    fun typeDescription(description: String) = type(description, descriptionInput)

    fun clickTransferNow() = click(transferNowButton)

}