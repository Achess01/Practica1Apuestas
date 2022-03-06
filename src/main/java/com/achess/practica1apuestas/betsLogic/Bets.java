/*
 * Welcome
 */
package com.achess.practica1apuestas.betsLogic;
import com.achess.practica1apuestas.betsLogic.linkedList.List;
import com.achess.practica1apuestas.betsLogic.linkedList.Node;

/**
 *
 * @author achess
 */
public class Bets {
    private static Bets bets;
    private List<Bet> noVerified;
    private List<Bet> accepted;
    private List<Bet> rejected;
    private boolean validated;
    private boolean finished;
    private int finalPositions[];
    private boolean calculated;
    
    private Bets(){
        noVerified = new List();
        accepted = new List();
        rejected = new List();
        validated = false;
        finished = false;
        calculated = false;
    }
    
    public static Bets getBets(){
        if(bets == null){
            bets = new Bets();            
        }
        return bets;
    }

    public int[] getFinalPositions() {
        return finalPositions;
    }

    public void setFinalPositions(int[] finalPositions) {
        this.finalPositions = finalPositions;
    }
            
    public void addNoVerified(Bet bet){
        noVerified.push(bet);
    }
    
    public void addAccepted(Bet bet){
        accepted.push(bet);
    }
    
    public void addNoVerified(String gambler, int amount, int positions[]){
        Bet bet = new Bet(gambler, amount, positions); 
        noVerified.push(bet);
    }
    
    public void addRejected(Bet bet){
        rejected.push(bet);
    }
    
    public void validate(){       
        if(!validated){
            Node<Bet> aux = noVerified.pop();
            while(aux != null){
                if(Verify.validate(aux.getData().getPositions())){
                    accepted.push(aux);
                }
                else{
                    rejected.push(aux);
                }
                aux = noVerified.pop();
            }
        }
        validated = true;
        //System.gc();        
    }
    
    public static void clear(){
        bets = null;
        System.gc();
    }

    public boolean isValidated() {
        return validated;
    }
        
    public List<Bet> getNoVerified() {
        return noVerified;
    }

    public List<Bet> getAccepted() {
        return accepted;
    }

    public List<Bet> getRejected() {
        return rejected;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }
        
    
    public void sortByPoinst(){
        
    }
                      
    /**
     * Calculating final results
     */
    public void calculateRetults(){
        if(!calculated){
            Node<Bet> aux = accepted.getHead();
            while(aux != null){
                getPoints(aux.getData());
                aux = aux.getNext();
            }
        }
        calculated = true;
    }
    private void getPoints(Bet bet){
        int gamblerPositions[] = bet.getPositions();
        int pts = 0;
        pts += gamblerPositions[0] == finalPositions[0] ? 10 : 0;
        pts += gamblerPositions[1] == finalPositions[1] ? 9 : 0;
        pts += gamblerPositions[2] == finalPositions[2] ? 8 : 0;
        pts += gamblerPositions[3] == finalPositions[3] ? 7 : 0;
        pts += gamblerPositions[4] == finalPositions[4] ? 6 : 0;
        pts += gamblerPositions[5] == finalPositions[5] ? 5 : 0;
        pts += gamblerPositions[6] == finalPositions[6] ? 4 : 0;
        pts += gamblerPositions[7] == finalPositions[7] ? 3 : 0;
        pts += gamblerPositions[8] == finalPositions[8] ? 2 : 0;
        pts += gamblerPositions[9] == finalPositions[9] ? 1 : 0;                        
        bet.addPoints(pts);
    }
    
}
