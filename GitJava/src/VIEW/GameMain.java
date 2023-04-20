package VIEW;

<<<<<<< HEAD
import java.util.Scanner;
=======
import java.util.ArrayList;
import java.util.Scanner;

import Controller.CharDAO;
import Controller.GameDAO;
import Controller.UserDAO;
import MODEL.CharVO;
>>>>>>> branch 'master' of https://github.com/2023-SMHRD-SW-Fullstack-1/FirstTeamJ.git

public class GameMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
<<<<<<< HEAD
		
		
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
		
		
			
			
		
		
=======
		UserDAO udao = new UserDAO();

		int choice = 0;
		while (true) {

			System.out.println("==== 스인재 개발자 키우기 ====");
			System.out.println("메뉴선택 [1]회원가입 [2]로그인 [3]게임설명 [4]회원탈퇴 [5]게임종료 >> ");
			choice = sc.nextInt();
			if (choice == 1) {
				System.out.println("=== 회원가입 ===");
				System.out.println("id입력 >> ");
				String inputId = sc.next();
				System.out.println("pw입력 >> ");
				String inputPw = sc.next();
				System.out.println("닉네임 입력 >> ");
				String inputNick = sc.next();
				udao.join(inputId, inputPw, inputNick);
				System.out.println("회원가입 성공!");

			} else if (choice == 2) {
				System.out.println("=== 로그인 ===");
				System.out.println("id입력 >> ");
				String inputId = sc.next();
				System.out.println("pw입력 >> ");
				String inputPw = sc.next();
				udao.login(inputId, inputPw);
				System.out.println("로그인 성공!");
				startGame(udao.login(inputId, inputPw));

			} else if (choice == 3) {
				System.out.println("=== 게임 설명 ===");
			} else if (choice == 4) {
				System.out.println("=== 회원탈퇴 ===");

			} else if (choice == 5) {
				System.out.println("게임종료");
				break;
			} else {
				System.out.println("올바른 번호를 입력하세요.");
			}

		}
>>>>>>> branch 'master' of https://github.com/2023-SMHRD-SW-Fullstack-1/FirstTeamJ.git

	}

	public static void startGame(String nick) {
		GameDAO gdao = new GameDAO();
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("메뉴 선택 >> [1] 스인재 개발자 키우기 [2] 랭킹 확인 [3] 캐릭터 상태 확인 [4] 닉네임 변경 [5] 캐릭터 삭제 [6] 게임종료");
			int choice = sc.nextInt();
			if (choice == 1) {
				System.out.println("====== 스인재 개발자 키우기 ======");
				
				boolean sw = false;
				
				System.out.println(gdao.userCharList());
				
				if(gdao.userCharList().size()==0) {
					makeChar(nick);
				}

				for (int i = 0; i < gdao.userCharList().size(); i++) {
					if (gdao.userCharList().get(i).getNick().equals(nick)) {
						System.out.println();
						gdao.callChar(nick);

						System.out.println("====== 캐릭터 상태 확인 ======");

						int userExp = gdao.charGauge(nick).get(0);
						int userStress = gdao.charGauge(nick).get(1);
						int userHp = gdao.charGauge(nick).get(2);

						System.out.printf("EXP : %d  STRESS : %d  HP : %d\n", userExp, userStress, userHp);
						break;
					}else {
						sw = true;
					}
				}
				
				if(sw) {
					makeChar(nick);
				}
				
				raise(nick);
				
				
				
			} else if (choice == 2) {
				System.out.println("====== 랭킹 확인 ======");
				for (int i = 0; i < gdao.rank().size(); i++) {
					CharVO temp = gdao.rank().get(i);
					String userNick = temp.getNick();
					int userExp = temp.getExp();
					int userStress = temp.getStress();
					int userHp = temp.getHp();

					System.out.printf("닉네임 : %s  EXP : %d  STRESS : %d  HP : %d\n", userNick, userExp, userStress,
							userHp);
				}

			} else if (choice == 3) {
				System.out.println("====== 캐릭터 상태 확인 ======");

				int userExp = gdao.charGauge(nick).get(0);
				int userStress = gdao.charGauge(nick).get(1);
				int userHp = gdao.charGauge(nick).get(2);

				System.out.printf("EXP : %d  STRESS : %d  HP : %d\n", userExp, userStress, userHp);

			} else if (choice == 4) {
				System.out.println("====== 닉네임 변경 ======");

			} else if (choice == 5) {
				System.out.println("====== 캐릭터 삭제 ======");

			} else if (choice == 6) {
				System.out.println("게임 종료");
				break;

			} else {
				System.out.println("올바른 번호를 입력하세요.");
			}
		}

	}

	public static void raise(String nick) {
		CharDAO cdao = new CharDAO();
		GameDAO gdao = new GameDAO();
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		while (true) {
			System.out.println("==== 행동 선택 ====");
			System.out.println("[1]출근하기 [2] 수업듣기 [3] 팀프로젝트 ");
			System.out.println("[4]코딩테스트 [5] 자격증공부 [6] 예습 복습 ");
			System.out.println("[7]점심시간 [8] 집에가기 [9] 월요일 5시 퇴근 ");
			System.out.println("[10]수업시간에 졸기 [11] 주말에 쉬기 [12] 커피마시기 [0] 그만하기 ");
			choice = sc.nextInt();

			if (choice == 1) {
				cdao.goSmhrd(nick);
			} else if (choice == 0) {
				break;
			} else if (choice == 2) {
				cdao.listeningClass(nick);
			} else if (choice == 3) {
				cdao.teamProject(nick);
			} else if (choice == 4) {
				cdao.codingTest(nick);
			} else if (choice == 5) {
				cdao.studyCertificate(nick);
			} else if (choice == 6) {
				cdao.selfEdu(nick);
			} else if (choice == 7) {
				cdao.lunchTime(nick);
			} else if (choice == 8) {
				cdao.goHome(nick);
			} else if (choice == 9) {
				cdao.monday(nick);
			} else if (choice == 10) {
				cdao.snooze(nick);
			} else if (choice == 11) {
				cdao.weekend(nick);
			} else if (choice == 12) {
				cdao.coffee(nick);
			}

			System.out.println("====== 캐릭터 상태 확인 ======");

			int userExp = gdao.charGauge(nick).get(0);
			int userStress = gdao.charGauge(nick).get(1);
			int userHp = gdao.charGauge(nick).get(2);

			System.out.printf("EXP : %d  STRESS : %d  HP : %d\n", userExp, userStress, userHp);
		}

	}

	public static void makeChar(String nick) {
		Scanner sc = new Scanner(System.in);
		GameDAO gdao = new GameDAO();

		System.out.println("개발자 선택 >> [1]풀스택 개발자 [2]데이터베이스 관리자 [3]인공지능 개발자");
		int choice = sc.nextInt();
		gdao.creationChar(nick, choice);

		if (choice == 1) {
			gdao.creationChar(nick, choice);
			System.out.println("풀스택개발자 생성 완료!");
		} else if (choice == 2) {
			gdao.creationChar(nick, choice);
			System.out.println("데이터베이스 관리자 생성 완료!");
		} else if (choice == 3) {
			gdao.creationChar(nick, choice);
			System.out.println("인공지능 개발자 생성 완료!");
		}

		System.out.println("====== 캐릭터 상태 확인 ======");

		int userExp = gdao.charGauge(nick).get(0);
		int userStress = gdao.charGauge(nick).get(1);
		int userHp = gdao.charGauge(nick).get(2);
		System.out.println(nick);
		System.out.printf("EXP : %d  STRESS : %d  HP : %d\n", userExp, userStress, userHp);
	}
}
