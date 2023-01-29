import java.awt.Color;
import java.util.ArrayList;

/**
 * Subject Interface in a Pull Observer model
 *
 * @author Christopher Long, written in IntelliJ
 * @version 2020-04-12
 */
public interface FractalSubject {

    /**
     * Attaches an observer to this Subject
     *
     * @param observer The observer that will be pulling data
     */
    void attach(FractalObserver observer);

    /**
     * Detaches an already attached observer
     *
     * @param observer The observer taht will be detached
     */
    void detach(FractalObserver observer);

    /**
     * Will notify all observers registered with this subject that data is ready to be pulled
     */
    void notifyObservers();

    /**
     * Will use currently stored attributes to generate data to be used by observers
     *
     * @return An ArrayList of FractalElements to be used by observer
     */
    ArrayList<FractalElement> getData();

    /**
     * Sets Subjects attributes to be used in generating data
     *
     * @param children The number of "spokes" on a fractal
     * @param depth The number of times it will repeat itself
     * @param ratio The ratio of children circles and lines to the parent circle
     * @param color The color to draw the FractalElements in
     * @param background The color of the background
     */
    void setData(int children, int depth, double ratio, Color color, Color background);
}
