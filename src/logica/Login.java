package logica;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("nick");
		HttpSession session = request.getSession();
		ServletContext application = getServletContext();
		session.setAttribute("login", login);
		synchronized(this){
			Game game = (Game) application.getAttribute("game");
			if(game==null){
				//classe Game ainda não foi instanciada
				game = new Game(15);
				game.addPlayer(login);
				application.setAttribute("game", game);
				request.getRequestDispatcher("formNavios.jsp").forward(request, response);
			}
			else{
				//classe Game já havia sido instanciada
				if(game.getGameState()!= GameState.WaitingForPlayers){
					//jogo já está lotado e/ou em andamento
					request.getRequestDispatcher("salaCheia.jsp").forward(request, response);
				}
				else{
					if (!game.addPlayer(login))
					{
						session.setAttribute("login", login+"(1)");
					}
					request.getRequestDispatcher("formNavios.jsp").forward(request, response);
				}
				
			}
			
		}
	}

}
