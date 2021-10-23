package frame.panels;

import frame.panels.buttons.ClearButton;
import frame.panels.buttons.ChangeTextButton;

import javax.swing.*;
import java.awt.*;

public class ButtonPanel extends JPanel {
    private ClearButton clearButton;
    private ChangeTextButton changeTextButton;


    public ButtonPanel() {
        setSize(220, 25);
        setLayout(new FlowLayout());
//        setLocation(290, 500);
        addButtons();
    }

    private void addButtons() {
        clearButton = new ClearButton("clear", 100, 25, 0, 0);
        changeTextButton = new ChangeTextButton("collapse", 100, 25, 120, 0);
        add(clearButton);
        add(changeTextButton);
    }

    public ClearButton getClearButton() {
        return clearButton;
    }

    public ChangeTextButton getCollapseButton() {
        return changeTextButton;
    }
}
