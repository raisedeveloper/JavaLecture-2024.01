package ch06_class.sec05_melon;

public class MelonMain {

	public static void main(String[] args) {
		Melon[] melons = new Melon[5];		// 객체 5개 생성
		melons[0] = new Melon(1, "비의 랩소디", "임재현", "비의 랩소디", 33139);
		melons[1] = new Melon(2, "Perfect Night", "LE SSERAFIM (르세라핌)", "Perfect Night", 94989);
		melons[2] = new Melon(3, "To.x", "태연 (TAEYEON)", "To. X - The 5th Mini Album", 82783);
		melons[3] = new Melon(4, "Drama", "aespa", "Drama - The 4th Mini Album", 68534);
		melons[4] = new Melon(5, "헤어지자 말해요", "박재정", "1집 Alone", 157160);

		Melon[] melon2 = { new Melon(1, "비의 랩소디", "임재현", "비의 랩소디", 33139), 
							new Melon(2, "Perfect Night", "LE SSERAFIM (르세라핌)", "Perfect Night", 94989), 
							new Melon(3, "To.x", "태연 (TAEYEON)", "To. X - The 5th Mini Album", 82783), 
							new Melon(4, "Drama", "aespa", "Drama - The 4th Mini Album", 68534),
							new Melon(5, "헤어지자 말해요", "박재정", "1집 Alone", 157160) };
		
//		Enhanced 'for-loop': 잘 안씀 	
//		for (int i = 0; i < melons.length; i++)
//			System.out.println(melons[i]);
		for (Melon melon: melons)
			System.out.println(melon);
		}

	}


