import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class StringAnagramProblem {
    public static int numberNeeded(String first, String second) {
        
        HashMap<String,Integer> firstHashMap=new HashMap<String,Integer>();
        HashMap<String,Integer> secondHashMap=new HashMap<String,Integer>();
        createHashMap(firstHashMap,first);
        createHashMap(secondHashMap,second);
        int firstHashMapSize=firstHashMap.size();
        int secondHashMapSize=secondHashMap.size();
        //System.out.println("firstHashMapSize"+firstHashMapSize);
       // System.out.println("secondHashMapSize---"+secondHashMapSize);
        Iterator<Map.Entry<String,Integer>> itrOne=firstHashMap.entrySet().iterator();
        Iterator<Map.Entry<String,Integer>> itrtwo=secondHashMap.entrySet().iterator();
        int count=0;
        while(itrOne.hasNext()){
            Map.Entry<String,Integer> eSet=itrOne.next();
            if(!(secondHashMap.containsKey(eSet.getKey()))){
             //count++;
             count=count+Math.abs(eSet.getValue());
             itrOne.remove();                  
            }            
        }
        
           while(itrtwo.hasNext()){
            Map.Entry<String,Integer> eSet=itrtwo.next();
            if(!(firstHashMap.containsKey(eSet.getKey()))){
             //count++;
             count=count+Math.abs(eSet.getValue());
             itrtwo.remove();                  
            }            
        }
        
        Iterator<Map.Entry<String,Integer>> itrThree=firstHashMap.entrySet().iterator();
        while(itrThree.hasNext()){
           Map.Entry<String,Integer> eSet=itrThree.next();
            if(Math.abs(eSet.getValue()-secondHashMap.get(eSet.getKey()))>0){
              count=count+Math.abs(eSet.getValue()-secondHashMap.get(eSet.getKey()));                  
            }            
        }
        
       // System.out.println("firstHashMapSize after"+firstHashMap.size()+"count is"+count);
      return count;
    }
  
    
    public static void createHashMap(HashMap<String,Integer> firstHashMap,String first){
       // System.out.print("value of first is"+first);
        for(int i=0;i<first.toCharArray().length;i++)
            {
         //    System.out.println("value of first is"+String.valueOf(first.charAt(i)));
            if((firstHashMap.containsKey(String.valueOf(first.charAt(i)))))
                {
           //      System.out.println("in if");      
                firstHashMap.put(String.valueOf(first.charAt(i)),Integer.valueOf(firstHashMap.get(String.valueOf(first.charAt(i)))+1));
            }else{
             //   System.out.println("in else"); 
                firstHashMap.put(String.valueOf(first.charAt(i)),Integer.valueOf(1));
            }
        }
        //System.out.println("size is"+firstHashMap.size());
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));
    }
}
