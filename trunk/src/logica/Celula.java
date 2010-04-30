package logica;

public class Celula {
	
	private boolean foiAtingida;
	private boolean contemNavio;	
	
	
	public Celula() {
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


	public boolean verificaTiro(Celula celula){
		if(celula.isContemNavio()){
			celula.setFoiAtingida(true);
			return true;
		}
		else{
			return false;
		}
	}
}
