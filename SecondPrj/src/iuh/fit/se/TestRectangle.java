package iuh.fit.se;

	import java.util.Scanner;
/**
 * @description: This class tests the Rectangle class by creating an instance,
 * reading length and width from user inputsss, and displaying therectangle's details,
 * area, and perimeter.
 * @author: Dang Van Ninh
 * @version: 1.0
 * @created: 30 thg 8, 2025 00:00:37
 */
	public class TestRectangle {
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        System.out.print("Enter length: ");
	        double length = scanner.nextDouble();
	        System.out.print("Enter width: ");
	        double width = scanner.nextDouble();
	        Rectangle rectangle = new Rectangle(length, width);
	        System.out.println(rectangle.toString());
	        scanner.close();
	    }
	}

