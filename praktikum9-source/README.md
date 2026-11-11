# Praktikum 9 - Unit Testing dengan JUnit 5

Project Maven untuk Praktikum I-V pada Modul Praktikum PBO 9.

## Menjalankan

Gunakan JDK 17 atau lebih baru dan Maven, lalu jalankan dari folder ini:

```text
mvn test
```

## Isi

- `BankAccount` dan `InsufficientBalanceException` untuk deposit, withdraw, dan transfer.
- `SavingsAccount` untuk saldo minimum dan bunga.
- `BankAccountTest` untuk AAA, `assertAll`, exception, integritas saldo, `@BeforeEach`, `@ValueSource`, `@CsvSource`, dan mini TDD.
- `SavingsAccountTest` untuk batas saldo minimum dan polymorphism melalui reference `BankAccount`.

JUnit 5.11.4 dipakai sebagai dependency test, sesuai modul.
