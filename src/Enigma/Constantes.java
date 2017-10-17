package Enigma;

abstract class Constantes {

    // En todos los alfabetos se deja un espacio en blanco al principio para usar una configuración más natural en adelante. Empezando en 1, no en 0.

    static final String alfabeto = " ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    static final String rotorI = " EKMFLGDQVZNTOWYHXUSPAIBRCJ";
    static final char saltoI = 'Q';

    static final String rotorII = " AJDKSIRUXBLHWTMCQGZNPYFVOE";
    static final char saltoII = 'E';

    static final String rotorIII = " BDFHJLCPRTXVZNYEIWGAKMUSQO";
    static final char saltoIII = 'V';

    static final String reflector = " YRUHQSLDPXNGOKMIEBFZCWVJAT";

    // Devuelve el índice del caracter introducido. Se compara con el alfabeto común.
    static int indiceCaracter(char caracter) {
        return alfabeto.indexOf(caracter);
    }
}
