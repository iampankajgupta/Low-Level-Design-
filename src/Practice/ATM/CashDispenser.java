package Practice.ATM;

import Practice.ATM.enums.Note;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class CashDispenser {
    private static final Map<Note, Integer> notes = new LinkedHashMap<>();

    static {
        notes.put(Note.TWO_THOUSAND, 1);
        notes.put(Note.FIVE_HUNDRED, 1);
        notes.put(Note.TWO_HUNDRED, 1);
        notes.put(Note.HUNDRED, 1);
    }
    public void dispense(int amount) {
        System.out.println("Dispensing amount: "+amount);
    }


    public boolean isValidAmountForDispense(int amount) {
        for (Map.Entry<Note, Integer> next : notes.entrySet()) {
            Note note = next.getKey();
            Integer value = next.getValue();

            if (amount < Note.getNoteValue(Note.HUNDRED)) {
                System.out.println("InValid amount please enter amount of multiple of hundered, two hundred, five hundred, five and two thousand");
                return false;
            }

            while (amount % Note.getNoteValue(note) > value) {
                amount = amount / Note.getNoteValue(note);
            }
            if (amount == 0) return true;
        }
        return false;
    }
}
