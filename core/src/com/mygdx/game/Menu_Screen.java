package com.mygdx.game;

/**
 * Created by Laurenz on 15.11.2015.
 */

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;


/**
 * Created by Laurenz on 15.11.2015.
 */
public class Menu_Screen implements Screen {

    Controller controller;
    Model model;
    Stage stage;
    OrthographicCamera camera;
    private KeyBack_Menu_Screen game;

    private TextButton tb;
    private Texture texture;
    private SpriteBatch batch;

    /**
     * Konstruktor, gleicht der create- Methode
     * @param g
     */
    public Menu_Screen(KeyBack_Menu_Screen g) {
        game = g;
        camera = new OrthographicCamera();
        batch = new SpriteBatch();
        stage = new Stage();


         Skin skin = new Skin(Gdx.files.internal("uiskin.json")); //Skins für Actor

        camera = new OrthographicCamera();      //Setzt Kamera
        camera.setToOrtho(false, 1920, 1080); //Kameragröße
        camera.update();

        controller= new Controller(this,model,game);
        //All Events will be Handeld by Controller Class
        Gdx.input.setInputProcessor(controller);

        //Schriftgröße wird geändert
        skin.getFont("default-font").getData().setScale(3, 3);

        //Tabelle und Button wird erstellt und Positioniert
        Table table = new Table();
        tb = new TextButton("Start Game", skin);
        tb.setSize(tb.getWidth() + 300, tb.getHeight() + 100);
        table.row().height(200).width(200);
        tb.setPosition(Gdx.graphics.getWidth() / 2 - tb.getWidth() / 2, Gdx.graphics.getHeight() / 2 - tb.getHeight() / 2); //Mitte von Bildschirm
        table.add(tb);
        table.setFillParent(true);

        //Hintergrundbild
        texture = new Texture(Gdx.files.internal("ele.jpg"));

         //Actors werden Listener hinzugefügt
        tb.addListener(controller);

        //Wird der Stage hinzugefügt (Layout - Behälter)
        stage.addActor(tb);
        stage.addActor(table);
    }


    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 2, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();

        batch.begin();
        batch.draw(texture, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch.end();

        stage.act(delta);
        stage.draw();

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }

    public TextButton getTb() {
        return tb;
    }

    public void setTb(TextButton tb) {
        this.tb = tb;
    }
}
