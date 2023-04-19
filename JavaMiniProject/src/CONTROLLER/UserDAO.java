package CONTROLLER;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import MODEL.UserVO;

public class UserDAO {
	// DAO : Data Access Object
		// 데이터에 접근하는 기능을 가지고 있음

		Connection conn = null;
		PreparedStatement pstm = null; // 쿼리문 실행시키는 객체
		ResultSet rs = null; // 쿼리문을 통해 발생한 응답을 받을 수 있는 객체

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

		// 쿼리문 작성

		// 로그인
		public String login(String inputId, String inputPw) {
			   getConn();
			   String nick = null;
			   try {
			      String sql = "select user_pw, user_nick from user_info where user_id = ?";
			      pstm = conn.prepareStatement(sql);
			      pstm.setString(1,  inputId);

			      rs = pstm.executeQuery();
			      
			      if(rs.next()) {
			         String pw = rs.getString("user_pw");
			         if (pw.equals(inputPw)) {
			            nick = rs.getString("user_nick");
			         } else {
			            System.out.println("비밀번호가 일치하지 않습니다.");
			         }
			      } else {
			         System.out.println("해당 아이디가 존재하지 않습니다.");
			      }
			   } catch(SQLException e) {
			      System.out.println("쿼리문 오류");
			      e.printStackTrace();
			   }
			   close();
			   return nick;
			}

		// 회원가입
		public int join(String inputId, String inputPw, String inputNick) {

			getConn();
			int result = 0;
			try {
				// 아이디와 비밀번호 중복 확인
				String sqlCheck = "select count(*) from user_info where user_id = ? or user_nick = ?";
				pstm = conn.prepareStatement(sqlCheck);
				pstm.setString(1, inputId);
				pstm.setString(2, inputNick);
				rs = pstm.executeQuery();
				rs.next();
				int count = rs.getInt(1);
				if (count > 0) {
				    System.out.println("이미 가입된 아이디 또는 닉네임입니다.");
				    return -1;
				} else {
				    // 회원가입 처리
				    String sqlJoin = "insert into user_info(user_id, user_pw, user_nick) values (?, ?, ?)";
				    pstm = conn.prepareStatement(sqlJoin);
				    pstm.setString(1, inputId);
				    pstm.setString(2, inputPw);
				    pstm.setString(3, inputNick);
				    result = pstm.executeUpdate();
//				    if (result > 0) {
//				        System.out.println("회원가입 성공!");
//				    } else {
//				        System.out.println("회원가입 실패!");
//				    }
				}

			} catch (SQLException e) {
				System.out.println("쿼리문 오류!");
				e.printStackTrace();
			} finally {
				close();
			}
			return result;
		}

		// 전체 회원 조회
		public ArrayList<UserVO> userList() {
			getConn();

			ArrayList<UserVO> userList = new ArrayList<UserVO>();

			String list = "";
			try {
				String sql = "select * from user_info";
				pstm = conn.prepareStatement(sql);

				rs = pstm.executeQuery();

				while (rs.next()) {
					// 데이터베이스에서 id, pw, nick 꺼내기
					String id = rs.getString("ID");
					String pw = rs.getString("PW");
					String nick = rs.getString("NICK");
					// 꺼낸 값을 dto에 저장
					UserVO userVo = new UserVO(id, pw, nick);
					// dto에 저장된 값을 배열에 저장
					userList.add(userVo);

				}
			} catch (SQLException e) {
				System.out.println("쿼리문 오류");
				e.printStackTrace();
			}
			close();
			return userList;
		}
		
		
		// 회원 탈퇴
		public int deleteMember(String inputId, String inputPw) {
		    getConn();
		    int result = 0;
		    try {
		        // 입력받은 아이디와 비밀번호로 회원 조회
		        String sqlCheck = "select count(*) from user_info where user_id = ? and user_pw = ?";
		        pstm = conn.prepareStatement(sqlCheck);
		        pstm.setString(1, inputId);
		        pstm.setString(2, inputPw);
		        rs = pstm.executeQuery();
		        rs.next();
		        int count = rs.getInt(1);
		        if (count > 0) {
		            // 일치하는 회원이 있다면 삭제 처리
		            String sqlDelete = "delete from user_info where user_id = ?";
		            pstm = conn.prepareStatement(sqlDelete);
		            pstm.setString(1, inputId);
		            result = pstm.executeUpdate();
		            if (result > 0) {
		                System.out.println("회원탈퇴 성공!");
		            } else {
		                System.out.println("회원탈퇴 실패!");
		            }
		        } else {
		            System.out.println("일치하는 회원이 없습니다.");
		        }
		    } catch (SQLException e) {
		        System.out.println("쿼리문 오류!");
		        e.printStackTrace();
		    } finally {
		        close();
		    }
		    return result;
		}
		
		// 회원 탈퇴
		public int deleteUser(String inputId, String inputPw) {
		    getConn();
		    int result = 0;
		    try {
		        // 입력받은 아이디와 비밀번호로 회원 조회
		        String sqlCheck = "select count(*) from user_info where user_id = ? and user_pw = ?";
		        pstm = conn.prepareStatement(sqlCheck);
		        pstm.setString(1, inputId);
		        pstm.setString(2, inputPw);
		        rs = pstm.executeQuery();
		        rs.next();
		        int count = rs.getInt(1);
		        if (count > 0) {
		            // 일치하는 회원이 있다면 삭제 처리
		            String sqlDelete = "delete from user_info where user_id = ?";
		            pstm = conn.prepareStatement(sqlDelete);
		            pstm.setString(1, inputId);
		            result = pstm.executeUpdate();
		            if (result > 0) {
		                System.out.println("회원탈퇴 성공!");
		            } else {
		                System.out.println("회원탈퇴 실패!");
		            }
		        } else {
		            System.out.println("일치하는 회원이 없습니다.");
		        }
		    } catch (SQLException e) {
		        System.out.println("쿼리문 오류!");
		        e.printStackTrace();
		    } finally {
		        close();
		    }
		    return result;
		    
		}
}
