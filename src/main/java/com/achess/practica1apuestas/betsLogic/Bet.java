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
    

    public void addPoints(int points) {
        this.points += points;
    }        

    public int getPoints() {
        return points;
    }
        
    @Override
    public String toString() {
        StringBuilder csv = new StringBuilder();
        csv.append(gamblerName);
        csv.append(",");
        csv.append(amount);
        csv.append(",");
        csv.append(positions[0]);
        csv.append(",");
        csv.append(positions[1]);
        csv.append(",");
        csv.append(positions[2]);
        csv.append(",");
        csv.append(positions[3]);
        csv.append(",");
        csv.append(positions[4]);
        csv.append(",");
        csv.append(positions[5]);
        csv.append(",");
        csv.append(positions[6]);
        csv.append(",");
        csv.append(positions[7]);
        csv.append(",");
        csv.append(positions[8]);
        csv.append(",");
        csv.append(positions[9]);        
        csv.append("\n");
        return csv.toString();
    }
    
        
}
