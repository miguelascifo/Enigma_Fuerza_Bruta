package Enigma;

public class Main {

    public static void main(String[] args) {
        String texto = "YLJKKVAWHAQTJITNQUPTJSHDBWGDSBEOWKLEDBYBJSSGCI";
        String[] diccionario = {"ambiguo", "obvio", "trivial", "estupendo", "esther", "bugzilla", "thevenin", "pacifico", "diarrea", "hola", "mundo", "garabata", "papiloma", "herpes", "celula", "porro", "suaves", "dimitri", "fiesta", "patata"};
        String etiqueta;
        String calculado;

        for (char rI = 'A'; rI <= 'Z'; rI++) {
            for (char rII = 'A'; rII <= 'Z'; rII++) {
                for (char rIII = 'A'; rIII <= 'Z'; rIII++) {
                    for (char etiqueta1 = 'A'; etiqueta1 <= 'Z'; etiqueta1++) {
                        for (char etiqueta2 = 'A'; etiqueta2 <= 'Z'; etiqueta2++) {

                            etiqueta = etiqueta1 + "" + etiqueta2;

                            StringBuilder resultado = new StringBuilder();

                            Enigma enigma = new Enigma(new Rotor(Constantes.rotorI, rI, Constantes.saltoI),
                                    new Rotor(Constantes.rotorII, rII, Constantes.saltoII),
                                    new Rotor(Constantes.rotorIII, rIII, Constantes.saltoIII),
                                    new Reflector(),
                                    new Etiquetas(etiqueta));

                            for (int i = 0; i < texto.length(); i++) {
                                resultado.append(enigma.caracterCifrado(texto.charAt(i)));
                            }

                            for (String aDiccionario : diccionario) {
                                if (resultado.toString().toLowerCase().contains(aDiccionario)) {
                                    calculado = rI + "" + rII + "" + rIII + " - " + etiqueta + ": " + resultado.toString();
                                    System.out.println(calculado);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
