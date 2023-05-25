package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;


public abstract class Gota {
	private int subir;
	public Rectangle rectangulo;
	public Texture textura;
	
	public abstract void crearGotaDeLluvia(int i);
	
	
	public abstract void chocarTarro(Tarro tarro);
	

	
	public void actualizarDibujo(SpriteBatch batch) {
		batch.draw(textura, rectangulo.x, rectangulo.y); 
	}
	
	public void actualizarMovimiento(Tarro tarro) {
		if(this.getSubir()==1) {
			  rectangulo.y -= 300 * Gdx.graphics.getDeltaTime();
		  }
		  else {
			  rectangulo.y += 300 * Gdx.graphics.getDeltaTime();
		  }
		if(rectangulo.overlaps(tarro.getArea())) {
			chocarTarro(tarro);
		}
	}
	
	public Rectangle getRectangulo() {
		return rectangulo;
	}
	
	public int getSubir() {
		return subir;
	}
	
	public void setSubir(int subir) {
		this.subir = subir;
	}
	
	
}