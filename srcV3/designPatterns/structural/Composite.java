package designPatterns.structural;
import java.util.ArrayList;
import java.util.List;

/**
 * This pattern creates a class that contains group of its own objects. This class provides ways to modify its group of same objects.
 * It lets you treat individual objects and compositions of objects uniformly.
 * It’s useful when you have to work with tree-like structures — like hierarchies of menus, UI components, or file systems.
 */
public class Composite {
   // 1. Component Interface

    interface FileSystemComponent {
        void display();   // Common operation
        int getSize();    // Common operation
    }

//2. Leaf Class

   static class File implements FileSystemComponent {
        private String name;
        private int size;

        public File(String name, int size) {
            this.name = name;
            this.size = size;
        }

        @Override
        public void display() {
            System.out.println("File: " + name + ", Size: " + size + "KB");
        }

        @Override
        public int getSize() {
            return size;
        }
    }

//3. Composite Class


   static class Directory implements FileSystemComponent {
        private String name;
        private List<FileSystemComponent> components;

        public Directory(String name) {
            this.name = name;
            this.components = new ArrayList<>();
        }

        public void addComponent(FileSystemComponent component) {
            components.add(component);
        }

        @Override
        public void display() {
            System.out.println("Directory: " + name);
            for (FileSystemComponent component : components) {
                component.display();
            }
        }

        @Override
        public int getSize() {
            int totalSize = 0;
            for (FileSystemComponent component : components) {
                totalSize += component.getSize();
            }
            return totalSize;
        }
    }

//4. Client Code

    public static class Main {
        public static void main(String[] args) {
            // Create files
            File file1 = new File("file1.txt", 100);
            File file2 = new File("file2.txt", 200);
            File file3 = new File("file3.txt", 150);

            // Create directories
            Directory dir1 = new Directory("dir1");
            Directory dir2 = new Directory("dir2");

            // Add files to directories
            dir1.addComponent(file1);
            dir1.addComponent(file2);

            dir2.addComponent(file3);
            dir2.addComponent(dir1);  // Add dir1 to dir2 (nested structure)

            // Display the file system
            dir2.display();

            // Get total size
            System.out.println("Total Size of dir2: " + dir2.getSize() + "KB");
        }
    }

}
