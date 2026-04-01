import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class DatabaseConnectionTest {

    DatabaseConnection db;

    @BeforeEach
    void setup() {
        db = new DatabaseConnection();
        db.connect();
    }

    @AfterEach
    void teardown() {
        db.disconnect();
    }

    @Test
    void testConnectionEstablished() {
        assertTrue(db.isConnected());
    }

    @Test
    void testConnectionClosed() {
        db.disconnect();
        assertFalse(db.isConnected());
    }
}



