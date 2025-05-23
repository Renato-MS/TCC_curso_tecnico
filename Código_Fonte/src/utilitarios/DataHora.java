

package utilitarios;

import java.text.SimpleDateFormat;
import java.util.Date;


public class DataHora
{
    private String hora,Data, dataParaBanco;
    private SimpleDateFormat horaAtual = new SimpleDateFormat("HH:mm:ss");
    private SimpleDateFormat dataHoje = new SimpleDateFormat("dd/M/yyyy");
    private SimpleDateFormat dataBanco = new SimpleDateFormat("yyyy-M-dd"); //formato para ser gravado no banco de dados

    Date CapturaHoraData;
    public void leHora()
    {
        CapturaHoraData = new Date();
        hora = horaAtual.format(CapturaHoraData);
        Data = dataHoje.format(CapturaHoraData);
    }   
   
    public String getData()
    {
        return Data;
    }
    public String getHora() //esse metodo tambem é usado para gravar a hora para o banco
    {
        return hora;
    }

    public String getDataHoraParaBanco()
    {
        CapturaHoraData = new Date();
        dataParaBanco = dataBanco.format(CapturaHoraData);
        return dataParaBanco;
    }

   
}
