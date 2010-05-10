package logica;

import java.awt.Point;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.*;

/**
 * Servlet implementation class RecebeNavios
 */
public class RecebeNavios extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecebeNavios() {
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
		Vector<Ship> ships = new Vector<Ship>();
		if((getXwings(5,request,ships))&&(getFalcons(3,request,ships))&&(getDestroyers(3,request,ships))){
			ValidationCode status = game.validateShipList(ships);
			switch(status){
			case ValidationOK:
				game.initializePlayerBoard((String)session.getAttribute("login"), ships);
				if(game.startGame()){
					//2 jogadores prontos
					request.getRequestDispatcher("jogo.jsp").forward(request, response);
				}
				else{
					//apenas 1 jogador pronto, envia para página de espera
					request.getRequestDispatcher("espera").forward(request, response);
				}
				break;
			case ShipMissing:
				request.setAttribute("error", "Preencha todos os campos");
				request.getRequestDispatcher("formNavios.jsp").forward(request, response);
				break;
			case ShipLocationError:
				request.setAttribute("error", "Você colocou navios em posições inválidas");
				request.getRequestDispatcher("formNavios.jsp").forward(request, response);
				break;
			default:
				request.setAttribute("error", "Ocorreu um erro, preencha os campos novamente");
				request.getRequestDispatcher("formNavios.jsp").forward(request, response);
				break;
			}
		}
		else{
			request.setAttribute("error", "Preencha todos os campos");
			request.getRequestDispatcher("formNavios.jsp").forward(request, response);
		}
		}
	
	private boolean getXwings(int quant, HttpServletRequest request, Vector<Ship> ships){
		Vector<Ship> temp = new Vector<Ship>();
		Integer x, y;
		for(int i=1; i<=quant; i++){
			String callerX = "wxing"+Integer.toString(i)+"x";
			String callerY = "wxing"+Integer.toString(i)+"y";
			if((request.getParameter(callerX)!=null)&&(request.getParameter(callerY)!=null)){
				x = Integer.parseInt(request.getParameter(callerX));
				y = Integer.parseInt(request.getParameter(callerY));
				if((x>0)&&(x<16)&&(y>0)&&(y<16)){
					temp.add(new Ship("Xwing"+i,5,new Point(x,y)));
				}
			}
		}
		if(temp.size()==quant){
			ships.addAll(temp);
		}
		else{
			return false;
		}
		return true;
	}
	
	private boolean getFalcons(int quant, HttpServletRequest request, Vector<Ship> ships){
		Vector<Ship> temp = new Vector<Ship>();
		Integer x, y;
		for(int i=1; i<=quant; i++){
			String callerX = "falcon"+Integer.toString(i)+"x";
			String callerY = "falcon"+Integer.toString(i)+"y";
			if((request.getParameter(callerX)!=null)&&(request.getParameter(callerY)!=null)){
				x = Integer.parseInt(request.getParameter(callerX));
				y = Integer.parseInt(request.getParameter(callerY));
				if((x>0)&&(x<16)&&(y>0)&&(y<16)){
					temp.add(new Ship("Falcon"+i,5,new Point(x,y)));
				}
			}
		}
		if(temp.size()==quant){
			ships.addAll(temp);
		}
		else{
			return false;
		}
		return true;
	}
	
	private boolean getDestroyers(int quant, HttpServletRequest request, Vector<Ship> ships){
		Vector<Ship> temp = new Vector<Ship>();
		Integer x, y;
		for(int i=1; i<=quant; i++){
			String callerX = "destroyer"+Integer.toString(i)+"x";
			String callerY = "destroyer"+Integer.toString(i)+"y";
			if((request.getParameter(callerX)!=null)&&(request.getParameter(callerY)!=null)){
				x = Integer.parseInt(request.getParameter(callerX));
				y = Integer.parseInt(request.getParameter(callerY));
				if((x>0)&&(x<16)&&(y>0)&&(y<16)){
					temp.add(new Ship("Destroyer"+i,5,new Point(x,y)));
				}
			}
		}
		if(temp.size()==quant){
			ships.addAll(temp);
		}
		else{
			return false;
		}
		return true;
	}

}
