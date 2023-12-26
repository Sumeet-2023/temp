package de.tum.cit.ase.maze;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class SettingsScreen implements Screen {
    private final Stage stage;
    private final OrthographicCamera camera;
    private final MazeRunnerGame game;

    public SettingsScreen(MazeRunnerGame game) {
        this.game = game;
        camera=new OrthographicCamera();
        camera.zoom=1.0f;
        Viewport viewport=new ScreenViewport(camera) ;
        stage=new Stage(viewport, game.getSpriteBatch());
        Table table=new Table();
        table.setFillParent(true);
        stage.addActor(table);
        TextButton backGroundMusic=new TextButton("Music",game.getSkin());
        table.add(backGroundMusic).width(250).pad(30).row();
        TextButton sound= new TextButton("Sound",game.getSkin());
        table.add(sound).width(250).pad(10).row();

    }
    public void render(float delta) {
        if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
            game.goToMenu();
        }
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); // Clear the screen
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f)); // Update the stage
        stage.draw(); // Draw the stage
    }
    public void resize(int width, int height) {
        camera.setToOrtho(false);
    }

    public void pause() {
    }

    public void resume() {
    }

    public void show() {

    }


    public void hide() {
    }


    public void dispose() {
    }

}

