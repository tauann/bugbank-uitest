package pages

import org.openqa.selenium.By

private const val CONTAINER = "[class*='transfer__Container']"

class TransferPage : BasePage() {

    private val backButton = By.cssSelector("$CONTAINER #btnBack")
    private val accountNumberInput = By.cssSelector("$CONTAINER input[name='accountNumber']")
    private val digitInput = By.cssSelector("$CONTAINER input[name='digit']")
    private val transferAmountInput = By.cssSelector("$CONTAINER input[name='transferValue']")
    private val descriptionInput = By.cssSelector("$CONTAINER input[name='description']")
    private val transferNowButton = By.cssSelector("$CONTAINER button[type='submit']")

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