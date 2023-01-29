/**
 * Observer Interface in a Pull Observer model
 *
 * @author Christopher Long, written in IntelliJ
 * @version 2020-04-12
 */
public interface FractalObserver {

    /**
     * Pulls data from the Subject
     */
    void update();
}
