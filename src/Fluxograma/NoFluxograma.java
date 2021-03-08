
package Fluxograma;

import java.util.ArrayList;


public class NoFluxograma {
  
    private String textoFigura;
    private int idFigura;
    private ArrayList<NoFluxograma> proximo;
    private ArrayList<NoFluxograma> anterior;

    public String getTextoFigura() {
        return textoFigura;
    }
    
    public int quantidadeDeProximosNos(){
      return proximo.size();
    }

    public ArrayList<NoFluxograma> getProximo() {
        return proximo;
    }
    
    

    public void setTextoFigura(String textoFigura) {
        this.textoFigura = textoFigura;
    }

    public int getIdFigura() {
        return idFigura;
    }

    public void setIdFigura(int idFigura) {
        this.idFigura = idFigura;
    }

//    public NoFluxograma getProximo() {
//        return proximo;
//    }

    public void AddProximo(NoFluxograma proximo) {
        if(!this.proximo.contains(proximo)){
           this.proximo.add(proximo);
        }
    }

 

    public void AddAnterior(NoFluxograma anterior) {
        if(!this.anterior.contains(anterior)){
            this.anterior.add(anterior);
        }
    }

    public NoFluxograma(String textoFigura, int idFigura) {
        this.textoFigura = textoFigura;
        this.idFigura = idFigura;
        
        this.proximo = new ArrayList<NoFluxograma>();
        this.anterior = new ArrayList<NoFluxograma>();
    }
    
    
    
}
