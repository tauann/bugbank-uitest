package pages

private const val CARD = ".card__register"

class RegisterUserPage : BasePage() {

    private val emailInput = "$CARD input[name='email']"
    private val nameInput = "$CARD input[name='name']"
    private val passwordInput = "$CARD input[name='password']"
    private val passwordConfirmationInput = "$CARD input[name='passwordConfirmation']"
    private val createAccountWithBalanceToggle = "$CARD #toggleAddBalance"
    private val registerButton = "$CARD button[type='submit']"


    fun typeEmail(email: String) = type(email, emailInput)

    fun typeName(name: String) = type(name, nameInput)

    fun typePassword(password: String) = type(password, passwordInput)

    fun typePasswordConfirmation(passwordConfirmation: String) = type(passwordConfirmation, passwordConfirmationInput)

    fun checkCreateAccountWithBalance() = click(createAccountWithBalanceToggle)

    fun clickRegister() = click(registerButton)

    fun getErrorEmail() = getFieldError(emailInput)

    fun getErrorPassword() = getFieldError(passwordInput)

    fun getErrorPasswordConfirmation() = getFieldError(passwordConfirmationInput)

}