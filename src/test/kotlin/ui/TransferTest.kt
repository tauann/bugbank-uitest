package ui

import constants.USER_PASSWORD
import constants.USER_TRANSFER_EMAIL
import constants.USER_TRANSFER_NAME
import org.amshove.kluent.shouldBeEqualTo
import org.amshove.kluent.shouldContain
import org.junit.jupiter.api.Test

class TransferTest : BaseTest() {

    @Test
    fun `Should validate error when transferring value from an account with no balance to a valid account`() {
        val account = registerAUser(USER_TRANSFER_EMAIL, USER_TRANSFER_NAME, USER_PASSWORD, false)

        loginAUser(false)
        home.clickTranfer()

        transfer.run {
            typeAccountNumber(account["number"]!!)
            typeDigit(account["digit"]!!)
            typeTransferValue("1000.00")
            clickTransferNow()
        }

        alert.getBodyText() shouldBeEqualTo "Você não tem saldo suficiente para essa transação"
    }

    @Test
    fun `Should validate error when transferring value from an account with balance to a invalid account`() {
        loginAUser()
        home.clickTranfer()

        transfer.run {
            typeAccountNumber("999")
            typeDigit("9")
            typeTransferValue("1000.00")
            clickTransferNow()
        }

        alert.getBodyText() shouldBeEqualTo "Conta inválida ou inexistente"
    }

    @Test
    fun `Should validate success when transferring value from an account with balance to a valid account`() {
        val transferValue = "100"
        val account = registerAUser(USER_TRANSFER_EMAIL, USER_TRANSFER_NAME, USER_PASSWORD, false)

        loginAUser()
        home.clickTranfer()

        transfer.run {
            typeAccountNumber(account["number"]!!)
            typeDigit(account["digit"]!!)
            typeTransferValue(transferValue)
            clickTransferNow()
        }

        alert.run {
            alert.getBodyText() shouldBeEqualTo "Transferencia realizada com sucesso"
            alert.clickClose()
        }

        transfer.clickBack()

        home.getBalanceText() shouldContain "900,00"
    }

}