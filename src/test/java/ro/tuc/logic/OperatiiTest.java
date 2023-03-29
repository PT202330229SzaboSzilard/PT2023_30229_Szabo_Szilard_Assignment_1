package ro.tuc.logic;

import junit.framework.TestCase;
import ro.tuc.model.Polinom;

public class OperatiiTest extends TestCase {

    private static final  Operatii operatii = new Operatii();
    private static final Polinom a = Operatii.toPolinom("2x^2+7x^0");
    private static final Polinom b = Operatii.toPolinom("2x^1-7x^0");

    public void testInmultire() {
        assertEquals(operatii.inmultire(a,b).afisarePolinom(),"-49.0+14.0x-14.0x^2+4.0x^3");
    }

    public void testAdunare() {
        assertEquals(operatii.adunare(a,b).afisarePolinom(),"2.0x+2.0x^2");
    }

    public void testScadere() {
        assertEquals(operatii.scadere(a,b).afisarePolinom(),"14.0-2.0x+2.0x^2");
    }

    public void testDerivare() {
        assertEquals(operatii.derivare(a).afisarePolinom(),"4.0x");
    }

    public void testIntegrare() {
        assertEquals(operatii.integrare(a).afisarePolinom(),"7.0x+0.6666666666666666x^3");
    }
}