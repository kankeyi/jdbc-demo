package _homework;

import java.util.Scanner;

public class _scanner {
	
	public static void main(String[] args) {
		double a, b;

		System.out.print("請輸入身高:");
		Scanner c = new Scanner(System.in);
		double e = c.nextDouble() / 100;

		System.out.print("請輸入體重:");
		Scanner d = new Scanner(System.in);
		double bmi = d.nextDouble() / (e * e);

		System.out.printf("您的BMI值為：%.2f\n", bmi);
	}
}