package RunAndRun;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import base.Juego;

public class JuegoRunAndRun extends Juego {

	private ImagenEst fondo;
	private static int velocitat=20;
	private Enemigo[] enemigos;
	private int contador;
	private Jugador jugador;
	private Jugador jugador2;
	private ImagenEst gameover;
	private Punto punto;
	private Puntuacion puntuacion;
	public int i;
	
	public JuegoRunAndRun() {
		super("Run And Run!", 1800, 1000);
		
		inicializa();
		
		 start();
	}
	
	public void inicializa(){
		i=5;
		fondo = new ImagenEst("fondo.jpg",0,0,1800,1000);
		area.add(fondo);
		jugador= new Jugador("pj.png",20,20,60,0,0);
		jugador2= new Jugador("pj2.png",1700,900,60,0,0);
		enemigos = new Enemigo[100];
		contador = 0;
		punto = new Punto("punt.png",(int) ((Math.random()*1750)+10),(int) ((Math.random()*950)+10),(int) ((Math.random()*40)+40),10,10);
		//añade un enemigo a la array de enemigos, el metodo esta mas abajo
		//getEnC devuelve una imagen, para que el tipo de enemigo sea al azar, metodo mas abajo
		while(contador<10){
			add(new Enemigo(getEnC(),(int) ((Math.random()*1750)+10),(int) ((Math.random()*950)+10),(int) ((Math.random()*40)+40),(int) ((Math.random()*10)+10),(int) ((Math.random()*10)+10)));
		}
		puntuacion=new Puntuacion(10,20);
		
		area.add(puntuacion);
		area.add(jugador);
		area.add(jugador2);
		area.add(punto);
		temporizador2.add(jugador);
		temporizador3.add(jugador2);
		temporizador.add(punto);
		temporizador.add(puntuacion);
		
		
		// metodo que añade todos los enemigos del array enemigos a la area
		areaAddEnemics();

		// metodo que añade todos los enemigos del array enemigos al temporizador
		tempAddEnemics();
	}
	
	//getEnemicColor
	private String getEnC() {
		int num=(int) (4 * Math.random());
		String color = "rojo.png";
		switch (num) {
		case 1:
			color="rojo.png";
			break;
		case 2:
			color="azul.png";
			break;
		case 3:
			color="groc.png";
			break;
		case 0:
			color="verd.png";
			break;
		}
		return color;
	}
	

	public void add(Enemigo enemigo){
	       
    	enemigos[contador] = enemigo;
    	contador++;
    }
	
	public void areaAddEnemics(){
		
        for (int i=0; i<contador;i++){
            area.add(enemigos[i]);
        }
    }
	
	public void tempAddEnemics(){
	       
        for (int i=0; i<contador;i++){
            temporizador.add(enemigos[i]);
        }
    }
	
	public static int getVelocitat() {
		return velocitat;
	}
	public static void setVelocitat(int velocitat) {
		JuegoRunAndRun.velocitat = velocitat;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_UP){
			if(getVelocitat()<30){
					setVelocitat(getVelocitat() + 1);
			}
			jugador.setVelocidad(0, -getVelocitat());
		}
		if(e.getKeyCode()==KeyEvent.VK_DOWN){
			if(getVelocitat()<30){
				setVelocitat(getVelocitat() + 1);
		}
			jugador.setVelocidad(0, getVelocitat());
		}
		if(e.getKeyCode()==KeyEvent.VK_LEFT){
			if(getVelocitat()<30){
				setVelocitat(getVelocitat() + 1);
			}
			jugador.setVelocidad(-getVelocitat(), 0);
		}
		if(e.getKeyCode()==KeyEvent.VK_RIGHT){
			if(getVelocitat()<30){
				setVelocitat(getVelocitat() + 1);
			}
			jugador.setVelocidad(getVelocitat(), 0);
		}
		if(e.getKeyCode()==KeyEvent.VK_SPACE){
			if(jugador.getCrashed() && jugador2.getCrashed()){
				gameover.setVisible(false);
				jugador.setCrashed(false);
				jugador2.setCrashed(false);
				velocitat=20;
				temporizador.restart();
				temporizador2.restart();
				temporizador3.restart();
				area.vacia();
				temporizador.vacia();
				temporizador2.vacia();
				temporizador3.vacia();
				inicializa();
				area.repaint();
			}
		}
		////////////////////////////////////
		if(e.getKeyCode()==KeyEvent.VK_1){
			if(getVelocitat()<30){
					setVelocitat(getVelocitat() + 1);
			}
			jugador2.setVelocidad(0, -getVelocitat());
		}
		if(e.getKeyCode()==KeyEvent.VK_2){
			if(getVelocitat()<30){
				setVelocitat(getVelocitat() + 1);
		}
			jugador2.setVelocidad(0, getVelocitat());
		}
		if(e.getKeyCode()==KeyEvent.VK_3){
			if(getVelocitat()<30){
				setVelocitat(getVelocitat() + 1);
			}
			jugador2.setVelocidad(-getVelocitat(), 0);
		}
		if(e.getKeyCode()==KeyEvent.VK_4){
			if(getVelocitat()<30){
				setVelocitat(getVelocitat() + 1);
			}
			jugador2.setVelocidad(getVelocitat(), 0);
		}

	}

	@Override
	public void comprobaciones() {
		
		Rectangle rect = new Rectangle(jugador.getX(),jugador.getY(),jugador.getXt(),jugador.getXt());
		Rectangle rect2 = new Rectangle(jugador2.getX(),jugador2.getY(),jugador2.getXt(),jugador2.getXt());
		
		Rectangle[] rectangles;
		Rectangle[] rectangles2;
		rectangles = new Rectangle[contador];
		rectangles2 = new Rectangle[contador];
		for (int i=0; i<contador;i++){
			rectangles[i] = new Rectangle(enemigos[i].getX(),enemigos[i].getY(),enemigos[i].getXt(),enemigos[i].getXt());
			if(rect.intersects(rectangles[i])){
				if(!jugador.isInvulnerable()){
					jugador.setCrashed(true);
				}	
			}
        }
		//////////////////////////////////////
		for (int i=0; i<contador;i++){
			rectangles2[i] = new Rectangle(enemigos[i].getX(),enemigos[i].getY(),enemigos[i].getXt(),enemigos[i].getXt());
			if(rect2.intersects(rectangles2[i])){
				if(!jugador2.isInvulnerable()){
					jugador2.setCrashed(true);
				}	
			}
        }
		
		Rectangle rectp = new Rectangle(punto.getX(),punto.getY(),punto.getXt(),punto.getXt());
		if(rect.intersects(rectp) || rect2.intersects(rectp)){
			punto.setX((int) ((Math.random()*1700)+10));
			punto.setY((int) ((Math.random()*900)+10));
			punto.setVx((int) ((Math.random()*10)+10));
			punto.setVy((int) ((Math.random()*10)+10));
			puntuacion.setA(puntuacion.getA()+1);
		}
		if((puntuacion.getA()) == i) {
			i+=5;
			jugador.setInvulnerable(true);
			jugador2.setInvulnerable(true);
			jugador.setCrashed(false);
			jugador2.setCrashed(false);
			velocitat=20;
			temporizador2.restart();
			temporizador3.restart();
			temporizador2.vacia();
			temporizador3.vacia();
			temporizador2.add(jugador);
			temporizador3.add(jugador2);
			area.repaint();
		}
		if((puntuacion.getA()%5)==0){
			jugador.setInvulnerable(true);
			jugador2.setInvulnerable(true);
		}else{
			jugador.setInvulnerable(false);
			jugador2.setInvulnerable(false);
		}
		if(jugador.getCrashed()){
			temporizador2.stop();	
		}
		if(jugador2.getCrashed()){
			temporizador3.stop();	
		}
		if(jugador.getCrashed() && jugador2.getCrashed()){
			temporizador.stop();
			gameover= new ImagenEst("gameover.png",300,200,1300,700);
			area.add(gameover);	
		}
		
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new JuegoRunAndRun();
	}


}

