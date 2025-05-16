package designPatterns.structural;

/**
 * decouple an abstraction from its implementation so that the two can vary independently.
 *
 * Abstraction: The main interface or class clients interact with.
 * Refined Abstraction: Extends the abstraction to add more behavior.
 *
 * Implementor (Interface): Defines the interface for implementation classes.
 * ConcreteImplementor: Implements the implementor interface.
 *
 */
public class Bridge {
    // Abstraction
    public abstract class Shape {
        protected Renderer renderer;

        public Shape(Renderer renderer) {
            this.renderer = renderer;
        }

        public abstract void draw();
    }

    // Refined Abstraction (Circle)
    public class Circle extends Shape {
        public Circle(Renderer renderer) {
            super(renderer);
        }

        @Override
        public void draw() {
            renderer.renderCircle();
        }
    }

    // Refined Abstraction (Square)
    public class Square extends Shape {
        public Square(Renderer renderer) {
            super(renderer);
        }

        @Override
        public void draw() {
            renderer.renderSquare();
        }
    }

    // Implementor (Renderer)
    public interface Renderer {
        void renderCircle();
        void renderSquare();
    }

    // Concrete Implementor (WindowsRenderer)
    public class WindowsRenderer implements Renderer {
        @Override
        public void renderCircle() {
            System.out.println("Rendering circle on Windows");
        }

        @Override
        public void renderSquare() {
            System.out.println("Rendering square on Windows");
        }
    }

    // Concrete Implementor (MacRenderer)
    public class MacRenderer implements Renderer {
        @Override
        public void renderCircle() {
            System.out.println("Rendering circle on Mac");
        }

        @Override
        public void renderSquare() {
            System.out.println("Rendering square on Mac");
        }
    }

    //______ new code______________
   /* public class Triangle extends Shape {
        public Triangle(Renderer renderer) {
            super(renderer);
        }

        @Override
        public void draw() {
            renderer.renderTriangle();
        }
    }

    public interface Renderer {
        void renderCircle();
        void renderSquare();
        void renderTriangle();
    }

    // Concrete Implementor (WindowsRenderer)
    public class WindowsRenderer implements Renderer {
        @Override
        public void renderCircle() {
            System.out.println("Rendering circle on Windows");
        }

        @Override
        public void renderSquare() {
            System.out.println("Rendering square on Windows");
        }

        @Override
        public void renderTriangle() {
            System.out.println("Rendering triangle on Windows");
        }
    }

    // Concrete Implementor (MacRenderer)
    public class MacRenderer implements Renderer {
        @Override
        public void renderCircle() {
            System.out.println("Rendering circle on Mac");
        }

        @Override
        public void renderSquare() {
            System.out.println("Rendering square on Mac");
        }

        @Override
        public void renderTriangle() {
            System.out.println("Rendering triangle on Mac");
        }
    }
*/

}
