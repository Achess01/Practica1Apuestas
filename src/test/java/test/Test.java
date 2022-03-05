/*
 * Welcome
 */
package test;

/**
 *
 * @author achess
 */
public class Test {
    public static void main(String[] args) {
        boolean[] test = new boolean[10];
        //System.out.println(test[1]);
        String pattern = "\\w+,[1-9]\\d*(,(10|[1-9])){10}";
        String line = "Pedro,334,10,2,3,4,5,6,7,8,9,10";
        System.out.println(line.matches(pattern));
    }
}
