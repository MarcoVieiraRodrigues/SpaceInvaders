package meujogo.Modelo;

import javax.swing.*;
import java.awt.*;

public class Shot {

    private Image image;
    private int x, y;
    private int height, width;
    private boolean isVisible;

    private static final int WIDTH = 938;
    private static int SPEED = 3;

    // construtor

    public Shot(int x, int y) {
        this.x = x;
        this.y = y;
        isVisible = true;
    }

    // Metodo Load

    public void load() {
        ImageIcon referencia = new ImageIcon("res//shot3_2.png");
        image = referencia.getImage();

        this.width = image.getWidth(null);
        this.height = image.getHeight(null);
    }

    // Definir para o tiro sumir quando atingir a largura maxima setada antes
    public void update() {
        this.x += SPEED;
        if (this.x > WIDTH) {
            isVisible = false;
        }
    }

    // Getters/ Setters

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public static int getSPEED() {
        return SPEED;
    }

    public void setVisible(boolean visible) {
        isVisible = visible;
    }

    public static void setSPEED(int SPEED) {
        Shot.SPEED = SPEED;
    }

    public Image getImage() {
        return image;
    }
}
