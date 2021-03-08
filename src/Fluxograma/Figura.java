/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fluxograma;

/**
 *
 * @author alian
 */
public class Figura {
    
    private String corpoFigura;
    private double largura;
    private double altura;
    private String textoFigura;
    private String cor;
    private double x;
    private double y;

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public String getTextoFigura() {
        return textoFigura;
    }

    public void setTextoFigura(String textoFigura) {
        this.textoFigura = textoFigura;
    }
    

    public String getCorpoFigura() {
        return corpoFigura;
    }

    public Figura(String corpoFigura, String textoFigura, double x, double y, String cor) {
        this.corpoFigura = corpoFigura;
        this.textoFigura = textoFigura;
        this.cor = cor; 
        this.x = x;
        this.y = y;
    }

    public void setCorpoFigura(String corpoFigura) {
        this.corpoFigura = corpoFigura;
    }

    public double getLargura() {
        return largura;
    }

    public void setLargura(double largura) {
        this.largura = largura;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public Figura(String corpoFigura, String textoFigura, String cor) {
        this.corpoFigura = corpoFigura;
        this.textoFigura = textoFigura;
        this.cor = cor;
    }
    
    public void DefineAlturaLarguraPeloTextoFigura(){
      this.largura = (this.textoFigura.length() * 5);
      
      if(this.largura < 50){
        this.largura = 50;
      }else{
         this.largura = this.largura + 50;
      }
      
      this.altura  = 50;
    
    }
    
}
