package Practice.ATM;

import Practice.ATM.State.AtmState;
import Practice.ATM.State.IdleState;
import Practice.ATM.enums.OperationType;

public class Atm {
    private AtmSession session = null;
    private AtmState atmState = new IdleState();
    private BankingService bankingService;
    private CashDispenser cashDispenser;

    public Atm(BankingService bankingService, CashDispenser cashDispenser) {
        this.bankingService = bankingService;
        this.cashDispenser = cashDispenser;
        System.out.println("Please insert your card to getStarted!!!");
    }


    public void insertCard(Card card) {
        atmState.insertCard(card, this);
    }

    public void insertPin(String pin) {
        atmState.insertPin(pin, this);
    }

    public void selectOperation(OperationType operationType) {
        atmState.selectOperation(operationType, this);
    }

    public void enterAmount(int amount) {
        atmState.enterAmount(this, amount);
    }

    public void cancel(){
        atmState.cancel(this);
    }

    public void clear() {
        atmState.clear(this);
    }

    public AtmSession getSession() {
        return session;
    }

    public void setSession(AtmSession session) {
        this.session = session;
    }

    public AtmState getAtmState() {
        return atmState;
    }

    public void setAtmState(AtmState atmState) {
        this.atmState = atmState;
    }

    public BankingService getBankingService() {
        return bankingService;
    }

    public void setBankingService(BankingService bankingService) {
        this.bankingService = bankingService;
    }

    public CashDispenser getCashDispenser() {
        return cashDispenser;
    }

    public void setCashDispenser(CashDispenser cashDispenser) {
        this.cashDispenser = cashDispenser;
    }


    public void processWithDrawl(int amount) {
        if(this.getSession().isAuthenticated()) {
            Account accountByCardNumber = bankingService.getAccountByCardNumber(session.getCard().getCardNumber());
            if(accountByCardNumber.getBalance() >= amount) {
                if(cashDispenser.isValidAmountForDispense(amount)) {
                    cashDispenser.dispense(amount);
                    bankingService.updateBalance(session.getCard().getCardNumber(), amount);
                }
            }else {
                throw new IllegalArgumentException("Insufficient balance!!!");
            }
        }
    }


}
