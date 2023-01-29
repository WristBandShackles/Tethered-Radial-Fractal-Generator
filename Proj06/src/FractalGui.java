import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FractalGui extends JFrame {

    private final FractalSubject subject;
    private final JPanel panel = new JPanel();
    private final JSlider childrenSlider = new JSlider();
    private final JSlider depthSlider = new JSlider();
    private final JSlider ratioSlider = new JSlider();
    private final JRadioButton backgroundBlack = new JRadioButton("Black");
    private Color drawColor = Color.cyan;
    private Color backgroundColor;

    public FractalGui(FractalSubject subject) {


        this.subject = subject;
        setTitle("Fractal Settings");
        setSize(500, 400);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Toolkit toolkit = getToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        setLocation(((screenSize.width - getWidth())/2)-250, (screenSize.height - getHeight())/2);

        getContentPane().add(panel);
        panel.setLayout(null);

        JLabel childrenLabel = new JLabel("Children");
        childrenLabel.setBounds(55, 20, 50, 15);
        panel.add(childrenLabel);
        childrenSlider.setBounds((getWidth() - 400)/2, 35, 400, 50);
        childrenSlider.setPaintTicks(true);
        childrenSlider.setSnapToTicks(true);
        childrenSlider.setPaintLabels(true);
        childrenSlider.setMajorTickSpacing(1);
        childrenSlider.setMaximum(13);
        childrenSlider.setMinimum(1);
        childrenSlider.setValue(4);
        childrenSlider.addChangeListener(new realTimeResponseSlider());
        panel.add(childrenSlider);

        JLabel depthLabel = new JLabel("Depth");
        depthLabel.setBounds(55, 95, 50, 15);
        panel.add(depthLabel);
        depthSlider.setBounds((getWidth() - 400)/2, 110, 400, 50);
        depthSlider.setPaintTicks(true);
        depthSlider.setSnapToTicks(true);
        depthSlider.setPaintLabels(true);
        depthSlider.setMajorTickSpacing(1);
        depthSlider.setMaximum(10);
        depthSlider.setMinimum(2);
        depthSlider.setValue(5);
        depthSlider.addChangeListener(new realTimeResponseSlider());
        panel.add(depthSlider);

        JLabel ratioLabel = new JLabel("Ratio");
        ratioLabel.setBounds(55, 170, 50, 15);
        panel.add(ratioLabel);
        ratioSlider.setBounds((getWidth() - 400)/2, 185, 400, 50);
        ratioSlider.setPaintTicks(true);
        ratioSlider.setSnapToTicks(true);
        ratioSlider.setPaintLabels(true);
        ratioSlider.setMajorTickSpacing(10);
        ratioSlider.setMinorTickSpacing(1);
        ratioSlider.setMaximum(70);
        ratioSlider.setMinimum(20);
        ratioSlider.setValue(48);
        ratioSlider.addChangeListener(new realTimeResponseSlider());
        panel.add(ratioSlider);

        JButton colors = new JButton("Colors");
        colors.setBounds(75, 265, 80, 30);
        colors.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawColor = JColorChooser.showDialog(panel, "Choose Color", Color.cyan);
                if (backgroundBlack.isSelected()) {
                    backgroundColor = Color.black;
                }
                else {
                    backgroundColor = Color.white;
                }
                subject.setData(childrenSlider.getValue(), depthSlider.getValue(), ratioSlider.getValue() * 0.01, drawColor, backgroundColor);
            }
        });
        panel.add(colors);

        JLabel backgroundLabel = new JLabel("Background Color");
        backgroundLabel.setBounds(230, 265, 120, 15);
        panel.add(backgroundLabel);
        backgroundBlack.setBounds(210, 280, 60, 20);
        backgroundBlack.setSelected(true);
        backgroundBlack.addActionListener(new realTimeResponseButton());
        JRadioButton backgroundWhite = new JRadioButton("White");
        backgroundWhite.setBounds(290, 280, 60, 20);
        backgroundWhite.addActionListener(new realTimeResponseButton());
        panel.add(backgroundBlack);
        panel.add(backgroundWhite);
        ButtonGroup backgroundGroup = new ButtonGroup();
        backgroundGroup.add(backgroundBlack);
        backgroundGroup.add(backgroundWhite);

        setVisible(true);

        if (backgroundBlack.isSelected()) {
            backgroundColor = Color.black;
        }
        else {
            backgroundColor = Color.white;
        }
        subject.setData(childrenSlider.getValue(), depthSlider.getValue(), ratioSlider.getValue() * 0.01, drawColor, backgroundColor);
    }

    private class realTimeResponseSlider implements ChangeListener {

        @Override
        public void stateChanged(ChangeEvent e) {
            if (backgroundBlack.isSelected()) {
                backgroundColor = Color.black;
            }
            else {
                backgroundColor = Color.white;
            }
            subject.setData(childrenSlider.getValue(), depthSlider.getValue(), ratioSlider.getValue() * 0.01, drawColor, backgroundColor);
        }
    }

    private class realTimeResponseButton implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (backgroundBlack.isSelected()) {
                backgroundColor = Color.black;
            }
            else {
                backgroundColor = Color.white;
            }
            subject.setData(childrenSlider.getValue(), depthSlider.getValue(), ratioSlider.getValue() * 0.01, drawColor, backgroundColor);
        }
    }
}
