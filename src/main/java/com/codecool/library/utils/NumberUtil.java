package com.codecool.library.utils;

public class NumberUtil {

    public static boolean isDouble(String s) {
        try {
            Double.parseDouble(s);
        } catch(NumberFormatException | NullPointerException e) {
            return false;
        }
        return true;
    }

    public static boolean isLong(String s) {
        try {
            Long.parseLong(s);
        } catch(NumberFormatException | NullPointerException e) {
            return false;
        }
        return true;
    }

    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch(NumberFormatException | NullPointerException e) {
            return false;
        }
        return true;
    }
}
