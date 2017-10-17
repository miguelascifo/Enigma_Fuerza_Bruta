package Enigma;

class Etiquetas {

    private int[] etiqueta;

    Etiquetas(String etiqueta) {

        this.etiqueta = new int[26];
        for (int i = 0; i < this.etiqueta.length; i++) {
            // Cada letra se empareja con sí misma
            this.etiqueta[i] = i;
        }

        // Las etiquetas se referencian así: "AC;FX"
        String[] auxiliar = etiqueta.split(";");

        // Se cambia la configuración para cada par de letras
        for (String auxiliar2 : auxiliar) {
            int primerIndice = Constantes.alfabeto.indexOf(auxiliar2.charAt(0));
            int segundoIndice = Constantes.alfabeto.indexOf(auxiliar2.charAt(1));

            this.etiqueta[primerIndice] = segundoIndice;
            this.etiqueta[segundoIndice] = primerIndice;
        }
    }

    int caracterCifrado(int numero) {
        return etiqueta[numero];
    }
}
