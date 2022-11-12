package model;

public class Student extends Human {
    private int anStudiu;

    public Student(String nume, String prenume, String facultate, int varsta, int anStudiu) {
        super(nume,prenume,facultate,varsta);
        this.anStudiu = anStudiu;
    }

    public int getAnStudiu() {
        return anStudiu;
    }

    public void setAnStudiu(int anStudiu) {
        this.anStudiu = anStudiu;
    }

    @Override
    public void greeting() {
        System.out.println("Hello mates! I'm student " + nume + " " +prenume +"!");
    }

    @Override
    public void doWork() {
        System.out.println("Student " + nume + " " + prenume + " on duty...");
    }

    @Override
    public String toString() {
        return "{Sd." +
                " nume: " + nume +
                ", prenume: " + prenume +
                ", facultate: " + facultate +
                ", varsta: " + varsta +
                ", anStudiu: " + anStudiu +
                "}";
    }
}
