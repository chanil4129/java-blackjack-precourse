package domain.view.input;

import java.util.Scanner;

public class InputManager {
    private static Scanner scanner = new Scanner(System.in);

    public static String readLine() {
        return scanner.nextLine();
    }
}
