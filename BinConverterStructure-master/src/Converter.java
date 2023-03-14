import Tools.LinkedList;
import Tools.Node;

import java.math.BigInteger;
import java.util.Iterator;
import java.util.Scanner;


public class Converter {

    LinkedList<String> decimal;
    LinkedList<String > binario;
    Scanner leer = new Scanner(System.in);

    public Converter() {
    }

    public LinkedList<Integer> pedirDeimal(){

        LinkedList<Integer> dec = new LinkedList<>();

        System.out.print("Ingrese el numero decimal: ");
        String digitos = leer.nextLine();

        for( char x: digitos.toCharArray()){
            dec.add(Character.getNumericValue(x));
        }

        return dec;
    }

    public LinkedList<Integer> pedirBinario() {

        boolean banderita = false;

        LinkedList<Integer> bina = new LinkedList<>();

        System.out.println("Ingrese el numero binario: ");
        String nbinario = leer.nextLine();

        for(char x: nbinario.toCharArray()){
            if(x == 0 || x == 1){
                banderita = true;
            }else {
                break;
            }
        }

        for(char j : nbinario.toCharArray()){
            bina.add(Character.getNumericValue(j));
        }

        return bina;
    }

    public LinkedList<String> Dec2Bin(LinkedList<Integer> dec){

        BigInteger residuo;
        BigInteger numero = new BigInteger(dec.toString());
        BigInteger cociente = new BigInteger(String.valueOf(2));
        BigInteger temp = new BigInteger(String.valueOf(1));
        BigInteger num = new BigInteger(String.valueOf(2)); //Para convertir a binario, se divide entre 2

        while (cociente.compareTo(temp) >= 1){

            cociente = numero.divide(num);
            residuo = numero.mod(num);

            numero = cociente;

            binario.add(residuo.toString());
        }

        return decimal;

    }

    public String Bin2Dec(LinkedList<Integer> bin){

        BigInteger decimal = new BigInteger("0");
        double pow;
        int index = 0;
        int i = bin.size() - 1;

        LinkedList<Integer> temp = new LinkedList<>();

        //Pasar la conversion a una lista temporal con los digitos del decimal
        while (i >= 0){
            pow = Math.pow(2, index);
            temp.addFirst((int) (bin.pop() * pow));
            index++;
            i--;
        }

        //Sumar digitos de la lista para obtener el decimal
        Iterator<Node> iterator = temp.iterator();

        while (iterator.hasNext()){
            int coso = (int) iterator.next().getObject();
            BigInteger si = new BigInteger(String.valueOf(coso));

            decimal = new BigInteger(decimal.add(si).toString());
        }

        return decimal.toString();
    }


}
