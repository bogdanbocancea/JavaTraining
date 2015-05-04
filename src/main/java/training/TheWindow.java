package training;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class TheWindow extends JFrame implements WindowInterface
{
    private JSlider slider;
    private DrawOval oval;
    private DrawRectangle rectangle;
    private DrawArc arc;

    public void generateOval()
    {
        oval = new DrawOval();
        oval.setBackground(Color.BLUE);

        slider = new JSlider(SwingConstants.HORIZONTAL, 0, 200, 10);
        slider.setMajorTickSpacing(10);
        slider.setPaintTicks(true);

        slider.addChangeListener(new ChangeListener()
        {
            public void stateChanged(ChangeEvent e)
            {
                oval.setD(slider.getValue());
            }
        });
        add(slider, BorderLayout.SOUTH);
        add(oval, BorderLayout.CENTER);
    }

    public void generateRectangle()
    {
        rectangle = new DrawRectangle();
        rectangle.setBackground(Color.BLUE);

        slider = new JSlider(SwingConstants.HORIZONTAL, 0, 200, 10);
        slider.setMajorTickSpacing(10);
        slider.setPaintTicks(true);

        slider.addChangeListener(new ChangeListener()
        {
            public void stateChanged(ChangeEvent e)
            {
                rectangle.setD(slider.getValue());
            }
        });
        add(slider, BorderLayout.SOUTH);
        add(rectangle, BorderLayout.CENTER);
    }

    public void generateArc()
    {
        arc = new DrawArc();
        arc.setBackground(Color.BLUE);

        slider = new JSlider(SwingConstants.HORIZONTAL, 0, 200, 10);
        slider.setMajorTickSpacing(10);
        slider.setPaintTicks(true);

        slider.addChangeListener(new ChangeListener()
        {
            public void stateChanged(ChangeEvent e)
            {
                arc.setD(slider.getValue());
            }
        });
        add(slider, BorderLayout.SOUTH);
        add(arc, BorderLayout.CENTER);
    }

    public static void main(String[] args)
    {
        TheWindow w = new TheWindow();
        // w.generateRectangle();
         w.generateOval();
        //w.generateArc();

        w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        w.setSize(300, 400);
        w.setVisible(true);
    }
}
