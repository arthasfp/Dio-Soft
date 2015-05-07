package service;

import common.Event;
import common.Person;
import datastore.CalendarDataStore;

import java.rmi.RemoteException;
import java.util.*;
import java.util.logging.Logger;

import static java.util.Arrays.asList;

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

    @Override
    public Event addAttender(String title, Person... persons) throws RemoteException {
        Event oldEvent = dataStore.remove(title);
        if (oldEvent == null)
        {
            return null;
        }
        List<Person> newAttenders = new ArrayList<>(oldEvent.getAttenders());
        newAttenders.addAll(asList(persons));

        Event newEvent = new Event.Builder(oldEvent)
                .attenders(newAttenders)
                .build();
        dataStore.addEventToMap(newEvent);

        return newEvent;

    }

    @Override
    public boolean isPersonAvaliable(Person person, GregorianCalendar desireDate) {
        Event event = dataStore.getByDate(desireDate);
        boolean isPersonAvaliable = false;

        if(event.getAttenders().contains(person))
        {
            isPersonAvaliable = true;
        }
        return isPersonAvaliable;
    }
}
