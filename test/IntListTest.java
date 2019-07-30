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
    void canCreateAnIntList() {
        assertEquals(0, intList.getSize());
    }

    @Test
    void canAddOnce() {
        intList.add(99);
        assertEquals(1, intList.getSize(),
        "Unexpected value retrieved from intList");
        assertEquals(99, intList.getContents()[0],
                "Unexpected value retrieved from intList");
    }

    @RepeatedTest(3)
    void canRepeatAdd(RepetitionInfo repetitionInfo) {
        // elementCount increments thus 1, 2, 3, ...
        final int elementCount = repetitionInfo.getCurrentRepetition();
        // put integers into intList
        for (int index = 0; index < elementCount; index++)
            intList.add(index);
        // intList is the right length?
        assertEquals(elementCount, intList.getSize());
        // check the right inte are in the right place
        for (int index = 0; index < elementCount; index++) {
            String msg = "failed when testing for value " + index + "at position " + index;
            assertEquals(index, intList.getContents()[index], msg);
        }
    }

    @Test
    void canGetAt() {
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
    void canThowWhenEmpptyIndexError() {
        assertThrows(Exception.class, () -> {
            intList.getAt(0);
        });
    }

}