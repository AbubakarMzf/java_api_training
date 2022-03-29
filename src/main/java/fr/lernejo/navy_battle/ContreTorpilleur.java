package fr.lernejo.navy_battle;

public class ContreTorpilleur implements Objet{
    private final int abscisse;
    private final int ordonee;
    private final String nom;

    public ContreTorpilleur(int abscisse, int ordonee){
        this.abscisse = abscisse;
        this.ordonee = ordonee;
        this.nom = "Contre-Torpilleur";
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
