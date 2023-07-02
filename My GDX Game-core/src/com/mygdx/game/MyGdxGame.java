package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class MyGdxGame extends ApplicationAdapter {
	
	       private OrthographicCamera camera;
		   private SpriteBatch batch;	   
		   private BitmapFont font;
		   
		   private Pou pou;
		   private Lluvia lluvia;
		@Override
		public void create () {
			 font = new BitmapFont(); // use libGDX's default Arial font
			 
			  // load the images for the droplet and the bucket, 64x64 pixels each 	     
			  Sound hurtSound = Gdx.audio.newSound(Gdx.files.internal("Bonk.mp3"));
			  pou = Pou.getInstance(new Texture(Gdx.files.internal("pou.png")),hurtSound);
	          
		      // load the drop sound effect and the rain background "music" 
	          Texture gota = new Texture(Gdx.files.internal("drop.png"));
	          Texture gotaMala = new Texture(Gdx.files.internal("dropBad.png"));
	          
	          Sound dropSound = Gdx.audio.newSound(Gdx.files.internal("drop.wav"));
	         
		      Music rainMusic = Gdx.audio.newMusic(Gdx.files.internal("rain.mp3"));
	          lluvia = new Lluvia(gota, gotaMala, dropSound, rainMusic);
		      
		      // camera
		      camera = new OrthographicCamera();
		      camera.setToOrtho(false, 800, 480);
		      batch = new SpriteBatch();
		      // creacion del pou
		      pou.crear();
		      
		      // creacion de la lluvia
		      lluvia.funcion(pou);
		}
		


		@Override
		public void render () {
			//limpia la pantalla con color azul obscuro.
			ScreenUtils.clear(0, 0, 0.2f, 1);
			//actualizar matrices de la cámara
			camera.update();
			//actualizar 
			batch.setProjectionMatrix(camera.combined);
			batch.begin();
			//dibujar textos
			font.draw(batch, "Frutas totales: " + pou.getPuntos(), 5, 475);
			font.draw(batch, "Vidas : " + pou.getVidas(), 720, 475);
			
			if (!pou.estaHerido()) {
				// movimiento del tarro desde teclado
		        pou.actualizarMovimiento(pou);        
				// caida de la lluvia 
		        lluvia.actualizarMovimiento(pou);	   
			}
			
			pou.dibujar(batch);
			lluvia.actualizarDibujoLluvia(batch);
			
			batch.end();	
			
		}
		
		@Override
		public void dispose () {
		      pou.destruir();
	          lluvia.destruir();
		      batch.dispose();
		      font.dispose();
		}
	
}
