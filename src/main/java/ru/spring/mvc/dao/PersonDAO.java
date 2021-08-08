package ru.spring.mvc.dao;

import ru.spring.mvc.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT = 0;
    private final List<Person> people;

    {
        people = new ArrayList<>();
        people.add(new Person(++PEOPLE_COUNT, "Bob"));
        people.add(new Person(++PEOPLE_COUNT, "Merch"));
        people.add(new Person(++PEOPLE_COUNT, "John"));
    }

    public List<Person> getAll() {
        return people;
    }

    public Person getPersonById(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update(int id, Person updatedPerson) {
        Person toBeUpdated = getPersonById(id);

        toBeUpdated.setName(updatedPerson.getName());
    }

    public void delete(int id) {
        people.removeIf(p -> p.getId() == id);
    }
}
