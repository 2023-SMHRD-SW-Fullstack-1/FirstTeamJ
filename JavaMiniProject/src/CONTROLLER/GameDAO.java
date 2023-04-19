package CONTROLLER;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import MODEL.CharVO;

public class GameDAO {
 
	   Connection conn = null;
	   PreparedStatement pstm = null; //쿼리문 실행시키는 객체
	   ResultSet rs = null; //쿼리문을 통해 발생한 응답을 받을 수 있는 객체
	   
	   //DB연결
	   public void charGetConn() {

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
	   
	   //DB닫기
	   public void charClose() {
	      //DB 연결 끊기 → 역순
	      try {
	         if(rs != null) {
	            rs.close();
	         }
	         if(pstm != null) {
	            pstm.close();
	         }
	         if(conn != null) {
	            conn.close();
	         }
	      }catch(SQLException e){
	         e.printStackTrace();
	      }
	   }
	   
	   //캐릭터 생성
	   public int creationChar(String nick) {
	      charGetConn();
	      int result = 0;
	      try {
	         String sql = "insert into DEVELOPER_DAMA values (?, ?, ?, ?)";
	         pstm = conn.prepareStatement(sql);
	         pstm.setString(1,  nick);
	         pstm.setInt(2,  0);
	         pstm.setInt(3,  0);
	         pstm.setInt(4,  50);
	         
	         result = pstm.executeUpdate();
	         
	      } catch (SQLException e) {
	         System.out.println("쿼리문 오류!");
	         e.printStackTrace();
	      }
	      charClose();
	      return result;
	   }
	   
	   //캐릭터 삭제
	   public int deleteChar(String id, String pw) {
		   charGetConn();
		   int result = 0;
		
		   try {
			   String sql = "delete from developer_dama where user_id = ? and user_pw = ?";
			   pstm = conn.prepareStatement(sql);
			   pstm.setString(1, id);
			   pstm.setString(2, pw);   
			   result = pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		   charClose();
		   return result;
		   
	   }
	   
	   //전체 캐릭터 리스트 - exp순으로 정렬 (랭킹)
	   public ArrayList<CharVO> rank() {
			charGetConn();
			
			ArrayList<CharVO> charList = new ArrayList<CharVO>();
			
			try {
				String sql = "select * from developer_dama order by char_exp";
				pstm = conn.prepareStatement(sql);
				rs = pstm.executeQuery();
				
				while(rs.next()) {
					String nick = rs.getString("user_nick");
					int exp = rs.getInt("char_exp");
					int stress = rs.getInt("char_stress");
					int hp = rs.getInt("char_hp");
					CharVO cvo = new CharVO(nick, exp, stress, hp);
					charList.add(cvo);
					
					}
				}catch(SQLException e) {
					System.out.println("쿼리문 오류");
					e.printStackTrace();
				}
			charClose();
			return charList;
		}
	   
	   //유저 캐릭터 상태 확인
	   public ArrayList<Integer> charGauge(String nick) {
		   
		   ArrayList<Integer> charGauge = new ArrayList<Integer>();
		   
		   int charExp = 0;
		   int charStress = 0;
		   int charHp = 0;

		   for(int i = 0 ; i < rank().size() ; i++) {
			   if(rank().get(i).getNick().equals(nick)) {
				   charExp = rank().get(i).getExp();
				   charStress = rank().get(i).getStress();
				   charHp = rank().get(i).getHp();
				   charGauge.add(charExp);
				   charGauge.add(charStress);
				   charGauge.add(charHp);
				   break;
			   }
		   }

		   return charGauge;
	   }
	   
	  


}
