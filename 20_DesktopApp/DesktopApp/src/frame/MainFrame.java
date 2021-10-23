package frame;

import frame.panels.ButtonPanel;
import frame.panels.FIOPanel;
import frame.panels.FullFIOPanel;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private FullFIOPanel fullFIO;
    private ButtonPanel buttonPanel;
    private FIOPanel fioPanel;

    public MainFrame() {
        setFrameConfigurations();
        addPanels();
        addNewActions();
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void setFrameConfigurations() {
        setSize(800, 600);
        setMinimumSize(new Dimension(365,250));
        setLayout(new GridBagLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void addPanels() {
        buttonPanel = new ButtonPanel();
        fioPanel = new FIOPanel(456, 90, 172, 287);
        fullFIO = new FullFIOPanel(220, 90, 295, 250);
        add(fullFIO, new GridBagConstraints(0, 0, 1, 1, 0, 0.9,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(10, 10, 10, 10),
                0, 0));
        add(buttonPanel, new GridBagConstraints(0, 1, 1, 1, 0, 0.9,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(10, 10, 10, 10),
                0, 0));
        add(fioPanel, new GridBagConstraints(0, 0, 1, 1, 0, 0.9,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(10, 10, 10, 10),
                0, 0));
    }

    private void addNewActions() {
        clearFullFIO();
        changeText();
        clearFIO();
    }

    private void changeText() {
        buttonPanel.getCollapseButton().changeAction(fullFIO, fioPanel);
    }

    private void clearFullFIO() {

        buttonPanel.getClearButton().clear(fullFIO.getPatronymic());
        buttonPanel.getClearButton().clear(fullFIO.getSurname());
        buttonPanel.getClearButton().clear(fullFIO.getNameInField());

    }

    private void clearFIO() {
        buttonPanel.getClearButton().clear(fioPanel.getFIO());
    }
}
