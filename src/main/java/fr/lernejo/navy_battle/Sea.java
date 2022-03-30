package fr.lernejo.navy_battle;

import java.util.ArrayList;

public class Sea {
    private final ArrayList<Objet> sea = new ArrayList<Objet>();
    public Sea(){
        sea.add(new Avion(0, 0,0)); sea.add(new Avion(0,0,1)); sea.add(new Avion(0,0,2)); sea.add(new Avion(0,0,3));
        sea.add(new Avion(0,0,4));
        sea.add(new Torpilleur(1,1,5)); sea.add(new Torpilleur(1,1,6));
        sea.add(new Croiseur(2,5,3));
        sea.add(new Croiseur(2,5,4));
        sea.add(new Croiseur(2,5,5));
        sea.add(new Croiseur(2,5,6));
        sea.add(new ContreTorpilleur(3,3,3)); sea.add(new ContreTorpilleur(3,3,4));sea.add(new ContreTorpilleur(3,3,5));
        sea.add(new ContreTorpilleur(4,4,4)); sea.add(new ContreTorpilleur(4,4,5));sea.add(new ContreTorpilleur(4,4,6));
    }
    public ArrayList<Objet> getSea() {
        return sea;
    }
    public String checkPosition(int abscisse, int ordonnee){
        int id_remove = -1; ArrayList<Objet> toremove = new ArrayList<Objet>();
        for (int i = 0; i < this.sea.size(); i++) {
            if (this.sea.get(i).getAbscisse() == abscisse && this.sea.get(i).getOrdonnee() == ordonnee) {
                id_remove = this.sea.get(i).getId();
                toremove.add(this.sea.get(i));}
        }
        for (Objet o:toremove) { this.sea.remove(o); }
        if (id_remove == -1) {return "miss";}
        for (int j = 0; j < this.sea.size(); j++) {
                if (this.sea.get(j).getId() == id_remove) {return "hit";}
        }
        return "sunk";
    }
}
