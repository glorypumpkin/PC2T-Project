import java.util.ArrayList;

public class TechStudents extends Students {
	
	protected String leapYear;
	private static int newId=0;
	
	public TechStudents(String name, String surname, int yearOfBirth) {
		super(name, surname, yearOfBirth);
		// TODO Auto-generated constructor stub
	}
	
	
	public String isLeapYear(int yearOfBirth) {
		if((yearOfBirth % 4 == 0) && (yearOfBirth % 100 != 0) || (yearOfBirth % 400 == 0)) {
			leapYear = "The year " +yearOfBirth+" is leap";
			return leapYear;
		}
		else{
			leapYear = "The year " +yearOfBirth+" is not leap";
			return leapYear;
		}
	}

	public String isLeapYear() {
		// TODO Auto-generated method stub
		return null;
	}

}
