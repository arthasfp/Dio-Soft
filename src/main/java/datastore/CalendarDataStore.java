package datastore;

import common.Event;

public interface CalendarDataStore {

    void addEventToMap(Event event);
    Event remove (String title);
    Event getEvent (String title);

}
