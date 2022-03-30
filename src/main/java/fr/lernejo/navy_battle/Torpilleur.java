package fr.lernejo.navy_battle;

public class Torpilleur implements Objet{
    private final int abscisse;
    private final int ordonee;
    private final String nom;
    private final int id;

    public Torpilleur(int id, int abscisse, int ordonee){
        this.abscisse = abscisse;
        this.ordonee = ordonee;
        this.nom = "Torpilleur";
        this.id = id;
    }
    @Override
    public int getAbscisse() {
        return abscisse;
    }
    @Override
    public int getOrdonnee() {
        return ordonee;
    }
    public String getNom() {
        return nom;
    }
    @Override
    public int getId() {
        return this.id;
    }

}
