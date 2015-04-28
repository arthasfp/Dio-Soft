import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class Event {

    private final String description;
    private final List<Person> attenders;
    private final GregorianCalendar gregorianCalendar;

    public Event(Builder builder) {
        this.description = builder.description;
        this.attenders = builder.attenders;
        this.gregorianCalendar = builder.gregorianCalendar;
    }

    public String getDescription() {
        return description;
    }

    public List<Person> getAttenders() {
        return attenders;
    }

    public GregorianCalendar getDate() {
        return gregorianCalendar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Event event = (Event) o;

        if (attenders != null ? !attenders.equals(event.attenders) : event.attenders != null) return false;
        if (gregorianCalendar != null ? !gregorianCalendar.equals(event.gregorianCalendar) : event.gregorianCalendar != null) return false;
        if (description != null ? !description.equals(event.description) : event.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = description != null ? description.hashCode() : 0;
        result = 31 * result + (attenders != null ? attenders.hashCode() : 0);
        result = 31 * result + (gregorianCalendar != null ? gregorianCalendar.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Event{" +
                "description='" + description + '\'' +
                ", attenders=" + attenders +
                ", date=" + gregorianCalendar +
                '}';
    }

    public static class Builder
    {
        private String description;
        private List<Person> attenders;
        private GregorianCalendar gregorianCalendar;

        public Builder() {
        }

        public Builder(Event original) {
            this.gregorianCalendar = original.gregorianCalendar;
            this.attenders = original.attenders;
            this.description = original.description;
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

        public Builder gregorianCalendar(GregorianCalendar gregorianCalendar)
        {
            this.gregorianCalendar = gregorianCalendar;
            return this;
        }

        public Event build()
        {
            return new Event(this);
        }

    }
}
