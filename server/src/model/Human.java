package model;

public abstract class Human implements Comparable<Human> {

    protected String nume;
    protected String prenume;
    protected String facultate;
    protected int varsta;

    public Human(String nume, String prenume, String facultate, int varsta) {
        this.nume = nume;
        this.prenume = prenume;
        this.facultate = facultate;
        this.varsta = varsta;
    }

    public abstract void greeting();
    public abstract void doWork();

    @Override
    public int compareTo(Human o) {
        return Integer.compare(this.varsta, o.varsta);
    }
}
