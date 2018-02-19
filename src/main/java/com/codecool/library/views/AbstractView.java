package com.codecool.library.views;

import java.util.Scanner;

public abstract class AbstractView {

    public void displayPressAnyKeyToContinueMessage() {
        System.out.print("\nPress any key to continue.");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

    public void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
