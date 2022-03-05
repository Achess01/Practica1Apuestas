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
    
    private Bets(){
        noVerified = new List();
        accepted = new List();
        rejected = new List();
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
    
    public void addRejected(Bet bet){
        rejected.push(bet);
    }
    
    public static void verify(){
        
    }
    
}
