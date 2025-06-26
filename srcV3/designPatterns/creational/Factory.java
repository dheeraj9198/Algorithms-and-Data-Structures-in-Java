package designPatterns.creational;

/**
 * In Factory pattern, we create object without exposing the creation logic to the client and refer to newly created object using a common interface.
 */
public class Factory {

    interface Animal {
        void speak();
    }

   static class Dog implements Animal {
        public void speak() { System.out.println("Woof"); }
    }

    static class Cat implements Animal {
        public void speak() { System.out.println("Meow"); }
    }

    static class AnimalFactory {
        public static Animal createAnimal(String type) {
             switch (type) {
                 case "dog" : return new Dog();
                 case "cat" : return new Cat();
                 default : throw new IllegalArgumentException("Unknown");
            }
        }
    }

}
