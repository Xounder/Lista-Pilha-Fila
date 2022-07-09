/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listasduplamenteencadeadas;
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
        int num, posicao, opcao;
	Lista lista = new Lista();
        Scanner input = new Scanner(System.in);
        
        do{
            System.out.println("\n-------------------------------------------------------");
            System.out.println("01 - Exibir Lista");
            System.out.println("02 - Inserir no Inicio");
            System.out.println("03 - Inserir no Meio");
            System.out.println("04 - Inserir no Fim");
            System.out.println("05 - Remover do Inicio");
            System.out.println("06 - Remover do Meio");
            System.out.println("07 - Remover do Fim");
            System.out.println("08 - Buscar Elemento");
            System.out.println("09 - Tamanho da Lista");
            System.out.println("0 - Sair");
            System.out.println("\n-------------------------------------------------------");
            opcao = input.nextInt();
            switch(opcao){
                case 1:
                    lista.imprimirLista();
                    break;
                case 2:
                    System.out.println("Digite o valor a ser inserido");
                    num = input.nextInt();
                    lista.inserirNoInicio(num);
                    break;
                case 3:
                    System.out.println("Digite o valor a ser inserido");
                    num = input.nextInt();
                    System.out.println("Digite a posição do valor a ser inserido");
                    posicao = input.nextInt();
                    lista.inserirNoMeio(num, posicao);
                    break;
                case 4:
                    System.out.println("Digite o valor a ser inserido");
                    num = input.nextInt();
                    lista.inserirNoFim(num);
                    break;
                case 5:
                    lista.removerDoInicio();
                    break;
                case 6:
                    System.out.println("Digite a posição a remover");
                    posicao = input.nextInt();
                    lista.removerDoMeio(posicao);
                    break;
                case 7:
                    lista.removerDoFim();
                    break;
                case 8:
                    System.out.println("Digite o valor que deseja procurar");
                    num = input.nextInt();
                    if(lista.buscarElemento(num)){
                        System.out.println("O valor existe na lista");
                    }else{
                        System.out.println("O valor não existe na lista");
                    }
                    break;
                case 9:
                    System.out.println("O tamanho da lista: " + lista.getTamanho());
                    break;
                default:
                    System.out.println("Opção Inválida");
                    break;       
            }
        }while(opcao != 0);
    }
    
}
