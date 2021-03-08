/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fluxograma;

import Fluxograma.ConstantesFiguras;
import com.mxgraph.layout.hierarchical.mxHierarchicalLayout;
import com.mxgraph.layout.mxStackLayout;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.util.mxConstants;
import com.mxgraph.view.mxGraph;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.SwingConstants;
import Fluxograma.NoFluxograma;
/**
 *
 * @author alian
 */
public class Fluxograma {
  
   private mxGraph grafico;
   private Object parent;
   private mxGraphComponent graficoComponente;  
   private NoFluxograma noInicialFluxograma = null;
   private HashMap nosJaInseridos;
   private ArrayList<VerticeOrigemDestino>ligacoes;

    public Fluxograma() {
      grafico = new mxGraph();
      parent = grafico.getDefaultParent();
      graficoComponente = new mxGraphComponent(grafico); 
       nosJaInseridos = new HashMap<NoFluxograma, Object>();
      ligacoes = new ArrayList<VerticeOrigemDestino>();
    }
    
  public void adicionaNoJaInserido(NoFluxograma noInserido, Object figura){
     nosJaInseridos.put(noInserido, figura);
  }   
  
   public Object verificaSeJaInseriuNoFluxograma(NoFluxograma no){
      if(nosJaInseridos.containsKey(no)){
          return nosJaInseridos.get(no);
      }else{
        return null;
      } 
     
   } 
   
   public boolean verificaSeJaInseriuLigacao(VerticeOrigemDestino origemDestino){
      return ligacoes.contains(origemDestino); 
   }
    
  public Object desenhaFigura(Figura figura, NoFluxograma no){
       Object aux = null;
       grafico.getModel().beginUpdate();
       try {
            figura.DefineAlturaLarguraPeloTextoFigura();
            aux = grafico.insertVertex(parent, null, figura.getTextoFigura().trim(), figura.getX(), figura.getY(), figura.getLargura(),
                                            figura.getAltura(), "ROUNDED;strokeColor=black;fillColor="+ figura.getCor() +";fontColor=black;shape=" + figura.getCorpoFigura());
           
           

       } finally {
           grafico.getModel().endUpdate();
       }
       return aux; 
   }
   
   public void desenhaLinhaLigacaoFigura(Object figuraOrigem, Object figuraDestino, String textoLigacao){
       grafico.getModel().beginUpdate();
       try {
        Object a =   grafico.insertEdge(parent,
                                        null,
                                        textoLigacao,
                                        figuraOrigem,
                                        figuraDestino,
                                        "edgeStyle=elbowEdgeStyle;elbow=vertical"
                                        );

//           + "exitX=0.5;exitY=1;exitPerimeter=1;entryX=0;entryY=0;entryPerimeter=1;"
          }finally{
		 grafico.getModel().endUpdate();}
    }
   
    public mxGraph getGrafico() {
        return grafico;
    }
    
  public Object criaFigura(NoFluxograma noInserir, int x, int y) {
        Object figura = null;
        String label = "";

        label = noInserir.getTextoFigura();

        switch (noInserir.getIdFigura()) {
            case ConstantesFiguras.idFiguraAtribuicao:
                figura = desenhaFigura(new FiguraAtribuicao(label, x, y), noInserir);
                break;

            case ConstantesFiguras.idFiguraCriacao:
                figura = desenhaFigura(new FiguraCriacaoVariavel(label, x, y), noInserir);
                break;

            case ConstantesFiguras.idFiguraElse:
                figura = desenhaFigura(new FiguraElse(label, x, y), noInserir);
                break;

            case ConstantesFiguras.idFiguraIF:
                figura = desenhaFigura(new FiguraIF2(label, x, y), noInserir);
                break;

            case ConstantesFiguras.idFiguraQualquerComando:
                figura = desenhaFigura(new FiguraQualquerComando(label, x, y), noInserir);
                break;

            case ConstantesFiguras.idFiguraWhile:
                figura = desenhaFigura(new FiguraWhile(label, x, y), noInserir);
                break;
                
            case ConstantesFiguras.idFiguraFor:
                 figura = desenhaFigura(new FiguraFor(label, x, y), noInserir);
                 break;
                
            case ConstantesFiguras.idFiguraInicioFim:
                 figura = desenhaFigura(new FiguraInicioFim(label), noInserir);
                 break;
                 
            case ConstantesFiguras.idFiguraSwitch:
                  figura = desenhaFigura(new FiguraSwtich(label, x, y), noInserir);
                  break;
                  
            case ConstantesFiguras.idFiguraCase:
                 figura = desenhaFigura(new FiguraCase(label, x, y), noInserir);
                 break;
                 
            case ConstantesFiguras.idFiguraDefault:
                 figura = desenhaFigura(new FiguraDefault(label, x, y), noInserir);
                 break;
                 
            default:
                figura = desenhaFigura(new FiguraQualquerComando(label, x, y), noInserir);
                break;

        }
        return figura;
    }

   
    public void setaCaracteristicasGrafico(){
      grafico.getModel().beginUpdate();
      try{
//          mxRadialTreeLayout m = new mxRadialTreeLayout(grafico, false);
          mxHierarchicalLayout  m = new mxHierarchicalLayout(grafico, SwingConstants.VERTICAL);
          m.setInterRankCellSpacing(30);
          m.execute(grafico.getDefaultParent());
          
      }
          
     finally
          {
            grafico.getModel().endUpdate();
                  }
    }
    
    public void adicionaNoFluxograma(NoFluxograma noInserir, NoFluxograma Anterior, Object noAnterior, int nivel, int y, int x) {
        if (noInserir == null) {
            return;
        }

        if (noInicialFluxograma == null) {
            noInicialFluxograma = noInserir;
        }

        Object noExecucao = verificaSeJaInseriuNoFluxograma(noInserir);
        if (noExecucao == null) {
            noExecucao = criaFigura(noInserir, x, y);
            adicionaNoJaInserido(noInserir, noExecucao);

            if (noInserir.quantidadeDeProximosNos() == 0) {
                return;
            } else {
                int x2 = 50;
                int y2 = nivel * 90;
                for (NoFluxograma no : noInserir.getProximo()) {
                    adicionaNoFluxograma(no, noInserir, noExecucao, nivel + 1, y2, x2);
                    y2 = nivel * 90;
                    x2 = x2 + 400;
                }
            }
        }
    }
    
    
    public void adicionaLigacoes(ArrayList<VerticeOrigemDestino> verticeOrigemDestino) {
        for (VerticeOrigemDestino origemDestino : verticeOrigemDestino) {
            if (!verificaSeJaInseriuLigacao(origemDestino)) {
                desenhaLinhaLigacaoFigura(this.nosJaInseridos.get(origemDestino.getNoOrigem()),
                                          this.nosJaInseridos.get(origemDestino.getNoDestino()),
                                          origemDestino.getTextoLigacao());

                ligacoes.add(origemDestino);
            }
        }
    }


    public Object getParent() {
        return parent;
    }

   

    public mxGraphComponent getGraficoComponente() {
        return graficoComponente;
    }

  
    
    
}
