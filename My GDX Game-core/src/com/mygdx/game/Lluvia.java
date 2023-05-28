package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;



public class Lluvia {
	private Array<Gota> rainDropsPos;
	//private Array<Integer> rainDropsType;
	//private Array<Integer> rainDropsFall;
    private long lastDropTime;
    private Texture gotaBuena;
    private Texture gotaMala;
    private Sound dropSound;
    private Music rainMusic;
	   
	public Lluvia(Texture gotaBuena, Texture gotaMala, Sound ss, Music mm) {
		rainMusic = mm;
		dropSound = ss;
		this.gotaBuena = gotaBuena;
		this.gotaMala = gotaMala;
	}
	
	public void crear() {
		rainDropsPos = new Array<Gota>();
		//rainDropsType = new Array<Integer>();
		//rainDropsFall = new Array<Integer>();
		crearGotaDeLluvia();
	      // start the playback of the background music immediately
	      rainMusic.setLooping(true);
	      rainMusic.play();
	}
	
	private void crearGotaDeLluvia() {
	      //Rectangle raindrop = new Rectangle();
	   // ver el tipo de gota
	      int i = MathUtils.random(0, 2);
	      int j = MathUtils.random(1,20);
	      if (j <2) {
	    	  GotaPotenciador gotita = new GotaPotenciador();
	    	  gotita.crearGotaDeLluvia(i);
	    	  rainDropsPos.add(gotita);
	      }
	      else if(j<6) {
	    	  GotaEmpeorar gotita = new GotaEmpeorar();
	    	  gotita.crearGotaDeLluvia(i);
	    	  rainDropsPos.add(gotita);
	      }
	      else if (j<11) {	 
	    	  GotaMala gotita = new GotaMala();
	      	  gotita.crearGotaDeLluvia(i);
	      	  rainDropsPos.add(gotita);
	         //rainDropsType.add(1);
	      }
	      else {
	    	  GotaBuena gotita = new GotaBuena();
	    	  gotita.crearGotaDeLluvia(i);
	    	  rainDropsPos.add(gotita);
	      }
	    	 //rainDropsType.add(2);
	      
		      lastDropTime = TimeUtils.nanoTime();
	      
	   }
	
   public void actualizarMovimiento(Tarro tarro) { 
	   // generar gotas de lluvia 
	   if(TimeUtils.nanoTime() - lastDropTime > 100000000) crearGotaDeLluvia();
	  
	   
	   // revisar si las gotas cayeron al suelo o chocaron con el tarro
	   for (int i=0; i < rainDropsPos.size; i++ ) {
		  Gota gotita = rainDropsPos.get(i);
		  gotita.actualizarMovimiento(tarro);
	      
	      //cae al suelo y se elimina
	      if(gotita.getRectangulo().y + 64 < 0) {
	    	  rainDropsPos.removeIndex(i); 
	    	  //rainDropsType.removeIndex(i);
	    	  //rainDropsFall.removeIndex(i);
	      }
	      if(gotita.getRectangulo().overlaps(tarro.getArea())) { //la gota choca con el tarro
	    	  gotita.chocarTarro(tarro);
	    	  rainDropsPos.removeIndex(i);
	      }
	   }   
   }
   
   public void actualizarDibujoLluvia(SpriteBatch batch) { 
	   
	  for (int i=0; i < rainDropsPos.size; i++ ) {
		  Gota gotita = rainDropsPos.get(i);
		  gotita.actualizarDibujo(batch); 
	   }
   }
   public void destruir() {
	      dropSound.dispose();
	      rainMusic.dispose();
   }
   
}
