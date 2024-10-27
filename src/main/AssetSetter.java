package main;

import entity.NPC_OldMan;
import monster.MON_GreenSlime;
import object.*;
import tile_interactive.IT_DryTree;

public class AssetSetter {
    GamePanel gp;

    public AssetSetter(GamePanel gp) {
        this.gp = gp;
    }

    public void setObject() {
    	
    	
    	int mapNum = 0;
        int i =0;
        
        gp.obj[mapNum][i] = new OBJ_Axe(gp);
        gp.obj[mapNum][i].worldX = gp.tileSize*33;
        gp.obj[mapNum][i].worldY = gp.tileSize*21;
        i++;

    }

    public void setNPC() {
    	
    	int mapNum = 0;
    	
        gp.npc[mapNum][0] = new NPC_OldMan(gp);
        gp.npc[mapNum][0].worldX = gp.tileSize*21;
        gp.npc[mapNum][0].worldY = gp.tileSize*21;

    }

    public void setMonster() {
    	
    	int mapNum = 0;
        int i =0;
        gp.monster[mapNum][i] = new MON_GreenSlime(gp);
        gp.monster[mapNum][i].worldX = gp.tileSize*21;
        gp.monster[mapNum][i].worldY = gp.tileSize*38;

        i++;
        gp.monster[mapNum][i] = new MON_GreenSlime(gp);
        gp.monster[mapNum][i].worldX = gp.tileSize*23;
        gp.monster[mapNum][i].worldY = gp.tileSize*42;
        i++;
        gp.monster[mapNum][i] = new MON_GreenSlime(gp);
        gp.monster[mapNum][i].worldX = gp.tileSize*24;
        gp.monster[mapNum][i].worldY = gp.tileSize*37;
        i++;
        gp.monster[mapNum][i] = new MON_GreenSlime(gp);
        gp.monster[mapNum][i].worldX = gp.tileSize*34;
        gp.monster[mapNum][i].worldY = gp.tileSize*42;
        i++;
        gp.monster[mapNum][i] = new MON_GreenSlime(gp);
        gp.monster[mapNum][i].worldX = gp.tileSize*38;
        gp.monster[mapNum][i].worldY = gp.tileSize*42;
        i++;
    }

    public void setInteractiveTiles() {
    	int mapNum =0;
        int i = 0;

        gp.iTile[mapNum][i] = new IT_DryTree(gp,27,12);
        i++;
        gp.iTile[mapNum][i] = new IT_DryTree(gp,28,12);
        i++;
        gp.iTile[mapNum][i] = new IT_DryTree(gp,29,12);
        i++;
        gp.iTile[mapNum][i] = new IT_DryTree(gp,30,12);
        i++;
        gp.iTile[mapNum][i] = new IT_DryTree(gp,31,12);
        i++;
        gp.iTile[mapNum][i] = new IT_DryTree(gp,32,12);
        i++;
        gp.iTile[mapNum][i] = new IT_DryTree(gp,33 ,12);
        i++;
    }
}
