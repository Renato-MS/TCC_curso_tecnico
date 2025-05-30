/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ExcluirUsuario.java
 *
 * Created on 07/12/2011, 21:56:34
 */

package Interfaces;

import conexaoBancoDeDados.conexaoMySql;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Familia
 */
public class ExcluirUsuario extends javax.swing.JDialog {
    String nome_usuario;

    /** Creates new form ExcluirUsuario */
    public ExcluirUsuario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        bd_default();
        ComboBox();
        seta_usuario();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tf_senha = new javax.swing.JTextField();
        bt_excluir = new javax.swing.JButton();
        cb_NomeUsuarioAtual = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Conta de Usuário");
        setAlwaysOnTop(true);
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Excluir Usuário", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 0, 12), new java.awt.Color(0, 0, 255))); // NOI18N

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Nome do Usuário:");

        jLabel2.setText("Senha do Administrador:");

        tf_senha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_senhaActionPerformed(evt);
            }
        });

        bt_excluir.setText("Excluir");
        bt_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_excluirActionPerformed(evt);
            }
        });

        cb_NomeUsuarioAtual.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bt_excluir, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cb_NomeUsuarioAtual, javax.swing.GroupLayout.Alignment.LEADING, 0, 167, Short.MAX_VALUE)
                    .addComponent(tf_senha, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cb_NomeUsuarioAtual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf_senha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(bt_excluir)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        java.awt.Dimension dialogSize = getSize();
        setLocation((screenSize.width-dialogSize.width)/2,(screenSize.height-dialogSize.height)/2);
    }// </editor-fold>//GEN-END:initComponents

    private void tf_senhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_senhaActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_tf_senhaActionPerformed
        conexaoMySql valida = new conexaoMySql();
    private void bt_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_excluirActionPerformed
        // TODO add your handling code here:
        boolean excluido = false;
        try {

            if (cb_NomeUsuarioAtual.getSelectedItem().equals("-") || tf_senha.getText().equals("")) {

                throw new IllegalAccessError();

            } else {

                try{
                valida.executaComandosSql("SELECT * FROM login");
                    while(valida.resultset.next()){
                        
                        /*JOptionPane.showMessageDialog(this,"teste "+nome_usuario+"  "+valida.resultset.getString("log_usuario")+" \n \n"
                                + tf_senha.getText()+ " "+valida.resultset.getString("log_senha"));*/
                        if(nome_usuario.equals(valida.resultset.getString("log_usuario")) && tf_senha.getText().equals(valida.resultset.getString("log_senha"))){
                            //JOptionPane.showMessageDialog(this,"teste "+nome_usuario);
                            while(valida.resultset.first() || valida.resultset.next()){
                                //valida.resultset.first();
                                //JOptionPane.showMessageDialog(this,"asdf");
                                valida.statement.executeUpdate("DELETE FROM login "
                                + "WHERE log_usuario = '"+cb_NomeUsuarioAtual.getSelectedItem()+"'");
                                
                                excluido = true;
                                JOptionPane.showMessageDialog(this,"Usuário excluído com sucesso","Conta de Usuário",JOptionPane.INFORMATION_MESSAGE);
                                LimpaComboBox();
                                break;

                            }
                            break;
                        }


                    
                    
                }
                    if(excluido == false){
                        JOptionPane.showMessageDialog(this,"Senha incorreta \n\nDigite a senha do Administrador LOGADO neste momento.","Conta de Usuário",JOptionPane.INFORMATION_MESSAGE);
                    }

                }catch(Exception ex){
                    JOptionPane.showMessageDialog(this,"Erro de sintaxe");
                }

            }

        } catch (IllegalAccessError erroDado) {

            JOptionPane.showMessageDialog(this,"Preencha Todos os Campos!", "", 2);
            tf_senha.requestFocus();
        }


        // private void gravarDados(){


        //}
        /*
        boolean log_feito = false;

        try {
            while (valida.resultset.next()) {
                if (jTextField1.getText().equals(valida.resultset.getString("log_usuario")) && jPassword.getText().equals(valida.resultset.getString("log_senha"))) {
                    if (valida.resultset.getString("log_tipo_usuario").equals("Administrador")) {
                        log_feito = true;
                        new TelaPrincipal().setVisible(true);
                        dispose();
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(this, "Zé Ruela vc n loga ainda");
                        log_feito = true;
                    }

                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Usuário ou senha estão incorretos", "Erro de Autenticação", JOptionPane.ERROR_MESSAGE);
        }*/
}//GEN-LAST:event_bt_excluirActionPerformed


    public void seta_usuario(){

        try{
            File leUser = new File("Config/user.ini");
            FileReader file = new FileReader(leUser);
            BufferedReader user = new BufferedReader(file);
            nome_usuario = user.readLine();


            //String str = ""+nome_usuario;
            //jLabel16.setText(str);
        }catch(IOException ex){

        }



    }

    public void LimpaComboBox(){

        tf_senha.setText("");
        cb_NomeUsuarioAtual.removeAllItems();
        cb_NomeUsuarioAtual.addItem("-");
        ComboBox();
    }

    public void ComboBox(){
        //cb_NomeUsuarioAtual.set
        //cb.addItem();
        //boolean log_feito = false;
       valida.executaComandosSql("SELECT log_usuario FROM login ORDER BY log_usuario");
        try {
            while (valida.resultset.next()) {

                if(valida.resultset.getString("log_usuario").equals(null)){

                }else{
                cb_NomeUsuarioAtual.addItem(valida.resultset.getString("log_usuario"));
                }
                /*if (jTextField1.getText().equals(valida.resultset.getString("log_usuario")) && jPassword.getText().equals(valida.resultset.getString("log_senha"))) {
                    if (valida.resultset.getString("log_tipo_usuario").equals("Administrador")) {
                        log_feito = true;
                        new TelaPrincipal().setVisible(true);
                        dispose();
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(this, "Zé Ruela vc n loga ainda");
                        log_feito = true;
                    }

                }*/
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Usuário ou senha estão incorretos", "Erro de Autenticação", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void bd_default() {
        valida.eventuaCenexao();


    }

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ExcluirUsuario dialog = new ExcluirUsuario(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton bt_excluir;
    private javax.swing.JComboBox cb_NomeUsuarioAtual;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField tf_senha;
    // End of variables declaration//GEN-END:variables

}
