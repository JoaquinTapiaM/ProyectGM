package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;

public class GotaBuena extends Gota {
    private Sound dropSound;
    
    public void crearGotaDeLluvia(int i) {
    	Rectangle r = new Rectangle();
    	int a = MathUtils.random(1, 3);
    	Texture text;
    	if(a == 1) {
    		text = new Texture(Gdx.files.internal("fruta1.png"));
    		}
    	if(a == 2) {
    		text = new Texture(Gdx.files.internal("fruta2.png"));
    		}
    	else{
    		text = new Texture(Gdx.files.internal("fruta3.png"));
    		}
    	this.dropSound = Gdx.audio.newSound(Gdx.files.internal("drop.wav"));
    	setTextura(text);
    	r.x = MathUtils.random(0, 800-64);
	  	r.y = 480;
	  	r.width = 64;
	  	r.height = 64;
	      if(i <2) {
	    	  setSubir(1);  
	      }
	      else {
	    	  setSubir(2);
	      }
	    setRectangulo(r);
	}
    
    public void actualizarMovimiento(Pou tarro) {
		if(this.getSubir()==1) {
			  getRectangulo().y -= 300 * Gdx.graphics.getDeltaTime();
		  }
		  else {
			  getRectangulo().y += 300 * Gdx.graphics.getDeltaTime();
		  }
	}
    
	public void chocarTarro(Pou tarro) {
		// TODO Auto-generated method stub
		tarro.sumarPuntos(1);
        dropSound.play();
	}

	
	

}
