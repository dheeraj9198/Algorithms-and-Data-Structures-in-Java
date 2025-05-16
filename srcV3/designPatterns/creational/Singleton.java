package designPatterns.creational;

/**
 * The Singleton Pattern is a creational design pattern that ensures only one instance of a class exists and provides a global point of access to it.
 */
public class Singleton {

    private Singleton() {
    }

    private static class SingletonHelper {
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        return SingletonHelper.INSTANCE;
    }
}
