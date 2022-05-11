package main;

import java.util.Random;
import java.util.Scanner;
import model.*;


public class Main {

    public static void main(String[] args) {
        Lista listaNodos = new Lista();
        Rick j1 = new Rick();
        Morty j2 = new Morty();
        int nuevo = 0;
        int cont = 0;
        int eleccion;
        int Filas, Columnas, Opcion = 9, dado;
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        //pedir Filas y Columnas
        System.out.println("Ingrese el numero de filas: ");
        Filas = sc.nextInt();
        System.out.println("Ingrese el numero de Columnas: ");
        Columnas = sc.nextInt();

        // Pedir semillas
        int cantSemillas = 9999;
        while (cantSemillas > ((Filas * Columnas) / 2)) {
            System.out.println("\nla cantidad tiene que ser menor o igual a " + (Filas * Columnas)*0.5);
            System.out.println("Cuantas semillas hay en el tablero: ");
            cantSemillas = sc.nextInt();
        }

        // Pedir portales
        int cantPortales = 9999;
        while (cantPortales > ((Filas * Columnas) / 2)) {
            System.out.println("\nla cantidad tiene que ser menor o igual a " + (Filas * Columnas) / 2);
            System.out.println("Cuantos portales hay en el tablero: ");
            cantPortales = sc.nextInt();
        }

        //Crear Jugadores
        String player1, player2;
        System.out.println("Ingrese el nombre del jugador 1 (Rick):");
        sc.nextLine();
        player1 = sc.nextLine();
        System.out.println("Ingrese el nombre del jugador 2 (Morty):");
        player2 = sc.nextLine();

        j1.setNombre(player1);
        j1.setPocicion(rand.nextInt((Filas * Columnas) - 1) + 1);
        j2.setNombre(player2);
        j2.setPocicion(rand.nextInt((Filas * Columnas) - 1) + 1);

        //generar semillas
        int i = 0;
        int[] semillas = new int[cantSemillas];
        semillas[i] = rand.nextInt((Filas * Columnas) - 1) + 1;
        while (semillas[i] == j1.getPocicion() || semillas[i] == j2.getPocicion()) {
            semillas[i] = rand.nextInt((Filas * Columnas) - 1) + 1;
        }

        for (i = 1; i < cantSemillas; i++) {
            semillas[i] = rand.nextInt((Filas * Columnas) - 1) + 1;
            for (int j = 0; i > j; j++) {
                if (semillas[i] == semillas[j] || semillas[i] == j1.getPocicion() || semillas[i] == j2.getPocicion()) {
                    i--;
                }
            }
        }

        //Generar portales
        i = 0;
        int[] conexion = new int[cantPortales * 2];
        int[] portales = new int[cantPortales * 2];
        int contador = 2;
        int pos = 1;

        portales[i] = rand.nextInt((Filas * Columnas) - 1) + 1;
        conexion[i] = pos;
        for (i = 1; i < portales.length; i++) {
            portales[i] = rand.nextInt((Filas * Columnas) - 1) + 1;
            conexion[i] = pos;
            for (int j = 0; i > j; j++) {
                if (portales[i] == portales[j]) {
                    contador--;
                    i--;
                }
            }
            contador++;
            if (contador > 2) {
                contador = 1;
                pos++;
            }
        }

        //crear tablero
        for (i = 0; i < Columnas; i++) {
            for (int j = 0; j < Filas; j++) {
                listaNodos.insertarNodo(Columnas, Filas, semillas, portales, conexion);
            }
        }

        //menu opciones
        
        int turno = 1;
        System.out.println("\n--------------------------------------------------------------------------------\n"
                         + "------------------------QUE EMPIECE EL JUEGO------------------------------------\n"
                         + "--------------------------------------------------------------------------------\n");
        while (Opcion != 0) {
        	for(int a = 0; a > semillas.length; a++) {
        		cont += semillas[i];
        	}
        	if(cont == 0) {
        		int puntaje1 = j1.getPuntos()*120;
        		int puntaje2 = j2.getPuntos()*120;
        		if(puntaje1 > puntaje2 ) {
        			System.out.println("El juego ha terminado");
        			System.out.println("El jugador "+j1.getNombre()+"Ha ganado con: "+puntaje1);
        		}
        		if(puntaje2 > puntaje1) {
        			System.out.println("El juego ha terminado");
        			System.out.println("El jugador " + j2.getNombre() + "ha ganado: " + puntaje2);
        		}
        	}
            if(turno == 1){
                System.out.println("\nEs el turno de Rick: "+j1.getNombre()+" ¿Que deseas hacer?: \n"
                    + "1. Tirar dado \n"
                    + "2. Ver tablero \n"
                    + "3. ver enlaces \n"
                    + "4. Marcador \n"
                    + "0. salir \n");
            }else{
                System.out.println("\nEs el turno de Morty: "+j2.getNombre()+" ¿Que deseas hacer?: \n"
                    + "1. Tirar dado \n"
                    + "2. Ver tablero \n"
                    + "3. ver enlaces \n"
                    + "4. Marcador \n"
                    + "0. salir \n");
            }
            

            Opcion = sc.nextInt();
            switch (Opcion) {
                case 1:
                    dado = rand.nextInt(6);
                    if (turno == 1) {
                        System.out.println("Rick: " + j1.getNombre() + " te salio: " + dado);
                        System.out.println("1. quieres avanzar \n"
                                + "2. quieres retroceder");
                        eleccion = sc.nextInt();
                        if (eleccion == 1) {
                            if ((j1.getPocicion() + dado) > (Filas * Columnas)) {
                                dado = (dado + j1.getPocicion()) - (Filas * Columnas);
                                j1.setPocicion(dado);
                            } else {
                                j1.setPocicion(j1.getPocicion() + dado);
                            }
                        } else {
                            if ((j1.getPocicion() - dado) < 1) {
                                dado = (Filas * Columnas) - ((dado - j1.getPocicion()) * (-1));
                                j1.setPocicion(dado);
                            } else {
                                j1.setPocicion(j1.getPocicion() - dado);
                            }
                        }

                        int dato = listaNodos.validarTP(j1.getPocicion(), portales, conexion);
                        if (dato != 0) {
                            for (int k = 0; k < conexion.length; k++) {
                                if (conexion[k] == dato && j1.getPocicion() != portales[k]) {
                                    nuevo = portales[k];
                                }
                            }
                            j1.setPocicion(nuevo);
                        }
                        if (listaNodos.validarPunto(j1.getPocicion(), semillas)) {
                            semillas = listaNodos.actualizarSemillas(j1.getPocicion(), semillas);
                            j1.sumarPuntos();
                        }
                        turno = 2;
                    } else {
                        System.out.println("Morty: " + j2.getNombre() + " te salio: " + dado);
                        System.out.println("1. quieres avanzar. \n"
                                + "2. quieres retroceder");
                        eleccion = sc.nextInt();
                        if (eleccion == 1) {
                            if ((j2.getPocicion() + dado) > (Filas * Columnas)) {
                                dado = (dado + j2.getPocicion()) - (Filas * Columnas);
                                j2.setPocicion(dado);
                            } else {
                                j2.setPocicion(j2.getPocicion() + dado);
                            }
                        } else {
                            if ((j2.getPocicion() - dado) < 1) {
                                dado = (Filas * Columnas) - ((dado - j2.getPocicion()) * (-1));
                                j2.setPocicion(dado);
                            } else {
                                j2.setPocicion(j2.getPocicion() - dado);
                            }
                        }
                        int dato = listaNodos.validarTP(j2.getPocicion(), portales, conexion);
                        if (dato != 0) {
                            for (int k = 0; k < conexion.length; k++) {
                                if (conexion[k] == dato && j2.getPocicion() != portales[k]) {
                                    nuevo = portales[k];
                                }
                            }
                            j2.setPocicion(nuevo);
                        }

                        if (listaNodos.validarPunto(j2.getPocicion(), semillas)) {
                            semillas = listaNodos.actualizarSemillas(j2.getPocicion(), semillas);
                            j2.sumarPuntos();
                        }
                        turno = 1;
                    }

                    break; 
                case 2:
                    listaNodos.mostrarNodos(Columnas, j1, j2);
                    break; 

                case 3:
                    listaNodos.mostrarPortales(Columnas);
                    break; 
                case 4:
                    System.out.println("Rick: " + j1.getNombre() + " tu puntaje va: " + j1.getPuntos() + " Semillas");
                    System.out.println("Morty: " + j2.getNombre() + " tu puntaje va: " + j2.getPuntos() + " Semillas");
                    break;
                default:
            }
        }
    }
}
