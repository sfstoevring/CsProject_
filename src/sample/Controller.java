/**
 * !!!
 * Remember to add:
 *      - javafx SDK lib           (Project structure > Project Settings > Libraries > + > Java)
 *      - GLUON.jar-file    (Project structure > Project Settings > Libraries > + > Java)
 *
 *
 *
 * Change path for the VM (Edit configurations > VM options:  "--module-path {Path to javafx SDK} --add-modules javafx.controls,javafx.fxml" )
 * Change path for the Database @ line 152-162
 * !!!
 */

package sample;

import com.gluonhq.charm.glisten.control.ToggleButtonGroup;
import javafx.event.ActionEvent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.chart.*;
import javafx.scene.paint.Color;
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
    public BarChart<String, Number> tabOverviewBarChartThreats;
    public CategoryAxis tabOverviewBarChartThreatsX;
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
    public TableColumn tabGlobalTabDatabaseTableViewDatabaseColumnResponseLength;
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
    public ToggleButtonGroup tabGlobalTabDatabaseToggleButtonGroupSearch; //Needs charm-glisten.4.4.1.jar to run properly
    public ToggleButton tabGlobalTabDatabaseToggleButtonGroupSearchToggleButtonID;
    public ToggleButton tabGlobalTabDatabaseToggleButtonGroupSearchToggleButtonTimeStamp;
    public ToggleButton tabGlobalTabDatabaseToggleButtonGroupSearchToggleButtonIP;
    public ToggleButton tabGlobalTabDatabaseToggleButtonGroupSearchToggleButtonPort;
    public ToggleButton tabGlobalTabDatabaseToggleButtonGroupSearchToggleButtonRequest;
    public ToggleButton tabGlobalTabDatabaseToggleButtonGroupSearchToggleButtonResponse;
    public ToggleButton tabGlobalTabDatabaseToggleButtonGroupSearchToggleButtonClient;
    public ToggleButton tabGlobalTabDatabaseToggleButtonGroupSearchToggleButtonFromService;
    public TableColumn tabHomeTableViewEntriesColumnMethod;
    public TableColumn tabGlobalTabDatabaseTableViewDatabaseColumnMethod;
    public ToggleButton tabGlobalTabDatabaseToggleButtonGroupSearchToggleButtonMethod;
    public TableColumn tabMethodTabDatabaseTableViewDatabaseColumnMethod;

    public BarChart tabGlobalTabIPBarChartIP;
    public CategoryAxis tabGlobalTabIPBarChartIPX;
    public NumberAxis tabGlobalTabIPBarChartIPY;
    public BarChart tabGlobalTabPortBarChartPort;
    public CategoryAxis tabGlobalTabPortBarChartPortX;
    public NumberAxis tabGlobalTabPortBarChartPortY;
    public LineChart tabGlobalTabEntriesLineChartEntries;
    public CategoryAxis tabGlobalTabEntriesLineChartEntriesX;
    public NumberAxis tabGlobalTabEntriesLineChartEntriesY;
    public LineChart tabGlobalTabErrorsLineChartErrors;
    public CategoryAxis tabGlobalTabErrorsLineChartErrorsX;
    public NumberAxis tabGlobalTabErrorsLineChartErrorsY;
    public BarChart tabGlobalTabRiskMeasureBarChartRiskMeasure;
    public CategoryAxis tabGlobalTabRiskMeasureBarChartRiskMeasureX;
    public NumberAxis tabGlobalTabRiskMeasureBarChartRiskMeasureY;
    public LineChart tabGlobalTabTrendsOverTimeLineChartTrendsOverTime;
    public CategoryAxis tabGlobalTabTrendsOverTimeLineChartTrendsOverTimeX;
    public NumberAxis tabGlobalTabTrendsOverTimeLineChartTrendsOverTimeY;
    public PieChart tabGlobalTabLoginsPieChartLogins;
    public BarChart tabGlobalTabTopAttackerBarChartTopAttacker;
    public CategoryAxis tabGlobalTabTopAttackerBarChartTopAttackerX;
    public NumberAxis tabGlobalTabTopAttackerBarChartTopAttackerY;

    private QueryWriter queryWriter = new QueryWriter();


//    private AnyList<MethodTabTableViewObjects> listOfMethodTabTableViewObjects = new AnyList<>("ListOfMethodTabTableViewObjects");
//    private AnyList<HomeTabTableViewObjects> listOfHomeTabTableViewObjects = new AnyList<>("ListOfHomeTabTableViewObjects");
//    private AnyList<GlobalTabTableViewObjects> listOfGlobalTabTableViewObjects = new AnyList<>("ListOfGlobalTabTableViewObjects");

    // List fields
    //
    private AnyList<Entry> listOfEntries = new AnyList<>("ListOfEntries");
    private AnyList<Error> listOfErrors = new AnyList<>("ListOfErrors");
    private AnyList<Bubble> listOfBubbles = new AnyList<>("ListOfBubbles");
    private AnyList<Method> listOfMethodTypes = new AnyList<>("ListOfMethodTypes");
    private AnyList<TableViewObjects> listOfTableViewObjectsAtTabHome = new AnyList<>("ListOfTableViewObjects@Tab_Home");
    private AnyList<TableViewObjects> listOfTableViewObjectsAtTabGlobal = new AnyList<>("ListOfTableViewObjects@Tab_Global");
    private AnyList<TableViewObjects> listOfTableViewObjectsAtTabMethod = new AnyList<>("ListOfTableViewObjects@Tab_Method");
    private String[] listOfMethods = new String[8];

    /* Jesper URL */
    private String url = "jdbc:sqlite:C:\\Users\\JesperBlom\\Documents\\GitHub\\CsProject_\\Database.db";

    /* Simon URL */
    //private String url = "jdbc:sqlite:/Users/sfstoevring/Dropbox/RUC/5. Semester/Project/CsProject/Database.db";

    /* Magnus URL */
    //private String url = "jdbc:sqlite:/Users/magnus/Documents/CsProject_/Database.db";

    /* Anders URL */
    //private String url = "jdbc:sqlite:C:/Users/ander/Documents/Intelli J saves/CS_exa/CsProject_/Database.db";










    public void initialize() throws ParseException, UnknownHostException, SQLException {

        setPropertyValueFactories();
        createEntriesAsObjectsFromDatabase();
        createErrorsAsObjectsFromDatabase();
        createListOfMethods();
        createMethodsAsObjects();
        populateMethodObjects();
        createBubbles();
        populateBubbles();
        populateHomeTabTableView2();
        populateGlobalTabTableView2();
        populateMethodTabTableView2();

        //populateHomeTabTableView();
        //populateGlobalTabTableView();
        //populateMethodTabTableView();







        for (int i = 0; i < listOfMethodTypes.getSize(); i++){
            System.out.println(listOfMethodTypes.getFromList().get(i).getListName() + " size: " + listOfMethodTypes.getFromList().get(i).getList().getSize());
        }


        tabHomeTextFieldEntriesToday.setText(new String (listOfEntries.getSize() + ""));
        tabHomeTextFieldErrorsToday.setText(new String (listOfErrors.getSize() + ""));


        GraphicsContext bubbles = tabOverviewCanvas.getGraphicsContext2D();
        bubbles.clearRect(0,0,tabOverviewCanvas.getWidth(),tabOverviewCanvas.getHeight());
        for (int i = 0 ; i < listOfMethodTypes.getSize() ; i++) {
            bubbles.setFill(Color.rgb(200, 200, 200, 0.8));
            bubbles.fillOval(tabOverviewCanvas.getWidth() / 2, tabOverviewCanvas.getHeight() / 2, listOfMethodTypes.getFromList().get(i).getList().getSize() * 0.1, listOfMethodTypes.getFromList().get(i).getList().getSize() * 0.1);
        }


        //graph
        tabOverviewBarChartThreatsX.setLabel("IP-address");
        tabOverviewBarChartThreatsY.setLabel("Hits");

        XYChart.Series<String, Number> series1 = new XYChart.Series();

        for(int i = 0 ; i<listOfBubbles.getSize() ; i++) {
            series1.getData().addAll(new XYChart.Data(listOfBubbles.getFromList().get(i).getMethodType().getName(), listOfBubbles.getFromList().get(i).getMethodType().getList().getSize()));

        }

        tabOverviewBarChartThreats.getData().add(series1);

    }

    //* Methods *//

    public void setBarChartGraph(){
        tabOverviewBarChartThreatsX.setLabel("IP-address");
        tabOverviewBarChartThreatsY.setLabel("Hits");

        XYChart.Series<String, Number> series1 = new XYChart.Series();

        for(int i = 0 ; i<listOfBubbles.getSize() ; i++) {
            series1.getData().addAll(new XYChart.Data(listOfBubbles.getFromList().get(i).getMethodType().getName(), listOfBubbles.getFromList().get(i).getMethodType().getList().getSize()));

        }

        tabOverviewBarChartThreats.getData().add(series1);

    }

    /**
     * Prepares the rows and columns in GUI
     */
    public void setPropertyValueFactories(){
        //TabHome
        tabHomeTableViewEntriesColumnTimeStamp.setCellValueFactory(new PropertyValueFactory<TableViewObjects, String>("TIME"));
        tabHomeTableViewEntriesColumnIP.setCellValueFactory(new PropertyValueFactory<TableViewObjects, String>("IP"));
        tabHomeTableViewEntriesColumnPort.setCellValueFactory(new PropertyValueFactory<TableViewObjects, Integer>("PORT"));
        tabHomeTableViewEntriesColumnMethod.setCellValueFactory(new PropertyValueFactory<TableViewObjects, String>("METHOD"));
        tabHomeTableViewEntriesColumnRequest.setCellValueFactory(new PropertyValueFactory<TableViewObjects, String>("REQUEST"));
        tabHomeTableViewEntriesColumnResponse.setCellValueFactory(new PropertyValueFactory<TableViewObjects, String>("RESPONSE"));
        //TabGlobal
        tabGlobalTabDatabaseTableViewDatabaseColumnID.setCellValueFactory(new PropertyValueFactory<TableViewObjects, Integer>("ID"));
        tabGlobalTabDatabaseTableViewDatabaseColumnTimeStamp.setCellValueFactory(new PropertyValueFactory<TableViewObjects, String>("TIME"));
        tabGlobalTabDatabaseTableViewDatabaseColumnIP.setCellValueFactory(new PropertyValueFactory<TableViewObjects, String>("IP"));
        tabGlobalTabDatabaseTableViewDatabaseColumnPort.setCellValueFactory(new PropertyValueFactory<TableViewObjects, Integer>("PORT"));
        tabGlobalTabDatabaseTableViewDatabaseColumnMethod.setCellValueFactory(new PropertyValueFactory<TableViewObjects, String>("METHOD"));
        tabGlobalTabDatabaseTableViewDatabaseColumnRequest.setCellValueFactory(new PropertyValueFactory<TableViewObjects, String>("REQUEST"));
        tabGlobalTabDatabaseTableViewDatabaseColumnResponse.setCellValueFactory(new PropertyValueFactory<TableViewObjects, Integer>("RESPONSE"));
        tabGlobalTabDatabaseTableViewDatabaseColumnResponseLength.setCellValueFactory(new PropertyValueFactory<TableViewObjects, Integer>("RESPONSE_LEN"));
        tabGlobalTabDatabaseTableViewDatabaseColumnClient.setCellValueFactory(new PropertyValueFactory<TableViewObjects, String>("FROM_CLIENT"));
        tabGlobalTabDatabaseTableViewDatabaseColumnFromService.setCellValueFactory(new PropertyValueFactory<TableViewObjects, String>("FROM_SYS"));
        //TabMethod
        tabMethodTabDatabaseTableViewDatabaseColumnTimeStamp.setCellValueFactory(new PropertyValueFactory<TableViewObjects, String>("TIME"));
        tabMethodTabDatabaseTableViewDatabaseColumnPort.setCellValueFactory(new PropertyValueFactory<TableViewObjects, Integer>("PORT"));
        tabMethodTabDatabaseTableViewDatabaseColumnIP.setCellValueFactory(new PropertyValueFactory<TableViewObjects, String>("IP"));
        tabMethodTabDatabaseTableViewDatabaseColumnMethod.setCellValueFactory(new PropertyValueFactory<TableViewObjects, String>("METHOD"));
        tabMethodTabDatabaseTableViewDatabaseColumnRequest.setCellValueFactory(new PropertyValueFactory<TableViewObjects, String>("REQUEST"));
        tabMethodTabDatabaseTableViewDatabaseColumnResponse.setCellValueFactory(new PropertyValueFactory<TableViewObjects, String>("RESPONSE"));
        tabMethodTabDatabaseTableViewDatabaseColumnClient.setCellValueFactory(new PropertyValueFactory<TableViewObjects, String>("CLIENT"));
    }

    /**
     * Creates EntryObjects from databse
     * @throws SQLException
     * @throws ParseException
     * @throws UnknownHostException
     */
    public void createEntriesAsObjectsFromDatabase() throws SQLException, ParseException, UnknownHostException {
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
            listOfEntries.addToList(entry);
        }
    }

    /**
     * Creates ErrorObjects from database
     * @throws ParseException
     * @throws UnknownHostException
     * @throws SQLException
     */
    public void createErrorsAsObjectsFromDatabase() throws SQLException {
        ResultSet resultSet = queryWriter.initResultSetToObjects(url, "ERROR");
        while (resultSet.next()){
            Error error = new Error();
            error.setID(resultSet.getInt("ID"));
            error.setErrorMsg(resultSet.getString("ERRORSTRING"));
            listOfErrors.addToList(error);
        }
    }

    /**
     * Creates a list of all the HTTP Request methods found in the database
     * @throws SQLException
     */
    public void createListOfMethods() throws  SQLException{
        ResultSet rs = queryWriter.listOfMethods(url);
        int i = 0;
        while (rs.next()) {
            listOfMethods[i] = rs.getString("METHOD");
            System.out.println("saved " + rs.getString("METHOD") + " in listOfMethods");
            i++;
        }
    }

    /**
     * Instantiates HTTP request methods as objects
     */
    public void createMethodsAsObjects(){
        TypeASCII typeASCII = new TypeASCII();
        TypeCONNECT typeCONNECTION = new TypeCONNECT();
        TypeEMPTY typeEMPTY = new TypeEMPTY();
        TypeGET typeGET = new TypeGET();
        TypeHEAD typeHEAD = new TypeHEAD();
        TypeOPTIONS typeOPTIONS = new TypeOPTIONS();
        TypePOST typePOST = new TypePOST();
        TypePROPFIND typePROPFIND = new TypePROPFIND();

        listOfMethodTypes.addToList(typeASCII);
        listOfMethodTypes.addToList(typeCONNECTION);
        listOfMethodTypes.addToList(typeEMPTY);
        listOfMethodTypes.addToList(typeGET);
        listOfMethodTypes.addToList(typeHEAD);
        listOfMethodTypes.addToList(typeOPTIONS);
        listOfMethodTypes.addToList(typePOST);
        listOfMethodTypes.addToList(typePROPFIND);
    }

    /**
     * Saves Entry objects in Method objects
     */
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

    /**
     * Creates bubbles. Used for visuals in GUI
     */
    public void createBubbles(){
        for (int i = 0; i < listOfMethods.length; i++){
            String name = "bubble" + listOfMethods[i];
            Bubble bubble = new Bubble(name, i, listOfMethods[i]);
            listOfBubbles.addToList(bubble);
            System.out.println("Added " + listOfBubbles.getFromList().get(i).getName() + " to listOfBubbles");
        }
    }

    /**
     * Saves Method objects in Bubble object
     */
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

    private void populateHomeTabTableView2() throws SQLException {
        listOfTableViewObjectsAtTabHome.clearList();
        ResultSet rsHomeTabTableView = queryWriter.resultSetForHomeTabTableView(url);
        while(rsHomeTabTableView.next()){
            TableViewObjects homeTab = new TableViewObjects();
            homeTab.setTIME(rsHomeTabTableView.getString("TIME"));
            homeTab.setIP(rsHomeTabTableView.getString("IP"));
            homeTab.setPORT(rsHomeTabTableView.getInt("PORT"));
            homeTab.setMETHOD(rsHomeTabTableView.getString("METHOD"));
            homeTab.setREQUEST(rsHomeTabTableView.getString("REQUEST"));
            homeTab.setsRESPONSE(rsHomeTabTableView.getString("RESPONSE"));
            listOfTableViewObjectsAtTabHome.addToList(homeTab);
        }
        tabHomeTableViewEntries.setItems(listOfTableViewObjectsAtTabHome.getFromList());
    }

    private void populateGlobalTabTableView2() throws SQLException {
        listOfTableViewObjectsAtTabGlobal.clearList();
        ResultSet rsGlobalTabTableView = queryWriter.resultSetForGlobalTabTableView(url);
        while (rsGlobalTabTableView.next()){
            TableViewObjects globalTab = new TableViewObjects();
            globalTab.setID(rsGlobalTabTableView.getInt("ID"));
            globalTab.setTIME(rsGlobalTabTableView.getString("TIME"));
            globalTab.setIP(rsGlobalTabTableView.getString("IP"));
            globalTab.setPORT(rsGlobalTabTableView.getInt("PORT"));
            globalTab.setMETHOD(rsGlobalTabTableView.getString("METHOD"));
            globalTab.setREQUEST(rsGlobalTabTableView.getString("REQUEST"));
            globalTab.setRESPONSE(rsGlobalTabTableView.getInt("RESPONSE"));
            globalTab.setRESPONSE_LEN(rsGlobalTabTableView.getInt("RESPONSE_LEN"));
            globalTab.setFROM_CLIENT(rsGlobalTabTableView.getString("FROM_CLIENT"));
            globalTab.setFROM_SYS(rsGlobalTabTableView.getString("FROM_SYS"));
            listOfTableViewObjectsAtTabGlobal.addToList(globalTab);
        }
        tabGlobalTabDatabaseTableViewDatabase.setItems(listOfTableViewObjectsAtTabGlobal.getFromList());
    }

    private void populateMethodTabTableView2() throws SQLException {
        listOfTableViewObjectsAtTabMethod.clearList();
        ResultSet rsMethodTabTableView = queryWriter.resultSetForMethodTabTableView(url);
        while(rsMethodTabTableView.next()){
            TableViewObjects methodTab = new TableViewObjects();
            methodTab.setTIME(rsMethodTabTableView.getString("TIME"));
            methodTab.setIP(rsMethodTabTableView.getString("IP"));
            methodTab.setPORT(rsMethodTabTableView.getInt("PORT"));
            methodTab.setMETHOD(rsMethodTabTableView.getString("METHOD"));
            methodTab.setREQUEST(rsMethodTabTableView.getString("REQUEST"));
            methodTab.setsRESPONSE(rsMethodTabTableView.getString("RESPONSE"));
            methodTab.setCLIENT(rsMethodTabTableView.getString("CLIENT"));
            listOfTableViewObjectsAtTabMethod.addToList(methodTab);
        }
        tabMethodTabDatabaseTableViewDatabase.setItems(listOfTableViewObjectsAtTabMethod.getFromList());

    }

//    public void populateHomeTabTableView() throws SQLException {
//        listOfHomeTabTableViewObjects.clearList();
//        ResultSet rsHomeTabTableView = queryWriter.resultSetForHomeTabTableView(url);
//        while(rsHomeTabTableView.next()){
//            HomeTabTableViewObjects homeTab = new HomeTabTableViewObjects();
//            homeTab.setTIME(rsHomeTabTableView.getString("TIME"));
//            homeTab.setIP(rsHomeTabTableView.getString("IP"));
//            homeTab.setPORT(rsHomeTabTableView.getInt("PORT"));
//            homeTab.setMETHOD(rsHomeTabTableView.getString("METHOD"));
//            homeTab.setREQUEST(rsHomeTabTableView.getString("REQUEST"));
//            homeTab.setRESPONSE(rsHomeTabTableView.getString("RESPONSE"));
//            listOfHomeTabTableViewObjects.addToList(homeTab);
//        }
//        tabHomeTableViewEntries.setItems(listOfHomeTabTableViewObjects.getFromList());
//    }
//
//    public void populateGlobalTabTableView() throws SQLException {
//        listOfGlobalTabTableViewObjects.clearList();
//        ResultSet rsGlobalTabTableView = queryWriter.resultSetForGlobalTabTableView(url);
//        while (rsGlobalTabTableView.next()){
//            GlobalTabTableViewObjects globalTab = new GlobalTabTableViewObjects();
//            globalTab.setID(rsGlobalTabTableView.getInt("ID"));
//            globalTab.setTIME(rsGlobalTabTableView.getString("TIME"));
//            globalTab.setIP(rsGlobalTabTableView.getString("IP"));
//            globalTab.setPORT(rsGlobalTabTableView.getInt("PORT"));
//            globalTab.setMETHOD(rsGlobalTabTableView.getString("METHOD"));
//            globalTab.setREQUEST(rsGlobalTabTableView.getString("REQUEST"));
//            globalTab.setRESPONSE(rsGlobalTabTableView.getInt("RESPONSE"));
//            globalTab.setRESPONSE_LEN(rsGlobalTabTableView.getInt("RESPONSE_LEN"));
//            globalTab.setFROM_CLIENT(rsGlobalTabTableView.getString("FROM_CLIENT"));
//            globalTab.setFROM_SYS(rsGlobalTabTableView.getString("FROM_SYS"));
//            listOfGlobalTabTableViewObjects.addToList(globalTab);
//        }
//        tabGlobalTabDatabaseTableViewDatabase.setItems(listOfGlobalTabTableViewObjects.getFromList());
//    }
//
//    public void populateMethodTabTableView() throws SQLException {
//        listOfMethodTabTableViewObjects.clearList();
//        ResultSet rsMethodTabTableView = queryWriter.resultSetForMethodTabTableView(url);
//        while(rsMethodTabTableView.next()){
//            MethodTabTableViewObjects methodTab = new MethodTabTableViewObjects();
//            methodTab.setTIME(rsMethodTabTableView.getString("TIME"));
//            methodTab.setIP(rsMethodTabTableView.getString("IP"));
//            methodTab.setPORT(rsMethodTabTableView.getInt("PORT"));
//            methodTab.setMETHOD(rsMethodTabTableView.getString("METHOD"));
//            methodTab.setREQUEST(rsMethodTabTableView.getString("REQUEST"));
//            methodTab.setRESPONSE(rsMethodTabTableView.getString("RESPONSE"));
//            methodTab.setCLIENT(rsMethodTabTableView.getString("CLIENT"));
//            listOfMethodTabTableViewObjects.addToList(methodTab);
//        }
//        tabMethodTabDatabaseTableViewDatabase.setItems(listOfMethodTabTableViewObjects.getFromList());
//    }



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

    public void tabGlobalTabDatabaseToggleButtonGroupSearchToggleButtonMethodACTION(ActionEvent actionEvent) {
    }
}
