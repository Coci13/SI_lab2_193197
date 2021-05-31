import junit.framework.TestCase;
import org.junit.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class SILab2Test extends TestCase {

    
        private SILab2 cociObject;

        @Test
        void everyBranchTest() {

           
            RuntimeException exception;
            exception = assertThrows(RuntimeException.class, () -> cociObject.function(List.of(new Time(-3, 23, 0))));
            assertTrue(exception.getMessage().contains("The hours are smaller than the minimum"));

            exception = assertThrows(RuntimeException.class, () -> cociObject.function(List.of(new Time(28, 23, 0))));
            assertTrue(exception.getMessage().contains("The hours are grater than the maximum"));

            exception = assertThrows(RuntimeException.class, () -> cociObject.function(List.of(new Time(20, 72, 0))));
            assertTrue(exception.getMessage().contains("The minutes are not valid!"));

            exception = assertThrows(RuntimeException.class, () -> cociObject.function(List.of(new Time(20, 2, 65))));
            assertTrue(exception.getMessage().contains("The seconds are not valid"));

            exception = assertThrows(RuntimeException.class, () -> cociObject.function(List.of(new Time(27,69,69))));
            assertTrue(exception.getMessage().contains("The time is greater than the maximum"));

            assertEquals(java.util.Optional.of(72135), cociObject.function(List.of(new Time(20,2,15))).get(0));
            assertEquals(java.util.Optional.of(86400),cociObject.function(List.of(new Time(24,0,0))).get(0));
        }
    @Test
    void multipleConditionsTest()
    {
        RuntimeException ex;
        ex = assertThrows(RuntimeException.class, () -> cociObject.function(List.of(new Time(-8,0,5))));
        assertTrue(ex.getMessage().contains("The hours are smaller than the minimum"));

        ex = assertThrows(RuntimeException.class, () -> cociObject.function(List.of(new Time(29,5,5))));
        assertTrue(ex.getMessage().contains("The hours are grater than the maximum"));

        ex = assertThrows(RuntimeException.class, () -> cociObject.function(List.of(new Time(20,-12,5))));
        assertTrue(ex.getMessage().contains("The minutes are not valid!"));

        ex = assertThrows(RuntimeException.class, () -> cociObject.function(List.of(new Time(19,85,3))));
        assertTrue(ex.getMessage().contains("The minutes are not valid!"));

        ex = assertThrows(RuntimeException.class, () -> cociObject.function(List.of(new Time(17,52,-45))));
        assertTrue(ex.getMessage().contains("The seconds are not valid"));

        ex = assertThrows(RuntimeException.class, () -> cociObject.function(List.of(new Time(16,13,95))));
        assertTrue(ex.getMessage().contains("The seconds are not valid"));

        assertEquals(java.util.Optional.of(72135), cociObject.function(List.of(new Time(20,2,15))).get(0));
    }


}