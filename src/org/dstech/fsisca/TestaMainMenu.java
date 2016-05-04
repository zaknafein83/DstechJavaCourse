/**
 * Dear Maintainer:
 * 
 * When I wrote this code, only I and God knew what it was.
 * Now, only God knows!!!
 * 
 * So, if you are done trying to "optimeze" this routine (and failed), 
 * please increment the following counter as a warning to the next guy:
 * 
 * total_hours_wasted_here: 10
 * 
 */
package org.dstech.fsisca;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author franksisca
 *
 */
public class TestaMainMenu {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (true)
			try {
				showMenu();
				int nextInt = Integer.parseInt(scanner.next());
				while (nextInt != 9) {
					showMenu();
					nextInt = scanner.nextInt();
				}
			} catch (InputMismatchException exp) {
				System.out.println("Only int");

			}catch (NumberFormatException exp) {
				System.out.println("Only int");

			}
	}

	/**
	 * 
	 */
	private static void showMenu() {
		// TODO Auto-generated method stub
		System.out.println("1 - fai qualcosa");
		System.out.println("9 - Esci");
	}

}
