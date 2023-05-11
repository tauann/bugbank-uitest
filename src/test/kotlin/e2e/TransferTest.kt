package e2e

import BaseTest
import constants.*
import org.amshove.kluent.shouldBeEqualTo
import org.amshove.kluent.shouldContain
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class TransferTest : BaseTest() {

    private val transferAmount = "100.00"
    private lateinit var destinationAccount: Map<String, String>

    @BeforeEach
    fun preConditions() {
        destinationAccount = registerUser("transfer@account.com", "Transfer Account", PASSWORD, false)
    }

    @Test
    fun `Should validate that the user can transfer value from an account with balance to a valid account`() {
        loginUser()

        homePage.clickTranfer()
        transferPage.makeTransfer(destinationAccount["number"]!!, destinationAccount["digit"]!!, transferAmount)

        alertPage.getAlertText() shouldBeEqualTo "Transferencia realizada com sucesso"

        transferPage.clickBack()

        homePage.getBalanceText() shouldContain "900,00"
    }

    @Test
    fun `Should validate that the user cannot transfer value from an account with balance to an invalid account`() {
        loginUser()

        homePage.clickTranfer()
        transferPage.makeTransfer("999", "9", transferAmount)

        alertPage.getAlertText() shouldBeEqualTo "Conta inválida ou inexistente"
    }

    @Test
    fun `Should validate that the user cannot transfer value from an account without balance to a valid account`() {
        loginUser(false)

        homePage.clickTranfer()
        transferPage.makeTransfer(destinationAccount["number"]!!, destinationAccount["digit"]!!, transferAmount)

        alertPage.getAlertText() shouldBeEqualTo "Você não tem saldo suficiente para essa transação"
    }

    private fun loginUser(withBalance: Boolean = true) {
        registerUser(LOGIN_EMAIL, LOGIN_NAME, PASSWORD, withBalance)

        loginPage.doLogin(LOGIN_EMAIL, PASSWORD)
    }

}