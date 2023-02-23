package com.jdbl44.library.management.system.datastore;

import com.jdbl44.library.management.system.database.ConnectionManager;
import com.jdbl44.library.management.system.model.Student;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
@Component
@Data
@Getter
@Builder
@ControllerAdvice
public class StudentDataStore {
    private static final String INSERT_STUDENT = "insert into student(name,contact,branch,password) values(?,?,?,?)";
    private static Connection connection = ConnectionManager.getConnection();

    public static void addNewStudent(Student student){
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STUDENT);

            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(3, student.getBranch());
            preparedStatement.setString(2, student.getContact());
            preparedStatement.setString(4, student.getPassword());

            int updateCount = preparedStatement.executeUpdate();

            if(updateCount>0){
                System.out.println("Student updated Successfully..");
            }
            else{
                System.out.println("Failed to insert..");
            }
        }
        catch (Exception sqlException){
            System.out.println(sqlException.getMessage());

        }

    }

    public static void main(String[] args) {
        Student s2 = Student.builder().name("Sangram").contact("8249500929").branch("Electrical").password("Sangram@1997").build();
        addNewStudent(s2);

        Student s3 = Student.builder().name("Swaviman").contact("7589045312").branch("Chemical").password("Swaviman@3107").build();
        addNewStudent(s3);

        Student s4 = Student.builder().name("Debopam").contact("9853456789").branch("Biotech").password("Debopam@0707").build();
        addNewStudent(s4);

        Student s5 = Student.builder().name("Monalisha").contact("8208657884").branch("Computer Science").password("Monalisha@2021").build();
        addNewStudent(s5);
    }

}
