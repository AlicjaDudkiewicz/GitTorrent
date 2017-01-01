package host;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.entities.FileInstance;
import model.entities.Host;

public class MainWindowController
{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ListView<Host> hostList;

    @FXML
    private TableView<FileInstance> fileTable;

    @FXML
    private Label statusLabel;

    @FXML
    private TableColumn<FileInstance, String> md5Column;

    @FXML
    private TableColumn<FileInstance, String> filenameColumn;

    @FXML
    private TableColumn<FileInstance, String> filesizeColumn;

    @FXML
    void closeMenuItemClicked(ActionEvent event)
    {

    }

    @FXML
    void aboutMenuItemClicked(ActionEvent event)
    {

    }

    @FXML
    void downloadButtonClicked(ActionEvent event)
    {

    }

    @FXML
    void uploadButtonClicked(ActionEvent event)
    {

    }

    @FXML
    void refreshButtonClicked(ActionEvent event)
    {

    }

    @FXML
    void initialize()
    {
        assert hostList != null : "fx:id=\"hostList\" was not injected: check your FXML file 'sample.fxml'.";
        assert fileTable != null : "fx:id=\"fileTable\" was not injected: check your FXML file 'sample.fxml'.";
        assert statusLabel != null : "fx:id=\"statusLabel\" was not injected: check your FXML file 'sample.fxml'.";

        md5Column.setCellValueFactory(param -> new ReadOnlyStringWrapper(param.getValue().getMd5()));
        filenameColumn.setCellValueFactory(param -> new ReadOnlyStringWrapper(param.getValue().getName()));
        filesizeColumn.setCellValueFactory(param -> new ReadOnlyStringWrapper(param.getValue().getSize() + ""));

        fileTable.getItems().add(new FileInstance(new File("C:\\x.txt")));
    }
}
