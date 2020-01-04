
package fabFileLib;


public class FabCipher {
    /**
     * ciphering a string using a key of your choice 
     * @param anyString
     * @param keyString 
     * @return an encrypted string 
     */
    public String cipherString(String anyString, String keyString){
        if(anyString == null || anyString.equals("")) return "";
        if(keyString == null || keyString.equals("")) keyString = "string";
        
        String one = hashCryptor(anyString, keyString, true);
        return stringMixer(obfuscator(one));
    }
    
    /**
     * deciphering a string using a key that you used to cipher the string 
     * @param anyString
     * @param keyString 
     * @return an encrypted string 
     */
    public String decipherString(String anyString, String keyString){
        if(anyString == null || anyString.equals("")) return "";
        if(keyString == null || keyString.equals("")) keyString = "string";
        
        String one = unObfuscator(unStringMixer(anyString)); 
        return hashCryptor(one, keyString, false); 
    }
    
    /*THIS ARE THE METHODS FOR THE FABCIPHER DECIPHER */
    private String obfuscator(String str){
        StringBuilder sb = new StringBuilder();
        SwitchBase base = new SwitchBase();
        if (str.length() <= 512) {
            for (int i=0 ; i<str.length() ; i++)
                sb.append(base.turnToBase36(str.charAt(i) + 321));
            return sb.toString();
        }
        for (int i=0 ; i<str.length() ; i++)
            sb.append(base.turnToBase36(str.charAt(i) + 13000));
        return sb.toString();
    }
    private String unObfuscator(String str){
        StringBuilder sb = new StringBuilder();
        SwitchBase base = new SwitchBase();
        int decimal = 0;
        if (str.length() <= 1024) {
            for (int i=0 ; i<str.length() ; i+=2){
                decimal = (int) base.turnToBase10(str.substring(i, i+2));
                sb.append((char)(decimal - 321)); 
            } return sb.toString();
        }
        for (int i=0 ; i<str.length() ; i+=3){
            decimal = (int) base.turnToBase10(str.substring(i, i+3));
            sb.append((char)(decimal - 13000)); 
        } return sb.toString();
    }
    
    private String hashCryptor(String anyString, String keyCode, boolean doUndo){
        return hashCryptor(anyString, Math.abs(simpleHashCode(keyCode)), doUndo);
    }
    private String hashCryptor(String anyString, long keyNumber, boolean doUndo){
        int sz = anyString.length();
        long prevPrime = Math.abs(keyNumber); 
        long nextPrime = nextPrime(prevPrime);
        int difference = (int) (nextPrime - prevPrime);
        StringBuilder sb = new StringBuilder();
        
        if (doUndo) { 
            for (int i=0 ; i<sz ; i++){
                prevPrime = nextPrime; 
                sb.append((char)charShuffler(anyString.charAt(i), (7 + i + difference), true));
                nextPrime = nextPrime(nextPrime);
                difference = (int) (nextPrime - prevPrime);
            }
        }
        else{ 
            for (int i=0 ; i<sz ; i++){
                prevPrime = nextPrime; 
                sb.append((char)charShuffler(anyString.charAt(i), (7 + i + difference), false));
                nextPrime = nextPrime(nextPrime);
                difference = (int) (nextPrime - prevPrime);
            }
        }
        return sb.toString();
    }
    
    private long simpleHashCode(String str){
        long hashed = str.hashCode();
        for (int i=0 ; i<str.length() ; i++){
            hashed += str.charAt(i) * 500;
        }return hashed;
    }
    
    private long nextPrime(long number){
        number++;
        while (!isPrime(number)) number++;
        return number;
    }
    
    private boolean isPrime(long num){
        if (num == 2) return true;
        if (num % 2 == 0) return false;
        long end = (long) (1 + Math.sqrt(num)); 
        for (long i = 3 ; i < end ; i+=2) if(num % i == 0) return false ;
        return true;
    }
    
    private int charShuffler(char kar, int posNAdiff, boolean do_Undo){
        /* TAKING A CHARACTER AND RATATE IT IN THE CHARACTER SET TO SOME OTHER LETTER */
        if (do_Undo) return kar + posNAdiff;
        return kar - posNAdiff;
    }
    private String stringMixer(String word){
        int n = word.length()/2;
        StringBuilder sb = new StringBuilder();
        for(int i=0 ; i<n ; i++) sb.append(word.charAt(n + i)).append(word.charAt(i));
        if(word.length()%2 != 0) sb.append(word.charAt(n*2));

        return sb.toString();
    }
    private String unStringMixer(String word){
        int sz = word.length();
        StringBuilder sbXX = new StringBuilder();
        StringBuilder sbYY = new StringBuilder();
        for(int i=0 ; i<sz ; i++){
            if(i%2 == 0) sbXX.append(word.charAt(i));
            else sbYY.append(word.charAt(i));
        }
        return sbYY.append(sbXX).toString();
    }
    /*THIS ARE THE METHODS FOR THE FABCIPHER DECIPHER */
}
