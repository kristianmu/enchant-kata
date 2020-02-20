import org.junit.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;


public class DuranceShould {

    @Test
    public void describe_a_non_enchanted_weapon() {
        Weapon weapon = Mockito.mock(Weapon.class);
        MagicBook magicBook = new MagicBook();
        Durance durance = new Durance(weapon, magicBook);
        given(weapon.stats()).willReturn(
                "Dagger of the Nooblet\n" +
                "5 - 10 attack damage\n" +
                "1.2 attack speed\n");

        String description = durance.describeWeapon();

        assertThat(description).isEqualTo(
                "Dagger of the Nooblet\n" +
                "5 - 10 attack damage\n" +
                "1.2 attack speed\n");
    }
}