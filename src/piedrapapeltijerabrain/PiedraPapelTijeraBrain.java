/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package piedrapapeltijerabrain;

import java.util.Scanner;

/**
 *
 * @author José Miguel Cobo Manteca
 */
public class PiedraPapelTijeraBrain {

    /**
     * Es el método principal que ejecuta el juego.
     * El juego contra la máquina y el objetivo es cumplir la acción que te especifique en relación a un número aleatorio que saque.
     * El juego dura cinco rondas y al final se cálcula el tiempo empleado al que hay que sumar la penalización de 5 segundos por fallo cometido.
     * @param args the command line argument
     */
    public static void main(String[] args) {
// TODO code application logic here
        int chiquipuntos = 0;
        Scanner sc = new Scanner(System.in);
        String opcionJugador = "";
        String opcionBot = "";
        int exitoEnProposito = 1;
        long inicio = System.currentTimeMillis();
        for (int i = 0; i < 5; i++) {
            int proposito = (int) Math.floor(Math.random() * 2 + 1);
            if (proposito == 1) {
                System.out.println("\n\tIntenta ganar");
            }
            if (proposito == 2) {
                System.out.println("\n\tIntenta perder");
            }
            int j = (int) Math.floor(Math.random() * 3 + 1);
            if (j == 1) {
                opcionBot = "tijera";
                System.out.println(opcionBot);
                tijera();
            }
            if (j == 2) {
                opcionBot = "papel";
                System.out.println(opcionBot);
                papel();
            }
            if (j == 3) {
                opcionBot = "piedra";
                System.out.println(opcionBot);
                piedra();
            }
            do {
                System.out.println("Introduce tu jugada");
                opcionJugador = sc.nextLine();
                if (opcionBot.equals(opcionJugador)) {
                    System.out.println("No tiene sentido que intentes empatar");
                }
            } while (opcionBot == opcionJugador);
            if (opcionJugador.equals("tijera") && (opcionBot.equals("papel"))) {
                exitoEnProposito = 1;
            }
            if (opcionJugador.equals("papel") && (opcionBot.equals("tijera"))) {
                exitoEnProposito = -1;
            }
            if (opcionJugador.equals("tijera") && (opcionBot.equals("piedra"))) {
                exitoEnProposito = -1;
            }
            if (opcionJugador.equals("piedra") && (opcionBot.equals("tijera"))) {
                exitoEnProposito = 1;
            }
            if (opcionJugador.equals("piedra") && (opcionBot.equals("papel"))) {
                exitoEnProposito = -1;
            }
            if (opcionJugador.equals("papel") && (opcionBot.equals("piedra"))) {
                exitoEnProposito = 1;
            }
            if (proposito == 2) {
                exitoEnProposito *= -1;
            }
            if (exitoEnProposito == 1) {
                chiquipuntos++;
            }
        }
        long fin = System.currentTimeMillis();
        double tiempo = (double) ((fin - inicio) / 1000);
        System.out.println("Has realizado el ejercicio en " + tiempo + " segundos");
        int nFallos = 5 - chiquipuntos;
        System.out.println("Penalización: " + nFallos + " x 5s = " + nFallos * 5);
        double tiempoFinal = tiempo + nFallos * 5;
        System.out.println("Tu tiempo final es de " + tiempoFinal + " segundos");
        System.out.println("Vuelve a jugar con nosotros");
        System.out.println("Es muy divertido");
    }
    /**
     * Este método imprime una representación Asci de una tíjera.
     */
    public static void tijera() {
        System.out.println("'''\n"
                + " _______\n"
                + "---' ____)____\n"
                + " ______)\n"
                + " __________)\n"
                + " (____)\n"
                + "---.__(___)\n"
                + "'''");
    }
    /**
     * Este método imprime una representación Asci de una papel.
     */
    public static void papel() {
        System.out.println("'''\n"
                + " _______\n"
                + "---' ____)____\n"
                + " ______)\n"
                + " _______)\n"
                + " _______)\n"
                + "---.__________)");
    }
    /**
     * Este método imprime una representación Asci de una piedra.
     */
    public static void piedra() {
        System.out.println("'''\n"
                + " _______\n"
                + "---' ____)\n"
                + " (_____)\n"
                + " (_____)\n"
                + " (____)\n"
                + "---.__(___)\n"
                + "'''");
    }
}
