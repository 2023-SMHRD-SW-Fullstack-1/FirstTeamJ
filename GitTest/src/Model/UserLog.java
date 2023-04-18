package Model;

import java.util.ArrayList;
import java.util.Scanner;



public class UserLog {
	
	private String name; // 이름
	private String pw; // 패스워드
	private String nick; // 닉네임	
	
	


	public UserLog(String name, String pw, String nick) {
		this.name = name;
		this.pw = pw;
		this.nick = nick;
	}
	
	
	public String getName() {
		return name;
	}

	public String getPw() {
		return pw;
	}

	public String nick() {
		return nick;
	}
	
}
