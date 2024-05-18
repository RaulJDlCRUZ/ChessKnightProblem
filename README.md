# ChessKnightProblem
Trabajo teórico Fundamentos de Programación I
## Enunciado
En el ajedrez, un caballo “come” (o cubre) en forma de ‘L’ en todas direcciones. Se pide realizar un programa que, dado un tablero de NxN, donde N es un valor entero positivo que se introduce por teclado, el usuario vaya introduciendo caballos en las filas y columnas que desee hasta que todo el tablero quede cubierto por el poder de los caballos.

Para ello, el programa le pedirá al usuario la fila y la columna de la casilla en la que desee colocar un caballo. Cada vez que se introduzca un caballo en una posición del tablero válida, no cubierta por otro caballo introducido previamente, la posición del caballo se marcará con el valor ‘C’ y todas las casillas que queden cubiertas por dicho caballo se marcarán con el valor ‘x’, mostrando, a continuación, el estado del tablero. Si al introducir un caballo en una casilla, ésta ya estuviera cubierta por otro introducido antes (es decir, la casilla tiene el valor ‘x’ o ‘C’) o cayera fuera de los bordes del tablero, el programa mostrará un mensaje al usuario indicando la situación y no hará nada. 

El programa finaliza cuando todo el tablero está cubierto por el efecto de los caballos colocados, mostrando el número de ellos utilizados.

