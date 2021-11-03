package meujogo.Modelo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class Player {

    private int x, y;
    private int dx, dy;
    private Image image;
    private int width, height;
//    Tiro
    private List <Shot> shots;


//    construtor

    public Player() {
        this.x = 100;
        this.y = 100;
//X E Y EM 100 PARA DEFINIR AONDE E O SPAWN DO PLAYER

//        instanciar o tiro

        shots = new ArrayList<Shot>();
    }

    public void load() {
        ImageIcon referencia = new ImageIcon("res//Ship3.png");
        image = referencia.getImage();
        height = image.getHeight(null);
        width = image.getWidth(null);
    }

//    Mover o player

    public void update() {
        x += dx;
        y += dy;
    }
//Para o tiro aparecer no meio da nave
    public void simpleShot() {
        this.shots.add(new Shot(x+width, y + (height/3) ));
    }

    public void keyPressed(KeyEvent key) {
        int code = key.getKeyCode();

        if(code == KeyEvent.VK_F) {
            simpleShot();
        }


//        Movimentacao
        if(code == KeyEvent.VK_W) {
            dy=-3;
        }

        if(code == KeyEvent.VK_S) {
            dy=3;
        }

        if(code == KeyEvent.VK_A) {
            dx=-3;
        }

        if(code == KeyEvent.VK_D) {
            dx=3;
        }

        if(code == KeyEvent.VK_UP) {
            dy=-3;
        }

        if(code == KeyEvent.VK_DOWN) {
            dy=3;
        }

        if(code == KeyEvent.VK_LEFT) {
            dx=-3;
        }

        if(code == KeyEvent.VK_RIGHT) {
            dx=3;
        }
    }

//    Para funcionar so quando a tecla esta sendo apertada

    public void keyReleased(KeyEvent key) {
        int code = key.getKeyCode();

//        Movimentacao
        if(code == KeyEvent.VK_W) {
            dy=0;
        }

        if(code == KeyEvent.VK_S) {
            dy=0;
        }

        if(code == KeyEvent.VK_A) {
            dx=-0;
        }

        if(code == KeyEvent.VK_D) {
            dx=0;
        }

        if(code == KeyEvent.VK_UP) {
            dy=0;
        }

        if(code == KeyEvent.VK_DOWN) {
            dy=0;
        }

        if(code == KeyEvent.VK_LEFT) {
            dx=-0;
        }

        if(code == KeyEvent.VK_RIGHT) {
            dx=0;
        }
    }

//    Getters e Setters
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getImage() {
        return image;
    }

    public List<Shot> getShots() {
        return shots;
    }
}
