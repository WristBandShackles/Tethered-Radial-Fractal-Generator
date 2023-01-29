import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class FractalCalc implements  FractalSubject{
    private final ArrayList<FractalObserver> observers = new ArrayList<>();
    private int children;
    private int depth;
    private double ratio;
    private Color color;
    private Color background;
    private final static double twoPI = 2 * Math.PI;
    private final static double piOverTwo = Math.PI / 2;

    public FractalCalc(){}

    /**
     * {@inheritDoc}
     * @param observer The observer that will be pulling data
     */
    @Override
    public void attach(FractalObserver observer) {
        observers.add(observer);
    }

    /**
     * {@inheritDoc}
     * @param observer The observer that will be detached
     */
    @Override
    public void detach(FractalObserver observer) {
        observers.remove(observer);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void notifyObservers() {
        for (FractalObserver observer : observers) {
            observer.update();
        }
    }

    /**
     * {@inheritDoc}
     * @return An ArrayList of FractalElements to be used by observer
     */
    @Override
    public ArrayList<FractalElement> getData() {
        ArrayList<FractalElement> drawElements = new ArrayList<>();
        drawElements.add(new FractalElement() {
            @Override
            public void draw(Graphics g, int drawAreaWidth, int drawAreaHeight) {
                g.setColor(background);
                g.fillRect(0, 0, drawAreaWidth, drawAreaHeight);
            }
        });
        drawElements.addAll(getData(depth, 0, 0, 50));
        return drawElements;
    }

    private ArrayList<FractalElement> getData(double depth, double originX, double originY, double radius) {
        ArrayList<FractalElement> drawElements = new ArrayList<>();
        drawElements.add(new Circle(originX, originY, radius, color));
        if (depth!=0 && radius > 2) {
            depth--;
            for (double theta = twoPI / children, multi = 0; multi * theta < twoPI; multi++) {
            drawElements.add(new Line(originX + (radius * Math.cos(multi * theta + piOverTwo)),
                                  originY + (radius * Math.sin(multi * theta + piOverTwo)),
                                   originX + ((radius - (radius * ratio) + radius) * Math.cos(multi * theta + piOverTwo)),
                                   originY + ((radius - (radius * ratio) + radius) * Math.sin(multi * theta + piOverTwo)),
                                         color));
            drawElements.addAll(getData(depth,
                             originX + (2 * radius * Math.cos(multi * theta + piOverTwo)),
                             originY + (2 * radius * Math.sin(multi * theta + piOverTwo)),
                              radius * ratio));
            }
        }
        return drawElements;
    }

    /**
     * {@inheritDoc}
     * @param children The number of "spokes" on a fractal
     * @param depth The number of times it will repeat itself
     * @param ratio The ratio of children circles and lines to the parent circle
     * @param color The color to draw the FractalElements in
     * @param background The color of the background
     */
    public void setData(int children, int depth, double ratio, Color color, Color background) {
        this.children = children;
        this.depth = depth;
        this.ratio = ratio;
        this.color = color;
        this.background = background;
        notifyObservers();
    }
}
