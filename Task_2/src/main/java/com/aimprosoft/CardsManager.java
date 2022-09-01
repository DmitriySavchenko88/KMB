package com.aimprosoft;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class CardsManager {

    public static void main(String[] args) throws IOException {
        List<Card> list = new ArrayList<>();

        populateTestData(list);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        boolean isContinue = true;

        while (isContinue) {

            System.out.println("Enter command: ");
            String command = reader.readLine();
            switch (command) {
                case "printCards": {
                    for (Card card : list) {
                        System.out.println(card);
                    }
                    break;
                }
                case "addNewCard": {
                    long cardNumber = Long.parseLong(reader.readLine());
                    if (list.stream().noneMatch(card -> card.getCardNumber() == cardNumber)) {
                        String name = reader.readLine();
                        String bank = reader.readLine();
                        int endYear = Integer.parseInt(reader.readLine());
                        int endMonth = Integer.parseInt(reader.readLine());

                        Card card = new Card(cardNumber, name, bank, endYear, endMonth);


                        list.add(card);

                        System.out.println("New card added: " + card);
                    } else {
                        System.out.println("Card with this number exists");
                    }
                    break;
                }
                case "search": {
                    String nameBank = reader.readLine();

                    list.stream()
                            .filter(card -> nameBank.equals(card.getBank()))
                            .forEach(card -> System.out.println(card));
                    break;
                }
                case "EXIT": {
                    isContinue = false;
                    break;
                }
            }
        }
    }


    private static void populateTestData(List<Card> list) {
        Card cardOne = new Card(1234123412341234L, "Vasil", "Privat", 12, 2023);

        Card cardTwo = new Card(1234123412341235L, "Masha", "Privat", 3, 2025);

        Card cardThree = new Card(1234123412341236L, "Natasha", "UkrSib", 7, 2028);

        list.add(cardOne);
        list.add(cardTwo);
        list.add(cardThree);
    }
}
