package presentacion;

import javax.swing.*;
import java.util.ArrayList;

public class crearTecladoView extends javax.swing.JFrame {

    private controladorPresentacion cp;
    private ArrayList<String> textos;
    private ArrayList<String> listas;
    private javax.swing.JRadioButton BBRadioButton;
    private javax.swing.JRadioButton SARadioButton;
    private javax.swing.JButton acceptButton;
    private javax.swing.JComboBox<String> alfabetoComboBox;
    private javax.swing.JPanel background;
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel infoLabel;
    private javax.swing.JLabel infoLabel2;
    private javax.swing.JRadioButton listaRadioButton;
    private javax.swing.JTextField nombreTecladoTextField;
    private javax.swing.JComboBox<String> textOrListComboBox;
    private javax.swing.JLabel textOrListLabel;
    private javax.swing.JRadioButton textoRadioButton;
    private ButtonGroup grupoListaTexto;
    private ButtonGroup grupoAlgoritmos;
    /**
     * Creates new form crearTecladoView
     */
    public crearTecladoView(controladorPresentacion cp, ArrayList<String> alfabetos, ArrayList<String> textos, ArrayList<String> listas) {
        this.cp = cp;
        this.textos = textos;
        this.listas = listas;
        initComponents();
        //cargamos los alfabetos
        DefaultComboBoxModel<String> modelAlfabetos = new DefaultComboBoxModel<>();
        modelAlfabetos.addElement("-- Selecciona un alfabeto --");
        for (String nombreAlfabeto : alfabetos) {
            modelAlfabetos.addElement(nombreAlfabeto);
        }
        alfabetoComboBox.setModel(modelAlfabetos);
        //cargamos los textos inicialmente
        textoRadioButton.doClick();
        SARadioButton.doClick();
    }

    private void initComponents() {

        grupoListaTexto = new javax.swing.ButtonGroup();
        grupoAlgoritmos = new javax.swing.ButtonGroup();
        background = new javax.swing.JPanel();
        infoLabel = new javax.swing.JLabel();
        nombreTecladoTextField = new javax.swing.JTextField();
        textoRadioButton = new javax.swing.JRadioButton();
        listaRadioButton = new javax.swing.JRadioButton();
        alfabetoComboBox = new javax.swing.JComboBox<>();
        infoLabel2 = new javax.swing.JLabel();
        textOrListLabel = new javax.swing.JLabel();
        textOrListComboBox = new javax.swing.JComboBox<>();
        acceptButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        BBRadioButton = new javax.swing.JRadioButton();
        SARadioButton = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        background.setBackground(new java.awt.Color(153, 153, 255));

        infoLabel.setText("Nombre:");

        textoRadioButton.setBackground(new java.awt.Color(153, 153, 255));
        grupoListaTexto.add(textoRadioButton);
        textoRadioButton.setText("Texto");
        textoRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoRadioButtonActionPerformed(evt);
            }
        });

        listaRadioButton.setBackground(new java.awt.Color(153, 153, 255));
        grupoListaTexto.add(listaRadioButton);
        listaRadioButton.setText("Lista de palabras");
        listaRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listaRadioButtonActionPerformed(evt);
            }
        });

        alfabetoComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Selecciona un alfabeto --" }));

        infoLabel2.setText("Alfabeto:");

        textOrListLabel.setText("TextOrList:");

        textOrListComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Selecciona un texto o una lista --" }));

        acceptButton.setText("Aceptar");
        acceptButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acceptButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancelar");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        BBRadioButton.setBackground(new java.awt.Color(153, 153, 255));
        grupoAlgoritmos.add(BBRadioButton);
        BBRadioButton.setText("BB");

        SARadioButton.setBackground(new java.awt.Color(153, 153, 255));
        grupoAlgoritmos.add(SARadioButton);
        SARadioButton.setText("SA");

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
                backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(backgroundLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(backgroundLayout.createSequentialGroup()
                                                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(infoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(infoLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                                                        .addComponent(textOrListLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                                                .addGap(7, 7, 7)
                                                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(alfabetoComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(nombreTecladoTextField)
                                                        .addComponent(textOrListComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGroup(backgroundLayout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(SARadioButton, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                                                        .addComponent(BBRadioButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(50, 50, 50)
                                                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundLayout.createSequentialGroup()
                                                                .addComponent(textoRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(listaRadioButton))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundLayout.createSequentialGroup()
                                                                .addComponent(cancelButton)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(acceptButton)))))
                                .addContainerGap())
        );
        backgroundLayout.setVerticalGroup(
                backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(backgroundLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(infoLabel)
                                        .addComponent(nombreTecladoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(alfabetoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(infoLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(textOrListLabel)
                                        .addComponent(textOrListComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(listaRadioButton)
                                        .addComponent(textoRadioButton)
                                        .addComponent(BBRadioButton))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(acceptButton)
                                        .addComponent(cancelButton)
                                        .addComponent(SARadioButton))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }

    private void textoRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {
        textOrListLabel.setText("Texto:");
        DefaultComboBoxModel<String> modelTextos = new DefaultComboBoxModel<>();
        modelTextos.addElement("-- Selecciona un texto --");
        for (String nombretexto : textos) {
            modelTextos.addElement(nombretexto);
        }
        textOrListComboBox.setModel(modelTextos);
    }

    private void listaRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {
        textOrListLabel.setText("Lista:");
        DefaultComboBoxModel<String> modelListas = new DefaultComboBoxModel<>();
        modelListas.addElement("-- Selecciona una lista --");
        for (String nombreLista : listas) {
            modelListas.addElement(nombreLista);
        }
        textOrListComboBox.setModel(modelListas);
    }

    private void acceptButtonActionPerformed(java.awt.event.ActionEvent evt) {
        //comprobamos el algoritmo que quieren usar
        int type;
        if (BBRadioButton.isSelected()) type = 0;
        else type = 1;
        //conseguimos los parametros necesarios para crear el teclado
        String nombreTeclado, nombreAlfabeto;
        nombreTeclado = nombreTecladoTextField.getText();
        nombreAlfabeto = alfabetoComboBox.getSelectedItem().toString();
        //comprobamos le objeto con el que quieren crear el teclado
        if (textoRadioButton.isSelected() && textOrListComboBox.getSelectedIndex() > 0) {
            String nombreTexto = textOrListComboBox.getSelectedItem().toString();
            cp.crearTecladoTexto(nombreTeclado, type, nombreAlfabeto, nombreTexto);
            this.setVisible(false);
        }
        else if (textOrListComboBox.getSelectedIndex() > 0) {
            String nombreLista = textOrListComboBox.getSelectedItem().toString();
            cp.crearTecladoLista(nombreTeclado, type, nombreAlfabeto, nombreLista);
            this.setVisible(false);
        }
    }

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
    }
}


