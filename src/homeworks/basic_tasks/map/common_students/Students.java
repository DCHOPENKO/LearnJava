package homeworks.basic_tasks.map.common_students;

import java.util.Objects;

public class Students {
    private final int id;
    private final String name;

    public Students(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Students students = (Students) o;
        return id == students.id && Objects.equals(name, students.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "id is - " + id + ", Name - " + name + ".";
    }
}
