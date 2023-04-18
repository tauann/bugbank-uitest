package pages

import org.openqa.selenium.By

private const val CONTAINER = "[class*='transfer__Container']"

class TransferPage : BasePage() {

    private val backButton = By.cssSelector("$CONTAINER #btnBack")
    private val accountNumberInput = By.cssSelector("$CONTAINER input[name='accountNumber']")
    private val digitInput = By.cssSelector("$CONTAINER input[name='digit']")
    private val transferValueInput = By.cssSelector("$CONTAINER input[name='transferValue']")
    private val descriptionInput = By.cssSelector("$CONTAINER input[name='description']")
    private val transferNowButton = By.cssSelector("$CONTAINER button[type='submit']")


    fun clickBack() = click(backButton)

    fun typeAccountNumber(accountNumber: String) = type(accountNumber, accountNumberInput)

    fun typeDigit(digit: String) = type(digit, digitInput)

    fun typeTransferValue(transferValue: String) = type(transferValue, transferValueInput)

    fun typeDescription(description: String) = type(description, descriptionInput)

    fun clickTransferNow() = click(transferNowButton)

}