package digital;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import com.digitalpersona.onetouch.*;
import com.digitalpersona.onetouch.capture.*;
import com.digitalpersona.onetouch.capture.event.*;
import com.digitalpersona.onetouch.processing.*;

public class CaptureForm extends JDialog {

    private DPFPCapture capturer = DPFPGlobal.getCaptureFactory().createCapture();   

    private JLabel picture = new JLabel();
    private JTextField prompt = new JTextField();
    public JTextArea log = new JTextArea();
    public JTextField status = new JTextField("[nulo]");
 

    public CaptureForm(JFrame owner) {
        super(owner, true);
        setTitle("Impressão digital");        
        setLayout(new BorderLayout());
        rootPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        picture.setPreferredSize(new Dimension(200, 280));
        picture.setBorder(BorderFactory.createLoweredBevelBorder());
        prompt.setFont(UIManager.getFont("Panel.font"));
        prompt.setEditable(false);
        prompt.setColumns(40);
        prompt.setMaximumSize(prompt.getPreferredSize());
        prompt.setBorder(
                BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0), "Mensagem: "),
                BorderFactory.createLoweredBevelBorder()));
        log.setColumns(40);
        log.setEditable(false);
        log.setFont(UIManager.getFont("Panel.font"));
        JScrollPane logpane = new JScrollPane(log);
        log.setBackground(Color.black);
        log.setForeground(Color.GREEN);
        logpane.setBorder(
                BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0), "Eventos do leitor:"),
                BorderFactory.createLoweredBevelBorder()));

        status.setEditable(false);
        status.setBorder(BorderFactory.createEmptyBorder(15, 5, 5, 5));
        status.setFont(UIManager.getFont("Panel.font"));
        status.setForeground(Color.blue);        
        status.setFont(new Font(null, Font.BOLD, 12));

        JButton quit = new JButton("Sair");
        quit.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                
            }
        });

        JPanel right = new JPanel(new BorderLayout());
        right.setBackground(Color.getColor("control"));
        right.add(prompt, BorderLayout.PAGE_START);
        right.add(logpane, BorderLayout.CENTER);

        JPanel center = new JPanel(new BorderLayout());
        center.setBackground(Color.getColor("control"));
        center.add(right, BorderLayout.CENTER);
        center.add(picture, BorderLayout.LINE_START);
        center.add(status, BorderLayout.PAGE_END);
        
       


        JPanel bottom = new JPanel(new FlowLayout(FlowLayout.TRAILING));
        bottom.setBackground(Color.getColor("control"));
        bottom.add(quit);

        setLayout(new BorderLayout());
        add(center, BorderLayout.CENTER);
        add(bottom, BorderLayout.PAGE_END);



        this.addComponentListener(new ComponentAdapter() {

            @Override
            public void componentShown(ComponentEvent e) {
                init();
                start();
               // JOptionPane.showMessageDialog(null, "ok");


            }

            @Override
            public void componentHidden(ComponentEvent e) {
                stop();           
                
            }
        });
        

        pack();
        setAlwaysOnTop(true);
        setLocationRelativeTo(null);        
    }   

    protected void init() {
        capturer.addDataListener(new DPFPDataAdapter() {

            @Override
            public void dataAcquired(final DPFPDataEvent e) {
                SwingUtilities.invokeLater(new Runnable() {

                    public void run() {
                        makeReport("A digital foi capturada.");
                        //setPrompt("Scan the same fingerprint again.");
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
    }

    protected void start() {
        capturer.startCapture();
        setPrompt("Usando o leitor, coloque o dedo.");

    }

    protected void stop() {
        capturer.stopCapture();
    }

    public void setStatus(String string) {
        status.setText(string);

    }

    public void setPrompt(String string) {
        prompt.setText(string);

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
}
