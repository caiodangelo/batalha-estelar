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
	
	public static String generateHtmlTable(Cell[][] table, int quant, boolean enemy){
		String tabela = "";
		tabela = tabela+"<table>";
		for(int i=-1; i<quant; i++)
		{
			tabela = tabela+"<tr>";
			for(int j=-1; j<quant; j++)
			{
				if (i==-1)
				{
					if(j==-1){
						tabela = tabela+"<th>&nbsp;</th>";
					}
					else{
						tabela = tabela+"<th>"+j+"</th>";
					}					
					continue;
				}
				if(j==-1)
				{
					tabela = tabela+"<td>"+i+"</td>";
					continue;
				}
				Cell atual = table[i][j];
				if(atual.isHit()){
					if (atual.hasShip())
					{
						tabela = tabela+"<td class=\"hitShip\"><img src=\"img/fire.png\" width=\"20px\" height=\"20px\" border=\"0\" /></td>";
					}
					else
					{
						tabela = tabela+"<td class=\"miss\"><img src=\"img/water.png\" width=\"20px\" height=\"20px\" border=\"0\" /></td>";
					}
				}
				else if(atual.hasShip()){
					tabela = tabela+"<td class=\"ship\">&nbsp;</td>";
				}
				else{
					if(enemy)
						tabela = tabela+"<td class=\"free\"><a href=\"RealizaAtaque?posx="+i+"&posy="+j+"\" title=\"\"><img src=\"img/target.png\" width=\"20px\" height=\"20px\" border=\"0\" /></a></td>";
					else
						tabela = tabela+"<td class=\"free\">&nbsp;</td>";
				}				
			}
			tabela = tabela+"</tr>";
		}
		tabela = tabela+"</table>";
		return tabela;
	}
	
	public static String generateHtmlShipsForm(int xwing, int falcon, int destroyer){
		String form;
		form = "<div class=\"xwingforms\">";
		for(int i=0; i<xwing; i++){
			//monta a quantidade de x-wings desejada
			form = form+"<h3>X-Wing "+(i+1)+" </h3> x: <input type=\"text\" name=\"xwing"+(i+1)+"x\">";
			form = form+"  y: <input type=\"text\" name=\"xwing"+(i+1)+"y\"><br>";
		}
		form = form+"</div><div class=\"falconforms\">";
		for(int j=0; j<falcon; j++){
			//monta a quantidade de falcons desejada
			form = form+"<h3>Millenium Falcon "+(j+1)+"</h3> x: <input type=\"text\" name=\"falcon"+(j+1)+"x\">";
			form = form+"  y: <input type=\"text\" name=\"falcon"+(j+1)+"y\"><br>";
		}
		form = form+"</div><div class=\"destroyerforms\">";
		for(int k=0; k<destroyer; k++){
			//monta a quantidade de destroyers desejada
			form = form+"<h3>Destroyer "+(k+1)+"</h3> x: <input type=\"text\" name=\"destroyer"+(k+1)+"x\">";
			form = form+"  y: <input type=\"text\" name=\"destroyer"+(k+1)+"y\"><br>";
			
		}
		form = form+"</div>";
		return form;
	}
	
	public static String getErrors(String erro){
		String msg = "";
		if(erro!=null){
			msg = erro;
			return msg;
		}
		else{
			return msg;
		}
	}
	
	public static String getMessage(String msg){
		return getErrors(msg);
	}

}
