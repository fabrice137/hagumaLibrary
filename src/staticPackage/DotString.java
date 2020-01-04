/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package staticPackage;

/**
 *
 * @author fabruz
 */
public class DotString {
    
    
    
    public static String makeNumbers(String string){
        String one = stringToCodePoints(string);
        return stringMixer(one);
    }
    
    public static String unmakeNumbers(String string){
        String one = unStringMixer(string);
        return codePointsToString(one);
    }
    
    public static String stringToCodePoints(String str){
        StringBuilder sb = new StringBuilder();
        for(int i=0 ; i<str.length() ; i++){
            if (str.codePointAt(i) < 31) {
                sb.append(str.codePointAt(i));
            }
            
        } return sb.toString();
    }
    public static String codePointsToString(String text){
        StringBuilder sb = new StringBuilder(); 
        int index = 0, charCode, size = text.length(); 
        while(index < size){
            if(text.codePointAt(index) < 51) {
                charCode = Integer.parseInt(text.substring(index, index+3));
                if(charCode < 31) sb.append((char) charCode);
                index += 3;
            }else{
                charCode = Integer.parseInt(text.substring(index, index+2));
                if(charCode < 31) sb.append((char) charCode);
                index += 2;
            }
        } return sb.toString();
    }
    
    /**
     *read a string from a text file in a folder with the filename NB: don't put extension
     * @param folder to read from 
     * @param filename the name of your file in that folder 
     * @return  a string representation of the text file content 
     * @throws java.lang.Exception 
     */
    public static String readFile_asString(String folder, String filename) throws Exception{
        java.io.File file2read = new java.io.File(folder + filename);
        StringBuilder sbContent = new StringBuilder();
        
        try (java.io.BufferedReader reader = 
                new java.io.BufferedReader(new java.io.FileReader(file2read)); )
        {
            String line = reader.readLine();
            while (line != null) {
                sbContent.append(line).append(System.lineSeparator());
                line = reader.readLine() ;
            }
        }
        return sbContent.toString(); 
    }
    
    
    
    public static String DynamicEncryptor(String line){
        
        int[] char2dec = turn2Dec(line); 
        
        String[] twoLetter = new String[char2dec.length];
        for(int i=0 ; i<char2dec.length ; i++) twoLetter[i] = twoletter(char2dec[i]); 

        String unbelievable = makeWord(twoLetter);

        String smarter = smarten(unbelievable, 1);

        String[] textOUT = believable(smarter);
        
        StringBuilder finiBuilder = new StringBuilder();
        for (String textOUT1 : textOUT) {
            finiBuilder.append(randomUpperCase(textOUT1, true)).append(' ');
        }
        return addDigitInSpace(finiBuilder.toString());
    }
    
    public static String DynamicDecryptor(String line){
        String[] textIN_Arr = replaceDigitWithSpace(line);
        
        String unbelievable = makeWord(textIN_Arr);
        unbelievable = randomUpperCase(unbelievable, false);
        
        String notsmart = smarten(unbelievable, -1);
        
        int smallsize = notsmart.length() / 2;
        
        String[] twoLetter = new String[smallsize];
        
        for(int i=0 ; i<smallsize ; i++) 
            twoLetter[i] = notsmart.charAt(i*2) + "" + notsmart.charAt((i*2)+1);
        
        int[] two2dec = new int[smallsize];
        
        for(int i=0 ; i<smallsize ; i++) two2dec[i] = UN2letter(twoLetter[i]);
        
        char[] dec2char = turn2Char(two2dec);
        
        String textOUT = makeWord(dec2char);
        
        return textOUT; 
    }
    
    public static String cipherString(String anyString, String keyString){
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
    public static String decipherString(String anyString, String keyString){
        if(anyString == null || anyString.equals("")) return "";
        if(keyString == null || keyString.equals("")) keyString = "string";
        
        String one = unObfuscator(unStringMixer(anyString)); 
        return hashCryptor(one, keyString, false); 
    }
    
    /*THIS ARE THE METHODS FOR THE FABCIPHER DECIPHER */
    private static String obfuscator(String str){
        StringBuilder sb = new StringBuilder();
        if (str.length() <= 512) {
            for (int i=0 ; i<str.length() ; i++)
                sb.append(turnToBase36(str.charAt(i) + 321));
            return sb.toString();
        }
        for (int i=0 ; i<str.length() ; i++)
            sb.append(turnToBase36(str.charAt(i) + 13000));
        return sb.toString();
    }
    private static String unObfuscator(String str){
        StringBuilder sb = new StringBuilder();
        int decimal = 0;
        if (str.length() <= 1024) {
            for (int i=0 ; i<str.length() ; i+=2){
                decimal = (int) turnToBase10(str.substring(i, i+2));
                sb.append((char)(decimal - 321)); 
            } return sb.toString();
        }
        for (int i=0 ; i<str.length() ; i+=3){
            decimal = (int) turnToBase10(str.substring(i, i+3));
            sb.append((char)(decimal - 13000)); 
        } return sb.toString();
    }
    
    /*Switching from base 10 to base 36 */
    public static String turnToBase36(long aLong){
        return Long.toString(aLong, 36);
    }
    
    /*Switching from base 36 to base 10 */
    public static long turnToBase10(String base36String){
        return Long.parseLong(base36String.toLowerCase(), 36);
    }
    
    private static String hashCryptor(String anyString, String keyCode, boolean doUndo){
        return hashCryptor(anyString, Math.abs(simpleHashCode(keyCode)), doUndo);
    }
    private static String hashCryptor(String anyString, long keyNumber, boolean doUndo){
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
    
    private static long simpleHashCode(String str){
        long hashed = str.hashCode();
        for (int i=0 ; i<str.length() ; i++){
            hashed += str.charAt(i) * 500;
        }return hashed;
    }
    
    private static long nextPrime(long number){
        number++;
        while (!isPrime(number)) number++;
        return number;
    }
    
    private static boolean isPrime(long num){
        if (num == 2) return true;
        if (num % 2 == 0) return false;
        long end = (long) (1 + Math.sqrt(num)); 
        for (long i = 3 ; i < end ; i+=2) if(num % i == 0) return false ;
        return true;
    }
    
    private static int charShuffler(char kar, int posNAdiff, boolean do_Undo){
        /* TAKING A CHARACTER AND RATATE IT IN THE CHARACTER SET TO SOME OTHER LETTER */
        if (do_Undo) return kar + posNAdiff;
        return kar - posNAdiff;
    }
    /*THIS ARE THE METHODS FOR THE FABCIPHER DECIPHER */
    
    
    /*THIS ARE THE METHODS FOR THE ENCRYPTOR DECRYPTOR */
    private static char[] alphaBet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    private static int [] integerArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 2, 3, 4, 5, 6, 5, 4, 3};
    private static int[] turn2Dec(String x){     /* returns an int array from a word's character values */
        int[] decims = new int[x.length()];
        for(int i=0 ; i<x.length() ; i++) decims[i] = (int)x.charAt(i);
        return decims;
    }
    private static String twoletter(int x){
        /* THE MOD CAN BE ANY NUMBER BTWN 0 AND 25 TO MATCH ALPHABET  BUT THE DIV CAN ONLY BE SO SMALL
        * THEN WHEN MOD IS 13 OR GREATER THE NEXT LETTER WILL BE <= DIV LETTERS IN THAT DIRECTION
        * WHEN MOD IS 12 OR LESS THE NEXT LETTER WILL BE => DIV LETTERS IN THAT DIRECTION.*/
        int div = x / 26;     int mod = x % 26;
        int next = mod + div;    if(mod > 12) next = mod - div;
        String sol = "" + alphaBet[mod] + alphaBet[next] + "";
        return sol;
    }
    private static int UN2letter(String two){
        int mod = two.charAt(0) - 97;     int next = two.charAt(1) - 97;
        
        int div = next - mod;  if(mod > 12) div = mod - next;
        int sol = (26 * div) + mod;

        return sol;
    }
    private static String makeWord(String[] arr){
        /* Taking-in an array of characters and returning a string/word.
        *  the word follows the sequence of the array. */
        StringBuilder sb = new StringBuilder();
        for (String arr1 : arr) sb.append(arr1);
        return sb.toString(); 
    }
    private static String makeWord(char[] arr){
        /*  Taking-in an array of characters and returning a string/word.
        *  the word follows the sequence of the array. */
        StringBuilder sb = new StringBuilder();
        for(char ka: arr) sb.append(ka);
        return sb.toString();
    }
    private static String randomFirst(String word_string, int do_OR_undo){
        /* do_OR_undo to do(positive) and remove(negative) the effect
        * ADD A RANDOM CHARACTER OR TWO BEFORE THE WORD_STRING  */
        if(do_OR_undo > 0) 
            return alphaBet[(int)(Math.random()*26)] + word_string;
        else 
            return word_string.substring(1);
    }
    private static String smarten(String word, int do_OR_undo){
        /* do_OR_undo to do(positive) and remove(negative) the effect
        * TO SCRABBLE WORDS THAT THEY ARE TIED TO THEIR POSITION IN THE STRING
        * in AARON (THE 1st A HAS A DIFFERENT LETTER FROM THE 2nd A
        * PLUS A RANDOM CHARACTER AT THE BEGINNIG OF THE WORD  WITH ITS INT AS RANDOM  */

        if(do_OR_undo > 0) word = randomFirst(word, do_OR_undo);

        int random = (int)word.charAt(0);

        StringBuilder sbSmart = new StringBuilder().append(word.charAt(0));

        for(int i=1 ; i<word.length() ; i++){
            sbSmart.append(shuffleCHAR(word.charAt(i), i, random, do_OR_undo));
        }
        if(do_OR_undo < 0) return sbSmart.substring(1);
        
        return sbSmart.toString();
    }
    private static char shuffleCHAR(char kar, int position, int random, int do_OR_undo){
        /* do_OR_undo to do(positive) and remove(negative) the effect
        * TO SHUFFLE CHARACTERS CONSIDERING THEIR POSITION
        * THE do_OR_undo IS FOR REVERSING THE EFFECT NEGATIVE VS POSITIVE  */
        int adder = random ;
        if(do_OR_undo < 0) adder = -random;

        adder += ((int)kar - 97);
        
        int newPosition = 11 + adder + position ;
        while(newPosition > 25) newPosition = newPosition - 26;
        // THE REVERSER STARTS HERE
        if(do_OR_undo < 0) {
            newPosition = adder - (11 + position);
            while(newPosition < 0) newPosition = newPosition + 26;
        }
        char finkar = alphaBet[newPosition];

        return finkar;
    }
    private static String[] believable(String x){ 
        /*ADDING SPACES HERE AND THERE */
        int szBut1 = x.length() - 1;
        StringBuilder sb = new StringBuilder(x);
        
        int at = 0;
        while (at <= szBut1){
            at += integerArray[(int)(Math.random() * 17)];
            if (at < szBut1) sb.insert(at, ' ');
        }
        return line2Arr(sb.toString()); 
    }
    private static String[] line2Arr(String phrase){
        /* you enter a phrase and it turns it into an arrayList of individual words. */
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
    private static char[] turn2Char(int[] arr){  /* returns an int array's character value array  */
        char[] chars = new char[arr.length];
        for(int i=0 ; i<arr.length ; i++) chars[i] = (char)arr[i];
        return chars;
    }
    
    private static String addDigitInSpace(String any){
        StringBuilder sb = new StringBuilder(any);
        for (int i=0 ; i<any.length() ; i++){
            if(sb.charAt(i) == ' ') 
                sb.replace(i, i+1, "" + (char)('0' + Math.random() * ('9' - '0' + 1)));
        }
        return sb.toString();
    }
    private static String[] replaceDigitWithSpace(String any){
        StringBuilder sb = new StringBuilder(any);
        int ka = 0;
        for (int i=0 ; i<any.length() ; i++){
            ka = (int) sb.charAt(i);
            if(ka > 47 && ka < 58) 
                sb.replace(i, i+1, " ");
        }
        return line2Arr(sb.toString()); 
    }
    private static String randomUpperCase(String any, boolean do_OR_undo){
        /* WITH TRUE ADD SOME RANDOM UPPERCASE HERE AND THERE WITH FALSE TO REMOVE THEM */
        if(do_OR_undo){
            StringBuilder sb = new StringBuilder(any);
            for (int i=0 ; i<any.length() ; i++){
                if ((int)(Math.random() * 11) %2 == 0)
                    sb.replace(i, i+1, Character.toString(any.charAt(i)).toUpperCase());
            } return sb.toString();
        } return any.toLowerCase();
    }
    private static String stringMixer(String word){
        int n = word.length()/2;
        StringBuilder sb = new StringBuilder();
        for(int i=0 ; i<n ; i++) sb.append(word.charAt(n + i)).append(word.charAt(i));
        if(word.length()%2 != 0) sb.append(word.charAt(n*2));

        return sb.toString();
    }
    private static String unStringMixer(String word){
        int sz = word.length();
        StringBuilder sbXX = new StringBuilder();
        StringBuilder sbYY = new StringBuilder();
        for(int i=0 ; i<sz ; i++){
            if(i%2 == 0) sbXX.append(word.charAt(i));
            else sbYY.append(word.charAt(i));
        }
        return sbYY.append(sbXX).toString();
    }
    /*THIS ARE THE METHODS FOR THE ENCRYPTOR DECRYPTOR */
    
    
}
