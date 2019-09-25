import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class Taller02Test {

    ArrayList datos = new ArrayList();

    @BeforeEach
    void setUp() {
        double [ ][ ] datosTesting = {
                {2.5, 3.0, 2.7, 3.8, 4.0, 3.1, 4.6, 2.3, 3.2, 3.1, 2.5, 2.2, 2.5, 3.0, 2.7, 3.8, 4.0, 3.1, 4.5, 2.3, 3.2, 3.1, 2.5, 2.2},
                {4.5, 2.3, 3.2, 3.1, 2.5, 2.2, 2.5, 3.0, 2.7, 3.8, 4.0, 3.1, 2.5, 2.2, 2.5, 3.0, 2.7, 3.8, 2.5, 3.0, 2.7, 3.8, 4.0, 3.1},
                {2.3, 3.2, 3.1, 2.5, 2.2, 2.5, 2.2, 2.5, 3.0, 2.7, 3.8, 2.5, 3.0, 2.7, 3.8, 4.0, 3.1, 3.8, 4.0, 3.1, 4.5, 2.3, 3.2, 2.9},
                {2.5, 3.0, 2.7, 3.8, 4.0, 3.1, 4.5, 2.3, 3.2, 3.1, 2.5, 2.2, 2.5, 2.2, 2.5, 3.0, 2.7, 3.8, 2.7, 3.8, 4.5, 2.3, 3.2, 3.1},
                {3.8, 4.0, 3.1, 4.5, 2.3, 3.2, 2.5, 2.2, 2.5, 3.0, 2.7, 3.8, 4.5, 2.3, 3.2, 3.1, 2.5, 2.2, 2.5, 3.0, 2.7, 3.8, 4.0, 3.1}
        };
        datos.add(datosTesting);
    }

    @Test
    void testSismoMasIntenso() {
        assertEquals(4.6 ,Taller02.sismoMasIntenso((double[][]) datos.get(0)) );
        assertEquals(4,Taller02.sismoMasIntenso((double[][]) datos.get(0)));
    }

    @Test
    void testSismoRepetidos() {
        assertEquals(17 ,Taller02.sismoRepetidos((double[][]) datos.get(0),4.0));
        assertEquals(12 ,Taller02.sismoRepetidos((double[][]) datos.get(0),4.0));
    }
}