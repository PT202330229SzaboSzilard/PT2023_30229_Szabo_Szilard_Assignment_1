package ro.tuc.model;

import java.util.*;

public class Polinom {
    private final HashMap<Integer, Monom> colectieMonoame = new HashMap<>();


    public Polinom() {
        super();
    }

    public void adaugareMonomInPolinom(Monom monomNou) {
        colectieMonoame.put(monomNou.getPutere(), monomNou);
    }

    public String afisarePolinom() {
        String aux = "";
        for(Map.Entry<Integer, Monom> y: colectieMonoame.entrySet())
        {
            int exponent = y.getKey();
            double coefficient = y.getValue().getCoeficient().doubleValue();
            if (coefficient > 0 && aux.length() > 0) {
                aux += "+";
            }
            if (coefficient != 1 && coefficient != -1 && exponent != 0 && coefficient != 0) {
                aux += coefficient;
            } else if (coefficient == -1) {
                aux += "-";
            }
            if (exponent == 0) {
                if(coefficient != 0)
                    aux += coefficient;
            } else if (exponent == 1) {
                aux += "x";
            } else if(coefficient != 0){
                aux += "x^" + exponent;
            }
        }
        return aux;
    }
    public HashMap<Integer, Monom> getColectieMonoame() {
        return colectieMonoame;
    }

}