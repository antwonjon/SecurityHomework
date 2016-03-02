/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package securitylab2;

/**
 *
 * @author AJ
 */
public class Password {
    private String value, actual;
    private long time;

    public Password(String value, String actual, long time) {
        this.value = value;
        this.actual = actual;
        this.time = time;
    }

    public String getValue() {
        return value;
    }

    public String getActual() {
        return actual;
    }

    public long getTime() {
        return time;
    }
    
   
    
}
