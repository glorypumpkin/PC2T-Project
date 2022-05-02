
import java.sql.*;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class SQLcon {
	private static Connection conStudents;	
	public static void conStud() {
        conStudents = null;
        try {
        	String url="jdbc:sqlite:students.db";
            conStudents = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
            
        } 
    }
	
	public static void disconStud() throws SQLException {
		if(conStudents!=null) {
			try {
				conStudents.close();
			}
			catch(SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	public static boolean createTable() {
		if(conStudents==null) {
			return false;
		}
			String sql = "CREATE TABLE IF NOT EXISTS students(" + "id integer PRIMARY KEY," + "Name varchar(255) NOT NULL,"+ "Surname varchar(255) NOT NULL,"
	                + "yearOfBirth integer, " + "marks varchar(255), " + "avgmark real," +  "Studies varchar(255)" + ");";
	        try{
	            Statement stmt = conStudents.createStatement();
	            stmt.execute(sql);
	            return true;
	        }
	        catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
		return false;
	}
	
	public static void PrintStudents() {
		try {
			String sql = "SELECT * FROM students";
			PreparedStatement pstmt = conStudents.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getString("id") + " : " + rs.getString("Name") + ", "
			            + rs.getString("Surname") + ", " + rs.getString("yearOfBirth") + ", " + rs.getString("marks")
			            + ", " + rs.getString("avgmark")+ ", " + rs.getString("Studies"));
			}
		}
		catch (SQLException e) {
            System.out.println(e.getMessage());
        }
	}
	
	public static void DeleteStudent(int id) {
		String sql ="DELETE FROM students WHERE id = ?";
		try {
			PreparedStatement pstmt = conStudents.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.executeQuery();
		}
		catch (SQLException e) {
            System.out.println(e.getMessage());
        }
	}
	
	public static void SaveStudent(int id, String name, String surname, int year, List<Float> marks, float mark) {
		String sql = "INSERT INTO Students(id,name,surname,yearOfBirth,marks,avgmark) VALUES(?,?,?,?,?,?)";
        String stringedMarks = "";

        for(float mark1 : marks)
        {
            stringedMarks = stringedMarks + mark1 + " ";
        }
        try {
            PreparedStatement pstmt = conStudents.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setString(3, surname);
            pstmt.setInt(4, year);
            pstmt.setString(5, stringedMarks);
            pstmt.setDouble(6, mark);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
	}

}
