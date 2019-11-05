import elements.mode.BeginnerMode;
import gameHandlers.gameEvents.GameEventHandler;
import game.MinerGame;
import game.SimpleMinerGame;
import view.CellViewer;

import java.util.Scanner;

class ConsoleGame {
        public static void main(String[] args) {
            GameEventHandler handler = new GameEventHandler();
            MinerGame minerGame = new SimpleMinerGame(handler);
            minerGame.startNewGame(BeginnerMode.getInstance());

            //////TODO DELETE
            CellViewer viewer = CellViewer.getInstance();

            Scanner scanner = new Scanner(System.in);

            while (!handler.isGameEnded()) {
                ////////TODO DELETE
                for (int i = 0; i < minerGame.getPlayGround().getHeight(); i++) {
                    for (int j = 0; j < minerGame.getPlayGround().getWidth(); j++) {
                        System.out.print(viewer.GetTrueCell(minerGame.getPlayGround().getCell(j, i)) + " ");
                    }
                    System.out.println();
                }
                System.out.println("/////////////////////////");

                for (int i = 0; i < minerGame.getPlayGround().getHeight(); i++) {
                    for (int j = 0; j < minerGame.getPlayGround().getWidth(); j++) {
                        System.out.print(viewer.GetCellView(minerGame.getPlayGround().getCell(j, i)) + " ");
                    }
                    System.out.println();
                }
                System.out.println("Enter X and Y");
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                minerGame.digCell(x, y);
                ///TODO END HERE
            }
            System.out.println(handler.getStatus());
        }
}
