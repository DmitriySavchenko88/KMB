package com.aimprosoft;

import java.util.List;

public final class Util {

    private Util() {}

    public static boolean isNumeric(String argument) {

        return argument.matches("-?\\d+(\\.\\d+)?");
    }

    public static double calculateDouble(List<Double> doubleInputList) {
        return doubleInputList.stream().mapToDouble(f -> f).sum();
    }
}