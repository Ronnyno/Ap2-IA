package ia_damas;

/**
 *
 * @author Ronny's Note
 */
public enum TipoPeca {
    RED(1), WHITE(-1);
    final int direita;

    private TipoPeca(int direita) {
        this.direita = direita;
    }
    
    
    
}
