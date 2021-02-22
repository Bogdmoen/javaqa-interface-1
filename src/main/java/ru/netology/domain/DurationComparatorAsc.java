package ru.netology.domain;

import java.util.Comparator;

public class DurationComparatorAsc implements Comparator<Ticket> {

    @Override
    public int compare(Ticket o1, Ticket o2) {
        return o1.getDuration() - o2.getDuration();
    }
}
