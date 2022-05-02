import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class App {

	public static int onlyInteger(Scanner sc) 
	{
		int number = 0;
		try
		{
			number = sc.nextInt();
		}
		catch(Exception e)
		{
			System.err.println("Please insert only integer!");
			sc.nextLine();
			number = onlyInteger(sc);
		}
		return number;
	}
	
	public static float onlyFloat(Scanner sc)     
	{
		float number = 0;
		try			
		{
			number = sc.nextFloat();		
		}
		catch(Exception e)		
		{
			System.err.println("Please insert float number!");
			sc.nextLine();
			number = onlyFloat(sc);
		}
		return number;
	}
	
	public static boolean haveTechStuds(List<TechStudents> techstuds, int id) {
        for (TechStudents techstud : techstuds) {
            if (((Students) techstuds).getId() == id)
                return true;
        }
        return false;
    }
	
	public static boolean haveHumStuds(List<HumStudents> humstuds, int id) {
        for (HumStudents humstud : humstuds) {
            if (((Students) humstuds).getId() == id)
                return true;
        }
        return false;
    }
	
	public static boolean haveKombStuds(List<KombStudents> kombstuds, int id) {
        for (KombStudents kombstud : kombstuds) {
            if (((Students) kombstuds).getId() == id)
                return true;
        }
        return false;
    }
	
	public static boolean haveStuds(List<Students> studs, int id) {
        for (Students stud : studs) {
            if (((Students) studs).getId() == id)
                return true;
        }
        return false;
    }
	
	public static String printStuds(Students studs) {
		return "Name: "+studs.getName()+"\nSurname: "+studs.getSurname()+"\nYear of birth: "+studs.getYear()+"\nAverage mark: "+studs.getAverageMark();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Students> students = new ArrayList<>();
		List<TechStudents> techstuds = new ArrayList<>();
		List<HumStudents> humstuds = new ArrayList<>();
		List<KombStudents> kombstuds = new ArrayList<>();
		
		
//		SQLcon test=new SQLcon(1);
		
		boolean runApp=true;
		
		while(runApp) {
			Scanner num = new Scanner(System.in);
			System.out.println("Choose what to do: \n1 - Add student,\n2 - Add students mark,");
			System.out.println("3 - Delete student,\n4 - Print all info about certain student,");
			System.out.println("5 - Students skill,\n6 - Sort students by surname,\n7 - Print average mark in technical and humanities studies,");
			System.out.println("8 - Print the total number of students in individual groups,");
			System.out.println("9 - Save data to textfile,\n10 - Load data from textfile,");
			System.out.println("11 - Connect to SQL database,\n12 - Sava data to the SQL database,");
			System.out.println("13 - Load data from SQl database,\n14 - Close the program.");
			String choice = num.nextLine();
			
			switch(choice) {
			case "1":
				try {
				System.out.println("Enter students name: ");
				String name = num.next();
				System.out.println("Enter students surname: ");
				String surname = num.next();
				System.out.println("Enter students year of birth: ");
				int year = onlyInteger(num);
				
				Scanner num1 = new Scanner(System.in);
				System.out.println("Choose students category: \n1 - technical students,");
				System.out.println("2 - humanities students, \n3 - combine students.");
				int cat = onlyInteger(num1);
				if(cat == 1) {
					TechStudents techstud = new TechStudents(name,surname,year);
					techstuds.add(techstud);
					students.add(techstud);
					System.out.println("Success :)");
				}
				else if(cat==2) {
					System.out.println("Enter students day of birth: ");
					int day = onlyInteger(num);
					System.out.println("Enter students mounth of birth: ");
					int mounth = onlyInteger(num);
					if((day>31||day<1)||(mounth>12||mounth<1)) {
						System.out.println("Day or mounth is out of range. Please, try again.");
					}
					else {
						HumStudents humstud = new HumStudents(name,surname,year,day,mounth);
						humstuds.add(humstud);
						students.add(humstud);
						System.out.println("Success :)");
					}
				}
				else if(cat==3) {
					System.out.println("Enter students day of birth: ");
					int day1 = onlyInteger(num);
					System.out.println("Enter students mounth of birth: ");
					int mounth1 = onlyInteger(num);
					if((day1>31||day1<1)||(mounth1>12||mounth1<1)) {
						System.out.println("Day or mounth is out of range. Please, try again.");
					}
					else {
						KombStudents combstud = new KombStudents(name,surname,year,day1,mounth1);
						kombstuds.add(combstud);
						students.add(combstud);
						System.out.println("Success :)");
					}
				}
				else {
					System.out.println("Some strange things are happening...");
				}
				}
				catch(Exception e) {
					System.err.println("Oops.. Something went wrong!");
				}
				break;
			case "2":
				try {
					Scanner idx = new Scanner(System.in);
					System.out.println("Choose student by an ID: ");
					int id = onlyInteger(idx);
					Scanner addMark = new Scanner(System.in);
					System.out.println("Enter your mark: ");
					float mark = onlyFloat(addMark);
					
					for(Students student : students) {
						if(student.getId()==id) {
							student.setMark(mark);
							break;
						}
					}
				}
				catch(Exception e) {
					System.err.println("Oops.. Something went wrong!");
				}
				break;
			case "3":
				try {
					Scanner idx = new Scanner(System.in);
					System.out.println("Choose student by an ID: ");
					int id = onlyInteger(idx);
					for(Students studs : students) {
						if(studs.getId()==id) {
							students.removeIf(student -> studs.getId()==id);
							System.out.println("Student was deleted.");
							break;
						}
					}
				}
					
				catch(Exception e) {
					System.err.println("Oops.. Something went wrong!");
				}
				break;
			case "4":
				try {
				Scanner idx = new Scanner(System.in);
				System.out.println("Choose student by an ID: ");
				int id = onlyInteger(idx);
				for(Students studs : students) {
					if(studs.getId()==id) {
						System.out.println(printStuds(studs));
						break;
					}
				}
				for(TechStudents studs : techstuds) {
					if(studs.getId()==id) {
						System.out.println("Technical studies student.");
						break;
					}
				}
				for(HumStudents studs : humstuds) {
					if(studs.getId()==id) {
						System.out.println("Humanities studies student.");
						break;
					}
				}
				for(KombStudents studs : kombstuds) {
					if(studs.getId()==id) {
						System.out.println("Combine studies student.");
						break;
					}
				}
				}
				catch(Exception e) {
					System.err.println("Oops.. Something went wrong!");
				}
				break;
			case "5":
				try {
				Scanner idx = new Scanner(System.in);
				System.out.println("Choose student by an ID: ");
				int id = onlyInteger(idx);
				for(TechStudents studs : techstuds) {
					if(studs.getId()==id) {
						System.out.println(studs.isLeapYear(studs.getYear()));
						break;
					}
				}
				for(HumStudents studs : humstuds) {
					if(studs.getId()==id) {
						System.out.println(studs.getZodiac(studs.getDay(),studs.getMounth()));
						break;
					}
				}
				for(KombStudents studs : kombstuds) {
					if(studs.getId()==id) {
						System.out.println(studs.isLeapYear(studs.getYear()));
						System.out.println(studs.getZodiac(studs.getDay(),studs.getMounth()));
						break;
					}
				}
				}
				catch(Exception e) {
					System.err.println("Oops.. Something went wrong!");
				}
				break;
			case "6":
				 List<Students> sortedStuds = new ArrayList<>(students);
				 sortedStuds.sort(Comparator.comparing(Students::getSurname));
                 for (Students student : sortedStuds) {
                	 System.out.println(printStuds(student));
                 }
                 break;
			case "7":
				try {
					float num1 = 0,num2=0,aveMark=0;
					for(TechStudents studs : techstuds) {
						num1+=studs.getAverageMark();
					}
					for(HumStudents studs : humstuds) {
						num2+=studs.getAverageMark();
					}
					aveMark=(num1+num2)/2;
					System.out.println("Average mark in technical and humanities studies: "+aveMark);
					}
				catch(Exception e) {
					System.err.println("Oops.. Something went wrong!");
				}
				break;
			case "8":
				System.out.println("Total number of students in technical studies: "+techstuds.size());
				System.out.println("Total number of students in humanities studies: "+humstuds.size());
				System.out.println("Total number of students in combine studies: "+kombstuds.size());
				break;
			case "9":
				String filename="writedata.txt";
				try {
					BufferedWriter bw = new BufferedWriter(new FileWriter(filename,true));
					for(Students studs : students) {
						bw.append(printStuds(studs));
					}
					bw.close();
					System.out.println("Success :)");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case "10":
				String filename1="readdata.txt";
				FileReader fr=null;
				BufferedReader in=null;
				try {
					fr = new FileReader(filename1);
					in = new BufferedReader(fr);
					String line;
					String separator = ";";
					while((line=in.readLine())!=null){
						String[] values = line.split(separator);
						values=line.split(separator);
						if (values.length!=4) {
							System.out.println("Invalid file, try again!");
						}
						else if(values.length==4) {
							Students stud = new Students(values[0],values[1],Integer.parseInt(values[2]));
							stud.setMark(Float.parseFloat(values[3]));
							students.add(stud);
							System.out.println("Success :)");
						}
						if (in!=null)
							{
								in.close();
								fr.close();
							}
					}
				}
				catch (IOException e) {
					System.out.println("Cannot open this file!");
				}  
				break;
			case "11":
				SQLcon.conStud();
				break;
			case "12":
				SQLcon.createTable();
				for(Students stud : students) {
					SQLcon.SaveStudent(stud.getId(), stud.getName(), stud.getSurname(), stud.getYear(), stud.getMarks(), stud.getAverageMark());
				}
				break;
			case "13":
				SQLcon.PrintStudents();	
				break;
			case "14":
				System.out.println("Thank you for using this program :)");
				runApp=false;
				break;
			default: {
                System.out.println("Command not found. Please use digits from 1 to 14.");
            }
		}
	}

	}
}
