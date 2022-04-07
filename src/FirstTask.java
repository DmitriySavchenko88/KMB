import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class FirstTask {
    public static void main(String[] args) {
        List<Double> doubleInputList = new ArrayList<>();
        List<String> stringInputList = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, enter an arguments:");

        Util util = Util.getInstance();
        String argument;
        while (!(argument = scanner.next()).equalsIgnoreCase("end")){

            if (util.isNumeric(argument)) {
                doubleInputList.add(Double.parseDouble(argument));
                System.out.println("Input number: " + argument);

            } else {
                stringInputList.add(argument);
                System.out.println("Input String: " + argument);
            }
        }
        stringInputList.sort(Comparator.comparingInt(String::length).reversed());
        for (String str : stringInputList) {
            System.out.println(str);
        }
        double sum = util.calculateDouble(doubleInputList);
        System.out.println("\nNumber arguments sum: " + sum);

        System.out.println("\nWell done :)");
    }
}