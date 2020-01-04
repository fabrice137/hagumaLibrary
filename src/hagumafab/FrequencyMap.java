package hagumafab;

public class FrequencyMap {
    private Object object;
    private int frequency;
    
    public FrequencyMap(Object obj){
        this.object = obj;
        this.frequency = 1;
    }
    public FrequencyMap(Object obj, int frequency){
        this.object = obj;
        this.frequency = frequency;
    }
    public void addFrequency(){ this.frequency++; }
    public void setFrequency(int freqCount){ this.frequency = freqCount; }
    public void addFrequency(Object obj){
	if(obj.equals(this.object)) this.frequency++;
    }
    public int getFrequency(){ return this.frequency; }
    public Object getObject(){ return this.object; }
    
    public boolean isObject(Object obj){ return this.object.equals(obj); }

    public static java.util.Comparator<FrequencyMap> compareByFrequency = (FrequencyMap freq1, FrequencyMap freq2) -> {
        /** SORTING IN DESCENDING ORDER ( FROM HIGH TO LOW)*/
        return freq1.frequency < freq2.frequency ? 1 : freq1.frequency > freq2.frequency ? -1 : 0;
    };    
}
/** THIS IS THE ORIGINAL THAT SORT IN ASCENDING ORDER */
/**  return freq1.frequency > freq2.frequency ? 1 : freq1.frequency < freq2.frequency ? -1 : 0;  */