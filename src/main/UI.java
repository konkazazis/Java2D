package main;

import entity.Entity;
import object.OBJ_Heart;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class UI {

    GamePanel gp;
    Graphics2D g2;
    Font arial_40, arial_80B;
    Font purisaB;
    BufferedImage heart_full, heart_half, heart_blank;
    public boolean messageOn = false;
    public String message = "";
    int messageCounter = 0;
    public boolean gameFinished = false;
    public String currentDialogue = "";
    public int commandNum = 0;
    public int titleScreenState = 0;

    public UI(GamePanel gp) {
        this.gp = gp;
        //arial_40 = new Font("Arial" , Font.PLAIN, 40);
        //arial_80B = new Font("Arial" , Font.BOLD, 80);

        try {
            InputStream is = getClass().getResourceAsStream("/font/PurisaBold.ttf");
            purisaB = Font.createFont(Font.TRUETYPE_FONT, is);
        } catch (FontFormatException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //create hud object
        Entity heart = new OBJ_Heart(gp);
        heart_full = heart.image;
        heart_half = heart.image2;
        heart_blank = heart.image3;

    }

    public void showMessage(String text) {
        message = text;
        messageOn = true;
    }

    public void draw(Graphics2D g2) {

        this.g2 = g2;

        g2.setFont(purisaB);
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2.setColor(Color.white);

        //title state
        if (gp.gameState == gp.titleState) {
            drawTitleScreen();
        }

        //play state
        if (gp.gameState == gp.playState) {
            drawPlayerLife();
        }
        //pause state
        if (gp.gameState == gp.pauseState) {
            drawPauseScreen();
            drawPlayerLife();
        }
        //dialogue state
        if (gp.gameState == gp.dialogueState) {
            drawDialogueScreen();
            drawPlayerLife();

        }
        //character state
        if(gp.gameState == gp.characterState) {
            drawCharacterScreen();
        }

    }

    public void drawPlayerLife() {

        int x = gp.tileSize/2;
        int y = gp.tileSize/2;
        int i = 0;

        //draw max heart
        while (i < gp.player.maxLife / 2) {
            g2.drawImage(heart_blank, x, y, null);
            i++;

            x += gp.tileSize;
        }

        //reset
        x = gp.tileSize/2;
        y = gp.tileSize/2;
        i = 0;

        //draw current life
        while(i < gp.player.life) {
            g2.drawImage(heart_half, x, y, null);
            i ++;
            if (i < gp.player.life) {
                g2.drawImage(heart_full, x, y, null);
            }
            i++;
            x += gp.tileSize;
        }
    }

    public void drawTitleScreen() {

        if(titleScreenState == 0) {
            g2.setColor(new Color(70, 120, 80));
            g2.fillRect(0, 0 , gp.screenWidth, gp.screenHeight);

            //title name
            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 60F));
            String text = "Blue Boy Adventure";
            int x = getXforCenteredtext(text);
            int y = gp.tileSize*3;

            //shadow
            g2.setColor(Color.black);
            g2.drawString(text, x+5, y+5);

            g2.setColor(Color.white);
            g2.drawString(text, x, y);

            //blue boy image
            x = gp.screenWidth/2 - (gp.tileSize*2)/2;
            y += gp.tileSize*2;
            g2.drawImage(gp.player.down1, x, y, gp.tileSize*2, gp.tileSize*2, null);

            //menu
            g2.setFont(g2.getFont().deriveFont(Font.BOLD,38F));

            text = "NEW GAME";
            x = getXforCenteredtext(text);
            y += gp.tileSize*4;
            g2.drawString(text, x, y);
            if(commandNum == 0 ){
                g2.drawString(">", x-gp.tileSize, y);
            }

            text = "LOAD GAME";
            x = getXforCenteredtext(text);
            y += gp.tileSize;
            g2.drawString(text, x, y);
            if(commandNum == 1 ){
                g2.drawString(">", x-gp.tileSize, y);
            }

            text = "QUIT";
            x = getXforCenteredtext(text);
            y += gp.tileSize;
            g2.drawString(text, x, y);
            if(commandNum == 2 ){
                g2.drawString(">", x-gp.tileSize, y);
            }
        }
        else if (titleScreenState == 1) {

            //class selection screen
            g2.setColor(Color.white);
            g2.setFont(g2.getFont().deriveFont(42F));

            String text = "Select your class!";
            int x = getXforCenteredtext(text);
            int y = gp.tileSize*3;
            g2.drawString(text, x, y);

            text = "Fighter";
            x = getXforCenteredtext(text);
            y += gp.tileSize*3;
            g2.drawString(text, x, y);
            if (commandNum == 0) {
                g2.drawString(">", x-gp.tileSize, y);
            }

            text = "Thief";
            x = getXforCenteredtext(text);
            y += gp.tileSize;
            g2.drawString(text, x, y);
            if (commandNum == 1) {
                g2.drawString(">", x-gp.tileSize, y);
            }

            text = "Sorcerer";
            x = getXforCenteredtext(text);
            y += gp.tileSize;
            g2.drawString(text, x, y);
            if (commandNum == 2) {
                g2.drawString(">", x-gp.tileSize, y);
            }

            text = "Back";
            x = getXforCenteredtext(text);
            y += gp.tileSize*3;
            g2.drawString(text, x, y);
            if (commandNum == 3) {
                g2.drawString(">", x-gp.tileSize, y);
            }
        }

    }

    public void drawPauseScreen() {

        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 80F));
        String text = "PAUSED" ;
        int x = getXforCenteredtext(text);
        int y = gp.screenHeight/2;

        g2.drawString(text, x, y);
    }

    public void drawDialogueScreen() {

        //window
        int x = gp.tileSize * 2;
        int y = gp.tileSize / 2;
        int width = gp.screenWidth - (gp.tileSize * 4);
        int height = gp.tileSize * 4;
        drawSubWindow(x, y, width, height);

        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 20F));
        x += gp.tileSize;
        y += gp.tileSize;

        for(String line : currentDialogue.split("\n")) {
            g2.drawString(line,x ,y);
            y += 40;
        }

    }

    public void drawCharacterScreen() {
        // create a frame
        final int frameX = gp.tileSize*2;
        final int frameY = gp.tileSize;
        final int frameWidth = gp.tileSize*5;
        final int frameHeight = gp.tileSize*10;
        drawSubWindow(frameX, frameY, frameWidth, frameHeight);
    }

    public void drawSubWindow(int x, int y, int width, int height) {

        Color c = new Color(0,0,0, 210);
        g2.setColor(c);
        g2.fillRoundRect(x, y, width, height, 35, 35);

        c = new Color(255,255,255);
        g2.setColor(c);
        g2.setStroke(new BasicStroke(5));
        g2.drawRoundRect(x + 5, y + 5, width - 10, height - 10, 25, 25);
    }

    public int getXforCenteredtext(String text) {
        int length = (int)g2.getFontMetrics().getStringBounds(text,g2).getWidth();
        int x = gp.screenWidth/2 - length/2;
        return x;
    }
}
