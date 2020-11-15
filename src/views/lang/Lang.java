package views.lang;

public abstract class Lang {
	
	public static ELang lang = ELang.EN_US;
	
	public static final String[] example = new String[] {
			"Example", "Exemplo"};
	public static final String[] scientificNotation = new String[] {
			"Scientific Notation", "Notação Científica"};
	
	public static String get(String[] words) {
		if (words.length != ELang.values().length)
			return null;
		return words[lang.getIndex()];
	}
}
