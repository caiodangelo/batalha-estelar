package logica;

public class Cell {
	
	private boolean foiAtingida;
	private boolean contemNavio;	
	
	
	public Cell() {
		super();
		this.foiAtingida = false;
		this.contemNavio = false;
	}


	public boolean isFoiAtingida() {
		return foiAtingida;
	}


	public void setFoiAtingida(boolean foiAtingida) {
		this.foiAtingida = foiAtingida;
	}


	public boolean isContemNavio() {
		return contemNavio;
	}


	public void setContemNavio(boolean contemNavio) {
		this.contemNavio = contemNavio;
	}


	public boolean verificaTiro(Cell celula){
		if(celula.isContemNavio()){
			celula.setFoiAtingida(true);
			return true;
		}
		else{
			return false;
		}
	}
}
