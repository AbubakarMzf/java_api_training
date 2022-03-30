package fr.lernejo.navy_battle;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ServerTest {
    @Test
    void test_server1() {
        int port = 3000;
        Server serverClass = new Server(port);
        Assertions.assertThat(serverClass.getPort()).isEqualTo(port);
    }
}
