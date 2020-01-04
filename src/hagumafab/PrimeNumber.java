
package hagumafab;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumber {
    
    
    public boolean isNumberPrime(long num){
        return isPrime(num);
    }
    
    public long nextPrime(long next){
        if (next >= Long.MAX_VALUE) return Long.MAX_VALUE;
        next++;
        while (!isPrime(next)){
            next++;
            if (next >= Long.MAX_VALUE) return Long.MAX_VALUE;
        } return next;
    }
    
    public long previousPrime(long prev){
        if (prev <= 2) return 2;
        prev--;
        while (!isPrime(prev)){
            prev--;
            if (prev <= 2) return 2;
        } return prev;
    }
    

    /**
     *
     * @param number
     * @return List of found primes
     */

    public java.util.List<Long> listOfPrimes(long number){
        return primeList(number);
    }
    
    /**
     * 
     * @param low
     * @param high
     * @return List of found primes
     */
    public java.util.List<Long> listOfPrimes(long low, long high){
        return primeList(low, high);
    }
    
    
    private static java.util.List<Long> primeList(long number){
        java.util.ArrayList<Long> list = new java.util.ArrayList<>();
        int end = 1;
        list.add(new Long(2));  list.add(new Long(3));
        long count = 5; 
        while (count <= number) {            
            boolean isprime = true;
            if((end * end) < count) end++;
            for(int i=0 ; i<end && list.get(i) <= end; i++){
                if (count % list.get(i) == 0) {
                    isprime = false;
                    break;
                }
            }
            if (isprime) list.add(count);
            count += 2;
        } return list;
    }
    private static java.util.List<Long> primeList(long start, long finish){
        int end = (int) (1 + Math.sqrt(start));
        long count = start;  
        /** LIST OF PRIMES UP TO SQRT OF FINISH FOR TO QUICKEN PRIME CHECK */
        List<Long> list = primeList((long) (1 + Math.sqrt(finish)));
        ArrayList<Long> toReturnPrimeList = new ArrayList<>();
        
        if(list.get(list.size() -1) > start){  
            /* IF THE LAST IN LIST IS GREATER THAN START, ADD THEM  */
            int startCopy = SearchStart(list, start);
            for(int i=startCopy ; i<list.size() ; i++)
                toReturnPrimeList.add(list.get(i));
            count = 1 + toReturnPrimeList.get(toReturnPrimeList.size() -1);
            /* NOW COUNT BEGINS AT THE LAST ITEM + 1 */
        }
        if(count %2 == 0) count++;
        
        /* REGULAR PRIME CHECKING */
        while (count <= finish) {            
            boolean isprime = true;
            if((end * end) < count) end++;
            for(int i=0 ; (i<end && list.size() > i )&& list.get(i) <= end; i++){
                if (count % list.get(i) == 0) {
                    isprime = false;
                    break;
                }
            }
            if (isprime) toReturnPrimeList.add(count);
            count += 2;
        }
        return toReturnPrimeList;
    }
    private static int SearchStart(List<Long> list, long key){
        for (int i=0 ; i<list.size() ; i++) if (key <= list.get(i)) return i;
        return 0;
    }
    
    private static boolean isPrime(long num){
        if (num < 2) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;
        long end = (long) (1 + Math.sqrt(num)); 
        for (long i = 3 ; i < end ; i+=2) if(num % i == 0) return false ;
        return true;
    }
    
}
