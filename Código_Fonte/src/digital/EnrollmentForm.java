package digital;

import com.digitalpersona.onetouch.*;
import com.digitalpersona.onetouch.processing.*;
import java.awt.*;
import java.io.FileOutputStream;
import javax.swing.JOptionPane;
import conexaoBancoDeDados.conexaoMySql;
import java.sql.SQLException;
import javax.swing.JFrame;

public class EnrollmentForm extends CaptureForm {

    private DPFPEnrollment enroller = DPFPGlobal.getEnrollmentFactory().createEnrollment();  //captura e analiza o templete
    public String TEMPLATE_PROPERTY = "template";
    private DPFPTemplate template;
    public String nomeDigital, pasta;
    conexaoMySql con = new conexaoMySql();

    public EnrollmentForm(JFrame owner) {
        super(owner);
    }

    @Override
    protected void init() {
        super.init();       
        updateStatus();
        this.setTitle("Impressão digital");
    }

    @Override
    protected void process(DPFPSample sample) {
        super.process(sample);
        // Process the sample and create a feature set for the enrollment purpose.
        DPFPFeatureSet features = extractFeatures(sample, DPFPDataPurpose.DATA_PURPOSE_ENROLLMENT); //produz um templete da digital

        // Check quality of the sample and add to enroller if it's good
        if (features != null) {
            try {
                makeReport("Criando template da digital...");
                enroller.addFeatures(features);		// Add feature set to template.
            } catch (DPFPImageQualityException ex) {
            } finally {
                updateStatus();

                // Check if template has been created.
                switch (enroller.getTemplateStatus()) {
                    case TEMPLATE_STATUS_READY:	// report success and stop capturing
                        stop();
                        setTemplate(enroller.getTemplate());
                        setPrompt("Digital cadastrada com sucesso.");
                        makeReport("TEMPLATE CRIADO");                       
                        status.setBackground(Color.GREEN);
                        break;

                    case TEMPLATE_STATUS_FAILED:	// report failure and restart capturing
                        enroller.clear();
                        stop();
                        updateStatus();
                        setTemplate(null);
                        JOptionPane.showMessageDialog(EnrollmentForm.this, "A digital não é válida. Repita o cadastro novamente.", "Cadastro", JOptionPane.ERROR_MESSAGE);
                        status.setBackground(Color.red);
                        start();
                        break;
                }


            }

        }

    }

    private void updateStatus() {
        // Show number of samples needed.
        setStatus(String.format("Quantidade de imagens necessárias: %1$s", enroller.getFeaturesNeeded()));
    }

    public void setTemplate(DPFPTemplate template) {
        DPFPTemplate old = this.template;
        this.template = template;
        firePropertyChange(TEMPLATE_PROPERTY, old, template);

        try {
            String caminho = "templetes/"+pasta+"/" + nomeDigital + ".fpt";
            //FileOutputStream stream = new FileOutputStream("templetes/"+pasta+"/" + nomeDigital + ".fpt");
            FileOutputStream stream = new FileOutputStream(caminho);
            stream.write(template.serialize());
            stream.close();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Erro na gravação de um arquivo.","Erro", JOptionPane.ERROR_MESSAGE);
        }
        try {           
           // String inserTemplete = "insert into "+tabela+"(alu_digital)values('templetes/"+pasta+"/" + nomeDigital + ".fpt')";
            String inserTemplete = "insert into template(temp_dedo_1, temp_rg)values('templetes/"+pasta+"/" + nomeDigital + ".fpt' , '"+nomeDigital+"')";
            con.eventuaCenexao();
            con.executaComandosSql("select * from template");
            con.statement.executeUpdate(inserTemplete);

            /*inserTemplete = "insert into template(temp_rg)values('"+nomeDigital+"')";
            con.executaComandosSql("select * from template");
            con.statement.executeUpdate(inserTemplete);*/

            con.fechaConexao();
        } catch (SQLException erroSql) {
            JOptionPane.showMessageDialog(this, "erro");
        }
    }

    public DPFPTemplate getTemplate() {

        return template;
    }
}
