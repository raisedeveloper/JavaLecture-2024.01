package ch06_class.sec05_melon;

import java.util.TooManyListenersException;

public class MelonMain {

	public static void main(String[] args) {
		MelonChart[] melons = new MelonChart[5];		// 기본 생성자로 객체 5개 생성, 'Setter'로 필드값을 설정
		melons[0] = new MelonChart(1, "비의 랩소디", "임재현", "비의 랩소디", 33139);
		melons[1] = new MelonChart(2, "Perfect Night", "LE SSERAFIM (르세라핌)", "Perfect Night", 94989);
		melons[2] = new MelonChart(3, "To.x", "태연 (TAEYEON)", "To. X - The 5th Mini Album", 82783);
		melons[3] = new MelonChart(4, "Drama", "aespa", "Drama - The 4th Mini Album", 68534);
		melons[4] = new MelonChart(5, "헤어지자 말해요", "박재정", "1집 Alone", 157160);

		// 필드값을 객체를 생성할 때 부여
		MelonChart[] melon2 = { new MelonChart(1, "비의 랩소디", "임재현", "비의 랩소디", 33139), 
							new MelonChart(2, "Perfect Night", "LE SSERAFIM (르세라핌)", "Perfect Night", 94989), 
							new MelonChart(3, "To.x", "태연 (TAEYEON)", "To. X - The 5th Mini Album", 82783), 
							new MelonChart(4, "Drama", "aespa", "Drama - The 4th Mini Album", 68534),
							new MelonChart(5, "헤어지자 말해요", "박재정", "1집 Alone", 157160) };
		
//		Enhanced 'for-loop': 잘 안씀 	
//		for (int i = 0; i < melons.length; i++)
//			System.out.println(melons[i]);
		for (MelonChart melon: melons)
			System.out.println(melon);
		
		// 실전에서 사용하는 코드 List + 람다함수
		List<MelonChart> list = new ArrayList<>();
		}

	}


