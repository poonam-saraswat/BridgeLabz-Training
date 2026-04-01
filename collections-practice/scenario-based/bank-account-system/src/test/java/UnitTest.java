import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UnitTest {

    @Test
    public void Test_Deposit_ValidAmount() {
        Program account = new Program(100.0);

        account.depositAmount(50.0);

        assertEquals(150.0, account.getBalance());
    }

    @Test
    public void Test_Deposit_NegativeAmount() {
        Program account = new Program(100.0);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> account.depositAmount(-20.0));

        assertEquals("Deposit amount cannot be negative", exception.getMessage());
    }

    @Test
    public void Test_Withdraw_ValidAmount() {
        Program account = new Program(200.0);

        account.withdrawAmount(50.0);

        assertEquals(150.0, account.getBalance());
    }

    @Test
    public void Test_Withdraw_InsufficientFunds() {
        Program account = new Program(100.0);

        Exception exception = assertThrows(IllegalArgumentException.class,() -> account.withdrawAmount(150.0));

        assertEquals("Insufficient funds.", exception.getMessage());
    }
}
