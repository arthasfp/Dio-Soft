package datastore;

import common.Event;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;

public class CalendarDataStoreImpl implements CalendarDataStore {

    HashMap <String, Event> calendarSource = new HashMap<String, Event>();

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

    @Override
    public Event getByDate(GregorianCalendar someSearchedDate) {

        HashMap<String, Event> map = new HashMap<>();
        Iterator<HashMap.Entry<String, Event>> entries = map.entrySet().iterator();

        Event searchedEvent  = null;
        while (entries.hasNext()) {
            HashMap.Entry<String, Event> entry = entries.next();
            if ((someSearchedDate.before(entry.getValue().getStartDate()) == false) && (someSearchedDate.after(entry.getValue().getEndDate()) == false));
            searchedEvent = entry.getValue();

        }
        return searchedEvent;
    }
}
