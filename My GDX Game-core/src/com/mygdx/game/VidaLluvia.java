package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class VidaLluvia {
	public abstract void crear();
	public abstract void crearGotaDeLluvia();
	public abstract void actualizarMovimiento(Pou tarro);
	public abstract void actualizarDibujoLluvia(SpriteBatch batch);
	public abstract void destruir();
	//Pou tarro,SpriteBatch batch
	public void funcion(Pou pou){
		crear();
		crearGotaDeLluvia();
		
	}
}
