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
    public void addEvent(Event event) throws RemoteException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Event createEvent(String title, String description, GregorianCalendar startDate, GregorianCalendar endDate, List<Person> attenders) throws RemoteException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Event searchEvent(String title) throws RemoteException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Event remove(String title) throws RemoteException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
