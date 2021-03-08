/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fluxograma;

import com.mxgraph.util.mxConstants;

/**
 *
 * @author alian
 */
public class FiguraQualquerComando extends Figura{
   
   public FiguraQualquerComando(String textoFigura, int x, int y) {
        super(mxConstants.SHAPE_RECTANGLE, textoFigura, x, y, "#e6dbe2");
    } 
}
