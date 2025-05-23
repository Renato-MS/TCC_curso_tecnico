package digital;

import com.digitalpersona.onetouch.*;
import com.digitalpersona.onetouch.verification.*;
import java.awt.*;
import conexaoBancoDeDados.conexaoMySql;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class VerificationForm extends CaptureForm {

    private DPFPVerification verificator = DPFPGlobal.getVerificationFactory().createVerification();
    DPFPVerificationResult result;
    public conexaoMySql conet = new conexaoMySql();
    boolean resultado = true;
    public static String TEMPLATE_PROPERTY = "template";
    private DPFPTemplate template;
    public String RG;

    public VerificationForm(JFrame owner) {
        super(owner);
    }

    @Override
    protected void init() {
        // conet.eventuaCenexao();
        super.init();
        this.setTitle("Impressão digital");
        updateStatus(0);
    }

    @Override
    protected void process(DPFPSample sample) {
        super.process(sample);

        // Process the sample and create a feature set for the enrollment purpose.
        DPFPFeatureSet features = extractFeatures(sample, DPFPDataPurpose.DATA_PURPOSE_VERIFICATION);
        //conet.eventuaCenexao();
        //abreconexao.ligaConect();
        // while(features != null)
        //{

        // Check quality of the sample and start verification if it's good


        if (features != null) {			// Compare the feature set with our template
            String restagaTemplate = "select * from template where temp_rg = '"+RG+"'";
            conet.executaComandosSql(restagaTemplate);
            //verificaConstantemente();
            while (resultado == true) {
                try {
                    conet.resultset.next();
                    String retorno = conet.resultset.getString("temp_dedo_1");

                    FileInputStream stream = new FileInputStream(retorno);

                    byte[] data = new byte[stream.available()];
                    stream.read(data);
                    stream.close();
                    DPFPTemplate t = DPFPGlobal.getTemplateFactory().createTemplate(); 
                    t.deserialize(data);
                    setTemplate(t);

                    result = verificator.verify(features, getTemplate());
                    updateStatus(result.getFalseAcceptRate());

                    if (result.isVerified()) {
                        makeReport("A digital está CORRETA");                       
                        break;
                    }

                    // JOptionPane.showMessageDialog(null, retorno);
                } catch (SQLException ex) {
                    makeReport("A digital está ERRADA");                   
                    break;
                } catch (IOException erro) {
                    JOptionPane.showMessageDialog(null, "erro IO");
                    break;
                }

            }


        }

    }

    private void updateStatus(int FAR) {
        // Show "False accept rate" value
        setStatus(String.format("Resultado = %1$s", FAR));
    }

    public DPFPTemplate getTemplate() {
        //JOptionPane.showMessageDialog(null, "gettemplate");
        return template;
    }

    public void setTemplate(DPFPTemplate template) {
        DPFPTemplate old = this.template;
        this.template = template;
        firePropertyChange(TEMPLATE_PROPERTY, old, template);
    }
}
