package be.cegeka.battle;

import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArmyTestBuilder {

    private List<Soldier> soldiers;

    private IHeadquarters hq;

    private ArmyTestBuilder() {

    }

    public static ArmyTestBuilder aDefaultArmy() {
        return new ArmyTestBuilder();
    }

    public ArmyTestBuilder withSoldiers(Soldier... soldiers) {
        this.soldiers = Arrays.asList(soldiers);
        return this;
    }

    public ArmyTestBuilder withSoldiers(SoldierTestBuilder... soldierTestBuilders) {
        this.soldiers = Arrays.stream(soldierTestBuilders).map(stb -> stb.build()).collect(Collectors.toList());
        return this;
    }

    public ArmyTestBuilder withHQ(IHeadquarters hq) {
        this.hq = hq;
        return this;
    }

    public Army build() {
        Army army = createArmy();
        for (Soldier s: soldiers) {
            army.enroll(s);
        }
        return army;

    }

    private Army createArmy() {
        Army army;
        if (hq == null) {
            army = new Army(Mockito.mock(IHeadquarters.class));
        } else {
            army = new Army(hq);
        }
        return army;
    }
}
