package object;

import main.GamePanel;

import javax.imageio.ImageIO;

public class OBJ_Heart extends SuperObject{
    GamePanel gp;

    public OBJ_Heart(GamePanel gp) {

        this.gp = gp;

        name = "Heart";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/heart_full.png"));
            uTool.scaleImage(image, gp.tileSize, gp.tileSize);

            image2 = ImageIO.read(getClass().getResourceAsStream("/objects/heart_half.png"));
            uTool.scaleImage(image, gp.tileSize, gp.tileSize);

            image3 = ImageIO.read(getClass().getResourceAsStream("/objects/heart_blank.png"));
            image = uTool.scaleImage(image, gp.tileSize, gp.tileSize);
            image2 = uTool.scaleImage(image2, gp.tileSize, gp.tileSize);
            image3 = uTool.scaleImage(image3, gp.tileSize, gp.tileSize);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
