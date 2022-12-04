# Biblioteca para juegos - Equipo D

Esta biblioteca sirve como el motor principal de nuestro juego Recyling Game. Varias funcinoes (si no es que todas) estan orientadas para el uso de nuestro juego, pero con algunos cambios facilmente se puede implementar para usarse en algún otro proyecto.

A continuación se explicaran las clases de la biblioteca y como usarse:

## Base

Aquí se encuentran las clases base e interfaces que son utilizadas en la carpeta principal del juego.

---

### Animado

Todos los objetos que se muevan o sean dinamicos implementan esta interfaz

### AreaDibujo

Esta clase se extiende de JPanel. Genera la ventana que se utilizara para la interfaz grafica del juego

### Dibujable

Todo aquel objeto que vaya a ser dibujado/renderizado en pantalla implementa esta interfaz

- public void dibuja(Graphics g)
