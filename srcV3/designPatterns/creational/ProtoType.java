package designPatterns.creational;

/**
 * The Prototype Pattern is a creational design pattern that creates new objects by copying an existing object (the "prototype") instead of creating them from scratch.
 * It’s like cloning objects to save cost/time rather than building new ones manually!
 */
public class ProtoType {
    // Step 1: Create a Prototype interface
    public interface Prototype {
        Prototype clone();
    }
    // Step 2: Implement a concrete class
    public class Vehicle implements Prototype {
        private String brand;
        private String model;

        public Vehicle(String brand, String model) {
            this.brand = brand;
            this.model = model;
        }

        // Implement clone method
        public Prototype clone() {
            return new Vehicle(this.brand, this.model);
        }

        @Override
        public String toString() {
            return "Vehicle{" + "brand='" + brand + "', model='" + model + "'}";
        }
    }

}
