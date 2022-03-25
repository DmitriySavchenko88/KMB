import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Util {
    public static boolean StringValid(String argument) {
        if (argument.isEmpty() || argument.isBlank()) {
            System.out.println("Your argument is empty");
            return false;
        }
        return true;
    }

    public static boolean isNumeric(String argument) {
        return argument.matches("-?\\d+(\\.\\d+)?");
    }

    public static boolean isInputEndString(String argument) {
        if (argument.equalsIgnoreCase("end")) {
            System.out.println("\nString arguments:");
            return true;
        }

        return false;
    }

    public static List<String> sortingStringList(List<String> stringInputList) {
        return stringInputList.stream()
                .sorted(Comparator.comparingInt(String::length).reversed())
                .collect(Collectors.toList());
    }

    public static double calculateDouble(List<Double> doubleInputList) {
        double sum = 0.0;
        for (Double f : doubleInputList) {
            sum = sum + f;
        }
        return sum;
    }
}
