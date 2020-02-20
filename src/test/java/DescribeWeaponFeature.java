import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class DescribeWeaponFeature {
    @Test
    public void print_weapon_stats() {
        Weapon weapon = new DaggerOfTheNoblet();
        MagicBook magicBook = new MagicBook();
        Durance durance = new Durance(weapon, magicBook);

        durance.enchant();

        assertThat(durance.describeWeapon()).isEqualTo("Inferno Dagger of the Nooblet\n" +
                "5 - 10 attack damage\n" +
                "1.2 attack speed\n" +
                "+5 fire damage\n");
    }
}
