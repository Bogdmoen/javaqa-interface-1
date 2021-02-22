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


    public boolean matches(String fromSearch, String toSearch) {
        return getFrom().equalsIgnoreCase(fromSearch) && getTo().equalsIgnoreCase(toSearch);
    }

    @Override
    public int compareTo(Ticket o) {

        return cost - o.cost;
    }


}
