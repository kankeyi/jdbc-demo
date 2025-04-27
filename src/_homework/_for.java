package _homework;

public class _for {
	public static void main(String[] args) {
		int rows = 6;
		for (int i = 0; i < rows; i++) {
			for (int a = 0; a < (rows - i - 1); a++) {
				System.out.print(" ");
			}
			for (int a = 0; a < (2 * i + 1); a++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}