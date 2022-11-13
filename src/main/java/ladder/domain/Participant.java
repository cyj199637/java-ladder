package ladder.domain;

import java.util.Objects;

public class Participant {

    private final Name name;
    private PositiveInt position;

    public Participant(final String name, final int position) {
        this.name = new Name(name);
        this.position = new PositiveInt(position);
    }

    public void changePosition(final int position) {
        this.position = new PositiveInt(position);
    }

    public boolean isEqualName(final String name) {
        return this.name.equals(new Name(name));
    }

    public PositiveInt getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Participant)) {
            return false;
        }

        Participant that = (Participant) o;

        if (!this.name.equals(that.name)) {
            return false;
        }

        return this.position.equals(that.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }

    @Override
    public String toString() {
        return name.toString();
    }
}
