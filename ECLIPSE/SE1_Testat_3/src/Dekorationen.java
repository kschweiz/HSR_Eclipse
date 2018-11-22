
public abstract class Dekorationen extends Hut {
	private Hut wrappedHat;

	public Dekorationen(Hut hatToBeDecorated) {
		this.wrappedHat = hatToBeDecorated;
	}

	public Hut getHut() {
		return wrappedHat;
	}

}
