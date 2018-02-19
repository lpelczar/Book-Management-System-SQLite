package com.codecool.library.views;

import java.util.List;
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

    public void displayEntries(List<Object> entries) {
        showAllEntries(entries);
        displayPressAnyKeyToContinueMessage();
    }

    public void displayEntriesNoInput(List<Object> entries) {
        showAllEntries(entries);
    }

    private void showAllEntries(List<Object> entries) {
        System.out.println("");
        if(!entries.isEmpty()) {
            int index = 1;
            for (Object entry : entries) {
                System.out.println(index + ". " + entry);
                index++;
            }
        } else {
            System.out.println("List is empty!");
        }
    }
}
