package geeksForgeeks;

public class BubbleSortRecursive {

	public static void main(String[] args) {
		int arr[]={10,2,3,4,5,14,12};
		BubbleSortRecursive.bubbleRecurrisve(arr,arr.length);
		System.out.println("Reccursive call");
		printArr(arr);
		nonReccursiveBubbleSort(arr);
		System.out.println("\nNon-Reccursive call");
		printArr(arr);
	}
	
	public static void bubbleRecurrisve(int arr[],int n){
		int temp=0;
		if(n==1)
			return;
		for(int i=0;i<arr.length-1;i++){
			if(arr[i]>arr[i+1]){
				temp=arr[i];
				arr[i]=arr[i+1];
				arr[i+1]=temp;
			}
			bubbleRecurrisve(arr,n-1);
		}
		
	}
	
	public static void nonReccursiveBubbleSort(int arr[]){
		int temp=0;
		for(int i=0;i<arr.length-1;i++){
			for(int j=0;j<arr.length-i-1;j++){
				if(arr[j]>arr[j+1]){
					temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
	}
	
	public static void printArr(int arr[]){
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+",");
		}
	}
	
}
