package model;

public class Profesor extends Human {

    private String materie;

    public String getMaterie() {
        return materie;
    }

    public void setMaterie(String materie) {
        this.materie = materie;
    }

    public Profesor(String nume, String prenume, String facultate, int varsta, String materie) {
        super(nume,prenume,facultate,varsta);
        this.materie = materie;
    }

    @Override
    public void greeting() {
        System.out.println("Hello students! Professor " + nume + "here!");
    }

    @Override
    public void doWork() {
        System.out.println("Professor " + nume + " on duty...");
    }

    @Override
    public String toString() {
        return "{Prof." +
                " nume: " + nume +
                ", prenume: " + prenume +
                ", facultate: " + facultate +
                ", varsta: " + varsta +
                ", materie: " + materie +
                "}";
    }
}
