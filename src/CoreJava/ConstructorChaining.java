package CoreJava;

/**
 * Created by dheeraj on 31/12/14.
 */
public class ConstructorChaining {
        public static void main(String[] args) {
            final Sub sub = new Sub();
            System.err.println("Finished.");
        }

        private static class Base {
            public Base() {
                System.err.println("In Base ctor");
            }
        }

        private static class Sub extends Base {
            public Sub() {
                System.err.println("In Sub ctor");
            }
        }
    }