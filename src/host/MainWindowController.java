package host;

import java.net.URL;
import java.util.ArrayList;
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
import model.messages.FilesListRequest;

public class MainWindowController
{
    private DispatcherHost dispatcher;

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
        dispatcher.sendRequest(new FilesListRequest());
    }
    
    void refreshFilesList(ArrayList<FileInstance> fileList)
    {
    	fileTable.getItems().clear();
        for(FileInstance f:fileList)
        {
            fileTable.getItems().add(f);
        }
    }

    @FXML
    void initialize()
    {
        assert hostList != null : "fx:id=\"hostList\" was not injected: check your FXML file 'mainWindow.fxml'.";
        assert fileTable != null : "fx:id=\"fileTable\" was not injected: check your FXML file 'mainWindow.fxml'.";
        assert statusLabel != null : "fx:id=\"statusLabel\" was not injected: check your FXML file 'mainWindow.fxml'.";

        md5Column.setCellValueFactory(param -> new ReadOnlyStringWrapper(param.getValue().getMd5()));
        filenameColumn.setCellValueFactory(param -> new ReadOnlyStringWrapper(param.getValue().getName()));
        filesizeColumn.setCellValueFactory(param -> new ReadOnlyStringWrapper(param.getValue().getSize() + ""));

        //fileTable.getItems().add(new FileInstance(new File("C:\\x.txt")));
    }

	public void getHostList(ArrayList<Host> hostList2) {
		// TODO Auto-generated method stub
		
	}

    public void setHostList()
    {
        // TODO Auto-generated method stub
        
    }

    public void setDispatcher(DispatcherHost dispatcherHost)
    {
        this.dispatcher = dispatcherHost;
    }
}
