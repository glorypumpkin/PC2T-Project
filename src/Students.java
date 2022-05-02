import java.util.ArrayList;
import java.util.List;

public class Students{
	private static int Idcount=0;
	protected int id;
	private String name;
	private String surname;
	public int yearOfBirth;
	private float mark;
	protected List<Float> marks;
	protected float averageMark;
	
	
	public Students() {
	}
	
	public Students(String name, String surname, int yearOfBirth) {
		this.name=name;
		this.surname=surname;
		this.id=Idcount++;
		this.yearOfBirth=yearOfBirth;
		this.marks=new ArrayList<Float>();
	}
	public List<Float> getMarks(){
		return marks;
	}
	public float getMark() {
		return mark;
	}
	public void setMark(float mark) {
		if(mark<1||mark>5) {
			System.out.println("Mark is out of range 1.0-5.0. Please, try again.");
		}
		else {
			marks.add(mark);
			System.out.println("Mark was set.");
		}
	}
	public float getAverageMark() {
		int lenght = 0;
		float markCount =0;
		for(float mark: marks) {
			markCount+=mark;
			lenght+=1;
		}
		averageMark = markCount/lenght;
		return averageMark;
	}	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id=id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}
	
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname=surname;
	}
	
	public int getYear() {
		return yearOfBirth;
	}
	public void setYear(int yearOfBirth) {
		this.yearOfBirth=yearOfBirth;
	}

}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

