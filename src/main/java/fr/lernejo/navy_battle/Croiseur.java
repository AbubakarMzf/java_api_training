package fr.lernejo.navy_battle;

public class Croiseur implements Objet{
    private final int abscisse;
    private final int ordonee;
    private final String nom;

    public Croiseur(int abscisse, int ordonee){
        this.abscisse = abscisse;
        this.ordonee = ordonee;
        this.nom = "Croiseur";
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

}
