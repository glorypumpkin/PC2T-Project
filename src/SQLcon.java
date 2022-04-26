import java.sql.*;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SQLcon {
	private static Connection conStudents;
	
//	private Students [] elements;
//	private int lastStud;
//	
//	public SQLcon(int count) {
//		elements = new Students[count];
//	}
//	
//	public void setStudent(String name, String surname, int yearOfBirth)
//	{
//		try{		
//			elements[lastStud++]=new Students(name,surname,yearOfBirth);
//		}
//		catch(InputMismatchException e) {
//			System.out.println("Nespravne jste zadali rok");
//		}
//	}
//	
//	public Students getStudent(int id)
//	{
//		return elements[id];
//	}
	
	public static boolean Stud() {

        conStudents = null;

        try {
            conStudents = DriverManager.getConnection("jdbc:sqlite:students.db");
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
            return false;
        }

        return true;

    }
}
