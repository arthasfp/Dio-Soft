package service;


import common.Event;
import common.Person;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;

public interface CalendarService extends Remote {



    void createEvent(String title, String description, GregorianCalendar startDate, GregorianCalendar endDate, List<Person> attenders) throws RemoteException;

    Event searchEvent(String title)throws RemoteException;

    Event remove (String title) throws RemoteException;
}
