/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pilha;

/**
 *
 * @author renan
 */
public class Pilha {

    private Celulas inicio;
    private Celulas fim;
    private int tamanho;

    public int getTamanho() {
        return this.tamanho;
    }

    private Celulas criarNo(int valor) {
        Celulas no = new Celulas();
        no.setInfo(valor);
        return no;
    }

    public void inserir(int valor) {
        Celulas no = criarNo(valor);
        if (this.inicio == null) {
            this.inicio = this.fim = no;
            this.tamanho++;
        } else {
            Celulas ultimo = this.fim;
            ultimo.setProx(no);
            this.fim = no;
            this.tamanho++;
        }
    }
    
    public void remover() {
        if (this.inicio == null) {
            System.out.println("Pilha não possui nenhum elemento");
            return;
        }
        if (this.tamanho == 1) {
            this.inicio = this.fim = null;
            this.tamanho--;
        } else {
            Celulas anterior = null;
            Celulas ultimo = this.inicio;
            for (int i = 1; i < this.tamanho; i++) {
                anterior = ultimo;
                ultimo = ultimo.getProx();
            }
            anterior.setProx(null);
            this.fim = anterior;
            this.tamanho--;
        }
    }
    
    public void imprimirLista() {
        Celulas no = this.inicio;
        for (int i = 1; i <= this.tamanho; i++) {
            System.out.print(no.getInfo());
            if (i < this.tamanho) {
                System.out.print(" ---> ");
            }
            no = no.getProx();
        }
    }

    public boolean buscarElemento(int valor) {
        Celulas no = this.inicio;
        for (int i = 1; i <= this.tamanho; i++) {
            if (no.getInfo() == valor) {
                return true;
            }
            no = no.getProx();
        }
        return false;
    }
}
