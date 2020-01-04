/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hagumafab;

import java.util.Map;

/**
 *
 * @author fabruz
 */
public class FrequentClass {
    private java.util.Map<Object, Integer> theMap = new java.util.LinkedHashMap<>();
    
    public void addToMap(Object newObject){
        if (this.theMap.containsKey(newObject)) {
            int previousFrequency = this.theMap.get(newObject);
            this.theMap.replace(newObject, previousFrequency + 1);
        }
        else{
            this.theMap.put(newObject, 1);
        }
    }
    public void addToMap(Object newObject, int newFrequency){
        if (this.theMap.containsKey(newObject)) {
            this.theMap.replace(newObject, newFrequency);
        } else
            this.theMap.put(newObject, newFrequency);
    }
    public int getFrequency(Object object){
        if (this.theMap.containsKey(object)) {
            return this.theMap.get(object);
        } return 0;
    }
    public void getObjectOrdered(){ 
       java.util.List<Map.Entry<Object, Integer>> list = new java.util.ArrayList<>(this.theMap.entrySet());
       list.sort(Map.Entry.comparingByValue());
       
       Map<Object, Integer> result = new java.util.LinkedHashMap<>();
       list.forEach((entry) -> {
            result.put(entry.getKey(), entry.getValue());
        });
    }
    /*  THIS IS NOT FINNISHED  */  /*  THIS IS NOT FINNISHED  */  /*  THIS IS NOT FINNISHED  */
    /*  THIS IS NOT FINNISHED  */  /*  THIS IS NOT FINNISHED  */  /*  THIS IS NOT FINNISHED  */
    /*  THIS IS NOT FINNISHED  */  /*  THIS IS NOT FINNISHED  */  /*  THIS IS NOT FINNISHED  */
    /*  THIS IS NOT FINNISHED  */  /*  THIS IS NOT FINNISHED  */  /*  THIS IS NOT FINNISHED  */
    /*  THIS IS NOT FINNISHED  */  /*  THIS IS NOT FINNISHED  */  /*  THIS IS NOT FINNISHED  */
    
    
}
// java.util.Collections.sort(fMapList, FrequencyMap.compareByFrequency);
class Frequence{
    private Object object;
    private int frequency;
    
    public Frequence(Object obj){
        this.object = obj;
        this.frequency = 1;
    }
    public Frequence(Object obj, int frequency){
        this.object = obj;
        this.frequency = frequency;
    }
    public void incrementFrequency(){ this.frequency++; }
    public void setFrequency(int freqCount){ this.frequency = freqCount; }
    public void addFrequency(Object obj){
	if(obj.equals(this.object)) this.frequency++;
    }
    public int getFrequency(){ return this.frequency; }
    public Object getObject(){ return this.object; }
    
    public boolean isObject(Object obj){ return this.object.equals(obj); }

    public static java.util.Comparator<Frequence> compareByFrequency = (Frequence freq1, Frequence freq2) -> {
        /** SORTING IN DESCENDING ORDER ( FROM HIGH TO LOW)*/
        return freq1.frequency < freq2.frequency ? 1 : freq1.frequency > freq2.frequency ? -1 : 0;
    }; 
    
    /*
    private static <K, V> Map<K, V> sortByValue_NOLamda(Map<K, V> map) {
        java.util.List<Map.Entry<K, V>> list = new java.util.LinkedList<>(map.entrySet());
        java.util.Collections.sort(list, new java.util.Comparator<Object>() {
            @SuppressWarnings("unchecked")
            @Override
            public int compare(Object o1, Object o2) {
                return ((Comparable<V>) ((Map.Entry<K, V>) (o1)).getValue()).compareTo(((Map.Entry<K, V>) (o2)).getValue());
            }
        });

        Map<K, V> result = new java.util.LinkedHashMap<>();
        for (java.util.Iterator<Map.Entry<K, V>> it = list.iterator(); it.hasNext();) {
            Map.Entry<K, V> entry = (Map.Entry<K, V>) it.next();
            result.put(entry.getKey(), entry.getValue());
        }

        return result;
    }
    */
    
    
}
