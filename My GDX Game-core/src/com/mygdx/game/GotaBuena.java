package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;

public class GotaBuena extends Gota {
    private Sound dropSound;
    
    public void crearGotaDeLluvia(int i) {
    	this.rectangulo = new Rectangle();
    	int a = MathUtils.random(1, 3);
    	if(a == 1) {
    		this.textura = new Texture(Gdx.files.internal("fruta1.png"));
    		}
    	if(a == 2) {
    		this.textura = new Texture(Gdx.files.internal("fruta2.png"));
    		}
    	if(a == 3) {
    		this.textura = new Texture(Gdx.files.internal("fruta3.png"));
    		}
    	this.dropSound = Gdx.audio.newSound(Gdx.files.internal("drop.wav"));
    	
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
    
    public void actualizarMovimiento(Tarro tarro) {
		if(this.getSubir()==1) {
			  rectangulo.y -= 300 * Gdx.graphics.getDeltaTime();
		  }
		  else {
			  rectangulo.y += 300 * Gdx.graphics.getDeltaTime();
		  }
	}
    
	public void chocarTarro(Tarro tarro) {
		// TODO Auto-generated method stub
		tarro.sumarPuntos(1);
        dropSound.play();
	}

	
	

}
