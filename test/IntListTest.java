import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer.Random;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(Random.class)
class IntListTest {
    private IntList intList;

    @BeforeEach
    void setUp() {
        intList = new IntList(4);
    }

    /* @AfterEach
    void tearDown() {
    } */

    @Test
    void createEmpty() {
        assertEquals(0, intList.getSize());
    }

    @Test
    void addOne() {
        intList.add(99);
        assertEquals(1, intList.getSize(),
        "Unexpected value retrieved from intList");
        assertEquals(99, intList.getContents()[0],
                "Unexpected value retrieved from intList");
    }

    @RepeatedTest(3)
    void repeatedAdding(RepetitionInfo repetitionInfo) {
        //System.out.println("Repetition #" + repetitionInfo.getCurrentRepetition());
        for (int val = 0; val < repetitionInfo.getCurrentRepetition(); val++) {
            intList.add(val);
            //System.out.println("adding " + val);
        }
        assertEquals(repetitionInfo.getCurrentRepetition(), intList.getSize());
        for (int index = 0; index < repetitionInfo.getCurrentRepetition(); index++) {
            assertEquals(index, intList.getContents()[index]);
            //System.out.println("tested " + index + "at position " + index);
        }
    }

    @Test
    void testGetter() {
        intList.add(6);
        intList.add(5);
        intList.add(4);
        try {
            assertEquals(6, intList.getAt(0));
            assertEquals(5, intList.getAt(1));
            assertEquals(4, intList.getAt(2));
        }
        catch (Exception e) {
            fail("Exception: " + e.getMessage() );
        }
    }

    /* testing that there is a thrown exception
    @Test
    void testEmptyGet() {
        assertDoesNotThrow( () -> {
            intList.getAt(0);
        });
    }
    */
    @Test
    void testEmptyGet() {
        assertThrows(Exception.class, () -> {
            intList.getAt(0);
        });
    }

}