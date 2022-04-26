
public class KombStudents extends HumStudents{

	public KombStudents(String name, String surname, int yearOfBirth, int day, int mounth) {
		super(name, surname, yearOfBirth, day, mounth);
		// TODO Auto-generated constructor stub
	}
	
	public KombStudents(String name, String surname, int year) {
		super(name, surname, year);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getZodiac() {
		return zodiac;
	}
	
	@Override
	public String isLeapYear() {
		return leapYear;
	}
	
}


