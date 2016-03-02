/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package securitylab3;

/**
 *
 * @author AJ
 */
public class ComputerStats {
    private boolean vulnerable;
    private int infected;
    private boolean beenCounted;
    
    private boolean isDead;
    
    public ComputerStats() {
        this.vulnerable = true;
        this.infected = 0;
        this.isDead = false;
        this.beenCounted = false;
    }
    public boolean getVulnerability(){
        return vulnerable;
    }
    public void setInvulnerable(){
        this.vulnerable = false;
    }
    public void addInfected() {
        this.infected++;
    }

    public boolean hasBeenCounted() { //has to whether its been counted as reinfected yet or not
        return beenCounted;
    }

    public void setBeenCounted() {
        this.beenCounted = true;
    }
    
    public int getInfected(){
        return infected;
    }
    
    public void setIsDead(){
        this.isDead = true;
    }
    public boolean getIsDead(){
        return isDead;
    }
}
