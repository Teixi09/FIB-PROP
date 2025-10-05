package presentacion;

public class deleteWarningView extends javax.swing.JFrame {

    private controladorPresentacion cp;
    private String deletedObjectName;
    private String objectType;
    private javax.swing.JButton acceptButton;
    private javax.swing.JPanel background;
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel warningLabel;
    /**
     * Creates new form deleteWarning
     */
    public deleteWarningView(controladorPresentacion cp, String deletedObjectName, String objectType) {
        this.cp = cp;
        this.deletedObjectName = deletedObjectName;
        this.objectType = objectType;
        initComponents();
        if (objectType.equals("Alfabeto")) warningLabel.setText("Estas seguro de que quieres eliminar el alfabeto " + deletedObjectName + "?");
        else if (objectType.equals("Texto")) warningLabel.setText("Estas seguro de que quieres eliminar el texto " + deletedObjectName + "?");
        else if (objectType.equals("Lista")) warningLabel.setText("Estas seguro de que quieres eliminar la lista " + deletedObjectName + "?");
        else if (objectType.equals("Teclado")) warningLabel.setText("Estas seguro de que quieres eliminar el teclado " + deletedObjectName + "?");
        else if (objectType.equals("User")) warningLabel.setText("Estas seguro de que quieres eliminar el usuario " + deletedObjectName + "?");
    }

    private void initComponents() {

        background = new javax.swing.JPanel();
        warningLabel = new javax.swing.JLabel();
        acceptButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        background.setBackground(new java.awt.Color(153, 153, 255));

        warningLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        warningLabel.setText("Estas seguro de que quieres eliminar el x y");

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

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
                backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(backgroundLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(warningLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                        .addGroup(backgroundLayout.createSequentialGroup()
                                .addGap(150, 150, 150)
                                .addComponent(cancelButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(acceptButton)
                                .addContainerGap(158, Short.MAX_VALUE))
        );
        backgroundLayout.setVerticalGroup(
                backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(backgroundLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(warningLabel)
                                .addGap(18, 18, 18)
                                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(acceptButton)
                                        .addComponent(cancelButton))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }

    public void deleteObject() {
        if (objectType.equals("Alfabeto")) cp.eliminarAlfabeto(deletedObjectName);
        else if (objectType.equals("Texto")) cp.eliminarTexto(deletedObjectName);
        else if (objectType.equals("Lista")) cp.eliminarLista(deletedObjectName);
        else if (objectType.equals("Teclado")) cp.eliminarTeclado(deletedObjectName);
        else if (objectType.equals("User")) cp.eliminarUsuario();
    }

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
    }

    private void acceptButtonActionPerformed(java.awt.event.ActionEvent evt) {
        deleteObject();
        this.setVisible(false);
    }
}
