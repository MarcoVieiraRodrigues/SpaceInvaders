package meujogo.Modelo;

import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Fase extends JPanel implements ActionListener {

    private Image fundo;
    private Player player;
    private Timer timer;


//    Criando construtor

    public Fase() {
//        Melhora a resposta do teclado
        setFocusable(true);
        setDoubleBuffered(true);
//        Adicionando fundo
        ImageIcon referencia = new ImageIcon("res//background.jpg");
        fundo = referencia.getImage();

//        Adicionando um player

        player = new Player();
        player.load();

//        Instanciando o teclado
        addKeyListener(new KeyAdapter1());

//        timer

        timer = new Timer(5, this);
        timer.start();
    }

//    para colocar o background na tela
    public void paint(Graphics g) {
        Graphics2D graficos = (Graphics2D) g;
        graficos.drawImage(fundo, 0,0,null);
        graficos.drawImage(player.getImage(), player.getX(), player.getY(), this);

//        Para colocar os tiros na tela
        List <Shot> shots = player.getShots();
        for(int i = 0; i < shots.size(); i++) {
            Shot m = shots.get(i);
            m.load();
            graficos.drawImage(m.getImage(), m.getX(), m.getY(), this);
            }



        g.dispose();
    }


//    Atualizar a tela
    @Override
    public void actionPerformed(ActionEvent e) {
        player.update();
//        Caso o tiro estiver na largura da tela atualizala, caso nao remover o tiro
        List<Shot> shots = player.getShots();
        for(int i = 0; i < shots.size(); i++) {
            Shot m = shots.get(i);
            if (m.isVisible()) {
                m.update();
            } else {
                shots.remove(i);
            }
        }

        repaint();
    }

//    keyboard



    private class KeyAdapter1 extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            player.keyPressed(e);
        }


        public void keyReleased(KeyEvent e) {
            player.keyReleased(e);
        }
    }


}
