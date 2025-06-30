package Practice;

public class GenericMethods {
	/**
	 * This is generic utilities
	 * @author ravik
	 * @param args
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int answer = add(80,80);
		System.out.println(answer); 
		System.out.println(add(8,0));
		System.out.println(add(answer,70));
		System.out.println(add(56,90)) ;
		System.out.println(add(67,answer));
		
		System.out.println("____________");

		 int answer2 = sub(30,20);
		 System.out.println(answer2);
		 System.out.println(sub(100,40));
		 System.out.println(sub(100,answer2));
		 System.out.println(sub(answer,60));
		
			System.out.println("____________");
			
			int answer3 = div(400,2);
		System.out.println(answer3);
		 System.out.println(div(answer,40));
		 System.out.println(div(100,answer2));
		 System.out.println(div(answer3,60));
		
	}
	public static int add(int a, int b) {
		int c= a+b;
		return c;
	}
	
	public static int sub (int a, int b) {
		int c= a-b;
		return c;
	}
	
	public static int div (int a , int b) {
		int c= a/b;
		return c;
	}
}
