package AnimalManage;

public class Information {
	//�ֿϵ��� ������ ������ �������
	private String species = "";
	private String breed = "";
	private String name = "";
	private char gender = ' '; // char���� �������� �ʱ�ȭ
	private int age = 0;
	private int date = 0;
	private int reserv = 0;
	private String condition = "�Էµ� ������ �����ϴ�.";
	
	//������
	public Information() {}
	public Information(String species, String breed, String name, char gender, int age, int date) {
		this.species = species;
		this.breed = breed;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.date = date;
	}
	
	//setter
	public void setSpecies(String species) {
		this.species = species;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setDate(int date) {
		this.date = date;
	}
	public void setReserv(int reserv) {
		this.reserv = reserv;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	
	//getter
	public String getSpecies() {
		return this.species;
	}
	public String getBreed() {
		return this.breed;
	}
	public String getName(String name) {
		return this.name;
	}
	public char getGender() {
		return this.gender;
	}
	public int getAge() {
		return this.age;
	}
	public int getDate(int date) {
		return this.date;
	}
	public int getReserv() {
		return this.reserv;
	}
	public String getCondition() {
		return this.condition;
	}
}
