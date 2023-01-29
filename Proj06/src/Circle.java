import java.awt.Graphics;
import java.awt.Color;

public class Circle implements FractalElement {
    private final double x;
    private final double y;
    private final double radius;
    private final Color color;

    public Circle(double x, double y, double radius, Color color) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.color = color;
    }

    /**
     * {@inheritDoc}
     * @param g Graphics reference used to draw
     * @param drawAreaWidth The width of the canvas
     * @param drawAreaHeight The height of the canvas
     */
    @Override
    public void draw(Graphics g, int drawAreaWidth, int drawAreaHeight) {
        g.setColor(color);
        g.drawOval(drawAreaWidth/2 + (int)Math.round(x) - (int)Math.round(radius),drawAreaHeight/2  - (int)Math.round(y)  - (int)Math.round(radius),
                   2 * (int)Math.round(radius), 2 * (int)Math.round(radius));
    }
}
