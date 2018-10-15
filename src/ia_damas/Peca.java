package ia_damas;

import static ia_damas.Damas.QUADRO_SIZE;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

/**
 *
 * @author Ronny's Note
 */
public class Peca extends StackPane {

    private TipoPeca tipo;
    private double mouseX, mouseY;
    private double oldX, oldY;

    public Peca(TipoPeca tipo, int x, int y) {
        this.tipo = tipo;

        relocate(x * QUADRO_SIZE, y * QUADRO_SIZE);

        Ellipse elipseBlack = new Ellipse(QUADRO_SIZE * 0.3125, QUADRO_SIZE * 0.26);
        elipseBlack.setFill(Color.BLACK);
        elipseBlack.setStroke(Color.BLACK);
        elipseBlack.setStrokeWidth(QUADRO_SIZE * 0.03);
        elipseBlack.setTranslateX((QUADRO_SIZE - QUADRO_SIZE * 0.3125 * 2) / 2);
        elipseBlack.setTranslateY((QUADRO_SIZE - QUADRO_SIZE * 0.26 * 2) / 2 + QUADRO_SIZE * 0.07);

        Ellipse elipseWhite = new Ellipse(QUADRO_SIZE * 0.3125, QUADRO_SIZE * 0.26);
        elipseWhite.setFill(tipo == TipoPeca.RED ? Color.valueOf("#c40003") : Color.valueOf("#fff9f4"));
        elipseWhite.setStroke(Color.BLACK);
        elipseWhite.setStrokeWidth(QUADRO_SIZE * 0.03);
        elipseWhite.setTranslateX((QUADRO_SIZE - QUADRO_SIZE * 0.3125 * 2) / 2);
        elipseWhite.setTranslateY((QUADRO_SIZE - QUADRO_SIZE * 0.26 * 2) / 2);
        getChildren().addAll(elipseBlack, elipseWhite);

        setOnMousePressed(e -> {
            mouseX = e.getSceneX();
            mouseX = e.getSceneY();
        });

        setOnMouseDragged(e -> {
            relocate(e.getSceneX() - mouseX + oldX, e.getSceneY() - mouseY + oldY);
        });

    }

    public void mover(int x, int y) {
        oldX = x * QUADRO_SIZE;
        oldY = y * QUADRO_SIZE;
        relocate(oldX, oldY);
    }

    public TipoPeca getTipo() {
        return tipo;
    }

    public void setTipo(TipoPeca tipo) {
        this.tipo = tipo;
    }

}
