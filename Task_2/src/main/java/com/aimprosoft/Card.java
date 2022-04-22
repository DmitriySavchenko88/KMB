package com.aimprosoft;

import java.util.Date;

public class Card {
    private long cardNumber;
    private String name;
    private String bank;
    private int endYear;
    private int endMonth;


    public Card(long cardNumber, String name, String bank, int endYear, int endMonth) {
        this.cardNumber = cardNumber;
        this.name = name;
        this.bank = bank;
        this.endYear = endYear;
        this.endMonth = endMonth;
    }

    public long getCardNumber() {

        return cardNumber;
    }

    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public int getEndYear() {
        return endYear;
    }

    public void setEndYear(int endYear) {
        this.endYear = endYear;
    }

    public int getEndMonth() {
        return endMonth;
    }

    public void setEndMonth(int endMonth) {
        this.endMonth = endMonth;
    }

    @Override
    public String toString() {
        return "Card{" +
                "num= " + cardNumber + ", name= " + name +
                ", bank= " + bank + ", endYear= " + endYear + ", endMonth= " + endMonth +
                '}';
    }
}