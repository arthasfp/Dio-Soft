package datastore;

import common.Event;

import java.util.HashMap;

public class CalendarDataStoreImpl implements CalendarDataStore {

    HashMap <String, Event> calendarSource = new HashMap<>();

    @Override
    public void addEventToMap(Event event) {
        calendarSource.put(event.getTitle(), event);

    }

    @Override
    public Event remove(String title) {
        Event event = calendarSource.get(title);
        calendarSource.remove(title);

        return event;
    }

    @Override
    public Event getEvent(String title) {
        return calendarSource.get(title);
    }
}
