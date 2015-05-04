package service;

import common.Event;
import common.Person;
import datastore.CalendarDataStore;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

public class CalendarServiceImpl implements CalendarService {

    public static final Logger logger = Logger.getAnonymousLogger();
    private final CalendarDataStore dataStore;

    public CalendarServiceImpl(CalendarDataStore dataStore) {
        this.dataStore = dataStore;
    }



    @Override
    public void createEvent(String title, String description, GregorianCalendar startDate, GregorianCalendar endDate, List<Person> attenders) throws RemoteException {
        dataStore.addEventToMap(new Event.Builder()
                .title(title)
                .description(description)
                .startDate(startDate)
                .endDate(endDate)
                .attenders(attenders)
                .build());

        logger.info("Published even on service side " + title);
    }

    @Override
    public Event searchEvent(String title) throws RemoteException {
        return dataStore.getEvent(title);
    }

    @Override
    public Event remove(String title) throws RemoteException {
        return dataStore.remove(title);
    }
}
