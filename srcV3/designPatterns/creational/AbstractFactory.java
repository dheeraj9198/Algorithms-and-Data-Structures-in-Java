package designPatterns.creational;

/**
 * The Abstract Factory Pattern is a creational design pattern that lets you create families of related objects without specifying their concrete classes.
 */
public class AbstractFactory {

    interface Button {
        void render();
    }

    interface Checkbox {
        void render();
    }

    static class WindowsButton implements Button {
        public void render() {
            System.out.println("Rendering a Windows button");
        }
    }

    static class WindowsCheckbox implements Checkbox {
        public void render() {
            System.out.println("Rendering a Windows checkbox");
        }
    }

    static class MacOSButton implements Button {
        public void render() {
            System.out.println("Rendering a MacOS button");
        }
    }

    static class MacOSCheckbox implements Checkbox {
        public void render() {
            System.out.println("Rendering a MacOS checkbox");
        }
    }

    interface GUIFactory {
        Button createButton();
        Checkbox createCheckbox();
    }

    static class WindowsFactory implements GUIFactory {
        public Button createButton() {
            return new WindowsButton();
        }

        public Checkbox createCheckbox() {
            return new WindowsCheckbox();
        }
    }

    static class MacOSFactory implements GUIFactory {
        public Button createButton() {
            return new MacOSButton();
        }

        public Checkbox createCheckbox() {
            return new MacOSCheckbox();
        }
    }

    static public class Application {
        private Button button;
        private Checkbox checkbox;

        public Application(GUIFactory factory) {
            button = factory.createButton();
            checkbox = factory.createCheckbox();
        }

        public void paint() {
            button.render();
            checkbox.render();
        }
    }

    public static void main(String[] args) {
        GUIFactory factory;
        String osName = "Mac";  // This could come from config/env

        if (osName.equalsIgnoreCase("Windows")) {
            factory = new WindowsFactory();
        } else {
            factory = new MacOSFactory();
        }
        Application app = new Application(factory);
        app.paint();
    }


}
