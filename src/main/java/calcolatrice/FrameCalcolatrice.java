package calcolatrice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FrameCalcolatrice extends JFrame {
    private String tmp;
    private String risTmp;
    private int sum;
    private boolean isReset = true;
    public FrameCalcolatrice(){
        JPanel panel = new JPanel(null);
        panel.setBackground(Color.gray);


        //TextField

        JTextArea numeri = new JTextArea();
        numeri.setLineWrap(true);
        numeri.setMargin(new Insets(10,10,10,10));
        numeri.setFont(new Font("SansSerif", Font.BOLD, 20));
        numeri.setEditable(false);

        JTextArea ris = new JTextArea();
        ris.setLineWrap(true);
        ris.setMargin(new Insets(10,10,10,10));
        ris.setFont(new Font("SansSerif", Font.BOLD, 20));
        ris.setEditable(false);

        //Bottoni
        Dimension dimBottoni = new Dimension(100,100);
        Font fontBottoni = new Font("SansSerif", Font.BOLD, 50);
        JButton somma = new JButton("+");
        somma.setSize(dimBottoni);
        somma.setFont(fontBottoni);
        somma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isReset){
                    numeri.setText("");
                    ris.setText("");
                    sum = 0;
                    risTmp = "";
                    isReset = true;
                }
                if (numeri.getText().equals("")) return;
                sum += Integer.parseInt(numeri.getText());
                numeri.setText("");
                risTmp = ris.getText();
                ris.setText(risTmp + "+");
            }
        });
        JButton uguale = new JButton("=");
        uguale.setSize(dimBottoni);
        uguale.setFont(fontBottoni);
        uguale.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (numeri.getText().equals("")) return;
                sum += Integer.parseInt(numeri.getText());
                numeri.setText("Il risultato è: " + sum);
                risTmp = ris.getText();
                ris.setText(risTmp + "=" + sum);
                isReset = false;
            }
        });

        JButton reset = new JButton("Reset");
        reset.setSize(dimBottoni);
        reset.setFont(new Font(fontBottoni.getFontName(), fontBottoni.getStyle(), 25));
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numeri.setText("");
                ris.setText("");
                sum = 0;
                risTmp = "";
                isReset = true;
            }
        });


        ArrayList<JButton> bottoni = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            JButton button = new JButton("" + i);
            button.setSize(dimBottoni.width + 25, dimBottoni.height + 25);
            button.setFont(fontBottoni);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    tmp = numeri.getText();
                    numeri.setText(tmp + button.getText());
                    risTmp = ris.getText();
                    ris.setText(risTmp + button.getText());
                }
            });
            bottoni.add(button);
            panel.add(bottoni.get(i-1));


        }

        panel.add(somma);
        panel.add(uguale);
        panel.add(numeri);
        panel.add(ris);
        panel.add(reset);


        Insets bordo = panel.getInsets();

        //Bottoni
        somma.setBounds(500,350, somma.getWidth(), somma.getHeight());
        uguale.setBounds(somma.getX(), somma.getY() + 100, uguale.getWidth(), uguale.getHeight());
        reset.setBounds(somma.getX(), somma.getY() - 100, somma.getWidth(), somma.getHeight());

        bottoni.get(0).setBounds(5, numeri.getY() + 125, bottoni.get(0).getWidth(), bottoni.get(0).getHeight());
        bottoni.get(1).setBounds(150 + bottoni.get(0).getX(), numeri.getY() + 125, bottoni.get(0).getWidth(), bottoni.get(0).getHeight());
        bottoni.get(2).setBounds(300 + bottoni.get(0).getX(), numeri.getY() + 125, bottoni.get(0).getWidth(), bottoni.get(0).getHeight());
        bottoni.get(3).setBounds(0 + bottoni.get(0).getX(), bottoni.get(0).getY() + 150, bottoni.get(0).getWidth(), bottoni.get(0).getHeight());
        bottoni.get(4).setBounds(150 + bottoni.get(0).getX(), bottoni.get(0).getY() + 150, bottoni.get(0).getWidth(), bottoni.get(0).getHeight());
        bottoni.get(5).setBounds(300 + bottoni.get(0).getX(), bottoni.get(0).getY() + 150, bottoni.get(0).getWidth(), bottoni.get(0).getHeight());
        bottoni.get(6).setBounds(0 + bottoni.get(0).getX(), bottoni.get(5).getY() + 150, bottoni.get(0).getWidth(), bottoni.get(0).getHeight());
        bottoni.get(7).setBounds(150 + bottoni.get(0).getX(), bottoni.get(5).getY() + 150, bottoni.get(0).getWidth(), bottoni.get(0).getHeight());
        bottoni.get(8).setBounds(300 + bottoni.get(0).getX(), bottoni.get(5).getY() + 150, bottoni.get(0).getWidth(), bottoni.get(0).getHeight());

        //TextField
        numeri.setBounds(0 + bordo.left,0 + bordo.top, 300, 100);
        ris.setBounds(300, 0, 300, 100);




        add(panel);
        setTitle("Test");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setSize(600,600);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
