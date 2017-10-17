package Enigma;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StringBuilder resultado = new StringBuilder();

        System.out.println("Estas usando un simulador Enigma con soporte para 3 rotores, reflector B y etiquetas\n");

        System.out.println("Escribe la clave pulsando la tecla Intro despues de cada letra. Orden: Rotor I, Rotor II, Rotor III. Ejemplo: C[Intro]H[Intro]S");
        String rI = sc.nextLine();
        String rII = sc.nextLine();
        String rIII = sc.nextLine();

        System.out.println("Escribe el texto que quieres cifrar.");
        String texto = sc.nextLine();

        System.out.println("Escribe las etiquetas que quieres tener cambiadas. Dejalo en blanco si no las quieres cambiar. Ejemplo: AM;HE;QV");
        String etiquetas = sc.nextLine();

        if (etiquetas.equals("")) {
            etiquetas = "AA";
        }

        // Se comprueba que no se han usado los caracteres ñ, espacio o en blanco en el texto a cifrar
        if (texto.matches("(.*)Ñ(.*)") || texto.matches("(.*)ñ(.*)") || texto.matches("Ñ(.*)") || texto.matches("ñ(.*)") || texto.matches("(.*)Ñ") || texto.matches("(.*)ñ")) {
            System.out.println("El texto que has escrito contiene la letra Ñ, que no es soportada. Escribe el texto de nuevo.");
            texto = sc.nextLine();
        } else if (texto.matches("(.*) (.*)") || texto.matches(" (.*)") || texto.matches("(.*) ") || texto.matches(" ")) {
            System.out.println("El texto que has escrito contiene uno o mas espacios. Debes eliminarlos para continuar. Escribe el texto de nuevo.");
            texto = sc.nextLine();
        } else if (texto.matches("")) {
            System.out.println("No has escrito nada. Escribe el texto ahora.");
            texto = sc.nextLine();
        }

        // Se convierte a texto en mayúsculas
        rI = rI.toUpperCase();
        rII = rII.toUpperCase();
        rIII = rIII.toUpperCase();
        texto = texto.toUpperCase();
        etiquetas = etiquetas.toUpperCase();

        // Se crea el objeto Enigma con la configuración predeterminada
        Enigma enigma = new Enigma(new Rotor(Constantes.rotorI, rI.charAt(0), Constantes.saltoI),
                new Rotor(Constantes.rotorII, rII.charAt(0), Constantes.saltoII),
                new Rotor(Constantes.rotorIII, rIII.charAt(0), Constantes.saltoIII),
                new Reflector(),
                new Etiquetas(etiquetas));

        // Se pasa cada carácter por el simulador Enigma
        for (int i = 0; i < texto.length(); i++) {
            resultado.append(enigma.caracterCifrado(texto.charAt(i)));
        }

        System.out.println("\n******** TEXTO CIFRADO ********");
        System.out.println(resultado);
        System.out.println("*******************************");
    }
}
