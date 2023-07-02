package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;

public class GotaMala extends Gota{
	@Override
	public void crearGotaDeLluvia(int i) {
		// TODO Auto-generated method stub
		Rectangle r = new Rectangle();
		Texture text;
		int a = MathUtils.random(1, 3);
		if(a == 1) {
    		text = new Texture(Gdx.files.internal("basura1.png"));
    		}
    	if(a == 2) {
    		text = new Texture(Gdx.files.internal("basura2.png"));
    		}
    	else {
    		text = new Texture(Gdx.files.internal("basura3.png"));
    		}
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
	
	
	@Override
	public void chocarTarro(Pou tarro) {
		// TODO Auto-generated method stub
		tarro.dañar();
		
	}

}
