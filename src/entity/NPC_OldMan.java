package entity;

import main.GamePanel;

import java.util.Random;

public class NPC_OldMan  extends Entity{

    public NPC_OldMan(GamePanel gp) {
        super(gp);
        direction = "down";
        speed = 1;

        getImage();
        setDialogue();
    }

    public void getImage() {
        up1 = setup("/npc/oldman_up_1", gp.tileSize, gp.tileSize);
        up2 = setup("/npc/oldman_up_2", gp.tileSize, gp.tileSize);
        down1 = setup("/npc/oldman_down_1",gp.tileSize, gp.tileSize);
        down2 = setup("/npc/oldman_down_2",gp.tileSize, gp.tileSize);
        left1 = setup("/npc/oldman_left_1",gp.tileSize, gp.tileSize);
        left2 = setup("/npc/oldman_left_2",gp.tileSize, gp.tileSize);
        right1 = setup("/npc/oldman_right_1",gp.tileSize, gp.tileSize);
        right2 = setup("/npc/oldman_right_2",gp.tileSize, gp.tileSize);
    }

    public void setDialogue() {
        dialogues[0][0] = "Hello, lad.";
        dialogues[0][1] = "So you've come to this island to \nfind the treasure?";
        dialogues[0][2] = "I used to be a great wizard but now... \nI'm a bit too old for taking an adventure.";
        dialogues[0][3] = "Well, good luck on you.";
        
        dialogues[1][0] = "If you are tired, rest at the water.";
        dialogues[1][1] = "However, the monsters reappear if you sleep...";
        dialogues[1][2] = "In any case, dont push yourself too hard.";
        
        dialogues[2][0] = "I wonder how to open that door...";
    }

    public void setAction() {
    	
    	if(onPath == true) {
    		
//    		int goalCol = 12;
//    		int goalRow = 9;
    		
    		int goalCol = (gp.player.worldX + gp.player.solidArea.x)/gp.tileSize;
    		int goalRow = (gp.player.worldY + gp.player.solidArea.y)/gp.tileSize;
    		
    		searchPath(goalCol, goalRow);
    	}
    	else {
    		
    		actionLockCounter++;

            //Running on 60fps means he will not change direction
            //for 2 seconds. (120/60=2)
            if (actionLockCounter == 120) {
                Random random = new Random();
                int i = random.nextInt(100) + 1;

                if (i <= 25) {
                    direction = "up";
                }
                if (i > 25 && i <= 50) {
                    direction = "down";
                }
                if (i > 50 && i <= 75) {
                    direction = "left";
                }
                if (i > 75 && i <= 100) {
                    direction = "right";
                }

                actionLockCounter = 0;
            }

    	}
        
    }

    public void speak() {
        super.speak();
        
        onPath = true;
    }

}
