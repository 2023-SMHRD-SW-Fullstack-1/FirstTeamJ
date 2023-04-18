package Model;

import java.util.ArrayList;
import java.util.Scanner;



public class 더미회원가입 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<UserLog> arr = new ArrayList<>();
		
		
		System.out.print("이름 : ");
		String name = sc.next();
		System.out.print("비밀번호 : ");
		String pw = sc.next();
		System.out.print("닉네임 : ");
		String nick = sc.next();
		
		UserLog UserInfo = new UserLog(name,pw,nick);
		arr.add(UserInfo);
		
		
System.out.println("아이디 : "+arr.get(0).getName() + " \n비밀번호 : " + arr.get(0).getPw() + " \n닉네임 : "+ arr.get(0).nick());

		
	}

}
