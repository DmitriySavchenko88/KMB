import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FirstTask {
    public static void main(String args[]) {
        List<Double> doubleInputList = new ArrayList<>();
        List<String> stringInputList = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, enter an arguments:");

        while (Util.getInstance().isInputEndString("end")){
            String argument = scanner.next();

            if (Util.getInstance().isNumeric(argument)) {
                doubleInputList.add(Double.parseDouble(argument));
                System.out.println("Input number: " + argument);
///////////////////////////////////////////////////////////////////////////
                //fixme
            } else if (!Util.getInstance().isInputEndString(argument)) {
                System.out.println("\nString arguments:");
                stringInputList.add(argument);
                System.out.println("Input String: " + argument);

                ////////////////////////////////////////////////////////////////////////
            } else {
                List<String> sortedStringList = Util.getInstance().sortingStringList(stringInputList);
                for (String str : sortedStringList) {
                    System.out.println(str);
                }
                double sum = Util.getInstance().calculateDouble(doubleInputList);
                System.out.println("\nNumber arguments sum: " + sum);

                System.out.println("\nWell done :)");
                break;
            }
        }
    }
}