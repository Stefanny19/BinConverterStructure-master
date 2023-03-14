package Bin2DecConverter;

import Bin2DecConverter.Converter;
import Tools.LinkedList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);

        Converter converter;
        LinkedList<String> lista;

        System.out.println("¿Qué desea hacer?");
        System.out.println("1. Convertir de decimal a binario\n2. Convertir de binario a decimal");

        int option = leer.nextInt();

        if(option == 1){
            converter = new Converter();
            lista = converter.Dec2Bin(converter.pedirDeimal());
            System.out.println(lista.toString());

        } else if (option == 2) {
            converter = new Converter();
            System.out.println(converter.Bin2Dec(converter.pedirBinario()));
        }
    }
}