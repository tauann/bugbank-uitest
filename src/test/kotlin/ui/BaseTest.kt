package ui

import constants.ACCOUNT_PATTERN
import constants.USER_LOGIN_EMAIL
import constants.USER_LOGIN_NAME
import constants.USER_PASSWORD
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import pages.*
import utils.DriverManager.closeDriver
import utils.DriverManager.driver

abstract class BaseTest {

    protected lateinit var login: LoginPage
    protected lateinit var register: RegisterUserPage
    protected lateinit var alert: AlertPage
    protected lateinit var home: HomePage
    protected lateinit var transfer: TransferPage
    protected lateinit var statement: StatementPage

    @BeforeEach
    fun setUp() {
        driver?.navigate()?.to("https://bugbank.netlify.app/")

        login = LoginPage()
        register = RegisterUserPage()
        alert = AlertPage()
        home = HomePage()
        transfer = TransferPage()
        statement = StatementPage()
    }

    @AfterEach
    fun tearDown() {
        closeDriver()
    }

    protected fun registerAUser(
        email: String,
        name: String,
        password: String,
        withBalance: Boolean = true,
    ): Map<String, String> {
        val bodyText: String
        var account: String

        login.clickRegister()

        register.run {
            typeEmail(email)
            typeName(name)
            typePassword(password)
            typePasswordConfirmation(password)
            if (withBalance) checkCreateAccountWithBalance()
            clickRegister()
        }

        alert.run {
            bodyText = getBodyText()
            account = Regex(ACCOUNT_PATTERN).find(bodyText)!!.value
            clickClose()
        }

        return mapOf(
            "account" to account,
            "number" to account.substringBeforeLast("-"),
            "digit" to account.substringAfterLast("-")
        )
    }

    protected fun loginAUser(withBalance: Boolean = true) {
        registerAUser(USER_LOGIN_EMAIL, USER_LOGIN_NAME, USER_PASSWORD, withBalance)

        login.run {
            typeEmail(USER_LOGIN_EMAIL)
            typePassword(USER_PASSWORD)
            submit()
        }
    }

}