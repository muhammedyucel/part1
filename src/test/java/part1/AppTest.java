/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package part1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

class AppTest {
    @Test
    void appHasAGreeting() {
        App classUnderTest = new App();
        assertNotNull(classUnderTest.getGreeting(), "app should have a greeting");
    }

    @Test
    public void testDogru() {
        // Girilen elemanlar 0'dan büyük ve array boş değilse true dönder
        ArrayList<Integer> array = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        int boy = 187, kilo = 87, yas = 22;
        assertTrue(App.kaloriKontrol(array, boy, yas, kilo));

    }

    @Test
    public void testNotFound() {
        int boy = 0, kilo = 0, yas = 0;
        // Girilen elemanlar 0'dan küçük ise false değeri dönderecek
        ArrayList<Integer> array = new ArrayList<>(Arrays.asList(1, 2, 3, 4));

        if (boy < 0 || kilo < 0 || yas < 0) {
            assertFalse(App.kaloriKontrol(array, boy, yas, kilo));

        }
    }

    // arrayin boşluğunu kontrol eden test
    @Test
    public void testBosArray() {
        int boy = 187;
        int kilo = 87;
        int yas = 22;
        ArrayList<Integer> array = new ArrayList<>();

        assertFalse(App.kaloriKontrol(array, boy, yas, kilo));
    }

    @Test
    public void testNull() {
        int boy = 0, kilo = 0, yas = 0;
        assertFalse(App.kaloriKontrol(null, boy, yas, kilo));

    }

}
