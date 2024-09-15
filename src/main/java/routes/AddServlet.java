package routes;

import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import studentmgmt.Student;
import studentmgmt.StudentDAO;


@WebServlet("/add")
public class AddServlet extends HttpServlet {
    @Override
    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setStatus(403);
        PrintWriter out = response.getWriter();
        out.println("<html><h1>hi from /add route</h1></html>");
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader reader = request.getReader();
        Student student = new Gson().fromJson(reader, Student.class);
        reader.close();

        System.out.println(student.getName() + " " + student.getPhone() + " " + student.getCity());

        response.setContentType("text/html");
        boolean okay = StudentDAO.addStudent(student);
        PrintWriter out = response.getWriter();


        if (okay) {
            response.setStatus(200);
            out.println("<html><h1>success</h1></html>");
        }
        else {
            response.setStatus(403);
            out.println("<html><h1>error</h1></html>");
        }
    }
}
