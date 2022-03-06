/*
 * Welcome
 */
package com.achess.practica1apuestas.betsLogic;

import com.achess.practica1apuestas.betsLogic.linkedList.List;
import com.achess.practica1apuestas.betsLogic.linkedList.Node;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author achess
 */
public class Verify {
    
    private static int steps = 0;
    /**
     * O(1) ya que siempre hace 10 pasos o incluso menos
     * @param array Siempre de tamaño 10
     * @return 
     */
    public static boolean validate(int array[]) {        
        steps = 0;
        boolean[] isOnRepeated = new boolean[10];            
        for (int pos: array) {             
            steps++;
            int index = pos - 1;
            if(isOnRepeated[index]) return false;
            isOnRepeated[index] = true;
        }        
        return true;        
        /*
        int pos = 0;
        boolean[] founded = new boolean[10];
        founded[array[pos] - 1] = true;
        pos++;
        founded[array[pos] - 1] = true;
        pos++;
        founded[array[pos] - 1] = true;
        pos++;
        founded[array[pos] - 1] = true;
        pos++;
        founded[array[pos] - 1] = true;
        pos++;
        founded[array[pos] - 1] = true;
        pos++;
        founded[array[pos] - 1] = true;
        pos++;
        founded[array[pos] - 1] = true;
        pos++;
        founded[array[pos] - 1] = true;
        pos++;
        founded[array[pos] - 1] = true;        
        
        return founded[0] && founded[1] && founded[2] && founded[3] && founded[4] &&
               founded[5] && founded[6] && founded[7] && founded[8] && founded[9];    
        */
    }

    public static int getSteps() {
        return steps;
    }
    
    
    
    public static DefaultTableModel getModel(List<Bet> list){
        Node<Bet> aux = list.getHead();
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("No.");
        model.addColumn("Nombre");
        model.addColumn("Puntos");
        Integer line = 1;
        while(aux != null){
            Bet bet = aux.getData();
            Object[] data = {line, bet.getGamblerName(), bet.getPoints()};
            model.addRow(data);
            line++;
            aux = aux.getNext();
        }
        return model;
    }
}
