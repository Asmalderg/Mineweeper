package gui;

import javax.swing.*;

class EndGamePanel extends JOptionPane{
    private final JFrame frame;

    public EndGamePanel(JFrame frame) {
        this.frame = frame;
    }

    public void showWinMessage() {
        showMessageDialog(frame, "Congratulations! You win!");
    }

    public void showLoseMessage() {
        showMessageDialog(frame, "You lose:(", "Game over!", JOptionPane.ERROR_MESSAGE);
    }
}
