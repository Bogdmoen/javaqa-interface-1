package ru.netology.domain;

import java.util.Comparator;

public class DurationComparatorDesc implements Comparator<Ticket> {

    @Override
    public int compare(Ticket o1, Ticket o2) {
        return o2.getDuration() - o1.getDuration() ;
    }
}
