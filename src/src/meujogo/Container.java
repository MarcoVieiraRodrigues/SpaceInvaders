package meujogo;

import meujogo.Modelo.Fase;

import javax.swing.*;

public class Container extends JFrame {

//    Criacao construtor

    public Container() {
//        colocando o background
        add(new Fase());
        setTitle("Jogo Final POO");
//        Definindo a dimensao da Tela
        setSize(1024, 728);
//        Fechar
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        Para aparecer a aplicao no meio da tela
        setLocationRelativeTo(null);
//        Para o Usuario nao poder mexer no tamanho da tela
        this.setResizable(false);
        setVisible(true);
    }

//    Metodos Principal
public static void main(String[] args) {
    new Container();
}


}
