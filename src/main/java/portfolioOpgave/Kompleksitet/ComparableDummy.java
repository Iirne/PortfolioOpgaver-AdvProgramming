package portfolioOpgave.Kompleksitet;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class ComparableDummy implements Comparable<ComparableDummy>{

    private int id;

    @Override
    public int compareTo(ComparableDummy o) {
        return id - o.getId();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComparableDummy that = (ComparableDummy) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
