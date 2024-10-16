package a_Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import a_Model.mainDTO;

public class mainDAO {

	// DAO (Data Access Object)
	// DAO : 데이터에 접근하는 것을 도와준다!

	// DB에 연결해서 insert, delete, select 등등의 기능을 할 수 있는 코드의 모음집
	// 메소드 형태로 코드를 작성

	// 1. 회원가입 메소드
	public int join(mainDTO dto) {
		int result = 0;
		try {
			// 1. DB 드라이버 꺼내기 // 2. DB랑 자바연결 // 3. 쿼리문 작성
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@project-db-campus.smhrd.com:1523:xe";
			String user = "seocho_dcx_bigdata14_p1_3";
			String password = "smhrd3";
			Connection conn = DriverManager.getConnection(url, user, password);

			String sql = "INSERT INTO BANKUSER VALUES(?,?,?)";

			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getName());
			psmt.setString(2, dto.getId());
			psmt.setString(3, dto.getPw());

			result = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;

	}

	// 2. 로그인 메소드
	public int login(mainDTO dto) {
		int result = 0;
		try {
			// 1. DB 드라이버 꺼내기 // 2. DB랑 자바연결 // 3. 쿼리문 작성
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@project-db-campus.smhrd.com:1523:xe";
			String user = "seocho_dcx_bigdata14_p1_3";
			String password = "smhrd3";
			Connection conn = DriverManager.getConnection(url, user, password);
			// 여기부터는 내가 짜야함
			String sql = "SELECT * FROM BANKUSER WHERE USER_ID=? AND USER_PW=? ";
			PreparedStatement psmt = conn.prepareStatement(sql);

			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getPw());

			ResultSet rs = psmt.executeQuery();

			if (rs.next()) {
				result = 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;

	}
	// 3. 비밀번호 변경 메소드
	public int edit(mainDTO dto) {
		int result = 0;
		try {
			// 1. DB 드라이버 꺼내기 // 2. DB랑 자바연결 // 3. 쿼리문 작성
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@project-db-campus.smhrd.com:1523:xe";
			String user = "seocho_dcx_bigdata14_p1_3";
			String password = "smhrd3";
			Connection conn = DriverManager.getConnection(url, user, password);
			// 여기부터는 내가 짜야함
			String sql = "UPDATE BANKUSER SET USER_PW = ? WHERE USER_ID = ?";
			PreparedStatement psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, dto.getPw());
			psmt.setString(2, dto.getId());

			ResultSet rs = psmt.executeQuery();

			if (rs.next()) {
	            result = 1;
	         }
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;

	}
	// 4. 회원탈퇴 메소드
	public int delete(mainDTO dto) {
		int result = 0;
		try {
			// 1. DB 드라이버 꺼내기 // 2. DB랑 자바연결 // 3. 쿼리문 작성
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@project-db-campus.smhrd.com:1523:xe";
			String user = "seocho_dcx_bigdata14_p1_3";
			String password = "smhrd3";
			Connection conn = DriverManager.getConnection(url, user, password);
			// 여기부터는 내가 짜야함
			String sql = "DELETE FROM BANKUSER WHERE USER_ID = ? AND USER_PW = ? ";
			PreparedStatement psmt = conn.prepareStatement(sql);

			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getPw());

			ResultSet rs = psmt.executeQuery();

			if (rs.next()) {
				result = 1;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;

	}

}
