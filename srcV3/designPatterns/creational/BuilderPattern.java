package designPatterns.creational;

/**
 * The Builder Pattern is a creational design pattern that lets you construct complex objects step-by-step.
 * It separates the construction logic from the actual object representation, allowing the same construction process to create different representations.
 */
public class BuilderPattern {
    // Product class
    public  static class Computer {
        private final String cpu;
        private final String ram;
        private final String storage;
        private final boolean hasGraphicsCard;

        // Private constructor to enforce builder usage
        private Computer(Builder builder) {
            this.cpu = builder.cpu;
            this.ram = builder.ram;
            this.storage = builder.storage;
            this.hasGraphicsCard = builder.hasGraphicsCard;
        }

        public static class Builder {
            private String cpu;
            private String ram;
            private String storage;
            private boolean hasGraphicsCard;

            public Builder setCpu(String cpu) {
                this.cpu = cpu;
                return this;
            }

            public Builder setRam(String ram) {
                this.ram = ram;
                return this;
            }

            public Builder setStorage(String storage) {
                this.storage = storage;
                return this;
            }

            public Builder setGraphicsCard(boolean hasGraphicsCard) {
                this.hasGraphicsCard = hasGraphicsCard;
                return this;
            }

            public Computer build() {
                return new Computer(this);
            }
        }

        @Override
        public String toString() {
            return "Computer{" +
                    "cpu='" + cpu + '\'' +
                    ", ram='" + ram + '\'' +
                    ", storage='" + storage + '\'' +
                    ", hasGraphicsCard=" + hasGraphicsCard +
                    '}';
        }
    }

}
