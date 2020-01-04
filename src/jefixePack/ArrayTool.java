/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jefixePack;


public class ArrayTool {
    

    /**
     * search a key in an array of strings. if you search in the whole array put zeros in from and upto parameters 
     * @param array
     * @param key
     * @param from
     * @param upto
     * @return an index where it is or should be
     */
    public int binarySearch(String[] array, String key, int from, int upto){
        int size = array.length;
        int low = from; if(low < 0 || low > size) low = 0;
        int high = upto; if(high <= 0 || high > size) high = size;
        
        while (low < high) {            
            int mid = (low + high) / 2; // find middle
            if (key.compareTo(array[mid]) < 0) high = mid;    // Search Low half.
            else if (key.compareTo(array[mid]) > 0) low = mid + 1;  // Search Top half.
            else return mid;    // Found it. return position
        }
        return -(low + 1); // It should be here positively
    }
    
    /**
     * search a key number in an array of numbers. if you search in the whole array put zeros in from and upto parameters 
     * @param array
     * @param key
     * @param from
     * @param upto
     * @return an index where it is or should be
     */
    public int binarySearch(Number[] array, Number key, int from, int upto) {
        int size = array.length;
        int low = from; if(low < 0 || low > size) low = 0;
        int high = upto; if(high <= 0 || high > size) high = size;
        double dKey = key.doubleValue();
        
        while (low < high) {            
            int mid = (low + high) / 2; // find middle
            if (dKey < array[mid].doubleValue()) high = mid;    // Search Low half.
            else if (dKey > array[mid].doubleValue()) low = mid + 1;  // Search Top half.
            else return mid;    // Found it. return position
        }
        return -(low + 1);  // It should be here positively
    }
    
    /**
     * search a key in an array of strings. if you search in the whole array put zeros in from and upto parameters 
     * @param array
     * @param key
     * @param from
     * @param upto
     * @return an index where it is or should be
     */
    public int customBinarySearch(String[] array, int from, int upto, String key, int fromCharAt){
        int size = array.length;
        int low = from; if(low < 0 || low > size) low = 0;
        int high = upto; if(high <= 0 || high > size) high = size;
        
        while (low < high) {            
            int mid = (low + high) / 2; // find middle
            if (key.compareTo(array[mid].substring(fromCharAt)) < 0) high = mid;    // Search Low half.
            else if (key.compareTo(array[mid].substring(fromCharAt)) > 0) low = mid + 1;  // Search Top half.
            else return mid;    // Found it. return position
        }
        return -(low + 1); // It should be here positively
    }
    
    /**
     * pass in a string it will remove all the spaces and stay with individual strings
     * @param string
     * @return an array 
     */
    public String[] line2Arr(String string){
        String phrase = string + " ";
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
    

    /**
     * taking in a list and returning an array of strings
     * @param list
     * @return 
     */
    public String[] listToArray(java.util.List<String> list){
        int sz = list.size();
        String[] arr = new String[sz];
        for(int i=0 ; i<sz ; i++)arr[i] = list.get(i);
        return arr;
    }
    
    

    /**
     * taking in an array of strings and returning a list
     * @param array
     * @return 
     */
    public java.util.ArrayList<String> arrayToList(String[] array){
        int sz = array.length;
        java.util.ArrayList<String> list = new java.util.ArrayList<>();
        for(int i=0 ; i<sz ; i++) list.add(array[i]);
        return list;
    }
    
    /**/

    /**
     * adding the second array at the end of the first array
     * @param firstArray
     * @param secondArray
     * @return 
     */
    public Object[] add2array(Object[] firstArray, Object[] secondArray){
        //  Taking-in 2 arrays of strings and returning 1 array.
        //  the array is the addition of the two.
        int a = firstArray.length;  int b = secondArray.length;
        int tot = a + b;
        Object[] total = new Object[tot];
        System.arraycopy(firstArray, 0, total, 0, a);
        System.arraycopy(secondArray, 0, total, a, b);

        return total;
    }
    
}
