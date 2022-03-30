package fr.lernejo.navy_battle;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CroiseurTest {
    @Test
    void test_croiseur1() {
        Croiseur croiseur = new Croiseur(1,1,1);
        Assertions.assertThat(croiseur.getNom()).isEqualTo("Croiseur");
    }
    @Test
    void test_croiseur2() {
        Croiseur croiseur = new Croiseur(1,1,1);
        Assertions.assertThat(croiseur.getId()).isEqualTo(1);
    }
    @Test
    void test_croiseur3() {
        Croiseur croiseur = new Croiseur(1,1,1);
        Assertions.assertThat(croiseur.getAbscisse()).isEqualTo(1);
    }
    @Test
    void test_croiseur4() {
        Croiseur croiseur = new Croiseur(1,1,1);
        Assertions.assertThat(croiseur.getOrdonnee()).isEqualTo(1);
    }

}
