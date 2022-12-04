package recycleGame;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import base.Juego;

public class RecycleToSurvive extends Juego {

	private ImagenEst fondo; // Imagen de fondo del juego
	private static int velocitat = 20; // Velocidad estandar del personaje
	private Enemigo[] enemigos;
	private int contador; // Variable para las iteraciones de los enemigos
	private Jugador jugador;
	private Jugador jugador2;
	private ImagenEst gameover; // Imagen de GAME OVER
	private Punto punto;
	private Puntuacion puntuacion;
	public int revivir;
	public int restriccion;

	public RecycleToSurvive() {
		super("Vamos a reciclar!", 1800, 1000);
		// Las variables numericas de super indican el tamaño de la ventana
		// Si se desea modificar este tamaño, se debe considerar tambien la modificacion
		// de los parametros de limite para jugador, enemigo y punto

		inicializa();

		start();
	}

	public void inicializa() {
		restriccion = 5; // Variable que define cuantos puntos son necesarios para revivir
		revivir = 5; // Variable que mantiene la cantidad necesaria de puntos para revivir
		int maxEnemigos = 10; // Variable que define la cantidad de enemigos que habra
		fondo = new ImagenEst("fondo.jpg", 0, 0, 1800, 1000);
		area.add(fondo);
		jugador = new Jugador("pj.png", 20, 20, 60, 0, 0);
		jugador2 = new Jugador("pj.png", 1700, 900, 60, 0, 0);
		enemigos = new Enemigo[100]; // Cantidad maxima de enemigos permitidos
		contador = 0;
		punto = new Punto("punt.png", (int) ((Math.random() * 1750) + 10), (int) ((Math.random() * 950) + 10),
				(int) ((Math.random() * 40) + 40), 10, 10); // Genera el icono de punto en un espacio aleatorio
		// Las primeras dos variables generadas de manera random, delimitan el
		// Spawnpoint del punto

		// getEnC devuelve una imagen, para que el tipo de enemigo sea al azar, metodo
		// mas abajo
		while (contador < maxEnemigos) { // Añade un enemigo (con una posicion generada de manera random) al array de
											// enemigos
			add(new Enemigo(getEnC(), (int) ((Math.random() * 1750) + 10), (int) ((Math.random() * 950) + 10),
					(int) ((Math.random() * 40) + 40), (int) ((Math.random() * 10) + 10),
					(int) ((Math.random() * 10) + 10)));
			// Las primeras dos variables generadas de manera random, delimitan el
			// Spawnpoint del enemigo

		}
		puntuacion = new Puntuacion(10, 20);

		area.add(puntuacion);
		area.add(jugador);
		area.add(jugador2);
		area.add(punto);
		temporizador2.add(jugador); // Temporizador para el estado del jugador 1
		temporizador3.add(jugador2); // Temporizador para el estado del jugador 2
		temporizador.add(punto);
		temporizador.add(puntuacion);

		// Añade todos los enemigos del array enemigos al area del juego
		areaAddEnemics();

		// Añade todos los enemigos del array enemigos al temporizador global
		tempAddEnemics();
	}

	// Funcion para generar los enemigos con uno de los 4 iconos posibles al azar
	private String getEnC() {
		int num = (int) (4 * Math.random());
		String color = "rojo.png";
		switch (num) {
			case 1:
				color = "rojo.png";
				break;
			case 2:
				color = "azul.png";
				break;
			case 3:
				color = "groc.png";
				break;
			case 0:
				color = "verd.png";
				break;
		}
		return color;
	}

	public void add(Enemigo enemigo) {

		enemigos[contador] = enemigo;
		contador++;
	}

	public void areaAddEnemics() {

		for (int i = 0; i < contador; i++) {
			area.add(enemigos[i]);
		}
	}

	public void tempAddEnemics() {

		for (int i = 0; i < contador; i++) {
			temporizador.add(enemigos[i]);
		}
	}

	public static int getVelocitat() {
		return velocitat;
	}

	public static void setVelocitat(int velocitat) {
		RecycleToSurvive.velocitat = velocitat;
	}

	// El siguiente metodo permite leer las interacciones con el teclado para el
	// movimiento del personaje1
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			if (getVelocitat() < 30) {
				setVelocitat(getVelocitat() + 1);
			}
			jugador.setVelocidad(0, -getVelocitat());
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			if (getVelocitat() < 30) {
				setVelocitat(getVelocitat() + 1);
			}
			jugador.setVelocidad(0, getVelocitat());
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			if (getVelocitat() < 30) {
				setVelocitat(getVelocitat() + 1);
			}
			jugador.setVelocidad(-getVelocitat(), 0);
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			if (getVelocitat() < 30) {
				setVelocitat(getVelocitat() + 1);
			}
			jugador.setVelocidad(getVelocitat(), 0);
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			if (jugador.getCrashed() && jugador2.getCrashed()) { // En caso de que ambos jugadores pierdan, permite que
																	// al dar SPACE se reinicie el juego
				gameover.setVisible(false);
				jugador.setCrashed(false);
				jugador2.setCrashed(false);
				velocitat = 20;
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
		// El siguiente metodo permite leer las interacciones con el teclado para el
		// movimiento del personaje2
		if (e.getKeyCode() == KeyEvent.VK_NUMPAD8) {
			if (getVelocitat() < 30) {
				setVelocitat(getVelocitat() + 1);
			}
			jugador2.setVelocidad(0, -getVelocitat());
		}
		if (e.getKeyCode() == KeyEvent.VK_NUMPAD2) {
			if (getVelocitat() < 30) {
				setVelocitat(getVelocitat() + 1);
			}
			jugador2.setVelocidad(0, getVelocitat());
		}
		if (e.getKeyCode() == KeyEvent.VK_NUMPAD4) {
			if (getVelocitat() < 30) {
				setVelocitat(getVelocitat() + 1);
			}
			jugador2.setVelocidad(-getVelocitat(), 0);
		}
		if (e.getKeyCode() == KeyEvent.VK_NUMPAD6) {
			if (getVelocitat() < 30) {
				setVelocitat(getVelocitat() + 1);
			}
			jugador2.setVelocidad(getVelocitat(), 0);
		}

	}

	// El siguiente metodo sirve para comprobar las coliciones entre el jugador y
	// los enemigos o el punto
	@Override
	public void comprobaciones() {

		Rectangle rect = new Rectangle(jugador.getX(), jugador.getY(), jugador.getXt(), jugador.getXt());
		Rectangle rect2 = new Rectangle(jugador2.getX(), jugador2.getY(), jugador2.getXt(), jugador2.getXt());

		Rectangle[] rectangles;
		Rectangle[] rectangles2;
		rectangles = new Rectangle[contador];
		rectangles2 = new Rectangle[contador];
		for (int i = 0; i < contador; i++) {
			rectangles[i] = new Rectangle(enemigos[i].getX(), enemigos[i].getY(), enemigos[i].getXt(),
					enemigos[i].getXt());
			if (rect.intersects(rectangles[i])) { // Si la posicion del jugador1 y la de algun enemigo es la misma
													// (Existe una colicion)
				if (!jugador.isInvulnerable()) { // Mientras el jugador no sea invulnerable
					jugador.setCrashed(true); // Ir al metodo crashed para detener al jugador y cambiar su icono
				}
			}
		}
		//////////////////////////////////////
		for (int i = 0; i < contador; i++) {
			rectangles2[i] = new Rectangle(enemigos[i].getX(), enemigos[i].getY(), enemigos[i].getXt(),
					enemigos[i].getXt());
			if (rect2.intersects(rectangles2[i])) { // Si la posicion del jugador2 y la de algun enemigo es la misma
													// (Existe una colicion)
				if (!jugador2.isInvulnerable()) { // Mientras el jugador no sea invulnerable
					jugador2.setCrashed(true); // Ir al metodo crashed para detener al jugador y cambiar su icono
				}
			}
		}

		Rectangle rectp = new Rectangle(punto.getX(), punto.getY(), punto.getXt(), punto.getXt());
		if (rect.intersects(rectp) || rect2.intersects(rectp)) { //// Si la posicion de alguno de los jugadores y la del
																	//// punto es la misma (Existe una colicion)
			punto.setX((int) ((Math.random() * 1700) + 10));
			punto.setY((int) ((Math.random() * 900) + 10));
			punto.setVx((int) ((Math.random() * 10) + 10));
			punto.setVy((int) ((Math.random() * 10) + 10));
			// Las instrucciones anteriores se encargan de volver a generar el punto en un
			// area al azar
			puntuacion.setA(puntuacion.getA() + 1); // Aumentar el contador de puntuacion
		}
		if ((puntuacion.getA()) == revivir) { // Metodo que revive al
			revivir += restriccion; // La puntuacion necesaria para revivir se incrementa segun el valor de
									// "restriccion"
			jugador.setInvulnerable(true);
			jugador2.setInvulnerable(true);
			jugador.setCrashed(false);
			jugador2.setCrashed(false);
			velocitat = 20;
			temporizador2.restart();
			temporizador3.restart();
			temporizador2.vacia();
			temporizador3.vacia();
			temporizador2.add(jugador);
			temporizador3.add(jugador2);
			area.repaint();
			// Las instrucciones anteriores se encargar de revivir a los jugadores, asi como
			// re-inicializar sus variables necesarias para volver a su estado de "jugable"
		}
		if ((puntuacion.getA() % restriccion) == 0) { // Mientras la puntuacion sea divisible entre el valor de
														// restriccion, los jugadores seran invulnerables
			jugador.setInvulnerable(true);
			jugador2.setInvulnerable(true);
		} else {
			jugador.setInvulnerable(false);
			jugador2.setInvulnerable(false);
		}
		if (jugador.getCrashed()) { // En caso de encontrar una colision, el jugador1 pasa a un estado de "No
									// jugable"
			temporizador2.stop();
		}
		if (jugador2.getCrashed()) { // En caso de encontrar una colision, el jugador2 pasa a un estado de "No
										// jugable"
			temporizador3.stop();
		}
		if (jugador.getCrashed() && jugador2.getCrashed()) { // Si ambos jugadores se encuentran en "No jugable" el
																// juego termina
			temporizador.stop();
			gameover = new ImagenEst("gameover.png", 300, 200, 1300, 700);
			area.add(gameover);
		}

	}

	public static void main(String[] args) {
		new RecycleToSurvive();
	}

}
