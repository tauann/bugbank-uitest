package ui

import constants.*
import org.amshove.kluent.shouldBeEqualTo
import org.amshove.kluent.shouldMatch
import org.junit.jupiter.api.Test

class RegisterUserTest : BaseTest() {

    @Test
    fun `Should Validate Success When Creating A User`() {
        login.clickRegister()

        register.run {
            clickRegister()
            getErrorEmail() shouldBeEqualTo REQUIRED_FIELD_ERROR
            getErrorPassword() shouldBeEqualTo REQUIRED_FIELD_ERROR
            getErrorPasswordConfirmation() shouldBeEqualTo REQUIRED_FIELD_ERROR

            typeEmail(USER_LOGIN_EMAIL)
            clickRegister()
            getErrorPassword() shouldBeEqualTo REQUIRED_FIELD_ERROR
            getErrorPasswordConfirmation() shouldBeEqualTo REQUIRED_FIELD_ERROR

            typePassword(USER_PASSWORD)
            clickRegister()
            getErrorPasswordConfirmation() shouldBeEqualTo REQUIRED_FIELD_ERROR

            typePasswordConfirmation(USER_PASSWORD)
            clickRegister()
        }

        alert.run {
            getBodyText() shouldBeEqualTo "Nome não pode ser vazio."
            clickClose()
        }

        register.run {
            typeName(USER_LOGIN_NAME)
            clickRegister()
        }

        alert.getBodyText() shouldMatch "A conta $ACCOUNT_PATTERN foi criada com sucesso"
    }

}

