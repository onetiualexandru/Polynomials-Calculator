package BackEnd;

import org.junit.Test;

import static org.junit.Assert.*;

public class OperatieTest {

    @Test
    public void adunare() {
        Polinom p1 = new Polinom("1x^4-2x^3+3x^2-4x^1+6x^0");
        Polinom p2 = new Polinom("1x^2+2x^1-1x^0");
        Polinom asteptari = new Polinom("1x^4-2x^3+4x^2-2x^1+5x^0");
        Operatie o = new Operatie();
        Polinom rezultat = o.adunare(p1, p2);
        rezultat.sortarePolinom();
        rezultat.eliminaDuplicate();
        rezultat.eliminaZero();
        assertEquals(asteptari.toString(), rezultat.toString());
    }

    @Test
    public void scadere() {
        Polinom p1 = new Polinom("1x^4-2x^3+3x^2-4x^1+6x^0");
        Polinom p2 = new Polinom("1x^2+2x^1-1x^0");
        Polinom asteptari = new Polinom("1x^4-2x^3+2x^2-6x^1+7x^0");
        Operatie o = new Operatie();
        Polinom rezultat = o.scadere(p1, p2);
        rezultat.sortarePolinom();
        rezultat.eliminaDuplicate();
        rezultat.eliminaZero();
        assertEquals(asteptari.toString(), rezultat.toString());
    }

    @Test
    public void inmultire() {
        Polinom p1 = new Polinom("1x^4-2x^3+3x^2-4x^1+6x^0");
        p1.sortarePolinom();
        p1.eliminaDuplicate();
        p1.eliminaZero();

        Polinom p2 = new Polinom("1x^2+2x^1-1x^0");
        p2.sortarePolinom();
        p2.eliminaDuplicate();
        p2.eliminaZero();

        Polinom asteptari = new Polinom("1x^6-2x^4+4x^3-5x^2+16x^1-6x^0");

        Operatie o = new Operatie();
        Polinom rezultat = o.inmultire(p1, p2);
        rezultat.sortarePolinom();
        rezultat.eliminaDuplicate();
        rezultat.eliminaZero();

        assertEquals(asteptari.toString(), rezultat.toString());

        Polinom p3 = new Polinom("1x^4-2x^3+3x^2-4x^1+6x^0+1x^0");
        p1.sortarePolinom();
        p1.eliminaDuplicate();
        p1.eliminaZero();

        Polinom p4 = new Polinom("1x^2+2x^1-1x^0");
        p2.sortarePolinom();
        p2.eliminaDuplicate();
        p2.eliminaZero();

        Polinom asteptari2 = new Polinom("1x^6-2x^4+4x^3-4x^2+18x^1-7x^0");

        Operatie o2 = new Operatie();
        Polinom rezultat2 = o.inmultire(p1, p2);
        rezultat.sortarePolinom();
        rezultat.eliminaDuplicate();
        rezultat.eliminaZero();

        assertEquals(asteptari.toString(), rezultat.toString());
    }

    @Test
    public void impartire() {
        Polinom p1 = new Polinom("1x^4-2x^3+3x^2-4x^1+6x^0");
        p1.sortarePolinom();
        p1.eliminaDuplicate();
        p1.eliminaZero();

        Polinom p2 = new Polinom("1x^2+2x^1-1x^0");
        p2.sortarePolinom();
        p2.eliminaDuplicate();
        p2.eliminaZero();

        Polinom asteptari = new Polinom("1x^2-4x^1+12x^0");
        Polinom asteptariRest = new Polinom("-32x^1+18x^0");

        Operatie o = new Operatie();
        Polinom rezultat = o.impartire(p1, p2, true);
        rezultat.sortarePolinom();
        rezultat.eliminaDuplicate();
        rezultat.eliminaZero();

        assertEquals(asteptari.toString(), rezultat.toString());

        Polinom rezultatRest = o.impartire(p1, p2,false);
        rezultatRest.sortarePolinom();
        rezultatRest.eliminaDuplicate();
        rezultatRest.eliminaZero();

        assertEquals(asteptariRest.toString(), rezultatRest.toString());
    }


    @Test
    public void derivare() {
        Polinom p1 = new Polinom("1x^4-2x^3+3x^2-4x^1+6x^0");
        Polinom asteptari = new Polinom("4x^3-6x^2+6x^1-4x^0");

        Operatie o = new Operatie();
        Polinom rezultat = o.derivare(p1);
        rezultat.sortarePolinom();
        rezultat.eliminaDuplicate();
        rezultat.eliminaZero();

        assertEquals(rezultat.toString(), asteptari.toString());
    }

    @Test
    public void integrare() {

        Polinom p1 = new Polinom("2x^3+3x^1");

        Operatie o = new Operatie();
        Polinom rez = o.integrare(p1);

        assertEquals(rez.toString()," 0.5x^4 + 1.5x^2");
    }

}