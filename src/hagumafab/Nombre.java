/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hagumafab;

/**
 *
 * @author fabruz
 */
public class Nombre {
    
    public boolean myIsNumber(Object thing){ 
        String str = String.valueOf(thing);
        if(str.isEmpty()) return false;
        int start = 0, size = str.length();
        if (str.charAt(0) == 43 || str.charAt(0) == 45) 
            start = 1;  // in case there is plus or minus
        if (str.charAt(start) == 46) return false; // a dot at the beginning is bad !!
        for (int i=start ; i<size ; i++){
            if (str.charAt(i) < 46 || str.charAt(i) > 57) return false;
            if (str.charAt(i) == 47) return false;
        }
        return true;
    }
    
}
