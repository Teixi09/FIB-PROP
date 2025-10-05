package presentacion;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.util.HashMap;
import java.util.Objects;

public class crearListaView extends javax.swing.JFrame {

    private controladorPresentacion cp;
    private javax.swing.JButton acceptButon;
    private javax.swing.JButton addRowButton;
    private javax.swing.JButton backButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton deleteRowButton;
    private javax.swing.JLabel infoLabel;
    private javax.swing.JLabel infoLabel2;
    private javax.swing.JLabel infoLabel3;
    private javax.swing.JScrollPane listaScrollPanel;
    private javax.swing.JTable listaTable;
    private javax.swing.JButton nextButton;
    private javax.swing.JTextField nombreTextField;
    private javax.swing.JPanel sizeSelectionPanel;
    private javax.swing.JTextField sizeTextField;
    private javax.swing.JPanel wordInsertionPanel;
    /**
     * Creates new form crearListaView
     */
    public crearListaView(controladorPresentacion cp) {
        this.cp = cp;
        initComponents();
    }

    private void initComponents() {

        sizeSelectionPanel = new javax.swing.JPanel();
        infoLabel3 = new javax.swing.JLabel();
        sizeTextField = new javax.swing.JTextField();
        nextButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        wordInsertionPanel = new javax.swing.JPanel();
        infoLabel = new javax.swing.JLabel();
        nombreTextField = new javax.swing.JTextField();
        listaScrollPanel = new javax.swing.JScrollPane();
        listaTable = new javax.swing.JTable();
        infoLabel2 = new javax.swing.JLabel();
        acceptButon = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        deleteRowButton = new javax.swing.JButton();
        addRowButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(335, 305));
        setMinimumSize(new java.awt.Dimension(335, 305));
        setPreferredSize(new java.awt.Dimension(335, 305));
        setResizable(false);
        getContentPane().setLayout(new java.awt.CardLayout());

        sizeSelectionPanel.setBackground(new java.awt.Color(153, 153, 255));

        infoLabel3.setText("Size de la lista:");

        nextButton.setText("Siguiente");
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });

        backButton.setText("Cancelar");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout sizeSelectionPanelLayout = new javax.swing.GroupLayout(sizeSelectionPanel);
        sizeSelectionPanel.setLayout(sizeSelectionPanelLayout);
        sizeSelectionPanelLayout.setHorizontalGroup(
                sizeSelectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(sizeSelectionPanelLayout.createSequentialGroup()
                                .addContainerGap(163, Short.MAX_VALUE)
                                .addComponent(backButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(nextButton)
                                .addContainerGap())
                        .addGroup(sizeSelectionPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(infoLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sizeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        sizeSelectionPanelLayout.setVerticalGroup(
                sizeSelectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(sizeSelectionPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(sizeSelectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(infoLabel3)
                                        .addComponent(sizeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 242, Short.MAX_VALUE)
                                .addGroup(sizeSelectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(nextButton)
                                        .addComponent(backButton))
                                .addContainerGap())
        );

        getContentPane().add(sizeSelectionPanel, "card3");

        wordInsertionPanel.setBackground(new java.awt.Color(153, 153, 255));

        infoLabel.setText("Nombre:");

        listaTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null}
                },
                new String [] {
                        "Palabra", "Frecuencia"
                }
        ) {
            Class[] types = new Class [] {
                    java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        listaTable.setColumnSelectionAllowed(true);
        listaTable.getTableHeader().setReorderingAllowed(false);
        listaScrollPanel.setViewportView(listaTable);
        listaTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        infoLabel2.setText("Lista:");

        acceptButon.setText("Acceptar");
        acceptButon.setMaximumSize(new java.awt.Dimension(83, 22));
        acceptButon.setMinimumSize(new java.awt.Dimension(83, 22));
        acceptButon.setPreferredSize(new java.awt.Dimension(83, 22));
        acceptButon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acceptButonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancelar");
        cancelButton.setMaximumSize(new java.awt.Dimension(83, 22));
        cancelButton.setMinimumSize(new java.awt.Dimension(83, 22));
        cancelButton.setPreferredSize(new java.awt.Dimension(83, 22));
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        deleteRowButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        deleteRowButton.setText("-");
        deleteRowButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteRowButtonActionPerformed(evt);
            }
        });

        addRowButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        addRowButton.setText("+");
        addRowButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addRowButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout wordInsertionPanelLayout = new javax.swing.GroupLayout(wordInsertionPanel);
        wordInsertionPanel.setLayout(wordInsertionPanelLayout);
        wordInsertionPanelLayout.setHorizontalGroup(
                wordInsertionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(wordInsertionPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(wordInsertionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(infoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                                        .addComponent(infoLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(deleteRowButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(addRowButton, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(wordInsertionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, wordInsertionPanelLayout.createSequentialGroup()
                                                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(acceptButon, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE))
                                        .addComponent(listaScrollPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                        .addComponent(nombreTextField))
                                .addGap(71, 71, 71))
        );
        wordInsertionPanelLayout.setVerticalGroup(
                wordInsertionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(wordInsertionPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(wordInsertionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(infoLabel)
                                        .addComponent(nombreTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(wordInsertionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(wordInsertionPanelLayout.createSequentialGroup()
                                                .addComponent(infoLabel2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(addRowButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(12, 12, 12)
                                                .addComponent(deleteRowButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(wordInsertionPanelLayout.createSequentialGroup()
                                                .addComponent(listaScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(wordInsertionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(acceptButon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(78, Short.MAX_VALUE))
        );

        getContentPane().add(wordInsertionPanel, "card2");

        pack();
    }

    private void acceptButonActionPerformed(java.awt.event.ActionEvent evt) {
        if (listaTable.isEditing()) {
            listaTable.getCellEditor().stopCellEditing();
        }

        boolean valid = true;
        TableModel model = listaTable.getModel();
        HashMap<String, Integer> lista = new HashMap<>();

        int rowCount = model.getRowCount();

        for (int i = 0; i < rowCount; i++) {
            // Obtener el valor de la primera columna (clave) como String
            String clave = (String) model.getValueAt(i, 0);
            // Obtener el valor de la segunda columna (valor) como Integer
            String valorS = (String) model.getValueAt(i, 1);
            Integer valor = 0;
            try {valor = Integer.parseInt(valorS);}
            catch (NumberFormatException e) {
                errorView error = new errorView();
                error.setMessageError("Formato incorrecto de lista");
                error.setVisible(true);
                error.setLocationRelativeTo(null);
                valid = false;
                break;
            }
            // Agregar al HashMap
            lista.put(clave, valor);
        }

        String nombreLista = nombreTextField.getText();

        if (valid) {
            cp.crearLista(nombreLista, lista);
            this.setVisible(false);
        }
    }

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {
        sizeSelectionPanel.setVisible(true);
        wordInsertionPanel.setVisible(false);
        nombreTextField.setText("");
    }

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
    }

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String sizeString = sizeTextField.getText();
        try {
            int size = Integer.parseInt(sizeString);
            DefaultTableModel model = new DefaultTableModel(new String[]{"Palabra", "Frecuencia"}, size);
            listaTable.setModel(model);
            wordInsertionPanel.setVisible(true);
            sizeSelectionPanel.setVisible(false);
        }
        catch (NumberFormatException e) {
            errorView error = new errorView();
            error.setMessageError("Introduce un size valido!");
            error.setVisible(true);
            error.setLocationRelativeTo(null);
        }


    }

    private void addRowButtonActionPerformed(java.awt.event.ActionEvent evt) {
        DefaultTableModel model = (DefaultTableModel) listaTable.getModel();
        model.addRow(new Objects[] {null,null});
        listaTable.setModel(model);
    }

    private void deleteRowButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if (listaTable.getRowCount() > 0) {
            DefaultTableModel model = (DefaultTableModel) listaTable.getModel();
            model.removeRow(listaTable.getRowCount()-1);
            listaTable.setModel(model);
        }
    }
}
