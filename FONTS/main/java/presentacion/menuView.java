package presentacion;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author eteix
 */
public class menuView extends javax.swing.JFrame {

    private controladorPresentacion cp;
    private javax.swing.JMenu alfabetosMenu;
    private javax.swing.JScrollPane alfabetosScrollPanel;
    private javax.swing.JTable alfabetosTable;
    private javax.swing.JPanel alphabetsMenuPanel;
    private javax.swing.JButton changeMailButton;
    private javax.swing.JButton changePasswordButton;
    private javax.swing.JButton changeUsernameButton;
    private javax.swing.JButton createAlfabetoButton;
    private javax.swing.JButton createKeyboardButton;
    private javax.swing.JButton createListButton;
    private javax.swing.JButton createTextButton;
    private javax.swing.JButton deleteAlfabetoButton;
    private javax.swing.JButton deleteKeyboardButton;
    private javax.swing.JButton deleteListButton;
    private javax.swing.JButton deleteTextButton;
    private javax.swing.JButton deleteUserButton;
    private javax.swing.JButton editAlfabetoButton;
    private javax.swing.JButton editKeyboardButton;
    private javax.swing.JButton editListButton;
    private javax.swing.JButton editTextButton;
    private javax.swing.JButton exportAlfabetoButton;
    private javax.swing.JButton exportKeyboardButton;
    private javax.swing.JButton exportListButton;
    private javax.swing.JButton exportTextButton;
    private javax.swing.JButton importAlfabetoButton;
    private javax.swing.JButton importListButton;
    private javax.swing.JButton importTextButton;
    private javax.swing.JLabel infoUserLabel;
    private javax.swing.JScrollPane keyboardScrollPanel;
    private javax.swing.JTable keyboardTable;
    private javax.swing.JPanel keyboardsMenuPanel;
    private javax.swing.JMenu listasMenu;
    private javax.swing.JComboBox<String> listsComboBox;
    private javax.swing.JPanel listsMenuPanel;
    private javax.swing.JScrollPane listsScrollPanel;
    private javax.swing.JTable listsTable;
    private javax.swing.JButton logoutButton;
    private javax.swing.JLabel mailInfoLabel;
    private javax.swing.JLabel mailLabel;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JLabel passwordInfoLabel;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JButton seeKeyboardButton;
    private javax.swing.JMenu tecladosMenu;
    private javax.swing.JTextArea textArea;
    private javax.swing.JComboBox<String> textosComboBox;
    private javax.swing.JMenu textosMenu;
    private javax.swing.JScrollPane textosScrollPane;
    private javax.swing.JPanel textsMenuPanel;
    private javax.swing.JMenu userMenu;
    private javax.swing.JPanel userMenuPanel;
    private javax.swing.JLabel usernameInfoLabel;
    private javax.swing.JLabel usernameLabel;
    private javax.swing.JPanel welcomePanel;
    private javax.swing.JLabel welcomeText;

    /**
     * Creates new form mainMenu
     */
    public menuView(controladorPresentacion cp) {
        this.cp = cp;
        initComponents();
        firstStart();
    }

    private void firstStart() {
        iniUser();
        iniAlfabetos();
        iniListas();
        iniTeclados();
        iniTextos();
        userMenuPanel.setVisible(false);
        alphabetsMenuPanel.setVisible(false);
        listsMenuPanel.setVisible(false);
        textsMenuPanel.setVisible(false);
        welcomePanel.setVisible(true);
    }

    public void iniUser() {
        ArrayList<String> infoUser = cp.getInfoUser();
        usernameLabel.setText(infoUser.get(1));
        passwordLabel.setText(infoUser.get(2));
        mailLabel.setText(infoUser.get(3));
    }

    public void iniAlfabetos() {
        ArrayList<String> listaAux = new ArrayList<>();
        cp.getNombresAlfabetos(listaAux);
        int n = listaAux.size();
        DefaultTableModel model = new DefaultTableModel(new String[]{"Nombre", "Alfabeto"}, n);
        for (int i = 0; i < n; ++i) {
            String nombreAlfabeto = listaAux.get(i);
            model.setValueAt(nombreAlfabeto, i, 0);
            model.setValueAt(cp.getAlfabeto(nombreAlfabeto), i, 1);
        }
        alfabetosTable.setModel(model);
    }

    public void iniListas() {
        ArrayList<String> listaAux = new ArrayList<>();
        cp.getNombresListas(listaAux);
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        model.addElement("-- Selecciona una lista --");
        for (String nombreLista : listaAux) {
            model.addElement(nombreLista);
        }
        listsComboBox.setModel(model);
        DefaultTableModel model2 = new DefaultTableModel(new String[]{"Palabra", "Frecuencia"}, 0);
        listsTable.setModel(model2);
    }

    public void iniTeclados() {
        ArrayList<String> nombresTeclados = new ArrayList<>();
        cp.getNombreTeclados(nombresTeclados);
        int n = nombresTeclados.size();
        DefaultTableModel model = new DefaultTableModel(new String[]{"Nombre", "Alfabeto asociado", "Texto asociado", "Lista asociada"}, n);
        for (int i = 0; i < n; ++i) {
            ArrayList<String> info = cp.getInfoTeclado(nombresTeclados.get(i));
            model.setValueAt(nombresTeclados.get(i), i, 0);
            model.setValueAt(info.get(0), i, 1);
            model.setValueAt(info.get(1), i, 2);
            model.setValueAt(info.get(2), i, 3);
        }
        keyboardTable.setModel(model);
    }

    public void iniTextos() {
        ArrayList<String> listaAux = new ArrayList<>();
        cp.getNombresTextos(listaAux);
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        model.addElement("-- Selecciona un texto --");
        for (String nombreTexto : listaAux) {
            model.addElement(nombreTexto);
        }
        textosComboBox.setModel(model);
        textArea.setText("");
    }

    private void initComponents() {

        welcomePanel = new javax.swing.JPanel();
        welcomeText = new javax.swing.JLabel();
        userMenuPanel = new javax.swing.JPanel();
        infoUserLabel = new javax.swing.JLabel();
        usernameInfoLabel = new javax.swing.JLabel();
        passwordInfoLabel = new javax.swing.JLabel();
        mailInfoLabel = new javax.swing.JLabel();
        usernameLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        mailLabel = new javax.swing.JLabel();
        logoutButton = new javax.swing.JButton();
        changeUsernameButton = new javax.swing.JButton();
        changePasswordButton = new javax.swing.JButton();
        changeMailButton = new javax.swing.JButton();
        deleteUserButton = new javax.swing.JButton();
        alphabetsMenuPanel = new javax.swing.JPanel();
        createAlfabetoButton = new javax.swing.JButton();
        deleteAlfabetoButton = new javax.swing.JButton();
        editAlfabetoButton = new javax.swing.JButton();
        importAlfabetoButton = new javax.swing.JButton();
        exportAlfabetoButton = new javax.swing.JButton();
        alfabetosScrollPanel = new javax.swing.JScrollPane();
        alfabetosTable = new javax.swing.JTable();
        listsMenuPanel = new javax.swing.JPanel();
        listsComboBox = new javax.swing.JComboBox<>();
        listsScrollPanel = new javax.swing.JScrollPane();
        listsTable = new javax.swing.JTable();
        createListButton = new javax.swing.JButton();
        deleteListButton = new javax.swing.JButton();
        editListButton = new javax.swing.JButton();
        importListButton = new javax.swing.JButton();
        exportListButton = new javax.swing.JButton();
        keyboardsMenuPanel = new javax.swing.JPanel();
        keyboardScrollPanel = new javax.swing.JScrollPane();
        keyboardTable = new javax.swing.JTable();
        createKeyboardButton = new javax.swing.JButton();
        deleteKeyboardButton = new javax.swing.JButton();
        editKeyboardButton = new javax.swing.JButton();
        exportKeyboardButton = new javax.swing.JButton();
        seeKeyboardButton = new javax.swing.JButton();
        textsMenuPanel = new javax.swing.JPanel();
        textosComboBox = new javax.swing.JComboBox<>();
        textosScrollPane = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        createTextButton = new javax.swing.JButton();
        deleteTextButton = new javax.swing.JButton();
        editTextButton = new javax.swing.JButton();
        importTextButton = new javax.swing.JButton();
        exportTextButton = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        userMenu = new javax.swing.JMenu();
        alfabetosMenu = new javax.swing.JMenu();
        listasMenu = new javax.swing.JMenu();
        tecladosMenu = new javax.swing.JMenu();
        textosMenu = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu");
        setMaximumSize(new java.awt.Dimension(650, 450));
        setMinimumSize(new java.awt.Dimension(650, 450));
        setPreferredSize(new java.awt.Dimension(650, 450));
        setResizable(false);
        getContentPane().setLayout(new java.awt.CardLayout());

        welcomePanel.setBackground(new java.awt.Color(153, 153, 255));
        welcomePanel.setAlignmentY(0.0F);
        welcomePanel.setMaximumSize(new java.awt.Dimension(650, 450));
        welcomePanel.setMinimumSize(new java.awt.Dimension(650, 450));
        welcomePanel.setPreferredSize(new java.awt.Dimension(650, 450));

        welcomeText.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        welcomeText.setText("Welcome to SmartLayout!");
        welcomeText.setPreferredSize(new java.awt.Dimension(590, 64));

        javax.swing.GroupLayout welcomePanelLayout = new javax.swing.GroupLayout(welcomePanel);
        welcomePanel.setLayout(welcomePanelLayout);
        welcomePanelLayout.setHorizontalGroup(
                welcomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(welcomePanelLayout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(welcomeText, javax.swing.GroupLayout.PREFERRED_SIZE, 605, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(23, Short.MAX_VALUE))
        );
        welcomePanelLayout.setVerticalGroup(
                welcomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(welcomePanelLayout.createSequentialGroup()
                                .addGap(147, 147, 147)
                                .addComponent(welcomeText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(244, Short.MAX_VALUE))
        );

        getContentPane().add(welcomePanel, "card3");

        userMenuPanel.setBackground(new java.awt.Color(153, 153, 255));
        userMenuPanel.setMaximumSize(new java.awt.Dimension(650, 450));
        userMenuPanel.setMinimumSize(new java.awt.Dimension(650, 450));
        userMenuPanel.setPreferredSize(new java.awt.Dimension(650, 450));

        infoUserLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        infoUserLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        infoUserLabel.setText("Info del usuario");

        usernameInfoLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        usernameInfoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        usernameInfoLabel.setText("Username: ");

        passwordInfoLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        passwordInfoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        passwordInfoLabel.setText("Password:");

        mailInfoLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        mailInfoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mailInfoLabel.setText("Correo:");

        usernameLabel.setText("jLabel1");

        passwordLabel.setText("jLabel1");

        mailLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        mailLabel.setText("jLabel1");

        logoutButton.setBackground(new java.awt.Color(204, 204, 255));
        logoutButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        logoutButton.setText("Logout");
        logoutButton.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 102, 102), new java.awt.Color(255, 153, 153)));
        logoutButton.setMaximumSize(new java.awt.Dimension(100, 31));
        logoutButton.setMinimumSize(new java.awt.Dimension(100, 31));
        logoutButton.setPreferredSize(new java.awt.Dimension(100, 31));
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        changeUsernameButton.setBackground(new java.awt.Color(204, 204, 255));
        changeUsernameButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        changeUsernameButton.setText("Cambiar username");
        changeUsernameButton.setMaximumSize(new java.awt.Dimension(160, 26));
        changeUsernameButton.setMinimumSize(new java.awt.Dimension(160, 26));
        changeUsernameButton.setPreferredSize(new java.awt.Dimension(160, 26));
        changeUsernameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeUsernameButtonActionPerformed(evt);
            }
        });

        changePasswordButton.setBackground(new java.awt.Color(204, 204, 255));
        changePasswordButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        changePasswordButton.setText("Cambiar password");
        changePasswordButton.setMaximumSize(new java.awt.Dimension(300, 50));
        changePasswordButton.setMinimumSize(new java.awt.Dimension(160, 26));
        changePasswordButton.setPreferredSize(new java.awt.Dimension(160, 26));
        changePasswordButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changePasswordButtonActionPerformed(evt);
            }
        });

        changeMailButton.setBackground(new java.awt.Color(204, 204, 255));
        changeMailButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        changeMailButton.setText("Cambiar correo");
        changeMailButton.setMaximumSize(new java.awt.Dimension(160, 26));
        changeMailButton.setMinimumSize(new java.awt.Dimension(160, 26));
        changeMailButton.setPreferredSize(new java.awt.Dimension(160, 26));
        changeMailButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeMailButtonActionPerformed(evt);
            }
        });

        deleteUserButton.setBackground(new java.awt.Color(255, 204, 204));
        deleteUserButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        deleteUserButton.setText("Eliminar Usuario");
        deleteUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteUserButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout userMenuPanelLayout = new javax.swing.GroupLayout(userMenuPanel);
        userMenuPanel.setLayout(userMenuPanelLayout);
        userMenuPanelLayout.setHorizontalGroup(
                userMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(userMenuPanelLayout.createSequentialGroup()
                                .addGap(82, 82, 82)
                                .addGroup(userMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(userMenuPanelLayout.createSequentialGroup()
                                                .addGroup(userMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(userMenuPanelLayout.createSequentialGroup()
                                                                .addGap(25, 25, 25)
                                                                .addComponent(mailInfoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(mailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(userMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                .addComponent(passwordInfoLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(usernameInfoLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(userMenuPanelLayout.createSequentialGroup()
                                                                .addGap(69, 69, 69)
                                                                .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                                                .addGroup(userMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(changeMailButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(changePasswordButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(changeUsernameButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(98, 98, 98))
                                        .addGroup(userMenuPanelLayout.createSequentialGroup()
                                                .addGap(125, 125, 125)
                                                .addGroup(userMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(usernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(passwordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGroup(userMenuPanelLayout.createSequentialGroup()
                                .addGroup(userMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(userMenuPanelLayout.createSequentialGroup()
                                                .addGap(110, 110, 110)
                                                .addComponent(infoUserLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(userMenuPanelLayout.createSequentialGroup()
                                                .addGap(132, 132, 132)
                                                .addComponent(deleteUserButton)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        userMenuPanelLayout.setVerticalGroup(
                userMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(userMenuPanelLayout.createSequentialGroup()
                                .addGap(76, 76, 76)
                                .addComponent(infoUserLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(userMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(userMenuPanelLayout.createSequentialGroup()
                                                .addGroup(userMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(usernameInfoLabel)
                                                        .addComponent(usernameLabel))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(userMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(passwordInfoLabel)
                                                        .addComponent(passwordLabel))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(userMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(mailInfoLabel)
                                                        .addComponent(mailLabel))
                                                .addGap(18, 18, 18)
                                                .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(userMenuPanelLayout.createSequentialGroup()
                                                .addComponent(changeUsernameButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(changePasswordButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(changeMailButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addComponent(deleteUserButton)
                                .addContainerGap(171, Short.MAX_VALUE))
        );

        getContentPane().add(userMenuPanel, "card2");

        alphabetsMenuPanel.setBackground(new java.awt.Color(153, 153, 255));
        alphabetsMenuPanel.setMaximumSize(new java.awt.Dimension(650, 450));
        alphabetsMenuPanel.setMinimumSize(new java.awt.Dimension(650, 450));
        alphabetsMenuPanel.setPreferredSize(new java.awt.Dimension(650, 450));

        createAlfabetoButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        createAlfabetoButton.setText("Crear");
        createAlfabetoButton.setMaximumSize(new java.awt.Dimension(110, 31));
        createAlfabetoButton.setMinimumSize(new java.awt.Dimension(110, 31));
        createAlfabetoButton.setPreferredSize(new java.awt.Dimension(110, 31));
        createAlfabetoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createAlfabetoButtonActionPerformed(evt);
            }
        });

        deleteAlfabetoButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        deleteAlfabetoButton.setText("Eliminar");
        deleteAlfabetoButton.setMaximumSize(new java.awt.Dimension(110, 31));
        deleteAlfabetoButton.setMinimumSize(new java.awt.Dimension(110, 31));
        deleteAlfabetoButton.setPreferredSize(new java.awt.Dimension(110, 31));
        deleteAlfabetoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteAlfabetoButtonActionPerformed(evt);
            }
        });

        editAlfabetoButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        editAlfabetoButton.setText("Editar");
        editAlfabetoButton.setMaximumSize(new java.awt.Dimension(110, 31));
        editAlfabetoButton.setMinimumSize(new java.awt.Dimension(110, 31));
        editAlfabetoButton.setPreferredSize(new java.awt.Dimension(110, 31));
        editAlfabetoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editAlfabetoButtonActionPerformed(evt);
            }
        });

        importAlfabetoButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        importAlfabetoButton.setText("Importar");
        importAlfabetoButton.setMaximumSize(new java.awt.Dimension(110, 31));
        importAlfabetoButton.setMinimumSize(new java.awt.Dimension(110, 31));
        importAlfabetoButton.setPreferredSize(new java.awt.Dimension(110, 31));
        importAlfabetoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importAlfabetoButtonActionPerformed(evt);
            }
        });

        exportAlfabetoButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        exportAlfabetoButton.setText("Exportar");
        exportAlfabetoButton.setMaximumSize(new java.awt.Dimension(110, 31));
        exportAlfabetoButton.setMinimumSize(new java.awt.Dimension(110, 31));
        exportAlfabetoButton.setPreferredSize(new java.awt.Dimension(110, 31));
        exportAlfabetoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportAlfabetoButtonActionPerformed(evt);
            }
        });

        alfabetosTable = new javax.swing.JTable() {
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        alfabetosTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "Nombre", "Alfabeto"
                }
        ) {
            Class[] types = new Class [] {
                    java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                    false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        alfabetosTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        alfabetosTable.getTableHeader().setReorderingAllowed(false);
        alfabetosScrollPanel.setViewportView(alfabetosTable);
        alfabetosTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (alfabetosTable.getColumnModel().getColumnCount() > 0) {
            alfabetosTable.getColumnModel().getColumn(0).setMinWidth(100);
            alfabetosTable.getColumnModel().getColumn(0).setPreferredWidth(100);
            alfabetosTable.getColumnModel().getColumn(0).setMaxWidth(100);
            alfabetosTable.getColumnModel().getColumn(1).setMinWidth(200);
            alfabetosTable.getColumnModel().getColumn(1).setPreferredWidth(200);
            alfabetosTable.getColumnModel().getColumn(1).setMaxWidth(200);
        }

        javax.swing.GroupLayout alphabetsMenuPanelLayout = new javax.swing.GroupLayout(alphabetsMenuPanel);
        alphabetsMenuPanel.setLayout(alphabetsMenuPanelLayout);
        alphabetsMenuPanelLayout.setHorizontalGroup(
                alphabetsMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(alphabetsMenuPanelLayout.createSequentialGroup()
                                .addGap(85, 85, 85)
                                .addComponent(alfabetosScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(57, 57, 57)
                                .addGroup(alphabetsMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(createAlfabetoButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(deleteAlfabetoButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(editAlfabetoButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(exportAlfabetoButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(importAlfabetoButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(98, Short.MAX_VALUE))
        );
        alphabetsMenuPanelLayout.setVerticalGroup(
                alphabetsMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, alphabetsMenuPanelLayout.createSequentialGroup()
                                .addContainerGap(132, Short.MAX_VALUE)
                                .addGroup(alphabetsMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(alphabetsMenuPanelLayout.createSequentialGroup()
                                                .addComponent(createAlfabetoButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(deleteAlfabetoButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(editAlfabetoButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(importAlfabetoButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(exportAlfabetoButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(alfabetosScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(96, 96, 96))
        );

        getContentPane().add(alphabetsMenuPanel, "card4");

        listsMenuPanel.setBackground(new java.awt.Color(153, 153, 255));
        listsMenuPanel.setMaximumSize(new java.awt.Dimension(650, 450));
        listsMenuPanel.setMinimumSize(new java.awt.Dimension(650, 450));
        listsMenuPanel.setPreferredSize(new java.awt.Dimension(650, 450));

        listsComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Selecciona una lista --" }));
        listsComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listsComboBoxActionPerformed(evt);
            }
        });

        listsTable = new javax.swing.JTable(){
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        listsTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "Palabra", "Frecuencia"
                }
        ) {
            Class[] types = new Class [] {
                    java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                    false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        listsTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listsTable.getTableHeader().setReorderingAllowed(false);
        listsScrollPanel.setViewportView(listsTable);
        listsTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        createListButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        createListButton.setText("Crear");
        createListButton.setMaximumSize(new java.awt.Dimension(110, 31));
        createListButton.setMinimumSize(new java.awt.Dimension(110, 31));
        createListButton.setPreferredSize(new java.awt.Dimension(110, 31));
        createListButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createListButtonActionPerformed(evt);
            }
        });

        deleteListButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        deleteListButton.setText("Eliminar");
        deleteListButton.setMaximumSize(new java.awt.Dimension(110, 31));
        deleteListButton.setMinimumSize(new java.awt.Dimension(110, 31));
        deleteListButton.setPreferredSize(new java.awt.Dimension(110, 31));
        deleteListButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteListButtonActionPerformed(evt);
            }
        });

        editListButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        editListButton.setText("Editar");
        editListButton.setMaximumSize(new java.awt.Dimension(110, 31));
        editListButton.setMinimumSize(new java.awt.Dimension(110, 31));
        editListButton.setPreferredSize(new java.awt.Dimension(110, 31));
        editListButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editListButtonActionPerformed(evt);
            }
        });

        importListButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        importListButton.setText("Importar");
        importListButton.setMaximumSize(new java.awt.Dimension(110, 31));
        importListButton.setMinimumSize(new java.awt.Dimension(110, 31));
        importListButton.setPreferredSize(new java.awt.Dimension(110, 31));
        importListButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importListButtonActionPerformed(evt);
            }
        });

        exportListButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        exportListButton.setText("Exportar");
        exportListButton.setMaximumSize(new java.awt.Dimension(110, 31));
        exportListButton.setMinimumSize(new java.awt.Dimension(110, 31));
        exportListButton.setPreferredSize(new java.awt.Dimension(110, 31));
        exportListButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportListButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout listsMenuPanelLayout = new javax.swing.GroupLayout(listsMenuPanel);
        listsMenuPanel.setLayout(listsMenuPanelLayout);
        listsMenuPanelLayout.setHorizontalGroup(
                listsMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(listsMenuPanelLayout.createSequentialGroup()
                                .addGap(114, 114, 114)
                                .addGroup(listsMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(listsComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(listsScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(57, 57, 57)
                                .addGroup(listsMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(createListButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(deleteListButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(editListButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(importListButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(exportListButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(134, Short.MAX_VALUE))
        );
        listsMenuPanelLayout.setVerticalGroup(
                listsMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(listsMenuPanelLayout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(listsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(listsMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(listsMenuPanelLayout.createSequentialGroup()
                                                .addComponent(createListButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(deleteListButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(editListButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(importListButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(exportListButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(listsScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(141, Short.MAX_VALUE))
        );

        getContentPane().add(listsMenuPanel, "card6");

        keyboardsMenuPanel.setBackground(new java.awt.Color(153, 153, 255));

        keyboardTable = new javax.swing.JTable(){
            public boolean isCellEditable(int row, int col){
                return false;
            }
        };
        keyboardTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "Nombre", "Alfabeto Asociado", "Texto Asociado", "Lista Asociada"
                }
        ) {
            Class[] types = new Class [] {
                    java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                    false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        keyboardTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        keyboardTable.setShowHorizontalLines(true);
        keyboardTable.getTableHeader().setReorderingAllowed(false);
        keyboardScrollPanel.setViewportView(keyboardTable);
        keyboardTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        createKeyboardButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        createKeyboardButton.setText("Crear");
        createKeyboardButton.setMaximumSize(new java.awt.Dimension(110, 31));
        createKeyboardButton.setMinimumSize(new java.awt.Dimension(110, 31));
        createKeyboardButton.setPreferredSize(new java.awt.Dimension(110, 31));
        createKeyboardButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createKeyboardButtonActionPerformed(evt);
            }
        });

        deleteKeyboardButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        deleteKeyboardButton.setText("Eliminar");
        deleteKeyboardButton.setMaximumSize(new java.awt.Dimension(110, 31));
        deleteKeyboardButton.setMinimumSize(new java.awt.Dimension(110, 31));
        deleteKeyboardButton.setPreferredSize(new java.awt.Dimension(110, 31));
        deleteKeyboardButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteKeyboardButtonActionPerformed(evt);
            }
        });

        editKeyboardButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        editKeyboardButton.setText("Editar");
        editKeyboardButton.setMaximumSize(new java.awt.Dimension(110, 31));
        editKeyboardButton.setMinimumSize(new java.awt.Dimension(110, 31));
        editKeyboardButton.setPreferredSize(new java.awt.Dimension(110, 31));
        editKeyboardButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editKeyboardButtonActionPerformed(evt);
            }
        });

        exportKeyboardButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        exportKeyboardButton.setText("Exportar");
        exportKeyboardButton.setMaximumSize(new java.awt.Dimension(110, 31));
        exportKeyboardButton.setMinimumSize(new java.awt.Dimension(110, 31));
        exportKeyboardButton.setPreferredSize(new java.awt.Dimension(110, 31));
        exportKeyboardButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportKeyboardButtonActionPerformed(evt);
            }
        });

        seeKeyboardButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        seeKeyboardButton.setText("Ver");
        seeKeyboardButton.setMaximumSize(new java.awt.Dimension(110, 31));
        seeKeyboardButton.setMinimumSize(new java.awt.Dimension(110, 31));
        seeKeyboardButton.setPreferredSize(new java.awt.Dimension(110, 31));
        seeKeyboardButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seeKeyboardButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout keyboardsMenuPanelLayout = new javax.swing.GroupLayout(keyboardsMenuPanel);
        keyboardsMenuPanel.setLayout(keyboardsMenuPanelLayout);
        keyboardsMenuPanelLayout.setHorizontalGroup(
                keyboardsMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(keyboardsMenuPanelLayout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(keyboardScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(keyboardsMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(createKeyboardButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(deleteKeyboardButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(editKeyboardButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(exportKeyboardButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(seeKeyboardButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(54, Short.MAX_VALUE))
        );
        keyboardsMenuPanelLayout.setVerticalGroup(
                keyboardsMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(keyboardsMenuPanelLayout.createSequentialGroup()
                                .addGroup(keyboardsMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(keyboardsMenuPanelLayout.createSequentialGroup()
                                                .addGap(38, 38, 38)
                                                .addComponent(keyboardScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(keyboardsMenuPanelLayout.createSequentialGroup()
                                                .addGap(57, 57, 57)
                                                .addComponent(createKeyboardButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(deleteKeyboardButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(editKeyboardButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(exportKeyboardButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(seeKeyboardButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(141, Short.MAX_VALUE))
        );

        getContentPane().add(keyboardsMenuPanel, "card7");

        textsMenuPanel.setBackground(new java.awt.Color(153, 153, 255));
        textsMenuPanel.setMaximumSize(new java.awt.Dimension(650, 450));
        textsMenuPanel.setMinimumSize(new java.awt.Dimension(650, 450));
        textsMenuPanel.setPreferredSize(new java.awt.Dimension(650, 450));

        textosComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Selecciona un texto --" }));
        textosComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textosComboBoxActionPerformed(evt);
            }
        });

        textArea.setEditable(false);
        textArea.setColumns(20);
        textArea.setLineWrap(true);
        textArea.setRows(5);
        textosScrollPane.setViewportView(textArea);

        createTextButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        createTextButton.setText("Crear");
        createTextButton.setMaximumSize(new java.awt.Dimension(110, 31));
        createTextButton.setMinimumSize(new java.awt.Dimension(110, 31));
        createTextButton.setPreferredSize(new java.awt.Dimension(110, 31));
        createTextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createTextButtonActionPerformed(evt);
            }
        });

        deleteTextButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        deleteTextButton.setText("Eliminar");
        deleteTextButton.setMaximumSize(new java.awt.Dimension(110, 31));
        deleteTextButton.setMinimumSize(new java.awt.Dimension(110, 31));
        deleteTextButton.setPreferredSize(new java.awt.Dimension(110, 31));
        deleteTextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteTextButtonActionPerformed(evt);
            }
        });

        editTextButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        editTextButton.setText("Editar");
        editTextButton.setMaximumSize(new java.awt.Dimension(110, 31));
        editTextButton.setMinimumSize(new java.awt.Dimension(110, 31));
        editTextButton.setPreferredSize(new java.awt.Dimension(110, 31));
        editTextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editTextButtonActionPerformed(evt);
            }
        });

        importTextButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        importTextButton.setText("Importar");
        importTextButton.setMaximumSize(new java.awt.Dimension(110, 31));
        importTextButton.setMinimumSize(new java.awt.Dimension(110, 31));
        importTextButton.setPreferredSize(new java.awt.Dimension(110, 31));
        importTextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importTextButtonActionPerformed(evt);
            }
        });

        exportTextButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        exportTextButton.setText("Exportar");
        exportTextButton.setMaximumSize(new java.awt.Dimension(110, 31));
        exportTextButton.setMinimumSize(new java.awt.Dimension(110, 31));
        exportTextButton.setPreferredSize(new java.awt.Dimension(110, 31));
        exportTextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportTextButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout textsMenuPanelLayout = new javax.swing.GroupLayout(textsMenuPanel);
        textsMenuPanel.setLayout(textsMenuPanelLayout);
        textsMenuPanelLayout.setHorizontalGroup(
                textsMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(textsMenuPanelLayout.createSequentialGroup()
                                .addGap(100, 100, 100)
                                .addGroup(textsMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(textosScrollPane)
                                        .addComponent(textosComboBox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(54, 54, 54)
                                .addGroup(textsMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(exportTextButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(importTextButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(editTextButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(deleteTextButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(createTextButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(119, Short.MAX_VALUE))
        );
        textsMenuPanelLayout.setVerticalGroup(
                textsMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, textsMenuPanelLayout.createSequentialGroup()
                                .addContainerGap(123, Short.MAX_VALUE)
                                .addComponent(textosComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(textsMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(textsMenuPanelLayout.createSequentialGroup()
                                                .addComponent(createTextButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(deleteTextButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(editTextButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(importTextButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(exportTextButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(textosScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(65, 65, 65))
        );

        getContentPane().add(textsMenuPanel, "card5");

        menuBar.setBackground(new java.awt.Color(204, 204, 255));
        menuBar.setBorder(null);
        menuBar.setMaximumSize(new java.awt.Dimension(650, 40));
        menuBar.setMinimumSize(new java.awt.Dimension(650, 40));
        menuBar.setPreferredSize(new java.awt.Dimension(650, 40));

        userMenu.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        userMenu.setText("User");
        userMenu.setToolTipText("");
        userMenu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        userMenu.setMinimumSize(new java.awt.Dimension(130, 20));
        userMenu.setPreferredSize(new java.awt.Dimension(130, 20));
        userMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userMenuMouseClicked(evt);
            }
        });
        menuBar.add(userMenu);

        alfabetosMenu.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        alfabetosMenu.setText("Alfabetos");
        alfabetosMenu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        alfabetosMenu.setPreferredSize(new java.awt.Dimension(130, 20));
        alfabetosMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                alfabetosMenuMouseClicked(evt);
            }
        });
        menuBar.add(alfabetosMenu);

        listasMenu.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        listasMenu.setText("Listas de palabras");
        listasMenu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        listasMenu.setPreferredSize(new java.awt.Dimension(130, 20));
        listasMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listasMenuMouseClicked(evt);
            }
        });
        menuBar.add(listasMenu);

        tecladosMenu.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tecladosMenu.setText("Teclados");
        tecladosMenu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tecladosMenu.setMinimumSize(new java.awt.Dimension(130, 20));
        tecladosMenu.setPreferredSize(new java.awt.Dimension(130, 20));
        tecladosMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tecladosMenuMouseClicked(evt);
            }
        });
        menuBar.add(tecladosMenu);

        textosMenu.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        textosMenu.setText("Textos");
        textosMenu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textosMenu.setPreferredSize(new java.awt.Dimension(130, 20));
        textosMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                textosMenuMouseClicked(evt);
            }
        });
        menuBar.add(textosMenu);

        setJMenuBar(menuBar);

        pack();
    }

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {
        logoutConfirmationView logConfirm = new logoutConfirmationView(cp);
        logConfirm.setVisible(true);
        logConfirm.setLocationRelativeTo(null);
    }

    private void userMenuMouseClicked(java.awt.event.MouseEvent evt) {
        userMenuPanel.setVisible(true);
        welcomePanel.setVisible(false);
        alphabetsMenuPanel.setVisible(false);
        listsMenuPanel.setVisible(false);
        keyboardsMenuPanel.setVisible(false);
        textsMenuPanel.setVisible(false);
    }

    private void alfabetosMenuMouseClicked(java.awt.event.MouseEvent evt) {
        alphabetsMenuPanel.setVisible(true);
        welcomePanel.setVisible(false);
        userMenuPanel.setVisible(false);
        listsMenuPanel.setVisible(false);
        keyboardsMenuPanel.setVisible(false);
        textsMenuPanel.setVisible(false);
    }

    private void listasMenuMouseClicked(java.awt.event.MouseEvent evt) {
        listsMenuPanel.setVisible(true);
        welcomePanel.setVisible(false);
        userMenuPanel.setVisible(false);
        alphabetsMenuPanel.setVisible(false);
        keyboardsMenuPanel.setVisible(false);
        textsMenuPanel.setVisible(false);
    }

    private void tecladosMenuMouseClicked(java.awt.event.MouseEvent evt) {
        iniTeclados();
        keyboardsMenuPanel.setVisible(true);
        welcomePanel.setVisible(false);
        userMenuPanel.setVisible(false);
        alphabetsMenuPanel.setVisible(false);
        listsMenuPanel.setVisible(false);
        textsMenuPanel.setVisible(false);
    }

    private void textosMenuMouseClicked(java.awt.event.MouseEvent evt) {
        textsMenuPanel.setVisible(true);
        welcomePanel.setVisible(false);
        userMenuPanel.setVisible(false);
        alphabetsMenuPanel.setVisible(false);
        listsMenuPanel.setVisible(false);
        keyboardsMenuPanel.setVisible(false);
    }

    private void changeUsernameButtonActionPerformed(java.awt.event.ActionEvent evt) {
        cp.getNewUsername();
    }

    private void changePasswordButtonActionPerformed(java.awt.event.ActionEvent evt) {
        cp.getNewPassword();
    }

    private void changeMailButtonActionPerformed(java.awt.event.ActionEvent evt) {
        cp.getNewMail();
    }

    private void deleteUserButtonActionPerformed(java.awt.event.ActionEvent evt) {
        deleteWarningView warning = new deleteWarningView(cp, usernameLabel.getText(), "User");
        warning.setVisible(true);
        warning.setLocationRelativeTo(null);
    }

    private void createAlfabetoButtonActionPerformed(java.awt.event.ActionEvent evt) {
        crearAlfabetoView crearAlfabeto = new crearAlfabetoView(cp);
        crearAlfabeto.setVisible(true);
        crearAlfabeto.setLocationRelativeTo(null);
    }

    private void deleteAlfabetoButtonActionPerformed(java.awt.event.ActionEvent evt) {
        int rowIndex = alfabetosTable.getSelectedRow();
        if (rowIndex >= 0) {
            String nombreAlfabeto = alfabetosTable.getValueAt(rowIndex, 0).toString();
            deleteWarningView warning = new deleteWarningView(cp, nombreAlfabeto, "Alfabeto");
            warning.setVisible(true);
            warning.setLocationRelativeTo(null);
        }
    }

    private void editAlfabetoButtonActionPerformed(java.awt.event.ActionEvent evt) {
        int rowIndex = alfabetosTable.getSelectedRow();
        if (rowIndex >= 0) {
            String nombreAlfabeto = alfabetosTable.getValueAt(rowIndex, 0).toString();
            String alfabeto = alfabetosTable.getValueAt(rowIndex, 1).toString();
            editarAlfabetoView editAlfabeto = new editarAlfabetoView(cp, nombreAlfabeto, alfabeto);
            editAlfabeto.setVisible(true);
            editAlfabeto.setLocationRelativeTo(null);
        }
    }

    private void importAlfabetoButtonActionPerformed(java.awt.event.ActionEvent evt) {
        JFileChooser fileChooser = new JFileChooser();

        // Muestra el diálogo para seleccionar un archivo
        int seleccion = fileChooser.showOpenDialog(this);

        if (seleccion == JFileChooser.APPROVE_OPTION) {
            // El usuario seleccionó un archivo
            String path = fileChooser.getSelectedFile().getAbsolutePath();
            JOptionPane.showMessageDialog(this, "Directorio seleccionado: " + path);

            String[] paths = path.split("[\\\\/]");

            System.out.println(path);
            System.out.println(paths[paths.length-1]);

            cp.importarAlfabeto(path, paths[paths.length-1]);

        }

    }

    private void exportAlfabetoButtonActionPerformed(java.awt.event.ActionEvent evt) {
        int rowIndex = alfabetosTable.getSelectedRow();
        if (rowIndex >= 0) {
            String nombre = alfabetosTable.getValueAt(rowIndex, 0).toString();
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            // Muestra el diálogo para seleccionar un archivo
            int seleccion = fileChooser.showOpenDialog(this);

            if (seleccion == JFileChooser.APPROVE_OPTION) {
                // El usuario seleccionó un archivo
                String path = fileChooser.getSelectedFile().getAbsolutePath();
                JOptionPane.showMessageDialog(this, "Directorio seleccionado: " + path);

                cp.exportarAlfabeto(path, nombre);
            }
        }
    }

    private void textosComboBoxActionPerformed(java.awt.event.ActionEvent evt) {
        if (textosComboBox.getSelectedIndex() < 1) textArea.setText("");
        else {
            String textName = textosComboBox.getSelectedItem().toString();
            textArea.setText(cp.getText(textName));
        }
    }

    private void createTextButtonActionPerformed(java.awt.event.ActionEvent evt) {
        crearTextoView createText = new crearTextoView(cp);
        createText.setVisible(true);
        createText.setLocationRelativeTo(null);
    }

    private void deleteTextButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if (textosComboBox.getSelectedIndex() >= 1) {
            String textName = textosComboBox.getSelectedItem().toString();
            deleteWarningView warning = new deleteWarningView(cp, textName, "Texto");
            warning.setVisible(true);
            warning.setLocationRelativeTo(null);
        }
    }

    private void editTextButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if (textosComboBox.getSelectedIndex() >= 1) {
            String nombreTexto = textosComboBox.getSelectedItem().toString();
            String texto = cp.getText(nombreTexto);
            editarTextoView editTexto = new editarTextoView(cp, nombreTexto, texto);
            editTexto.setVisible(true);
            editTexto.setLocationRelativeTo(null);
        }
    }

    private void importTextButtonActionPerformed(java.awt.event.ActionEvent evt) {
        JFileChooser fileChooser = new JFileChooser();

        // Muestra el diálogo para seleccionar un archivo
        int seleccion = fileChooser.showOpenDialog(this);

        if (seleccion == JFileChooser.APPROVE_OPTION) {
            // El usuario seleccionó un archivo
            String path = fileChooser.getSelectedFile().getAbsolutePath();
            JOptionPane.showMessageDialog(this, "Directorio seleccionado: " + path);

            String[] paths = path.split("[\\\\/]");

            System.out.println(path);
            System.out.println(paths[paths.length-1]);

            cp.importarTexto(path, paths[paths.length-1]);

        }
    }

    private void exportTextButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if (textosComboBox.getSelectedIndex() >= 1) {
            String nombreTexto = textosComboBox.getSelectedItem().toString();
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            // Muestra el diálogo para seleccionar un archivo
            int seleccion = fileChooser.showOpenDialog(this);

            if (seleccion == JFileChooser.APPROVE_OPTION) {
                // El usuario seleccionó un archivo
                String path = fileChooser.getSelectedFile().getAbsolutePath();
                JOptionPane.showMessageDialog(this, "Directorio seleccionado: " + path);

                cp.exportarTexto(path, nombreTexto);
            }
        }
    }

    private void listsComboBoxActionPerformed(java.awt.event.ActionEvent evt) {
        HashMap<String, Integer> listaP = cp.getLista(listsComboBox.getSelectedItem().toString());

        if (listsComboBox.getSelectedIndex() < 1) {
            DefaultTableModel model = new DefaultTableModel(new String[]{"Palabra", "Frecuencia"}, 0);
            listsTable.setModel(model);
        }
        else {
            DefaultTableModel model = new DefaultTableModel(new String[]{"Palabra", "Frecuencia"}, listaP.size());
            int i = 0;
            for (Map.Entry<String, Integer> entry : listaP.entrySet()) {
                model.setValueAt(entry.getKey(), i, 0);
                model.setValueAt(entry.getValue(), i++, 1);
            }
            listsTable.setModel(model);
        }
    }

    private void createListButtonActionPerformed(java.awt.event.ActionEvent evt) {
        crearListaView createList = new crearListaView(cp);
        createList.setVisible(true);
        createList.setLocationRelativeTo(null);
    }

    private void deleteListButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if (listsComboBox.getSelectedIndex() >= 1) {
            String listName = listsComboBox.getSelectedItem().toString();
            deleteWarningView warning = new deleteWarningView(cp, listName, "Lista");
            warning.setVisible(true);
            warning.setLocationRelativeTo(null);
        }
    }

    private void editListButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if (listsComboBox.getSelectedIndex() >= 1) {
            String nombrelista = listsComboBox.getSelectedItem().toString();
            HashMap<String, Integer> lista = cp.getLista(nombrelista);
            editarListaView editlista = new editarListaView(cp, nombrelista, lista);
            editlista.setVisible(true);
            editlista.setLocationRelativeTo(null);
        }
    }

    private void importListButtonActionPerformed(java.awt.event.ActionEvent evt) {
        JFileChooser fileChooser = new JFileChooser();

        // Muestra el diálogo para seleccionar un archivo
        int seleccion = fileChooser.showOpenDialog(this);

        if (seleccion == JFileChooser.APPROVE_OPTION) {
            // El usuario seleccionó un archivo
            String path = fileChooser.getSelectedFile().getAbsolutePath();
            JOptionPane.showMessageDialog(this, "Directorio seleccionado: " + path);

            String[] paths = path.split("[\\\\/]");

            System.out.println(path);
            System.out.println(paths[paths.length-1]);

            cp.importarLista(path, paths[paths.length-1]);

        }
    }

    private void exportListButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if (listsComboBox.getSelectedIndex() >= 1) {
            String nombre = listsComboBox.getSelectedItem().toString();
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            // Muestra el diálogo para seleccionar un archivo
            int seleccion = fileChooser.showOpenDialog(this);

            if (seleccion == JFileChooser.APPROVE_OPTION) {
                // El usuario seleccionó un archivo
                String path = fileChooser.getSelectedFile().getAbsolutePath();
                JOptionPane.showMessageDialog(this, "Directorio seleccionado: " + path);

                cp.exportarLista(path, nombre);
            }
        }
    }

    private void createKeyboardButtonActionPerformed(java.awt.event.ActionEvent evt) {
        ArrayList<String> listas = new ArrayList<>();
        cp.getNombresListas(listas);
        ArrayList<String> textos = new ArrayList<>();
        cp.getNombresTextos(textos);
        ArrayList<String> alfabetos = new ArrayList<>();
        cp.getNombresAlfabetos(alfabetos);

        crearTecladoView createTeclado = new crearTecladoView(cp, alfabetos, textos, listas);
        createTeclado.setVisible(true);
        createTeclado.setLocationRelativeTo(null);
    }

    private void deleteKeyboardButtonActionPerformed(java.awt.event.ActionEvent evt) {
        int rowIndex = keyboardTable.getSelectedRow();
        if (rowIndex >= 0) {
            String nombreTeclado = keyboardTable.getValueAt(rowIndex, 0).toString();
            deleteWarningView warning = new deleteWarningView(cp, nombreTeclado, "Teclado");
            warning.setVisible(true);
            warning.setLocationRelativeTo(null);
        }
    }

    private void editKeyboardButtonActionPerformed(java.awt.event.ActionEvent evt) {
        int rowIndex = keyboardTable.getSelectedRow();
        if (rowIndex >= 0) {
            String nombreTeclado = keyboardTable.getValueAt(rowIndex, 0).toString();
            editarTecladoView editTeclado = new editarTecladoView(cp, nombreTeclado);
            editTeclado.setVisible(true);
            editTeclado.setLocationRelativeTo(null);
        }
    }

    private void exportKeyboardButtonActionPerformed(java.awt.event.ActionEvent evt) {
        int rowIndex = keyboardTable.getSelectedRow();
        if (rowIndex >= 0) {
            String nombre = keyboardTable.getValueAt(rowIndex, 0).toString();
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            // Muestra el diálogo para seleccionar un archivo
            int seleccion = fileChooser.showOpenDialog(this);

            if (seleccion == JFileChooser.APPROVE_OPTION) {
                // El usuario seleccionó un archivo
                String path = fileChooser.getSelectedFile().getAbsolutePath();
                JOptionPane.showMessageDialog(this, "Directorio seleccionado: " + path);

                cp.exportarTeclado(path, nombre);
            }

        }
    }

    private void seeKeyboardButtonActionPerformed(java.awt.event.ActionEvent evt) {
        int rowIndex = keyboardTable.getSelectedRow();
        if (rowIndex >= 0) {
            ArrayList<ArrayList<Character>> layout = new ArrayList<>();
            cp.getTeclado(keyboardTable.getValueAt(rowIndex, 0).toString(), layout);
            layoutView view = new layoutView(layout.size(), layout);
            view.setVisible(true);
            view.setLocationRelativeTo(null);
        }
    }
}