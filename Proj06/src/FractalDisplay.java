import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.*;
import java.util.ArrayList;

public class FractalDisplay extends JFrame implements FractalObserver{
    private final FractalSubject subject;
    private ArrayList<FractalElement> drawElements;
    private final JPanel gPanel = new GPanel();

    public FractalDisplay(FractalSubject subject) {
        this.subject = subject;
        this.subject.attach(this);

        setTitle("Fractal Display");
        setSize(600, 600);
        setResizable(true);

        Toolkit toolkit = getToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        setLocation(((screenSize.width - getWidth())/2) + 300, (screenSize.height - getHeight())/2);

        getContentPane().add(gPanel);
        gPanel.setLayout(null);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update() {
        drawElements = subject.getData();
        setVisible(true);
        gPanel.repaint();
    }

    private class GPanel extends JPanel {
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            for (FractalElement element : drawElements) {
                element.draw(g, getWidth(), getHeight());
            }
        }
    }
}
