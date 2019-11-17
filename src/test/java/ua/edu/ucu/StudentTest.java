package ua.edu.ucu;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class StudentTest {
    private Student studik1;

    @Before
    public void SetUp() {
        studik1 = new Student("Mary", "Petriv", 5.5, 2);
    }

    @Test
    public void testGetters() {
        assertEquals(studik1.getgPA(), 5.5, 0.00001);
        assertEquals(studik1.getYear(), 2);
        assertEquals(studik1.getName(), new String("Mary"));
        assertEquals(studik1.getSurname(), new String("Petriv"));
    }

    @Test
    public void testtoString() {
        assertEquals(studik1.toString(), "Student{name=Mary, surname=Petriv, gPA=5.5, year=2}");
    }

    @Test
    public void testTrue() {
        Student studik2 = new Student("Mary", "Petriv", 5.5, 2);
        assertEquals(studik1, studik2);
    }

    @Test
    public void testFalse() {
        Student studik2 = new Student("Marik", "Petriv", 5.5, 2);
        assertNotEquals(studik1, studik2);
    }

    @Test
    public void testInt() {
        assertNotEquals(studik1, 4);
    }

    @Test
    public void testHashCode() {
        Student studik2 = new Student("Mary", "Petriv", 5.5, 2);
        assertEquals(studik1.hashCode(), studik2.hashCode());
    }

}