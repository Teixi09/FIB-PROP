package presentacion;
/**
 *
 * @author eteix
 */
public class errorView extends javax.swing.JFrame {

    // Variables declaration - do not modify
    private javax.swing.JButton acceptButton;
    private javax.swing.JPanel background;
    private javax.swing.JTextArea errorTextLabel;
    private javax.swing.JLabel errorTitleLabel;
    // End of variables declaration

    /**
     * Creates new form errorView
     */
    public errorView() {
        initComponents();
    }

    private void initComponents() {

        background = new javax.swing.JPanel();
        errorTitleLabel = new javax.swing.JLabel();
        acceptButton = new javax.swing.JButton();
        errorTextLabel = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(500, 300));
        setResizable(false);

        background.setBackground(new java.awt.Color(204, 204, 255));
        background.setMaximumSize(new java.awt.Dimension(500, 300));
        background.setMinimumSize(new java.awt.Dimension(500, 300));

        errorTitleLabel.setFont(new java.awt.Font("Verdana", 1, 36)); // NOI18N
        errorTitleLabel.setForeground(new java.awt.Color(255, 102, 102));
        errorTitleLabel.setText("ERROR");

        acceptButton.setFont(new java.awt.Font("Segoe UI Historic", 0, 14)); // NOI18N
        acceptButton.setText("Aceptar");
        acceptButton.setBorder(null);
        acceptButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acceptButtonActionPerformed(evt);
            }
        });

        errorTextLabel.setEditable(false);
        errorTextLabel.setColumns(20);
        errorTextLabel.setRows(5);
        errorTextLabel.setWrapStyleWord(true);

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
                backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(acceptButton, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26))
                        .addGroup(backgroundLayout.createSequentialGroup()
                                .addGap(178, 178, 178)
                                .addComponent(errorTitleLabel)
                                .addContainerGap(182, Short.MAX_VALUE))
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(backgroundLayout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(errorTextLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))
        );
        backgroundLayout.setVerticalGroup(
                backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(backgroundLayout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(errorTitleLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 189, Short.MAX_VALUE)
                                .addComponent(acceptButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20))
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(backgroundLayout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(errorTextLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

    private void acceptButtonActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
    }

    public void setMessageError(String msg) {
        errorTextLabel.setText(msg);
    }
}
