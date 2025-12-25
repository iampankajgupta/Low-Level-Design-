package Practice.TextEditorSpell;

public class HindiLangSpellCheck implements SpellLangStrategy{
    @Override
    public boolean check(String text) {
        System.out.println("Checking Hindi Spell Check");
        return true;
    }
}
