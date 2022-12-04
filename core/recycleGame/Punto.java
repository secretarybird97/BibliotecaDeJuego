package recycleGame;

import java.awt.Graphics;

public class Punto extends Elemento {

	public Punto(String recurso, int x, int y, int xt, int vx, int vy) {
		super(recurso, x, y, xt, vx, vy);
	}

	@Override
	public void dibuja(Graphics g) {
		g.drawImage(imagen,getX(),getY(),getXt(),getXt(),null);
	}
	
	@Override
	public void anima() { //Permite el movimiento del objeto de puntuacion y en caso de llegar a los limites del mapa, rebotara
		setX(getX()+getVx());
		setY(getY()+getVy());
		if (getX()<0){
			setVx(-getVx());
		}
		if (getY()<0){
			setVy(-getVy());
		}
		if (getX()>1750){
			setVx(-getVx());
		}		
		if (getY()>950){
			setVy(-getVy());
		}
		
	}
	

}