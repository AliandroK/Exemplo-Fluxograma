/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tela;

import Fluxograma.ConstantesFiguras;
import Fluxograma.Fluxograma;
import Fluxograma.VerticeOrigemDestino;
import javax.swing.JFrame;

import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.util.mxConstants;
import com.mxgraph.view.mxGraph;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JScrollPane;
import Fluxograma.NoFluxograma;

public class telaFluxograma extends JFrame
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2707712944901661771L;
         Fluxograma fluxograma = null;
         
        @SuppressWarnings("unused")
	public telaFluxograma()
	{
             super("FluxoGrama");
//             this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             this.setSize(400, 600);
             fluxograma = new Fluxograma();
//             this.setVisible(true);
//             fluxograma = new Fluxograma();
             JScrollPane scroll_pane = new JScrollPane();
             scroll_pane.setBounds(0, 0, 400, 600);
             scroll_pane.setBackground(Color.white);
             scroll_pane.setViewportView(fluxograma.getGraficoComponente());
             this.getContentPane().add(scroll_pane);
             scroll_pane.setVisible(true);
             fluxograma.getGraficoComponente().setVisible(true);
        }
        
         public void ExecutaFluxograma(NoFluxograma noInicial, ArrayList<VerticeOrigemDestino>ligacoes){
           this.fluxograma.adicionaNoFluxograma(noInicial, null, null, 1 , 0, 250);
           this.fluxograma.adicionaLigacoes(ligacoes);
           this.fluxograma.setaCaracteristicasGrafico();
         }
        
    public static void main(String[] args)
	{
	telaFluxograma telaFluxograma = new telaFluxograma();
                
        ArrayList<VerticeOrigemDestino>ligacoesNos;
        ligacoesNos = new ArrayList<VerticeOrigemDestino> ();
        
        NoFluxograma no = new NoFluxograma("Teste", ConstantesFiguras.idFiguraInicioFim);
        NoFluxograma no2 = new NoFluxograma("Teste 2", ConstantesFiguras.idFiguraAtribuicao);
        no.AddProximo(no2);

        ligacoesNos.add(new VerticeOrigemDestino(no, no2, "ligacao 1"));
        NoFluxograma no3 = new NoFluxograma("Teste 2", ConstantesFiguras.idFiguraCriacao);
        ligacoesNos.add(new VerticeOrigemDestino(no, no3, "ligacao 2"));
        no.AddProximo(no3);
        
        NoFluxograma no4 = new NoFluxograma("Teste 2", ConstantesFiguras.idFiguraIF);
        ligacoesNos.add(new VerticeOrigemDestino(no2, no4, "ligacao 3"));
        no2.AddProximo(no4);
          
        telaFluxograma tela = new telaFluxograma();
     
        tela.setVisible(true);
        tela.ExecutaFluxograma(no, ligacoesNos);
//                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setSize(400, 600);
//		frame.setVisible(true);
}
}