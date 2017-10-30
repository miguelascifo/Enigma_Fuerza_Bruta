package Enigma;

class Enigma {

    private Rotor rotorIzq;
    private Rotor rotorMed;
    private Rotor rotorDer;
    private Reflector reflector;
    private Etiquetas etiqueta;

    // Inicializar la máquina Enigma con la configuración del usuario
    Enigma(Rotor rotorIzq, Rotor rotorMed, Rotor rotorDer, Reflector reflector, Etiquetas etiqueta) {
        this.rotorIzq = rotorIzq;
        this.rotorMed = rotorMed;
        this.rotorDer = rotorDer;
        this.reflector = reflector;
        this.etiqueta = etiqueta;
    }

    char caracterCifrado(char c) {

        int indiceCaracter = Constantes.indiceCaracter(c);

        incrementarRotores(rotorIzq, rotorMed, rotorDer);
        //indiceCaracter = etiqueta.caracterCifrado(indiceCaracter);
        indiceCaracter = rotorDer.caracterCifrado(0, indiceCaracter);
        indiceCaracter = rotorMed.caracterCifrado(0, indiceCaracter);
        indiceCaracter = rotorIzq.caracterCifrado(0, indiceCaracter);
        indiceCaracter = reflector.caracterCifrado(indiceCaracter);
        indiceCaracter = rotorIzq.caracterCifrado(1, indiceCaracter);
        indiceCaracter = rotorMed.caracterCifrado(1, indiceCaracter);
        indiceCaracter = rotorDer.caracterCifrado(1, indiceCaracter);
        //indiceCaracter = etiqueta.caracterCifrado(indiceCaracter);

        c = Constantes.alfabeto.charAt(indiceCaracter);
        return c;
    }

    // Mover el rotor si el carácter usado es igual que el carácter de salto
    private void incrementarRotores(Rotor rotorIzq, Rotor rotorMed, Rotor rotorDer) {
        if (rotorDer.posicionRotor() == rotorDer.saltoRotor()) {
            if (rotorMed.posicionRotor() == rotorMed.saltoRotor()) {
                rotorIzq.incrementarPosicion();
            }
            rotorMed.incrementarPosicion();
        }
        rotorDer.incrementarPosicion();
    }
}
