package View;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class testeConcatenar {

    public static String[] push(String[] array, String itemAdicionado){
        int tamanhoArray = array.length;
        String[] arrayNovo = new String[array.length + 1];
        for(int x=0; x < tamanhoArray; x++){
            arrayNovo[x] = array[x];
        }
        arrayNovo[array.length] = itemAdicionado;
        return arrayNovo;
    }
    public static void main(String[] args) throws ParseException{
        /*String dia, mes, ano;
        dia = "31";
        mes = "12";
        ano = "1998";
        String data = ano.concat("-").concat(mes).concat("-").concat(dia);
        System.out.println(data);
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date dataFormatada = formato.parse(data);
        System.out.println("Data formatada: " + formato.format(dataFormatada));
        System.out.println("Date = " + dataFormatada);*/ // <-primeiro comentario

        



        //String data = "31-12-1998";
        /*String[] array = new String[] {"Murilo Marques Peres"};
        array = push(array, "Isadora Marques Peres");
        array = push(array, "Marcelo de Souza Peres");

        for(String item : array){
            System.out.print("item: " + item + ", ");
        }*/ // <-segundo comentario

        /*String[] array = new String[]{"Something"};
        String[] array2 = new String[]{"Something else"};
        array = array2;
        array = new String[]{"Another thing"};
        System.out.println(array[0]);*/ // <-terceiro comentario
    }
}
