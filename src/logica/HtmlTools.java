package logica;

public class HtmlTools {
	
	public static String generateHtmlTable(int rows, int cols, boolean isForm){
		String table;
		int k = 0;
		table = "<table border=\"1\">";
		if(isForm){
			for(int i=0; i<rows+1; i++){
				table = table + "<tr>";
				for(int j=0; j<cols+1; j++){
					if((j==0)&&(i!=0)){
						table = table + "<td>"+i+"</td>";
						k++;
					}
					else{
						if((i==0)&&(j!=0)){
							table = table + "<td width=\"20px\">"+j+"</td>";
							k++;
						}
						else{
							table = table + "<td>"+"&nbsp;"+"</td>";
							k++;
						}						
					}					
				}
				table = table + "</tr>";
			}
		}
		else{
		for(int i=0; i<rows; i++){
			table = table + "<tr>";
			for(int j=0; j<cols; j++){
				table = table + "<td>"+"x"+"</td>";
				k++;
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
			form = form+"X-Wing "+(i+1)+" x: <input type=\"text\" name=\"xwing"+(i+1)+"x\">";
			form = form+"  y: <input type=\"text\" name=\"xwing"+(i+1)+"y\"><br>";
		}
		form = form+"<br>";
		for(int j=0; j<falcon; j++){
			//monta a quantidade de falcons desejada
			form = form+"Millenium Falcon "+(j+1)+" x: <input type=\"text\" name=\"falcon"+(j+1)+"x\">";
			form = form+"  y: <input type=\"text\" name=\"falcon"+(j+1)+"y\"><br>";
			
		}
		form = form+"<br>";
		for(int k=0; k<destroyer; k++){
			//monta a quantidade de destroyers desejada
			form = form+"Destroyer "+(k+1)+" x: <input type=\"text\" name=\"destroyer"+(k+1)+"x\">";
			form = form+"  y: <input type=\"text\" name=\"destroyer"+(k+1)+"y\"><br>";
			
		}
		return form;
	}
	
	public static String getErrors(String erro){
		String msg = erro;
		return msg;
	}

}
