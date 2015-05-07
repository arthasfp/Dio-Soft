package service;

import common.Event;
import datastore.CalendarDataStore;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by ROLAND on 05.05.2015.
 */
public class CalendarServiceImplTest {

    @Test
    public void testSearchEvent() throws Exception {
      String testTitle = "Работа в команде";

        Event expectedEvent = new Event.Builder()
                .title(testTitle)
                .build();

        CalendarDataStore dataStore = mock(CalendarDataStore.class);
        when(dataStore.getEvent(testTitle)).thenReturn(expectedEvent);

        CalendarService calendarService = new CalendarServiceImpl(dataStore);

        Event returnedValue = calendarService.searchEvent(testTitle);

        // assert return value
        assertEquals(expectedEvent, returnedValue);

    }
}