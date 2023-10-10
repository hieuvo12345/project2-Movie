module com.test.mymovie {
    requires javafx.controls;
    requires javafx.fxml;
    requires de.jensd.fx.glyphs.fontawesome;
    requires java.base;
    requires java.sql;
    requires javafx.base;
    
    opens com.test.mymovie to javafx.fxml;
    exports com.test.mymovie;
}
