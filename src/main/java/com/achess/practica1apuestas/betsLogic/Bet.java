/*
 * Welcome
 */
package com.achess.practica1apuestas.betsLogic;

/**
 *
 * @author achess
 */
public class Bet {
    private String gamblerName;
    private int amount;
    private int[] positions;
    private int points;

    public Bet(String gamblerName, int amount, int[] positions) {
        this.gamblerName = gamblerName;
        this.amount = amount;
        this.positions = positions;
        points = 0;
    }

    public String getGamblerName() {
        return gamblerName;
    }

    public int getAmount() {
        return amount;
    }

    public int[] getPositions() {
        return positions;
    }
    
    
}
