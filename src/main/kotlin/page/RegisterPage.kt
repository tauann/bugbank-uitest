package page

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

class RegisterPage(driver: WebDriver) : BasePage(driver) {

    @FindBy(css = "#btnBackButton")
    private lateinit var backToLoginLink: WebElement

    @FindBy(css = "input[name='email']")
    private lateinit var emailInput: WebElement

    @FindBy(css = "input[name='name']")
    private lateinit var nameInput: WebElement

    @FindBy(css = "input[name='password']")
    private lateinit var passwordInput: WebElement

    @FindBy(css = "input[name='passwordConfirmation']")
    private lateinit var passwordConfirmationButton: WebElement

    @FindBy(css = "#toggleAddBalance")
    private lateinit var createAccountWithBalanceToggle: WebElement

    @FindBy(css = "button[type='submit']")
    private lateinit var registerButton: WebElement


    fun clickBackToLogin() {
        click(backToLoginLink)
    }

    fun register(
        email: String = "",
        name: String = "",
        password: String = "",
        passwordConfirmation: String = "",
        createAccountWithBalance: Boolean = true
    ) {
        type(email, emailInput)
        type(name, nameInput)
        type(password, passwordInput)
        type(passwordConfirmation, passwordConfirmationButton)
        if (createAccountWithBalance)
            click(createAccountWithBalanceToggle)
        click(registerButton)
    }

}