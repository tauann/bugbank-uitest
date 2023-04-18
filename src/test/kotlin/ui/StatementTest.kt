package ui

import constants.USER_PASSWORD
import constants.USER_TRANSFER_EMAIL
import constants.USER_TRANSFER_NAME
import org.amshove.kluent.shouldContain
import org.amshove.kluent.shouldNotContain
import org.junit.jupiter.api.Test

class StatementTest : BaseTest() {

    @Test
    fun `Should validate that the statement doesn't display a debit entry after a failed transfer`() {
        val description = "invalid transfer"

        makeATransfer("999", "9", "1000", description)

        statement.getTransferDescriptions() shouldNotContain description
    }

    @Test
    fun `Should validate that the statement displays a debit entry after a successfull transfer`() {
        val description = "valid transfer"
        val account = registerAUser(USER_TRANSFER_EMAIL, USER_TRANSFER_NAME, USER_PASSWORD, false)

        makeATransfer(account["number"]!!, account["digit"]!!, "100", description)

        statement.getTransferDescriptions() shouldContain description
    }

    private fun makeATransfer(
        accountNumber: String,
        accountDigit: String,
        transferValue: String,
        description: String,
    ) {
        loginAUser()
        home.clickTranfer()

        transfer.run {
            typeAccountNumber(accountNumber)
            typeDigit(accountDigit)
            typeTransferValue(transferValue)
            typeDescription(description)
            clickTransferNow()
        }

        alert.clickClose()
        transfer.clickBack()
        home.clickStatement()
    }

}