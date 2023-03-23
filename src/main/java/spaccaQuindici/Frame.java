package spaccaQuindici;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class Frame extends JFrame {
    private JButton bottoneTMP;
    private int valoreTmp;
    public Frame(){
        ArrayList<Integer> lista = new ArrayList<>();
        Random random = new Random();
        JPanel panel = new JPanel(new GridLayout(4, 4));
        valoreTmp = 0;
        //lista.add(0);

        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e){
            e.printStackTrace();
        }

        Font fontBot = new Font("Cambria", Font.PLAIN, 60);

        /*bottoneVuoto.setBackground(Color.BLACK);
        bottoneVuoto.setOpaque(true);
        bottoneVuoto.setBorderPainted(true);
        bottoneVuoto.setFont(fontBot);
        panel.add(bottoneVuoto);*/

        for (int i = 0; i < 16; i++){
            int num = random.nextInt(16);
            //num++;

            while (lista.contains(num)) {
                num = random.nextInt(16);
                //num++;
            }
            JButton button = new JButton("" + num);
            if (num == 0){

                button.setBackground(Color.BLACK);
                button.setOpaque(true);
                button.setBorderPainted(true);
                button.setFont(fontBot);
                bottoneTMP = button;
            } else if (num % 2 == 0){
                button.setBackground(new Color(224,224,224));
                button.setOpaque(true);
                button.setBorderPainted(true);
            } else {
                button.setBackground(new Color(0x1a8cff));
                button.setOpaque(true);
                button.setBorderPainted(true);
            }

            button.setForeground(new Color(0x000000));
            button.setFont(fontBot);
            System.out.println("OOOOOOOOOO: " + lista);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    boolean a  = getCol(lista.indexOf(Integer.parseInt(button.getText())), lista.indexOf(0));
                    if (!a) return;

                    if (button.getText().equals("0")) return;

                    int tmp = lista.indexOf(Integer.parseInt(button.getText()));
                    lista.set(lista.indexOf(0), Integer.parseInt(button.getText()));
                    lista.set(tmp, 0);
                    valoreTmp = Integer.parseInt(button.getText());
                    System.out.println("======: " + lista);
                    bottoneTMP.setText("" + valoreTmp);
                    if (valoreTmp % 2 == 0){
                        bottoneTMP.setBackground(new Color(224,224,224));
                        bottoneTMP.setOpaque(true);
                        bottoneTMP.setBorderPainted(true);
                    } else {
                        bottoneTMP.setBackground(new Color(0x1a8cff));
                        bottoneTMP.setOpaque(true);
                        bottoneTMP.setBorderPainted(true);
                    }
                    button.setBackground(Color.black);
                    button.setText("0");

                    valoreTmp = Integer.parseInt(button.getText());
                    bottoneTMP = button;
                }
            });

            lista.add(num);
            panel.add(button);
        }

        add(panel);
        setSize(600,600);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public boolean getCol(int value, int zero){
        int numZero = zero;
        int valore = value;

        System.out.println(zero);

        if (valore - 4 == numZero){
            System.out.println("ci sono");
        } else if ((numZero != 3 && numZero != 7 && numZero != 11) && valore - 1 == numZero){
            System.out.println("Ci sono");
        } else if (numZero %4 != 0 && valore + 1 == numZero) {
            System.out.println("Ci sono");
        } else if (valore + 4 == numZero) {
            System.out.println("Ci sono");
        } else {
            System.out.println("non ci sono");
            return false;
        }
        return true;
    }

    public void aggiorna(int indiceZero, int indiceValore){

    }
}
