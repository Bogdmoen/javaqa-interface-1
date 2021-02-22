package ru.netology.ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.DurationComparatorAsc;
import ru.netology.domain.DurationComparatorDesc;
import ru.netology.domain.PriceComparatorAsc;
import ru.netology.domain.Ticket;


import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTest {
    TicketManager manager = new TicketManager();

    Ticket first = new Ticket(1, 5_000, "DME", "LED", 200);
    Ticket second = new Ticket(2, 1_000, "DME", "PKC", 500);
    Ticket third = new Ticket(3, 3_000, "DME", "LED", 900);
    Ticket forth = new Ticket(4, 2_000, "LED", "DME", 300);
    Ticket fifth = new Ticket(5, 2_500, "DME", "LED", 400);


    @BeforeEach
    public void setUp() {
        manager.addItem(first);
        manager.addItem(second);
        manager.addItem(third);
        manager.addItem(forth);
        manager.addItem(fifth);
    }

    @Test
    public void shouldGetSearchResult() {

        Ticket[] actual = manager.getAll("DME", "LED");
        Ticket[] expected = new Ticket[]{fifth, third, first};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetSearchResultPriceAsc() {

        Ticket[] actual = manager.getAllComp("DME", "LED", new PriceComparatorAsc());
        Ticket[] expected = new Ticket[]{fifth, third, first};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetSearchResultDurationAsc() {

        Ticket[] actual = manager.getAllComp("DME", "LED", new DurationComparatorAsc());
        Ticket[] expected = new Ticket[]{first, fifth, third};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetSearchResultDurationDesc() {

        Ticket[] actual = manager.getAllComp("DME", "LED", new DurationComparatorDesc());
        Ticket[] expected = new Ticket[]{third, fifth, first};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetEmptySearchResult() {

        Ticket[] actual = manager.getAll("PKC", "LED");
        Ticket[] expected = new Ticket[0];

        assertArrayEquals(expected, actual);
    }

}