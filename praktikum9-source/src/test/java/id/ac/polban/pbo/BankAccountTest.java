package id.ac.polban.pbo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BankAccountTest {
    private BankAccount sender;
    private BankAccount receiver;

    @BeforeEach
    void setUp() {
        sender = new BankAccount("001", "Andi", 100_000);
        receiver = new BankAccount("002", "Budi", 0);
    }

    @Test
    void deposit_menambahSaldo() {
        sender.deposit(50_000);

        assertEquals(150_000, sender.getBalance(), 0.001);
    }

    @Test
    void constructor_menyimpanDataRekening() {
        assertAll("data rekening",
                () -> assertEquals("001", sender.getAccountNumber()),
                () -> assertEquals("Andi", sender.getOwner()),
                () -> assertEquals(100_000, sender.getBalance(), 0.001));
    }

    @Test
    void constructor_saldoNegatif_ditolak() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new BankAccount("001", "Andi", -1));

        assertEquals("Saldo awal tidak boleh negatif", exception.getMessage());
    }

    @Test
    void withdraw_melebihiSaldo_ditolakDanSaldoTetap() {
        InsufficientBalanceException exception = assertThrows(
                InsufficientBalanceException.class,
                () -> sender.withdraw(200_000));

        assertAll("hasil penarikan ditolak",
                () -> assertEquals("Saldo tidak mencukupi", exception.getMessage()),
                () -> assertEquals(100_000, sender.getBalance(), 0.001));
    }

    @Test
    void withdraw_valid_tidakMelempar() {
        assertDoesNotThrow(() -> sender.withdraw(30_000));

        assertEquals(70_000, sender.getBalance(), 0.001);
    }

    @ParameterizedTest(name = "setoran {0} ditolak")
    @ValueSource(doubles = {0, -1, -50_000})
    void deposit_tidakValid_ditolakTanpaMengubahSaldo(double amount) {
        assertThrows(IllegalArgumentException.class, () -> sender.deposit(amount));

        assertEquals(100_000, sender.getBalance(), 0.001);
    }

    @ParameterizedTest(name = "saldo {0} - tarik {1} = {2}")
    @CsvSource({
            "100000, 10000, 90000",
            "100000, 100000, 0",
            "50000, 25000.5, 24999.5"
    })
    void withdraw_berbagaiNilai(double initial, double amount, double expected)
            throws InsufficientBalanceException {
        BankAccount account = new BankAccount("009", "Dewi", initial);

        account.withdraw(amount);

        assertEquals(expected, account.getBalance(), 0.001);
    }

    @Test
    void transfer_targetNull_ditolakTanpaMengubahSaldo() {
        assertThrows(IllegalArgumentException.class,
                () -> sender.transfer(null, 20_000));

        assertEquals(100_000, sender.getBalance(), 0.001);
    }

    @Test
    void transfer_valid_memindahkanSaldo() throws InsufficientBalanceException {
        sender.transfer(receiver, 20_000);

        assertAll("saldo setelah transfer",
                () -> assertEquals(80_000, sender.getBalance(), 0.001),
                () -> assertEquals(20_000, receiver.getBalance(), 0.001));
    }
}
