package BackEnd;

public class Monom  {

    private float coeficient;
    private int putere;

    public Monom(float coeficient, int putere) {
        this.coeficient = coeficient;
        this.putere = putere;
    }
    public Monom(){
        this(0,0);
    }

    public float getCoeficient() {
        return this.coeficient;
    }

    public void setCoeficient(float coeficient) {
        this.coeficient = coeficient;
    }

    public int getPutere() {
        return this.putere;
    }

    public void setPutere(int putere) {
        this.putere = putere;
    }

    public String toString() {
        return "c: " + coeficient + " p: " + putere;
    }

}
