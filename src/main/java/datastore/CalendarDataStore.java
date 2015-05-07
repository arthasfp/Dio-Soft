package datastore;

import common.Event;

import java.util.GregorianCalendar;

public interface CalendarDataStore {

    void addEventToMap(Event event);
    Event remove (String title);
    Event getEvent (String title);
    Event getByDate(GregorianCalendar gregorianCalendar);

}
