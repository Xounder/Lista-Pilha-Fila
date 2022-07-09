/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listasduplamenteencadeadas;

/**
 *
 * @author renan
 */
public class Celulas {
    private int info;
    private Celulas anterior; 
    private Celulas prox;
   
    public void setProx(Celulas prox) {
        this.prox = prox;
    }
    
    public Celulas getProx() {
        return prox;
    }

    public void setInfo(int info) {
        this.info = info;
    }    
    
    public int getInfo() {
        return info;
    }

    public void setAnterior(Celulas anterior) {
        this.anterior = anterior;
    }
    
    public Celulas getAnterior() {
        return anterior;
    }    
}


