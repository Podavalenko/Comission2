
import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun count_of_commission_right() {
        val cardType = VISA
        val monthAmount: Long = 1000
        val sumOfTransaction: Long = 100

        val result = commissionCount(
            card_type = cardType,
            previousAmountMonthly = monthAmount,
            transactionAmount = sumOfTransaction
        )

        assertEquals("Комиссия составляет 35 руб.", result)
    }

    @Test
    fun count_of_commission_right_VK_PAY() {
        val cardType = VK_PAY
        val monthAmount: Long = 80000
        val sumOfTransaction: Long = 800

        val result = commissionCount(
            card_type = cardType,
            previousAmountMonthly = monthAmount,
            transactionAmount = sumOfTransaction
        )

        assertEquals("Комиссия составляет 0 коп.", result)
    }

    @Test
    fun count_of_commission_right_MAESTRO() {
        val cardType = MAESTRO
        val monthAmount: Long = 50000
        val sumOfTransaction: Long = 8000000

        val result = commissionCount(
            card_type = cardType,
            previousAmountMonthly = monthAmount,
            transactionAmount = sumOfTransaction
        )

        assertEquals("Комиссия составляет 50000 коп.", result)
    }

    @Test
    fun count_of_commission_right_MASTERCARD() {
        val cardType = MASTERCARD
        val monthAmount: Long = 50000
        val sumOfTransaction: Long = 8000000

        val result = commissionCount(
            card_type = cardType,
            previousAmountMonthly = monthAmount,
            transactionAmount = sumOfTransaction
        )

        assertEquals("Комиссия составляет 50000 коп.", result)
    }

    @Test
    fun count_of_commission_right_MIR() {
        val cardType = MIR
        val monthAmount: Long = 1000
        val sumOfTransaction: Long = 100

        val result = commissionCount(
            card_type = cardType,
            previousAmountMonthly = monthAmount,
            transactionAmount = sumOfTransaction
        )

        assertEquals("Комиссия составляет 35 руб.", result)
    }


    @Test
    fun VK_PAY_Commission() {
        val monthAmount: Long = 1000
        val sumOfTransaction: Long = 100

        val result = commissionVkPay(
            transactionAmount = sumOfTransaction,
            previousAmountMonthly = monthAmount
        )
        assertEquals("Комиссия составляет 0 коп.", result)
    }

    @Test
    fun VK_PAY_Commission_0() {
        val sumOfTransaction: Long = 2000666

        val result = commissionCount(
            transactionAmount = sumOfTransaction
        )
        assertEquals("Превышена максимальная сумма перевода!", result)
    }

    @Test
    fun VK_PAY_Commission_Too_Much() {
        val cardType = VK_PAY
        val monthAmount: Long = 4_000_000
        val sumOfTransaction: Long = 500

        val result = commissionCount(
            card_type = cardType,
            monthAmount,
            transactionAmount = sumOfTransaction
        )
        assertEquals("Превышено количество переводов!", result)
    }

    @Test
    fun MaestroMasterCard_Commission() {
        val monthAmount: Long = 200
        val sumOfTransaction: Long = 20000

        val result = commissionCountMaestroMastercard(
            transactionAmount = sumOfTransaction,
            previousAmountMonthly = monthAmount
        )
        assertEquals("Комиссия составляет 2120 коп.", result)
    }

    @Test
    fun MaestroMasterCard_Commission_0() {
        val monthAmount: Long = 200
        val sumOfTransaction: Long = 35000

        val result = commissionCountMaestroMastercard(
            transactionAmount = sumOfTransaction,
            previousAmountMonthly = monthAmount
        )
        assertEquals("Комиссия составляет 0 коп.", result)
    }

    @Test
    fun MaestroMasterCard_Commission_Too_Much_For_Month() {
        val monthAmount: Long = 70_000_000
        val sumOfTransaction: Long = 3000

        val result = commissionCountMaestroMastercard(
            transactionAmount = sumOfTransaction,
            previousAmountMonthly = monthAmount
        )
        assertEquals("Превышено количество переводов!", result)
    }

    @Test
    fun MaestroMasterCard_Commission_Too_Much_For_Day() {
        val monthAmount: Long = 500
        val sumOfTransaction: Long = 25_000_000

        val result = commissionCountMaestroMastercard(
            transactionAmount = sumOfTransaction,
            previousAmountMonthly = monthAmount
        )
        assertEquals("Превышена максимальная сумма перевода!", result)
    }

    @Test
    fun Visa_Mir_commissionCount_Too_Much_Month() {
        val monthAmount: Long = 88000000
        val sumOfTransaction: Long = 2000

        val result = commissionVisaMir(
            transactionAmount = sumOfTransaction,
            previousAmountMonthly = monthAmount
        )
        assertEquals("Превышено количество переводов!", result)
    }

    @Test
    fun Visa_Mir_commissionCount_Too_Much_Day() {
        val monthAmount: Long = 500
        val sumOfTransaction: Long = 25_000_000

        val result = commissionVisaMir(
            transactionAmount = sumOfTransaction,
            previousAmountMonthly = monthAmount
        )
        assertEquals("Превышена максимальная сумма перевода!", result)
    }

    @Test
    fun Visa_Mir_commissionCount_Count() {
        val monthAmount: Long = 5000
        val sumOfTransaction: Long = 3333333

        val result = commissionVisaMir(
            transactionAmount = sumOfTransaction,
            previousAmountMonthly = monthAmount
        )
        assertEquals("Комиссия составляет 24999 коп.", result)
    }

}