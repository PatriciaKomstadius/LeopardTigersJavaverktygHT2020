package Main.Test;

import Main.Main;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {

    @Test
    void testAdd(){
        Main main = new Main();
        assertEquals("Johanna0808", main.add("Johanna", "0808"));


    }
}