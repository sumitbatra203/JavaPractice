import java.util.*;

public class RansomNoteHackerRank {
    Map<String, Integer> magazineMap;
    Map<String, Integer> noteMap;
    
    public Solution(String magazine, String note) {
        magazineMap=new HashMap<String, Integer>();
        noteMap=new HashMap<String, Integer>();
        String strArr1[]=magazine.split(" ");
        String strArr2[]=note.split(" ");
            
            for(int i=0;i<strArr1.length;i++)
            {
            if(magazineMap.containsKey(strArr1[i])){
            magazineMap.put(strArr1[i],Integer.valueOf((magazineMap.get(strArr1[i])+1)));
            }else{
            magazineMap.put(strArr1[i],Integer.valueOf(1));
            }
            }
        
            for(int i=0;i<strArr2.length;i++)
            {
            if(noteMap.containsKey(strArr2[i])){
            noteMap.put(strArr2[i],Integer.valueOf((noteMap.get(strArr2[i])+1)));
            }else{
            noteMap.put(strArr2[i],Integer.valueOf(1));
            }
            }
         //   System.out.println("hashmap initialized");
        
        
    }
    
    public boolean solve() {
        
        Iterator<Map.Entry<String,Integer>> itr=noteMap.entrySet().iterator();
        while(itr.hasNext()){
            Map.Entry<String,Integer> es=itr.next();
            if(!(magazineMap.containsKey(es.getKey()) && magazineMap.get(es.getKey())>=es.getValue())){
                return false;
            }
            }        
        return true;
        }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        
        // Eat whitespace to beginning of next line
        scanner.nextLine();
        
        Solution s = new Solution(scanner.nextLine(), scanner.nextLine());
        scanner.close();
        
        boolean answer = s.solve();
        if(answer)
            System.out.println("Yes");
        else System.out.println("No");
      
    }
}
