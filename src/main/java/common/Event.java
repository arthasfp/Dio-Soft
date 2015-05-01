package common;

import java.util.GregorianCalendar;
import java.util.List;

public class Event {

    private final String title;
    private final String description;
    private final List<Person> attenders;
    private final GregorianCalendar startDate;
    private final GregorianCalendar endDate;

    public Event(Builder builder) {
        this.title = builder.title;
        this.description = builder.description;
        this.attenders = builder.attenders;
        this.startDate = builder.startDate;
        this.endDate = builder.endDate;
    }

    public String getTitle() {
        return title;
    }

    public GregorianCalendar getStartDate() {
        return startDate;
    }

    public GregorianCalendar getEndDate() {
        return endDate;
    }

    public String getDescription() {
        return description;
    }

    public List<Person> getAttenders() {
        return attenders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Event event = (Event) o;

        if (attenders != null ? !attenders.equals(event.attenders) : event.attenders != null) return false;
        if (description != null ? !description.equals(event.description) : event.description != null) return false;
        if (endDate != null ? !endDate.equals(event.endDate) : event.endDate != null) return false;
        if (startDate != null ? !startDate.equals(event.startDate) : event.startDate != null) return false;
        if (title != null ? !title.equals(event.title) : event.title != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (attenders != null ? attenders.hashCode() : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Event{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", attenders=" + attenders +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }

    public static class Builder
    {
        private String title;
        private String description;
        private List<Person> attenders;
        private GregorianCalendar startDate;
        private GregorianCalendar endDate;

        public Builder() {
        }

        public Builder(Event original) {
            this.title = original.title;
            this.attenders = original.attenders;
            this.description = original.description;
            this.startDate = original.startDate;
            this.endDate = original.endDate;
        }

        public Builder title(String title)
        {
            this.title = title;
            return this;
        }

        public Builder description(String description)
        {
            this.description = description;
            return this;
        }

        public Builder attenders(List<Person> attenders)
        {
            this.attenders = attenders;
            return this;
        }

        public Builder startDate (GregorianCalendar startDate)
        {
            this.startDate = startDate;
            return this;
        }

        public Builder endDate (GregorianCalendar endDate)
        {
            this.endDate = endDate;
            return this;
        }

        public Event build()
        {
            return new Event(this);
        }

    }
}
