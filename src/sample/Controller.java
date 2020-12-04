package sample;


import com.gluonhq.charm.glisten.control.ToggleButtonGroup;
import javafx.event.ActionEvent;
import javafx.scene.canvas.Canvas;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.*;

import java.net.UnknownHostException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

public class Controller {
    // GUI fields
    //
    public Tab tabHome;
    public TableView tabHomeTableViewEntries;
    public TableColumn tabHomeTableViewEntriesColumnIP;
    public TableColumn tabHomeTableViewEntriesColumnTimeStamp;
    public TableColumn tabHomeTableViewEntriesColumnRequest;
    public TableColumn tabHomeTableViewEntriesColumnPort;
    public TableColumn tabHomeTableViewEntriesColumnResponse;
    public TableView tabHomeTableViewServerStats;
    public TableColumn tabHomeTableViewServerStatsColumnTemp;
    public DatePicker tabHomeDatePickerGraphOfEntries;
    public Button tabHomeButtonGraphOfEntries;
    public DatePicker tabHomeDatePickerGraphOfErrors;
    public Button tabHomeButtonGraphOfErrors;
    public Button tabHomeButtonKillServer;
    public Button tabHomeButtonLoginToServer;
    public TextField tabHomeTextFieldEntriesToday;
    public TextField tabHomeTextFieldErrorsToday;
    public Tab tabOverview;
    public Canvas tabOverviewCanvas;
    public BarChart tabOverviewBarChartThreats;
    public CategoryAxis tabOverviewBarChartX;
    public NumberAxis tabOverviewBarChartThreatsY;
    public Tab tabGlobal;
    public Tab tabGlobalTabMap;
    public Tab tabGlobalTabIP;
    public Tab tabGlobalTabPort;
    public Tab tabGlobalTabEntries;
    public Tab tabGlobalTabErrors;
    public Tab tabGlobalTabPackages;
    public Tab tabGlobalTabRiskMeasure;
    public Tab tabGlobalTabTrendsOverTime;
    public Tab tabGlobalTabFirewallBlocks;
    public Tab tabGlobalTabLogins;
    public Tab tabGlobalTabTopAttacker;
    public Tab tabGlobalTabDatabase;
    public TableView tabGlobalTabDatabaseTableViewDatabase;
    public TableColumn tabGlobalTabDatabaseTableViewDatabaseColumnID;
    public TableColumn tabGlobalTabDatabaseTableViewDatabaseColumnIP;
    public TableColumn tabGlobalTabDatabaseTableViewDatabaseColumnTimeStamp;
    public TableColumn tabGlobalTabDatabaseTableViewDatabaseColumnRequest;
    public TableColumn tabGlobalTabDatabaseTableViewDatabaseColumnResponse;
    public TableColumn tabGlobalTabDatabaseTableViewDatabaseColumnClient;
    public TableColumn tabGlobalTabDatabaseTableViewDatabaseColumnResponseLenght;
    public TableColumn tabGlobalTabDatabaseTableViewDatabaseColumnPort;
    public TableColumn tabGlobalTabDatabaseTableViewDatabaseColumnFromService;
    public TextField tabGlobalTabDatabaseTextFieldSearchBar;
    public Button tabGlobalTabDatabaseButtonSearch;
    public Tab tabMethod;
    public Tab tabMethodTabDescription;
    public Tab tabMethodTabIP;
    public Tab tabMethodTabRequest;
    public Tab tabMethodTabResponse;
    public Tab tabMethodTabClient;
    public Tab tabMethodTabDatabase;
    public TableView tabMethodTabDatabaseTableViewDatabase;
    public TableColumn tabMethodTabDatabaseTableViewDatabaseColumnTimeStamp;
    public TableColumn tabMethodTabDatabaseTableViewDatabaseColumnIP;
    public TableColumn tabMethodTabDatabaseTableViewDatabaseColumnPort;
    public TableColumn tabMethodTabDatabaseTableViewDatabaseColumnRequest;
    public TableColumn tabMethodTabDatabaseTableViewDatabaseColumnResponse;
    public TableColumn tabMethodTabDatabaseTableViewDatabaseColumnClient;
    public ComboBox tabMethodComboBoxVisualizeMethod;
    public Button tabMethodButtonVisualizeMethod;
    public Button tabGlobalTabDatabaseButtonReset;
    public ToggleButtonGroup tabGlobalTabDatabaseToggleButtonGroupSearch; //charm-glisten.4.4.1.jar nødvendig for at køre det her
    public ToggleButton tabGlobalTabDatabaseToggleButtonGroupSearchToggleButtonID;
    public ToggleButton tabGlobalTabDatabaseToggleButtonGroupSearchToggleButtonTimeStamp;
    public ToggleButton tabGlobalTabDatabaseToggleButtonGroupSearchToggleButtonIP;
    public ToggleButton tabGlobalTabDatabaseToggleButtonGroupSearchToggleButtonPort;
    public ToggleButton tabGlobalTabDatabaseToggleButtonGroupSearchToggleButtonRequest;
    public ToggleButton tabGlobalTabDatabaseToggleButtonGroupSearchToggleButtonResponse;
    public ToggleButton tabGlobalTabDatabaseToggleButtonGroupSearchToggleButtonClient;
    public ToggleButton tabGlobalTabDatabaseToggleButtonGroupSearchToggleButtonFromService;
    public ToggleButton tabGlobalTabDatabaseToggleButtonGroupSearchToggleButtonResponseLength;


    private QueryWriter queryWriter = new QueryWriter();
    // List fields
    //
    private AnyList<Entry> listOfEntries = new AnyList<>("ListOfEntries");
    private AnyList<Error> listOfErrors = new AnyList<>("ListOfErrors");
    private AnyList<Bubble> listOfBubbles = new AnyList<>("ListOfBubbles");
    /* Jesper URL */
    //private String url = "jdbc:sqlite:C:\\Users\\JesperBlom\\Documents\\GitHub\\CsProject_\\Database.db";

    /* Simon URL */
    //private String url = "jdbc:sqlite:/Users/sfstoevring/Dropbox/RUC/5. Semester/Project/CsProject/Database.db";

    /* Magnus URL */
    private String url = "jdbc:sqlite:/Users/magnus/Documents/CsProject_/Database.db";

    /* Anders URL */
    //private String url = "jdbc:sqlite:C:/Users/ander/Documents/Intelli J saves/CS_exa/CsProject_/Database.db";

    public void initialize() throws ParseException, UnknownHostException, SQLException {
        createEntryObjectsFromDatabase();
        createErrorObjectsFromDatabase();
        System.out.println(listOfErrors.getSize());
        System.out.println(listOfEntries.getSize());
        System.out.println(listOfErrors.getFromList().get(0).getErrorMsg());
        System.out.println(listOfEntries.getFromList().get(0).getID()+"    "+ listOfEntries.getFromList().get(0).getdDate());
    }

    // Funktioner til Anylist-stuffz
    //
    public <T> void addToList(T object) throws ParseException, UnknownHostException {
        // Utility objects for comparing the object passed to the method
        Entry tempEntry = new Entry("1.1.1.1","1/Jan/1111:11:11:11", "Test", 1, 1, "test", "Windows_ad_bad", 1, 0);
        Error tempError = new Error("Test Error", 0);
        Bubble tempBubble = new Bubble("testBubble", 1, 1, 1, "BLACK", 0);

        if(object.getClass().equals(tempEntry.getClass())){
            listOfEntries.addToList((Entry) object);
            System.out.println("An Entry object was added to listOfEntries");
        } else if(object.getClass().equals(tempError.getClass())){
            listOfErrors.addToList(((Error) object));
            System.out.println("An Error object was added to listOfErrors");
        } else if(object.getClass().equals(tempBubble.getClass())){
            listOfBubbles.addToList(((Bubble) object));
            System.out.println("A Bubble object was added to listOfBubbles");
        } else{
            System.out.println("Could not add object of type " + object.getClass() + " to any of the lists of type AnyList");
        }

    }


    public void createErrorObjectsFromDatabase() throws ParseException, UnknownHostException, SQLException {
        ResultSet resultSet = queryWriter.initResultSetToObjects(url, "ERROR");
        while (resultSet.next()){
            Error errortest2 = new Error();
            errortest2.setID(resultSet.getInt("ID"));
            errortest2.setErrorMsg(resultSet.getString("ERRORSTRING"));
            addToList(errortest2);
        }
    }

    public void createEntryObjectsFromDatabase() throws SQLException, ParseException, UnknownHostException {
        ResultSet resultSet1 = queryWriter.initResultSetToObjects(url, "DATA");
        while (resultSet1.next()){
            Entry entry = new Entry();
            entry.setID(resultSet1.getInt("ID"));
            entry.setInetIP(resultSet1.getString("IP"));
            entry.setdDate(resultSet1.getString("TIME"));
            entry.setMethod(resultSet1.getString("REQUEST"));
            entry.setResponse(resultSet1.getInt("RESPONSE"));
            entry.setResponseLength(resultSet1.getInt("RESPONSE_LEN"));
            entry.setFromPage(resultSet1.getString("FROM_SYS"));
            entry.setClient(resultSet1.getString("FROM_CLIENT"));
            entry.setPort(resultSet1.getInt("PORT"));
            addToList(entry);
        }
    }


    public <T> void removeFromList(T object){

        listOfEntries.removeFromList(((Entry) object));
        System.out.println("Removed object");
    }

    public void tabHomeDatePickerGraphOfEntriesACTION(ActionEvent actionEvent) {
    }

    public void tabHomeButtonGraphOfEntriesACTION(ActionEvent actionEvent) {
    }

    public void tabHomeDatePickerGraphOfErrorsACTION(ActionEvent actionEvent) {
    }

    public void tabHomeButtonGraphOfErrorsACTION(ActionEvent actionEvent) {
    }

    public void tabHomeButtonKillServerACTION(ActionEvent actionEvent) {
    }

    public void tabHomeButtonLoginToServerACTION(ActionEvent actionEvent) {
    }

    public void tabGlobalTabDatabaseButtonSearchACTION(ActionEvent actionEvent) {
    }

    public void tabGlobalTabDatabaseButtonResetACTION(ActionEvent actionEvent) {
    }

    public void tabGlobalTabDatabaseToggleButtonGroupSearchToggleButtonIDACTION(ActionEvent actionEvent) {
    }

    public void tabGlobalTabDatabaseToggleButtonGroupSearchToggleButtonTimeStampACTION(ActionEvent actionEvent) {
    }

    public void tabGlobalTabDatabaseToggleButtonGroupSearchToggleButtonIPACTION(ActionEvent actionEvent) {
    }

    public void tabGlobalTabDatabaseToggleButtonGroupSearchToggleButtonPortACTION(ActionEvent actionEvent) {
    }

    public void tabGlobalTabDatabaseToggleButtonGroupSearchToggleButtonRequestACTION(ActionEvent actionEvent) {
    }

    public void tabGlobalTabDatabaseToggleButtonGroupSearchToggleButtonResponseACTION(ActionEvent actionEvent) {
    }

    public void tabGlobalTabDatabaseToggleButtonGroupSearchToggleButtonClientACTION(ActionEvent actionEvent) {
    }

    public void tabGlobalTabDatabaseToggleButtonGroupSearchToggleButtonFromServiceACTION(ActionEvent actionEvent) {
    }

    public void tabMethodComboBoxVisualizeMethodACTION(ActionEvent actionEvent) {
    }

    public void tabMethodButtonVisualizeMethodACTION(ActionEvent actionEvent) {
    }

    public void tabGlobalTabDatabaseToggleButtonGroupSearchToggleButtonResponseLengthACTION(ActionEvent actionEvent) {
    }


    //Funktioner der styrer grafik
}
