package Ejercicios;

import java.util.Scanner;
import java.util.function.DoubleToIntFunction;

public class Simulacro {
    public static void main() {
        Scanner sc = new Scanner(System.in);
        int respuesta = 0;
        int movimientos = 10;
        int jugadorFila = 0;
        int jugadorColumna = 0;
        do {
            System.out.println("Que ejercicio entraras\n" +
                    "Ejercicio 1-1\n" +
                    "Ejercicio 2-2\n" +
                    "Salir-0");
            respuesta = sc.nextInt();
            sc.nextLine();
            switch (respuesta) {
                case 0 :
                    System.out.println("Adios");
                    break;
                case 1 :
                    ejercicio1();
                    break;
                case 2 :
                    System.out.println("¡Bienvenido al juego 'Escapa del Laberinto'!\nTu objetivo es llegar a la salida en la posición (3,3).");
                    ejercicio2(movimientos, jugadorFila, jugadorColumna);
                    break;
                default :
                    System.out.println("Respuesta No Valida");
                    break;
            }
        } while (respuesta != 0);
    }

    private static void ejercicio1() {
        Scanner sc = new Scanner(System.in);
        String frase;
        do {
            System.out.println("Escribe una frase");
            frase = sc.nextLine();
        } while (frase.isEmpty());
        cuentaCaracteres(frase);
        cuentaVocales(frase);
        main();
    }

    private static void cuentaCaracteres(String frase) {
        String espacio = " ";
        int contadorEspacios = 0;
        for (int i = 0; i < frase.length(); i++) {
            if (frase.charAt(i) == espacio.charAt(0)) {
                contadorEspacios++;
            }
        }
        System.out.println("La frase tiene " + (frase.length() - contadorEspacios) + " letras");
    }

    private static void cuentaVocales(String frase) {
        Scanner sc = new Scanner(System.in);
        String vocal;
        int contadorVocal = 0;
        boolean continua = true;
        do {
            System.out.println("Que vocal quieres contar");
            vocal = sc.nextLine();
                if(vocal.equalsIgnoreCase("a")){
                    continua = false;
                }else if(vocal.equalsIgnoreCase("e")){
                    continua=false;
                }else if(vocal.equalsIgnoreCase("i")){
                    continua=false;
                }else if(vocal.equalsIgnoreCase("o")){
                    continua=false;
                }else if(vocal.equalsIgnoreCase("u")){
                    continua=false;
                }else {
                    continua=true;
                }
        } while (continua || vocal.length() > 1);
        for (int i = 0; i < frase.length(); i++) {
            if (frase.charAt(i) == vocal.charAt(0)) {
                contadorVocal++;
            }
        }
        System.out.println("Tiene " + contadorVocal + " " + vocal);
    }

    private static void ejercicio2(int movimientos, int jugadorFila, int jugadorColumna) {
        Scanner sc = new Scanner(System.in);
        final int SALIDA_FILA = 3;
        final int SALIDA_COLUMNA = 3;
        System.out.println("Te quedan "+movimientos+" movimientos");
        System.out.println("A donde te vas a mover\n" +
                "Arriba- w\n" +
                "Abajo- s\n" +
                "Derecha- d\n" +
                "Izquierda- a");
        boolean continua = true;
        String direccion = "";
        do {
            direccion = sc.nextLine();
            if(direccion.equalsIgnoreCase("w")){
                continua = false;
            }else if(direccion.equalsIgnoreCase("a")){
                continua=false;
            }else if(direccion.equalsIgnoreCase("s")){
                continua=false;
            }else if(direccion.equalsIgnoreCase("d")){
                continua=false;
            }else{
                System.out.println("Opción no valida");
                continua=true;
            }
        } while (continua || direccion.length() > 1);
        movimientos--;
        if (direccion.equalsIgnoreCase("w")) {
            jugadorColumna++;
        } else if (direccion.equalsIgnoreCase("s")) {
            jugadorColumna--;
        } else if (direccion.equalsIgnoreCase("a")) {
            jugadorFila--;
        } else if (direccion.equalsIgnoreCase("d")) {
            jugadorFila++;
        }
        if (jugadorColumna == SALIDA_COLUMNA && jugadorFila == SALIDA_FILA) {
            System.out.println("Has llegado");
            main();
        } else {
            darPista(movimientos,jugadorFila, jugadorColumna);
        }
        if (movimientos==0){
            main();
        }else {
            ejercicio2(movimientos, jugadorFila, jugadorColumna);
        }
    }
    private static void darPista(int movimientos,int jugadorFila,int jugadorColumna){
        if(jugadorFila<3&&jugadorColumna<3){
            System.out.println("La salida está arriba a la derecha");
        }else if(jugadorFila>3&&jugadorColumna>3){
            System.out.println("La salida está abajo a la izquierda");
        }else if(jugadorFila<3&&jugadorColumna>3){
            System.out.println("La salida está abajo a la derecha");
        }else{
            System.out.println("La salida está arriba a la  izquierda");
        }
        ejercicio2(movimientos,jugadorFila,jugadorColumna);
    }
}
