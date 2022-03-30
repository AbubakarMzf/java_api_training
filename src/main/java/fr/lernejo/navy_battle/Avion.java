package fr.lernejo.navy_battle;

public class Avion implements Objet{
    private final int abscisse;
    private final int ordonee;
    private final String nom;
    private final int id;
    public Avion(int id, int abscisse, int ordonee){
        this.abscisse = abscisse;
        this.ordonee = ordonee;
        this.id = id;
        this.nom = "Avion";
    }
    @Override
    public int getAbscisse() {
        return abscisse;
    }
    @Override
    public int getOrdonnee() {
        return ordonee;
    }
    @Override
    public String getNom() {
        return nom;
    }
    @Override
    public int getId() {
        return this.id;
    }
}
