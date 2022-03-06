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
    private static int steps = 0;
    
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
            int stepsCount = 0;
            int maxSteps = stepsCount;
            int minSteps = stepsCount + 10;
            Long start = System.nanoTime();
            Node<Bet> aux = noVerified.pop();
            while(aux != null){
                if(Verify.validate(aux.getData().getPositions())){
                    accepted.push(aux);
                }
                else{
                    rejected.push(aux);
                }
                aux = noVerified.pop();
                int actualSteps = Verify.getSteps();
                stepsCount += actualSteps;
                if(actualSteps > maxSteps){
                    maxSteps = actualSteps;
                }
                if(actualSteps < minSteps){
                    minSteps = actualSteps;
                }
            }
            Long end = System.nanoTime();
            double averageTime = end.doubleValue() - start.doubleValue();
            averageTime = averageTime/noVerified.getLen();
            float averageSteps = stepsCount/noVerified.getLen();
            System.out.println("------VERIFICACIÓN DE RESULTADOS------");
            System.out.println("Tiempo promedio: " + averageTime + "ns");
            System.out.println("Pasos promedio: " + averageSteps + " pasos");
            System.out.println("Mayor cantidad de pasos: " + maxSteps + " pasos");
            System.out.println("Menor cantidad de pasos: " + minSteps + " pasos");
            System.out.println("--------------------------------------");
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
        
    
    public void sortByPoints(){
        Long start = System.nanoTime();
        //
        steps = 0;
        Node<Bet> newHead = mergeSort(accepted.getHead(), true);
        accepted.setHead(newHead);
        //
        Long end = System.nanoTime();
        double averageTime = end.doubleValue() - start.doubleValue();
        averageTime = averageTime/accepted.getLen();
        double averageSteps = steps/accepted.getLen();
        System.out.println("------ORDENAMIENTO POR PUNTOS------");
        System.out.println("Tiempo promedio: "+ averageTime +"ns");
            System.out.println("Promedio de pasos: " + averageSteps + " pasos");            
        System.out.println("-----------------------------------");
        
    }
    
    public void sortByNames(){
        Long start = System.nanoTime();
        //
        steps = 0;
        Node<Bet> newHead = mergeSort(accepted.getHead(), false);
        accepted.setHead(newHead);
        //
        Long end = System.nanoTime();
        double averageTime = end.doubleValue() - start.doubleValue();
        averageTime = averageTime/accepted.getLen();        
        double averageSteps = steps/accepted.getLen();
        System.out.println("------ORDENAMIENTO POR NOMBRES------");
        System.out.println("Tiempo promedio: "+ averageTime +"ns");
            System.out.println("Promedio de pasos: " + averageSteps + "pasos");            
        System.out.println("-----------------------------------");
    }
    
    private Node<Bet> mergeSort(Node<Bet> head, boolean points){       
        steps++;
        if(head == null || head.getNext() == null){
            return head;
        }
        Node middle = getMiddle(head);
        Node nextoMiddle = middle.getNext();
        middle.setNext(null);
        Node left = mergeSort(head, points);
        Node right = mergeSort(nextoMiddle, points);
        if(points) return SortedMergeForPoints(left, right);
        return SortedMergeForNames(left, right);
        
    }
    
    private Node<Bet> SortedMergeForPoints(Node<Bet> a, Node<Bet> b){
        steps++;
        Node<Bet> result = null;
        if(a == null){
            return b;
        }
        if(b == null){
            return a;
        }
        if(a.getData().getPoints() >= b.getData().getPoints()){
            result = a;
            result.setNext(SortedMergeForPoints(a.getNext(), b));
        }else{
            result = b;
            result.setNext(SortedMergeForPoints(a, b.getNext()));
        }
        return result;
    }
    
    private Node<Bet> SortedMergeForNames(Node<Bet> a, Node<Bet> b){
        steps++;
        Node<Bet> result = null;
        if(a == null){
            return b;
        }
        if(b== null){
            return a;
        }
        if(a.getData().getGamblerName().compareToIgnoreCase(b.getData().getGamblerName()) <= 0){
            result = a;
            result.setNext(SortedMergeForNames(a.getNext(), b));
        }else{
            result = b;
            result.setNext(SortedMergeForNames(a, b.getNext()));
        }
        return result;
    }
    
    private Node getMiddle(Node head){  
        steps++;
        if(head == null){
            return head;
        }
        
        Node slow = head, fast = head;
        while(fast.getNext() != null && fast.getNext().getNext() != null){
            slow = slow.getNext();
            fast = fast.getNext().getNext();
            steps++;
        }
        return slow;
    }
                      
    /**
     * Calculating final results
     */
    public void calculateRetults(){                
        if(!calculated){
            Long start = System.nanoTime();
            Double average = 0.0;
            Node<Bet> aux = accepted.getHead();
            while(aux != null){                
                getPoints(aux.getData());                
                aux = aux.getNext();
            }
            average = average / accepted.getLen();            
            //System.out.printf("Tiempo promedio: %d ns", average);                        
            Long end = System.nanoTime();
            double averageTime = 0.0;
            averageTime = (end.doubleValue() - start.doubleValue());
            averageTime = averageTime/accepted.getLen();
            System.out.println("---------CÁLCULO DE RESULTADOS--------");
            System.out.println("Tiempo promedio: "+ averageTime+"ns");
            System.out.println("Promedio de pasos: 10 pasos");
            System.out.println("Mayor: 10 pasos");
            System.out.println("Menor: 10 pasos");
            System.out.println("--------------------------------------");
        }        
        calculated = true;
    }
    /**
     * O(1) porque siempre son 10 pasos
     * @param bet 
     */  
    private void getPoints(Bet bet){
        int gamblerPositions[] = bet.getPositions();
        int bigPts = 10;
        int pts = 0;
        for(int x = 0; x < 10; x++){
            pts += gamblerPositions[x] == finalPositions[x] ? bigPts - x : 0;
        }
        bet.addPoints(pts);
        /*
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
        */
    }
    
}
