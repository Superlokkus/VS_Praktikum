/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vs_prakt;

import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author markus
 */
public class Philosopher extends Thread{
    
    public Philosopher(int name,Table table)
    {
        this.name = name; setName(String.valueOf(name));
        this.table = table;
        
        start();
    }
    
    @Override
    public void run() 
    {
        while (true) {
            try {
                think();
            } catch (InterruptedException ex) {
                break;
            }
            System.out.println(name + " will try to take fork " + name);
            while (!table.takeFork(name));
            System.out.println(name + " will try to take fork " + (name + 1));
            while (!table.takeFork(name + 1));
            try {
                eat();
            } catch (InterruptedException ie) {
                break;
            } finally
            {
                System.out.println(name + " puts down fork " + name);
                table.putFork(name);
                System.out.println(name + " puts down fork " + (name + 1));
                table.putFork(name + 1);
            }
        }
        
    }
    
    private void think() throws InterruptedException
    {
        int time = ThreadLocalRandom.current().nextInt(0,20000);
        System.out.println(name + " starts thinking for " + time + "ms");
        Thread.sleep(time);
    }
    
    private void eat() throws InterruptedException
    {
        int time = ThreadLocalRandom.current().nextInt(0,20000);
        System.out.println(name + " starts eating for " + time + "ms");
        Thread.sleep(time);
    }
    
    private Table table;
    final private int name;
}
