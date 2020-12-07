package sample;

import com.gluonhq.charm.glisten.control.ToggleButtonGroup;
import javafx.event.ActionEvent;
import javafx.scene.canvas.Canvas;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.*;

import java.net.UnknownHostException;
import java.sql.*;
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
    private AnyList<Method> listOfMethodTypes = new AnyList<>("ListOfMethodTypes");
    private String[] listOfMethods = new String[8];

    /* Jesper URL */
    //private String url = "jdbc:sqlite:C:\\Users\\JesperBlom\\Documents\\GitHub\\CsProject_\\Database.db";

    /* Simon URL */
    private String url = "jdbc:sqlite:/Users/sfstoevring/Dropbox/RUC/5. Semester/Project/CsProject/Database.db";

    /* Magnus URL */
    //private String url = "jdbc:sqlite:/Users/magnus/Documents/CsProject_/Database.db";

    /* Anders URL */
    //private String url = "jdbc:sqlite:C:/Users/ander/Documents/Intelli J saves/CS_exa/CsProject_/Database.db";

    public void initialize() throws ParseException, UnknownHostException, SQLException {
        createListOfMethods(); //Laver liste over Methoder der er fundet i databasen
        createMethodObjects(); //opretter metoder som objekter

        createEntryObjectsFromDatabase();
        createErrorObjectsFromDatabase();

        populateMethodObjects(); //Gemmer entryObjekter med GET, POST osv i de rigtige MethodObjects



        createBubbles();
        populateBubbles();

        for (int i = 0; i < listOfMethodTypes.getSize(); i++){
            System.out.println(listOfMethodTypes.getFromList().get(i).getListName() + " size: " + listOfMethodTypes.getFromList().get(i).getList().getSize());
        }


        tabHomeTextFieldEntriesToday.setText(new String (listOfEntries.getSize() + ""));
        tabHomeTextFieldErrorsToday.setText(new String (listOfErrors.getSize() + ""));



        /**
         *
         * Bubbles indeholder method.childs
         *
         * method.childs indeholder Entry-objekter
         *
         * Method childs skal sortere Entry-objekterne og deres respektive requesttypes
         *
         * De forskellige requesttypes skal gemmes i en list{list{}, list{}, list{}, ...}
         *
         */

        /**
         * Bubbles skal opretes med ét indbygget method.child > Dette skal gøres dynamisk
         */
    }

    //* Functions *//

    /**
     * Creates ErrorObjects from database
     * @throws ParseException
     * @throws UnknownHostException
     * @throws SQLException
     */
    public void createErrorObjectsFromDatabase() throws ParseException, UnknownHostException, SQLException {
        ResultSet resultSet = queryWriter.initResultSetToObjects(url, "ERROR");
        while (resultSet.next()){
            Error error = new Error();
            error.setID(resultSet.getInt("ID"));
            error.setErrorMsg(resultSet.getString("ERRORSTRING"));
            addToList(error);
        }
    }

    /**
     * Creates EntryObjects from databse
     * @throws SQLException
     * @throws ParseException
     * @throws UnknownHostException
     */
    public void createEntryObjectsFromDatabase() throws SQLException, ParseException, UnknownHostException {
        ResultSet resultSet1 = queryWriter.initResultSetToObjects(url, "DATA");
        while (resultSet1.next()){
            Entry entry = new Entry();
            entry.setID(resultSet1.getInt("ID"));
            entry.setInetIP(resultSet1.getString("IP"));
            entry.setdDate(resultSet1.getString("TIME"));
            entry.setMethod(resultSet1.getString("METHOD"));
            entry.setRequest(resultSet1.getString("REQUEST"));
            entry.setResponse(resultSet1.getInt("RESPONSE"));
            entry.setResponseLength(resultSet1.getInt("RESPONSE_LEN"));
            entry.setFromPage(resultSet1.getString("FROM_SYS"));
            entry.setClient(resultSet1.getString("FROM_CLIENT"));
            entry.setPort(resultSet1.getInt("PORT"));
            addToList(entry);
        }
    }

    /**
     * Adds 'generic' objects to certain lists
     * @param object
     * @param <T>
     * @throws ParseException
     * @throws UnknownHostException
     */
    public <T> void addToList(T object) throws ParseException, UnknownHostException {
        // Utility objects for comparing the object passed to the method
        Entry tempEntry = new Entry("1.1.1.1","1/Jan/1111:11:11:11", "test", 1, 1, "test", "test", 1, 0);
        Error tempError = new Error("Test Error", 0);
        Bubble tempBubble = new Bubble("testBubble", 0, "test");
        TypeASCII tempTypeASCII = new TypeASCII();
        TypeCONNECT tempTypeCONNECTION = new TypeCONNECT();
        TypeEMPTY tempTypeEMPTY = new TypeEMPTY();
        TypeGET tempTypeGET = new TypeGET();
        TypeHEAD tempTypeHEAD = new TypeHEAD();
        TypeOPTIONS tempTypeOPTIONS = new TypeOPTIONS();
        TypePOST tempTypePOST = new TypePOST();
        TypePROPFIND tempTypePROPFIND = new TypePROPFIND();

        if(object.getClass().equals(tempEntry.getClass())){
            listOfEntries.addToList((Entry) object);
            System.out.println("An Entry object was added to listOfEntries");
        } else if(object.getClass().equals(tempError.getClass())){
            listOfErrors.addToList(((Error) object));
            System.out.println("An Error object was added to listOfErrors");
        } else if(object.getClass().equals(tempBubble.getClass())){
            listOfBubbles.addToList(((Bubble) object));
            System.out.println("A Bubble object was added to listOfBubbles");
        } else if(object.getClass().equals(tempTypeASCII.getClass())){
            listOfMethodTypes.addToList(((TypeASCII) object));
            System.out.println("A method of type " + tempTypeASCII.getName() + " object was added to listOfMethodTypes");
        } else if(object.getClass().equals(tempTypeCONNECTION.getClass())){
            listOfMethodTypes.addToList(((TypeCONNECT) object));
            System.out.println("A method of type " + tempTypeCONNECTION.getName() + " object was added to listOfMethodTypes");
        } else if(object.getClass().equals(tempTypeEMPTY.getClass())){
            listOfMethodTypes.addToList(((TypeEMPTY) object));
            System.out.println("A method of type " + tempTypeEMPTY.getName() + " object was added to listOfMethodTypes");
        } else if(object.getClass().equals(tempTypeGET.getClass())){
            listOfMethodTypes.addToList(((TypeGET) object));
            System.out.println("A method of type " + tempTypeGET.getName() + " object was added to listOfMethodTypes");
        } else if(object.getClass().equals(tempTypeHEAD.getClass())){
            listOfMethodTypes.addToList(((TypeHEAD) object));
            System.out.println("A method of type " + tempTypeHEAD.getName() + " object was added to listOfMethodTypes");
        } else if(object.getClass().equals(tempTypeOPTIONS.getClass())){
            listOfMethodTypes.addToList(((TypeOPTIONS) object));
            System.out.println("A method of type " + tempTypeOPTIONS.getName() + " object was added to listOfMethodTypes");
        } else if(object.getClass().equals(tempTypePOST.getClass())){
            listOfMethodTypes.addToList(((TypePOST) object));
            System.out.println("A method of type " + tempTypePOST.getName() + " object was added to listOfMethodTypes");
        } else if(object.getClass().equals(tempTypePROPFIND.getClass())){
            listOfMethodTypes.addToList(((TypePROPFIND) object));
            System.out.println("A method of type " + tempTypePROPFIND.getName() + " object was added to listOfMethodTypes");
        } else{
            System.out.println("Could not add object of type " + object.getClass() + " to any of the lists of type AnyList");
        }
    }

    public void createListOfMethods() throws  SQLException{
        ResultSet rs = queryWriter.listOfMethods(url);
        int i = 0;
        while (rs.next()) {
            listOfMethods[i] = rs.getString("METHOD");
            System.out.println("saved " + rs.getString("METHOD") + " in listOfMethods");
            i++;
        }
    }

    public void createMethodObjects() throws ParseException, UnknownHostException {
        TypeASCII typeASCII = new TypeASCII();
        addToList(typeASCII);
        TypeCONNECT typeCONNECTION = new TypeCONNECT();
        addToList(typeCONNECTION);
        TypeEMPTY typeEMPTY = new TypeEMPTY();
        addToList(typeEMPTY);
        TypeGET typeGET = new TypeGET();
        addToList(typeGET);
        TypeHEAD typeHEAD = new TypeHEAD();
        addToList(typeHEAD);
        TypeOPTIONS typeOPTIONS = new TypeOPTIONS();
        addToList(typeOPTIONS);
        TypePOST typePOST = new TypePOST();
        addToList(typePOST);
        TypePROPFIND typePROPFIND = new TypePROPFIND();
        addToList(typePROPFIND);
    }

    private void populateMethodObjects() {
        for (int i = 0; i < listOfEntries.getSize(); i++) { //gennemløber alle entries
            for (int j = 0; j < listOfMethodTypes.getSize(); j++) { //gennemløber alle metoder
                if (listOfEntries.getFromList().get(i).getMethod().equalsIgnoreCase(listOfMethodTypes.getFromList().get(j).getName())) {
                    listOfMethodTypes.getFromList().get(j).addToList(listOfEntries.getFromList().get(i));
                    System.out.println("Added an EntryObject to the list: " + listOfMethodTypes.getFromList().get(j).getListName());
                } else {
                    continue;
                }
            }
        }
    }

    public void createBubbles(){
        for (int i = 0; i < listOfMethods.length; i++){
            String name = "bubble" + listOfMethods[i];
            Bubble bubble = new Bubble(name, i, listOfMethods[i]);
            listOfBubbles.addToList(bubble);
            System.out.println("Added " + listOfBubbles.getFromList().get(i).getName() + " to listOfBubbles");
        }
    }

    public void populateBubbles() {
        for (int i = 0; i < listOfBubbles.getSize(); i++) {
            for (int j = 0; j < listOfMethodTypes.getSize(); j++) {
                if (listOfBubbles.getFromList().get(i).getBubbleType().equalsIgnoreCase(listOfMethodTypes.getFromList().get(j).getName())) {
                    listOfBubbles.getFromList().get(i).setMethodType(listOfMethodTypes.getFromList().get(j));
                    System.out.println("added methodType: " + listOfMethodTypes.getFromList().get(j).getName() + " to " + listOfBubbles.getFromList().get(i).getName());
                }
            }
        }
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
}
