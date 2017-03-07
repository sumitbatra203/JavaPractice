package geeksForgeeks;

public class StringCombinations {
	static String input="abcde";
	public static void main(String[] args) {
		printCombinations(input);
	}
		
	static void printCombinations(String input){
		int start=0;
		int end=input.toCharArray().length;
		char chrArr[]=input.toCharArray();
		for(int i=0;i<input.toCharArray().length;i++){
			permutationUtil(start,end,chrArr,input.charAt(i)+"");
			start++;
		}
		
		
	}
	
	public static void  permutationUtil(int start,int end,char c[],String input){
		if(start==end)
			return;
		System.out.println(input);
		for(int i=start;i<end-1;i++){
			permutationUtil(i+1,end,c,input+c[i+1]);
		}
		
	}
}
