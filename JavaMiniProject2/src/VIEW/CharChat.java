package VIEW;

import java.util.Scanner;

import CONTROLLER.CharDAO;

public class CharChat {
	
int actionChoice;
	
	public CharChat() {
		this.actionChoice = actionChoice;
	}
	
	
	public static int actionMenu(String nick) {
		CharDAO cDAO = new CharDAO();
		Scanner sc = new Scanner(System.in);
		int actionChoice;
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
		System.out.println("                  |   0  |              <게임 종료> 를 원하시면 0를 선택해주세요               |");
		System.out.println("                   ㅡㅡㅡㅡㅡㅡㅡㅡ-ㅡㅡㅡㅡㅡㅡㅡㅡㅡ-ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ-ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.print("                                            행동 선택    >>  "); actionChoice = sc.nextInt();
		System.out.println("                   ㅡㅡㅡㅡㅡㅡㅡㅡ-ㅡㅡㅡㅡㅡㅡㅡㅡㅡ-ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ-ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ"); 
		
		return actionChoice;
	}
	
	
	public void fullStackPlayMenu(String nick) {
		CharDAO cDAO = new CharDAO();
		Scanner sc = new Scanner(System.in);
		
		switch (actionMenu(nick)) {
		case 1:
			cDAO.goSmhrd(nick);
			System.out.println("하루하루 『진화』 중이라능,,,!");
			break;
		case 2:
			cDAO.listeningClass(nick);
			System.out.println("야레야레,,, 『쉬울』뿐,,,");
			break;
		case 3:
			cDAO.teamProject(nick);
			System.out.println("훗,,,난 『ACE』라능,,,!");
			break;
		case 4:
			cDAO.codingTest(nick);
			System.out.println("압도적인 『노력』의 결과를 보여줄 차례인가,,,");
			break;
		case 5:
			cDAO.studyCertificate(nick);
			System.out.println("또 하나의 『능력』을 얻었다능,,,!");
			break;
		case 6:
			cDAO.selfEdu(nick);
			System.out.println("오오오옷,,,『능력치』가 솟아오른다능,,,");
			break;
		case 7:
			cDAO.lunchTime(nick);
			System.out.println("이몸은 무려 『육식』파라능,,,!");
			break;
		case 8:
			cDAO.goHome(nick);
			System.out.println("가벼운 나의 발걸음은 너의 『달림』을 뛰어 넘는다능,,,!");
			break;
		case 9:
			cDAO.monday(nick);
			System.out.println("후훗,,,나란 놈은『시간』을 조종한다능,,,!");
			break;
		case 10:
			cDAO.snooze(nick);
			System.out.println("단지,,,『추진력』을 얻기 위함이라능,,,!");
			break;
		case 11:
			cDAO.weekend(nick);
			System.out.println("내가 쉬면 『이세계』도 멈춘다능,,,!");
			break;
		case 12:
			cDAO.coffee(nick);
			System.out.println("내 『혈류』는 이미 블랙이라능,,,");
			break;
		default:
			System.out.println("게임을 종료합니다!");
		}
		
	}
	public static void DBPlayMenu(String nick) {
		CharDAO cDAO = new CharDAO();
		Scanner sc = new Scanner(System.in);
		
		
		switch (actionMenu(nick)) {
		case 1:
			cDAO.goSmhrd(nick);
			System.out.println("출근도 하나의 데이터일뿐....");
			break;
		case 2:
			cDAO.listeningClass(nick);
			System.out.println("수업도 하나의 데이터일뿐....");
			break;
		case 3:
			cDAO.teamProject(nick);
			System.out.println("팀도 하나의 데이터일뿐....");
			break;
		case 4:
			cDAO.codingTest(nick);
			System.out.println("코딩도 하나의 데이터 일뿐..");
			break;
		case 5:
			cDAO.studyCertificate(nick);
			System.out.println(" 자격증도 하나의 데이터일뿐...");
			break;
		case 6:
			cDAO.selfEdu(nick);
			System.out.println("예습/복습도 하나의 데이터일뿐...");
			break;
		case 7:
			cDAO.lunchTime(nick);
			System.out.println("점심도 하나의 데이터일뿐...");
			break;
		case 8:
			cDAO.goHome(nick);
			System.out.println("집도 하나의 데이터일뿐...");
			break;
		case 9:
			cDAO.monday(nick);
			System.out.println("월요일도 하나의 데이터일뿐...");
			break;
		case 10:
			cDAO.snooze(nick);
			System.out.println("졸음도 하나의 데이터일뿐...");
			break;
		case 11:
			cDAO.weekend(nick);
			System.out.println("주말도 하나의 데이터일뿐....");
			break;
		case 12:
			cDAO.coffee(nick);
			System.out.println("커피도 하나의 데이터일뿐....");
			break;
		default:
			System.out.println("게임을 종료합니다!");
			break;
		}		
	}
	public static void AiPlayMenu(String nick) {
		CharDAO cDAO = new CharDAO();
		Scanner sc = new Scanner(System.in);
		
		
		switch (actionMenu(nick)) {
		case 1:
			cDAO.goSmhrd(nick);
			System.out.println("하루하루 『진화』 중이라능,,,!");
			break;
		case 2:
			cDAO.listeningClass(nick);
			System.out.println("야레야레,,, 『쉬울』뿐,,,");
			break;
		case 3:
			cDAO.teamProject(nick);
			System.out.println("훗,,,난 『ACE』라능,,,!");
			break;
		case 4:
			cDAO.codingTest(nick);
			System.out.println("압도적인 『노력』의 결과를 보여줄 차례인가,,,");
			break;
		case 5:
			cDAO.studyCertificate(nick);
			System.out.println("또 하나의 『능력』을 얻었다능,,,!");
			break;
		case 6:
			cDAO.selfEdu(nick);
			System.out.println("오오오옷,,,『능력치』가 솟아오른다능,,,");
			break;
		case 7:
			cDAO.lunchTime(nick);
			System.out.println("이몸은 무려 『육식』파라능,,,!");
			break;
		case 8:
			cDAO.goHome(nick);
			System.out.println("가벼운 나의 발걸음은 너의 『달림』을 뛰어 넘는다능,,,!");
			break;
		case 9:
			cDAO.monday(nick);
			System.out.println("후훗,,,나란 놈은『시간』을 조종한다능,,,!");
			break;
		case 10:
			cDAO.snooze(nick);
			System.out.println("단지,,,『추진력』을 얻기 위함이라능,,,!");
			break;
		case 11:
			cDAO.weekend(nick);
			System.out.println("내가 쉬면 『이세계』도 멈춘다능,,,!");
			break;
		case 12:
			cDAO.coffee(nick);
			System.out.println("내 『혈류』는 이미 블랙이라능,,,");
			break;
		default:
			System.out.println("게임을 종료합니다!");
			break;
		}		
	
	

}

}
