package page

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

class TransferPage(driver: WebDriver) : BasePage(driver) {

    @FindBy(css = "input[name=’accountNumber’]")
    private lateinit var accountNumberInput: WebElement

    @FindBy(css = "input[name=’digit’]")
    private lateinit var digitInput: WebElement

    @FindBy(css = "input[name=’transferValue’]")
    private lateinit var transferValueInput: WebElement

    @FindBy(css = "input[name=’description’]")
    private lateinit var descriptionInput: WebElement

    @FindBy(css = "button[type=’submit’]")
    private lateinit var transferNowButton: WebElement


    fun transfer(accountNumber: String, digit: String, transferValue: String, description: String) {
        type(accountNumber, accountNumberInput)
        type(digit, digitInput)
        type(transferValue, transferValueInput)
        type(description, descriptionInput)
        click(transferNowButton)
    }

}