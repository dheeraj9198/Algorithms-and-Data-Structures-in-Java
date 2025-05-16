package designPatterns.structural;

/**
 * Decorator pattern allows a user to add new functionality to an existing object without altering its structure.
 *
 */
public class Decorator {
    // Component
    public interface Coffee {
        double cost();
        String ingredients();
    }

    // ConcreteComponent
    public class SimpleCoffee implements Coffee {
        @Override
        public double cost() {
            return 5;
        }

        @Override
        public String ingredients() {
            return "Coffee";
        }
    }

    // Decorator
    public abstract class CoffeeDecorator implements Coffee {
        protected Coffee decoratedCoffee;

        public CoffeeDecorator(Coffee decoratedCoffee) {
            this.decoratedCoffee = decoratedCoffee;
        }

        public double cost() {
            return decoratedCoffee.cost();
        }

        public String ingredients() {
            return decoratedCoffee.ingredients();
        }
    }

    // ConcreteDecorator - Adding Milk
    public class MilkDecorator extends CoffeeDecorator {

        public MilkDecorator(Coffee decoratedCoffee) {
            super(decoratedCoffee);
        }

        @Override
        public double cost() {
            return decoratedCoffee.cost() + 1.5;
        }

        @Override
        public String ingredients() {
            return decoratedCoffee.ingredients() + ", Milk";
        }
    }

    // ConcreteDecorator - Adding Sugar
    public class SugarDecorator extends CoffeeDecorator {

        public SugarDecorator(Coffee decoratedCoffee) {
            super(decoratedCoffee);
        }

        @Override
        public double cost() {
            return decoratedCoffee.cost() + 0.5;
        }

        @Override
        public String ingredients() {
            return decoratedCoffee.ingredients() + ", Sugar";
        }
    }

}
