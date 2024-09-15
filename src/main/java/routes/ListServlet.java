package routes;

import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import studentmgmt.Student;
import studentmgmt.StudentDAO;

@WebServlet("/list")
public class ListServlet extends HttpServlet {
    @Override
    protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ResultSet resultSet = null;
        try {
            resultSet = StudentDAO.getAllStudents();
            List<Student> students = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String city = resultSet.getString("city");
                String phone = resultSet.getString("phone");
                Student student = new Student(id, name, city, phone);
                students.add(student);
            }

            String json = new Gson().toJson(students);
            resp.setContentType("application/json");
            resp.getWriter().write(json);
            resp.setStatus(200);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
