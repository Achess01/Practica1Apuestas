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
    
    private Bets(){
        noVerified = new List();
        accepted = new List();
        rejected = new List();
        validated = false;
    }
    
    public static Bets getBets(){
        if(bets == null){
            bets = new Bets();            
        }
        return bets;
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
        //System.gc();        
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
                       
    
    public static void verify(){
        
    }
    
}
