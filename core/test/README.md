# Test

Esta biblioteca sirve como el motor principal de nuestro juego Recyling Game. Varias funcinoes (si no es que todas) estan orientadas para el uso de nuestro juego, pero con algunos cambios facilmente se puede implementar para usarse en algún otro proyecto o modificar el juego ya existente para generar variantes del mismo, o incluso implementarle una tematica distinta al mismo tipo de juego, segun las necesidades del usuario.

A continuación se explicaran las clases de la biblioteca y como usarse:

---

## Base

![Diagrama](DiagramaUML.jpg)

Aquí se encuentran las clases base e interfaces que son utilizadas en la carpeta principal del juego.

### Animado

Todos los objetos que se muevan o sean dinamicos implementan esta interfaz que contiene unicamente el metodo anima.

### AreaDibujo

Esta clase se extiende de JPanel. Genera la ventana que se utilizara para la interfaz grafica del juego. Es importante para definir el "tablero" o la base estatica en la que se estara corriendo el juego, asi como poder graficar los sprites de los personajes, enemigos, puntuacion, etc., y darle movilidad al juego por medio de la graficacion de los elementos.

- `public void add(Dibujable obj)` que recibe un array de objetos que se utilizara para almacenar los enemigos generados a la hora de comenzar el juego.

- `public void vacia()` para liberar el arreglo a la hora de reiniciar el juego y se puedan generar nuevamente los enemigos aleatoriamente.

### Dibujable

Todo aquel objeto que vaya a ser dibujado/renderizado en pantalla implementa esta interfaz, que unicamente cuenta con un metodo pues la clase importa el paquete java.awt.Graphics para la graficacion y dibujo de las imagenes durante el juego.

- `public void dibuja(Graphics g)`

### Temporizador

Esta clase permite que el juego corra en tiempo real. Se usa para registrar enemigos, puntuacion, entre otras cosas. Ademas en caso de dos jugadores, es necesario crear un objeto temporizador global (para enemigos, puntuacion, etc) y crear nuevamente objetos temporizador individuales para cada jugador, de esta manera el estado de cada jugador es independiente, y esto permite que si alguno pierde, el juego no acabe hasta que ambos se encuentren en ese estado.
Por lo que en caso de querer agregar otro personaje, es tan simple como utilizar otro objeto de tipo temporizador para agregar a este nuevo jugador (ademas de agregar sus interacciones). 

### Juego

Clase abstracta que el programador utilizara para correr el juego
Esta clase cuenta con las variables de instancia protegidas: area y temporizadores.

- `public juego(String titulo, int ancho, int largo)` recibe una cadena para el titulo que mostrara la ventana del juego y dos valores enteros para las dimensiones con las que se generara la ventana. Cambiando estos valores es posible renombrar el juego y ajustar la ventana emergente a las dimensiones deseadas.

- `public void start()` iniciar todos los temporizadores utilizados

- `public abstract void comprobaciones()` este metodo abstracto sera utilizado por la clase que contiene el main, para considerar las interacciones entre los iconos y sus colisiones.

- `public void actionPerformed(ActionEvent e)` registra y verifica las entradas del teclado para el control de los personajes.



---

## Test

Aqui se encuentra un ejemplo con clases sobre como utilizar la biblioteca, tomando como referencia nuestro videojuego de recyclingGame.

---

## ¿Como utilizar la biblioteca?

1. Clonar el repositorio en su dispositivo
2. blank
