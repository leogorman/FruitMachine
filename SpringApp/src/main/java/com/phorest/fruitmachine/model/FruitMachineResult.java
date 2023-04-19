package com.phorest.fruitmachine.model;

import java.util.List;

public class FruitMachineResult {

    public enum Color {
        BLACK,
        WHITE,
        GREEN,
        YELLOW;
    }

    private boolean winner;
    private List<Color> colors;
    private int balance;

    public FruitMachineResult(boolean winner, List<Color> colors, int balance) {
        this.winner = winner;
        this.colors = colors;
        this.balance = balance;
    }

    public boolean isWinner() {
        return winner;
    }

    public void setWinner(boolean winner) {
        this.winner = winner;
    }

    public List<Color> getColors() {
        return colors;
    }

    public void setColors(List<Color> colors) {
        this.colors = colors;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}

