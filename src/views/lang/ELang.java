package views.lang;

public enum ELang {
	EN_US(0),
	PT_BR(1);
	
	private final int index;
	
	private ELang(int index) {
		this.index = index;
	}
	
	public int getIndex() {
		return this.index;
	}
}
