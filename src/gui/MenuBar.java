package gui;

import elements.mode.GameModeFactoryMethod;
import elements.mode.GameMode;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class MenuBar extends JMenuBar {
    private final List<JRadioButtonMenuItem> radioButtonMenuItems;


    public MenuBar(ActionListener listener) {
        JMenu menu = new JMenu("game");

        JMenuItem newGameButton = new JMenuItem("New game", KeyEvent.VK_F2);
        newGameButton.addActionListener(listener);
        menu.add(newGameButton);

        menu.addSeparator();

        GameMode[] modesArray = GameModeFactoryMethod.getInstance().getAllModes();


        ////////////////Create radio button menu list////////////////////
        radioButtonMenuItems = new ArrayList<>();
        ButtonGroup gameModesButtons = new ButtonGroup();

        for (GameMode mode: modesArray) {
            JRadioButtonMenuItem button = new JRadioButtonMenuItem(mode.getName());
            radioButtonMenuItems.add(button);
            gameModesButtons.add(button);
            menu.add(button);
        }

        radioButtonMenuItems.get(0).setSelected(true);
        ///////////////////////////////////////////////////////

        JMenuItem exit = new JMenuItem("Exit");
        exit.addActionListener(listener);
        menu.addSeparator();
        menu.add(exit);

        add(menu);
    }

    public String getActiveGameMode() throws IOException{
        for (JRadioButtonMenuItem button: radioButtonMenuItems) {
            if (button.isSelected()) {
                return button.getText();
            }
        }
        throw new IOException("Error game mode name");
    }
}
