package pages

import utils.PlaywrightManager.page

private const val CARD = ".card__login"

class LoginPage : BasePage() {

    private val emailInput = "$CARD input[name='email']"
    private val passwordInput = "$CARD input[name='password']"
    private val registerButton = "$CARD .login__buttons > button[type='button']"


    fun typeEmail(email: String) = type(email, emailInput)

    fun typePassword(password: String) = type(password, passwordInput)

    fun submit() = page!!.locator(passwordInput).press("Enter")

    fun clickRegister() = click(registerButton)

    fun getErrorEmail() = getFieldError(emailInput)

    fun getErrorPassword() = getFieldError(passwordInput)
}