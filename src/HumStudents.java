
public class HumStudents extends TechStudents {
	
	protected String zodiac;
	private int day, mounth;
	
	public HumStudents(String name, String surname, int yearOfBirth, int day, int mounth) {
		super(name, surname, yearOfBirth);
		// TODO Auto-generated constructor stub
		this.day=day;
		this.mounth=mounth;
	}
	
	public HumStudents(String name, String surname, int year) {
		super(name, surname, year);
		// TODO Auto-generated constructor stub
	}

	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		if(day>31||day<1) {
			System.out.println("Day is out of range 1-31. Please, try again.");
		}
		else {
			this.day=day;
		}
	}
	public int getMounth() {
		return mounth;
	}
	public void setMounth(int mounth) {
		if(mounth>12||mounth<1) {
			System.out.println("Mounth is out of range. Please, try again.");
		}
		else {
			this.mounth=mounth;
		}
	}
	
	public String getZodiac(int day,int mounth) {
		
		if((mounth==3 && (day>=21&&day<=31))||(mounth==4 && (day>=1&&day<=19))){
			zodiac="aries";		
		}
		else if ((mounth==4 && (day>=20&&day<=31))||(mounth==5 && (day>=1&&day<=20))) {
			zodiac="taurus";
		}
		else if((mounth==5 && (day>=21&&day<=31))||(mounth==6 && (day>=1&&day<=20))) {
			zodiac="gemini";
		}
		else if((mounth==6 && (day>=21&&day<=31))||(mounth==7 && (day>=1&&day<=22))) {
			zodiac="cancer";
		}
		else if((mounth==7 && (day>=23&&day<=31))||(mounth==8 && (day>=1&&day<=22))) {
			zodiac="leo";
		}
		else if((mounth==8 && (day>=23&&day<=31))||(mounth==9 && (day>=1&&day<=22))) {
			zodiac="virgo";
		}
		else if((mounth==9 && (day>=23&&day<=31))||(mounth==10 && (day>=1&&day<=22))) {
			zodiac="libra";
		}
		else if((mounth==10 && (day>=23&&day<=31))||(mounth==11 && (day>=1&&day<=21))) {
			zodiac="scorpio";
		}
		else if((mounth==11 && (day>=22&&day<=31))||(mounth==12 && (day>=1&&day<=21))) {
			zodiac="sagittarius";
		}
		else if((mounth==12 && (day>=22&&day<=31))||(mounth==1 && (day>=1||day<=19))) {
			zodiac="capricorn";
		}
		else if((mounth==1 && (day>=20&&day<=31))||(mounth==2 && (day>=1||day<=18))) {
			zodiac="aquarius";
		}
		else if((mounth==2 && (day>=19&&day<=31))||(mounth==3 && (day>=1||day<=20))) {
			zodiac="pieces";
		}
		return zodiac;
	}

	public String getZodiac() {
		// TODO Auto-generated method stub
		return null;
	}
}
