package logica;

public class HtmlTools {
	
	public static String generateHtmlTable(int rows, int cols, boolean isForm){
		String table;
		table = "<table border=\"1\">";
		if(isForm){
			for(int i=0; i<rows; i++){
				table = table + "<tr>";
				for(int j=0; j<cols; j++){
					table = table + "<td>"+i+j+"</td>";
				}
				table = table + "</tr>";
			}
		}
		else{
		for(int i=0; i<rows; i++){
			table = table + "<tr>";
			for(int j=0; j<cols; j++){
				table = table + "<td>"+i+j+"</td>";
			}
			table = table + "</tr>";
		}
		}
		table = table+ "</table>";
		return table;
	}
	
	public static String generateHtmlShipsForm(int xwing, int falcon, int destroyer){
		String form;
		form = "<br>";
		for(int i=0; i<xwing; i++){
			//monta a quantidade de x-wings desejada
			form = form+"X-Wing "+(i+1)+": <input type=\"text\" name=\"xwing"+(i+1)+"\"><br>";
		}
		form = form+"<br>";
		for(int j=0; j<falcon; j++){
			//monta a quantidade de falcons desejada
			form = form+"Millenium Falcon "+(j+1)+": <input type=\"text\" name=\"falcon"+(j+1)+"\"><br>";
			
		}
		form = form+"<br>";
		for(int k=0; k<destroyer; k++){
			//monta a quantidade de destroyers desejada
			form = form+"Destroyer "+(k+1)+": <input type=\"text\" name=\"destroyer"+(k+1)+"\"><br>";
			
		}
		return form;
	}

}
