/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vs_praktikum;

/**
 *
 * @author markus
 */
public class VS_Prakt {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final int count = 5;
        Table table = new Table(count);
        Philosopher phils[] = new Philosopher[count];
        for (int i = 0; i < count; i++)
        {
            phils[i] = new Philosopher(i,table);
        }
    }
    
}
