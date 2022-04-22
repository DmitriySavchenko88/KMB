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

                        Card card = new Card();
                        card.setCardNumber(cardNumber);
                        card.setName(name);
                        card.setBank(bank);
                        card.setEndYear(endYear);
                        card.setEndMonth(endMonth);

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
        Card card_1 = new Card();
        card_1.setCardNumber(1234123412341234L);
        card_1.setName("Vasil");
        card_1.setBank("Privat");
        card_1.setEndMonth(12);
        card_1.setEndYear(2023);
        Card card_2 = new Card();
        card_2.setCardNumber(1234123412341235L);
        card_2.setName("Masha");
        card_2.setBank("Privat");
        card_2.setEndMonth(3);
        card_2.setEndYear(2025);
        Card card_3 = new Card();
        card_3.setCardNumber(1234123412341236L);
        card_3.setName("Natasha");
        card_3.setBank("UkrSib");
        card_3.setEndMonth(7);
        card_3.setEndYear(2028);
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
