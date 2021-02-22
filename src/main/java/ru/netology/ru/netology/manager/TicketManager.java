package ru.netology.ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

import java.util.Arrays;

@AllArgsConstructor
@NoArgsConstructor
public class TicketManager {

    TicketRepository repository = new TicketRepository();


    public void addItem(Ticket ticket) {
        repository.saveItem(ticket);
    }

    public Ticket[] getAll(String from, String to) {
        Ticket[] tmp;
        Ticket[] result = new Ticket[0];
        int index = 1;
        for (Ticket ticket : repository.findAll()) {

            if (ticket.matches(from, to)) {
                tmp = new Ticket[index];
                System.arraycopy(result, 0, tmp, 0, result.length);
                int lastIndex = tmp.length - 1;
                tmp[lastIndex] = ticket;
                result = tmp;
                index++;
            }
        }
        Arrays.sort(result);
        return result;
    }

}
