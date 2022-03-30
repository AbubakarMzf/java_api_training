package fr.lernejo.navy_battle;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TorpilleurTest {
    @Test
    void test_torpilleur1() {
        Torpilleur torpilleur = new Torpilleur(1,1,1);
        Assertions.assertThat(torpilleur.getNom()).isEqualTo("Torpilleur");
    }
    @Test
    void test_torpilleur2() {
        Torpilleur torpilleur = new Torpilleur(1,1,1);
        Assertions.assertThat(torpilleur.getId()).isEqualTo(1);
    }
    @Test
    void test_torpilleur3() {
        Torpilleur torpilleur = new Torpilleur(1,1,1);
        Assertions.assertThat(torpilleur.getAbscisse()).isEqualTo(1);
    }
    @Test
    void test_torpilleur4() {
        Torpilleur torpilleur = new Torpilleur(1,1,1);
        Assertions.assertThat(torpilleur.getOrdonnee()).isEqualTo(1);
    }

}
