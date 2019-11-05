package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

class MenuButtonsListener implements ActionListener {
    private final GuiGame guiGame;

    public MenuButtonsListener(GuiGame mainWindow) {
        this.guiGame = mainWindow;
    }

    @Override
    public void actionPerformed(ActionEvent e)  {
        try {
            switch (e.getActionCommand()) {
                case "New game":
                    guiGame.startGame();break;
                case "Exit": System.exit(0);
            }
        }catch (IOException exception) {
            exception.printStackTrace();
        }

    }

}
