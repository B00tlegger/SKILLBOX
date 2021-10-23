package frame.panels.buttons;

import frame.panels.buttons.Tester.StringTester;
import frame.panels.FIOPanel;
import frame.panels.FullFIOPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

public class ChangeTextButton extends JButton {

    public ChangeTextButton(String name, int sizeWidth, int sizeHeight, int xLocation, int yLocation) {
        setText(name);
        setPreferredSize(new Dimension(sizeWidth, sizeHeight));
    }


    public void changeAction(FullFIOPanel fullFIOPanel, FIOPanel fioPanel) {
        addActionListener(new Action() {
            @Override
            public Object getValue(String key) {
                return null;
            }

            @Override
            public void putValue(String key, Object value) {

            }

            @Override
            public void setEnabled(boolean b) {

            }

            @Override
            public boolean isEnabled() {
                return false;
            }

            @Override
            public void addPropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void removePropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void actionPerformed(ActionEvent e) {
                changeText(fullFIOPanel, fioPanel);
            }
        });
    }

    private void changeText(FullFIOPanel fullFIOPanel, FIOPanel fioPanel) {
        if (fullFIOPanel.isVisible()) {
            fullFIOTester(fullFIOPanel, fioPanel);
        } else if (fioPanel.isVisible()) {
            fioTester(fullFIOPanel, fioPanel);
        }
    }

    private void fullFIOTester(FullFIOPanel fullFIOPanel, FIOPanel fioPanel) {
        if (StringTester.testStrings(fullFIOPanel) != null) {
            fioPanel.getFIO().setText(StringTester.testStrings(fullFIOPanel));
            fullFIOPanel.setVisible(false);
            fioPanel.setVisible(true);
            setText("expand");
        } else {
            JOptionPane.showMessageDialog(fullFIOPanel, "Фамилия, имя, отчество введены не верно!", "ОШИБКА!", JOptionPane.PLAIN_MESSAGE);
        }
    }

    private void fioTester(FullFIOPanel fullFIOPanel, FIOPanel fioPanel) {
        if (StringTester.testString(fioPanel).size() > 1) {
            fullFIOPanel.getSurname().setText(StringTester.testString(fioPanel).get(0));
            fullFIOPanel.getNameInField().setText(StringTester.testString(fioPanel).get(1));
            if (StringTester.testString(fioPanel).size() > 2) {
                fullFIOPanel.getPatronymic().setText(StringTester.testString(fioPanel).get(2));
            } else {
                fullFIOPanel.getPatronymic().setText(null);
            }
            fioPanel.setVisible(false);
            fullFIOPanel.setVisible(true);
            setText("collapse");
        } else {
            JOptionPane.showMessageDialog(fioPanel,
                    "Ф.И.О. введены не верно! " +
                            "В строке должно быть не менее двух и не более трёх слов.\n" +
                            "Если в вашем имени, фамилии или отчестве больше одного слова, " +
                            "разделите их знаком подчёркивания \"_\"",
                    "ОШИБКА!", JOptionPane.PLAIN_MESSAGE);
        }
    }

}
