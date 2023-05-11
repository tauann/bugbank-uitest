package pages

import org.openqa.selenium.By

private const val CARD = ".card__register"

class RegisterPage : BasePage() {

    private val emailInput = By.cssSelector("$CARD input[name='email']")
    private val nameInput = By.cssSelector("$CARD input[name='name']")
    private val passwordInput = By.cssSelector("$CARD input[name='password']")
    private val passwordConfirmationInput = By.cssSelector("$CARD input[name='passwordConfirmation']")
    private val createAccountWithBalanceToggle = By.cssSelector("$CARD #toggleAddBalance")
    private val registerButton = By.cssSelector("$CARD button[type='submit']")

    fun register(email: String, name: String, password: String, withBalance: Boolean = true) {
        type(email, emailInput)
        type(name, nameInput)
        type(password, passwordInput)
        type(password, passwordConfirmationInput)
        if (withBalance) click(createAccountWithBalanceToggle, false)
        click(registerButton)
    }

}