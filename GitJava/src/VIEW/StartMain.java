package VIEW;

import java.util.ArrayList;
import java.util.Scanner;

import Controller.CharDAO;
import Controller.GameDAO;
import Controller.UserDAO;
import MODEL.CharVO;

public class StartMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		UserDAO uDAO = new UserDAO();
		CharDAO cDAO = new CharDAO();
		GameDAO gDAO = new GameDAO();


		gameStart();
		sc.nextLine();

		int choice;

		while (true) {
			System.out.println();
			System.out.println();
			System.out.println("                   ㅡㅡㅡㅡㅡㅡㅡㅡ-ㅡㅡㅡㅡㅡㅡㅡㅡㅡ-ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ-ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
			System.out.println("                  |                         스인개 개발자 키우기               [-][ㅁ][x] |");
			System.out.println("                   ㅡㅡㅡㅡㅡㅡㅡㅡ-ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ-ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ-ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
			System.out.println("                  |    [1] 회원가입   [2] 로그인  [3] 게임설명  [4] 회원탈퇴   [5] 게임종료    | ");
			System.out.println("                   ㅡㅡㅡㅡㅡ-ㅡㅡㅡ-ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ-ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
			System.out.print("                                              메뉴 선택    >>  "); choice = sc.nextInt();
			System.out.println("                   ㅡㅡㅡㅡㅡㅡㅡㅡ-ㅡㅡㅡㅡㅡㅡ-ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ-ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ"); 


			if (choice == 1) { // 회원가입
				System.out.println("                  |                             Sign Up                               |");
				System.out.println("                   ㅡㅡㅡㅡㅡㅡㅡㅡ-ㅡㅡㅡㅡㅡㅡ-ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ-ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ\n");
				
				String inputId = inputId();
				String inputPw = inputPw();
				
				System.out.print("                                            NICK : ");
				String inputNick = sc.next();

				int result = uDAO.join(inputId, inputPw, inputNick);
				if(result >0) {
					System.out.println("\n                   WELCOME  WELCOME    가입 성공!  "+inputNick+"님 환영합니다!     WELCOME  WELCOME ");
				}

				//DB에 ID/PW 저장

			} else if (choice == 2) { // 로그인
				System.out.println("                  |                              LOG-IN                              |");
				System.out.println("                   ㅡㅡㅡㅡㅡㅡㅡㅡ-ㅡㅡㅡㅡㅡㅡ-ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ-ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ\n");
				String inputId = inputId();
				String inputPw = inputPw();

				String nick = uDAO.login(inputId, inputPw);

				if(nick != null) {
					System.out.println("\n                   WELCOME     WELCOME   "+nick + "님이 로그인 하셨습니다!    WELCOME    WELCOME");
					System.out.println();

					boolean inputError = false;
					boolean firstTry = true;
					while(firstTry == true || inputError == true) {
						System.out.println("                   ㅡㅡㅡㅡㅡㅡㅡㅡ-ㅡㅡㅡㅡㅡㅡㅡㅡㅡ-ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ-ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
						System.out.println("                  |                           메인 메뉴                      [-][ㅁ][x] |");
						System.out.println("                   ㅡㅡㅡㅡㅡㅡㅡㅡ-ㅡㅡㅡㅡㅡㅡㅡㅡㅡ-ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ-ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
						System.out.println("                  |  [1]스인재 개발자 키우기 [2]캐릭터 조회  [3]닉네임 변경  [4]랭킹확인  [5]캐릭터 삭제  [6]게임종료 | ");
						System.out.println("                   ㅡㅡㅡㅡㅡㅡㅡㅡ-ㅡㅡㅡㅡㅡㅡㅡㅡㅡ-ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ-ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
						System.out.print("                                           메뉴 선택    >>  "); choice = sc.nextInt();
						System.out.println("                   ㅡㅡㅡㅡㅡㅡㅡㅡ-ㅡㅡㅡㅡㅡㅡㅡㅡㅡ-ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ-ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");

						if(choice == 1) { //스인재 개발자 키우기
							
							if(uDAO.checkNickDuplication(nick)) continue;
							
							if(gDAO.userCharList().size()==0) {
								makeChar(nick);
							}

							System.out.println("                   ㅡㅡㅡㅡㅡㅡㅡㅡ-ㅡㅡㅡㅡㅡㅡㅡㅡㅡ-ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ-ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
							System.out.println("                  |                         캐릭터 생성                       [-][ㅁ][x] |");
							System.out.println("                   ㅡㅡㅡㅡㅡㅡㅡㅡ-ㅡㅡㅡㅡㅡㅡㅡㅡㅡ-ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ-ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
							System.out.println("                  |   [1] 풀스택 개발자     [2] 데이터베이스 관리자     [3] 인공지능 개발자      | ");
							System.out.println("                   ㅡㅡㅡㅡㅡㅡㅡㅡ-ㅡㅡㅡㅡㅡㅡㅡㅡㅡ-ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ-ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
							System.out.print("                                            메뉴 선택    >>  "); choice = sc.nextInt();
							System.out.println("                   ㅡㅡㅡㅡㅡㅡㅡㅡ-ㅡㅡㅡㅡㅡㅡㅡㅡㅡ-ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ-ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");

							if (choice == 1) { // 풀스택 개발자 플레이
								gDAO.creationChar(nick); 
								artFullStack();
								playMenu(nick);
							} else if (choice == 2) { // 데이터베이스 관리자 플레이
								gDAO.creationChar(nick); 
								artDB();
								playMenu(nick);
							} else if (choice == 3){ // 인공지능 개발자 플레이
								gDAO.creationChar(nick); 
								artAI();
								playMenu(nick);
							} else {
								inputError = true;
								System.out.println("잘못된 입력입니다. 첫 화면으로 돌아갑니다.");
								continue;
							}

						}else if(choice == 2){ //게임플레이
							
							if(gDAO.existNickYn(nick).equals("N")) {
				                System.out.println("\n                                    캐릭터 생성이 필요합니다..");
								continue;
							}
							
							playMenu(nick);
							
						}else if(choice == 3) { //캐릭터 조회
							
							if(gDAO.existNickYn(nick).equals("N")) {
				                System.out.println("\n                                    캐릭터 생성이 필요합니다..");
								continue;
							}
							
							ArrayList<Integer> charGauge = gDAO.charGauge(nick);

							System.out.println(nick + " =========> "
									+ "Exp : " + charGauge.get(0)
									+ " / Stress : " + charGauge.get(1)
									+ " / Hp : " + charGauge.get(2));

						}else if(choice == 4) { //닉네임변경
							System.out.println("                  |                 ID와 변경할 새로운 닉네임을 입력해주세요                  |");
							System.out.println("                   ㅡㅡㅡㅡㅡㅡㅡㅡ-ㅡㅡㅡㅡㅡㅡ-ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ-ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ\n");
							System.out.print("                                             ID : ");
							inputId = sc.next();
							System.out.print("                                           New_Nick : ");
							String newNick = sc.next();
							int result = uDAO.updateNick(inputId, newNick);

						}else if(choice == 5) { //랭킹확인
							//                   String nickName = sc.next();

							ArrayList<CharVO> charList = gDAO.rank();

							for(int i=0; i<charList.size(); i++) {
								System.out.println(charList.get(i).getNick()+" / "+charList.get(i).getExp());
							}

						}else if(choice == 6){ //캐릭터삭제     //USER_NICK 컬럼밖에 없음
							inputId = inputId();
							inputPw = inputPw();
							gDAO.deleteChar(inputId, inputPw);
						}else {

						}
					}
				}else {
					//               System.out.println("\n   Not_Found   일치하는 회원정보가 없습니다. 다시 로그인해주세요      Not_Found  \n");
					continue;
				}

				//            
			} else if (choice == 3) { // 게임설명
				gameIntroduce();
				choice = sc.nextInt();
				if(choice == 1) {
					continue;
				}else {
					System.out.println("\n                    bye bye bye bye  bye bye  게임을  종료합니다   bye bye bye bye bye bye\n");
					break;
				}

				//         } else if (choice == 4) { // 게임종료
				//            System.out.println("\n                    bye bye bye bye bye bye  게임을  종료합니다   bye bye bye bye bye bye\n");
				//            break;
				//            
			} else if (choice == 4) { // 회원탈퇴
				System.out.println("                  |                    탈퇴 하실 ID / PW 를 입력해주세요                   |");
				System.out.println("                   ㅡㅡㅡㅡㅡㅡㅡㅡ-ㅡㅡㅡㅡㅡㅡ-ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ-ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ\n");
				String inputId = inputId();
				String inputPw = inputPw();
				int result = uDAO.deleteUser(inputId, inputPw);

			}else if (choice == 5) { // 게임종료
				System.out.println("\n                    bye bye bye bye bye bye  게임을  종료합니다   bye bye bye bye bye bye\n");
				break;

			} else {
				System.out.println();
				System.out.print("                    error   error   error  메뉴를 다시 선택해주세요 error   error   error");
				System.out.println();
				continue;
			}
		} //main 끝
	}

	public static void game() {
		System.out.println("GAME START");
		System.out.println("풀스택 개발자 키우기");
	}

	public static void gameStart() {
		System.out.println("\r\n"
				+ " ____  ____  ____  ____  ____  ____  ____  _________  ____  ____  ____  ____  ____  ____  ____  ____  ____  \r\n"
				+ "||S ||||M ||||H ||||R ||||D ||||  ||||  ||||       ||||  ||||  ||||  ||||  ||||  ||||  ||||  ||||  ||||  ||\r\n"
				+ "||__||||__||||__||||__||||__||||__||||__||||_______||||__||||__||||__||||__||||__||||__||||__||||__||||__||\r\n"
				+ "|/__\\||/__\\||/__\\||/__\\||/__\\||/__\\||/__\\||/_______\\||/__\\||/__\\||/__\\||/__\\||/__\\||/__\\||/__\\||/__\\||/__\\|\r\n");

		System.out.println(
				".______           ___       __       _______. __  .__   __.   _______     \r\n"
						+ "|   _  \\         /   \\     |  |     /       ||  | |  \\ |  |  /  _____|  \r\n"
						+ "|  |_)  |       /  ^  \\    |  |    |   (----`|  | |   \\|  | |  |  __     \r\n"
						+ "|      /       /  /_\\  \\   |  |     \\   \\    |  | |  . `  | |  | |_ |   \r\n"
						+ "|  |\\  \\----. /  _____  \\  |  | .----)   |   |  | |  |\\   | |  |__| |   \r\n"
						+ "| _| `._____|/__/     \\__\\ |__| |_______/    |__| |__| \\__|  \\______|    \r\n"
						+ "                                                                              \r\n"
						+ " _______   _______ ____    ____  _______  __        ______   .______    _______ .______           _______.\r\n"
						+ "|       \\ |   ____|\\   \\  /   / |   ____||  |      /  __  \\  |   _  \\  |   ____||   _  \\         /       |\r\n"
						+ "|  .--.  ||  |__    \\   \\/   /  |  |__   |  |     |  |  |  | |  |_)  | |  |__   |  |_)  |       |   (----`\r\n"
						+ "|  |  |  ||   __|    \\      /   |   __|  |  |     |  |  |  | |   ___/  |   __|  |      /         \\   \\    \r\n"
						+ "|  '--'  ||  |____    \\    /    |  |____ |  `----.|  `--'  | |  |      |  |____ |  |\\  \\----..----)   |   \r\n"
						+ "|_______/ |_______|    \\__/     |_______||_______| \\______/  | _|      |_______|| _| `._____||_______/    \r\n"
						+ "                                                        \r\n");
		System.out.println("                                          E   N   T   E   R                                              ");
	}

	public static void gameIntroduce() {
		System.out.println("                   ㅡㅡㅡㅡㅡㅡㅡㅡ-ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ-ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.println("                  |                        게 임  설 명                      [-][ㅁ][x] |");
		System.out.println("                   ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ-ㅡㅡㅡㅡㅡㅡㅡ-ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.println("                  |                   스마트인재개발원 수강신청에 성공한 당신!                 | ");
		System.out.println("                  | 당신은 풀스택 개발자, 데이터베이스 관리자, 인공지능 개발자 코스 중 하나를 선택하여 | ");
		System.out.println("                  |          능력 있는 개발자가 되기 위한 스인개 생활을 시작하게 되었습니다!       |");
		System.out.println("                  |                               ㅡ                                  |");
		System.out.println("                  |  [스인개 수업듣기] [팀프로젝트] [코딩테스트] [자격증 공부] [예습/복습] 을 통해  |");
		System.out.println("                  |개발 능력치를 상승시킬 수 있으나 무리한공부는 체력감소와 스트레스상승의 원인이 됩니다!|");
		System.out.println("                  |       스트레스 게이지가 100 초과시 스인재에서 퇴소당하는 불상사가 발생하니      |");
		System.out.println("                  |[점심시간] [커피마시기] [수업시간에 졸기] [퇴근] [주말에 쉬기] 등을 적절히 수행하여|");
		System.out.println("                  |               건강하고 능력있는 개발자가 되기 위해 노력해주세요!             |");
		System.out.println("                   ㅡㅡㅡㅡㅡㅡㅡㅡ-ㅡㅡㅡㅡㅡㅡㅡㅡㅡ-ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ-ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.println("                   ㅡㅡㅡㅡㅡㅡㅡㅡ-ㅡㅡㅡㅡㅡㅡㅡㅡㅡ-ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ-ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ"); 
		System.out.print("                               1. 시작메뉴로 돌아가기        2. 게임종료    >>   ");
	}

	public static void artFullStack() {
		System.out.println(
				"                                      ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ\r\n"
						+"                                     |     나는,,,                |\r\n"
						+"                                     |     개발자중의 개발자라능,,,!  |\r\n"
						+ "                                     ￣￣￣￣￣ヽ___ノ￣￣￣￣￣￣￣￣￣￣\r\n"
						+ "                                             Ｏ\r\n"
						+ "                                              o\r\n"
						+ "                                              ,. ─冖'⌒'─､\r\n"
						+ "                                             ノ         ＼\r\n"
						+ "                                            / ,r‐へへく⌒'￢､  ヽ\r\n"
						+ "                                           {ノ へ._、 ,,／~`  〉 ｝\r\n"
						+ "                                         ／プ￣￣`y'¨Y´￣￣ヽ─}j=く\r\n"
						+ "                                         ノ /レ'>ー{__ｭ`ーー'  ﾘ,ｲ}\r\n"
						+ "                                         / _勺 ｲ;；∵r===､､∴'∵;  シ \r\n"
						+ "                                       ,/ └'ノ ＼  ご`    ノ{ー--､__\r\n"
						+ "                                       人＿_/ー┬ー个-､＿＿,,.. ‐´ 〃`ァーｧー＼\r\n"
						+ "                                     . /  |／ |::|､      〃 /::/   ヽ\r\n"
						+ "                                     /    |  |::|＼､_________／/::/〃   |");

	}

	public static void artDB() {
		System.out.println(
				"                                      ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ\r\n"
						+"                                     |   너도 하나의 데이터일뿐....   |\r\n"
						+"                                     |                           |\r\n"
						+"                                     ￣￣￣￣￣ヽ___ノ￣￣￣￣￣￣￣￣￣\r\n"
						+ "                                          Ｏ\r\n"
						+ "                                              o\r\n"
						+ "                                          .~-                      \r\n"
						+ "                                            -$@@@@~                \r\n"
						+ "                                           .@@@@@@@-               \r\n"
						+ "                                           #@@@@@@@@               \r\n"
						+ "                                           @@@@@@@@@.              \r\n"
						+ "                                           =DBDBDBD.#              \r\n"
						+ "                                          @,        @              \r\n"
						+ "                                          @=  = =  !@              \r\n"
						+ "                                          .#,  L   @~              \r\n"
						+ "                                           .=  -- ;;               \r\n"
						+ "                                            *;   .@                \r\n"
						+ "                                             $!~:#      ,~~;;:~-   \r\n"
						+ "                                              ~=*     ,#@@@@@@@@@. \r\n"
						+ "                                            @     =.  @@@@@@@@@@@: \r\n"
						+ "                                          @,=@   ~@ @ :@@@@@@@@@@. \r\n"
						+ "                                        .@@@ @* ~@ @@ ;  -@@@@!  . \r\n"
						+ "                                        @@@@!,,  =.@@ @@#$!,.~$#@~ \r\n"
						+ "                                       =@@@@@-:@=.@@@ @@@@@@@@@@@~ \r\n"
						+ "                                      .@@@@@@@@@@@@@@ $@@@@@@@@@@~ \r\n"
						+ "                                            ");
	}

	public static void artAI() {
		System.out.println(
				"                                   ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ\r\n"
						+"                                 |  사람과 함께 공존하며         |\r\n"
						+"                                 |      더 높은곳을 향할것입니다  |\r\n"
						+"                                  ￣￣￣￣￣ヽ___ノ￣￣￣￣￣￣￣￣￣\r\n"
						+ "                                           Ｏ\r\n"
						+ "                                               o\r\n"
						+ "                                           :#############:     \r\n"
						+ "                                           =.-----------.=     \r\n"
						+ "                                          :,:=!!!!!!!!!*;.:    \r\n"
						+ "                                         ~!,:- -!. .!- ,;.*~   \r\n"
						+ "                                       , !;,:- ~;- -;~ ,;.;! . \r\n"
						+ "                                      $~=:~,:@@~~ ~~-@@  .~:=~$\r\n"
						+ "                                      @!=:~,:-.-~~U~~-.,;.~:$!@\r\n"
						+ "                                       , !;,:- ~;---;- ,;.;! , \r\n"
						+ "                                         ~!,:- ~*. .*~ ,;.!~   \r\n"
						+ "                                          :,:*;;;;;;;;;*:.;    \r\n"
						+ "                                           *.~~~~~~~~~~~.*     \r\n"
						+ "                                           ~$$$$$$$$$$$$$~     \r\n"
						+ "                                                 $ $           \r\n"
						+ "                                             ,#$$$@$$$#,       \r\n"
						+ "                                            .;=~~~@~~~=;.      \r\n"
						+ "                                            !;;!*!;!**;;*      \r\n"
						+ "                                           ;;  ,~   ~,  :;     \r\n"
						+ "                                           #   ,~   ~,   #     \r\n"
						+ "                                           #    *, ,*    #     \r\n"
						+ "                                          =$@   !@.@!   @$=    \r\n"
						+ "                                          *~*   ,*-*,   *~*    \r\n"
						+ "                                          -;    *, ,*    ;-    \r\n"
						+ "                                              ,!#- -#!,        \r\n"
						+ "                                             .!-:~ ~:-!.       \r\n"
						+ "                                             ,@#@: :@#@,       ");
	}

	public static void playMenu(String nick) {
		CharDAO cDAO = new CharDAO();
		Scanner sc = new Scanner(System.in);
		int choice;
		System.out.println("                   ㅡㅡㅡㅡㅡㅡㅡㅡ-ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ-ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ-ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ"                   );
		System.out.println("                  |                   행동을 선택해 주세요                      [-][ㅁ][x] |");
		System.out.println("                   ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ-ㅡㅡㅡㅡㅡㅡㅡㅡㅡ-ㅡㅡㅡㅡㅡㅡㅡ-ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.println("                  |번호선택|                행 동                   | EXP | STRESS |  HP | ");
		System.out.println("                  |   1  |             스인개 출근하기               |  0  |   10   | -10 | ");
		System.out.println("                  |   2  |             스인개 수업듣기               |  10 |    5   | -10 |");
		System.out.println("                  |   3  |               팀 프로젝트                |  15 |   10   | -15 |");
		System.out.println("                  |   4  |               코딩테스트                 |  15 |   10   | -15 |");
		System.out.println("                  |   5  |               자격증 공부                |  15 |   10   | -10 | ");
		System.out.println("                  |   6  |                예습 복습                |  10 |   10   | -10 |");
		System.out.println("                  |   7  |                점심 시간                |  0  |  -10   |  10 |");
		System.out.println("                  |   8  |                집에 가기                |  0  |  -20   |  15 |");
		System.out.println("                  |   9  |              월요일 5시 퇴근             |  0  |  -15   |  10 |");
		System.out.println("                  |  10  |              수업시간에 졸기              |  0  |  -15   |  10 |");
		System.out.println("                  |  11  |                주말에 쉬기               | -5  |    5   |  20 |");
		System.out.println("                  |  12  |                커피 마시기               |  0  |    0   |  5  |");
		System.out.println("                   ㅡㅡㅡㅡㅡㅡㅡㅡ-ㅡㅡㅡㅡㅡㅡㅡㅡㅡ-ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ-ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.print("                                            행동 선택    >>  "); choice = sc.nextInt();
		System.out.println("                   ㅡㅡㅡㅡㅡㅡㅡㅡ-ㅡㅡㅡㅡㅡㅡㅡㅡㅡ-ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ-ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ"); 
		
		switch(choice) {
			case 1 : cDAO.goSmhrd(nick);
			case 2 : cDAO.listeningClass(nick);
			case 3 : cDAO.teamProject(nick);
			case 4 : cDAO.codingTest(nick);
			case 5 : cDAO.studyCertificate(nick);
			case 6 : cDAO.selfEdu(nick);
			case 7 : cDAO.lunchTime(nick);
			case 8 : cDAO.goHome(nick);
			case 9 : cDAO.monday(nick);
			case 10 : cDAO.snooze(nick);
			case 11 : cDAO.weekend(nick);
			case 12 : cDAO.coffee(nick);
		}
	}
	public static void chat1() {
		System.out.println(
	             "    ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ    ");
		
	}
	   
	   
	public static String inputId() {
		Scanner sc = new Scanner(System.in);
		System.out.print("                                            ID : ");
		String id = sc.next();
		return id;
	}

	public static String inputPw() {
		Scanner sc = new Scanner(System.in);
		System.out.print("                                            PW : ");
		String pw = sc.next();
		return pw;
	}
	
	public static void makeChar(String nick) {
		
		Scanner sc = new Scanner(System.in);
		GameDAO gDAO = new GameDAO();
		int choice ;
		
		System.out.println("                   ㅡㅡㅡㅡㅡㅡㅡㅡ-ㅡㅡㅡㅡㅡㅡㅡㅡㅡ-ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ-ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.println("                  |                         캐릭터 생성                       [-][ㅁ][x] |");
		System.out.println("                   ㅡㅡㅡㅡㅡㅡㅡㅡ-ㅡㅡㅡㅡㅡㅡㅡㅡㅡ-ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ-ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.println("                  |   [1] 풀스택 개발자     [2] 데이터베이스 관리자     [3] 인공지능 개발자      | ");
		System.out.println("                   ㅡㅡㅡㅡㅡㅡㅡㅡ-ㅡㅡㅡㅡㅡㅡㅡㅡㅡ-ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ-ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.print("                                            메뉴 선택    >>  "); choice = sc.nextInt();
		System.out.println("                   ㅡㅡㅡㅡㅡㅡㅡㅡ-ㅡㅡㅡㅡㅡㅡㅡㅡㅡ-ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ-ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");

		if (choice == 1) { // 풀스택 개발자 플레이
			gDAO.creationChar(nick); 
			artFullStack();
			playMenu(nick);
		} else if (choice == 2) { // 데이터베이스 관리자 플레이
			gDAO.creationChar(nick); 
			artDB();
			playMenu(nick);
		} else if (choice == 3){ // 인공지능 개발자 플레이
			gDAO.creationChar(nick); 
			artAI();
			playMenu(nick);
		} else {
			inputError = true;
			System.out.println("잘못된 입력입니다. 첫 화면으로 돌아갑니다.");
			continue;
		}

	}

}
