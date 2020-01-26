
public class Fibo {

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			System.out.print(fibonacci(i)+" ");
		}
		System.out.println();
		fibonacci2Driver(10);
	}

	public static int fibonacci(int n) {

		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		return fibonacci(n - 1) + fibonacci(n - 2);

	}
	
	static int n1 = 0, n2 = 1, sum = 0;
	
	static void fibonacci2Driver(int count) {
		if(count >= 1 ) {
			System.out.print(0 + " ");
		}
		if(count >= 2 ) {
			System.out.print(1 + " ");
		}
		if(count > 2) {
			fibonacci2(count- 2);
		}
		if(count <= 0) {
			throw new RuntimeException("invalid input");
		}
		
		
	}
	
	static void fibonacci2(int count) {
		if (count > 0) {
			sum = n1 + n2;
			n1 = n2;
			n2 = sum;
			System.out.print(sum + " ");
			fibonacci2(count - 1);
		}
	}

}

