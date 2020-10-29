import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class IngotTest {
    CalculateIngots calculateIngots = new CalculateIngots();

    @Test
    public void should_get_number_of_euros_for_ingots() {
        int input_ingot = 13;
        long ouptut = calculateIngots.getEurosForIngots(input_ingot);
        assertThat(ouptut).isEqualTo(13);
    }

    @Test
    public void should_not_split_when_result_of_split_is_less_than_the_actual_it_get_value_instead() {
        int input_ingot = 2;
        long ouptut = calculateIngots.getEurosForIngots(input_ingot);
        assertThat(ouptut).isEqualTo(2);
    }


}
