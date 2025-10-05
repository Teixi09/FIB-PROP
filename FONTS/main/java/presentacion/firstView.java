package presentacion;

/**
 *
 * @author teixi09
 */
public class firstView extends javax.swing.JFrame {

    controladorPresentacion cp;

    // Variables declaration - do not modify
    private javax.swing.JButton acceptLoginButton;
    private javax.swing.JButton acceptRegisterButton;
    private javax.swing.JLabel appNameLabel;
    private javax.swing.JButton backFromLogButton;
    private javax.swing.JButton backFromRegButton;
    private javax.swing.JPanel firstViewPanel;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JButton loginButton;
    private javax.swing.JPanel loginPanel;
    private javax.swing.JLabel loginViewLabel;
    private javax.swing.JLabel mailLabel;
    private javax.swing.JTextField mailTextField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JLabel passwordLabel1;
    private javax.swing.JButton registerButton;
    private javax.swing.JPanel registerPanel;
    private javax.swing.JLabel registerViewLabel1;
    private javax.swing.JPanel startPanel;
    private javax.swing.JLabel usernameLabel;
    private javax.swing.JLabel usernameLabel1;
    private javax.swing.JTextField usernameTextField;
    private javax.swing.JTextField usernameTextField1;
    // End of variables declaration

    public firstView(controladorPresentacion cp) {
        this.cp = cp;
        initComponents();
        loginPanel.setVisible(false);
    }


    private void initComponents() {

        firstViewPanel = new javax.swing.JPanel();
        startPanel = new javax.swing.JPanel();
        appNameLabel = new javax.swing.JLabel();
        loginButton = new javax.swing.JButton();
        registerButton = new javax.swing.JButton();
        loginPanel = new javax.swing.JPanel();
        loginViewLabel = new javax.swing.JLabel();
        usernameLabel = new javax.swing.JLabel();
        usernameTextField = new javax.swing.JTextField();
        passwordLabel = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        acceptLoginButton = new javax.swing.JButton();
        backFromLogButton = new javax.swing.JButton();
        registerPanel = new javax.swing.JPanel();
        registerViewLabel1 = new javax.swing.JLabel();
        usernameLabel1 = new javax.swing.JLabel();
        usernameTextField1 = new javax.swing.JTextField();
        passwordLabel1 = new javax.swing.JLabel();
        jPasswordField2 = new javax.swing.JPasswordField();
        acceptRegisterButton = new javax.swing.JButton();
        backFromRegButton = new javax.swing.JButton();
        mailLabel = new javax.swing.JLabel();
        mailTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SmartLayout");
        setBackground(new java.awt.Color(204, 204, 255));
        setMaximumSize(new java.awt.Dimension(750, 500));
        setMinimumSize(new java.awt.Dimension(750, 500));
        setName("LoginFrame"); // NOI18N
        setPreferredSize(new java.awt.Dimension(750, 500));
        setResizable(false);

        firstViewPanel.setBackground(new java.awt.Color(204, 204, 255));
        firstViewPanel.setToolTipText("");
        firstViewPanel.setMaximumSize(new java.awt.Dimension(712, 500));
        firstViewPanel.setMinimumSize(new java.awt.Dimension(712, 500));
        firstViewPanel.setPreferredSize(new java.awt.Dimension(712, 500));
        firstViewPanel.setLayout(new java.awt.CardLayout());

        startPanel.setBackground(new java.awt.Color(204, 204, 255));
        startPanel.setMaximumSize(new java.awt.Dimension(712, 500));
        startPanel.setMinimumSize(new java.awt.Dimension(712, 500));
        startPanel.setPreferredSize(new java.awt.Dimension(712, 500));

        appNameLabel.setFont(new java.awt.Font("Arial", 1, 42)); // NOI18N
        appNameLabel.setText("SmartLayout");
        appNameLabel.setMaximumSize(new java.awt.Dimension(300, 73));
        appNameLabel.setMinimumSize(new java.awt.Dimension(300, 73));
        appNameLabel.setPreferredSize(new java.awt.Dimension(300, 73));

        loginButton.setFont(new java.awt.Font("NATS", 1, 24)); // NOI18N
        loginButton.setText("LOGIN");
        loginButton.setMargin(new java.awt.Insets(5, 10, 5, 10));
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        registerButton.setFont(new java.awt.Font("NATS", 1, 24)); // NOI18N
        registerButton.setText("REGISTER");
        registerButton.setMargin(new java.awt.Insets(5, 10, 5, 10));
        registerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout startPanelLayout = new javax.swing.GroupLayout(startPanel);
        startPanel.setLayout(startPanelLayout);
        startPanelLayout.setHorizontalGroup(
                startPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(startPanelLayout.createSequentialGroup()
                                .addGap(110, 110, 110)
                                .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 233, Short.MAX_VALUE)
                                .addComponent(registerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(110, 110, 110))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, startPanelLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(appNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(202, 202, 202))
        );
        startPanelLayout.setVerticalGroup(
                startPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(startPanelLayout.createSequentialGroup()
                                .addGap(84, 84, 84)
                                .addComponent(appNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(81, 81, 81)
                                .addGroup(startPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(loginButton)
                                        .addComponent(registerButton))
                                .addContainerGap(223, Short.MAX_VALUE))
        );

        firstViewPanel.add(startPanel, "card5");

        loginPanel.setBackground(new java.awt.Color(204, 204, 255));
        loginPanel.setMaximumSize(new java.awt.Dimension(700, 500));
        loginPanel.setMinimumSize(new java.awt.Dimension(700, 500));
        loginPanel.setPreferredSize(new java.awt.Dimension(700, 500));

        loginViewLabel.setFont(new java.awt.Font("NATS", 1, 48)); // NOI18N
        loginViewLabel.setText("LOGIN");

        usernameLabel.setFont(new java.awt.Font("NATS", 1, 24)); // NOI18N
        usernameLabel.setText("Usuario");

        usernameTextField.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        usernameTextField.setMargin(new java.awt.Insets(2, 10, 2, 6));
        usernameTextField.setMaximumSize(new java.awt.Dimension(200, 40));
        usernameTextField.setMinimumSize(new java.awt.Dimension(200, 40));
        usernameTextField.setPreferredSize(new java.awt.Dimension(200, 40));

        passwordLabel.setFont(new java.awt.Font("NATS", 1, 24)); // NOI18N
        passwordLabel.setText("Password");

        jPasswordField1.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jPasswordField1.setMargin(new java.awt.Insets(2, 10, 2, 6));
        jPasswordField1.setMaximumSize(new java.awt.Dimension(200, 40));
        jPasswordField1.setMinimumSize(new java.awt.Dimension(200, 40));
        jPasswordField1.setPreferredSize(new java.awt.Dimension(200, 40));

        acceptLoginButton.setFont(new java.awt.Font("NATS", 1, 18)); // NOI18N
        acceptLoginButton.setText("Login");
        acceptLoginButton.setMargin(new java.awt.Insets(5, 10, 5, 10));
        acceptLoginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acceptLoginButtonActionPerformed(evt);
            }
        });

        backFromLogButton.setFont(new java.awt.Font("NATS", 1, 24)); // NOI18N
        backFromLogButton.setText("Back");
        backFromLogButton.setMargin(new java.awt.Insets(5, 10, 5, 10));
        backFromLogButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backFromLogButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout loginPanelLayout = new javax.swing.GroupLayout(loginPanel);
        loginPanel.setLayout(loginPanelLayout);
        loginPanelLayout.setHorizontalGroup(
                loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(loginPanelLayout.createSequentialGroup()
                                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(loginPanelLayout.createSequentialGroup()
                                                .addGap(153, 153, 153)
                                                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(passwordLabel)
                                                        .addComponent(usernameLabel)))
                                        .addGroup(loginPanelLayout.createSequentialGroup()
                                                .addGap(288, 288, 288)
                                                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(usernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                .addComponent(acceptLoginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginPanelLayout.createSequentialGroup()
                                                                .addComponent(loginViewLabel)
                                                                .addGap(44, 44, 44))))
                                        .addGroup(loginPanelLayout.createSequentialGroup()
                                                .addGap(21, 21, 21)
                                                .addComponent(backFromLogButton)))
                                .addGap(11, 337, Short.MAX_VALUE))
        );
        loginPanelLayout.setVerticalGroup(
                loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(loginPanelLayout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(loginViewLabel)
                                .addGap(31, 31, 31)
                                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(usernameLabel)
                                        .addComponent(usernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(44, 44, 44)
                                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(passwordLabel)
                                        .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(49, 49, 49)
                                .addComponent(acceptLoginButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                                .addComponent(backFromLogButton)
                                .addGap(47, 47, 47))
        );

        firstViewPanel.add(loginPanel, "card3");

        registerPanel.setBackground(new java.awt.Color(204, 204, 255));
        registerPanel.setMaximumSize(new java.awt.Dimension(712, 500));
        registerPanel.setMinimumSize(new java.awt.Dimension(712, 500));

        registerViewLabel1.setFont(new java.awt.Font("NATS", 1, 48)); // NOI18N
        registerViewLabel1.setText("REGISTER");

        usernameLabel1.setFont(new java.awt.Font("NATS", 1, 24)); // NOI18N
        usernameLabel1.setText("Usuario");

        usernameTextField1.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        usernameTextField1.setMargin(new java.awt.Insets(2, 10, 2, 6));
        usernameTextField1.setMaximumSize(new java.awt.Dimension(200, 40));
        usernameTextField1.setMinimumSize(new java.awt.Dimension(200, 40));
        usernameTextField1.setPreferredSize(new java.awt.Dimension(200, 40));

        passwordLabel1.setFont(new java.awt.Font("NATS", 1, 24)); // NOI18N
        passwordLabel1.setText("Password");

        jPasswordField2.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jPasswordField2.setMargin(new java.awt.Insets(2, 10, 2, 6));
        jPasswordField2.setMaximumSize(new java.awt.Dimension(200, 40));
        jPasswordField2.setMinimumSize(new java.awt.Dimension(200, 40));
        jPasswordField2.setPreferredSize(new java.awt.Dimension(200, 40));

        acceptRegisterButton.setFont(new java.awt.Font("NATS", 1, 18)); // NOI18N
        acceptRegisterButton.setText("Register");
        acceptRegisterButton.setMargin(new java.awt.Insets(5, 10, 5, 10));
        acceptRegisterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acceptRegisterButtonActionPerformed(evt);
            }
        });

        backFromRegButton.setFont(new java.awt.Font("NATS", 1, 24)); // NOI18N
        backFromRegButton.setText("Back");
        backFromRegButton.setMargin(new java.awt.Insets(5, 10, 5, 10));
        backFromRegButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backFromRegButtonActionPerformed(evt);
            }
        });

        mailLabel.setFont(new java.awt.Font("NATS", 1, 24)); // NOI18N
        mailLabel.setText("Correo");

        mailTextField.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        mailTextField.setMargin(new java.awt.Insets(2, 10, 2, 6));
        mailTextField.setMaximumSize(new java.awt.Dimension(200, 40));
        mailTextField.setMinimumSize(new java.awt.Dimension(200, 40));
        mailTextField.setPreferredSize(new java.awt.Dimension(200, 40));

        javax.swing.GroupLayout registerPanelLayout = new javax.swing.GroupLayout(registerPanel);
        registerPanel.setLayout(registerPanelLayout);
        registerPanelLayout.setHorizontalGroup(
                registerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(registerPanelLayout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(registerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(registerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(passwordLabel1)
                                                .addComponent(usernameLabel1)
                                                .addGroup(registerPanelLayout.createSequentialGroup()
                                                        .addComponent(mailLabel)
                                                        .addGap(68, 68, 68)
                                                        .addGroup(registerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(usernameTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGroup(registerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(acceptRegisterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jPasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addComponent(mailTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGroup(registerPanelLayout.createSequentialGroup()
                                                                        .addGap(9, 9, 9)
                                                                        .addComponent(registerViewLabel1)))))
                                        .addGroup(registerPanelLayout.createSequentialGroup()
                                                .addComponent(backFromRegButton)
                                                .addGap(397, 397, 397)))
                                .addGap(12, 338, Short.MAX_VALUE))
        );
        registerPanelLayout.setVerticalGroup(
                registerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(registerPanelLayout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(registerViewLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(registerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(usernameLabel1)
                                        .addComponent(usernameTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(39, 39, 39)
                                .addGroup(registerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(passwordLabel1)
                                        .addComponent(jPasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                                .addGroup(registerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(mailLabel)
                                        .addComponent(mailTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(39, 39, 39)
                                .addComponent(acceptRegisterButton)
                                .addGap(16, 16, 16)
                                .addComponent(backFromRegButton)
                                .addGap(47, 47, 47))
        );

        firstViewPanel.add(registerPanel, "card4");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(firstViewPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 825, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(firstViewPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }


    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {
        loginPanel.setVisible(true);
        startPanel.setVisible(false);
    }

    private void registerButtonActionPerformed(java.awt.event.ActionEvent evt) {
        registerPanel.setVisible(true);
        startPanel.setVisible(false);
    }

    private void backFromLogButtonActionPerformed(java.awt.event.ActionEvent evt) {
        startPanel.setVisible(true);
        loginPanel.setVisible(false);
        usernameTextField.setText("");
        jPasswordField1.setText("");
    }

    private void backFromRegButtonActionPerformed(java.awt.event.ActionEvent evt) {
        startPanel.setVisible(true);
        registerPanel.setVisible(false);
        usernameTextField1.setText("");
        jPasswordField2.setText("");
        mailTextField.setText("");
    }

    private void acceptRegisterButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String username = usernameTextField1.getText();
        char[] aux = jPasswordField2.getPassword();
        String password = new String(aux);
        String mail = mailTextField.getText();
        usernameTextField1.setText("");
        jPasswordField2.setText("");
        mailTextField.setText("");

        int status = cp.register(username, password, mail);
        if (status >= 0) this.setVisible(false);
        else cp.mostrarError(status);
    }

    private void acceptLoginButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String username = usernameTextField.getText();
        char[] aux = jPasswordField1.getPassword();
        String password = new String(aux);
        usernameTextField.setText("");
        jPasswordField1.setText("");

        int status = cp.login(username, password);
        if (status >= 0) this.setVisible(false);
        else cp.mostrarError(status);
    }
}
