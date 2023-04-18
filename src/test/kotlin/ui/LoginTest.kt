package ui

import constants.REQUIRED_FIELD_ERROR
import constants.USER_LOGIN_EMAIL
import constants.USER_LOGIN_NAME
import constants.USER_PASSWORD
import org.amshove.kluent.shouldBeEqualTo
import org.amshove.kluent.shouldContain
import org.junit.jupiter.api.Test

class LoginTest : BaseTest() {

    @Test
    fun `Should validate error when logging in with an non-existing user`() {
        login.run {
            typeEmail("invalid@invalid.com")
            typePassword("invalid")
            clickAccess()
        }

        alert.getBodyText() shouldBeEqualTo "Usuário ou senha inválido.\nTente novamente ou verifique suas informações!"
    }

    @Test
    fun `Should validate success when logging in with an existing user`() {
        val account = registerAUser(USER_LOGIN_EMAIL, USER_LOGIN_NAME, USER_PASSWORD)["account"]

        login.run {
            clickAccess()
            getErrorEmail() shouldBeEqualTo REQUIRED_FIELD_ERROR
            getErrorPassword() shouldBeEqualTo REQUIRED_FIELD_ERROR

            typeEmail(USER_LOGIN_EMAIL)
            clickAccess()
            getErrorPassword() shouldBeEqualTo REQUIRED_FIELD_ERROR

            typePassword(USER_PASSWORD)
            clickAccess()
        }

        home.run {
            getUserName() shouldContain USER_LOGIN_NAME
            getAccountNumber() shouldBeEqualTo account
        }
    }

}