package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Key extends Entity {
	
	GamePanel gp;

    public OBJ_Key(GamePanel gp) {
        super(gp);
        this.gp = gp;

        type = type_consumable;
        name = "Key";
        down1 = setup("/objects/key", gp.tileSize, gp.tileSize);
        description = "[" + name + "]\nIt opens a door";
        price = 100;
    }
    
    public void use(Entity entity) {
    	
    	gp.gameState = gp.dialogueState;
    	
    	int objIndex = getDetected(entity, gp.obj, "Door");
    }

}
