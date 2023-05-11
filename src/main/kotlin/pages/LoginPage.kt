package pages

import org.openqa.selenium.By

private const val CARD = ".card__login"

class LoginPage : BasePage() {

    private val emailInput = By.cssSelector("$CARD input[name='email']")
    private val passwordInput = By.cssSelector("$CARD input[name='password']")
    private val accessButton = By.cssSelector("$CARD .login__buttons > button[type='submit']")
    private val registerButton = By.cssSelector("$CARD .login__buttons > button[type='button']")

    fun clickRegister() = click(registerButton)

    fun doLogin(email: String, password: String) {
        type(email, emailInput)
        type(password, passwordInput)
        click(accessButton)
    }

}