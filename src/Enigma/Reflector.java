package Enigma;

class Reflector {

    Reflector() {
    }

    int caracterCifrado(int numero) {
        String reflector = Constantes.reflector;
        char c = reflector.charAt(numero);
        return Constantes.alfabeto.indexOf(c);
    }
}
