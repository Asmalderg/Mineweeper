package res;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class IconGetter {

    private IconGetter() {
    }

    public static Image getIcon(String iconName) throws IOException{
        String resName;
        switch (iconName) {
            case "1": resName = "01.png"; break;
            case "2": resName = "02.png"; break;
            case "3": resName = "03.png"; break;
            case "4": resName = "04.png"; break;
            case "5": resName = "05.png"; break;
            case "6": resName = "06.png"; break;
            case "7": resName = "07.png"; break;
            case "8": resName = "08.png"; break;
            case "mine": resName = "AppIco.png";break;
            case "flag": resName = "Flag.png"; break;
            case "X": resName = "mine.png"; break;
            case "DX": resName = "detonatedMine.png"; break;
            default: throw new IOException("Invalid icon");
        }
        return ImageIO.read(IconGetter.class.getResourceAsStream(resName));
    }

}
