package test;

import model.Feet;
import model.Inches;
import service.MeasurementService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MeasurementTest {

    MeasurementService service = new MeasurementService();

    // Feet Tests
    @Test
    void testFeetSameValue() {
        assertTrue(service.compareFeet(new Feet(1.0), new Feet(1.0)));
    }

    @Test
    void testFeetDifferentValue() {
        assertFalse(service.compareFeet(new Feet(1.0), new Feet(2.0)));
    }

    @Test
    void testFeetNullComparison() {
        Feet f = new Feet(1.0);
        assertFalse(f.equals(null));
    }

    @Test
    void testFeetDifferentType() {
        Feet f = new Feet(1.0);
        assertFalse(f.equals("ABC"));
    }

    @Test
    void testFeetSameReference() {
        Feet f = new Feet(1.0);
        assertTrue(f.equals(f));
    }

    // Inches Tests
    @Test
    void testInchesSameValue() {
        assertTrue(service.compareInches(new Inches(1.0), new Inches(1.0)));
    }

    @Test
    void testInchesDifferentValue() {
        assertFalse(service.compareInches(new Inches(1.0), new Inches(2.0)));
    }

    @Test
    void testInchesNullComparison() {
        Inches i = new Inches(1.0);
        assertFalse(i.equals(null));
    }

    @Test
    void testInchesDifferentType() {
        Inches i = new Inches(1.0);
        assertFalse(i.equals("ABC"));
    }

    @Test
    void testInchesSameReference() {
        Inches i = new Inches(1.0);
        assertTrue(i.equals(i));
    }
}