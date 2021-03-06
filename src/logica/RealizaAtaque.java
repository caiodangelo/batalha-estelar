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
		doPost(request, response);
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
			synchronized(this){
				ShotResult shot = game.doShot((String) session.getAttribute("login"), target);
				switch(shot){
				case NotYourTurn:
					request.setAttribute("msg", "N�o � sua vez");
					break;
				case ShotAlreadyDone:
					request.setAttribute("msg", "Voc� j� atirou nessa casa");
					break;
				case Miss:
					request.setAttribute("msg", "�gua...");
					break;
				case XWingHit:
					request.setAttribute("msg", "X-Wing acertada!");
					break;
				case FalconHit:
					request.setAttribute("msg", "Millenium Falcon acertada!");
					break;
				case DestroyerHit:
					request.setAttribute("msg", "Destroyer acertado!");
					break;
				case XWingSunk:
					request.setAttribute("msg", "Uma X-Wing foi derrubada!");
					break;
				case FalconSunk:
					request.setAttribute("msg", "Uma Millenium Falcon foi derrubada!");
					break;
				case DestroyerSunk:
					request.setAttribute("msg", "Um Destroyer foi derrubado!");
					break;
				case AllShipsSunk:
					request.setAttribute("msg", "Todas as naves foram derrubadas!!");
					break;
				default:
					request.setAttribute("msg", "Insira um campo v�lido");
					break;
				}
				request.getRequestDispatcher("jogo.jsp").forward(request, response);
			}			
		}
		else{
			request.setAttribute("error", "Insira um campo v�lido");
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
			if((x>=0)&&(x<15)&&(y>=0)&&(y<15)){
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
