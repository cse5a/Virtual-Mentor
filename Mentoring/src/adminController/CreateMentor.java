package adminController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.AdminDao;

/**
 * Servlet implementation class CreateMentor
 */
@WebServlet("/CreateMentor")
public class CreateMentor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateMentor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		if(session.getAttribute("USERAUTH") != null) {
			int mentorId,firstId,lastId,i=0;
			boolean Status=false,status=false;
			mentorId=Integer.parseInt(request.getParameter("mentorid"));
			firstId=Integer.parseInt(request.getParameter("firstid"));
			lastId=Integer.parseInt(request.getParameter("lastid"));
			Status=AdminDao.mentorCreation(mentorId, firstId, lastId);
			if(Status == true) {
				for(i=firstId;i<=lastId;) {
					status=AdminDao.mentorAssign(i, mentorId);
					if(status == true)
						i++;
					else
						break;
				response.getWriter().println("Succsessfull");
				}
				RequestDispatcher rsd = request.getRequestDispatcher("adminPanel/CreateMentor.jsp");
				rsd.forward(request, response);
			}else
				response.sendRedirect("adminPanel/CreateMentor.jsp");
			
		}
		else 
			response.sendRedirect("Login.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
