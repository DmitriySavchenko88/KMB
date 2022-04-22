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

        while (true) {
            System.out.println("Enter command: ");
            String command = reader.readLine();
            switch (command) {
                case "printCards": {
                    for (int i = 0; i < list.size(); i++) {
                        Card card = list.get(i);
                        System.out.println(card);
                    }
                    break;
                }
                case "addNewCard": {
                    long cardNumber = Long.parseLong(reader.readLine());
                    if (!isCardNumberExist(cardNumber, list)) {
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
                    for (int i = 0; i < list.size(); i++) {
                        Card card = list.get(i);
                        if (Objects.equals(nameBank, card.getBank())) {
                            System.out.println(card);

                        }

                    }
                    break;
                }

            }
        }
    }

    private static void populateTestData(List<Card> list) {
        Card card_1 = new Card(1234123412341234L, "Vasil", "Privat", 12, 2023);

        Card card_2 = new Card(1234123412341235L, "Masha", "Privat", 3, 2025);

        Card card_3 = new Card(1234123412341236L, "Natasha", "UkrSib", 7, 2028);

        list.add(card_1);
        list.add(card_2);
        list.add(card_3);
    }

    private static boolean isCardNumberExist(long cardNumber, List<Card> list) {
        boolean isExist = false;
        for (int i = 0; i < list.size(); i++) {
            Card card = list.get(i);
            if (card.getCardNumber() == cardNumber) {
                isExist = true;
                break;
            }
        }
        return isExist;
    }

}
