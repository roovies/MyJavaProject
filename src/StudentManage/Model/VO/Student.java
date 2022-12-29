package StudentManage.Model.VO;

import java.sql.Date;

public class Student {
	// 카멜표기법 - STUDENT_ID에서 언더바 앞에 있는 건 소문자, 시작하는 단어 첫번째 글자는 대문자 나머지는 소문자
	private String studentId;
	private String studentPwd;
	private String studentName;
	private String gender;
	private int age;
	private String email;
	private String phone;
	private String address;
	private String hobby;
	private Date enrollDate; //JDBC에서는 Date 클래스를 java.sql.Date클래스를 사용할 것임
	
	//생성자
	public Student() {};
	public Student(String studentId, String studentPwd, String studentName, String gender, int age, String email,
			String phone, String address, String hobby, Date enrollDate) {
		super();
		this.studentId = studentId;
		this.studentPwd = studentPwd;
		this.studentName = studentName;
		this.gender = gender;
		this.age = age;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.hobby = hobby;
		this.enrollDate = enrollDate;
	}
	
	
	//Getter & Setter
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getStudentPwd() {
		return studentPwd;
	}
	public void setStudentPwd(String studentPwd) {
		this.studentPwd = studentPwd;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public Date getEnrollDate() {
		return enrollDate;
	}
	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}
	
	
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentPwd=" + studentPwd + ", studentName=" + studentName
				+ ", gender=" + gender + ", age=" + age + ", email=" + email + ", phone=" + phone + ", address="
				+ address + ", hobby=" + hobby + ", enrollDate=" + enrollDate + "]";
	}
	
}
