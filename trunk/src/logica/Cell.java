package logica;


/**
 * Implements the Cell class, which is an extension
 * of the Point class, with 2 more attributes: isHit and
 * hasShip, that facilitate the generation of the HTML 
 * Board representation.
 * @author Vitor / Caio
 * @version 1.0
 */
public class Cell{
	
	private boolean isHit;
	private boolean hasShip;
	
	public Cell() {
		this.isHit = false;
		this.hasShip = false;
	}

	public boolean isHit() {
		return this.isHit;
	}

	public void setIsHit(boolean isHit) {
		this.isHit = isHit;
	}

	public boolean hasShip() {
		return this.hasShip;
	}

	public void setHasShip(boolean hasShip) {
		this.hasShip = hasShip;
	}
}
