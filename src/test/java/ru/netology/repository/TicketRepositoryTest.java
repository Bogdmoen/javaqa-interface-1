package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;

import static org.junit.jupiter.api.Assertions.*;

class TicketRepositoryTest {
    TicketRepository repository = new TicketRepository();

    Ticket first = new Ticket(1, 1_000, "DME", "LED", 600);
    Ticket second = new Ticket(2, 1_000, "DME", "PKC", 600);
    Ticket third = new Ticket(3, 3_000, "DME", "LED", 600);
    Ticket forth = new Ticket(4, 2_000, "LED", "DME", 600);
    Ticket fifth = new Ticket(5, 2_500, "DME", "LED", 600);

    @Test
    public void shouldSaveItem() {

        repository.saveItem(first);

        Ticket[] actual = repository.findAll();
        Ticket[] expected = new Ticket[] {first};

        assertArrayEquals(expected, actual);
    }
}