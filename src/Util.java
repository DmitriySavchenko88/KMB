import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public final class Util {
    private static Util instance;

    private Util() {}

    public boolean isNumeric(String argument) {
        return argument.matches("-?\\d+(\\.\\d+)?");
    }
    public boolean isInputEndString(String argument) {
        return argument.equalsIgnoreCase("end");
    }

    public List<String> sortingStringList(List<String> stringInputList) {
        return stringInputList.stream()
                .sorted(Comparator.comparingInt(String::length).reversed())
                .collect(Collectors.toList());
    }

    public double calculateDouble(List<Double> doubleInputList) {
        return doubleInputList.stream().mapToDouble(f -> f).sum();
    }
    public static Util getInstance() {
        if (instance == null) {
            instance = new Util();
        }
        return instance;
    }
}