/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fila;
import java.util.Scanner;
/**
 *
 * @author renan
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int num, opcao;
	Fila fila = new Fila();
        Scanner input = new Scanner(System.in);
        
        do{
            System.out.println("\n-------------------------------------------------------");
            System.out.println("01 - Exibir Fila");
            System.out.println("02 - Inserir");
            System.out.println("03 - Remover");
            System.out.println("04 - Buscar Elemento");
            System.out.println("05 - Tamanho da Fila");
            System.out.println("0 - Sair");
            System.out.println("\n-------------------------------------------------------");
            opcao = input.nextInt();
            switch(opcao){
                case 1:
                    fila.imprimirLista();
                    break;
                case 2:
                    System.out.println("Digite o valor a ser inserido");
                    num = input.nextInt();
                    fila.inserir(num);
                    break;
                case 3:
                    fila.remover();
                    break;
                case 4:
                    System.out.println("Digite o valor que deseja procurar");
                    num = input.nextInt();
                    if(fila.buscarElemento(num)){
                        System.out.println("O valor existe na Fila");
                    }else{
                        System.out.println("O valor não existe na Fila");
                    }
                    break;
                case 5:
                    System.out.println("O tamanho da Fila: " + fila.getTamanho());
                    break;
                default:
                    System.out.println("Opção Inválida");
                    break;       
            }
        }while(opcao != 0);
    }
}
