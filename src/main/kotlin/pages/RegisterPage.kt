package pages

private const val CARD = ".card__register"

class RegisterPage : BasePage() {

    private val emailInput = "$CARD input[name='email']"
    private val nameInput = "$CARD input[name='name']"
    private val passwordInput = "$CARD input[name='password']"
    private val passwordConfirmationInput = "$CARD input[name='passwordConfirmation']"
    private val createAccountWithBalanceToggle = "$CARD #toggleAddBalance"
    private val registerButton = "$CARD button[type='submit']"

    fun register(email: String, name: String, password: String, withBalance: Boolean = true) {
        type(email, emailInput)
        type(name, nameInput)
        type(password, passwordInput)
        type(password, passwordConfirmationInput)
        if (withBalance) click(createAccountWithBalanceToggle)
        click(registerButton)
    }

}