package Practice.TextEditorSpell;

public class TextEditor {
    private SpellLangStrategy spellLangStrategy;

    public TextEditor(SpellLangStrategy spellLangStrategy) {
        this.spellLangStrategy = spellLangStrategy;
    }

    public SpellLangStrategy getSpellLangStrategy() {
        return spellLangStrategy;
    }

    public void setSpellLangStrategy(SpellLangStrategy spellLangStrategy) {
        this.spellLangStrategy = spellLangStrategy;
    }

    public boolean check(String text) {
        return spellLangStrategy.check(text);
    }
}
