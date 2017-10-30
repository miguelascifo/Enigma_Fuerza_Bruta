package Enigma;

public class Main {

    public static void main(String[] args) {
        String texto = "GSUTUBBWAXCANFJPPQRLDQQWDJTSVEXHUDHS";
        String[] diccionario = {"ambiguo", "obvio", "trivial", "estupendo", "esther", "bugzilla", "thevenin", "pacifico", "diarrea", "hola", "mundo", "garabata", "papiloma", "herpes", "celula", "porro", "suaves", "dimitri", "fiesta", "patata"};
        String etiquetas = "AA;BB;CC;DD;EE;FF;GG;HH;II;JJ;KK;LL;MM;NN;OO;PP;QQ;RR;SS;TT;UU;VV;WW;XX;YY;ZZ";

        for (char rI = 'A'; rI <= 'Z'; rI++) {
            for (char rII = 'A'; rII <= 'Z'; rII++) {
                for (char rIII = 'A'; rIII <= 'Z'; rIII++) {

                    StringBuilder resultado = new StringBuilder();

                    Enigma enigma = new Enigma(new Rotor(Constantes.rotorI, rI, Constantes.saltoI),
                            new Rotor(Constantes.rotorII, rII, Constantes.saltoII),
                            new Rotor(Constantes.rotorIII, rIII, Constantes.saltoIII),
                            new Reflector(),
                            new Etiquetas(etiquetas));

                    for (int i = 0; i < texto.length(); i++) {
                        resultado.append(enigma.caracterCifrado(texto.charAt(i)));
                    }

                    for (String aDiccionario : diccionario) {
                        if (resultado.toString().toLowerCase().contains(aDiccionario)) {
                            System.out.println(rI + "" + rII + "" + rIII + ": " + resultado.toString());
                        }
                    }
                }
            }
        }
    }
}
