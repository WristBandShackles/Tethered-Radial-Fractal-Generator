import java.awt.Graphics;

/**
 * Interface for elements of various shapes to be drawn
 *
 * @author Christopher Long, written in IntelliJ
 * @version 2020-04-12
 */
public interface FractalElement {

    /**
     * Uses a graphics reference to draw various shapes within the width and height specified
     *
     * @param g Graphics reference used to draw
     * @param drawAreaWidth The width of the canvas
     * @param drawAreaHeight The height of the canvas
     */
    void draw(Graphics g, int drawAreaWidth, int drawAreaHeight);
}
