package Interfaces;

import conexaoBancoDeDados.conexaoMySql;  //importa a classe conexaoMySql do pacote conexaoBanco...
import java.sql.SQLException;
import utilitarios.DataHora;
import javax.swing.JFileChooser;
import java.io.FileWriter;
import javax.swing.JOptionPane;

//webcam
import java.awt.Component;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.RenderedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.media.Buffer;
import javax.media.CaptureDeviceInfo;
import javax.media.Manager;
import javax.media.MediaLocator;
import javax.media.Player;
import javax.media.cdm.CaptureDeviceManager;
import javax.media.control.FrameGrabbingControl;
import javax.media.format.VideoFormat;
import javax.media.util.BufferToImage;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;

public class visitante extends javax.swing.JDialog {

    conexaoMySql iniciaConexao = new conexaoMySql(); //instacia o objeto     //cria um objeto
    DataHora getHoraDataBanco = new DataHora();
    pesquisa objeto;
    JFileChooser escolha;
    public String recebeRgPesquisa;
    MaskFormatter rgMask;
    
    String imgNoBanco = "imagens/semFoto.png";
    private static final long serialVersionUID = 1L;
    public static Player player = null;
    public CaptureDeviceInfo di = null;  //  @jve:decl-index=0:
    public MediaLocator ml = null;  //  @jve:decl-index=0:
    public Buffer buf = null;
    public Image img = null;
    public VideoFormat vf = null;
    public BufferToImage btoi = null;
    public Image myimg;
    
     
    public visitante(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().createImage(getClass().getResource("/icones/visitante.png")));
        objeto = new pesquisa(null, rootPaneCheckingEnabled);
        primeiroRegistro();       
        objeto.rg = "vis_rg";
        objeto.nome = "vis_nome";
        objeto.tabela = "visitante";
        objeto.img = "vis_foto";
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel6 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1Nome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jRadioButtonSIM = new javax.swing.JRadioButton();
        jRadioButtonNAO = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldCodigo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        try
        {
            rgMask = new MaskFormatter("########.*");
        }
        catch(Exception Erro)
        {
        }
        Rg = new JFormattedTextField(rgMask);
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel10 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        foto = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jButtonPrimeiro = new javax.swing.JButton();
        jButton2Anterior = new javax.swing.JButton();
        jButton1Proximo = new javax.swing.JButton();
        jButton1Ultimo = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jButton1Novo = new javax.swing.JButton();
        jButton2Excluir = new javax.swing.JButton();
        jButton3Salvar = new javax.swing.JButton();
        jButton4Cancelar = new javax.swing.JButton();
        jButton5Pesquisar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Visitante");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Dados do visitante", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 0, 12), new java.awt.Color(0, 0, 255))); // NOI18N

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Nome:");

        jLabel3.setText("RG:");

        jLabel6.setText("Veículo:");

        buttonGroup1.add(jRadioButtonSIM);
        jRadioButtonSIM.setText("Sim");

        buttonGroup1.add(jRadioButtonNAO);
        jRadioButtonNAO.setSelected(true);
        jRadioButtonNAO.setText("Não");

        jLabel2.setText("Código:");

        jTextFieldCodigo.setEditable(false);
        jTextFieldCodigo.setFont(new java.awt.Font("Verdana", 1, 14));
        jTextFieldCodigo.setForeground(new java.awt.Color(255, 0, 0));
        jTextFieldCodigo.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel5.setText("Sexo:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-", "Masculino", "Feminino" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jTextField1Nome, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
                        .addGap(56, 56, 56)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jComboBox1, 0, 147, Short.MAX_VALUE)
                            .addComponent(Rg, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)))
                    .addComponent(jLabel6)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jRadioButtonSIM)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButtonNAO)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Rg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1Nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jTextFieldCodigo, 0, 0, Short.MAX_VALUE)
                    .addComponent(jComboBox1))
                .addGap(22, 22, 22)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonSIM)
                    .addComponent(jRadioButtonNAO))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setText("Motivo da visita:");

        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE)
                    .addComponent(jLabel4))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13))
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton6.setText("Capturar WebCam");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton3.setText("Tirar Fotografia");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel4.setLayout(null);

        foto.setOpaque(true);
        jPanel4.add(foto);
        foto.setBounds(2, 2, 200, 204);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel10Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton3, jButton6});

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel10, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel7.setLayout(new javax.swing.BoxLayout(jPanel7, javax.swing.BoxLayout.LINE_AXIS));

        jButtonPrimeiro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Anterior/primeiro.png"))); // NOI18N
        jButtonPrimeiro.setToolTipText("Primeiro registro.");
        jButtonPrimeiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPrimeiroActionPerformed(evt);
            }
        });
        jPanel7.add(jButtonPrimeiro);

        jButton2Anterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Anterior/anterior.png"))); // NOI18N
        jButton2Anterior.setToolTipText("Registro anterior.");
        jButton2Anterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2AnteriorActionPerformed(evt);
            }
        });
        jPanel7.add(jButton2Anterior);

        jButton1Proximo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/proximo/proximo (2).png"))); // NOI18N
        jButton1Proximo.setToolTipText("Próximo registro.");
        jButton1Proximo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ProximoActionPerformed(evt);
            }
        });
        jPanel7.add(jButton1Proximo);

        jButton1Ultimo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/proximo/ultimo.png"))); // NOI18N
        jButton1Ultimo.setToolTipText("Último registro.");
        jButton1Ultimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1UltimoActionPerformed(evt);
            }
        });
        jPanel7.add(jButton1Ultimo);

        jPanel9.setPreferredSize(new java.awt.Dimension(60, 23));
        jPanel9.setLayout(new java.awt.CardLayout());

        jButton1.setMnemonic('R');
        jButton1.setText("Registrar saída");
        jButton1.setToolTipText("Registrar saída.");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel9.add(jButton1, "card2");

        jPanel7.add(jPanel9);

        jPanel8.setLayout(new java.awt.BorderLayout());

        jButton1Novo.setMnemonic('N');
        jButton1Novo.setText("Novo");
        jButton1Novo.setToolTipText("Novo registro.");
        jButton1Novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1NovoActionPerformed(evt);
            }
        });
        jPanel8.add(jButton1Novo, java.awt.BorderLayout.CENTER);

        jButton2Excluir.setMnemonic('E');
        jButton2Excluir.setText("    Excluir   ");
        jButton2Excluir.setToolTipText("Excluir visitante.");
        jButton2Excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ExcluirActionPerformed(evt);
            }
        });
        jPanel8.add(jButton2Excluir, java.awt.BorderLayout.PAGE_START);

        jButton3Salvar.setMnemonic('G');
        jButton3Salvar.setText("     Gravar   ");
        jButton3Salvar.setToolTipText("Gravar registro.");
        jButton3Salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3SalvarActionPerformed(evt);
            }
        });
        jPanel8.add(jButton3Salvar, java.awt.BorderLayout.PAGE_END);

        jButton4Cancelar.setMnemonic('A');
        jButton4Cancelar.setText("Atualizar");
        jButton4Cancelar.setToolTipText("Atualizar registro.");
        jButton4Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4CancelarActionPerformed(evt);
            }
        });
        jPanel8.add(jButton4Cancelar, java.awt.BorderLayout.LINE_END);

        jButton5Pesquisar.setMnemonic('P');
        jButton5Pesquisar.setText("Pesquisar");
        jButton5Pesquisar.setToolTipText("Pesquisar visitante.");
        jButton5Pesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5PesquisarActionPerformed(evt);
            }
        });
        jPanel8.add(jButton5Pesquisar, java.awt.BorderLayout.LINE_START);

        jPanel7.add(jPanel8);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 733, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        java.awt.Dimension dialogSize = getSize();
        setLocation((screenSize.width-dialogSize.width)/2,(screenSize.height-dialogSize.height)/2);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5PesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5PesquisarActionPerformed
        objeto.setVisible(rootPaneCheckingEnabled);
}//GEN-LAST:event_jButton5PesquisarActionPerformed

    private void jButton3SalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3SalvarActionPerformed
        if (jRadioButtonSIM.isSelected()) {
            veiculo passaDadosVisitante = new veiculo(null);
            try {
                if (jTextField1Nome.getText().equals("") || jTextArea1.getText().equals("") || Rg.getText().equals("")
                        || jComboBox1.getSelectedItem() == "-") {
                    throw new IllegalAccessError();
                }

                passaDadosVisitante.nomeProprientario = jTextField1Nome.getText();
                passaDadosVisitante.rgProprietario = Rg.getText();
                passaDadosVisitante.recebeDadosvisitate();
                gravaRegistroVisitante();
                passaDadosVisitante.setVisible(true);

            } catch (IllegalAccessError erro) {
                msg();
            }
        } else if (jRadioButtonNAO.isSelected()) {
            gravaRegistroVisitante();
        }
}//GEN-LAST:event_jButton3SalvarActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        capturaVideo();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton2ExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ExcluirActionPerformed
        int a = JOptionPane.showConfirmDialog(this, "Aceita apagar o registro permanentemente ?","ESCOLHA",JOptionPane.YES_NO_OPTION);
        if(a == JOptionPane.YES_OPTION){
        try {
            String deletaRegistro = "delete from visitante where vis_codigo = " + jTextFieldCodigo.getText();
            iniciaConexao.statement.executeUpdate(deletaRegistro);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erro, o comando sql não pode ser executado");
        }
        //iniciaConexao.fechaConexao();
        iniciaConexao.executaComandosSql("select * from visitante");
        try{
        iniciaConexao.resultset.first();
        mostraDados();
        }catch(SQLException eroo){

        }
        JOptionPane.showMessageDialog(this, "Registro Excluído com sucesso.");
        }
    }//GEN-LAST:event_jButton2ExcluirActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            //iniciaConexao.eventuaCenexao();
            int codigo;
            getHoraDataBanco.leHora();
            codigo = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o código do visitante", "Código", 3));
            try {
                // iniciaConexao.executaComandosSql("select * from visitante");
                String insereCodigo = "update visitante set vis_hora_saida = " + "'" + getHoraDataBanco.getHora() + "'" + "where vis_codigo = " + codigo;
                iniciaConexao.statement.executeUpdate(insereCodigo);
            } catch (SQLException comandoERRo) {
                JOptionPane.showMessageDialog(rootPane, "Ocorru um erro e a operação não pode ser executada");
            }
            iniciaConexao.executaComandosSql("select * from visitante");
            iniciaConexao.resultset.first();
            mostraDados();
        } catch (SQLException ex) {

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1NovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1NovoActionPerformed
        jTextField1Nome.setText(null);
        Rg.setText(null);
        jTextArea1.setText(null);
        jTextFieldCodigo.setText(null);
        jRadioButtonNAO.setSelected(rootPaneCheckingEnabled);
        jComboBox1.setSelectedItem("-");
        jButton3Salvar.setEnabled(true);
        foto.setIcon(null);
        
        iniciaConexao.eventuaCenexao();
        iniciaConexao.executaComandosSql("select vis_codigo from visitante");
        try {
            iniciaConexao.resultset.last();
            int ultimoCodigo = iniciaConexao.resultset.getInt("vis_codigo");
            jTextFieldCodigo.setText("" + (ultimoCodigo + 1));
            iniciaConexao.executaComandosSql("select * from visitante");
        } catch (SQLException ex) {
        }
    }//GEN-LAST:event_jButton1NovoActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        fotografa();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ProximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ProximoActionPerformed
       
            try {
                // iniciaConexao.eventuaCenexao();
                //iniciaConexao.executaComandosSql("select vis_imagem from visitante");
                 
                foto.setVisible(true);
                // foto.setIcon(null);
                iniciaConexao.resultset.next();
                String retorno = iniciaConexao.resultset.getString("vis_foto");
                ImageIcon imagem = new ImageIcon(retorno);
                foto.setIcon(new ImageIcon(imagem.getImage().getScaledInstance(204, 208, Image.SCALE_AREA_AVERAGING)));
                
                mostraDados();
                //verificaProprietarioVeiculo();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Já está no último registro.", "Atenção", JOptionPane.WARNING_MESSAGE);

                try {
                    iniciaConexao.resultset.last();
                } catch (SQLException ex1) {
                }
            }
            
       
    }//GEN-LAST:event_jButton1ProximoActionPerformed

    private void jButton2AnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2AnteriorActionPerformed
           try {
           // iniciaConexao.eventuaCenexao();
            //iniciaConexao.executaComandosSql("select vis_imagem from visitante");
            foto.setVisible(true);
           
           // foto.setIcon(null);
            iniciaConexao.resultset.previous();
            String retorno = iniciaConexao.resultset.getString("vis_foto");
            ImageIcon imagem = new ImageIcon(retorno);
            foto.setIcon(new ImageIcon(imagem.getImage().getScaledInstance(208, 208, Image.SCALE_AREA_AVERAGING)));
            mostraDados();
        } catch (SQLException ex) {
            try {
                JOptionPane.showMessageDialog(this, "Já está no primeiro registro.","Atenção",JOptionPane.WARNING_MESSAGE);
                iniciaConexao.resultset.first();
            } catch (SQLException ex1) {
               
            }
        }
    }//GEN-LAST:event_jButton2AnteriorActionPerformed

    private void jButton1UltimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1UltimoActionPerformed
       try {
           // iniciaConexao.eventuaCenexao();
            //iniciaConexao.executaComandosSql("select vis_imagem from visitante");
            foto.setVisible(true);
        
           // foto.setIcon(null);
            iniciaConexao.resultset.last();
            String retorno = iniciaConexao.resultset.getString("vis_foto");
            ImageIcon imagem = new ImageIcon(retorno);
            foto.setIcon(new ImageIcon(imagem.getImage().getScaledInstance(204, 208, Image.SCALE_AREA_AVERAGING)));
            mostraDados();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Ocorreu um erro.","Erro",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton1UltimoActionPerformed

    private void jButtonPrimeiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPrimeiroActionPerformed
       try {
           // iniciaConexao.eventuaCenexao();
            //iniciaConexao.executaComandosSql("select vis_imagem from visitante");
            foto.setVisible(true);
           
           // foto.setIcon(null);
            iniciaConexao.resultset.first();
            String retorno = iniciaConexao.resultset.getString("vis_foto");
            ImageIcon imagem = new ImageIcon(retorno);
            foto.setIcon(new ImageIcon(imagem.getImage().getScaledInstance(204, 208, Image.SCALE_AREA_AVERAGING)));
            mostraDados();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Ocorreu um erro.","Erro",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonPrimeiroActionPerformed

    private void jButton4CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4CancelarActionPerformed
      try{
        int opc = JOptionPane.showConfirmDialog(this, "Confirma a atualização ?", "Confirmação", JOptionPane.YES_NO_OPTION, 3);

            if (opc == JOptionPane.YES_OPTION) {

                String sqlUpdate = "UPDATE visitante SET "
                        + "vis_nome = '" + jTextField1Nome.getText() + "',"
                        + "vis_rg = '" + Rg.getText() + "',"
                        + "vis_sexo = '" + jComboBox1.getSelectedItem() + "' "
                        + "WHERE vis_codigo = " + Integer.parseInt(jTextFieldCodigo.getText());

                iniciaConexao.statement.executeUpdate(sqlUpdate);
                iniciaConexao.executaComandosSql("SELECT * FROM visitante");
                iniciaConexao.resultset.first();
                 mostraDados();
                JOptionPane.showMessageDialog(this, "Registro Atualizado Com Sucesso!", "Informação", 1);
        }
        }catch(SQLException ero)
      {
            JOptionPane.showMessageDialog(this, "Erro ao tentar atualizar o registro");
        }
       
    }//GEN-LAST:event_jButton4CancelarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        TelaPrincipal obj = new TelaPrincipal();
        obj.iniciaVerificacao();
    }//GEN-LAST:event_formWindowClosing

    public void gravaRegistroVisitante() {
        //iniciaConexao.eventuaCenexao();
        iniciaConexao.executaComandosSql("select * from visitante");
        try {
            if (jTextField1Nome.getText().equals("") || jTextArea1.getText().equals("") || Rg.getText().equals("")
                    || jComboBox1.getSelectedItem() == "-") {
                throw new IllegalAccessError();
            }
            FileWriter escreva = new FileWriter("ArquivosVisita/" + jTextFieldCodigo.getText() + ".txt");

            String texto1 = jTextArea1.getText();
            
           
             escreva.write(texto1);
            escreva.close();
            gravaImg();
            try {
                getHoraDataBanco.leHora();
                String caminhoArquivo = "ArquivosVisita/" + jTextFieldCodigo.getText() + ".txt";
                String str = jTextField1Nome.getText().replace("'", "\\'");
                String adicionaVisitante = "insert into visitante(vis_nome, vis_rg, vis_sexo,vis_hora_entrada, vis_data, vis_foto, vis_motivo_visita)values('"
                        + str + "',"
                        + "'" + Rg.getText() + "',"
                        + "'" + jComboBox1.getSelectedItem() + "',"
                        + "'" + getHoraDataBanco.getHora() + "',"
                        + "'" + getHoraDataBanco.getDataHoraParaBanco() + "',"
                        + "'" + imgNoBanco + "',"
                        + "'" + caminhoArquivo + "')";

                iniciaConexao.statement.executeUpdate(adicionaVisitante);
                jButton3Salvar.setEnabled(false);
                String retornaCodigo = "select vis_codigo from visitante where vis_rg = " + "'" + Rg.getText() + "'";
                iniciaConexao.executaComandosSql(retornaCodigo);
                iniciaConexao.resultset.first();
                jTextFieldCodigo.setText(String.valueOf(iniciaConexao.resultset.getInt("vis_codigo")));
                if (jRadioButtonNAO.isSelected()) {
                    JOptionPane.showMessageDialog(this, "\nCadastro realizado com êxito");
                }

                iniciaConexao.executaComandosSql("select * from visitante");
            } catch (SQLException erro) {
                JOptionPane.showMessageDialog(this, "Não foi possível executar o comando");
            }


        } catch (IOException erro) {
            JOptionPane.showMessageDialog(this, "Ocorreu um erro na criação do arquivo");
        } catch (IllegalAccessError txtErro) {
            msg();
        }
    }

    public void msg() {
        JOptionPane.showMessageDialog(this, "Não foi possível gravar o registro para visitante,\n"
                + "certifique-se que todos os campos foram preenchidos", "Cadastro incompleto", JOptionPane.ERROR_MESSAGE);
    }
    private void primeiroRegistro()
    {
        jButton3Salvar.setEnabled(false);
         iniciaConexao.eventuaCenexao();
        iniciaConexao.executaComandosSql("select * from visitante");
        try {
            iniciaConexao.resultset.first();
            ImageIcon imagem = new ImageIcon(iniciaConexao.resultset.getString("vis_foto"));
            foto.setIcon(new ImageIcon(imagem.getImage().getScaledInstance(204, 204, Image.SCALE_AREA_AVERAGING)));

            mostraDados();
        } catch (SQLException ex) {

        }
    }

   
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                visitante dialog = new visitante(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    public void capturaVideo() {       
       foto.setVisible(false);
        String str2 = "vfw//0";
        di = CaptureDeviceManager.getDevice(str2);
        ml = new MediaLocator("vfw://0");
        try {

            if( img != null){
                jPanel4.remove(1);
                img = null;
            }
            player = Manager.createRealizedPlayer(ml);

            Component comp;
            if ((comp = player.getVisualComponent()) != null) {

                player.start();
                jPanel4.add(comp);
                comp.setBounds(0, 0, 204, 208);
            }

        } catch (Exception e) {
            if (player != null) {

            } else {
                JOptionPane.showMessageDialog(this, "Não encontrado o dispositivo de vídeo.", "Webcam não encontrada", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void fotografa() {
    if(player !=null){
        FrameGrabbingControl fgc = (FrameGrabbingControl) player.getControl("javax.media.control.FrameGrabbingControl");
        buf = fgc.grabFrame();
        btoi = new BufferToImage((VideoFormat) buf.getFormat());
        img = btoi.createImage(buf);
        player.close();
        //player.deallocate();
        }
      
    }

    public void gravaImg() {
        try {            

           
                if (img != null) {
                    imgNoBanco = "imagens/visitante/" + Rg.getText() + ".jpg";
                    Image imagem = img;                 
                    ImageIO.write((RenderedImage) imagem, "PNG", new File(imgNoBanco));
                  
                }
        } catch (IOException erro) {
            JOptionPane.showMessageDialog(this, "Ocorreu um erro\nnão foi possível gravar a imagem no banco");
        }
    }

    public void mostraDados()
    {
        jTextArea1.setText("");
        try
        {
            jTextField1Nome.setText(iniciaConexao.resultset.getString("vis_nome"));
            Rg.setText(iniciaConexao.resultset.getString("vis_rg"));
            jTextFieldCodigo.setText(iniciaConexao.resultset.getString("vis_codigo"));
            jComboBox1.setSelectedItem(iniciaConexao.resultset.getString("vis_sexo"));
            
           

            try {
            File leArquivo = new File(iniciaConexao.resultset.getString("vis_motivo_visita"));
            FileReader leitura = new FileReader(leArquivo);
            BufferedReader text = new BufferedReader(leitura);
            //texto = text.readLine();
            String txt = null;
            while((txt = text.readLine()) != null){
            jTextArea1.append(txt+"\n");
                }            

        } catch (IOException erro) {
        }
        }
        catch (SQLException e)
        {
          
        }
    }
    public void verificaProprietarioVeiculo()
    {
        try
        {
            iniciaConexao.executaComandosSql("select veiculo.vei_rg from veiculo inner join visitante on veiculo.vei_rg = visitante.vis_rg");
            //iniciaConexao.resultset.getRow();
            JOptionPane.showMessageDialog(null, iniciaConexao.resultset.getRowId(1));
            iniciaConexao.executaComandosSql("select * from visitante");

        }
        catch (SQLException ex)
        {
           JOptionPane.showMessageDialog(null, "erro");
        }
        
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables

    private javax.swing.JFormattedTextField Rg;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel foto;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton1Novo;
    private javax.swing.JButton jButton1Proximo;
    private javax.swing.JButton jButton1Ultimo;
    private javax.swing.JButton jButton2Anterior;
    private javax.swing.JButton jButton2Excluir;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton3Salvar;
    private javax.swing.JButton jButton4Cancelar;
    private javax.swing.JButton jButton5Pesquisar;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButtonPrimeiro;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JRadioButton jRadioButtonNAO;
    private javax.swing.JRadioButton jRadioButtonSIM;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1Nome;
    private javax.swing.JTextField jTextFieldCodigo;
    // End of variables declaration//GEN-END:variables
}
