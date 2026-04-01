import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

public class ListOperationTest {

    ListManager manager = new ListManager();
    List<Integer> list = new ArrayList<>();

    @Test
    void testAddElement() {
        manager.addElement(list, 10);
        assertTrue(list.contains(10));
    }

    @Test
    void testRemoveElement() {
        list.add(5);
        manager.removeElement(list, 5);
        assertFalse(list.contains(5));
    }

    @Test
    void testListSize() {
        list.add(1);
        list.add(2);
        assertEquals(2, manager.getSize(list));
    }
}


