package studentmgmt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudentDAO {
    public static boolean addStudent(Student student) {
        boolean result = false;

        try (Connection connection = ConnectDB.getConnection();) {
            String query = "INSERT INTO students VALUES (DEFAULT, ?, ?, ?);";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getPhone());
            preparedStatement.setString(3, student.getCity());
            preparedStatement.executeUpdate();
            connection.close();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static boolean updateStudent(Student student) {
        int id = student.getId();
        String name = student.getName();
        String phone = student.getPhone();
        String city = student.getCity();

        boolean result = false;

        try (Connection connection = ConnectDB.getConnection();) {
            String query = "UPDATE students SET name = ?, phone = ?, city = ? WHERE id = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, phone);
            preparedStatement.setString(3, city);
            preparedStatement.setInt(4, id);

            preparedStatement.executeUpdate();
            connection.close();
            result = true;
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public static ResultSet getAllStudents() {
        ResultSet rs = null;
        try (Connection connection = ConnectDB.getConnection();) {
            String query = "SELECT * FROM students;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            rs = preparedStatement.executeQuery();
            connection.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return rs;
    }

    public static boolean deleteStudent(int id) {
        boolean result = false;

        try (Connection connection = ConnectDB.getConnection();) {
            String query = "DELETE FROM students WHERE id = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            connection.close();
            result = true;
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}
