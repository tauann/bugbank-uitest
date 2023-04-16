package page

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

class LoginPage(driver: WebDriver) : BasePage(driver) {

    @FindBy(css = "input[name='email']")
    private lateinit var emailInput: WebElement

    @FindBy(css = "input[name='password']")
    private lateinit var passwordInput: WebElement

    @FindBy(css = ".login__buttons > button[type='submit']")
    private lateinit var accessButton: WebElement

    @FindBy(css = ".login__buttons > button[type='button']")
    private lateinit var registerButton: WebElement


    fun doLogin(email: String, password: String) {
        type(email, emailInput)
        type(password, passwordInput)
        click(accessButton)
    }

    fun clickRegister() = click(registerButton)

}