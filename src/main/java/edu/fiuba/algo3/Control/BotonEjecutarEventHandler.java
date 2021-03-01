package edu.fiuba.algo3.Control;

import edu.fiuba.algo3.Vista.PanelDibujo;
import edu.fiuba.algo3.modelo.Personaje;
import edu.fiuba.algo3.modelo.TableroAlgoritmo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonEjecutarEventHandler implements EventHandler<ActionEvent> {
    private TableroAlgoritmo armadorAlgoritmo;
    private Personaje personaje;
    private PanelDibujo panelDibujo;
    public BotonEjecutarEventHandler(TableroAlgoritmo armadorAlgoritmo, PanelDibujo panelDibujo, Personaje personaje) {
        this.armadorAlgoritmo = armadorAlgoritmo;
        this.panelDibujo = panelDibujo;
        this.personaje = personaje;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        panelDibujo.resetear();
        personaje.subirLapiz();
        armadorAlgoritmo.ejecutarAlgoritmo();
        panelDibujo.dibujarAlgoritmo();
        }
}
