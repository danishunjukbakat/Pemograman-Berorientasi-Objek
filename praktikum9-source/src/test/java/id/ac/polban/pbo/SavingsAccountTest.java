package id.ac.polban.pbo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SavingsAccountTest {
    private SavingsAccount savings;

    @BeforeEach
    void setUp() {
        savings = new SavingsAccount("003", "Citra", 100_000, 0.05);
    }

    @Test
    void aturanSubclass_berlakuLewatReferenceInduk() {
        BankAccount account = savings;

        assertThrows(InsufficientBalanceException.class,
                () -> account.withdraw(60_000));

        assertEquals(100_000, account.getBalance(), 0.001);
    }

    @Test
    void withdraw_tepatBatasMinimum_diterima() throws InsufficientBalanceException {
        savings.withdraw(50_000);

        assertEquals(SavingsAccount.MIN_BALANCE, savings.getBalance(), 0.001);
    }

    @Test
    void addInterest_menambahBunga() {
        savings.addInterest();

        assertEquals(105_000, savings.getBalance(), 0.001);
    }

    @Test
    void constructor_bungaNegatif_ditolak() {
        assertThrows(IllegalArgumentException.class,
                () -> new SavingsAccount("003", "Citra", 100_000, -0.01));
    }
}
