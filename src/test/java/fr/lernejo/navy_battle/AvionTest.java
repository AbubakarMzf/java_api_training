package fr.lernejo.navy_battle;

import com.sun.net.httpserver.HttpServer;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.junit.jupiter.api.Assertions.*;

class AvionTest {
    @Test
    void test_avion1() {
            Avion avion = new Avion(1,1,1);
            Assertions.assertThat(avion.getNom()).isEqualTo("Avion");
    }
    @Test
    void test_avion2() {
        Avion avion = new Avion(1,1,1);
        Assertions.assertThat(avion.getId()).isEqualTo(1);
    }
    @Test
    void test_avion3() {
        Avion avion = new Avion(1,1,1);
        Assertions.assertThat(avion.getAbscisse()).isEqualTo(1);
    }
    @Test
    void test_avion4() {
        Avion avion = new Avion(1,1,1);
        Assertions.assertThat(avion.getOrdonnee()).isEqualTo(1);
    }
}
