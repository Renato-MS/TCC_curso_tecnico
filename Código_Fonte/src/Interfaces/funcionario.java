package Interfaces;

import digital.EnrollmentForm;
import digital.VerificationForm;
import javax.swing.*;
import conexaoBancoDeDados.*;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.sql.*;
import javax.swing.text.MaskFormatter;

public class funcionario extends JDialog {

    public conexaoMySql aluno = new conexaoMySql();
    public int valor = 0, cont = 0, opc = 0;
    public String valor1;
    public String nome, sqlInsert, sqlDelete, sqlUpdate;
    public ImageIcon foto, foto1;
    public File caminho;
    public JFileChooser fotografia;
    public MaskFormatter maskRG, maskData, maskTelefone;
    pesquisa objeto;

    public funcionario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().createImage(getClass().getResource("/icones/funcionarios.png")));
        objeto = new pesquisa(null, rootPaneCheckingEnabled);
        objeto.rg = "fun_rg";
        objeto.nome = "fun_nome";
        objeto.tabela = "funcionario";
        objeto.img = "fun_foto";
        boolean eventuaCenexao = aluno.eventuaCenexao();
        aluno.executaComandosSql("SELECT * FROM funcionario;");
        contaRegistros();
        btGravar.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        btPrimeiroRegistro = new javax.swing.JButton();
        btRegistroAnterior = new javax.swing.JButton();
        btProximoRegistro = new javax.swing.JButton();
        btUltimoRegistro = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        btExcluir = new javax.swing.JButton();
        btNovo = new javax.swing.JButton();
        btGravar = new javax.swing.JButton();
        btAtualizar = new javax.swing.JButton();
        btPesquisar = new javax.swing.JButton();
        jpPrincipal = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLnome = new javax.swing.JLabel();
        tf_nome = new javax.swing.JTextField();
        jLRg = new javax.swing.JLabel();
        jLtelefone = new javax.swing.JLabel();
        try
        {
            maskRG = new MaskFormatter("########.*");
        }

        catch(Exception erroIO) {}
        tf_rg = new JFormattedTextField(maskRG);
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cb_sexo = new javax.swing.JComboBox();
        tf_data = new javax.swing.JTextField();
        tf_entrada = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel5 = new javax.swing.JPanel();
        lbFoto = new javax.swing.JLabel();
        btFoto = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lbTotalReg = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        btGravarDigital = new javax.swing.JButton();
        btVerificarDigital = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Funcionário");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setAutoscrolls(true);
        jPanel1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jPanel1AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel7.setLayout(new javax.swing.BoxLayout(jPanel7, javax.swing.BoxLayout.LINE_AXIS));

        btPrimeiroRegistro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Anterior/primeiroRed.png"))); // NOI18N
        btPrimeiroRegistro.setToolTipText("Primeiro Registro");
        btPrimeiroRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPrimeiroRegistroActionPerformed(evt);
            }
        });
        jPanel7.add(btPrimeiroRegistro);

        btRegistroAnterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Anterior/anteriorRed.png"))); // NOI18N
        btRegistroAnterior.setToolTipText("Registro Anterior");
        btRegistroAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRegistroAnteriorActionPerformed(evt);
            }
        });
        jPanel7.add(btRegistroAnterior);

        btProximoRegistro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/proximo/proximoRed.png"))); // NOI18N
        btProximoRegistro.setToolTipText("Próximo Registro");
        btProximoRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btProximoRegistroActionPerformed(evt);
            }
        });
        jPanel7.add(btProximoRegistro);

        btUltimoRegistro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/proximo/ultimoRed.png"))); // NOI18N
        btUltimoRegistro.setToolTipText("Último Registro");
        btUltimoRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btUltimoRegistroActionPerformed(evt);
            }
        });
        jPanel7.add(btUltimoRegistro);

        jPanel8.setLayout(new java.awt.BorderLayout());

        btExcluir.setMnemonic('E');
        btExcluir.setText("Excluir");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });
        jPanel8.add(btExcluir, java.awt.BorderLayout.PAGE_START);

        btNovo.setMnemonic('N');
        btNovo.setText("    Novo");
        btNovo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btNovoMousePressed(evt);
            }
        });
        btNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoActionPerformed(evt);
            }
        });
        jPanel8.add(btNovo, java.awt.BorderLayout.CENTER);

        btGravar.setMnemonic('S');
        btGravar.setText("Salvar");
        btGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGravarActionPerformed(evt);
            }
        });
        jPanel8.add(btGravar, java.awt.BorderLayout.PAGE_END);

        btAtualizar.setMnemonic('A');
        btAtualizar.setText("     Alterar    ");
        btAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAtualizarActionPerformed(evt);
            }
        });
        jPanel8.add(btAtualizar, java.awt.BorderLayout.LINE_END);

        btPesquisar.setMnemonic('P');
        btPesquisar.setText("Pesquisar");
        btPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisarActionPerformed(evt);
            }
        });
        jPanel8.add(btPesquisar, java.awt.BorderLayout.LINE_START);

        jPanel7.add(jPanel8);

        jpPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        jpPrincipal.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Dados do funcionário", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 0, 12), new java.awt.Color(0, 0, 255))); // NOI18N

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLnome.setText("Nome:");

        tf_nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_nomeActionPerformed(evt);
            }
        });

        jLRg.setText("RG:");

        jLtelefone.setText("Data");

        jLabel3.setText("Entrada");

        jLabel1.setText("Sexo:");

        cb_sexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Masculino", "Feminino" }));

        tf_data.setEditable(false);

        tf_entrada.setEditable(false);

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cb_sexo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLnome, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLRg, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_rg)
                    .addComponent(tf_nome, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE))
                .addGap(14, 14, 14)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tf_data)
                    .addComponent(tf_entrada, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                    .addComponent(jLabel3)
                    .addComponent(jLtelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tf_entrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLnome)
                                    .addComponent(jLtelefone))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tf_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tf_data, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jLRg)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tf_rg, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cb_sexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {tf_nome, tf_rg});

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbFoto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        lbFoto.setOpaque(true);

        btFoto.setText("Foto");
        btFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFotoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btFoto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                    .addComponent(lbFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btFoto)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setText("Total de registros: ");

        lbTotalReg.setText("?");

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btGravarDigital.setText("Gravar Digital");
        btGravarDigital.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGravarDigitalActionPerformed(evt);
            }
        });

        btVerificarDigital.setText("Verificar Digital");
        btVerificarDigital.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVerificarDigitalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btGravarDigital, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                    .addComponent(btVerificarDigital, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btGravarDigital)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btVerificarDigital)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jpPrincipalLayout = new javax.swing.GroupLayout(jpPrincipal);
        jpPrincipal.setLayout(jpPrincipalLayout);
        jpPrincipalLayout.setHorizontalGroup(
            jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPrincipalLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpPrincipalLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(lbTotalReg, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61)
                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jpPrincipalLayout.setVerticalGroup(
            jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPrincipalLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(6, 6, 6)
                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpPrincipalLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel2))
                    .addGroup(jpPrincipalLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(lbTotalReg)))
                .addGap(50, 50, 50))
            .addGroup(jpPrincipalLayout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jpPrincipal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 674, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jpPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jpPrincipal.getAccessibleContext().setAccessibleName("Dados do Funcionario");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        java.awt.Dimension dialogSize = getSize();
        setLocation((screenSize.width-dialogSize.width)/2,(screenSize.height-dialogSize.height)/2);
    }// </editor-fold>//GEN-END:initComponents

    private void btGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGravarActionPerformed
       
        try {

            if (tf_nome.getText().equals("") || tf_rg.getText().equals("")) {

                throw new IllegalAccessError();

            } else {

                btGravar.setEnabled(false);
                gravarDados();

            }

        } catch (IllegalAccessError erroDado) {

            JOptionPane.showMessageDialog(this, "Preencha Todos os Campos!", "", 2);
            tf_nome.requestFocus();
        }
    }

    private void gravarDados() {
        utilitarios.DataHora objhora = new utilitarios.DataHora();
        objhora.leHora();
        try {

            sqlInsert = "INSERT INTO funcionario (fun_nome,fun_rg,fun_sexo,"
                    + "fun_data,fun_hora_entrada,fun_foto) value('"
                    + tf_nome.getText() + "','"
                    + tf_rg.getText() + "','"
                    + cb_sexo.getSelectedItem() + "','"
                    + objhora.getDataHoraParaBanco() + "','"
                    + objhora.getHora()+ "','"
                   // + tf_saida.getText() + "','"
                    + valor1 + "')";

            aluno.statement.executeUpdate(sqlInsert);
            aluno.resultset = aluno.statement.executeQuery("SELECT * FROM "
                    + "funcionario ORDER BY fun_nome");
            aluno.resultset.first();
            JOptionPane.showMessageDialog(this, "Cadastro Efetuado Com Sucesso!", "", 1);
            mostrarDados();

            contaRegistros();

        } catch (SQLException SQLError) {

            JOptionPane.showMessageDialog(this, "Erro Dados Não Gravados!\n"
                    + SQLError, "Erro", 0);
        }

    }//GEN-LAST:event_btGravarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        TelaPrincipal obj = new TelaPrincipal();
        obj.iniciaVerificacao();
    }//GEN-LAST:event_formWindowClosing

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed

        lbFoto.setIcon(null);
        jPanel5.repaint();

        btGravar.setEnabled(true);
        tf_nome.setText("");

        tf_data.setText("");
        tf_entrada.setText("");

        tf_rg.setText("");
        tf_data.setText("");
        cb_sexo.setSelectedItem("Masculino");

//        tf_saida.setText("");
        //  cbPeriodo.setSelectedItem("Manhã");
        valor1 = null;
        tf_rg.setText(null);

        //  tf_rg.requestFocus();
        tf_nome.requestFocus();

    }//GEN-LAST:event_btNovoActionPerformed

    private void btAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAtualizarActionPerformed

        try {

            String sqlDelete = "SELECT * FROM funcionario WHERE fun_codigo = " + aluno.resultset.getString("fun_codigo");
            aluno.executaComandosSql(sqlDelete);
            aluno.resultset.first();

            nome = "Alterar o Registro do Aluno(a): \n" + aluno.resultset.getString("fun_nome") + "?";
            int opc = JOptionPane.showConfirmDialog(this, nome, "Confirmação", JOptionPane.YES_NO_OPTION, 3);

            if (opc != 1) {

                sqlUpdate = "UPDATE funcionario SET "
                        + "fun_nome = '" + tf_nome.getText() + "',"
                        + "fun_rg   ='" + tf_rg.getText() + "',"
                        + "fun_sexo = '" + String.valueOf(cb_sexo.getSelectedItem()) + "',"
                        + "fun_data = '" + tf_data.getText() + "',"
                        + "fun_hora_entrada = '" + tf_entrada.getText() + "'"
                        + " where fun_codigo = " + aluno.resultset.getString("fun_codigo");


                // + "alu_nome = '" + tf_nome.getText() + "',"
                // + "alu_rg = '" + tf_rg.getText() + "',"
                // + "alu_telefone = '" + tf_data.getText() + "',"
                // + "alu_sexo = '" + String.valueOf(cbSexo.getSelectedItem()) + "',"
                // + "alu_periodo = '" + String.valueOf(cbPeriodo.getSelectedItem()) + "',"
                // + "alu_modulo = '" + String.valueOf(cbModulo.getSelectedItem()) + "',"
                // + "alu_curso = '" + tfCurso.getText() + "',"
                // + "alu_nascimento = '" + tfNascimento.getText() + "' "
                // + "WHERE alu_codigo = " + aluno.resultset.getString("alu_codigo");

                aluno.statement.executeUpdate(sqlUpdate);
                aluno.resultset = aluno.statement.executeQuery("SELECT * FROM funcionario ORDER BY fun_nome");
                aluno.resultset.first();
                JOptionPane.showMessageDialog(this, "Registro Atualizado Com Sucesso!", "Informação", 1);
                mostrarDados();

            }

        } catch (Exception SQLError) {

            JOptionPane.showMessageDialog(this, "Erro ao Atualizar Registro!\n" + SQLError, "Erro", 0);
        }
    }//GEN-LAST:event_btAtualizarActionPerformed

    private void contaRegistros() {
        try {
            while (aluno.resultset.next()) {
                cont++;
            }

            lbTotalReg.setText(String.valueOf(cont));
            jpPrincipal.repaint();

            cont = 0;
        } catch (SQLException erroSQL) {
        }
    }

    private void btUltimoRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btUltimoRegistroActionPerformed

        try {

            aluno.resultset.last();
            mostrarDados();

        } catch (SQLException SQLError) {

            JOptionPane.showMessageDialog(this, "Erro Dados Não Localizados!\n" + SQLError, "Erro", 0);
        }
    }//GEN-LAST:event_btUltimoRegistroActionPerformed

    private void btPrimeiroRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPrimeiroRegistroActionPerformed

        try {

            aluno.resultset.first();
            mostrarDados();

        } catch (SQLException SQLError) {

            JOptionPane.showMessageDialog(this, "Erro Dados Não Localizados!\n" + SQLError, "Erro", 0);
        }
    }//GEN-LAST:event_btPrimeiroRegistroActionPerformed

    private void btNovoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btNovoMousePressed
    }//GEN-LAST:event_btNovoMousePressed

    private void btRegistroAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRegistroAnteriorActionPerformed

        try {

            aluno.resultset.previous();
            valor = 1;
            mostrarDados();

        } catch (SQLException SQLError) {

            JOptionPane.showMessageDialog(this, "Dados Não Localizados!\n" + SQLError, "Erro", 0);
        }
}//GEN-LAST:event_btRegistroAnteriorActionPerformed

    private void btProximoRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btProximoRegistroActionPerformed

        try {

            aluno.resultset.next();
            valor = 2;
            mostrarDados();

        } catch (SQLException SQLError) {

            JOptionPane.showMessageDialog(this, "Dados Não Localizados!\n" + SQLError, "Erro", 0);
        }
}//GEN-LAST:event_btProximoRegistroActionPerformed

    private void jPanel1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jPanel1AncestorAdded
    }//GEN-LAST:event_jPanel1AncestorAdded

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed

        try {

            sqlDelete = "SELECT * FROM funcionario WHERE fun_codigo = " + aluno.resultset.getString("fun_codigo");
            aluno.executaComandosSql(sqlDelete);
            aluno.resultset.first();

            nome = "Apagar o Registro do Aluno(a): \n" + aluno.resultset.getString("fun_nome") + "?";
            opc = JOptionPane.showConfirmDialog(this, nome, "Confirmação", JOptionPane.YES_NO_OPTION, 3);

            if (opc != 1) {

                sqlDelete = "DELETE FROM funcionario WHERE fun_codigo = " + aluno.resultset.getString("fun_codigo");
                aluno.statement.executeUpdate(sqlDelete);
                aluno.resultset = aluno.statement.executeQuery("SELECT * FROM funcionario ORDER BY fun_nome");
                aluno.resultset.first();
                JOptionPane.showMessageDialog(this, "Registro Excluído Com Êxito!\n", "Informação", 1);
                mostrarDados();
            }

        } catch (Exception erro) {

            JOptionPane.showMessageDialog(null, "Erro! Não Foi Possível Excluir o Registro.", "Erro", 0);
        }

    }//GEN-LAST:event_btExcluirActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

        java.awt.event.ActionEvent e = null;

        btPrimeiroRegistroActionPerformed(e);
    }//GEN-LAST:event_formWindowOpened

    private void btPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisarActionPerformed

        objeto.setVisible(rootPaneCheckingEnabled);

    }//GEN-LAST:event_btPesquisarActionPerformed

    private void btFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFotoActionPerformed

         fotografia = new JFileChooser();          if (fotografia.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {             caminho = fotografia.getSelectedFile();             valor1 = String.valueOf(caminho);             valor1 = valor1.replace("\\", "/");             foto1 = new ImageIcon(valor1);              lbFoto.setIcon(new ImageIcon(foto1.getImage().getScaledInstance(178, 171, Image.SCALE_AREA_AVERAGING)));         }     }//GEN-LAST:event_btFotoActionPerformed

        private void tf_nomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_nomeActionPerformed
}//GEN-LAST:event_tf_nomeActionPerformed

        private void btGravarDigitalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGravarDigitalActionPerformed
            EnrollmentForm obj = new EnrollmentForm(null);
            try {
                if (tf_nome.getText().equals("") || tf_rg.getText().equals("") || tf_nome.getText().equals("") || cb_sexo.getSelectedItem() == "-") {
                    throw new IllegalAccessError();
                }
                obj.nomeDigital = tf_rg.getText();
                obj.pasta = "funcionario";
                obj.setVisible(true);
            } catch (IllegalAccessError erro) {
                JOptionPane.showMessageDialog(null, "Verifique Se Todos os Campos Foram Preenchidos!", "Alerta", 2);
            }
}//GEN-LAST:event_btGravarDigitalActionPerformed

        private void btVerificarDigitalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVerificarDigitalActionPerformed
            VerificationForm objVerifica = new VerificationForm(null);
            objVerifica.conet.eventuaCenexao();
            objVerifica.RG = tf_rg.getText();
            objVerifica.setVisible(true);
}//GEN-LAST:event_btVerificarDigitalActionPerformed

    private void mostrarDados() throws SQLException {

        try {

            foto = new ImageIcon(aluno.resultset.getString("fun_foto"));

            lbFoto.setIcon(new ImageIcon(foto.getImage().getScaledInstance(224, 178, Image.SCALE_AREA_AVERAGING)));

            tf_nome.setText(aluno.resultset.getString("fun_nome"));
            tf_rg.setText(aluno.resultset.getString("fun_rg"));
            tf_data.setText(aluno.resultset.getString("fun_data"));
            tf_entrada.setText(aluno.resultset.getString("fun_hora_entrada"));
            //tf_saida.setText(aluno.resultset.getString("fun_hora_saida"));
            //tf_data.setText(aluno.resultset.getString("alu_telefone"));

            cb_sexo.setSelectedItem(aluno.resultset.getString("fun_sexo"));
            // cbPeriodo.setSelectedItem(aluno.resultset.getString("alu_periodo"));
            // cbSexo.setSelectedItem(aluno.resultset.getString("alu_sexo"));

        } catch (SQLException TT) {

            if (valor == 1) {

                aluno.resultset.first();
                mostrarDados();
                JOptionPane.showMessageDialog(this, "Primeiro Registro!", "Alerta", 2);

            } else if (valor == 2) {

                aluno.resultset.last();
                mostrarDados();
                JOptionPane.showMessageDialog(this, "Último Registro!", "Alerta", 2);
            }
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                funcionario dialog = new funcionario(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAtualizar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btFoto;
    private javax.swing.JButton btGravar;
    private javax.swing.JButton btGravarDigital;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btPesquisar;
    private javax.swing.JButton btPrimeiroRegistro;
    private javax.swing.JButton btProximoRegistro;
    private javax.swing.JButton btRegistroAnterior;
    private javax.swing.JButton btUltimoRegistro;
    private javax.swing.JButton btVerificarDigital;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cb_sexo;
    private javax.swing.JLabel jLRg;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLnome;
    private javax.swing.JLabel jLtelefone;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel jpPrincipal;
    private javax.swing.JLabel lbFoto;
    private javax.swing.JLabel lbTotalReg;
    private javax.swing.JTextField tf_data;
    private javax.swing.JTextField tf_entrada;
    private javax.swing.JTextField tf_nome;
    private javax.swing.JFormattedTextField tf_rg;
    // End of variables declaration//GEN-END:variables
}
