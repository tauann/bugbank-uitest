package ui

import constants.LOGIN_EMAIL
import constants.LOGIN_NAME
import constants.PASSWORD
import org.amshove.kluent.shouldBeEqualTo
import org.amshove.kluent.shouldContain
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class LoginTest : BaseTest() {

    private lateinit var account: String

    @BeforeEach
    fun preConditions() {
        account = registerUser(LOGIN_EMAIL, LOGIN_NAME, PASSWORD)["account"]!!
    }

    @Test
    fun `Should validate that the user can login with the correct credentials`() {
        loginPage.doLogin(LOGIN_EMAIL, PASSWORD)

        homePage.getUserName() shouldContain LOGIN_NAME
        homePage.getAccountNumber() shouldBeEqualTo account
    }

    @Test
    fun `Should validate that the user cannot login with incorrect credentials`() {
        loginPage.doLogin(LOGIN_EMAIL, "INVALID")

        alertPage.getAlertText() shouldBeEqualTo "Usuário ou senha inválido.\nTente novamente ou verifique suas informações!"
    }

}