package ia_damas;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Ronny's Note
 */
public class Quadro extends Rectangle {

    private Peca peca;

    public boolean temPecas() {
        return peca != null;
    }

    
    public Quadro(boolean luz, int x, int y) {
        setWidth(Damas.QUADRO_SIZE);
        setHeight(Damas.QUADRO_SIZE);

        relocate(x * Damas.QUADRO_SIZE, y * Damas.QUADRO_SIZE);
        setFill(luz ? Color.valueOf("#EEEEE0") : Color.valueOf("#2E8B57"));
    }

    public Peca getPeca() {
        return peca;
    }

    public void setPeca(Peca peca) {
        this.peca = peca;
    }
    
    
}
