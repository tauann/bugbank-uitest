package pages

import org.openqa.selenium.By
import org.openqa.selenium.Keys
import utils.DriverManager.driver

private const val CARD = ".card__login"

class LoginPage : BasePage() {

    private val emailInput = By.cssSelector("$CARD input[name='email']")
    private val passwordInput = By.cssSelector("$CARD input[name='password']")
    private val registerButton = By.cssSelector("$CARD .login__buttons > button[type='button']")


    fun typeEmail(email: String) = type(email, emailInput)

    fun typePassword(password: String) = type(password, passwordInput)

    fun submit() = driver!!.findElement(passwordInput).sendKeys(Keys.ENTER)

    fun clickRegister() = click(registerButton)

    fun getErrorEmail() = getFieldError(emailInput)

    fun getErrorPassword() = getFieldError(passwordInput)
}