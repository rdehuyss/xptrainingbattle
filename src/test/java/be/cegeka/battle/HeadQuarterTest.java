package be.cegeka.battle;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class HeadQuarterTest {

    @Mock
    IHeadquarters hq;

    @Test
    public void givenSoldierEnlistment_thenReportedToHQ() {
        Soldier alice = new Soldier("Alice");
        Army army = new Army(hq);

        army.enroll(alice);

        verify(hq).reportEnlistment("Alice");
    }
}
