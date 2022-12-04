package base;

import java.awt.event.*;

public abstract class Juego implements ActionListener, KeyListener { // Clase abstracta que heredara la clase con el
																		// Main para correr el juego

	protected AreaDibujo area;
	protected Temporizador temporizador; // Temporizador global
	protected Temporizador temporizador2; // Temporizador para el jugador1
	protected Temporizador temporizador3; // Temporizador para el jugador2

	public Juego(String titulo, int ancho, int alto) { // Constructor de la ventana del juego
		// Sus variables de entrada son el Titulo y las dimensiones de la ventaja
		area = new AreaDibujo(titulo, ancho, alto);
		area.addKeyListener(this);
		temporizador = new Temporizador(50, this);
		temporizador2 = new Temporizador(50, this);
		temporizador3 = new Temporizador(50, this);
	}

	public void start() { // Iniciar los temporizadores de jugadores y global
		temporizador.start();
		temporizador2.start();
		temporizador3.start();
	}

	public abstract void comprobaciones();

	@Override
	public void actionPerformed(ActionEvent e) { // Registrar y verificar entradas por teclado
		comprobaciones();
		area.repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

}
