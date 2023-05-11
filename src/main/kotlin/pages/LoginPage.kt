package pages

import org.openqa.selenium.By
import org.openqa.selenium.Keys
import utils.DriverManager.driver

private const val CARD = ".card__login"

class LoginPage : BasePage() {

    private val emailInput = By.cssSelector("$CARD input[name='email']")
    private val passwordInput = By.cssSelector("$CARD input[name='password']")
    private val registerButton = By.cssSelector("$CARD .login__buttons > button[type='button']")

    fun clickRegister() = click(registerButton)

    fun doLogin(email: String, password: String) {
        type(email, emailInput)
        type(password, passwordInput)
        driver!!.findElement(passwordInput).sendKeys(Keys.ENTER)
    }

}