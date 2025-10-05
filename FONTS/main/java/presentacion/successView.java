package presentacion;

public class successView extends javax.swing.JFrame {

    private javax.swing.JButton acceptButton;
    private javax.swing.JPanel background;
    private javax.swing.JLabel successTextLabel;
    /**
     * Creates new form successView
     */
    public successView(String type) {
        initComponents();
        if (type.equals("change")) successTextLabel.setText("Se ha cambiado correctamente!");
        else if (type.equals("create")) successTextLabel.setText("Se ha creado correctamente!");
        else if (type.equals("delete")) successTextLabel.setText("Se ha eliminado correctamente!");
        else if (type.equals("edit")) successTextLabel.setText("Se ha editado correctamente!");
        else if (type.equals("import")) successTextLabel.setText("Se ha importado correctamente!");
        else if (type.equals("export")) successTextLabel.setText("Se ha exportado correctamente!");
    }

    private void initComponents() {

        background = new javax.swing.JPanel();
        successTextLabel = new javax.swing.JLabel();
        acceptButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        background.setBackground(new java.awt.Color(153, 153, 255));

        successTextLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        successTextLabel.setText("SuccessText");

        acceptButton.setText("Acceptar");
        acceptButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acceptButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
                backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(backgroundLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(acceptButton)
                                .addGap(144, 144, 144))
                        .addGroup(backgroundLayout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(successTextLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(37, Short.MAX_VALUE))
        );
        backgroundLayout.setVerticalGroup(
                backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(backgroundLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(successTextLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(acceptButton)
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
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }

    private void acceptButtonActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
    }
}
