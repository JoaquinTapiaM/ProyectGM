package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;


public abstract class Gota implements Movible{
	private int subir;
	private Rectangle rectangulo;
	private Texture textura;
	
	public abstract void crearGotaDeLluvia(int i);
	
	
	public abstract void chocarTarro(Pou tarro);
	

	
	public void actualizarDibujo(SpriteBatch batch) {
		batch.draw(textura, rectangulo.x, rectangulo.y); 	
	}
	
	public void actualizarMovimiento(Pou tarro) {
		if(this.getSubir()==1) {
			  rectangulo.y -= 300 * Gdx.graphics.getDeltaTime();
		  }
		  else {
			  rectangulo.y += 300 * Gdx.graphics.getDeltaTime();
		  }
	}
	
	public Rectangle getRectangulo() {
		return rectangulo;
	}
	
	public void setRectangulo(Rectangle rectangulo) {
		this.rectangulo = rectangulo;
	}
	
	public Texture getTextura() {
		return this.textura;
	}
	
	public void setTextura(Texture textura) {
		this.textura = textura;
	}
	
	public int getSubir() {
		return subir;
	}
	
	public void setSubir(int subir) {
		this.subir = subir;
	}
	
	
}