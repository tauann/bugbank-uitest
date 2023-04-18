package pages

import org.openqa.selenium.By

private const val CARD = ".card__register"

class RegisterUserPage : BasePage() {

    private val emailInput = By.cssSelector("$CARD input[name='email']")
    private val nameInput = By.cssSelector("$CARD input[name='name']")
    private val passwordInput = By.cssSelector("$CARD input[name='password']")
    private val passwordConfirmationInput = By.cssSelector("$CARD input[name='passwordConfirmation']")
    private val createAccountWithBalanceToggle = By.cssSelector("$CARD #toggleAddBalance")
    private val registerButton = By.cssSelector("$CARD button[type='submit']")


    fun typeEmail(email: String) = type(email, emailInput)

    fun typeName(name: String) = type(name, nameInput)

    fun typePassword(password: String) = type(password, passwordInput)

    fun typePasswordConfirmation(passwordConfirmation: String) = type(passwordConfirmation, passwordConfirmationInput)

    fun checkCreateAccountWithBalance() = click(createAccountWithBalanceToggle, false)

    fun clickRegister() = click(registerButton)

    fun getErrorEmail() = getFieldError(emailInput)

    fun getErrorPassword() = getFieldError(passwordInput)

    fun getErrorPasswordConfirmation() = getFieldError(passwordConfirmationInput)

}