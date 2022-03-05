/*
 * Welcome
 */
package com.achess.practica1apuestas.betsLogic;

/**
 *
 * @author achess
 */
public class Verify {
            
    public static boolean validate(int array[]) {
        boolean[] isOnRepeated = new boolean[10];        
        for (int pos: array) {             
            int index = pos - 1;
            if(isOnRepeated[index]) return false;
            isOnRepeated[index] = true;
        }        
        return true;
    }
}
