package designPatterns.structural;
import java.util.HashMap;

/**
 * Flyweight pattern is primarily used to reduce the number of objects created and to decrease memory footprint and increase performance.
 */
public class FlyWeight {
    interface Character {
        void display(int x, int y); // extrinsic state: x, y position
    }
    static class CharacterA implements Character {
        // intrinsic state
        private final char symbol = 'A';
        private final String font = "Arial";

        @Override
        public void display(int x, int y) {
            System.out.println("Character: " + symbol + " Font: " + font + " Position: (" + x + ", " + y + ")");
        }
    }

    static class CharacterFactory {
        private static final HashMap<java.lang.Character, Character> characters = new HashMap<>();

        public static Character getCharacter(char c) {
            if (!characters.containsKey(c)) {
                switch (c) {
                    case 'A':
                        characters.put('A', new CharacterA());
                        break;
                    // Add cases for other characters
                }
            }
            return characters.get(c);
        }
    }
    public class FlyweightPatternDemo {
        public static void main(String[] args) {
            Character charA1 = CharacterFactory.getCharacter('A');
            Character charA2 = CharacterFactory.getCharacter('A');

            // Different extrinsic state, same shared instance
            charA1.display(10, 20);
            charA2.display(50, 60);

            System.out.println("Same instance? " + (charA1 == charA2));
        }
    }

}
