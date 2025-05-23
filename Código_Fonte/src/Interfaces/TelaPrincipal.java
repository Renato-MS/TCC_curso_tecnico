package Interfaces;

import java.awt.Color;
import java.awt.Toolkit;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import utilitarios.DataHora;
import com.digitalpersona.onetouch.*;
import com.digitalpersona.onetouch.capture.*;
import com.digitalpersona.onetouch.capture.event.*;
import com.digitalpersona.onetouch.processing.*;
import com.digitalpersona.onetouch.verification.*;
import conexaoBancoDeDados.conexaoMySql;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.sql.SQLException;
import org.omg.SendingContext.RunTime;

public class TelaPrincipal extends javax.swing.JFrame{

    DataHora exibeDataHora;
    private DPFPVerification verificator = DPFPGlobal.getVerificationFactory().createVerification();
    DPFPVerificationResult result;
    conexaoMySql conect = new conexaoMySql();
    private DPFPCapture capturer = DPFPGlobal.getCaptureFactory().createCapture();
    String bio_nome, bio_rg, bio_curso, bio_modulo, bio_foto;
    ImageIcon foto1;

    public TelaPrincipal() {
        initComponents();
        exibeDataHora = new DataHora();
        exibeDataHora.leHora();
        jLabel16Data.setText(exibeDataHora.getData());
        timer1.start();
        restauraConfig();
        seta_usuario();
        bloquea();

        setIconImage(Toolkit.getDefaultToolkit().createImage(getClass().getResource("/icones/imgOpen.png")));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        timer1 = new org.netbeans.examples.lib.timerbean.Timer();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jButton2 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel16Data = new javax.swing.JLabel();
        jLabeHora = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        log = new javax.swing.JTextArea();
        picture = new javax.swing.JLabel();
        status = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        lb_imagem = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        tf_nome = new javax.swing.JLabel();
        tf_curso = new javax.swing.JLabel();
        tf_modulo = new javax.swing.JLabel();
        tf_rg = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenu3Estilo = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem14 = new javax.swing.JMenuItem();

        timer1.addTimerListener(new org.netbeans.examples.lib.timerbean.TimerListener() {
            public void onTime(java.awt.event.ActionEvent evt) {
                timer1OnTime(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("JCAB");
        setAlwaysOnTop(true);
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setMaximumSize(getPreferredSize());
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(null);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Botoes_5041_users_two_48.png"))); // NOI18N
        jLabel7.setText("Aluno");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel7MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel7MousePressed(evt);
            }
        });
        jPanel2.add(jLabel7);
        jLabel7.setBounds(40, 4, 120, 52);

        jLabel6.setMaximumSize(new java.awt.Dimension(35, 14));
        jLabel6.setMinimumSize(new java.awt.Dimension(34, 14));
        jPanel2.add(jLabel6);
        jLabel6.setBounds(40, 4, 120, 52);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/funcionarios.png"))); // NOI18N
        jLabel8.setText("Funcionário");
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel8MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel8MousePressed(evt);
            }
        });
        jPanel2.add(jLabel8);
        jLabel8.setBounds(170, 4, 130, 52);
        jPanel2.add(jLabel9);
        jLabel9.setBounds(170, 4, 130, 52);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/visitante.png"))); // NOI18N
        jLabel10.setText("Visitante");
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel10MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel10MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel10MousePressed(evt);
            }
        });
        jPanel2.add(jLabel10);
        jLabel10.setBounds(310, 4, 120, 52);
        jPanel2.add(jLabel11);
        jLabel11.setBounds(310, 4, 120, 52);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/carro.png"))); // NOI18N
        jLabel12.setText("Veículo");
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel12MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel12MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel12MousePressed(evt);
            }
        });
        jPanel2.add(jLabel12);
        jLabel12.setBounds(440, 4, 120, 52);
        jPanel2.add(jLabel13);
        jLabel13.setBounds(440, 4, 120, 52);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fundos/p4a.png"))); // NOI18N
        jLabel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel2.add(jLabel5);
        jLabel5.setBounds(0, 0, 790, 60);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(201, 13, 790, 60);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setLayout(null);

        jButton6.setFont(new java.awt.Font("Tahoma", 0, 12));
        jButton6.setText("Relatório Visitante");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton6);
        jButton6.setBounds(10, 140, 160, 40);

        jButton10.setFont(new java.awt.Font("Tahoma", 0, 12));
        jButton10.setText("Nome da Instituíção");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton10);
        jButton10.setBounds(10, 190, 160, 40);

        jButton11.setFont(new java.awt.Font("Tahoma", 0, 12));
        jButton11.setText("Usuário e Senha");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton11);
        jButton11.setBounds(10, 10, 160, 40);

        jButton12.setFont(new java.awt.Font("Tahoma", 0, 12));
        jButton12.setText("Visualizar em Tabela");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton12);
        jButton12.setBounds(10, 90, 160, 40);

        jButton13.setFont(new java.awt.Font("Tahoma", 0, 12));
        jButton13.setText("Bloquear Catraca");
        jButton13.setEnabled(false);
        jPanel3.add(jButton13);
        jButton13.setBounds(10, 350, 160, 40);

        jButton14.setFont(new java.awt.Font("Tahoma", 0, 12));
        jButton14.setText("Desbloquer Catraca");
        jButton14.setEnabled(false);
        jPanel3.add(jButton14);
        jButton14.setBounds(10, 410, 160, 40);

        jButton15.setFont(new java.awt.Font("Tahoma", 0, 12));
        jButton15.setText("Conectar Catraca");
        jButton15.setEnabled(false);
        jPanel3.add(jButton15);
        jButton15.setBounds(10, 470, 160, 40);
        jPanel3.add(jSeparator1);
        jSeparator1.setBounds(10, 330, 160, 10);
        jPanel3.add(jSeparator2);
        jSeparator2.setBounds(10, 70, 160, 10);
        jPanel3.add(jSeparator3);
        jSeparator3.setBounds(10, 250, 160, 10);

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 12));
        jButton2.setText("Sair");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2);
        jButton2.setBounds(10, 270, 160, 40);

        jLabel15.setBackground(new java.awt.Color(0, 0, 0));
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fundos/d5a.png"))); // NOI18N
        jPanel3.add(jLabel15);
        jLabel15.setBounds(1, 2, 178, 565);

        jPanel1.add(jPanel3);
        jPanel3.setBounds(11, 13, 180, 569);

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 12));
        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });
        jTabbedPane1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPane1StateChanged(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));
        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel1.setText("Data:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel2.setText("Hora:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel3.setText("Usuário:");

        jLabel16Data.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel16Data.setForeground(new java.awt.Color(204, 0, 51));
        jLabel16Data.setText("00/00/0000");

        jLabeHora.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabeHora.setForeground(new java.awt.Color(204, 0, 51));
        jLabeHora.setText("00:00:00");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel16.setForeground(new java.awt.Color(204, 0, 51));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16Data, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabeHora, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                        .addComponent(jLabel16Data, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabeHora, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel14.setFont(new java.awt.Font("Monotype Corsiva", 1, 60));
        jLabel14.setForeground(new java.awt.Color(102, 102, 102));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fundos/26.png"))); // NOI18N
        jLabel14.setText("Etec Jardim Ângela");
        jLabel14.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel14.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 785, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 437, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Tela Principal", jPanel4);

        jPanel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel6MouseClicked(evt);
            }
        });
        jPanel6.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jPanel6ComponentShown(evt);
            }
        });

        log.setBackground(new java.awt.Color(0, 0, 0));
        log.setColumns(20);
        log.setEditable(false);
        log.setFont(new java.awt.Font("Verdana", 0, 12));
        log.setForeground(new java.awt.Color(0, 153, 0));
        log.setRows(5);
        log.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jScrollPane1.setViewportView(log);

        picture.setBackground(new java.awt.Color(255, 255, 255));
        picture.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        picture.setOpaque(true);

        status.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        status.setOpaque(true);

        jPanel7.setBackground(new java.awt.Color(204, 204, 204));
        jPanel7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel7.setLayout(null);

        lb_imagem.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel7.add(lb_imagem);
        lb_imagem.setBounds(261, 13, 199, 218);

        jLabel18.setText("Nome:");
        jPanel7.add(jLabel18);
        jLabel18.setBounds(12, 23, 40, 14);

        jLabel19.setText("Curso:");
        jPanel7.add(jLabel19);
        jLabel19.setBounds(12, 55, 40, 14);

        jLabel20.setText("Módulo:");
        jPanel7.add(jLabel20);
        jLabel20.setBounds(12, 87, 50, 14);

        jLabel21.setText("RG:");
        jPanel7.add(jLabel21);
        jLabel21.setBounds(12, 119, 30, 14);
        jPanel7.add(tf_nome);
        tf_nome.setBounds(68, 23, 175, 14);
        jPanel7.add(tf_curso);
        tf_curso.setBounds(68, 55, 175, 14);
        jPanel7.add(tf_modulo);
        tf_modulo.setBounds(68, 87, 175, 14);
        jPanel7.add(tf_rg);
        tf_rg.setBounds(68, 119, 175, 14);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(picture, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE))
                .addGap(15, 15, 15))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(picture, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Eventos da Biometria", jPanel6);

        jPanel1.add(jTabbedPane1);
        jTabbedPane1.setBounds(201, 81, 790, 500);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fundos/20.png"))); // NOI18N
        jLabel4.setText("jLabel4");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(1, 1, 1000, 602);

        jMenuBar1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jMenu1.setBackground(new java.awt.Color(224, 226, 235));
        jMenu1.setMnemonic('C');
        jMenu1.setText("Cadastro                 ");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/aluno32.png"))); // NOI18N
        jMenuItem1.setText("Aluno");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/funcionarios32.png"))); // NOI18N
        jMenuItem6.setText("Funcionário");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem6);

        jMenuItem8.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/visitante32.png"))); // NOI18N
        jMenuItem8.setText("Visitante");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem8);

        jMenuItem9.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/carro32.png"))); // NOI18N
        jMenuItem9.setText("Veículo");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem9);
        jMenu1.add(jSeparator5);

        jMenuItem13.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/exit.png"))); // NOI18N
        jMenuItem13.setText("Sair");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem13);

        jMenuBar1.add(jMenu1);

        jMenu3Estilo.setMnemonic('E');
        jMenu3Estilo.setText("Estilo                ");

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Ice.png"))); // NOI18N
        jMenuItem2.setText("Vidro");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3Estilo.add(jMenuItem2);

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/nimbus.png"))); // NOI18N
        jMenuItem3.setText("Nimbus");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu3Estilo.add(jMenuItem3);

        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/windows.png"))); // NOI18N
        jMenuItem5.setText("Sistema");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu3Estilo.add(jMenuItem5);
        jMenu3Estilo.add(jSeparator4);

        jMenu6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/pintura.png"))); // NOI18N
        jMenu6.setText("Pintura");

        jMenuItem4.setText("Escuro");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem4);

        jMenuItem10.setText("Azul");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem10);

        jMenuItem11.setText("Padrão");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem11);

        jMenu3Estilo.add(jMenu6);

        jMenuBar1.add(jMenu3Estilo);

        jMenu5.setText("Configurações            ");

        jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/editor.png"))); // NOI18N
        jMenuItem7.setText("Mudar nome da instituíção");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem7);

        jMenuBar1.add(jMenu5);

        jMenu7.setText("Relatório          ");

        jMenuItem12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/relatorio.png"))); // NOI18N
        jMenuItem12.setText("Relatório de visitante");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem12);

        jMenuBar1.add(jMenu7);

        jMenu2.setBackground(new java.awt.Color(224, 226, 235));
        jMenu2.setText("Ajuda     ");

        jMenuItem14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/img (55).png"))); // NOI18N
        jMenuItem14.setText("Sobre");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem14);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1002, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 604, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        java.awt.Dimension dialogSize = getSize();
        setLocation((screenSize.width-dialogSize.width)/2,(screenSize.height-dialogSize.height)/2);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        new tabela(this, rootPaneCheckingEnabled).setVisible(true);
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        new senha(this, rootPaneCheckingEnabled).setVisible(true);
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jLabel7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseEntered

        jLabel6.setIcon(new ImageIcon(getClass().getResource("/botoes/1.png")));
        jLabel6.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }//GEN-LAST:event_jLabel7MouseEntered

    private void jLabel7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseExited
        jLabel6.setIcon(null);
        jLabel6.setBorder(null);
    }//GEN-LAST:event_jLabel7MouseExited

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        try{
            File le_Tipo_User = new File("Config/tipo_user.ini");
            FileReader file = new FileReader(le_Tipo_User);
            BufferedReader tipo_user = new BufferedReader(file);
            String tipo_usuario = tipo_user.readLine();

            if(tipo_usuario.equals("Agente")){
                
            }else{
                 stop();
                setVisible(false);
                // buscaDigital.fechaConexao();
                new FormAluno(this, rootPaneCheckingEnabled).setVisible(true);
            }
            //String str = ""+nome_usuario;
            //jLabel16.setText(str);
        }catch(IOException ex){

        }


    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MousePressed
        jLabel6.setIcon(new ImageIcon(getClass().getResource("/botoes/5.png")));
    }//GEN-LAST:event_jLabel7MousePressed

    private void jLabel8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseEntered
        jLabel9.setIcon(new ImageIcon(getClass().getResource("/botoes/1.png")));
        jLabel9.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }//GEN-LAST:event_jLabel8MouseEntered

    private void jLabel8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseExited
        jLabel9.setIcon(null);
        jLabel9.setBorder(null);
    }//GEN-LAST:event_jLabel8MouseExited

    private void jLabel8MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MousePressed

        jLabel9.setIcon(new ImageIcon(getClass().getResource("/botoes/5.png")));
        jLabel9.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }//GEN-LAST:event_jLabel8MousePressed

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
       try{
            File le_Tipo_User = new File("Config/tipo_user.ini");
            FileReader file = new FileReader(le_Tipo_User);
            BufferedReader tipo_user = new BufferedReader(file);
            String tipo_usuario = tipo_user.readLine();

            if(tipo_usuario.equals("Agente")){
                
            }else{
                stop();
                setVisible(false);
                // buscaDigital.fechaConexao();
                new funcionario(this, rootPaneCheckingEnabled).setVisible(true);
                //dispose();
            }
            //String str = ""+nome_usuario;
            //jLabel16.setText(str);
        }catch(IOException ex){

        }


    }//GEN-LAST:event_jLabel8MouseClicked

    private void jLabel10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseEntered

        jLabel11.setIcon(new ImageIcon(getClass().getResource("/botoes/1.png")));
        jLabel11.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }//GEN-LAST:event_jLabel10MouseEntered

    private void jLabel10MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseExited
        jLabel11.setIcon(null);
        jLabel11.setBorder(null);
    }//GEN-LAST:event_jLabel10MouseExited

    private void jLabel10MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MousePressed

        jLabel11.setIcon(new ImageIcon(getClass().getResource("/botoes/5.png")));
    }//GEN-LAST:event_jLabel10MousePressed

    private void jLabel12MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseEntered
        jLabel13.setIcon(new ImageIcon(getClass().getResource("/botoes/1.png")));
        jLabel13.setBorder(BorderFactory.createLineBorder(Color.black));
    }//GEN-LAST:event_jLabel12MouseEntered

    private void jLabel12MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseExited
        jLabel13.setIcon(null);
        jLabel13.setBorder(null);
    }//GEN-LAST:event_jLabel12MouseExited

    private void jLabel12MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MousePressed
        jLabel13.setIcon(new ImageIcon(getClass().getResource("/botoes/5.png")));
    }//GEN-LAST:event_jLabel12MousePressed

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        stop();
        setVisible(false);
        new visitante(this, rootPaneCheckingEnabled).setVisible(true);

    }//GEN-LAST:event_jLabel10MouseClicked

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        //stop();
        //setVisible(false);
        new veiculo(this).setVisible(true);
    }//GEN-LAST:event_jLabel12MouseClicked

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        jMenuItem12ActionPerformed(evt);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jMenuItem2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem2MouseClicked
    }//GEN-LAST:event_jMenuItem2MouseClicked

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        Apararencia("com.birosoft.liquid.LiquidLookAndFeel");
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        Apararencia("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        Apararencia("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");

    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void timer1OnTime(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timer1OnTime
        exibeDataHora.leHora();
        jLabeHora.setText(exibeDataHora.getHora());
    }//GEN-LAST:event_timer1OnTime

    private void jPanel6ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel6ComponentShown
    }//GEN-LAST:event_jPanel6ComponentShown

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        init();
        start();
        updateStatus(0);        
        boolean v = true;
        if(v == true)
        {
            conect.eventuaCenexao();
            v= false;
        }
}//GEN-LAST:event_formComponentShown

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        String logo = JOptionPane.showInputDialog(this,"Informe o novo nome da instituição:","Mudar nome",JOptionPane.INFORMATION_MESSAGE);
        if(logo != null)
        {
             jLabel14.setText(logo);
             logoInstituicao(logo);
        }
       
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        stop();
        setVisible(false);
        new FormAluno(this, true).setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
       //buscaDigital.eventuaCenexao();
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void jPanel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel6MouseClicked

    private void jTabbedPane1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPane1StateChanged
       
    }//GEN-LAST:event_jTabbedPane1StateChanged

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      System.exit(0);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        pinturaFundo("Config/imgConfig/27.png");
        pinturaCentro("Config/imgConfig/5.png");
        pinturaLateral("Config/imgConfig/d1.png");
        pinturaSuperior("Config/imgConfig/p2.png");
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        pinturaFundo("Config/imgConfig/18a.png");
        pinturaCentro("Config/imgConfig/16.png");
        pinturaLateral("Config/imgConfig/d1.png");
        pinturaSuperior("Config/imgConfig/p2.png");
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        pinturaFundo("Config/imgConfig/20.png");
        pinturaCentro("Config/imgConfig/26.png");
        pinturaLateral("Config/imgConfig/d5a.png");
        pinturaSuperior("Config/imgConfig/p4a.png");
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        new relatorioForm(this, rootPaneCheckingEnabled).setVisible(true);
}//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
       jMenuItem7ActionPerformed(evt);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        stop();
        setVisible(false);
        new funcionario(this, rootPaneCheckingEnabled).setVisible(true);
        
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        stop();
        setVisible(false);
        new visitante(this, rootPaneCheckingEnabled).setVisible(rootPaneCheckingEnabled);
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        new veiculo(this).setVisible(rootPaneCheckingEnabled);
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
       System.exit(0);
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
        new sobre(this, rootPaneCheckingEnabled).setVisible(rootPaneCheckingEnabled);
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    public void Apararencia(String estilo) {
        try {
            UIManager.setLookAndFeel(estilo);
            SwingUtilities.updateComponentTreeUI(this);
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro ao Carregar Look And Feel!");
        } //fim

        try {
            FileWriter escreva = new FileWriter("Config/LookAndFeel.ini");
            escreva.write(estilo);
            escreva.close();
        } catch (IOException erro) {
        }
    }

    protected void init() {
        capturer.addDataListener(new DPFPDataAdapter() {

            @Override
            public void dataAcquired(final DPFPDataEvent e) {
                SwingUtilities.invokeLater(new Runnable() {

                    public void run() {
                        log.setText("");
                        makeReport("A digital foi capturada.");
                        process(e.getSample());
                    }
                });
            }
        });
        capturer.addReaderStatusListener(new DPFPReaderStatusAdapter() {

            @Override
            public void readerConnected(final DPFPReaderStatusEvent e) {
                SwingUtilities.invokeLater(new Runnable() {

                    public void run() {                        
                        makeReport("O leitor está conectado.");
                    }
                });
            }

            @Override
            public void readerDisconnected(final DPFPReaderStatusEvent e) {
                SwingUtilities.invokeLater(new Runnable() {

                    public void run() {
                        makeReport("O leitor está desconectado.");
                    }
                });
            }
        });        
        capturer.addImageQualityListener(new DPFPImageQualityAdapter() {

            @Override
            public void onImageQuality(final DPFPImageQualityEvent e) {
                SwingUtilities.invokeLater(new Runnable() {

                    public void run() {
                        if (e.getFeedback().equals(DPFPCaptureFeedback.CAPTURE_FEEDBACK_GOOD)) {
                            makeReport("A qualidade da imagem é boa.");
                        } else {
                            makeReport("A qualidade da imagem é ruim.");
                        }
                    }
                });
            }
        });
    }

    protected void process(DPFPSample sample) {
        // Draw fingerprint sample image.
        drawPicture(convertSampleToBitmap(sample));
        // convertSampleToBitmap(sample);
        DPFPFeatureSet features = extractFeatures(sample, DPFPDataPurpose.DATA_PURPOSE_VERIFICATION);

        // Check quality of the sample and start verification if it's good
        if (features != null) {
            String comparaDigitais = "select * from template";
            conect.executaComandosSql(comparaDigitais);
            boolean boleano = true;
            while (boleano == true) {
                try {

                    conect.resultset.next();
                    String digital = conect.resultset.getString("temp_dedo_1");

                    FileInputStream stream = new FileInputStream(digital);

                    byte[] data = new byte[stream.available()];
                    stream.read(data);
                    stream.close();
                    DPFPTemplate t = DPFPGlobal.getTemplateFactory().createTemplate();
                    t.deserialize(data);

                    result = verificator.verify(features, t);
                    updateStatus(result.getFalseAcceptRate());

                    if (result.isVerified()) {                        
                        makeReport("A digital está CORRETA");                        
                        jPanel6.setBackground(new Color(0,102,51));

                        String RG = conect.resultset.getString("temp_rg");
                        seta_info_bio(RG);
                        break;
                    }


                } catch (SQLException ex) {                   
                    makeReport("A digital está ERRADA.");
                    jPanel6.setBackground(new Color(204,0,0));
                    break;
                } catch(IOException erro){

                }
            }
        }
    }

    public void seta_info_bio(String rg){
        String comparaRG = "select * from aluno, funcionario ";
            conect.executaComandosSql(comparaRG);
           // boolean boleano = true;

                try {
                    while (conect.resultset.next()) {

                        if(rg.equals(conect.resultset.getString("alu_rg"))){
                            bio_nome = conect.resultset.getString("alu_nome");
                            bio_rg = rg;
                            bio_curso = conect.resultset.getString("alu_curso");
                            bio_modulo = conect.resultset.getString("alu_modulo");
                            bio_foto = conect.resultset.getString("alu_foto");

                            tf_nome.setText(bio_nome);
                            tf_rg.setText(bio_rg);
                            tf_curso.setText(bio_curso);
                            tf_modulo.setText(bio_modulo);
                            tf_nome.setText(bio_nome);
                            jLabel19.setText("Curso:");
                            jLabel20.setText("Módulo:");

                            String valor1 = String.valueOf(bio_foto);
                            valor1 = valor1.replace("\\", "/");
                            foto1 = new ImageIcon(valor1);


                            lb_imagem.setIcon(new ImageIcon(foto1.getImage().getScaledInstance(205, 228, Image.SCALE_DEFAULT)));

                            //lb_imagem.setIcon(new ImageIcon(
                            //foto1.getImage().foto1.getScaledInstance(lb_imagem.getWidth(), lb_imagem.getHeight(), Image.SCALE_DEFAULT)));

                            break;
                        }
                        
                        if(rg.equals(conect.resultset.getString("fun_rg"))){
                            bio_nome = conect.resultset.getString("fun_nome");
                            bio_rg = rg;
                            bio_curso = "FUNCIONÁRIO";
                            //bio_modulo = conect.resultset.getString("alu_modulo");
                            bio_foto = conect.resultset.getString("fun_foto");

                            tf_nome.setText(bio_nome);
                            tf_rg.setText(bio_rg);
                            tf_curso.setText(bio_curso);
                            tf_modulo.setText("");
                            tf_nome.setText(bio_nome);
                            jLabel19.setText("");
                            jLabel20.setText("");

                            String valor1 = String.valueOf(bio_foto);
                            valor1 = valor1.replace("\\", "/");
                            foto1 = new ImageIcon(valor1);


                            lb_imagem.setIcon(new ImageIcon(foto1.getImage().getScaledInstance(205, 228, Image.SCALE_DEFAULT)));

                            //lb_imagem.setIcon(new ImageIcon(
                            //foto1.getImage().foto1.getScaledInstance(lb_imagem.getWidth(), lb_imagem.getHeight(), Image.SCALE_DEFAULT)));

                            break;
                        }
                    //conect.resultset.first();


                    }
                }catch (SQLException ex){

                }


    }


    protected void start() {
        capturer.startCapture();
    }

    protected void stop() {
        capturer.stopCapture();
    }

    public void setStatus(String string) {
        status.setText(string);

    }

    public void makeReport(String string) {
        log.append(string + "\n");        
    }

    public void drawPicture(Image image) { //vai retornar a imagem
        picture.setIcon(new ImageIcon(
                image.getScaledInstance(picture.getWidth(), picture.getHeight(), Image.SCALE_DEFAULT)));
    }

    protected Image convertSampleToBitmap(DPFPSample sample) {
        return DPFPGlobal.getSampleConversionFactory().createImage(sample);
    }

    protected DPFPFeatureSet extractFeatures(DPFPSample sample, DPFPDataPurpose purpose) {
        DPFPFeatureExtraction extractor = DPFPGlobal.getFeatureExtractionFactory().createFeatureExtraction();
        try {
            return extractor.createFeatureSet(sample, purpose);
        } catch (DPFPImageQualityException e) {
            return null;
        }
    }

    public void updateStatus(int FAR) {
        // Show "False accept rate" value
        setStatus(String.format("Resultado = %1$s", FAR));
    }

    public void logoInstituicao(String nome)
    {
        try {
            FileWriter escreva = new FileWriter("Config/logo.ini");
            escreva.write(nome);
            escreva.close();
        } catch (IOException erro) {
        }
    }

    private void restauraConfig()
    {
        try {
            File leArquivo = new File("Config/logo.ini");
            FileReader leitura = new FileReader(leArquivo);
            BufferedReader text = new BufferedReader(leitura);
            String texto = text.readLine();           

            File leFundo = new File("Config/fundo.ini");
            FileReader leitura2 = new FileReader(leFundo);
            BufferedReader fundo = new BufferedReader(leitura2);
            String textoImg1 = fundo.readLine();

            File leFundoEsquerdo = new File("Config/fundoLateral.ini");
            FileReader leitura3 = new FileReader(leFundoEsquerdo);
            BufferedReader fundo2 = new BufferedReader(leitura3);
            String textoImg2 = fundo2.readLine();

            File leFundoCentro = new File("Config/fundoCentro.ini");
            FileReader leitura4 = new FileReader(leFundoCentro);
            BufferedReader fundo3 = new BufferedReader(leitura4);
            String textoImg3 = fundo3.readLine();

            File leFundoSuperior = new File("Config/superior.ini");
            FileReader leitura5 = new FileReader(leFundoSuperior);
            BufferedReader fundo4 = new BufferedReader(leitura5);
            String textoImg4 = fundo4.readLine();

            jLabel14.setText(texto);
            jLabel4.setIcon(new ImageIcon(textoImg1));
            jLabel15.setIcon(new ImageIcon(textoImg2));
            jLabel14.setIcon(new ImageIcon(textoImg3));
            jLabel5.setIcon(new ImageIcon(textoImg4));

        } catch (IOException erro) {
        }
    }

    public void pinturaFundo(String print)
    {
        try {
            FileWriter escrevaPintura = new FileWriter("Config/fundo.ini");
            escrevaPintura.write(print);
            escrevaPintura.close();
        } catch (IOException erro) {
        }
        jLabel4.setIcon(new ImageIcon(print));
    }

    public void pinturaLateral(String print)
    {
        try {
            FileWriter escrevaPintura = new FileWriter("Config/fundoLateral.ini");
            escrevaPintura.write(print);
            escrevaPintura.close();
        } catch (IOException erro) {
        }
        jLabel15.setIcon(new ImageIcon(print));
    }

    public void pinturaCentro(String print)
    {
        try {
            FileWriter escrevaPintura = new FileWriter("Config/fundoCentro.ini");
            escrevaPintura.write(print);
            escrevaPintura.close();
        } catch (IOException erro) {
        }
        jLabel14.setIcon(new ImageIcon(print));
    }

    public void pinturaSuperior(String print)
    {
        try {
            FileWriter escrevaPintura = new FileWriter("Config/superior.ini");
            escrevaPintura.write(print);
            escrevaPintura.close();
        } catch (IOException erro) {
        }
        jLabel5.setIcon(new ImageIcon(print));
    }

    public void iniciaVerificacao()
    {       
       setVisible(true);
    }




    public void bloquea(){
        try{
            File le_Tipo_User = new File("Config/tipo_user.ini");
            FileReader file = new FileReader(le_Tipo_User);
            BufferedReader tipo_user = new BufferedReader(file);
            String tipo_usuario = tipo_user.readLine();

            if(tipo_usuario.equals("Agente")){
                bloquear_item();
            }
            //String str = ""+nome_usuario;
            //jLabel16.setText(str);
        }catch(IOException ex){

        }

        //if(str.equals("Agente")){
          //     bloquear_item();
        //}
    }

    public void bloquear_item(){
        jButton11.setEnabled(false);
        jButton10.setEnabled(false);
        jLabel6.setEnabled(false);
        jLabel7.setEnabled(false);

        jLabel6.enable(false);
        jLabel7.enable(false);

        jLabel8.setEnabled(false);
        jLabel9.setEnabled(false);
        jMenuItem1.setEnabled(false);
        jMenuItem6.setEnabled(false);
        jMenuItem7.setEnabled(false);
    }
    //conexaoMySql valida = new conexaoMySql();





    public void seta_usuario(){

        try{
            File leUser = new File("Config/user.ini");
            FileReader file = new FileReader(leUser);
            BufferedReader user = new BufferedReader(file);
            String nome_usuario = user.readLine();

            String str = ""+nome_usuario;
            jLabel16.setText(str);
        }catch(IOException ex){

        }



    }


   

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new TelaPrincipal().setVisible(true);
                
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    javax.swing.JButton jButton10;
    javax.swing.JButton jButton11;
    javax.swing.JButton jButton12;
    javax.swing.JButton jButton13;
    javax.swing.JButton jButton14;
    javax.swing.JButton jButton15;
    javax.swing.JButton jButton2;
    javax.swing.JButton jButton6;
    javax.swing.JLabel jLabeHora;
    javax.swing.JLabel jLabel1;
    javax.swing.JLabel jLabel10;
    javax.swing.JLabel jLabel11;
    javax.swing.JLabel jLabel12;
    javax.swing.JLabel jLabel13;
    javax.swing.JLabel jLabel14;
    javax.swing.JLabel jLabel15;
    javax.swing.JLabel jLabel16;
    javax.swing.JLabel jLabel16Data;
    javax.swing.JLabel jLabel18;
    javax.swing.JLabel jLabel19;
    javax.swing.JLabel jLabel2;
    javax.swing.JLabel jLabel20;
    javax.swing.JLabel jLabel21;
    javax.swing.JLabel jLabel3;
    javax.swing.JLabel jLabel4;
    javax.swing.JLabel jLabel5;
    javax.swing.JLabel jLabel6;
    javax.swing.JLabel jLabel7;
    javax.swing.JLabel jLabel8;
    javax.swing.JLabel jLabel9;
    javax.swing.JMenu jMenu1;
    javax.swing.JMenu jMenu2;
    javax.swing.JMenu jMenu3Estilo;
    javax.swing.JMenu jMenu5;
    javax.swing.JMenu jMenu6;
    javax.swing.JMenu jMenu7;
    javax.swing.JMenuBar jMenuBar1;
    javax.swing.JMenuItem jMenuItem1;
    javax.swing.JMenuItem jMenuItem10;
    javax.swing.JMenuItem jMenuItem11;
    javax.swing.JMenuItem jMenuItem12;
    javax.swing.JMenuItem jMenuItem13;
    javax.swing.JMenuItem jMenuItem14;
    javax.swing.JMenuItem jMenuItem2;
    javax.swing.JMenuItem jMenuItem3;
    javax.swing.JMenuItem jMenuItem4;
    javax.swing.JMenuItem jMenuItem5;
    javax.swing.JMenuItem jMenuItem6;
    javax.swing.JMenuItem jMenuItem7;
    javax.swing.JMenuItem jMenuItem8;
    javax.swing.JMenuItem jMenuItem9;
    javax.swing.JPanel jPanel1;
    javax.swing.JPanel jPanel2;
    javax.swing.JPanel jPanel3;
    javax.swing.JPanel jPanel4;
    javax.swing.JPanel jPanel5;
    javax.swing.JPanel jPanel6;
    javax.swing.JPanel jPanel7;
    javax.swing.JScrollPane jScrollPane1;
    javax.swing.JSeparator jSeparator1;
    javax.swing.JSeparator jSeparator2;
    javax.swing.JSeparator jSeparator3;
    javax.swing.JPopupMenu.Separator jSeparator4;
    javax.swing.JPopupMenu.Separator jSeparator5;
    javax.swing.JTabbedPane jTabbedPane1;
    javax.swing.JLabel lb_imagem;
    javax.swing.JTextArea log;
    javax.swing.JLabel picture;
    javax.swing.JLabel status;
    javax.swing.JLabel tf_curso;
    javax.swing.JLabel tf_modulo;
    javax.swing.JLabel tf_nome;
    javax.swing.JLabel tf_rg;
    org.netbeans.examples.lib.timerbean.Timer timer1;
    // End of variables declaration//GEN-END:variables
}
