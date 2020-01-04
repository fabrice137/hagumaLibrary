/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fabFileLib;

/**
 *
 * @author fabruz
 */
public class SwitchBase {
    /*Switching from base 10 to base 36 */
    public String turnToBase36(int anInt){
        return Integer.toString(anInt, 36);
    }
    
    /*Switching from base 10 to base 36 */
    public String turnToBase36(long aLong){
        return Long.toString(aLong, 36);
    }
    
    /*Switching from base 36 to base 10 */
    public long turnToBase10(String base36String){
        return Long.parseLong(base36String.toLowerCase(), 36);
    }
    
    public String cryptorBase36(String text){
        StringBuilder sb = new StringBuilder("");
        int sz = text.length();
        for(int i=0 ; i<sz ; i++){
            int kar = (int)text.charAt(i) + 100;
            sb.append(Integer.toString(kar, 36));
        } return sb.toString();
    }
    public String uncryptorBase36(String text){
        StringBuilder sb = new StringBuilder();
        int sz = text.length();
        for(int i=1 ; i<sz ; i += 2){ 
            int twoChar = Integer.parseInt((text.charAt(i -1) + "" + text.charAt(i)), 36);
            sb.append((char) (twoChar - 100));
        }         
        return sb.toString();
    }
}
