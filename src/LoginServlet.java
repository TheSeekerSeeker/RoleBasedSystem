import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");

        // Assign roles based on username
        String role;
        switch (username.toLowerCase()) {
            case "admin":
                role = "Admin";
                break;
            case "tech":
                role = "Technician";
                break;
            case "user":
                role = "Normal User";
                break;
            default:
                role = "Guest"; // Invalid user
        }

        // Store user role in session
        HttpSession session = request.getSession();
        session.setAttribute("role", role);

        // Redirect based on role
        switch (role) {
            case "Admin":
                response.sendRedirect("admin.jsp");
                break;
            case "Technician":
                response.sendRedirect("technician.jsp");
                break;
            case "Normal User":
                response.sendRedirect("user.jsp");
                break;
            default:
                response.sendRedirect("index.jsp"); // Go back to login
        }
    }
}
