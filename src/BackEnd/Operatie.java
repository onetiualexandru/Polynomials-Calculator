package BackEnd;

public class Operatie {

    private Polinom polinom;

    public Operatie() {
        this.polinom = new Polinom();
    }

    public Polinom adunare(Polinom p1, Polinom p2) {

        Polinom rezultat = new Polinom();

        int max = (p1.getGradPol() > p2.getGradPol() ? p1.getGradPol() : p2.getGradPol());

        for (int i = 0; i <= max; i++) {
            Monom monomRezultat = new Monom();
            if (p1.existaPutere(i) && p2.existaPutere(i)) {
                monomRezultat.setCoeficient(p1.getCoeficientMonom(i) + p2.getCoeficientMonom(i));
                monomRezultat.setPutere(i);
                rezultat.getPolinom().add(monomRezultat);
            } else {
                if (p1.existaPutere(i)) {
                    monomRezultat.setCoeficient(p1.getCoeficientMonom(i));
                    monomRezultat.setPutere(i);
                    rezultat.getPolinom().add(monomRezultat);
                } else if (p2.existaPutere(i)) {
                    monomRezultat.setCoeficient(p2.getCoeficientMonom(i));
                    monomRezultat.setPutere((i));
                    rezultat.getPolinom().add(monomRezultat);
                }
            }
        }
        return rezultat;
    }

    public Polinom scadere(Polinom p1, Polinom p2) {

        Polinom rezultat = new Polinom();

        int max = (p1.getGradPol() > p2.getGradPol() ? p1.getGradPol() : p2.getGradPol());

        for (int i = 0; i <= max; i++) {
            Monom monomRezultat = new Monom();
            if (p1.existaPutere(i) && p2.existaPutere(i)) {
                monomRezultat.setCoeficient(p1.getCoeficientMonom(i) - p2.getCoeficientMonom(i));
                monomRezultat.setPutere(i);
                rezultat.getPolinom().add(monomRezultat);
            } else {
                if (p1.existaPutere(i)) {
                    monomRezultat.setCoeficient(p1.getCoeficientMonom(i));
                    monomRezultat.setPutere(i);
                    rezultat.getPolinom().add(monomRezultat);
                } else if (p2.existaPutere(i)) {
                    monomRezultat.setCoeficient(-p2.getCoeficientMonom(i));
                    monomRezultat.setPutere((i));
                    rezultat.getPolinom().add(monomRezultat);
                }
            }
        }
        return rezultat;
    }

    public Polinom inmultire(Polinom p1, Polinom p2) {
        Polinom polinomTemp = new Polinom();
        for (Monom monomonom : p1.getPolinom()) {
            for (Monom monom2 : p2.getPolinom()) {
                Monom monomRezultat = new Monom();
                monomRezultat.setCoeficient(monomonom.getCoeficient() * monom2.getCoeficient());
                monomRezultat.setPutere(monomonom.getPutere() + monom2.getPutere());
                polinomTemp.getPolinom().add(monomRezultat);
            }
        }
        return polinomTemp;
    }

    public Polinom impartire(Polinom a, Polinom b, boolean alege) {

        Polinom rezultat = new Polinom();
        Polinom rest = new Polinom();
        Polinom auxPol = new Polinom();

        int p1g = a.getGradPol();
        int p2g = b.getGradPol();

        while (p1g >= p2g) {

            auxPol.getPolinom().clear();

            //impartire la coeficientul cel mai mare
            int putereDivizer = p1g - p2g;
            float coefDivizer = a.getCoeficientMonom(p1g) / b.getCoeficientMonom(p2g);

            //salvez rezultatul
            Monom auxMonom = new Monom();
            auxMonom.setCoeficient(coefDivizer);
            auxMonom.setPutere(putereDivizer);
            rezultat.getPolinom().add(auxMonom);

            //inmultesc rezultatul cu al doilea polinom
            for (Monom monomPolinomB : b.getPolinom()) {
                Monom auxMonom2 = new Monom();
                auxMonom2.setCoeficient(-(monomPolinomB.getCoeficient() * coefDivizer));
                auxMonom2.setPutere(monomPolinomB.getPutere() + putereDivizer);
                auxPol.getPolinom().add(auxMonom2);
            }
            Operatie o = new Operatie();
            rest = o.adunare(a, auxPol);
            a = rest;
            p1g--;
        }
        if ( alege==true)
        return rezultat;
            else
        return rest;
    }

    public Polinom derivare(Polinom p1) {

        Polinom rezultat = new Polinom();

        for (Monom monom : p1.getPolinom()) {
            Monom auxMonom = new Monom();
            if (monom.getPutere() == 0)
                auxMonom.setPutere(0);
            else {
                auxMonom.setCoeficient(monom.getCoeficient() * monom.getPutere());
                auxMonom.setPutere(monom.getPutere() - 1);
            }
            rezultat.getPolinom().add(auxMonom);
        }
        return rezultat;
    }

    public Polinom integrare(Polinom p1) {

        Polinom rezultat = new Polinom();
        for (Monom monom : p1.getPolinom()) {

            Monom auxMonom = new Monom();
            auxMonom.setCoeficient(monom.getCoeficient() / (monom.getPutere() + 1));
            auxMonom.setPutere(monom.getPutere() + 1);
            rezultat.getPolinom().add(auxMonom);
        }
        return rezultat;
    }


}

