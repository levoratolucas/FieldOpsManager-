
// // .\gradlew run  
package com.osapp;

import com.osapp.view.LayoutDidatico;
import com.osapp.view.ColaboradorView;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
        String title;
        // ColaboradorView colaboradorView = new ColaboradorView();
        // Scene scene = new Scene(colaboradorView.getView(), 600, 400);
        // title = "Gestão de Colaboradores";

        LayoutDidatico layoutDidatico = new LayoutDidatico();
        Scene scene = new Scene(layoutDidatico.getView(), 600, 400);
        title = "teste view de aprendizado";

        primaryStage.setTitle(title);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
// // ---------------------- pra migrar as tabelas ------------------------------
// package com.osapp;

// import com.osapp.controller.ColaboradorController;
// import com.osapp.model.Colaborador;
// import com.osapp.util.JpaUtil;

// import jakarta.persistence.EntityManager;
// import java.util.List;

// public class App {
//     public static void main(String[] args) {
//         EntityManager em = JpaUtil.getEntityManager();

//         try {
//             em.getTransaction().begin();

           
//             em.getTransaction().commit();
//         } catch (Exception e) {
//             em.getTransaction().rollback();
//             e.printStackTrace();
//         } finally {
//             em.close();
//             JpaUtil.close();
//         }
//     }
// }

