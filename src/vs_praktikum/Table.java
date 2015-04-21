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
public class Table {
    
    public Table(int forkCount)
    {
        forkUsed = new boolean[forkCount];
    }
    
    public boolean takeFork(int fork)
    {
        fork = fork % forkUsed.length ;
        if (forkUsed[fork])
        {
            return false;
        }
        forkUsed[fork] = true;
        return true;
    }
    
    public void putFork(int fork)
    {
        fork = fork % forkUsed.length ;
        if (!forkUsed[fork])
        {
            throw new RuntimeException("Fork already put on table");
        }
        forkUsed[fork] = false;
    }
    
    private boolean[] forkUsed;
}
