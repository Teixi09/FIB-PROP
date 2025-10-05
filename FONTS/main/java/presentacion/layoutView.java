package presentacion;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class layoutView extends javax.swing.JFrame {

    private JPanel panel;
    private JButton[][] botones;
    private int n;

    public layoutView(int n, ArrayList<ArrayList<Character>> layout) {
        this.n = n;

        // Configuración de la ventana principal
        setTitle("layout");
        setSize(n*75, n*75);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);

        // Crear el panel y establecer el layout
        panel = new JPanel(new GridLayout(n, n));

        add(panel);

        // Crear la matriz de botones
        crearMatrizDeBotones(layout);
    }

    private void crearMatrizDeBotones(ArrayList<ArrayList<Character>> layout) {
        botones = new JButton[n][n];

        // Crear y añadir botones al panel
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                botones[i][j] = new JButton(String.valueOf(layout.get(i).get(j)));

                botones[i][j].setBackground(new java.awt.Color(204, 204, 255));
                botones[i][j].setFont(new java.awt.Font("NATS", 1, 18));
                botones[i][j].setFocusPainted(false);;
                panel.add(botones[i][j]);
            }
        }
    }


}
