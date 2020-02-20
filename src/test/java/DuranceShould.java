import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.verification.VerificationMode;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


@RunWith(MockitoJUnitRunner.class)
public class DuranceShould {

    @Mock
    private Weapon weapon;

@Mock
    private MagicBook magicBook;

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

    @Test
    public void enchant_a_weapon() {
        Durance durance = new Durance(weapon, magicBook);
        given(weapon.stats()).willReturn(
                "Inferno Dagger of the Nooblet\n" +
                        "5 - 10 attack damage\n" +
                        "1.2 attack speed\n" +
                        "+5 fire damage\n");

        durance.enchant();
        String weaponDescription = durance.describeWeapon();

        verify(magicBook, times(1)).enchant(weapon);
        assertThat(weaponDescription).isEqualTo("Inferno Dagger of the Nooblet\n" +
                "5 - 10 attack damage\n" +
                "1.2 attack speed\n" +
                "+5 fire damage\n");
    }
}