/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listasencadeadas;

/**
 *
 * @author renan
 */
public class Lista {

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

    public void inserirNoInicio(int valor) {
        Celulas no = criarNo(valor);
        if (this.inicio == null) {
            this.inicio = this.fim = no;
        } else {
            Celulas primeiro = this.inicio;
            no.setProx(primeiro);
            this.inicio = no;
        }
        this.tamanho++;
    }

    public void inserirNoFim(int valor) {
        if (this.tamanho == 0) {
            this.inserirNoInicio(valor);
        } else {
            Celulas no = criarNo(valor);
            Celulas anterior = this.fim;
            anterior.setProx(no);
            this.fim = no;
            this.tamanho++;
        }
    }

    public void inserirNoMeio(int valor, int pos) {
        if (pos >= 1 && pos <= this.tamanho + 1) {
            if (pos == 1) {
                this.inserirNoInicio(valor);
            } else {
                if (pos == this.tamanho + 1) {
                    this.inserirNoFim(valor);
                } else {
                    Celulas no = criarNo(valor);
                    Celulas anterior = this.inicio;
                    for (int i = 1; i <= this.tamanho; i++) {
                        if (i + 1 == pos) {
                            no.setProx(anterior.getProx());
                            anterior.setProx(no);
                        }
                        anterior = anterior.getProx();
                    }
                    this.tamanho++;
                }
            }
        } else {
            System.out.println("Posição Inválida!");
        }
    }

    public void removerDoInicio() {
        Celulas primeiro = this.inicio;
        if (this.inicio == null) {
            System.out.println("Lista não possui nenhum elemento");
        } else {
            if (this.tamanho == 1) {
                this.inicio = this.fim = null;
            } else {
                this.inicio = primeiro.getProx();
            }
            this.tamanho--;
        }
    }

    public void removerDoFim() {
        if (this.inicio == null) {
            System.out.println("Lista não possui nenhum elemento");
        }
        if (this.tamanho == 1) {
            this.removerDoInicio();
        } else {
            Celulas anterior = this.inicio;
            for (int i = 1; i <= this.tamanho; i++) {
                if (i + 1 == this.tamanho) {
                    this.fim = anterior;
                }
                anterior = anterior.getProx();
            }
            this.tamanho--;
        }
    }

    public void removerDoMeio(int pos) {
        if (pos >= 1 && pos <= this.tamanho) {
            if (this.inicio == null) {
                System.out.println("Lista não possui nenhum elemento");
                return;
            }
            if (pos == 1) {
                removerDoInicio();
            } else {
                if (pos == this.tamanho) {
                    removerDoFim();
                } else {
                    Celulas anterior = this.inicio;
                    for (int i = 1; i < this.tamanho; i++) {
                        if (i + 1 == pos) {
                            anterior.setProx(anterior.getProx().getProx());
                        }
                        anterior = anterior.getProx();
                    }
                    this.tamanho--;
                }
            }
        } else {
            System.out.println("Posição Inválida!");
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
