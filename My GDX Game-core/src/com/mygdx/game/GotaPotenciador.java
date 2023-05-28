package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;

public class GotaPotenciador extends Gota{

	private Sound dropSound;

	@Override
	public void crearGotaDeLluvia(int i) {
		// TODO Auto-generated method stub
		this.rectangulo = new Rectangle();
		this.textura = new Texture(Gdx.files.internal("redbull.png"));
		this.dropSound = Gdx.audio.newSound(Gdx.files.internal("Waltuh.mp3"));
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
		tarro.mejorar();
		dropSound.play();
	}

}
