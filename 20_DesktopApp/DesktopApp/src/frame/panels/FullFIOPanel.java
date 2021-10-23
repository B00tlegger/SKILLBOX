package frame.panels;

import javax.swing.*;
import java.awt.*;

public class FullFIOPanel extends JPanel {
    private JTextField surname;
    private JTextField name;
    private JTextField patronymic;

    public FullFIOPanel(int sizeWidth, int sizeHeight, int xLocation, int yLocation) {
        setPreferredSize(new Dimension(sizeWidth, sizeHeight));
        setLayout(new FlowLayout());
        addSurnameLine();
        addNameLine();
        addPatronymicLine();
        setVisible(true);
    }

    private void addSurnameLine(){
        JLabel jLabel = new JLabel("Фамилия:");
        jLabel.setPreferredSize(new Dimension(60, 25));
        add(jLabel);
        surname = new JTextField();
        surname.setPreferredSize(new Dimension(150, 25));
        add(surname);
    }
    private void addNameLine(){
        JLabel jLabel = new JLabel("        Имя:");
        jLabel.setPreferredSize(new Dimension(60, 25));
        add(jLabel);
        name = new JTextField();
        name.setPreferredSize(new Dimension(150, 25));
        add(name);
    }

    private void addPatronymicLine(){
        JLabel jLabel = new JLabel("Отчество:");
        jLabel.setPreferredSize(new Dimension(60, 25));
        add(jLabel);
        patronymic = new JTextField();
        patronymic.setPreferredSize(new Dimension(150, 25));
        add(patronymic);
    }

    public JTextField getSurname() {
        return surname;
    }

    public JTextField getNameInField() {
        return name;
    }

    public JTextField getPatronymic() {
        return patronymic;
    }
}
