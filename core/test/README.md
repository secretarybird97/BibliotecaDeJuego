# Test

Esta biblioteca sirve como el motor principal de nuestro juego Recyling Game. Varias funcinoes (si no es que todas) estan orientadas para el uso de nuestro juego, pero con algunos cambios facilmente se puede implementar para usarse en algún otro proyecto.

A continuación se explicaran las clases de la biblioteca y como usarse:

---

## Base

![Diagrama](DiagramaUML.jpg)

Aquí se encuentran las clases base e interfaces que son utilizadas en la carpeta principal del juego.

### Animado

Todos los objetos que se muevan o sean dinamicos implementan esta interfaz

### AreaDibujo

Esta clase se extiende de JPanel. Genera la ventana que se utilizara para la interfaz grafica del juego

### Dibujable

Todo aquel objeto que vaya a ser dibujado/renderizado en pantalla implementa esta interfaz

- `public void dibuja(Graphics g)`

### Temporizador

Esta clase permite que el juego corra en tiempo real. Se usa para registrar enemigos, puntuacion, entre otras cosas.

### Juego

Clase abstracta que el programador utilizara para correr el juego

---

## Test

Aqui se encuentra un ejemplo con clases sobre como utilizar la biblioteca, tomando como referencia nuestro videojuego de recyclingGame.

---

## ¿Como utilizar la biblioteca?

1. Clonar el repositorio en su dispositivo
2. blank
