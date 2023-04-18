package pages

import org.openqa.selenium.By

private const val CARD = ".card__login"

class LoginPage : BasePage() {

    private val emailInput = By.cssSelector("$CARD input[name='email']")
    private val passwordInput = By.cssSelector("$CARD input[name='password']")
    private val accessButton = By.cssSelector("$CARD .login__buttons > button[type='submit']")
    private val registerButton = By.cssSelector("$CARD .login__buttons > button[type='button']")


    fun typeEmail(email: String) = type(email, emailInput)

    fun typePassword(password: String) = type(password, passwordInput)

    fun clickAccess() = click(accessButton)

    fun clickRegister() = click(registerButton)

    fun getErrorEmail() = getFieldError(emailInput)

    fun getErrorPassword() = getFieldError(passwordInput)
}