package Practice.ATM.enums;

public enum Note {
    HUNDRED(100), TWO_HUNDRED(200), FIVE_HUNDRED(500), TWO_THOUSAND(2000)

    private int noteValue;

    Note(int note) {
        this.noteValue = note;
    }

    public static int getNoteValue(Note notes) {
        return notes.noteValue;
    }
}
