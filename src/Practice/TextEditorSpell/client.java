package Practice.TextEditorSpell;

public class client {
    public static void main(String[] args) {
        // Text Editor Spell Check
        // 1. TextEditor
        // 2. SpellLanguageStrategy
        // 3. HindiSpell

        TextEditor textEditor=new TextEditor(new EnglishLanSpellCheck());
        textEditor.check("ABC");
        textEditor.setSpellLangStrategy(new HindiLangSpellCheck());
        textEditor.check("BCA");


    }
}
