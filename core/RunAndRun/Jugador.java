package RunAndRun;

import java.awt.Graphics;

import javax.swing.ImageIcon;

public class Jugador extends Elemento {

	private boolean invulnerable;
	
	public Jugador(String recurso,int x, int y,int tx, int vx, int vy) {
		super(recurso, x, y, tx, vx, vy);
		invulnerable=false;
	}

	@Override
	public void dibuja(Graphics g) {
		if (isCrashed()){
			imagen = new ImageIcon(this.getClass().getResource("mort.png")).getImage();
			g.drawImage(imagen,getX(),getY(),getXt(),getXt(),null);
		}else{
			if(isInvulnerable()){
				imagen = new ImageIcon(this.getClass().getResource("pj-inv.png")).getImage();
				g.drawImage(imagen,getX(),getY(),getXt(),getXt(),null);
			}else{
				imagen = new ImageIcon(this.getClass().getResource("pj.png")).getImage();
				g.drawImage(imagen,getX(),getY(),getXt(),getXt(),null);
			}
		}
	}
	

	public boolean isInvulnerable() {
		return invulnerable;
	}
	
	@Override
	public void anima() {
		setX(getX()+getVx());
		setY(getY()+getVy());
		if (getX()<0 || getY()<0 || getX()>1750 || getY()>950){
			if(isInvulnerable()){
				if(getX()<0){
					setX(1750);
				}
				if(getX()>1750){
					setX(0);
				}
				if(getY()<0){
					setY(950);
				}
				if(getY()>950){
					setY(0);
				}
			}else{
				setCrashed(true);
			}
		}
	}

	public void setInvulnerable(boolean invulnerable) {
		this.invulnerable = invulnerable;
	}

}
