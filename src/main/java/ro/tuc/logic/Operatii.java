package ro.tuc.logic;

import ro.tuc.model.Monom;
import ro.tuc.model.Polinom;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Operatii{
    public static Polinom toPolinom(String polinom)
    {
        //String exemplu = "3x^3+5x^2-4x^1-1x^0";
        Polinom polinomCreat = new Polinom();
        String[] coeficient;
        String[] putere;
        Pattern pattern = Pattern.compile("([+-]?(?:(?:\\d+x\\^\\d+)|(?:\\d+x)|(?:\\d+)|(?:x)))");
        Matcher matcher = pattern.matcher(polinom);
        int x = 0;
        while(matcher.find()) {
            x++;
            coeficient = matcher.group(1).split("x");
            putere = coeficient[1].split("^");
            Monom monomCitit = new Monom(Integer.parseInt(putere[0].substring(1)),Integer.valueOf(coeficient[0]));
            polinomCreat.adaugareMonomInPolinom(monomCitit);
        }
        return polinomCreat;
    }

    public Polinom inmultire(Polinom a, Polinom b)
    {
        Polinom c = new Polinom();
        for (Map.Entry<Integer, Monom> x : a.getColectieMonoame().entrySet()) {
            for (Map.Entry<Integer, Monom> y : b.getColectieMonoame().entrySet()) {
                Monom aux = new Monom(0,0);
                aux.setPutere(x.getKey()+y.getKey());
                c.adaugareMonomInPolinom(new Monom(x.getKey() + y.getKey(), x.getValue().getCoeficient().intValue() * y.getValue().getCoeficient().intValue()));
                for(Map.Entry<Integer, Monom> z : c.getColectieMonoame().entrySet())
                    if(z.getKey() == aux.getPutere())
                        c.adaugareMonomInPolinom(new Monom(z.getKey(), z.getValue().getCoeficient()));
            }
        }
        return c;
    }


    public Polinom adunare(Polinom a, Polinom b)
    {
        Polinom aux = new Polinom();
        for(Map.Entry<Integer, Monom> polinomA: a.getColectieMonoame().entrySet()) {
            int x = 1;
            for(Map.Entry<Integer, Monom> polinomB: b.getColectieMonoame().entrySet()) {
                if(polinomA.getKey().equals(polinomB.getKey())) {
                    aux.adaugareMonomInPolinom(new Monom(polinomB.getKey(), polinomA.getValue().getCoeficient().intValue() + polinomB.getValue().getCoeficient().intValue()));
                    x = 0;
                }
            }
            if(x == 1)
                aux.adaugareMonomInPolinom(new Monom(polinomA.getKey(), polinomA.getValue().getCoeficient().intValue()));
        }
        for(Map.Entry<Integer, Monom> polinomB: b.getColectieMonoame().entrySet()) {
            int x = 1;
            for(Map.Entry<Integer, Monom> polinomA: a.getColectieMonoame().entrySet()) {
                if(polinomA.getKey().equals(polinomB.getKey())) {
                    aux.adaugareMonomInPolinom(new Monom(polinomA.getKey(), polinomA.getValue().getCoeficient().intValue() + polinomB.getValue().getCoeficient().intValue()));
                    x = 0;
                }
            }
            if(x == 1)
                aux.adaugareMonomInPolinom(new Monom(polinomB.getKey(), polinomB.getValue().getCoeficient().intValue()));
        }
        return aux;
    }

    public Polinom scadere(Polinom a, Polinom b) {
        Polinom aux = new Polinom();
        for(Map.Entry<Integer, Monom> polinomA: a.getColectieMonoame().entrySet()) {
            int x = 1;
            for(Map.Entry<Integer, Monom> polinomB: b.getColectieMonoame().entrySet()) {
                if(polinomA.getKey().equals(polinomB.getKey())) {
                    aux.adaugareMonomInPolinom(new Monom(polinomA.getKey(), polinomA.getValue().getCoeficient().intValue() - polinomB.getValue().getCoeficient().intValue()));
                    x = 0;
                }
            }
            if(x == 1)
                aux.adaugareMonomInPolinom(new Monom(polinomA.getKey(), polinomA.getValue().getCoeficient().intValue()));
        }
        for(Map.Entry<Integer, Monom> polinomB: b.getColectieMonoame().entrySet()) {
            int x = 1;
            for(Map.Entry<Integer, Monom> polinomA: a.getColectieMonoame().entrySet()) {
                if(polinomA.getKey().equals(polinomB.getKey())) {
                    aux.adaugareMonomInPolinom(new Monom(polinomA.getKey(), polinomA.getValue().getCoeficient().intValue() - polinomB.getValue().getCoeficient().intValue()));
                    x = 0;
                }
            }
            if(x == 1)
                aux.adaugareMonomInPolinom(new Monom(polinomB.getKey(), -polinomB.getValue().getCoeficient().intValue()));
        }
        return aux;
    }

    public Polinom derivare(Polinom a) {
        Polinom aux = new Polinom();
        for(Map.Entry<Integer, Monom> polinomA: a.getColectieMonoame().entrySet()){
            if(polinomA.getKey() != 0)
                aux.adaugareMonomInPolinom(new Monom((polinomA.getKey())-1, polinomA.getValue().getCoeficient().intValue() * polinomA.getKey()));
        }
        return aux;
    }

    public Polinom integrare(Polinom a) {
        Polinom aux = new Polinom();
        for(Map.Entry<Integer, Monom> polinomA: a.getColectieMonoame().entrySet())
            aux.adaugareMonomInPolinom(new Monom(polinomA.getKey() + 1, polinomA.getValue().getCoeficient().doubleValue() / (polinomA.getKey() + 1)));
        return aux;
    }
}