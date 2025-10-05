package presentacion;

import domain.classes.Error;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class editarListaView extends javax.swing.JFrame {

    private controladorPresentacion cp;
    private String oldName;
    private HashMap<String, Integer> oldList;
    private javax.swing.JButton acceptButon;
    private javax.swing.JButton addRowButton;
    private javax.swing.JPanel background;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton deleteRowButton;
    private javax.swing.JLabel infoLabel;
    private javax.swing.JLabel infoLabel2;
    private javax.swing.JScrollPane listaScrollPanel;
    private javax.swing.JTable listaTable;
    private javax.swing.JTextField nombreTextField;
    /**
     * Creates new form editarListaView
     */
    public editarListaView(controladorPresentacion cp, String nombreLista, HashMap<String, Integer> lista) {
        this.cp = cp;
        this.oldName = nombreLista;
        this.oldList = lista;
        initComponents();
        nombreTextField.setText(nombreLista);
        DefaultTableModel model = new DefaultTableModel(new String[]{"Palabra", "Frecuencia"}, lista.size());
        int i = 0;
        for (Map.Entry<String, Integer> entry : lista.entrySet()) {
            model.setValueAt(entry.getKey(), i, 0);
            model.setValueAt(entry.getValue(), i++, 1);
        }
        listaTable.setModel(model);
    }

    private void initComponents() {

        background = new javax.swing.JPanel();
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
        setResizable(false);

        background.setBackground(new java.awt.Color(153, 153, 255));

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

        infoLabel2.setText("Lista:");

        acceptButon.setText("Acceptar");
        acceptButon.setMaximumSize(new java.awt.Dimension(91, 22));
        acceptButon.setMinimumSize(new java.awt.Dimension(91, 22));
        acceptButon.setPreferredSize(new java.awt.Dimension(91, 22));
        acceptButon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acceptButonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancelar");
        cancelButton.setMaximumSize(new java.awt.Dimension(91, 22));
        cancelButton.setMinimumSize(new java.awt.Dimension(91, 22));
        cancelButton.setPreferredSize(new java.awt.Dimension(91, 22));
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        deleteRowButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        deleteRowButton.setText("-");
        deleteRowButton.setMaximumSize(new java.awt.Dimension(40, 40));
        deleteRowButton.setMinimumSize(new java.awt.Dimension(40, 40));
        deleteRowButton.setPreferredSize(new java.awt.Dimension(40, 40));
        deleteRowButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteRowButtonActionPerformed(evt);
            }
        });

        addRowButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        addRowButton.setText("+");
        addRowButton.setMaximumSize(new java.awt.Dimension(40, 40));
        addRowButton.setMinimumSize(new java.awt.Dimension(40, 40));
        addRowButton.setPreferredSize(new java.awt.Dimension(40, 40));
        addRowButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addRowButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
                backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(backgroundLayout.createSequentialGroup()
                                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(backgroundLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(infoLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                                                        .addComponent(infoLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundLayout.createSequentialGroup()
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(deleteRowButton, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                                                        .addComponent(addRowButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(backgroundLayout.createSequentialGroup()
                                                        .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(acceptButon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(nombreTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(listaScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(24, Short.MAX_VALUE))
        );
        backgroundLayout.setVerticalGroup(
                backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(backgroundLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(infoLabel)
                                        .addComponent(nombreTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(backgroundLayout.createSequentialGroup()
                                                .addComponent(infoLabel2)
                                                .addGap(18, 18, 18)
                                                .addComponent(addRowButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(deleteRowButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(listaScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(acceptButon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(20, Short.MAX_VALUE))
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
            Object c = model.getValueAt(i, 0);
            // Obtener el valor de la segunda columna (valor) como Integer
            Object v= model.getValueAt(i, 1);

            if (c == null || v == null) valid = false;
            if (valid) {
                String valueS = v.toString();
                String clave = c.toString();
                Integer valor = 0;
                try {valor = Integer.parseInt(valueS);}
                catch (NumberFormatException e) {
                    valid = false;
                    errorView error = new errorView();
                    error.setMessageError("Formato incorrecto de lista");
                    error.setVisible(true);
                    error.setLocationRelativeTo(null);
                }
                // Agregar al HashMap
                lista.put(clave, valor);
            }

        }

        String nombreLista = nombreTextField.getText();

        if (valid) {
            cp.editarLista(oldName, nombreLista, oldList, lista);
            this.setVisible(false);
        }
        else cp.mostrarError(-Error.typeError.ERRORFORMATOLISTA.ordinal());
    }

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
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
