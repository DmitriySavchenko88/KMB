import java.util.List;

public final class Util {
    private static Util instance;

    private Util() {}

    public boolean isNumeric(String argument) {

        return argument.matches("-?\\d+(\\.\\d+)?");
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