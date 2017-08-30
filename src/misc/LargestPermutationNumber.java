package misc;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

class MyComparator implements Comparator<Number>{

	@Override
	public int compare(Number o1, Number o2) {
       String str1 = o1.toString() + o2.toString();
       String str2 = o2.toString() + o1.toString();
	   if(str1.compareTo(str2) > 0)
		   return -1;
	   else
		   return 1;
	}


}

public class LargestPermutationNumber {
	public static void main(String args[]) {
     Scanner scanner = new Scanner(System.in);
     LinkedList<Integer> number = new LinkedList<>();
     while(scanner.hasNext()){
    	 int input = scanner.nextInt();
    	 if(input == -1)
    		 break;
    	 number.add(input);
     }
     Collections.sort(number, new MyComparator());
     for(int i = 0 ; i < number.size(); i++){
    	System.out.print(number.get(i));
     }
	}
	
	

}
