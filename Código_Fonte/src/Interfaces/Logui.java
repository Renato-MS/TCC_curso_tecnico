package Interfaces;

import conexaoBancoDeDados.conexaoMySql;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class Logui extends javax.swing.JDialog {

    conexaoMySql valida = new conexaoMySql();
    String texto;
    String usuario;

    @SuppressWarnings("LeakingThisInConstructor")
    public Logui() {
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().createImage(getClass().getResource("/icones/imgOpen.png")));
        bd_default();

        retornaAparencia();

        try {
            //UIManager.setLookAndFeel("ch.randelshofer.quaqua.QuaquaLookAndFeel");
            // UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");

            if (texto != null) {
                UIManager.setLookAndFeel(texto);
                SwingUtilities.updateComponentTreeUI(this);
            } else {
                UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
                SwingUtilities.updateComponentTreeUI(this);
            }
        } catch (Exception erro) {
            try {
                UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
                SwingUtilities.updateComponentTreeUI(this);
            } catch (Exception e) {
            }
        }


    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel3Logo = new javax.swing.JLabel();
        jPassword = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Autenticação");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(null);

        jLabel1.setText("Usuário:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(12, 13, 60, 14);

        jTextField1.setToolTipText("Digite o nome de usuário cadastrado na base de dados.");
        jPanel1.add(jTextField1);
        jTextField1.setBounds(12, 33, 250, 30);

        jLabel2.setText("Senha:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(10, 90, 60, 14);

        jButton1.setText("Entrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(190, 150, 75, 30);

        jButton2.setText("Cancelar");
        jButton2.setPreferredSize(new java.awt.Dimension(80, 23));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(270, 150, 90, 30);

        jLabel3Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/imgClose.png"))); // NOI18N
        jPanel1.add(jLabel3Logo);
        jLabel3Logo.setBounds(250, 10, 120, 130);

        jPassword.setToolTipText("Digite a senha cadastrada na base de dados.");
        jPanel1.add(jPassword);
        jPassword.setBounds(10, 110, 250, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        java.awt.Dimension dialogSize = getSize();
        setLocation((screenSize.width-dialogSize.width)/2,(screenSize.height-dialogSize.height)/2);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (jTextField1.getText().equals("Administrador") && jPassword.getText().equals("etec")) {
            new TelaPrincipal().setVisible(true);
            dispose();
        } else {
            valida.executaComandosSql("SELECT * FROM login");

            boolean log_feito = false;

            try {
                while (valida.resultset.next()) {
                    if (jTextField1.getText().equals(valida.resultset.getString("log_usuario")) && jPassword.getText().equals(valida.resultset.getString("log_senha"))) {
                        if (valida.resultset.getString("log_tipo_usuario").equals("Administrador")) {
                            log_feito = true;
                            guarda_user();
                            guarda_tipo_user();
                            new TelaPrincipal().setVisible(true);
                            dispose();
                        } else {
                            guarda_user();
                            guarda_tipo_user();
                            new TelaPrincipal().setVisible(true);
                            log_feito = true;
                            dispose();

                        }

                    }
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Usuário ou senha estão incorretos", "Erro de Autenticação", JOptionPane.ERROR_MESSAGE);
            }
            if (log_feito == false) {
                JOptionPane.showMessageDialog(null, "Usuário ou senha estão errados\nou não consegue achar o banco de dados.\n\n"
                        + "> Informe o nome de usuário e senha corretamente.\n> Verifique se ambos estão cadastrados no banco de dados.\n> "
                        + "Certifique-se que o MySQL está instalado.\n> Observe se o banco de dados foi gravado corretamente com o nome de \"etec\".\n\n"
                        + "Caso o banco de dados esteja armazenado em outro computador,\nfeche o programa e execute o aplicativo configPC, informe o nome\nou endereço IP "
                        + "do mesmo.",
                        "Erro de autenticação", JOptionPane.ERROR_MESSAGE);
            }

        }

    }//GEN-LAST:event_jButton1ActionPerformed

    public void guarda_user() {
        try {
            FileWriter nome_user = new FileWriter("Config/user.ini");
            nome_user.write(valida.resultset.getString("log_usuario"));
            nome_user.close();
        } catch (IOException erro) {
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "---", "Erro de Autenticação", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void guarda_tipo_user() {
        try {
            FileWriter tipo_user = new FileWriter("Config/tipo_user.ini");
            tipo_user.write(valida.resultset.getString("log_tipo_usuario"));
            tipo_user.close();
        } catch (IOException erro) {
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "---", "Erro de Autenticação", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButton2ActionPerformed
    public void bd_default() {
        valida.eventuaCenexao();


    }

    public final void retornaAparencia() {
        try {
            File leArquivo = new File("Config/LookAndFeel.ini");
            FileReader leitura = new FileReader(leArquivo);
            BufferedReader text = new BufferedReader(leitura);
            texto = text.readLine();

        } catch (IOException erro) {
        }
    }

    public void nomeComputador() {
        String comp;
        try {
            File pcNome = new File("conf.txt");
            FileReader obj = new FileReader(pcNome);
            BufferedReader text = new BufferedReader(obj);
            comp = text.readLine();
            //text.close();
        } catch (IOException erro) {
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Logui().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3Logo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPassword;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
