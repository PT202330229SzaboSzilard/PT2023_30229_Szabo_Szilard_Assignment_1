package ro.tuc.model;

public class Monom{
    private int putere;
    private Number coeficient;

    public Monom(int putere, Number coeficient) {
        this.putere = putere;
        this.coeficient = coeficient;
    }

    public int getPutere() {
        return putere;
    }

    public Number getCoeficient() {
        return coeficient;
    }

    public void setPutere(int putere) {
        this.putere = putere;
    }

    public void setCoeficient(Number coeficient) {
        this.coeficient = coeficient;
    }

    @Override
    public String toString() {
        if(coeficient.intValue() < 0)
            return coeficient.intValue() + "x^" + putere;
        else
        if(coeficient.intValue() > 0)
            return "+" + coeficient.intValue() + "x^" + putere;
        else
            return "";
    }

}

