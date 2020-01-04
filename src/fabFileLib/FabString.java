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
public class FabString {
    /**/

    /**
     * generate a name of your file based on the current time with any other thing you want
     * to add on it whether it goes before or after the date and time
     * @param addOn
     * @param before
     * @return 
     */
    public String randomFileName(String addOn, boolean before){
        java.text.DateFormat dateFormat = new java.text.SimpleDateFormat("yyyyMMdd_hhmmss");
        String nameOfFile = dateFormat.format(new java.util.Date());
        if (before) {
            return addOn + "_" + nameOfFile;
        } return nameOfFile + "_" + addOn;
    }
    
    /**
     * enter an anyNumber and it is spaced between thousands
     * @param anyNumber
     * @return  anyNumber with spaces 
     */
    public String reWriteNumb(Number anyNumber){
        String word = anyNumber + "";
        int sz = word.length();
        StringBuilder out = new StringBuilder();
        for (int i=1; i<=sz ; i++){ 
            if ((i-1) % 3 == 0) {
                out.append(' ');
            }
            out.append(word.charAt(sz - i));
        }
        return out.reverse().toString(); 
    }
    /**
     * enter an anyObject (got to be primitive) and it is reversed.
     * @param anyObject
     * @return  anyObject reversed
     */
    public String reverseThis(Object anyObject){
        StringBuilder sb = new StringBuilder(String.valueOf(anyObject));
        return sb.reverse().toString();
    }

    /**
     * enter a phrase and it turns it into a string array of individual words.
     * @param phrase
     * @return a string array
     */
    public String[] lineToArray(String phrase){
        // you enter a phrase and it turns it into an arrayList of individual words.
        phrase += " ";
        int szP = phrase.length();   // szP = size of the phrase
        
        java.util.ArrayList<String> list = new java.util.ArrayList<>(); 
        StringBuilder builder = new StringBuilder();
        
        for(int i=0 ; i<szP ; i++) {
            int intKar = (int)phrase.charAt(i);
            if (intKar > 32) builder.append(phrase.charAt(i));
            else if (intKar == 32 && !"".equals(builder.toString())){
                list.add(builder.toString());
                builder.delete(0, builder.length());
            }
            else builder.delete(0, builder.length());
        }
        int newsz = list.size();
        String[] arr = new String[newsz];
        for (int i=0; i<newsz; i++) arr[i] = list.get(i);
        
        return arr;
    }
    
    private char getRandomCharacter(char ch1, char ch2){
        /** Generate a random character between ch1 and ch2 */
        return (char)(ch1 + Math.random() * (ch2 - ch1 + 1));
    }
    public char getRandomLowerCaseLetter(){
        /** Generate a random lowercase letter */
        return getRandomCharacter('a', 'z');
    }
    public char getRandomUpperCaseLetter(){
        /** Generate a random uppercase letter */
        return getRandomCharacter('A', 'Z');
    }
    public char getRandomDigitCharacter(){
        /** Generate a random digit character */
        return getRandomCharacter('0', '9');
    }
    private char getRandomCharacter(){
        /** Generate a random character */
        return getRandomCharacter('\u0000', '\uFFFF');
    }
    
    public String randomStringOf(int size, boolean alphabetTrue_numericFalse){
        StringBuilder sb = new StringBuilder(size+3);
        if (alphabetTrue_numericFalse) {
            for(int i=0 ; i<size ; i++){
                int rand = (int) (Math.random() * 2);
                if (rand == 1) sb.append(getRandomCharacter('a', 'z'));
                else sb.append(getRandomCharacter('A', 'Z'));
            }
            return sb.toString();
        }else {
            for(int i=0 ; i<size ; i++){
                sb.append(getRandomCharacter('0', '9'));
            }
            return sb.toString();
        }
    }
    
    public String randomStringOf(int size, boolean alphaNumeric, boolean nonAlphaNumeric){
        StringBuilder sb = new StringBuilder(size+3);
        boolean areBoth = (alphaNumeric && nonAlphaNumeric);
        if (areBoth) {
            for(int i=0 ; i<size ; i++){
                int rand = (int) (Math.random() * 3);
                if (rand == 1 || rand == 2) sb.append(getRandomAlphaNumeric());
                else sb.append(getRandom_Non_AlphaNumeric());
            }
            return sb.toString();
        }
        else if (alphaNumeric) {
            for(int i=0 ; i<size ; i++){
                sb.append(getRandomAlphaNumeric());
            }
            return sb.toString();
        }
        else {
            for(int i=0 ; i<size ; i++){
                sb.append(getRandom_Non_AlphaNumeric());
            }
            return sb.toString();
        }
    }
    
    public char getRandomAlphaNumeric(){
        /** Generate a random character */
        int random = (int) (Math.random() * 3); 
        switch (random) {
            case 0:
                return getRandomCharacter('A', 'Z');   
            case 1:
                return getRandomCharacter('a', 'z');
            case 2:
                return getRandomCharacter('0', '9');
            default:
                return getRandomCharacter('A', 'Z');
        }
    }
    
    public char getRandom_Non_AlphaNumeric(){
        /** Generate a random character */
        int random = (int) (Math.random() * 5); 
        switch (random) {
            case 0:
                return getRandomCharacter('!', '(');  // (From:33  To:40)   
            case 1:
                return getRandomCharacter(')','/');   // (From:41  To:47) 
            case 2:
                return getRandomCharacter(':','@');  //  (From:58  To:64)
            case 3:
                return getRandomCharacter('[','`');  //  (From:91  To:96)  
            case 4:
                return getRandomCharacter('{','~');  //  (From:123  To:126) 
            default:
                return getRandomCharacter('!', '/'); //  just from 33 to 47
        }
    }
    
    /**
     * returns a string array from parsing the string entered if parse-able 
     * @param stringToParse
     * @return a string array
     */
    public String[] jfxParse(String stringToParse){
        int sz1 = stringToParse.length();
        String[] arr = stringToParse.substring(1, sz1-1).split("¦"); 
        return arr;
    }
    
    /**
     * returns a string of objects like regular toString but without coma separation 
     * @param objects
     * @return a string
     */
    public String jfxToString(Object[] objects){
        StringBuilder sb = new StringBuilder().append("[");
        int sz = objects.length;
        for (int i=0 ; i<sz-1 ; i++){ // THIS IS A TWO LINE SPLIT
            sb.append(String.valueOf(objects[i])).append("¦");
        }
        sb.append(objects[sz-1]).append("]");
        return sb.toString();
    }
    
    /**
     * returns a string of objects like regular toString but without coma separation
     * @param strings
     * @return a string
     */
    public String jfxToString(java.util.List<String> strings){
        StringBuilder sb = new StringBuilder().append("[");
        int sz = strings.size();
        for (int i=0 ; i<sz-1 ; i++){ // THIS IS A TWO LINE SPLIT
            sb.append(String.valueOf(strings.get(i))).append("¦");
        }
        sb.append(strings.get(sz-1)).append("]");
        return sb.toString();
    }
    public String simplePadding(Number number, int capSize){
        return padString(String.valueOf(number), "0", capSize);
    }
    public String simplePadding(String string, int capSize){
        return padString(string, " ", capSize);
    }
    
    private static String padString(String str, String margin ,int topSize){
        StringBuilder sb = new StringBuilder();
        int pad = topSize - str.length();
        if (pad > 0) {
            for (int i=0 ; i<pad ; i++) sb.append(margin);
            return sb.append(str).toString();
        }else if (pad < 0) {
            return str.substring(0, (str.length()+ pad));
        }
        return str;
    }
    
}
