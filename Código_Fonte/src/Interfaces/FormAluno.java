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

public class FormAluno extends JDialog {

    public conexaoMySql aluno = new conexaoMySql();
    public int valor = 0, cont = 0, opc = 0;
    public String valor1;
    public String nome, sqlInsert, sqlDelete, sqlUpdate;
    public ImageIcon foto, foto1;
    public File caminho;
    public JFileChooser fotografia;
    public MaskFormatter maskRG, maskData, maskTelefone;
    pesquisa objeto;

    public FormAluno(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().createImage(getClass().getResource("/icones/Botoes_5041_users_two_48.png")));
        objeto = new pesquisa(null, rootPaneCheckingEnabled);
        objeto.rg = "alu_rg";
        objeto.nome = "alu_nome";
        objeto.tabela = "aluno";
        objeto.img = "alu_foto";
        boolean eventuaCenexao = aluno.eventuaCenexao();
        aluno.executaComandosSql("SELECT * FROM aluno;");        
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
        tfNome = new javax.swing.JTextField();
        jLVeiculo = new javax.swing.JLabel();
        jLRg = new javax.swing.JLabel();
        jLtelefone = new javax.swing.JLabel();
        jRadioSim = new javax.swing.JRadioButton();
        jRadioNao = new javax.swing.JRadioButton();
        jLsexo = new javax.swing.JLabel();
        cbSexo = new javax.swing.JComboBox();
        try
        {
            maskRG = new MaskFormatter("########.*");
        }

        catch(Exception erroIO) {}
        tfRG = new JFormattedTextField(maskRG);
        new JFormattedTextField(maskRG);
        try {

            maskTelefone = new MaskFormatter("(##)####-####");
        }
        catch (Exception errorIO){}
        tfTelefone = new JFormattedTextField(maskTelefone);
        jPanel4 = new javax.swing.JPanel();
        jLcurso = new javax.swing.JLabel();
        tfCurso = new javax.swing.JTextField();
        jLmodulo = new javax.swing.JLabel();
        cbModulo = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLnascimento = new javax.swing.JLabel();
        cbPeriodo = new javax.swing.JComboBox();
        try {

            maskData = new MaskFormatter("##/##/####");

        } catch(Exception errorIO) {}
        tfNascimento = new JFormattedTextField(maskData);
        jPanel5 = new javax.swing.JPanel();
        lbFoto = new javax.swing.JLabel();
        btFoto = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        btGravarDigital = new javax.swing.JButton();
        btVerificarDigital = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lbTotalReg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Aluno");
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

        btPrimeiroRegistro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Anterior/primeiroGreen.png"))); // NOI18N
        btPrimeiroRegistro.setToolTipText("Primeiro Registro");
        btPrimeiroRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPrimeiroRegistroActionPerformed(evt);
            }
        });
        jPanel7.add(btPrimeiroRegistro);

        btRegistroAnterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Anterior/anteriorGreen.png"))); // NOI18N
        btRegistroAnterior.setToolTipText("Registro Anterior");
        btRegistroAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRegistroAnteriorActionPerformed(evt);
            }
        });
        jPanel7.add(btRegistroAnterior);

        btProximoRegistro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/proximo/proximoGreen.png"))); // NOI18N
        btProximoRegistro.setToolTipText("Próximo Registro");
        btProximoRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btProximoRegistroActionPerformed(evt);
            }
        });
        jPanel7.add(btProximoRegistro);

        btUltimoRegistro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/proximo/ultimoGreen.png"))); // NOI18N
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
        jpPrincipal.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Dados do Aluno", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 0, 12), new java.awt.Color(0, 0, 255))); // NOI18N

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLnome.setText("Nome:");

        tfNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNomeActionPerformed(evt);
            }
        });

        jLVeiculo.setText("Veículo:");

        jLRg.setText("RG:");

        jLtelefone.setText("Telefone:");

        buttonGroup1.add(jRadioSim);
        jRadioSim.setText("Sim");

        buttonGroup1.add(jRadioNao);
        jRadioNao.setSelected(true);
        jRadioNao.setText("Não");

        jLsexo.setText("Sexo:");

        cbSexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Masculino", "Feminino" }));
        cbSexo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSexoActionPerformed(evt);
            }
        });

        tfRG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfRGActionPerformed(evt);
            }
        });

        tfTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfTelefoneActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLnome, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLtelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(116, 116, 116))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(tfTelefone, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                                    .addComponent(tfNome, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE))
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLsexo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLRg, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfRG, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                            .addComponent(cbSexo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jRadioSim, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioNao, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLnome)
                    .addComponent(jLRg))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfRG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLtelefone)
                            .addComponent(jLsexo))
                        .addGap(26, 26, 26)))
                .addGap(18, 18, 18)
                .addComponent(jLVeiculo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioSim)
                    .addComponent(jRadioNao))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLcurso.setText("Curso:");

        jLmodulo.setText("Módulo:");

        cbModulo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1º Módulo", "2º Módulo", "3º Módulo", "1º Ano", "2º Ano", "3º Ano" }));

        jLabel1.setText("Período:");

        jLnascimento.setText("Data de Nascimento:");

        cbPeriodo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Manhã", "Tarde", "Noite" }));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLcurso)
                    .addComponent(jLmodulo)
                    .addComponent(cbModulo, 0, 180, Short.MAX_VALUE)
                    .addComponent(tfCurso))
                .addGap(59, 59, 59)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLnascimento, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addComponent(cbPeriodo, javax.swing.GroupLayout.Alignment.TRAILING, 0, 145, Short.MAX_VALUE))
                    .addComponent(tfNascimento, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLmodulo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbModulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLnascimento)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLcurso)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(29, Short.MAX_VALUE))
        );

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btFoto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                    .addComponent(lbFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(btGravarDigital, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                    .addComponent(btVerificarDigital, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE))
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

        jLabel2.setText("Total de registros: ");

        lbTotalReg.setText("?");

        javax.swing.GroupLayout jpPrincipalLayout = new javax.swing.GroupLayout(jpPrincipal);
        jpPrincipal.setLayout(jpPrincipalLayout);
        jpPrincipalLayout.setHorizontalGroup(
            jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpPrincipalLayout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jpPrincipalLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpPrincipalLayout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbTotalReg, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jpPrincipalLayout.setVerticalGroup(
            jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jpPrincipalLayout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jpPrincipalLayout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lbTotalReg))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 726, Short.MAX_VALUE)
                    .addComponent(jpPrincipal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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
        veiculo passaDadosVisitante = new veiculo(null);
        if(jRadioSim.isSelected()){
        try {

            if (tfNome.getText().equals("") || tfRG.getText().equals("") || tfNascimento.getText().equals("") || tfCurso.getText().equals("")) {

                throw new IllegalAccessError();

            } 
                passaDadosVisitante.nomeProprientario = tfNome.getText();
                passaDadosVisitante.rgProprietario = tfRG.getText();
                passaDadosVisitante.recebeDadosvisitate();
               
                passaDadosVisitante.setVisible(true);
                 btGravar.setEnabled(false);
                gravarDados();

        } catch (IllegalAccessError erroDado) {

            JOptionPane.showMessageDialog(this, "Preencha Todos os Campos!", "", 2);
            tfNome.requestFocus();
        }
        }else if(jRadioNao.isSelected()){
            btGravar.setEnabled(false);
                gravarDados();
        }
    }

    private void gravarDados() {
        utilitarios.DataHora objhora = new utilitarios.DataHora();
        objhora.leHora();
        try {

            sqlInsert = "INSERT INTO aluno (alu_nome, alu_foto, alu_rg, alu_curso, alu_nascimento, alu_telefone, alu_modulo, alu_sexo,alu_data,alu_hora_entrada, alu_periodo) VALUES ('"
                    + tfNome.getText().replace("'", "\'") + "','"
                    + valor1 + "','"
                    + tfRG.getText() + "','"
                    + tfCurso.getText() + "','"
                    + tfNascimento.getText() + "','"
                    + tfTelefone.getText() + "','"
                    + cbModulo.getSelectedItem() + "','"
                    + cbSexo.getSelectedItem() + "','"
                    +objhora.getDataHoraParaBanco()+"','"
                    +objhora.getHora()+"','"
                    + cbPeriodo.getSelectedItem() + "')";

            aluno.statement.executeUpdate(sqlInsert);
            aluno.resultset = aluno.statement.executeQuery("SELECT * FROM aluno ORDER BY alu_nome");
            aluno.resultset.first();
           
            mostrarDados();

            contaRegistros();
             if (jRadioNao.isSelected()) {
                    JOptionPane.showMessageDialog(this, "Cadastro Efetuado Com Sucesso!", "", 1);
                }

        } catch (SQLException SQLError) {

            JOptionPane.showMessageDialog(this, "Erro Dados Não Gravados!\n" + SQLError, "Erro", 0);
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
        tfCurso.setText("");

        tfNascimento.setText("");
        tfNome.setText("");

        tfRG.setText("");
        tfTelefone.setText("");
        cbModulo.setSelectedItem("1° Módulo");

        cbSexo.setSelectedItem("Masculino");
        cbPeriodo.setSelectedItem("Manhã");
        valor1 = null;
        tfRG.setText(null);

        tfRG.requestFocus();
        tfNome.requestFocus();

    }//GEN-LAST:event_btNovoActionPerformed

    private void btAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAtualizarActionPerformed

        try {

            String sqlDelete = "SELECT * FROM aluno WHERE alu_codigo = " + aluno.resultset.getString("alu_codigo");
            aluno.executaComandosSql(sqlDelete);
            aluno.resultset.first();

            nome = "Alterar o Registro do Aluno(a): \n" + aluno.resultset.getString("alu_nome") + "?";
            int opc = JOptionPane.showConfirmDialog(this, nome, "Confirmação", JOptionPane.YES_NO_OPTION, 3);

            if (opc != 1) {

                sqlUpdate = "UPDATE aluno SET "
                        + "alu_nome = '" + tfNome.getText() + "',"
                        + "alu_rg = '" + tfRG.getText() + "',"
                        + "alu_telefone = '" + tfTelefone.getText() + "',"
                        + "alu_sexo = '" + String.valueOf(cbSexo.getSelectedItem()) + "',"
                        + "alu_periodo = '" + String.valueOf(cbPeriodo.getSelectedItem()) + "',"
                        + "alu_modulo = '" + String.valueOf(cbModulo.getSelectedItem()) + "',"
                        + "alu_curso = '" + tfCurso.getText() + "',"
                        + "alu_nascimento = '" + tfNascimento.getText() + "' "
                        + "WHERE alu_codigo = " + aluno.resultset.getString("alu_codigo");

                aluno.statement.executeUpdate(sqlUpdate);
                aluno.resultset = aluno.statement.executeQuery("SELECT * FROM aluno ORDER BY alu_nome");
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

    private void btVerificarDigitalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVerificarDigitalActionPerformed
        VerificationForm objVerifica = new VerificationForm(null);
        objVerifica.conet.eventuaCenexao();
        objVerifica.RG = tfRG.getText();
        objVerifica.setVisible(true);
        

            //objVerifica.pasta = "aluno";

    }//GEN-LAST:event_btVerificarDigitalActionPerformed

    private void btGravarDigitalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGravarDigitalActionPerformed
        EnrollmentForm obj = new EnrollmentForm(null);
        try {

            if (tfNome.getText().equals("") || tfRG.getText().equals("")
                    || tfCurso.getText().equals("") || tfNascimento.getText().equals("")
                    || cbPeriodo.getSelectedItem() == "-" || cbSexo.getSelectedItem() == "-"
                    || cbModulo.getSelectedItem() == "-") {

                throw new IllegalAccessError();
            }

            obj.nomeDigital = tfRG.getText();            
            obj.pasta = "aluno";
            
            obj.setVisible(true);

        } catch (IllegalAccessError erro) {

            JOptionPane.showMessageDialog(null, "Verifique Se Todos os Campos Foram Preenchidos!", "Alerta", 2);
        }
    }//GEN-LAST:event_btGravarDigitalActionPerformed

    private void cbSexoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSexoActionPerformed
}//GEN-LAST:event_cbSexoActionPerformed

    private void tfNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNomeActionPerformed
    }//GEN-LAST:event_tfNomeActionPerformed

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

            sqlDelete = "SELECT * FROM aluno WHERE alu_codigo = " + aluno.resultset.getString("alu_codigo");
            aluno.executaComandosSql(sqlDelete);
            aluno.resultset.first();

            nome = "Apagar o Registro do Aluno(a): \n" + aluno.resultset.getString("alu_nome") + "?";
            opc = JOptionPane.showConfirmDialog(this, nome, "Confirmação", JOptionPane.YES_NO_OPTION, 3);

            if (opc != 1) {

                sqlDelete = "DELETE FROM aluno WHERE alu_codigo = " + aluno.resultset.getString("alu_codigo");
                aluno.statement.executeUpdate(sqlDelete);
                aluno.resultset = aluno.statement.executeQuery("SELECT * FROM aluno ORDER BY alu_nome");
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

    private void btFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFotoActionPerformed

        fotografia = new JFileChooser();

        if (fotografia.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            caminho = fotografia.getSelectedFile();
            valor1 = String.valueOf(caminho);
            valor1 = valor1.replace("\\", "/");
            foto1 = new ImageIcon(valor1);

            lbFoto.setIcon(new ImageIcon(foto1.getImage().getScaledInstance(178, 171, Image.SCALE_AREA_AVERAGING)));
        }
    }//GEN-LAST:event_btFotoActionPerformed

    private void tfRGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfRGActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfRGActionPerformed

    private void tfTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfTelefoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfTelefoneActionPerformed

    private void btPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisarActionPerformed
       
        objeto.setVisible(rootPaneCheckingEnabled);

    }//GEN-LAST:event_btPesquisarActionPerformed

    private void mostrarDados() throws SQLException {

        try {

            foto = new ImageIcon(aluno.resultset.getString("alu_foto"));

            lbFoto.setIcon(new ImageIcon(foto.getImage().getScaledInstance(189, 178, Image.SCALE_AREA_AVERAGING)));

            tfNome.setText(aluno.resultset.getString("alu_nome"));
            tfRG.setText(aluno.resultset.getString("alu_rg"));
            tfNascimento.setText(aluno.resultset.getString("alu_nascimento"));
            tfRG.setText(aluno.resultset.getString("alu_rg"));
            tfCurso.setText(aluno.resultset.getString("alu_curso"));
            tfTelefone.setText(aluno.resultset.getString("alu_telefone"));

            cbModulo.setSelectedItem(aluno.resultset.getString("alu_modulo"));
            cbPeriodo.setSelectedItem(aluno.resultset.getString("alu_periodo"));
            cbSexo.setSelectedItem(aluno.resultset.getString("alu_sexo"));

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
                FormAluno dialog = new FormAluno(new javax.swing.JFrame(), true);
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
    private javax.swing.JComboBox cbModulo;
    private javax.swing.JComboBox cbPeriodo;
    private javax.swing.JComboBox cbSexo;
    private javax.swing.JLabel jLRg;
    private javax.swing.JLabel jLVeiculo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLcurso;
    private javax.swing.JLabel jLmodulo;
    private javax.swing.JLabel jLnascimento;
    private javax.swing.JLabel jLnome;
    private javax.swing.JLabel jLsexo;
    private javax.swing.JLabel jLtelefone;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JRadioButton jRadioNao;
    private javax.swing.JRadioButton jRadioSim;
    private javax.swing.JPanel jpPrincipal;
    private javax.swing.JLabel lbFoto;
    private javax.swing.JLabel lbTotalReg;
    private javax.swing.JTextField tfCurso;
    private javax.swing.JFormattedTextField tfNascimento;
    private javax.swing.JTextField tfNome;
    private javax.swing.JFormattedTextField tfRG;
    private javax.swing.JFormattedTextField tfTelefone;
    // End of variables declaration//GEN-END:variables
}
