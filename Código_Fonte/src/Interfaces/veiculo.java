

package Interfaces;
import conexaoBancoDeDados.conexaoMySql;
import java.awt.Frame;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import utilitarios.DataHora;

public class veiculo extends javax.swing.JDialog {
conexaoMySql conexaoParaCarro = new conexaoMySql();;
DataHora horaDoSistema = new DataHora();
String nomeProprientario = null , rgProprietario = null;

    public veiculo(Frame owner) {
        super(owner, true);
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().createImage(getClass().getResource("/icones/carro.png")));
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jButton1Novo = new javax.swing.JButton();
        jButton2Excluir = new javax.swing.JButton();
        jButton3Gravar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldPlaca = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldCor = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jPanel4 = new javax.swing.JPanel();
        jTextFieldNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldRg = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Veículo");

        jPanel7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel7.setLayout(new javax.swing.BoxLayout(jPanel7, javax.swing.BoxLayout.LINE_AXIS));

        jPanel8.setLayout(new java.awt.BorderLayout());

        jButton1Novo.setText("Novo");
        jButton1Novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1NovoActionPerformed(evt);
            }
        });
        jPanel8.add(jButton1Novo, java.awt.BorderLayout.CENTER);

        jButton2Excluir.setText("Excluir");
        jButton2Excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ExcluirActionPerformed(evt);
            }
        });
        jPanel8.add(jButton2Excluir, java.awt.BorderLayout.PAGE_START);

        jButton3Gravar.setText("Gravar");
        jButton3Gravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3GravarActionPerformed(evt);
            }
        });
        jPanel8.add(jButton3Gravar, java.awt.BorderLayout.PAGE_END);

        jPanel7.add(jPanel8);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Dados de carro", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 255))); // NOI18N

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Carro", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jPanel3.setPreferredSize(new java.awt.Dimension(220, 221));

        jLabel1.setText("Placa:");

        jLabel2.setText("Cor:");

        jLabel5.setText("Tipo:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pequeno Porte", "Médio porte", "Grande porte", "Motocicleta" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextFieldPlaca, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                    .addComponent(jTextFieldCor, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                    .addComponent(jComboBox1, 0, 198, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldPlaca)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldCor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Proprietário", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jLabel3.setText("Nome:");

        jLabel4.setText("RG:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldRg, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldRg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(99, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                .addGap(60, 60, 60)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 547, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        java.awt.Dimension dialogSize = getSize();
        setLocation((screenSize.width-dialogSize.width)/2,(screenSize.height-dialogSize.height)/2);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3GravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3GravarActionPerformed
    horaDoSistema.leHora();
    conexaoParaCarro.eventuaCenexao();
    conexaoParaCarro.executaComandosSql("select * from veiculo");
    try
    {
      if(jTextFieldCor.getText().equals("")||jTextFieldNome.getText().equals("")
         || jTextFieldPlaca.getText().equals("")||jTextFieldRg.getText().equals(""))
      {
          throw new IllegalAccessError();
      }
      try
      {        
        String gravaRegistroVeiculo = "insert into veiculo(vei_placa,vei_tipo,vei_proprietario,vei_hora_entrada,vei_data)values('"
                +jTextFieldPlaca.getText()+"','"+jComboBox1.getSelectedItem()+"','"+jTextFieldNome.getText()
                +"','"+horaDoSistema.getHora()+"','"+horaDoSistema.getDataHoraParaBanco()+"')";
        
        conexaoParaCarro.statement.executeUpdate(gravaRegistroVeiculo);
        conexaoParaCarro.fechaConexao();
        JOptionPane.showMessageDialog(null,"\nCadastro realizado com êxito");
        dispose();
      }
      catch(SQLException erroSql)
      {
        JOptionPane.showMessageDialog(rootPane, "Ocorreu um erro");
      }
    }
    catch(IllegalAccessError erro)
    {
        JOptionPane.showMessageDialog(null, "Não foi possível gravar o registro para veículo\n"
                + "certifique-se que todos os campos foram preenchidos");
    }    
    
    }//GEN-LAST:event_jButton3GravarActionPerformed

    private void jButton2ExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ExcluirActionPerformed
    int a = JOptionPane.showConfirmDialog(this, "Deseja apagar o registro ?","Escolha",JOptionPane.YES_NO_OPTION);
    if(a == JOptionPane.YES_OPTION)
    {

        if(jTextFieldPlaca.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Informe a placa do carro",null,JOptionPane.WARNING_MESSAGE);
        }else{
            conexaoParaCarro.eventuaCenexao();
                try {
                    conexaoParaCarro.executaComandosSql("select * from veiculo");
                    conexaoParaCarro.statement.executeUpdate("delete from veiculo where vei_placa = '" + jTextFieldPlaca.getText()+"'");
                } catch (SQLException ex) {
                   JOptionPane.showMessageDialog(this, "Erro",null,JOptionPane.WARNING_MESSAGE);
                }
            conexaoParaCarro.fechaConexao();
        }
    }
    }//GEN-LAST:event_jButton2ExcluirActionPerformed

    private void jButton1NovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1NovoActionPerformed
       jTextFieldCor.setText(null);
       jTextFieldNome.setText(null);
       jTextFieldPlaca.setText(null);
       jTextFieldRg.setText(null);
    }//GEN-LAST:event_jButton1NovoActionPerformed
   
    public void recebeDadosvisitate()
    {
       
        jTextFieldNome.setText(nomeProprientario);
        jTextFieldRg.setText(rgProprietario);
        
    }    
    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                veiculo dialog = new veiculo(new javax.swing.JFrame());
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
    private javax.swing.JButton jButton1Novo;
    private javax.swing.JButton jButton2Excluir;
    private javax.swing.JButton jButton3Gravar;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JTextField jTextFieldCor;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldPlaca;
    private javax.swing.JTextField jTextFieldRg;
    // End of variables declaration//GEN-END:variables

}
