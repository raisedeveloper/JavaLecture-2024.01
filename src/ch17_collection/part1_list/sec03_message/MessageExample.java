package ch17_collection.part1_list.sec03_message;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ch18_io.sec11_message.Ex.Message;

public class MessageExample {

   public static void main(String[] args) {
      List<Message> list = new ArrayList<>();

      // 객체 추가
      Message message = new Message(1, "Hello", "James", LocalDateTime.now(), 0);
      list.add(message);
      list.add(new Message(2, "world", "maria", LocalDateTime.now(), 0));
      for (Message m : list)
         System.out.println(m);
      
      
      for (int i = 1; i <= 3; i++) {
    	  Message msg = new Message(2+i, "내용"+i, "저자"+i, LocalDateTime.now(), 0);
    	  list.add(msg);
      }
      for (Message m: list) 
    	  System.out.println(m);	
      
      list = generateMessage();
      for (Message m: list) 
    	  System.out.println(m);	

      // 이름이 3글자 이상인 사람의 글
   
      List<Message> newList = new ArrayList<Message>();	//==|
      for (Message msg: list) { 							//검색 뽑는 법 / 검색 쉬워지는 법
    	  if (msg.getWriter().length() >= 3);			//==|
    		  
      }
      for (Message m: newList)
    	  System.out.println(m);
   
   }
   
      // ♥♥♥ 반복문에서 개체를 추구하고 싶으면 시작 시 빈리스트를 먼저 만들어 주고 ♥♥♥
      // ♥♥♥ for-loop 안에서 객체를 만들어서 밖깥쪽 리스트에 추가하는 방법이 기본이다 _ 암기해야 함 ♥♥♥
      
      // 메세지 객체를 3개 생성해서 리스트로 반환하는 방법
      static List<Message> generateMessage() { 		// 리턴 타입 _ return 안 쓰면 빨간 줄 뜸
    	  List<Message> list = new ArrayList<Message>();
    	  Scanner scan = new Scanner(System.in);
    	  for (int i = 1; i <= 3; i++) {
    		  System.out.println("저자> ");
    		  String writer = scan.nextLine();
    		  System.out.println("내용> ");
    		  String content = scan.nextLine();
    		  Message msg = new Message(i, content, writer, LocalDateTime.now(),0);
    		  list.add(msg);
    		  
    	  }
    	  return list;
      }
   }