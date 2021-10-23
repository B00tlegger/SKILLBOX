package frame.panels;

import javax.swing.*;
import java.awt.*;

public class FIOPanel extends JPanel {

    private JTextField fio;

    public FIOPanel(int sizeWidth, int sizeHeight, int xLocation, int yLocation) {
        setSize(sizeWidth, sizeHeight);
        setLayout(new FlowLayout());
        setVisible(false);
        addFIOLine();
    }

    private void addFIOLine(){
        JLabel jLabel = new JLabel("Ф.И.О.:");
        jLabel.setPreferredSize(new Dimension(60, 25));
        add(jLabel);
        fio = new JTextField();
        fio.setPreferredSize(new Dimension(250, 25));
        add(fio);
    }

    public JTextField getFIO() {
        return fio;
    }
}
