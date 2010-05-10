package logica;

import java.awt.Point;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RealizaAtaque
 */
public class RealizaAtaque extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RealizaAtaque() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext application = getServletContext();
		HttpSession session = request.getSession();
		Game game = (Game) application.getAttribute("game");
		Point target = new Point();
		if(getTiro(request,target)){
			ShotResult shot = game.doShot((String) session.getAttribute("nick"), target);
			switch(shot){
			case NotYourTurn:
				request.setAttribute("msg", "Não é sua vez");
				break;
			case ShotAlreadyDone:
				request.setAttribute("msg", "Você já atirou nessa casa");
				break;
			case Miss:
				request.setAttribute("msg", "Água...");
				break;
			case ShipHit:
				request.setAttribute("msg", "Nave acertada");
				break;
			case ShipSunk:
				request.setAttribute("msg", "Nave derrubada");
				break;
			case AllShipsSunk:
				request.setAttribute("msg", "Todas as naves foram derrubadas");
				break;
			default:
				request.setAttribute("msg", "Insira um campo válido");
				break;
			}
			request.getRequestDispatcher("jogo.jsp").forward(request, response);
		}
		else{
			request.setAttribute("error", "Insira um campo válido");
			request.getRequestDispatcher("jogo.jsp").forward(request, response);
		}
	}
	
	private boolean getTiro(HttpServletRequest request, Point target){
		String posx = request.getParameter("posx");
		String posy = request.getParameter("posy");
		if((posx!=null)&&(posy!=null)){
			Integer x,y;
			x = Integer.parseInt(posx);
			y = Integer.parseInt(posy);
			if((x>0)&&(x<16)&&(y>0)&&(y<16)){
				target.x = x;
				target.y = y;
				return true;
			}
			else{
				return false;
			}
		}
		else{
			return false;
		}
	}

}
