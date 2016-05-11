/**
 * 
 */
package org.dstech.fsisca;

/**
 * @author franksisca
 *
 */
public class AbstractPatternExample {
	public static void main(String[] args) {
		GUIFactory factory = GUIFactory.getFactory();
		if (factory instanceof OSXFactory) {
			System.out.println("Sono su mac");
		}
		if (factory instanceof WinFactory) {
			System.out.println("Sono su windows");

		}
	}
	// L'output sarà:
	// "Sono un WinButton: "
	// oppure:
	// "Sono un OSXButton: "
}

/*
 * GUIFactory example
 */
abstract class GUIFactory {
	public static GUIFactory getFactory() {
		String property = System.getProperty("os.name");
		if (property.toLowerCase().contains("mac")) {
			return new OSXFactory();
		} else {
			return new WinFactory();
		}
	}

	public abstract Button createButton();
}

class WinFactory extends GUIFactory {
	public Button createButton() {
		return new WinButton();
	}
}

class OSXFactory extends GUIFactory {
	public Button createButton() {
		return new OSXButton();
	}
}

abstract class Button {
	public abstract void paint();
}

class WinButton extends Button {
	public void paint() {
		System.out.println("Sono un WinButton: ");
	}
}

class OSXButton extends Button {
	public void paint() {
		System.out.println("Sono un OSXButton: ");
	}
}
