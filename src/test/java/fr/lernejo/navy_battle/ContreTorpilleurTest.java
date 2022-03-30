package fr.lernejo.navy_battle;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContreTorpilleurTest {
    @Test
    void test_contreTorpilleur1() {
        ContreTorpilleur contreTorpilleur = new ContreTorpilleur(1,1,1);
        Assertions.assertThat(contreTorpilleur.getNom()).isEqualTo("Contre-Torpilleur");
    }
    @Test
    void test_contreTorpilleur2() {
        ContreTorpilleur contreTorpilleur = new ContreTorpilleur(1,1,1);
        Assertions.assertThat(contreTorpilleur.getId()).isEqualTo(1);
    }
    @Test
    void test_contreTorpilleur3() {
        ContreTorpilleur contreTorpilleur = new ContreTorpilleur(1,1,1);
        Assertions.assertThat(contreTorpilleur.getAbscisse()).isEqualTo(1);
    }
    @Test
    void test_contreTorpilleur4() {
        ContreTorpilleur contreTorpilleur = new ContreTorpilleur(1,1,1);
        Assertions.assertThat(contreTorpilleur.getOrdonnee()).isEqualTo(1);
    }

}
