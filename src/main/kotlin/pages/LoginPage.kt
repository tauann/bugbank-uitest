package pages

import utils.PlaywrightManager.page

private const val CARD = ".card__login"

class LoginPage : BasePage() {

    private val emailInput = "$CARD input[name='email']"
    private val passwordInput = "$CARD input[name='password']"
    private val registerButton = "$CARD .login__buttons > button[type='button']"

    fun clickRegister() = click(registerButton)

    fun doLogin(email: String, password: String) {
        type(email, emailInput)
        type(password, passwordInput)
        page!!.locator(passwordInput).press("Enter")
    }

}