/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fluxograma;

import Fluxograma.NoFluxograma;

/**
 *
 * @author alian
 */
public class VerticeOrigemDestino {
   private NoFluxograma noOrigem;
   private NoFluxograma noDestino;
   private String textoLigacao;

    public String getTextoLigacao() {
        return textoLigacao;
    }

    public void setTextoLigacao(String textoLigacao) {
        this.textoLigacao = textoLigacao;
    }

    public NoFluxograma getNoOrigem() {
        return noOrigem;
    }

    public void setNoOrigem(NoFluxograma noOrigem) {
        this.noOrigem = noOrigem;
    }

    public NoFluxograma getNoDestino() {
        return noDestino;
    }

    public void setNoDestino(NoFluxograma noDestino) {
        this.noDestino = noDestino;
    }

    public VerticeOrigemDestino(NoFluxograma noOrigem, NoFluxograma noDestino, String textoLigacao) {
        this.noOrigem = noOrigem;
        this.noDestino = noDestino;
        this.textoLigacao = textoLigacao;
    }
   
   
}
