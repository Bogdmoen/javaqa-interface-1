package ru.netology.ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTest {

    TicketManager manager = new TicketManager(new TicketRepository());

    Ticket first = new Ticket(1, 1_000, "DME", "LED", 600);
    Ticket second = new Ticket(2, 1_000, "DME", "PKC", 600);
    Ticket third = new Ticket(3, 3_000, "DME", "LED", 600);
    Ticket forth = new Ticket(4, 2_000, "LED", "DME", 600);
    Ticket fifth = new Ticket(5, 2_500, "DME", "LED", 600);


    @BeforeEach
    public void setUp() {
        manager.addItem(first);
        manager.addItem(second);
        manager.addItem(third);
        manager.addItem(forth);
        manager.addItem(fifth);
    }

    @Test
    public void shouldGetAll() {

        Ticket[] actual = manager.getAll("DME", "LED");
        Ticket[] expected = new Ticket[]{first, third, fifth};

        assertArrayEquals(expected, actual);
    }
}