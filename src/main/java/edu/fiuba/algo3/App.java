package edu.fiuba.algo3;

import edu.fiuba.algo3.Vista.ContenedorPrincipal;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        ContenedorPrincipal contenedorPrincipal = new ContenedorPrincipal(stage);
        Scene escenaPrincipal = new Scene(contenedorPrincipal,1280,720);

        stage.setScene(escenaPrincipal);
        stage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
