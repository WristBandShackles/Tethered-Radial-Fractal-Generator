import java.awt.Graphics;
import java.awt.Color;

public class Line implements FractalElement {
    private final double initialX;
    private final double initialY;
    private final double finalX;
    private final double finalY;
    private final Color color;

    public Line(double initialX, double initialY, double finalX, double finalY, Color color) {
        this.initialX = initialX;
        this.initialY = initialY;
        this.finalX = finalX;
        this.finalY = finalY;
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
        g.drawLine(drawAreaWidth/2 + (int)Math.round(initialX), drawAreaHeight/2  - (int)Math.round(initialY),
                   drawAreaWidth/2 + ((int)Math.round(finalX) * drawAreaWidth) / drawAreaWidth, drawAreaHeight/2  - ((int)Math.round(finalY) * drawAreaHeight) / drawAreaHeight);
    }
}
