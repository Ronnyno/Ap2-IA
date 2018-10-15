package ia_damas;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author Ronny's Note
 */
public class Damas extends Application {
    
    public static final int QUADRO_SIZE = 100;
    public static final int QUADRO_WIDTH = 8;
    public static final int QUADRO_HEIGTH = 8;
    
    private Quadro[][] borda = new Quadro[QUADRO_WIDTH][QUADRO_HEIGTH];
    private Group grupoQuadro = new Group();
    private Group grupoPeca = new Group();
    
    private Parent criarDados(){
        Pane raiz = new Pane();
        raiz.setPrefSize(QUADRO_WIDTH * QUADRO_SIZE, QUADRO_HEIGTH * QUADRO_SIZE);
        raiz.getChildren().addAll(grupoQuadro, grupoPeca);
        for (int i = 0; i < QUADRO_HEIGTH; i++) {
            for (int j = 0; j < QUADRO_WIDTH; j++) {
                Quadro quadro = new Quadro((i + j) % 2 == 0, i, j);
                
                borda[i][j] = quadro;
                
                grupoQuadro.getChildren().add(quadro);
                
                Peca peca = null;
                
                if(j <= 2 && (i+j) % 2 != 0){
                    peca = CriarPeca(TipoPeca.RED, i, j);
                }
                if(j >= 5 && (i+j) % 2 != 0){
                    peca = CriarPeca(TipoPeca.WHITE, i, j);
                }
                if(peca != null){
                    quadro.setPeca(peca);
                    grupoPeca.getChildren().add(peca);
                }
            }
        }
        
        return raiz;
    }
    @Override
    public void start(Stage primaryStage) throws Exception{
        Scene scene = new Scene(criarDados());
        primaryStage.setTitle("JOGO DE DAMAS");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Peca CriarPeca(TipoPeca tipo, int x, int y){
        Peca peca = new Peca(tipo, x, y);
        peca.setOnMouseReleased(e -> {
            
        });
        return peca;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
