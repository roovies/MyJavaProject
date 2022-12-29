package StudentManage.Model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import StudentManage.Model.VO.Student;

public class StudentDAO {
	/*	DAO에서는 아래처럼 선언하면 데이터가 존재하지 않으면 null을 반환하여, 해당 null값으로 데이터 존재유무를 핸들링 해야 하는데
	 * 	그렇게 코딩하기가 헷갈리기 때문에 가능하면 각 쿼리문 기능에서 객체를 생성해주도록 한다.
	 * 	(혹은 Student객체에 대해서만 null로 선언해두면 된다.)
	 * 	Student student;
	 * 	List<Student> sList;
	 * 	
	 * 	public StudentDAO(){
	 * 		student = new Student();
	 * 		sList = new ArrayList<Student>();
	 * 
	 */
	
	/** JDBC 변수 선언 */
	private final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	private final String USER = "STUDENT";
	private final String PWD = "STUDENT";
	
	/**-------------------------------------------------------------------------------------------------
	/ JDBC - 관리자 확인
	/-------------------------------------------------------------------------------------------------*/
	public Student selectAdmin(String loginId, String loginPwd) {
		Student student = null;
		try {
			/** JDBC로 DB연결 및 쿼리문 준비 */
			Class.forName(DRIVER);
			Connection conn = DriverManager.getConnection(URL, USER, PWD);
			Statement stmt = conn.createStatement();
			
			/** SELECT STUDENT_ID, STUDENT_PWD FROM STUDENT_TBL WHERE STUDENT_ID='admin' AND STUDENT_PWD='admin';
			    WHERE절을 통해 관리자 ID, PW가 일치하는 레코드를 SELECT한다. */
			String sql = "SELECT STUDENT_ID, STUDENT_PWD FROM STUDENT_TBL WHERE STUDENT_ID='"+loginId+"' AND STUDENT_PWD='"+loginPwd+"'";
			System.out.println(sql);
			ResultSet rset = stmt.executeQuery(sql);
			if(rset.next()) {
				student = new Student();
			// 쿼리 결과값이 존재한다면 next()가 true가 되어 아래 조건문이 실행된다. (따라서 Student 객체를 생성해서 넘겨주자.)
			// 그러나 쿼리 결과값이 존재하지 않는다면 false가 되어 바로 return student;로 넘어가게 된다.
				student.setStudentId(rset.getString("STUDENT_ID"));
				student.setStudentPwd(rset.getString("STUDENT_PWD"));
				rset.close();
				stmt.close();
				conn.close();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return student;
	}
	
	/**-------------------------------------------------------------------------------------------------
	/ JDBC - 회원가입
	/-------------------------------------------------------------------------------------------------*/
	public int insertStudent(Student student) {
		int result = 0;
		try {
			/** JDBC로 DB연결 및 쿼리문 준비 */
			Class.forName(DRIVER);
			Connection conn = DriverManager.getConnection(URL, USER, PWD);
			Statement stmt = conn.createStatement();
			
			/** 회원가입 SQL문 전송 
			 * INSERT INTO STUDENT_TBL VALUES('id', 'pw', 'name', 'gender', age, 'email', 'phone', 'addr', 'hobby', date); */
			String sql = "INSERT INTO STUDENT_TBL VALUES("+
							"'"+student.getStudentId()+"',"+
							"'"+student.getStudentPwd()+"',"+
							"'"+student.getStudentName()+"',"+
							"'"+student.getGender()+"', "+
								student.getAge()+", "+
							"'"+student.getEmail()+"', "+
							"'"+student.getPhone()+"', "+
							"'"+student.getAddress()+"', "+
							"'"+student.getHobby()+"', "+
							"DEFAULT)";
			result = stmt.executeUpdate(sql);
			stmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	/**-------------------------------------------------------------------------------------------------
	/ JDBC - 전체 회원 조회
	/-------------------------------------------------------------------------------------------------*/
	public List<Student> selectAll() {
		Student student = null;
		List<Student> sList = new ArrayList<Student>();
		try {
			/** JDBC로 DB연결 및 쿼리문 준비 */
			Class.forName(DRIVER);
			Connection conn = DriverManager.getConnection(URL, USER, PWD);
			Statement stmt = conn.createStatement();
			
			/** SELECT * FROM STUDENT_TBL; */
			String sql = "SELECT * FROM STUDENT_TBL";
			ResultSet rset = stmt.executeQuery(sql);
			while(rset.next()) {
				student = new Student();
				student.setStudentId(rset.getString("STUDENT_ID"));
				student.setStudentPwd(rset.getString("STUDENT_PWD"));
				student.setStudentName(rset.getString("STUDENT_NAME"));
				student.setGender(rset.getString("GENDER"));
				student.setAge(rset.getInt("AGE"));
				student.setEmail(rset.getString("EMAIL"));
				student.setPhone(rset.getString("PHONE"));
				student.setAddress(rset.getString("ADDRESS"));
				student.setHobby(rset.getString("HOBBY"));
				student.setEnrollDate(rset.getDate("ENROLL_DATE"));
				sList.add(student);
			}
			rset.close();
			stmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sList;
	}
	
	/**-------------------------------------------------------------------------------------------------
	/ JDBC - ID로 회원 조회
	/-------------------------------------------------------------------------------------------------*/
	public Student selectId(String studentId) {
		Student student = null;
		try {
			/** JDBC로 DB연결 및 쿼리문 준비 */
			Class.forName(DRIVER);
			Connection conn = DriverManager.getConnection(URL, USER, PWD);
			Statement stmt = conn.createStatement();
			
			/** SELECT * FROM STUDENT_TBL WHERE STUDENT_ID='아이디'; */
			String sql = "SELECT * FROM STUDENT_TBL WHERE STUDENT_ID='"+studentId+"'";
			ResultSet rset = stmt.executeQuery(sql);
			if(rset.next()) {
				student = new Student();
				student.setStudentId(rset.getString("STUDENT_ID"));
				student.setStudentPwd(rset.getString("STUDENT_PWD"));
				student.setStudentName(rset.getString("STUDENT_NAME"));
				student.setGender(rset.getString("GENDER"));
				student.setAge(rset.getInt("AGE"));
				student.setEmail(rset.getString("EMAIL"));
				student.setPhone(rset.getString("PHONE"));
				student.setAddress(rset.getString("ADDRESS"));
				student.setHobby(rset.getString("HOBBY"));
				student.setEnrollDate(rset.getDate("ENROLL_DATE"));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return student;
	}
	
	/**-------------------------------------------------------------------------------------------------
	/ JDBC - 이름으로 회원 조회
	/-------------------------------------------------------------------------------------------------*/
	public List<Student> selectName(String studentName) {
		Student student = null;
		List<Student> sList = new ArrayList<Student>();
		try {
			/** JDBC로 DB연결 및 쿼리문 준비 */
			Class.forName(DRIVER);
			Connection conn = DriverManager.getConnection(URL, USER, PWD);
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM STUDENT_TBL WHERE STUDENT_NAME='"+studentName+"'";
			ResultSet rset = stmt.executeQuery(sql);
			while(rset.next()) {
				student = new Student();
				student.setStudentId(rset.getString("STUDENT_ID"));
				student.setStudentPwd(rset.getString("STUDENT_PWD"));
				student.setStudentName(rset.getString("STUDENT_NAME"));
				student.setGender(rset.getString("GENDER"));
				student.setAge(rset.getInt("AGE"));
				student.setEmail(rset.getString("EMAIL"));
				student.setPhone(rset.getString("PHONE"));
				student.setAddress(rset.getString("ADDRESS"));
				student.setHobby(rset.getString("HOBBY"));
				student.setEnrollDate(rset.getDate("ENROLL_DATE"));
				sList.add(student);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sList;
	}
	
	/**-------------------------------------------------------------------------------------------------
	/ JDBC - 회원탈퇴
	/-------------------------------------------------------------------------------------------------*/
	public int deleteId(String studentId) {
		int result = 0;
		/** JDBC로 DB연결 및 쿼리문 준비 */
		try {
			Class.forName(DRIVER);
			Connection conn = DriverManager.getConnection(URL, USER, PWD);
			Statement stmt = conn.createStatement();
			
			//DML 결과는 int값으로 반환
			String sql = "DELETE FROM STUDENT_TBL WHERE STUDENT_ID='"+studentId+"'";
			result = stmt.executeUpdate(sql);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**-------------------------------------------------------------------------------------------------
	/ JDBC - 정보수정
	/-------------------------------------------------------------------------------------------------*/
	public int updatePwd(Student student) {
		int result = 0;
		try {
			/** JDBC로 DB연결 및 쿼리문 준비 */
			Class.forName(DRIVER);
			Connection conn = DriverManager.getConnection(URL, USER, PWD);
			Statement stmt = conn.createStatement();
			
			String sql = "UPDATE STUDENT_TBL SET STUDENT_PWD='"+student.getStudentPwd()+"' WHERE STUDENT_ID='"+student.getStudentId()+"'";
			result = stmt.executeUpdate(sql);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int updateEmail(Student student) {
		int result = 0;
		try {
			/** JDBC로 DB연결 및 쿼리문 준비 */
			Class.forName(DRIVER);
			Connection conn = DriverManager.getConnection(URL, USER, PWD);
			Statement stmt = conn.createStatement();
			
			String sql = "UPDATE STUDENT_TBL SET EMAIL='"+student.getEmail()+"' WHERE STUDENT_ID='"+student.getStudentId()+"'";
			result = stmt.executeUpdate(sql);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int updatePhone(Student student) {
		int result = 0;
		try {
			/** JDBC로 DB연결 및 쿼리문 준비 */
			Class.forName(DRIVER);
			Connection conn = DriverManager.getConnection(URL, USER, PWD);
			Statement stmt = conn.createStatement();
			
			String sql = "UPDATE STUDENT_TBL SET PHONE='"+student.getPhone()+"' WHERE STUDENT_ID='"+student.getStudentId()+"'";
			result = stmt.executeUpdate(sql);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int updateAddress(Student student) {
		int result = 0;
		try {
			/** JDBC로 DB연결 및 쿼리문 준비 */
			Class.forName(DRIVER);
			Connection conn = DriverManager.getConnection(URL, USER, PWD);
			Statement stmt = conn.createStatement();
			
			String sql = "UPDATE STUDENT_TBL SET ADDRESS='"+student.getAddress()+"' WHERE STUDENT_ID='"+student.getStudentId()+"'";
			result = stmt.executeUpdate(sql);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int updateHobby(Student student) {
		int result = 0;
		try {
			/** JDBC로 DB연결 및 쿼리문 준비 */
			Class.forName(DRIVER);
			Connection conn = DriverManager.getConnection(URL, USER, PWD);
			Statement stmt = conn.createStatement();
			
			String sql = "UPDATE STUDENT_TBL SET HOBBY='"+student.getHobby()+"' WHERE STUDENT_ID='"+student.getStudentId()+"'";
			result = stmt.executeUpdate(sql);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
