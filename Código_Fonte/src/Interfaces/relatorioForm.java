/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * relatorioForm.java
 *
 * Created on 19/11/2011, 14:34:26
 */
package Interfaces;

import conexaoBancoDeDados.conexaoMySql;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;

public class relatorioForm extends javax.swing.JDialog {

    /** Creates new form relatorioForm */
    public relatorioForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        relatorioVisitante();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Relatório de visitante");
        setResizable(false);

        jScrollPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jTextArea1.setColumns(20);
        jTextArea1.setEditable(false);
        jTextArea1.setFont(new java.awt.Font("Arial", 0, 12));
        jTextArea1.setForeground(new java.awt.Color(102, 102, 102));
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jScrollPane1.setViewportView(jTextArea1);

        jMenu2.setText("Exportar");

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/pdf.png"))); // NOI18N
        jMenuItem1.setText("PDF");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 786, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 477, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        JFileChooser chooser = new JFileChooser();
        Document documento = new Document();
		chooser.addChoosableFileFilter(new TemplateFileFilter());
		while (true) {
			if (chooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
				try {
					File file = chooser.getSelectedFile();
					if (!file.toString().toLowerCase().endsWith(".pdf"))
						file = new File(file.toString() + ".pdf");
					if (file.exists()) {
						int choice = JOptionPane.showConfirmDialog(this,
							String.format("O arquivo \"%1$s\" já existe.\nDeseja substituí-lo ?", file.toString()),
							"Salvando PDF",
							JOptionPane.YES_NO_CANCEL_OPTION);
						if (choice == JOptionPane.NO_OPTION)
							continue;
						else if (choice == JOptionPane.CANCEL_OPTION)
							break;
					}

                                        PdfWriter.getInstance(documento, new FileOutputStream(file));
                                        documento.open();
                                       documento.add(new Paragraph(jTextArea1.getText()));

				} catch (Exception ex) {
					
				}
			}
                        documento.close();
			break;
		}
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void relatorioVisitante() {
        conexaoMySql con = new conexaoMySql();
        con.eventuaCenexao();
        con.executaComandosSql("select * from visitante");      
                

        try {
                jTextArea1.append("             ==========================================================================\n");
                jTextArea1.append("                                                     RELATÓRIO DE VISITANTE\n");
                jTextArea1.append("             ==========================================================================");


                
                
            while (con.resultset.next()) {               
                jTextArea1.append("\n\n\n             CÓDIGO:..................................");
                jTextArea1.append(con.resultset.getString("vis_codigo"));
                jTextArea1.append("\n\n");

               
                jTextArea1.append("             NOME:.......................................");
                jTextArea1.append(con.resultset.getString("vis_nome"));
                jTextArea1.append("\n\n");
                

                jTextArea1.append("             RG:............................................");
                jTextArea1.append(con.resultset.getString("vis_rg"));
                jTextArea1.append("\n\n");

                jTextArea1.append("             SEXO:........................................");
                jTextArea1.append(con.resultset.getString("vis_sexo"));
                jTextArea1.append("\n\n");

                jTextArea1.append("             HORÁRIO DE ENTRADA:..........");
                jTextArea1.append(con.resultset.getString("vis_hora_entrada"));
                jTextArea1.append("\n\n");

                jTextArea1.append("             DATA:........................................");
                jTextArea1.append(con.resultset.getString("vis_data"));
                jTextArea1.append("\n\n");

                jTextArea1.append("             MOTIVO DA VISITA: ");
               // jTextArea1.append("\n\n");


                File leArquivo = new File(con.resultset.getString("vis_motivo_visita"));
                FileReader leitura = new FileReader(leArquivo);
                BufferedReader text = new BufferedReader(leitura);
                String line;
               
                while ((line = text.readLine()) != null) {
                
                jTextArea1.append(line);
               
                }
                text.close();
                jTextArea1.append("\n\n\n\n");
            }
        } catch (IOException erro) {
            JOptionPane.showMessageDialog(this, "Erro ao ler um arquivo.");
        } catch (SQLException eroo) {
            JOptionPane.showMessageDialog(this, "erro sql");
        }
        /*
        try {
        con.resultset.first();
        jTextPane1.setText(con.resultset.getString("vis_nome"));
        } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "ero");
        }*/
    }
    public class TemplateFileFilter extends javax.swing.filechooser.FileFilter {
		 public boolean accept(File f) {
			return f.getName().endsWith(".pdf");
		}
		 public String getDescription() {
			return "Arquivo PDF (*.pdf)";
		}
	}

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                relatorioForm dialog = new relatorioForm(new javax.swing.JFrame(), true);
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
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
