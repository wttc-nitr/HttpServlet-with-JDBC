package routes;

import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import studentmgmt.Student;
import studentmgmt.StudentDAO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
    @Override
    protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setStatus(404);

        PrintWriter out = resp.getWriter();
        out.println("<html><h4>hi from update route</h4></html>");
        out.close();
    }

    @Override
    protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader reader = req.getReader();
        Student student = new Gson().fromJson(reader, Student.class);
        reader.close();

        boolean result = StudentDAO.updateStudent(student);
        PrintWriter out = resp.getWriter();
        if (result) {
            resp.setStatus(200);
            out.println("<html><h4>updated successfully</h4></html>");
        }
        else {
            resp.setStatus(404);
            out.println("<html><h4>failure</h4></html>");
        }
    }
}
