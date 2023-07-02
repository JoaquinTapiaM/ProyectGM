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
		Rectangle r = new Rectangle();
		Texture text = new Texture(Gdx.files.internal("redbull.png"));
		this.dropSound = Gdx.audio.newSound(Gdx.files.internal("Waltuh.mp3"));
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
	    setTextura(text);
	}

	
	@Override
	public void chocarTarro(Pou tarro) {
		// TODO Auto-generated method stub
		tarro.mejorar();
		dropSound.play();
	}

}
