package logica;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
		
	}
	
	private Vector<Integer> getXwings(int quant, HttpServletRequest request){
		Vector<Integer> positions = new Vector<Integer>();
		Integer x;
		for(int i=1; i<=quant; i++){
			String caller = "wxing"+Integer.toString(i);
			if(request.getParameter(caller)!=null){
				x = Integer.parseInt(request.getParameter(caller));
				if((x>=0)&&(x<225)){
					positions.add(x);
				}
			}			
		}
		return positions;
	}
	
	private Vector<Integer> getFalcons(int quant, HttpServletRequest request){
		Vector<Integer> positions = new Vector<Integer>();
		Integer x;
		for(int i=1; i<=quant; i++){
			String caller = "falcon"+Integer.toString(i);
			if(request.getParameter(caller)!=null){
				x = Integer.parseInt(request.getParameter(caller));
				if((x>=0)&&(x<225)){
					positions.add(x);
				}
			}			
		}
		return positions;
	}
	
	private Vector<Integer> getDestroyers(int quant, HttpServletRequest request){
		Vector<Integer> positions = new Vector<Integer>();
		Integer x;
		for(int i=1; i<=quant; i++){
			String caller = "destroyer"+Integer.toString(i);
			if(request.getParameter(caller)!=null){
				x = Integer.parseInt(request.getParameter(caller));
				if((x>=0)&&(x<225)){
					positions.add(x);
				}
			}			
		}
		return positions;
	}

}
