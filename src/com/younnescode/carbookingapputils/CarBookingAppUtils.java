package com.younnescode.carbookingapputils;

import java.util.Arrays;
import java.util.Objects;

public class CarBookingAppUtils {
    public static boolean isEmpty(Object[] object) {
        return Arrays.stream(object).allMatch(Objects::isNull);
    }

    public static void exit() {
        System.out.println("\uD83D\uDC4B Bye Bye \uD83D\uDE04");
        System.exit(0);
    }
}
