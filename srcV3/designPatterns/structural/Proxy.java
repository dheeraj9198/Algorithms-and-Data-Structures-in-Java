package designPatterns.structural;

/**
 * The Proxy Pattern is a structural design pattern that provides a substitute or placeholder for another object to control access to it.
 * It lets you intervene in how a client interacts with the real object—whether for access control, lazy initialization, logging, or performance optimization.
 */
public class Proxy {

    interface Image {
        void display();
    }

    class RealImage implements Image {
        private String filename;

        public RealImage(String filename) {
            this.filename = filename;
            loadFromDisk();//costly operation
        }

        private void loadFromDisk() {
            System.out.println("Loading image from disk: " + filename);
        }

        @Override
        public void display() {
            System.out.println("Displaying image: " + filename);
        }
    }

    class ProxyImage implements Image {
        private RealImage realImage;
        private String filename;

        public ProxyImage(String filename) {
            this.filename = filename;
        }

        @Override
        public void display() {
            if (realImage == null) {
                realImage = new RealImage(filename);
            }
            realImage.display();
        }
    }

}
