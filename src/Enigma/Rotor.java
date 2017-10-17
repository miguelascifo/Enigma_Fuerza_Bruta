package Enigma;

class Rotor {

    private String configuracionRotor;
    private int posicionRotor;
    private int saltoRotor;
    private int anillo = Constantes.indiceCaracter("A".charAt(0));

    // Se inicializa el rotor según su número y configuración
    Rotor(String configuracionRotor, char posicionRotor, char saltoRotor) {
        this.configuracionRotor = configuracionRotor;
        this.posicionRotor = Constantes.indiceCaracter(posicionRotor);
        this.saltoRotor = Constantes.indiceCaracter(saltoRotor);
    }

    int caracterCifrado(int direccion, int numero) {

        numero = numero - anillo;
        numero = normalizar(numero);

        numero = numero + posicionRotor;
        numero = normalizar(numero);

        // direccion = 0 significa el camino de IDA
        // direccion = 1 significa el camino de VUELTA
        if (direccion == 0) {
            char c = configuracionRotor.charAt(numero);
            numero = Constantes.alfabeto.indexOf(c);
        } else {
            char c = Constantes.alfabeto.charAt(numero);
            numero = configuracionRotor.indexOf(c);
        }

        // Operación contraria para obtener el carácter
        numero = numero - posicionRotor;
        numero = normalizar(numero);

        numero = numero + anillo;
        numero = normalizar(numero);

        return numero;
    }

    // Empezar de nuevo si se llega al final del rotor y al contrario.
    private int normalizar(int numero) {
        if (numero > 26) {
            return numero - 26;
        } else if (numero < 1) {
            return 26 + numero;
        }
        return numero;
    }

    void incrementarPosicion() {
        posicionRotor++;
        if (posicionRotor > 26) {
            posicionRotor = 1;
        }
    }

    int posicionRotor() {
        return posicionRotor;
    }

    int saltoRotor() {
        return saltoRotor;
    }
}
