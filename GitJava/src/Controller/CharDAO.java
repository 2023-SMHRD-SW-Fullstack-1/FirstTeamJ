package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CharDAO {
	
	// 캐릭터 행동 메서드 모음
	// 출근하기, 수업듣기, 팀프로젝트, 코딩테스트, 자격증 공부, 예습 복습 등

	Connection conn = null;
	PreparedStatement pstm = null; // 쿼리문 실행시키는 객체
	ResultSet rs = null; // 쿼리문을 통해 발생한 응답을 받을 수 있는 객체

	int result = 0;
	int changeExp = 0;
	int changeStress = 0;
	int changeHp = 0;
	
	// DB연결
	public void getConn() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
			String id = "campus_k_0417_3";
			String pw = "smhrd3";

			conn = DriverManager.getConnection(url, id, pw);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	// DB닫기
	public void close() {
		// DB 연결 끊기 → 역순
		try {
			if (rs != null) {
				rs.close();
			}
			if (pstm != null) {
				pstm.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
//	// 게이지 변경하기
//	public int changeGauge(String nick) {
//		
//		int result = 0;
//		
//        try {
//        	String sql2 = "update DEVELOPER_DAMA set char_exp = ?, char_stress = ?, char_hp = ?";
//			pstm = conn.prepareStatement(sql2);
//			
//			pstm.setInt(1,  changeExp);
//			
//			if(changeStress >= 0 && changeStress <= 100) {
//				pstm.setInt(2,  changeStress);
//			}else if(changeStress < 0) {
//				pstm.setInt(2,  0);
//			}else {
//				pstm.setInt(2, 100);
//			}
//	        
//			if(changeHp >= 0 && changeHp <= 100) {
//				 pstm.setInt(3,  changeHp);
//			}else if(changeHp < 0){
//				pstm.setInt(3,  0);
//			}else {
//				pstm.setInt(3, 100);
//			}
//	       
//			result = pstm.executeUpdate();
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//        
//        close();
//        return result;
//	}

	// 출근하기
	public void goSmhrd(String nick) {
		getConn();
		int exp = 0;
		int stress = 0;
		int hp = 0;

        try {
        	String sql = "select * from DEVELOPER_DAMA where user_nick = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, nick);
			rs = pstm.executeQuery();
	        
			while(rs.next()) {
		        exp = rs.getInt("char_exp");
		        stress = rs.getInt("char_stress");
		        hp = rs.getInt("char_hp");			
	        }
			
			String sql2 = "update developer_dama set char_exp = ?, char_stress = ?, char_hp = ?";
			pstm = conn.prepareStatement(sql2);
			pstm.setInt(1, exp);
			pstm.setInt(2, stress+10);
			pstm.setInt(3, hp-10);
			pstm.executeUpdate();
		       
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
	}
	
	// 수업듣기
	public void listeningClass(String nick) {
		getConn();

        try {
        	String sql = "select * from DEVELOPER_DAMA where user_nick = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, nick);
			rs = pstm.executeQuery();
	        
			if(rs.next()) {
		        changeExp = rs.getInt("char_exp") + 10;
		        if(rs.getInt("char_Stress") > 80) {
		        	changeStress = rs.getInt("char_stress") + 10;
		        }else {
		        	changeStress = rs.getInt("char_stress") + 5;
		        }
		        changeHp = rs.getInt("char_hp") - 10;
			}
			
//			changeGauge(nick);
		        
		       
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        close();
        
	}
	
	// 팀프로젝트
	public void teamProject(String nick) {
		getConn();

        try {
        	String sql = "select * from DEVELOPER_DAMA where user_nick = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, nick);
			rs = pstm.executeQuery();
	        
			if(rs.next()) {
		        changeExp = rs.getInt("char_exp") + 15;
		        if(rs.getInt("char_Stress") > 80) {
		        	changeStress = rs.getInt("char_stress") + 20;
		        }else {
		        	changeStress = rs.getInt("char_stress") + 10;
		        }
		        changeHp = rs.getInt("char_hp") - 15;
			}
			
//			changeGauge(nick);
		        
		       
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        close();
        
	}
	
	// 코딩테스트
	public void codingTest(String nick) {
		getConn();

        try {
        	String sql = "select * from DEVELOPER_DAMA where user_nick = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, nick);
			rs = pstm.executeQuery();
	        
			if(rs.next()) {
		        changeExp = rs.getInt("char_exp") + 15;
		        if(rs.getInt("char_Stress") > 80) {
		        	changeStress = rs.getInt("char_stress") + 30;
		        }else {
		        	changeStress = rs.getInt("char_stress") + 15;
		        }
		        changeHp = rs.getInt("char_hp") - 20;
			}
			
//			changeGauge(nick);
		        
		       
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        close();
        
	}
	
	// 자격증 공부
	public void studyCertificate(String nick) {
		getConn();

        try {
        	String sql = "select * from DEVELOPER_DAMA where user_nick = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, nick);
			rs = pstm.executeQuery();
	        
			if(rs.next()) {
		        changeExp = rs.getInt("char_exp") + 15;
		        if(rs.getInt("char_Stress") > 80) {
		        	changeStress = rs.getInt("char_stress") + 20;
		        }else {
		        	changeStress = rs.getInt("char_stress") + 10;
		        }
		        changeHp = rs.getInt("char_hp") - 15;
			}
			
//			changeGauge(nick);
		        
		       
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        close();
        
	}
	
	// 예습 복습
	public void selfEdu(String nick) {
		getConn();

        try {
        	String sql = "select * from DEVELOPER_DAMA where user_nick = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, nick);
			rs = pstm.executeQuery();
	        
			if(rs.next()) {
		        changeExp = rs.getInt("char_exp") + 10;
		        if(rs.getInt("char_Stress") > 80) {
		        	changeStress = rs.getInt("char_stress") + 20;
		        }else {
		        	changeStress = rs.getInt("char_stress") + 10;
		        }
		        changeHp = rs.getInt("char_hp") - 10;
			}
			
//			changeGauge(nick);
		        
		       
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        close();
        
	}
	
	// 점심시간
	public void lunchTime(String nick) {
		getConn();

        try {
        	String sql = "select * from DEVELOPER_DAMA where user_nick = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, nick);
			rs = pstm.executeQuery();
	        
			if(rs.next()) {
		        changeExp = rs.getInt("char_exp") + 0;
		        changeStress = rs.getInt("char_stress") - 10;
		        changeHp = rs.getInt("char_hp") + 10;
			}
			
//			changeGauge(nick);
		        
		       
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        close();
        
	}
	
	// 집에가기
	public void goHome(String nick) {
		getConn();

        try {
        	String sql = "select * from DEVELOPER_DAMA where user_nick = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, nick);
			rs = pstm.executeQuery();
	        
			if(rs.next()) {
		        changeExp = rs.getInt("char_exp") + 0;
		        changeStress = rs.getInt("char_stress") - 20;
		        changeHp = rs.getInt("char_hp") + 15;
			}
			
//			changeGauge(nick);
		        
		       
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        close();
        
	}
	
	// 월요일 5시 퇴근
	public void monday(String nick) {
		getConn();

        try {
        	String sql = "select * from DEVELOPER_DAMA where user_nick = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, nick);
			rs = pstm.executeQuery();
	        
			if(rs.next()) {
		        changeExp = rs.getInt("char_exp") + 0;
		        changeStress = rs.getInt("char_stress") - 15;
		        changeHp = rs.getInt("char_hp") + 10;
			}
			
//			changeGauge(nick);
		        
		       
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        close();
        
	}
	
	// 수업시간에 졸기
	public void snooze(String nick) {
		getConn();

        try {
        	String sql = "select * from DEVELOPER_DAMA where user_nick = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, nick);
			rs = pstm.executeQuery();
	        
			if(rs.next()) {
		        changeExp = rs.getInt("char_exp") - 5;
		        if(rs.getInt("char_Stress") > 80) {
		        	changeStress = rs.getInt("char_stress") + 10;
		        }else {
		        	changeStress = rs.getInt("char_stress") + 5;
		        }
		        changeHp = rs.getInt("char_hp") + 10;
			}
			
//			changeGauge(nick);
		        
		       
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        close();
        
	}
	
	// 주말에 쉬기
	public void weekend(String nick) {
		getConn();

        try {
        	String sql = "select * from DEVELOPER_DAMA where user_nick = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, nick);
			rs = pstm.executeQuery();
	        
			if(rs.next()) {
		        changeExp = rs.getInt("char_exp") - 20;
		        changeStress = rs.getInt("char_stress") - 20;
		        changeHp = rs.getInt("char_hp") + 20;
			}
			
//			changeGauge(nick);
		        
		       
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        close();
        
	}
	
	// 커피 마시기
	public void coffee(String nick) {
		getConn();

        try {
        	String sql = "select * from DEVELOPER_DAMA where user_nick = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, nick);
			rs = pstm.executeQuery();
	        
			if(rs.next()) {
		        changeExp = rs.getInt("char_exp") + 0;
		        changeStress = rs.getInt("char_stress") + 0;
		        changeHp = rs.getInt("char_hp") + 5;
			}
			
//			changeGauge(nick);
		        
		       
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        close();
        
	}
	
	//HP 이벤트
	public void eventHp(String nick) {
		getConn();

        try {
        	
        	String sql = "select char_hp from DEVELOPER_DAMA where user_nick = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, nick);
			rs = pstm.executeQuery();
	        
			if(rs.next()) {
				
				if(rs.getInt("char_hp") >= 0 && rs.getInt("char_hp") <= 20){
					changeHp = rs.getInt("char_hp") + 5;
				}else if(rs.getInt("char_hp") >= 80 && rs.getInt("char_hp") <= 100) {
					changeHp = rs.getInt("char_hp") - 10;
				}
			}

//			changeGauge(nick);
		        
		       
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        close();
	}

}
