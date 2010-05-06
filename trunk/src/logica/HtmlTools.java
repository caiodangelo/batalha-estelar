package logica;

public class HtmlTools {
	
	public static String generateHtmlTable(int rows, int cols, boolean isForm){
		String table;
		table = "<table>";
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

}
