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
import javafx.event.EventType;
import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.chart.*;
import javafx.scene.effect.Light;
import javafx.scene.paint.Color;
import org.w3c.dom.ls.LSOutput;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.*;
import java.text.ParseException;
import java.util.Random;

public class Controller {
    // GUI fields
    //
    public Tab tabHome;
    public TabPane tabPane;
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
    public BarChart tabOverviewBarChartThreats; //<String, Number>
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
    public Label tabGlobalTabDatabaseLabelResultsCount;

    private QueryWriter queryWriter = new QueryWriter();
    public boolean running = true;
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

    private String url = "jdbc:sqlite:Database.db";

    public void initialize() throws ParseException, UnknownHostException, SQLException {

        setPropertyValueFactories();
        createEntriesAsObjectsFromDatabase();
        createErrorsAsObjectsFromDatabase();
        createListOfMethods();
        createMethodsAsObjects();
        populateMethodObjects();
        createBubbles();
        populateBubbles();
        populateHomeTabTableView();
        populateGlobalTabTableView();
        //populateMethodTabTableView(); //Skal bruge en String for at køre
        populateMethodTabCombobox();

        Random random = new Random();

        int random_x = random.nextInt(500);
        int random_y = random.nextInt(500);

        for (int i = 0; i < listOfMethodTypes.getSize(); i++) {
            System.out.println(listOfMethodTypes.getFromList().get(i).getListName() + " size: " + listOfMethodTypes.getFromList().get(i).getList().getSize());
        }

        tabHomeTextFieldEntriesToday.setText(new String(listOfEntries.getSize() + ""));
        tabHomeTextFieldErrorsToday.setText(new String(listOfErrors.getSize() + ""));

        GraphicsContext bubbles = tabOverviewCanvas.getGraphicsContext2D();
        bubbles.clearRect(0, 0, tabOverviewCanvas.getWidth(), tabOverviewCanvas.getHeight());
        for (int i = 0; i < listOfMethodTypes.getSize(); i++) {
            double random_x_test = Math.random() * (tabOverviewCanvas.getWidth() - tabOverviewCanvas.getWidth()/2 + 1) + tabOverviewCanvas.getWidth()/2;
            double random_y_test = Math.random() * (tabOverviewCanvas.getHeight() - tabOverviewCanvas.getHeight()/2 + 1) + tabOverviewCanvas.getHeight()/2;
            bubbles.setFill(Color.rgb(200, 200, 200, 0.8));
            bubbles.fillOval( random_x_test, random_y_test, listOfMethodTypes.getFromList().get(i).getList().getSize() * 0.1, listOfMethodTypes.getFromList().get(i).getList().getSize() * 0.1);
        }


        //graph
        setBarChartGraph(tabOverviewBarChartThreats, tabOverviewBarChartThreatsX, " ", tabOverviewBarChartThreatsY, " ", 0);
        setPieChartGraph(tabGlobalTabLoginsPieChartLogins);
        setLineChartGraph(tabGlobalTabEntriesLineChartEntries, tabGlobalTabEntriesLineChartEntriesX, " ", tabGlobalTabEntriesLineChartEntriesY, " ", 0);
        setBarChartGraph(tabGlobalTabIPBarChartIP, tabGlobalTabIPBarChartIPX,"Bo", tabGlobalTabIPBarChartIPY, "Lis", 1);
    }

    //* Methods *//

    public void setBarChartGraph(BarChart barChart, CategoryAxis categoryAxis, String categoryAxisLabel, NumberAxis numberAxis, String numberAxisLabel, int listSwitcher) {

        categoryAxis.setLabel(categoryAxisLabel);
        numberAxis.setLabel(numberAxisLabel);

        XYChart.Series<String, Number> series1 = new XYChart.Series();

        switch (listSwitcher) {
            case 0:
                for (int i = 0; i < listOfMethodTypes.getSize(); i++) {
                    series1.getData().addAll(new XYChart.Data(listOfMethodTypes.getFromList().get(i).getName(), listOfMethodTypes.getFromList().get(i).getList().getSize()));
                }
                break;
            case 1:
                for(int i = 0; i < listOfMethodTypes.getFromList().get(3).getList().getSize(); i++){
                    series1.getData().addAll(new XYChart.Data(listOfMethodTypes.getFromList().get(3).getList().getFromList().get(i).getIPAsString(), i*10));
                }
                break;
        }
        barChart.getData().addAll(series1);

    }

    public void setIPChart(BarChart barChart, CategoryAxis categoryAxis, String categoryAxisLabel, NumberAxis numberAxis, String numberAxisLabel) {

        categoryAxis.setLabel(categoryAxisLabel);
        numberAxis.setLabel(numberAxisLabel);

        XYChart.Series<String, Number> series1 = new XYChart.Series();
        for(int i = 0; i < listOfMethodTypes.getFromList().get(3).getList().getSize(); i++){
            //System.out.println(listOfMethodTypes.getFromList().get(1).getList().getFromList().get(i).getIPAsString());
            series1.getData().addAll(new XYChart.Data(listOfMethodTypes.getFromList().get(3).getList().getFromList().get(i).getIPAsString(), i*10));
        }
        barChart.getData().addAll(series1);
    }

    public void setPieChartGraph(PieChart pieChart){

        int chartSliceGET = 0;
        int chartSlicePOST = 0;

        for (int i = 0; i < listOfMethodTypes.getFromList().get(3).getList().getSize(); i++) {
            if (listOfMethodTypes.getFromList().get(3).getList().getFromList().get(i).getRequest().toLowerCase().contains("login")) {
                chartSliceGET++;
                System.out.println(chartSliceGET);
            }
        }

        for (int i = 0; i < listOfMethodTypes.getFromList().get(6).getList().getSize(); i++) {
            if (listOfMethodTypes.getFromList().get(6).getList().getFromList().get(i).getRequest().toLowerCase().contains("login")) {
                chartSlicePOST++;
                System.out.println(chartSlicePOST);
            }
        }

        PieChart.Data slice1 = new PieChart.Data("GET", chartSliceGET);
        PieChart.Data slice2 = new PieChart.Data("POST", chartSlicePOST);

        pieChart.getData().addAll(slice1, slice2);

    }

    public void setLineChartGraph(LineChart lineChart, CategoryAxis categoryAxis, String categoryAxisLabel, NumberAxis numberAxis, String numberAxisLabel, int listSwitcher){

        categoryAxis.setLabel(categoryAxisLabel);
        numberAxis.setLabel(numberAxisLabel);

        XYChart.Series<String, Number> series1 = new XYChart.Series();
        XYChart.Series<String, Number> series2 = new XYChart.Series();

        switch (listSwitcher) {
            case 0:
                for (int i = 0; i < listOfEntries.getSize(); i++) {
                    series1.getData().addAll(new XYChart.Data(listOfEntries.getFromList().get(i).getsDate(), 10));
                    //series2.getData().addAll(new XYChart.Data(listOfMethodTypes.getFromList().get(i).getName(), listOfMethodTypes.getFromList().get(i).getList().getSize()+100));
                }

                break;
        }

        lineChart.getData().addAll(series1, series2);

    }

    public void resetToggleButtonAndTextField(){
        tabGlobalTabDatabaseTextFieldSearchBar.setText("");
        tabGlobalTabDatabaseToggleButtonGroupSearchToggleButtonID.setSelected(false);
        tabGlobalTabDatabaseToggleButtonGroupSearchToggleButtonIP.setSelected(false);
        tabGlobalTabDatabaseToggleButtonGroupSearchToggleButtonTimeStamp.setSelected(false);
        tabGlobalTabDatabaseToggleButtonGroupSearchToggleButtonPort.setSelected(false);
        tabGlobalTabDatabaseToggleButtonGroupSearchToggleButtonMethod.setSelected(false);
        tabGlobalTabDatabaseToggleButtonGroupSearchToggleButtonRequest.setSelected(false);
        tabGlobalTabDatabaseToggleButtonGroupSearchToggleButtonResponse.setSelected(false);
        tabGlobalTabDatabaseToggleButtonGroupSearchToggleButtonClient.setSelected(false);
        tabGlobalTabDatabaseToggleButtonGroupSearchToggleButtonFromService.setSelected(false);
    }

    /**
     * Methods to navigate to tabs in the GUI
     * index of tabs:
     * Home = 0
     * Overview = 1
     * Global = 2
     * Method = 3
     */
    public void goToHomeTab (){
        tabPane.getSelectionModel().select(0);
    }

    public void goToOverviewTab (){
        tabPane.getSelectionModel().select(1);
    }

    public void goToGlobalTab (){
        tabPane.getSelectionModel().select(2);
    }

    public void goToMethodTab (){
        tabPane.getSelectionModel().select(3);
    }

    /**
     * Prepares the rows and columns in GUI
     */
    public void setPropertyValueFactories() {
        //TabHome
        tabHomeTableViewEntriesColumnTimeStamp.setCellValueFactory(new PropertyValueFactory<TableViewObjects, String>("TIME"));
        tabHomeTableViewEntriesColumnIP.setCellValueFactory(new PropertyValueFactory<TableViewObjects, String>("IP"));
        tabHomeTableViewEntriesColumnPort.setCellValueFactory(new PropertyValueFactory<TableViewObjects, Integer>("PORT"));
        tabHomeTableViewEntriesColumnMethod.setCellValueFactory(new PropertyValueFactory<TableViewObjects, String>("METHOD"));
        tabHomeTableViewEntriesColumnRequest.setCellValueFactory(new PropertyValueFactory<TableViewObjects, String>("REQUEST"));
        tabHomeTableViewEntriesColumnResponse.setCellValueFactory(new PropertyValueFactory<TableViewObjects, String>("sRESPONSE"));
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
        tabMethodTabDatabaseTableViewDatabaseColumnResponse.setCellValueFactory(new PropertyValueFactory<TableViewObjects, String>("sRESPONSE"));
        tabMethodTabDatabaseTableViewDatabaseColumnClient.setCellValueFactory(new PropertyValueFactory<TableViewObjects, String>("CLIENT"));
    }

    /**
     * Creates EntryObjects from databse
     *
     * @throws SQLException
     * @throws ParseException
     * @throws UnknownHostException
     */
    public void createEntriesAsObjectsFromDatabase() throws SQLException, ParseException, UnknownHostException {
        ResultSet resultSet1 = queryWriter.initResultSetToObjects(url, "DATA");
        while (resultSet1.next()) {
            Entry entry = new Entry();
            entry.setID(resultSet1.getInt("ID"));
            entry.setInetIP(resultSet1.getString("IP"));
            entry.setdDate(resultSet1.getString("TIME"));
            entry.setsDate(resultSet1.getString("TIME"));
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
     *
     * @throws ParseException
     * @throws UnknownHostException
     * @throws SQLException
     */
    public void createErrorsAsObjectsFromDatabase() throws SQLException {
        ResultSet resultSet = queryWriter.initResultSetToObjects(url, "ERROR");
        while (resultSet.next()) {
            Error error = new Error();
            error.setID(resultSet.getInt("ID"));
            error.setErrorMsg(resultSet.getString("ERRORSTRING"));
            listOfErrors.addToList(error);
        }
    }

    /**
     * Creates a list of all the HTTP Request methods found in the database
     *
     * @throws SQLException
     */
    public void createListOfMethods() throws SQLException {
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
    public void createMethodsAsObjects() {
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

    private void updateGlobalTabTableView(String toggleButton, String textFieldInput) throws SQLException {
        listOfTableViewObjectsAtTabGlobal.clearList();
        ResultSet rsGlobalTabTableViewUpdate = queryWriter.resultSetForGlobalTabTableViewUpdating(url,toggleButton,textFieldInput);
        while (rsGlobalTabTableViewUpdate.next()) {
            TableViewObjects globalTabTableViewUpdate = new TableViewObjects();
            globalTabTableViewUpdate.setID(rsGlobalTabTableViewUpdate.getInt("ID"));
            globalTabTableViewUpdate.setTIME(rsGlobalTabTableViewUpdate.getString("TIME"));
            globalTabTableViewUpdate.setIP(rsGlobalTabTableViewUpdate.getString("IP"));
            globalTabTableViewUpdate.setPORT(rsGlobalTabTableViewUpdate.getInt("PORT"));
            globalTabTableViewUpdate.setMETHOD(rsGlobalTabTableViewUpdate.getString("METHOD"));
            globalTabTableViewUpdate.setREQUEST(rsGlobalTabTableViewUpdate.getString("REQUEST"));
            globalTabTableViewUpdate.setRESPONSE(rsGlobalTabTableViewUpdate.getInt("RESPONSE"));
            globalTabTableViewUpdate.setRESPONSE_LEN(rsGlobalTabTableViewUpdate.getInt("RESPONSE_LEN"));
            globalTabTableViewUpdate.setFROM_CLIENT(rsGlobalTabTableViewUpdate.getString("FROM_CLIENT"));
            globalTabTableViewUpdate.setFROM_SYS(rsGlobalTabTableViewUpdate.getString("FROM_SYS"));
            listOfTableViewObjectsAtTabGlobal.addToList(globalTabTableViewUpdate);
        }
        tabGlobalTabDatabaseTableViewDatabase.setItems(listOfTableViewObjectsAtTabGlobal.getFromList());
        String listSize = String.valueOf(listOfTableViewObjectsAtTabGlobal.getSize());
        tabGlobalTabDatabaseLabelResultsCount.setText(listSize);
    }

    /**
     * Creates bubbles. Used for visuals in GUI
     */
    public void createBubbles() {
        for (int i = 0; i < listOfMethods.length; i++) {
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

    private void populateHomeTabTableView() throws SQLException {
        listOfTableViewObjectsAtTabHome.clearList();
        ResultSet rsHomeTabTableView = queryWriter.resultSetForHomeTabTableView(url);
        while (rsHomeTabTableView.next()) {
            TableViewObjects homeTabTableView = new TableViewObjects();
            homeTabTableView.setTIME(rsHomeTabTableView.getString("TIME"));
            homeTabTableView.setIP(rsHomeTabTableView.getString("IP"));
            homeTabTableView.setPORT(rsHomeTabTableView.getInt("PORT"));
            homeTabTableView.setMETHOD(rsHomeTabTableView.getString("METHOD"));
            homeTabTableView.setREQUEST(rsHomeTabTableView.getString("REQUEST"));
            homeTabTableView.setsRESPONSE(rsHomeTabTableView.getString("sRESPONSE"));
            listOfTableViewObjectsAtTabHome.addToList(homeTabTableView);
        }
        tabHomeTableViewEntries.setItems(listOfTableViewObjectsAtTabHome.getFromList());
    }

    private void populateGlobalTabTableView() throws SQLException {
        listOfTableViewObjectsAtTabGlobal.clearList();
        ResultSet rsGlobalTabTableView = queryWriter.resultSetForGlobalTabTableViewUpdating(url);
        while (rsGlobalTabTableView.next()) {
            TableViewObjects globalTabTableView = new TableViewObjects();
            globalTabTableView.setID(rsGlobalTabTableView.getInt("ID"));
            globalTabTableView.setTIME(rsGlobalTabTableView.getString("TIME"));
            globalTabTableView.setIP(rsGlobalTabTableView.getString("IP"));
            globalTabTableView.setPORT(rsGlobalTabTableView.getInt("PORT"));
            globalTabTableView.setMETHOD(rsGlobalTabTableView.getString("METHOD"));
            globalTabTableView.setREQUEST(rsGlobalTabTableView.getString("REQUEST"));
            globalTabTableView.setRESPONSE(rsGlobalTabTableView.getInt("RESPONSE"));
            globalTabTableView.setRESPONSE_LEN(rsGlobalTabTableView.getInt("RESPONSE_LEN"));
            globalTabTableView.setFROM_CLIENT(rsGlobalTabTableView.getString("FROM_CLIENT"));
            globalTabTableView.setFROM_SYS(rsGlobalTabTableView.getString("FROM_SYS"));
            listOfTableViewObjectsAtTabGlobal.addToList(globalTabTableView);
        }
        tabGlobalTabDatabaseTableViewDatabase.setItems(listOfTableViewObjectsAtTabGlobal.getFromList());
        String listSize = String.valueOf(listOfTableViewObjectsAtTabGlobal.getSize());
        tabGlobalTabDatabaseLabelResultsCount.setText(listSize);
    }

    private void populateMethodTabTableView(String method) throws SQLException {
        listOfTableViewObjectsAtTabMethod.clearList();
        ResultSet rsMethodTabTableView = queryWriter.resultSetForMethodTabTableView(url, method);
        while (rsMethodTabTableView.next()) {
            TableViewObjects methodTabTableView = new TableViewObjects();
            methodTabTableView.setTIME(rsMethodTabTableView.getString("TIME"));
            methodTabTableView.setIP(rsMethodTabTableView.getString("IP"));
            methodTabTableView.setPORT(rsMethodTabTableView.getInt("PORT"));
            methodTabTableView.setMETHOD(rsMethodTabTableView.getString("METHOD"));
            methodTabTableView.setREQUEST(rsMethodTabTableView.getString("REQUEST"));
            methodTabTableView.setsRESPONSE(rsMethodTabTableView.getString("sRESPONSE"));
            methodTabTableView.setCLIENT(rsMethodTabTableView.getString("CLIENT"));
            listOfTableViewObjectsAtTabMethod.addToList(methodTabTableView);
        }
        tabMethodTabDatabaseTableViewDatabase.setItems(listOfTableViewObjectsAtTabMethod.getFromList());

    }

    public void populateMethodTabCombobox() {
        for (int i = 0; i < listOfMethodTypes.getSize(); i++) {
            tabMethodComboBoxVisualizeMethod.getItems().add(listOfMethodTypes.getFromList().get(i).getName());
        }
    }

    public void tabHomeDatePickerGraphOfEntriesACTION(ActionEvent actionEvent) {
    }

    public void tabHomeButtonGraphOfEntriesACTION(ActionEvent actionEvent) {
       goToOverviewTab();

    }

    public void tabHomeDatePickerGraphOfErrorsACTION(ActionEvent actionEvent) {
    }

    public void tabHomeButtonGraphOfErrorsACTION(ActionEvent actionEvent) {
        goToOverviewTab();
    }

    public void tabHomeButtonKillServerACTION(ActionEvent actionEvent) {
    }

    public void tabHomeButtonLoginToServerACTION(ActionEvent actionEvent) throws IOException {

        String operSys = System.getProperty("os.name").toLowerCase();
        if (operSys.contains("win")) {
            File file = new File("C:\\WINDOWS\\system32\\cmd.exe");
            final Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
            if (desktop != null && desktop.isSupported(Desktop.Action.OPEN)) {
                desktop.open(file);
            } else {
                throw new UnsupportedOperationException("Open action not supported");
            }
        } else if (operSys.contains("mac")) {
            File file = new File("/Applications/Utilities/Terminal.app");
            final Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
            if (desktop != null && desktop.isSupported(Desktop.Action.OPEN)) {
                desktop.open(file);
            } else {
                throw new UnsupportedOperationException("Open action not supported");
            }
        }
    }

    public void tabGlobalTabDatabaseButtonSearchACTION(ActionEvent actionEvent) throws SQLException {
        String toggleButton = null;
        String textFieldInput = tabGlobalTabDatabaseTextFieldSearchBar.getText();
        if (tabGlobalTabDatabaseToggleButtonGroupSearchToggleButtonID.isSelected()){
            toggleButton = "ID";
        }
        else if (tabGlobalTabDatabaseToggleButtonGroupSearchToggleButtonTimeStamp.isSelected()){
            toggleButton = "TIME";
        }
        else if (tabGlobalTabDatabaseToggleButtonGroupSearchToggleButtonIP.isSelected()){
            toggleButton = "IP";
        }
        else if (tabGlobalTabDatabaseToggleButtonGroupSearchToggleButtonPort.isSelected()){
            toggleButton = "PORT";
        }
        else if (tabGlobalTabDatabaseToggleButtonGroupSearchToggleButtonMethod.isSelected()){
            toggleButton = "METHOD";
        }
        else if (tabGlobalTabDatabaseToggleButtonGroupSearchToggleButtonRequest.isSelected()){
            toggleButton = "REQUEST";
        }
        else if (tabGlobalTabDatabaseToggleButtonGroupSearchToggleButtonResponse.isSelected()){
            toggleButton = "RESPONSE";
        }
        else if (tabGlobalTabDatabaseToggleButtonGroupSearchToggleButtonClient.isSelected()){
            toggleButton = "FROM_CLIENT";
        }
        else if (tabGlobalTabDatabaseToggleButtonGroupSearchToggleButtonFromService.isSelected()){
            toggleButton = "FROM_SERVICE";
        }

        System.out.println(toggleButton);

        System.out.println(textFieldInput);

        updateGlobalTabTableView(toggleButton, textFieldInput);
    }

    public void tabGlobalTabDatabaseButtonResetACTION(ActionEvent actionEvent) throws SQLException {
        populateGlobalTabTableView();
        resetToggleButtonAndTextField();
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

    public void tabMethodButtonVisualizeMethodACTION(ActionEvent actionEvent) throws SQLException {
        populateMethodTabTableView((String) tabMethodComboBoxVisualizeMethod.getSelectionModel().getSelectedItem());
    }

    public void tabGlobalTabDatabaseToggleButtonGroupSearchToggleButtonMethodACTION(ActionEvent actionEvent) {
    }

    }