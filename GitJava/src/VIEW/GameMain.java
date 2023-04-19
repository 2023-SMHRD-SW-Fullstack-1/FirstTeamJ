package VIEW;

import java.util.Scanner;

public class GameMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		while(true) {
			System.out.println(">>>>>>>>>>>>>메뉴<<<<<<<<<<<<<");
			System.out.println("|    [1] 스인재 개발자 키우기     |");
			System.out.println("|    [2] 랭 킹 확 인           |");
			System.out.println("|    [3] 캐릭터 상태 확인        |");
			System.out.println("|    [4] 닉네임 변경            |");
			System.out.println("|    [5] 캐릭터 삭제            |");
			System.out.println("|    [6] 게임 종료             |");
			System.out.println(">>>>>>>>>>>>>><<<<<<<<<<<<<<<");
			System.out.print("메뉴를 골라주십시오 >> ");
			int select = sc.nextInt();
			System.out.println();
			
			if(select == 1) {
				System.out.println(">>>>>>>>>>>개발자 목록<<<<<<<<<<<");
				System.out.println("|      [1] 풀스택 개발자        |");
				System.out.println("|      [2] 데이터베이스 관리자    |");
				System.out.println("|      [3] 인공지능 개발자       |");
				System.out.println(">>>>>>>>>>>>>>><<<<<<<<<<<<<<");
				int dev = sc.nextInt();
				if(dev ==1) {
					System.out.println("￣￣￣￣￣ヽ___ノ￣￣￣￣￣￣￣￣￣\r\n"
							+ "        Ｏ\r\n"
							+ "         o\r\n"
							+ "         ,. ─冖'⌒'─､\r\n"
							+ "        ノ         ＼\r\n"
							+ "       / ,r‐へへく⌒'￢､  ヽ\r\n"
							+ "      {ノ へ._、 ,,／~`  〉 ｝\r\n"
							+ "     ／プ￣￣`y'¨Y´￣￣ヽ─}j=く\r\n"
							+ "    ノ /レ'>ー{__ｭ`ーー'  ﾘ,ｲ}\r\n"
							+ "   / _勺 ｲ;；∵r===､､∴'∵;  シ \r\n"
							+ "  ,/ └'ノ ＼  ご`    ノ{ー--､__\r\n"
							+ "  人＿_/ー┬ー个-､＿＿,,.. ‐´ 〃`ァーｧー＼\r\n"
							+ ". /  |／ |::|､      〃 /::/   ヽ\r\n"
							+ "/    |  |::|＼､_________／/::/〃    |");
				}if(dev ==2) {
					System.out.println("\r\n"
							+ "\r\n"
							+ "       ,~-.$$;      \r\n"
							+ "      !~  .  ~:     \r\n"
							+ "      @      .;     \r\n"
							+ "      #.;;.,!*,     \r\n"
							+ "     !#   .  @;     \r\n"
							+ "     :# :  : @:     \r\n"
							+ "      @      ~      \r\n"
							+ "      .*    ;       \r\n"
							+ "       $$ ~#!       \r\n"
							+ "    -==! :, ===-    \r\n"
							+ "   :-  -!==:-  -:   \r\n"
							+ "  .~ #$$$!!$$$# ;   \r\n"
							+ "  ;, ;        ; -~  \r\n"
							+ "  @@@;   @@   ;@@@  \r\n"
							+ " :   ;   $#   ;  -  \r\n"
							+ " *@@@;        ;@@@= \r\n"
							+ ":,   ;:::::::::   ,:\r\n"
							+ "$     ........     $\r\n"
							+ "#;!;;;;;;-:!!!!!!!;#\r\n"
							+ "#$$$$$$$$$$$$$$$$$$@\r\n"
							+ "");
				}
				
			}else if(select ==2) {
				System.out.println("랭킹 확인");
			}else if(select==3) {
				System.out.println("캐릭터 상태 확인");
			}else if(select==4) {
				System.out.println("닉네임 변경");
			}else if(select==5) {
				System.out.println("캐릭터 삭제");
			}else {
				System.out.println("게임 종료");
				break;
			}
		}
		
		
			
			
		
		

	}

}
