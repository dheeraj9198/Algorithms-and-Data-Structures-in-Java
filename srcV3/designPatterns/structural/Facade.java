package designPatterns.structural;

/**
 * Facade pattern hides the complexities of the system and provides an interface to the client using which the client can access the system.
 *
 */
public class Facade {
    class Amplifier {
        public void on() { System.out.println("Amplifier ON"); }
        public void setVolume(int level) { System.out.println("Volume set to " + level); }
    }

    class DVDPlayer {
        public void on() { System.out.println("DVD Player ON"); }
        public void play(String movie) { System.out.println("Playing movie: " + movie); }
    }

    class Projector {
        public void on() { System.out.println("Projector ON"); }
        public void wideScreenMode() { System.out.println("Projector in widescreen mode"); }
    }

    class HomeTheaterFacade {
        private Amplifier amp;
        private DVDPlayer dvd;
        private Projector projector;

        public HomeTheaterFacade(Amplifier amp, DVDPlayer dvd, Projector projector) {
            this.amp = amp;
            this.dvd = dvd;
            this.projector = projector;
        }

        public void watchMovie(String movie) {
            System.out.println("Get ready to watch a movie...");
            amp.on();
            amp.setVolume(5);
            projector.on();
            projector.wideScreenMode();
            dvd.on();
            dvd.play(movie);
        }
    }

}
