package View;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class testeConcatenar {
    public static void main(String[] args) throws ParseException{
        String dia, mes, ano;
        dia = "31";
        mes = "12";
        ano = "1998";
        String data = ano.concat("-").concat(mes).concat("-").concat(dia);
        System.out.println(data);
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date dataFormatada = formato.parse(data);
        System.out.println("Data formatada: " + formato.format(dataFormatada));
        System.out.println("Date = " + dataFormatada);
        
    }
}
