package game;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SetGame
 */
@WebServlet("/setgame")
public class SetGame extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private static final int DEFAULT_MAX_TRIAL = 5;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SetGame() {
        super();
        // TODO Auto-generated constructor stub
    }
    //asd
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String word = (request.getParameter("word")==null) ? "default" :
						request.getParameter("word");
		String tryNo = (request.getParameter("tryNo")==null) ? "" :
			request.getParameter("tryNo");
		
		int maxTrial;
		try {
			maxTrial = Integer.parseInt(tryNo);
		} catch(NumberFormatException ex) {
			maxTrial = DEFAULT_MAX_TRIAL;
		}
		
	}

	

}
