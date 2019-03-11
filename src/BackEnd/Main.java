package BackEnd;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private Operatie operatie;

    //unde are avea mai mult sens sa o pun ar trebui cumva o clasa noua?


    public Main() {
    }

    public static void main(String[] args) {


       /* Polinom p3 = new Polinom();
        ArrayList<Monom> mm3 = new ArrayList<Monom>();

        Operatie o = new Operatie();
        Polinom rez = new Polinom();

        Monom m3 = new Monom();
        m3.setPutere(4);
        m3.setCoeficient(3);
        mm3.add(m3);

        Monom m2 = new Monom();
        m2.setPutere(2);
        m2.setCoeficient(-2);
        mm3.add(m2);

        Monom m1 = new Monom();
        m1.setPutere(0);
        m1.setCoeficient(-1);
        mm3.add(m1);

        p3.setPolinom(mm3);

        System.out.println(p3);

        Polinom p4 = new Polinom();
        ArrayList<Monom> mm4 = new ArrayList<Monom>();


        Monom n2 = new Monom();
        n2.setPutere(1);
        n2.setCoeficient(1);
        mm4.add(n2);

        Monom n1 = new Monom();
        n1.setPutere(0);
        n1.setCoeficient(1);
        mm4.add(n1);

        p4.setPolinom(mm4);
        System.out.println(p4);

        System.out.print("Impartire:");
        rez = o.impartire(p3, p4);
        System.out.println(rez);
/*
        Polinom p1 = new Polinom();
        Polinom p2 = new Polinom();
        Main main = new Main();
        // p1=main.getTextPolinom("1x^4-2x^3+3x^2-4x^1+6x^0");
        //p2 = main.getTextPolinom("3x^1-10x^1+15x^0");

        //p1 = main.getTextPolinom("1x^2+5x^1+1x^0");
        // p2=main.getTextPolinom("3x^2");
        System.out.println("Noul Polinom:" + p1);
        System.out.println("Noul Polinom:" + p2);

        //   System.out.println("adunare:"+o.adunare(p1,p2));
        //   System.out.println("scadere:"+o.scadere(p1,p2));
        System.out.println("inmultire:" + o.inmultire(p1, p2));
        p3 = o.inmultire(p1, p2);
        p3.sortarePolinom();
        System.out.println("sort:" + p3);
        p3.eliminaDuplicate();
        System.out.println("elimina duplicate:" + p3);*/
        //  System.out.println("impartire:"+o.impartire(p1,p2));
        //   System.out.println("derivare:"+o.derivare(p2));
        //    System.out.println("integrare:"+o.integrare(p1));


        Polinom p1 = new Polinom("1x^4-2x^3+3x^2-4x^1+6x^0");
        Polinom p2 = new Polinom("1x^2+2x^1-1x^0");
        p1.sortarePolinom();
        p1.eliminaDuplicate();
        p2.sortarePolinom();
        p2.eliminaDuplicate();
        Polinom p3 = new Polinom();
        System.out.println(p1);
        System.out.println(p2);

        Operatie operatie = operatie;
        p3 = operatie.adunare(p1, p2);
        p3.sortarePolinom();
        p3.eliminaDuplicate();
        System.out.println("Adunare:" + p3);

        p3 = operatie.scadere(p1, p2);
        p3.sortarePolinom();
        p3.eliminaDuplicate();

        p3.eliminaZero();
        System.out.println("scadere:" + p3);

        p3 = operatie.inmultire(p1, p2);
        System.out.println("Inmultire" + p3);
        p3.sortarePolinom();
        p3.eliminaDuplicate();
        p3.eliminaZero();
        System.out.println("Inmultire2" + p3);

        p3 = operatie.impartire(p1, p2,true);
        System.out.println("Impartire" + p3);

        p3=operatie.derivare(p1);
        p3.sortarePolinom();
        p3.eliminaDuplicate();
        p3.eliminaZero();
        System.out.println("Derivare:"+p3);

        Polinom p4=new Polinom("2x^3+3x^1");

        p3=operatie.integrare(p4);
        p3.sortarePolinom();
        p3.eliminaDuplicate();
        p3.eliminaZero();
        System.out.println("Integrare:"+p3);


    }
}
