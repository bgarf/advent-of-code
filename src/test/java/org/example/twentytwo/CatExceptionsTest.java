package org.example.twentytwo;

import org.junit.jupiter.api.Test;

import java.text.ParseException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class CatExceptionsTest {
    Prompt mockPrompt = mock(Prompt.class);

    @Test
    public void shouldRetryWhenUserInputIsIncorrect() throws UnsupportedUserInputException, ParseException {
        when(mockPrompt.getPlayerInput())
                .thenReturn("tomato")
                .thenReturn("parsnip");

        CatExceptions examples = new CatExceptions(mockPrompt);

        Veg actualVeg = examples.getUsersChosenVeg();
        assertThat(actualVeg.growTimeDays()).isEqualTo(10);
    }
}