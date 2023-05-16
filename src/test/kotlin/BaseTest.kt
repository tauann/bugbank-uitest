import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import pages.*
import utils.DriverManager.closeDriver
import utils.DriverManager.driver

abstract class BaseTest {

    protected lateinit var loginPage: LoginPage
    protected lateinit var alertPage: AlertPage
    protected lateinit var homePage: HomePage
    protected lateinit var transferPage: TransferPage
    private lateinit var registerPage: RegisterPage

    @BeforeEach
    fun setup() {
        driver?.navigate()?.to("https://bugbank.netlify.app/")
        loginPage = LoginPage()
        alertPage = AlertPage()
        homePage = HomePage()
        transferPage = TransferPage()
        registerPage = RegisterPage()
    }

    @AfterEach
    fun tearDown() {
        closeDriver()
    }

    protected fun registerUser(
        email: String,
        name: String,
        password: String,
        withBalance: Boolean = true,
    ): Map<String, String> {
        loginPage.clickRegister()
        registerPage.register(email, name, password, withBalance)

        val alertText: String = alertPage.getAlertText()
        return mapAccount(alertText)
    }

    private fun mapAccount(alertText: String): Map<String, String> {
        val pattern = "\\d+-\\d"
        val account = Regex(pattern).find(alertText)!!.value
        return mapOf(
            "account" to account,
            "number" to account.substringBeforeLast("-"),
            "digit" to account.substringAfterLast("-")
        )
    }

}