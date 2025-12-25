package Practice.TextEditorSpell;

public class EnglishLanSpellCheck implements SpellLangStrategy{
    @Override
    public boolean check(String text) {
        System.out.println("Checking English Spell Check");
        return true;
    }
}
