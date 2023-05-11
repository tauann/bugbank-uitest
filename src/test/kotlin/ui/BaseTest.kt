package ui

import constants.ACCOUNT_PATTERN
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import pages.*
import utils.DriverManager.closeDriver
import utils.DriverManager.driver

abstract class BaseTest {

    protected lateinit var loginPage: LoginPage
    protected lateinit var alertPage: AlertPage
    protected lateinit var homePage: HomePage
    protected lateinit var transferPage: TransferPage

    @BeforeEach
    fun setupPages() {
        loginPage = LoginPage()
        alertPage = AlertPage()
        homePage = HomePage()
        transferPage = TransferPage()
    }

    protected fun registerUser(
        email: String,
        name: String,
        password: String,
        withBalance: Boolean = true,
    ): Map<String, String> {
        loginPage.clickRegister()
        RegisterPage().register(email, name, password, withBalance)
        val alertText: String = alertPage.getAlertText()
        return mapAccount(alertText)
    }

    private fun mapAccount(alertText: String): Map<String, String> {
        val account = Regex(ACCOUNT_PATTERN).find(alertText)!!.value
        return mapOf(
            "account" to account,
            "number" to account.substringBeforeLast("-"),
            "digit" to account.substringAfterLast("-")
        )
    }

    companion object {
        @JvmStatic
        @BeforeAll
        fun setUp() {
            driver?.navigate()?.to("https://bugbank.netlify.app/")
        }

        @JvmStatic
        @AfterAll
        fun tearDown() {
            closeDriver()
        }
    }

}