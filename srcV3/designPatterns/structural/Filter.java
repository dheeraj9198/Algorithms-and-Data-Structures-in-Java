package designPatterns.structural;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *The Filter Pattern (also known as the Specification Pattern) is a structural design pattern used to
 * filter a collection of objects based on specific criteria, using a series of filter conditions or predicates.
 * It allows you to combine multiple filters to apply complex filtering logic in a modular and flexible way.
 */
public class Filter {
    //1. Model Class

    static class Person {
        String name;
        String gender;
        String profession;

        Person(String name, String gender, String profession) {
            this.name = name;
            this.gender = gender;
            this.profession = profession;
        }

        public String toString() {
            return name + " (" + gender + ", " + profession + ")";
        }
    }

//2. Criteria Interface

    interface Criteria {
        List<Person> meetCriteria(List<Person> persons);
    }

//3. Concrete Filters

    static class CriteriaMale implements Criteria {
        public List<Person> meetCriteria(List<Person> persons) {
            return persons.stream()
                    .filter(p -> p.gender.equalsIgnoreCase("Male"))
                    .collect(Collectors.toList());
        }
    }

    static class CriteriaEngineer implements Criteria {
        public List<Person> meetCriteria(List<Person> persons) {
            return persons.stream()
                    .filter(p -> p.profession.equalsIgnoreCase("Engineer"))
                    .collect(Collectors.toList());
        }
    }

//4. Combinator Filters (AND / OR)

    static class AndCriteria implements Criteria {
        private Criteria criteria;
        private Criteria otherCriteria;

        AndCriteria(Criteria c1, Criteria c2) {
            this.criteria = c1;
            this.otherCriteria = c2;
        }

        public List<Person> meetCriteria(List<Person> persons) {
            return otherCriteria.meetCriteria(criteria.meetCriteria(persons));
        }
    }

    static class OrCriteria implements Criteria {
        private Criteria criteria;
        private Criteria otherCriteria;

        OrCriteria(Criteria c1, Criteria c2) {
            this.criteria = c1;
            this.otherCriteria = c2;
        }

        public List<Person> meetCriteria(List<Person> persons) {
            Set<Person> result = new HashSet<>(criteria.meetCriteria(persons));
            result.addAll(otherCriteria.meetCriteria(persons));
            return new ArrayList<>(result);
        }
    }

//5. Client Code

    public static class Main {
        public static void main(String[] args) {
            List<Person> people = new ArrayList<>();
            people.add(new Person("Alice", "Female", "Engineer"));
            people.add(new Person("Bob", "Male", "Doctor"));
            people.add(new Person("Charlie", "Male", "Engineer"));
            people.add(new Person("Diana", "Female", "Artist"));

            Criteria male = new CriteriaMale();
            Criteria engineer = new CriteriaEngineer();
            Criteria maleAndEngineer = new AndCriteria(male, engineer);
            Criteria maleOrEngineer = new OrCriteria(male, engineer);

            System.out.println("Male Engineers:");
            maleAndEngineer.meetCriteria(people).forEach(System.out::println);

            System.out.println("\nMales OR Engineers:");
            maleOrEngineer.meetCriteria(people).forEach(System.out::println);
        }
    }
}
