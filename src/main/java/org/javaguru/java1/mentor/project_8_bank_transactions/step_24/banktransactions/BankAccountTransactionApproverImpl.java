package org.javaguru.java1.mentor.project_8_bank_transactions.step_24.banktransactions;

class BankAccountTransactionApproverImpl implements BankAccountTransactionApprover {

    private CurrentBalanceCalculator currentBalanceCalculator;

    public BankAccountTransactionApproverImpl(CurrentBalanceCalculator currentBalanceCalculator) {
        this.currentBalanceCalculator = currentBalanceCalculator;
    }

    @Override
    public boolean approve(BankAccount bankAccount,
                           Transaction newTransaction) {
        // если транзакция это депозит, то её всегда разрешаем - пополнить банковский аккаунт можно всегда
        // если транзакция это снятие денег со счета, то:
        // return true - если у пользователя достаточно денег на балансе
        // return false - если у пользователя недостаточно денег на балансе
        // для получения текущего баланса воспользуйтесь свойством currentBalanceCalculator
        // значение которого вы получаете через конструктор

        return false;
    }

}
