package ch02_type;

import java.io.IOException;
import java.util.Scanner;

public class Ex04_input {

	public static void main(String[] args) throws IOException {
		// 하나의 문자를 읽을 때 사용하나, 빈번하게 사용되지 않음 (캐릭터를 입력받을 때 사용)
//		int keyCode = System.in.read();				// '5'
//		System.out.println("keyCode: " + keyCode);	// 0x35 => 3 * 16 + 5 = 53
		
		try (Scanner scan = new Scanner(System.in)) {
			System.out.print("입력하세요> ");
			String inputText = scan.nextLine();	// Enter 칠 때까지의 문자열을 읽어줌
			System.out.println(inputText);
		}
	}

}
