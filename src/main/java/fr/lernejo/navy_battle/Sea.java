package fr.lernejo.navy_battle;

import java.util.ArrayList;

public class Sea {
    private final ArrayList<Objet> sea = new ArrayList<Objet>();
    public Sea(){
        sea.add(new Avion(0,0)); sea.add(new Avion(0,1)); sea.add(new Avion(0,2)); sea.add(new Avion(0,3));
        sea.add(new Avion(0,4));
        sea.add(new Torpilleur(1,5)); sea.add(new Torpilleur(1,6));
        sea.add(new ContreTorpilleur(5,7)); sea.add(new ContreTorpilleur(5,8));sea.add(new ContreTorpilleur(5,9));
        sea.add(new ContreTorpilleur(6,7)); sea.add(new ContreTorpilleur(6,8));sea.add(new ContreTorpilleur(6,9));
        sea.add(new Croiseur(9,3));
        sea.add(new Croiseur(9,4));
        sea.add(new Croiseur(9,5));
        sea.add(new Croiseur(9,6));
    }
    public ArrayList<Objet> getSea() {
        return sea;
    }
    public String checkPosition(int abscisse, int ordonnee){
        String nom_remove = "";
        for (int i = 0; i < this.sea.size(); i++) {
            if (this.sea.get(i).getAbscisse() == abscisse && this.sea.get(i).getOrdonnee() == ordonnee) {
                nom_remove = this.sea.get(i).getNom();
                this.sea.remove(i);
            }
        }
        if (nom_remove.equals("")) {return "miss";}
        for (int j = 0; j < this.sea.size(); j++) {
                if (this.sea.get(j).getNom().equals(nom_remove)){return "hit";}
        }
        return "sunk";
    }
}
