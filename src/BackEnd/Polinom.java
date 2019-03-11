package BackEnd;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polinom {

    private ArrayList<Monom> polinom = new ArrayList<Monom>();

    public Polinom() {
        this.polinom = new ArrayList<Monom>();
    }

    public Polinom(String inputText) {

        Pattern p = Pattern.compile("(-?\\b\\d+)[xX]\\^(-?\\d+\\b)");
        Matcher m = p.matcher(inputText);
        while (m.find()) {
            Monom mon = new Monom();

            mon.setCoeficient(Float.parseFloat(m.group(1)));
            mon.setPutere(Integer.parseInt(m.group(2)));
            polinom.add(mon);
        }
    }

    public ArrayList<Monom> getPolinom() {
        return polinom;
    }

    public void setPolinom(ArrayList<Monom> polinom) {
        this.polinom = polinom;
    }

    public String toString() {
        String rezultat = "";

        int ok = 1;
        if (polinom.isEmpty())
            rezultat = "0";
        else
            for (Monom monom : polinom) {
                if (monom.getCoeficient() >= 0 && ok == 0)
                    rezultat += " + " + monom.getCoeficient() + "x^" + monom.getPutere();
                else
                    rezultat += " " + monom.getCoeficient() + "x^" + monom.getPutere();
                ok = 0;
            }
        return rezultat;
    }

    public int getGradPol() {
        int max = -Integer.MAX_VALUE;
        for (Monom monom : polinom) {
            if (monom.getPutere() > max)
                max = monom.getPutere();
        }
        return max;
    }

    public boolean existaPutere(int i) {
        boolean ok = false;
        for (Monom monom : polinom) {
            if (monom.getPutere() == i) {
                ok = true;
                break;
            }
        }
        return ok;
    }

    public float getCoeficientMonom(int i) {
        float coeficient = 0;
        for (Monom monom : polinom) {
            if (monom.getPutere() == i) {
                coeficient = monom.getCoeficient();
                break;
            }
        }
        return coeficient;
    }

    public void sortarePolinom() {

        int k = polinom.size();
        for (int i = 0; i < k - 1; i++)
            for (int j = 0; j < k - i - 1; j++)
                if (polinom.get(j).getPutere() < polinom.get(j + 1).getPutere()) {
                    Monom m = polinom.get(j);
                    polinom.set(j, polinom.get(j + 1));
                    polinom.set(j + 1, m);
                }

    }

    public void eliminaDuplicate() {

        int k = polinom.size();
        for (int i = 0; i < k; i++)
            for (int j = i + 1; j < k; j++) {
                //  System.out.println("iPrim="+i+" jPrim="+j);
                if (polinom.get(i).getPutere() == polinom.get(j).getPutere()) {
                    polinom.get(j).setCoeficient(polinom.get(i).getCoeficient() + polinom.get(j).getCoeficient());
                    polinom.remove(polinom.get(i));
                    //    System.out.println("i="+i+" j="+j);
                    k--;
                    j--;
                    //   System.out.println("k="+k);
                }
            }
    }

    public void eliminaZero() {
        int k=polinom.size();
        for (int i = 0; i < k; i++) {
            if(polinom.get(i).getCoeficient()==0) {
                polinom.remove(i);
                k--;
                i--;
            }
        }
    }

}
