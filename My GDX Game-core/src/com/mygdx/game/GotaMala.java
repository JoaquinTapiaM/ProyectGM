package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;

public class GotaMala extends Gota{
	@Override
	public void crearGotaDeLluvia(int i) {
		// TODO Auto-generated method stub
		this.rectangulo = new Rectangle();
		int a = MathUtils.random(1, 3);
		if(a == 1) {
    		this.textura = new Texture(Gdx.files.internal("basura1.png"));
    		}
    	if(a == 2) {
    		this.textura = new Texture(Gdx.files.internal("basura2.png"));
    		}
    	if(a == 3) {
    		this.textura = new Texture(Gdx.files.internal("basura3.png"));
    		}
		
		
	      if(i <2) {
	    	  rectangulo.x = MathUtils.random(0, 800-64);
	    	  rectangulo.y = 480;
	    	  rectangulo.width = 64;
	    	  rectangulo.height = 64;
	    	  setSubir(1);  
	      }
	      else {
	    	  rectangulo.x = MathUtils.random(0, 800-64);
	    	  rectangulo.y = 0;
	    	  rectangulo.width = 64;
	    	  rectangulo.height = 64;
	    	  setSubir(2);
	      }
		
	}

	@Override
	public void chocarTarro(Tarro tarro) {
		// TODO Auto-generated method stub
		tarro.dañar();
		
	}

}
