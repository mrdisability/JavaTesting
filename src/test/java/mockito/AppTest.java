package mockito;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Calendar;

public class AppTest {

    @Test
    public void testIt() {
        Calendar mockCalendar = Mockito.mock(Calendar.class);
    }
}
