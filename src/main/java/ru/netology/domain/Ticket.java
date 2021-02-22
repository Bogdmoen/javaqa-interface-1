package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ticket implements Comparable<Ticket> {
    private int id;
    private int cost;
    private String from;
    private String to;
    private int duration;


    public boolean matches (String fromSearch, String toSearch) {
        if (getFrom().equalsIgnoreCase(fromSearch) && getTo().equalsIgnoreCase(toSearch)) {
            return true;
        }
        return false;
    }

    @Override
    public int compareTo(Ticket o) {

        return 0;
    }
}
