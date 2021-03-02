package edu.fiuba.algo3;

import edu.fiuba.algo3.Vista.ContenedorPrincipal;
import edu.fiuba.algo3.modelo.Personaje;
import edu.fiuba.algo3.modelo.TableroAlgoritmo;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    private Personaje personaje;
    private TableroAlgoritmo tableroAlgoritmo;

    @Override
    public void start(Stage stage) throws Exception {

        this.inicializarModelo();

        ContenedorPrincipal contenedorPrincipal = new ContenedorPrincipal(stage,personaje,tableroAlgoritmo);
        Scene escenaPrincipal = new Scene(contenedorPrincipal,1000,500);

        stage.setScene(escenaPrincipal);
        stage.show();
    }

    private void inicializarModelo() {
        personaje = new Personaje();
        tableroAlgoritmo = new TableroAlgoritmo(personaje);
    }

    public static void ejecutar(String[] args)
    {
        launch(args);
    }
}
