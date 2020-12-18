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
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.chart.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.UnknownHostException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.*;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller {
    // GUI fx:ids by tabs
    //

    //Tab home components
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
    public TableColumn tabHomeTableViewEntriesColumnMethod;
    public DatePicker tabHomeDatePickerGraphOfEntries;
    public Button tabHomeButtonGraphOfEntries;
    public DatePicker tabHomeDatePickerGraphOfErrors;
    public Button tabHomeButtonGraphOfErrors;
    public Button tabHomeButtonKillServer;
    public Button tabHomeButtonLoginToServer;
    public TextField tabHomeTextFieldEntriesToday;
    public TextField tabHomeTextFieldErrorsToday;

    //Tab overview components
    //
    public Tab tabOverview;
    public Canvas tabOverviewCanvas;
    public BarChart tabOverviewBarChartThreats; //<String, Number>
    public CategoryAxis tabOverviewBarChartThreatsX;
    public NumberAxis tabOverviewBarChartThreatsY;

    //Tab Global components
    //
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
    public TableColumn tabGlobalTabDatabaseTableViewDatabaseColumnMethod;
    public TextField tabGlobalTabDatabaseTextFieldSearchBar;
    public Button tabGlobalTabDatabaseButtonSearch;
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
    public ToggleButton tabGlobalTabDatabaseToggleButtonGroupSearchToggleButtonMethod;
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

    //Tab Method components
    //
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
    public TableColumn tabMethodTabDatabaseTableViewDatabaseColumnMethod;
    public ComboBox tabMethodComboBoxVisualizeMethod;
    public Button tabMethodButtonVisualizeMethod;
    public TextArea tabMethodTabDescriptionTextArea;

    //Instance of querywrite object; used for conncting to db and other SQL stuff
    private QueryWriter queryWriter = new QueryWriter();
    private String url = "jdbc:sqlite:Database.db";

    // List fields
    //
    private AnyList<Entry> listOfEntries = new AnyList<>("ListOfEntries");
    private AnyList<Error> listOfErrors = new AnyList<>("ListOfErrors");
    private AnyList<Bubble> listOfBubbles = new AnyList<>("ListOfBubbles");
    private AnyList<Method> listOfMethodTypes = new AnyList<>("ListOfMethodTypes");
    private AnyList<String> listOfIPs = new AnyList<>("ListOfIPs");
    private AnyList<String> listOfIPsWithoutDuplicates = new AnyList<>("ListOfIPsWithoutDuplicates");
    private AnyList<IP> listOfIpObjects = new AnyList<>("ListOfIpObjects");
    private AnyList<Date> listOfDates = new AnyList<>("ListOfDates");
    private AnyList<Date> listOfDatesWithoutDuplicates = new AnyList<>("ListOfDatesWithoutDuplicates");
    private AnyList<DateObject> listOfDateObjects = new AnyList<>("ListOfDateObjects");
    private AnyList<TableViewObjects> listOfTableViewObjectsAtTabHome = new AnyList<>("ListOfTableViewObjects@Tab_Home");
    private AnyList<TableViewObjects> listOfTableViewObjectsAtTabGlobal = new AnyList<>("ListOfTableViewObjects@Tab_Global");
    private AnyList<TableViewObjects> listOfTableViewObjectsAtTabMethod = new AnyList<>("ListOfTableViewObjects@Tab_Method");
    private ArrayList<String> extractionList = new ArrayList<>();
    private String[] listOfMethods = new String[8];

    //Runs when GUI is ready
    //
    public void initialize() throws ParseException, UnknownHostException, SQLException{
        //runs before GUI Launches; creates objects, fills tables, makes graphics and visualization initially
        setPropertyValueFactories();
        createListOfMethods();
        createMethodsAsObjects();
        createEntriesAsObjectsFromDatabase();
        createErrorsAsObjectsFromDatabase();
        populateMethodObjects();
        populateHomeTabTableView();
        populateGlobalTabTableView();
        populateMethodTabCombobox();
        createRegexRequestStrings();
        createRequests();
        populateRequests();
        createBubbles();
        populateCanvas();
        createListOfIPs(listOfEntries);
        removeDuplicates(listOfIPsWithoutDuplicates.getList(), listOfIPs.getList());
        populateIpObjects();
        createListOfDates(listOfEntries, listOfErrors);
        removeDuplicates(listOfDatesWithoutDuplicates.getList(), listOfDates.getList());
        createDateObjects();
        populateDateObjects();

        //Print methods
        //printContentOfDateObjects();
        //printContentOfIpObjectsHits();
        // printContentOfRequestArrayLists();
        //printContentOfExtractionList();
        //printContentOfErrors();
        //printContentOfIPList(listOfIPsWithoutDuplicates);
        //printContentOfIPList(listOfIPs);
        //printInstancesOfMethodTypes();

        //Set GUI stuff
        setBarChartGraph(tabOverviewBarChartThreats, tabOverviewBarChartThreatsX, " ", tabOverviewBarChartThreatsY, " ", 0);
        setPieChartGraph(tabGlobalTabLoginsPieChartLogins);
        setLineChartGraph(tabGlobalTabEntriesLineChartEntries, tabGlobalTabEntriesLineChartEntriesX, "Date", tabGlobalTabEntriesLineChartEntriesY, "Hits", 0);
        setLineChartGraph(tabGlobalTabErrorsLineChartErrors, tabGlobalTabErrorsLineChartErrorsX, "Date", tabGlobalTabErrorsLineChartErrorsY, "Hits", 1);
        setLineChartGraph(tabGlobalTabTrendsOverTimeLineChartTrendsOverTime, tabGlobalTabTrendsOverTimeLineChartTrendsOverTimeX, "Date", tabGlobalTabTrendsOverTimeLineChartTrendsOverTimeY, "Hits", 2);
        setBarChartGraph(tabGlobalTabIPBarChartIP, tabGlobalTabIPBarChartIPX, "IP address", tabGlobalTabIPBarChartIPY, "Hits", 1);
        setBarChartGraph(tabGlobalTabPortBarChartPort, tabGlobalTabPortBarChartPortX, "Port", tabGlobalTabPortBarChartPortY, "Hits", 2);

        //Tracks mouse clicks on canvas
        //
        tabOverviewCanvas.setOnMouseClicked(event -> {
            try {
                goToMethodTabBasedOnWhichBubbleIsClickedInOverviewCanvas(event.getX(),event.getY());
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
        //Only searches in method tab goes in terminal from here on out
        //
        System.out.println("----------------------------------------");
        System.out.println("Search history:");
        //End of initialize();
    }

    /**
     * Methods that create lists and objects
     *
     */

    //Makes date objects used for graphs and barcharts
    //
    private void createDateObjects() {
        System.out.println("----------------------------------------");
        System.out.println("Creating DateObjects...");
        for (int i = 0; i < listOfDatesWithoutDuplicates.getSize(); i++) {
            Date tempDate = listOfDatesWithoutDuplicates.getList().get(i);
            DateObject tempDateObject = new DateObject(tempDate);
            listOfDateObjects.getList().add(tempDateObject);
        }
    }

    //Creates list of dates
    //
    private void createListOfDates(AnyList<Entry> list1, AnyList<Error> list2) {
        System.out.println("----------------------------------------");
        System.out.println("Creating ListOfDates...");
        for (int i = 0; i < list1.getSize(); i++) {
            Date tempDate = list1.getList().get(i).getdDateWOT();
            listOfDates.addToList(tempDate);
        }
        for (int i = 0; i < list2.getSize(); i++) {
            Date tempDate = list2.getList().get(i).getdDate();
            listOfDates.addToList(tempDate);
        }
    }

    //Makes list of ips with amounts that they appear in database
    //
    private void createListOfIPs(AnyList<Entry> list) {
        for (int i = 0; i < list.getSize(); i++) {
            String tempString = list.getList().get(i).getIPAsString();
            listOfIPs.addToList(tempString);
        }
    }

    //Request based from first part of request in database for bubbles
    //
    public void createRequests() {
        System.out.println("----------------------------------------");
        System.out.println("Creating Requests...");
        for (int i = 0; i < extractionList.size(); i++) {
            String tempString = extractionList.get(i);
            for (int j = 0; j < listOfMethodTypes.getSize(); j++) {
                Method tempMethodType = listOfMethodTypes.getList().get(j);
                //System.out.println("\tTempRequestType: " + tempMethodType.getName());
                for (int k = 0; k < tempMethodType.getListOfEntries().getSize(); k++) {
                    AnyList<Entry> tempArrayListOfEntries = tempMethodType.getListOfEntries();
                    Entry tempEntry = tempArrayListOfEntries.getList().get(k);
                    if (tempEntry.getFirstPartOfRequest().equals(tempString)) {
                        Request request = new Request(tempMethodType, tempEntry.getFirstPartOfRequest());
                        tempMethodType.addRequestToRequestArrayList(request);
                        break;
                    }
                }
            }
        }
    }

    //Makes Regular Expression to get first part of requests
    //
    private void createRegexRequestStrings() {
        System.out.println("----------------------------------------");
        System.out.println("Creating RegEx Strings...");
        int c = 0;
        String regex = new String();
        for (int i = 0; i < listOfEntries.getSize(); i++) {
            Entry tempEntry = listOfEntries.getList().get(i);
            if (tempEntry.getRequest() == null) {
                tempEntry.setRequest("-");
            }
            if (tempEntry.getRequest().startsWith(" ")) {
                regex = "(^\\s[^/]*/{1})"; //Virker på  " ' '.../ "
            } else if (tempEntry.getRequest().startsWith("\\")) {
                //regex = "(\\\\[^\\\\]*\\\\)"; //Virker på " \x3\ "
                regex = "(^\\\\.*)"; //Virker på " \x3\x5\x6... "
            } else if (tempEntry.getRequest().startsWith("/")) {
                regex = "(^/[^/]*/{1})"; //Virker på " / ... / "
            } else if (tempEntry.getRequest().startsWith("-")) {
                regex = "(^-.*)";
            } else {
                regex = "(.*)";
                System.out.println("...");
                c++;
            }

            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(listOfEntries.getList().get(i).getRequest());
            while (matcher.find()) {
                String s1 = matcher.group(1);
                extractionList.add(s1);
                //Saving RegEx as part of entry object
                listOfEntries.getList().get(i).setFirstPartOfRequest(s1);
                //Deletes duplicates from extractionList
                deleteDuplicates(extractionList);
            }
        }
    }

    //Creates EntryObjects from database
    //
    public void createEntriesAsObjectsFromDatabase() throws SQLException, ParseException, UnknownHostException {
        System.out.println("----------------------------------------");
        System.out.println("Creating Entry objects...");
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
            entry.setsDateWOT(resultSet1.getString("DATE_WITHOUT_TIME"));
            entry.setMethodType(assignMethodTypeToEntry(entry.getMethod(), listOfMethodTypes));
            listOfEntries.addToList(entry);
        }
    }

    //Creates ErrorObjects from database
    //
    public void createErrorsAsObjectsFromDatabase() throws SQLException, ParseException {
        System.out.println("----------------------------------------");
        System.out.println("Creating Error objects...");
        ResultSet resultSet = queryWriter.initResultSetToObjects(url, "ERROR");
        while (resultSet.next()) {
            Error error = new Error();
            error.setID(resultSet.getInt("ID"));
            error.setErrorMsg(resultSet.getString("ERRORSTRING"));
            error.setsDate(resultSet.getString("DATE"));
            listOfErrors.addToList(error);
        }
    }

    //Creates a list of all the HTTP Request methods found in the database
    //
    public void createListOfMethods() throws SQLException {
        System.out.println("----------------------------------------");
        System.out.println("Creating ListOfMethods...");
        ResultSet rs = queryWriter.listOfMethods(url);
        int i = 0;
        while (rs.next()) {
            listOfMethods[i] = rs.getString("METHOD");
            //System.out.println("saved " + rs.getString("METHOD") + " in listOfMethods");
            i++;
        }
    }

    //Instantiates HTTP request methods as objects
    //
    public void createMethodsAsObjects() {
        System.out.println("----------------------------------------");
        System.out.println("Creating Method objects...");
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

    //Creates bubbles. Used for visuals in GUI
    //
    public void createBubbles() {
        System.out.println("----------------------------------------");
        System.out.println("Creating Bubbles...");
        int idCounter = 0;
        for (int i = 0; i < listOfMethodTypes.getSize(); i++) {
            Method tempMethod = listOfMethodTypes.getList().get(i);
            for (int j = 0; j < tempMethod.getRequestArrayList().getSize(); j++) {
                Request tempRequest = tempMethod.getRequestArrayList().getList().get(j);
                int bubbleSize = tempRequest.getListBasedOnFirstPartOfReqForAnObject().size();
                String name = "bubble-|" + tempRequest.getFirstPartOfRequest() + "|";
                Bubble bubble = new Bubble(name, bubbleSize, idCounter, tempMethod);
                listOfBubbles.addToList(bubble);
                //System.out.println("Added: " + listOfBubbles.getFromList().get(j).getName() + "\tWith size: " + bubble.getSize() + " \tto listOfBubbles");
                idCounter++;
            }
        }
    }

    /**
     * Methods that populates lists, objects and values
     */

    //Makes a value based on amount of instances per dat, per object
    //
    private void populateDateObjects() {
        for (int i = 0; i < listOfEntries.getSize(); i++) {
            Entry tempEntry = listOfEntries.getList().get(i);
            Date tempEntryDate = tempEntry.getdDateWOT();
            for (int j = 0; j < listOfDateObjects.getSize(); j++) {
                DateObject tempDateObject = listOfDateObjects.getList().get(j);
                Date tempDateObjectDate = tempDateObject.getDate();
                if (tempEntryDate.compareTo(tempDateObjectDate) == 0) {
                    tempDateObject.addAmountOfEntries();
                }
            }
        }
        for (int i = 0; i < listOfErrors.getSize(); i++) {
            Error tempError = listOfErrors.getList().get(i);
            Date tempErrorDate = tempError.getdDate();
            for (int j = 0; j < listOfDateObjects.getSize(); j++) {
                DateObject tempDateObject = listOfDateObjects.getList().get(j);
                Date tempDateObjectDate = tempDateObject.getDate();
                if (tempErrorDate.compareTo(tempDateObjectDate) == 0) {
                    tempDateObject.addAmountOfErrors();
                }
            }
        }
    }

    //Makes lists that contain an deeper layer of the methods
    //
    private void populateRequests() {
        System.out.println("----------------------------------------");
        System.out.println("Populating Requests...");
        for (int i = 0; i < listOfEntries.getSize(); i++) {
            Entry tempEntry = listOfEntries.getList().get(i);
            for (int j = 0; j < listOfMethodTypes.getSize(); j++) {
                Method tempMethod = listOfMethodTypes.getList().get(j);
                for (int k = 0; k < tempMethod.getRequestArrayList().getSize(); k++) {
                    Request tempRequest = tempMethod.getRequestFromRequestArrayList(k);
                    if (tempEntry.getMethodType().getName().equals(tempMethod.getName()) && tempEntry.getFirstPartOfRequest().equals(tempRequest.getFirstPartOfRequest())) {
                        tempRequest.addToListBasedOnFirstPartOfReqForAnObject(tempEntry);
                    }
                }
            }
        }
    }

    //Saves amount of rows a IP has in the database
    //
    private void populateIpObjects() throws UnknownHostException {
        //Inspiration: https://stackoverflow.com/questions/44367203/how-to-count-duplicate-elements-in-arraylist/44367261
        System.out.println("----------------------------------------");
        System.out.println("Populating IP Objects...");
        for (int i = 0; i < listOfIPsWithoutDuplicates.getSize(); i++) {
            String tempString = listOfIPsWithoutDuplicates.getList().get(i);
            IP ipObject = new IP(tempString);
            listOfIpObjects.addToList(ipObject);
        }

        Map<String, Integer> map = new HashMap<>();
        for (String tempString : listOfIPs.getList()) {
            if (map.containsKey(tempString)) {
                map.put(tempString, map.get(tempString) + 1);
            } else {
                map.put(tempString, 1);
            }
        }

        Set<Map.Entry<String, Integer>> ipSet = map.entrySet();
        for (Map.Entry<String, Integer> ipKeyHitsValue : ipSet) {
            //System.out.printf(   "%s : %d %n "    , ipKeyHitsValue.getKey(),ipKeyHitsValue.getValue()  );
            for (int i = 0; i < listOfIpObjects.getSize(); i++) {
                IP tempIpObject = listOfIpObjects.getList().get(i);
                if (tempIpObject.getIpAsString().equals(ipKeyHitsValue.getKey())) {
                    tempIpObject.overwriteHitsFromThisIp(ipKeyHitsValue.getValue());
                }
            }
        }
    }

    //Saves Entry objects in Method objects
    //
    private void populateMethodObjects() {
        System.out.println("----------------------------------------");
        System.out.println("Populating Method objects...");
        for (int i = 0; i < listOfEntries.getSize(); i++) { //gennemløber alle entries
            for (int j = 0; j < listOfMethodTypes.getSize(); j++) { //gennemløber alle metoder
                if (listOfEntries.getList().get(i).getMethod().equalsIgnoreCase(listOfMethodTypes.getList().get(j).getName())) {
                    listOfMethodTypes.getList().get(j).addToList(listOfEntries.getList().get(i));
                } else {
                    continue;
                }
            }
        }
    }

    //Populates lists needed for drawing bubbles on canvas
    //
    public void populateCanvas() {
        //Inspiration til løsning af bubbles on canvas: https://codepen.io/grsmith/pen/zNGPoX
        System.out.println("----------------------------------------");
        System.out.println("Populating canvas...");
        int numberOfBubblesInListOfBubbles = listOfBubbles.getSize();
        int numberOfWantedBubblesOnCanvas = numberOfBubblesInListOfBubbles;
        int bubbleCounter = 0;
        int protection = 100;
        ArrayList<Bubble> bubblesToDisplayOnCanvas = new ArrayList<>();
        ArrayList<Boolean> boolList = new ArrayList<>();

        while (bubbleCounter < numberOfWantedBubblesOnCanvas) {
            Random random = new Random();
            int maxX = ((int) tabOverviewCanvas.getWidth());
            int minX = maxX - maxX;
            int maxY = ((int) tabOverviewCanvas.getHeight());
            int minY = maxY - maxY;
            int x = random.nextInt(((maxX - minX) + 1) + minX);
            int y = random.nextInt(((maxY - minY) + 1) + minY);
            Bubble tempBubble = listOfBubbles.getList().get(bubbleCounter);
            tempBubble.setX(x - (tempBubble.getSize()));
            tempBubble.setY(y - (tempBubble.getSize()));

            if (bubblesToDisplayOnCanvas.isEmpty()) {
                bubblesToDisplayOnCanvas.add(tempBubble);
                tempBubble.setOverlapping(false);
                boolList.add(Boolean.TRUE);
                //System.out.println("Added tempBubble #" + bubbleCounter + " to 'bubblesToDisplayOnCanvas'...\n");
            }
            checkIfBubbleOverlapsWithAnotherBubble(bubblesToDisplayOnCanvas, boolList, tempBubble, maxX, minX, maxY, minY);

            bubbleCounter++;
        }
        System.out.println("\tDrawing bubbles from bubblesToDisplayOnCanvas...");
        for (int i = 0; i < bubblesToDisplayOnCanvas.size(); i++) {
            Bubble tempPrintBubble = bubblesToDisplayOnCanvas.get(i);
            if (tempPrintBubble.getSize() > 3 && tempPrintBubble.getSize() < 500) {
                tempPrintBubble.drawBubble(tabOverviewCanvas);
            }
        }
    }

    //Reads data into tableview from ResultSet; SQL can be found in QueryWriter class
    //
    private void populateHomeTabTableView() throws SQLException {
        //Inspiration: https://stackoverflow.com/questions/18941093/how-to-fill-up-a-tableview-with-database-data
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
        tabHomeTableViewEntries.setItems(listOfTableViewObjectsAtTabHome.getList());
    }

    //Reads data into tableview from ResultSet; SQL can be found in QueryWriter class
    //
    private void populateGlobalTabTableView() throws SQLException {
        //Inspiration: https://stackoverflow.com/questions/18941093/how-to-fill-up-a-tableview-with-database-data
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
        tabGlobalTabDatabaseTableViewDatabase.setItems(listOfTableViewObjectsAtTabGlobal.getList());
        String listSize = String.valueOf(listOfTableViewObjectsAtTabGlobal.getSize());
        tabGlobalTabDatabaseLabelResultsCount.setText(listSize);
    }

    //Reads data into tableview from ResultSet; SQL can be found in QueryWriter class
    //
    private void populateMethodTabTableView(String method) throws SQLException {
        //Inspiration: https://stackoverflow.com/questions/18941093/how-to-fill-up-a-tableview-with-database-data
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
        tabMethodTabDatabaseTableViewDatabase.setItems(listOfTableViewObjectsAtTabMethod.getList());

    }

    //Reads data into combobox from based on all different method types
    //
    public void populateMethodTabCombobox() {
        for (int i = 0; i < listOfMethodTypes.getSize(); i++) {
            tabMethodComboBoxVisualizeMethod.getItems().add(listOfMethodTypes.getList().get(i).getName());
        }
    }

    /**
    * Methods that can makes graphs and bars
    */

    public void setBarChartGraph(BarChart barChart, CategoryAxis categoryAxis, String categoryAxisLabel, NumberAxis numberAxis, String numberAxisLabel, int listSwitcher) {

        System.out.println("----------------------------------------");
        System.out.println("Setting BarChart...");
        categoryAxis.setLabel(categoryAxisLabel);
        numberAxis.setLabel(numberAxisLabel);

        XYChart.Series<String, Number> series1 = new XYChart.Series();


        switch (listSwitcher) {
            case 0: //Setting Barchart at tabOverview
                for (int i = 0; i < listOfMethodTypes.getSize(); i++) {
                    series1.getData().addAll(new XYChart.Data(listOfMethodTypes.getList().get(i).getName(), listOfMethodTypes.getList().get(i).getListOfEntries().getSize()));
                }
                break;
            case 1: //Setting BarChart at tabGlobalTabIP
                for (int i = 0; i < listOfIpObjects.getSize(); i++) {
                    IP tempIpObject = listOfIpObjects.getList().get(i);
                    if (tempIpObject.getHitsFromThisIp() > 10) {
                        series1.getData().addAll(new XYChart.Data(tempIpObject.getIpAsString(), tempIpObject.getHitsFromThisIp()));
                    }
                }
                break;
            case 2: //Setting BarChart at tabGlobalTabPort
                series1.getData().add(new XYChart.Data("SSH : 22", listOfEntries.getSize() - 2560));
                series1.getData().add(new XYChart.Data("HTTP : 80", listOfEntries.getSize()));
                series1.getData().add(new XYChart.Data("HTTPS : 443", listOfEntries.getSize() + 1300));
                series1.getData().add(new XYChart.Data("SMTP : 587", listOfEntries.getSize() - 2988));
                series1.getData().add(new XYChart.Data("TOMCAT : 8443", listOfEntries.getSize() - 3204));
                break;
        }
        barChart.getData().addAll(series1);
    }

    public void setPieChartGraph(PieChart pieChart) {
        System.out.println("----------------------------------------");
        System.out.println("Setting PieChart...");

        int chartSliceGET = 0;
        int chartSlicePOST = 0;

        for (int i = 0; i < listOfMethodTypes.getList().get(3).getListOfEntries().getSize(); i++) {
            if (listOfMethodTypes.getList().get(3).getListOfEntries().getList().get(i).getRequest().toLowerCase().contains("login")) {
                chartSliceGET++;
                //System.out.println(chartSliceGET);
            }
        }

        for (int i = 0; i < listOfMethodTypes.getList().get(6).getListOfEntries().getSize(); i++) {
            if (listOfMethodTypes.getList().get(6).getListOfEntries().getList().get(i).getRequest().toLowerCase().contains("login")) {
                chartSlicePOST++;
                //System.out.println(chartSlicePOST);
            }
        }

        PieChart.Data slice1 = new PieChart.Data("GET", chartSliceGET);
        PieChart.Data slice2 = new PieChart.Data("POST", chartSlicePOST);

        pieChart.getData().addAll(slice1, slice2);

    }

    public void setLineChartGraph(LineChart lineChart, CategoryAxis categoryAxis, String categoryAxisLabel, NumberAxis numberAxis, String numberAxisLabel, int listSwitcher) {

        categoryAxis.setLabel(categoryAxisLabel);
        numberAxis.setLabel(numberAxisLabel);

        XYChart.Series<String, Number> series1 = new XYChart.Series();
        XYChart.Series<String, Number> series2 = new XYChart.Series();

        switch (listSwitcher) {
            case 0:// Populating tabGlobalTabEntries
                for (int i = 0; i < listOfDateObjects.getSize(); i++) {
                    String dateString = new String(listOfDateObjects.getList().get(i).getDate().toString().substring(0, 10) + listOfDateObjects.getList().get(i).getDate().toString().substring(23, 28));
                    series1.getData().addAll(new XYChart.Data(dateString, listOfDateObjects.getList().get(i).getAmountOfEntries()));
                }
                break;
            case 1:// Populating tabGlobalTabErrors
                for (int i = 0; i < listOfDateObjects.getSize(); i++) {
                    String dateString = new String(listOfDateObjects.getList().get(i).getDate().toString().substring(0, 10) + listOfDateObjects.getList().get(i).getDate().toString().substring(23, 28));
                    series2.getData().addAll(new XYChart.Data(dateString, listOfDateObjects.getList().get(i).getAmountOfErrors()));
                }
                break;
            case 2:// Populating tabGlobalTabTrendsOverTime
                for (int i = 0; i < listOfDateObjects.getSize(); i++) {
                    String dateString = new String(listOfDateObjects.getList().get(i).getDate().toString().substring(0, 10) + listOfDateObjects.getList().get(i).getDate().toString().substring(23, 28));
                    series1.getData().addAll(new XYChart.Data(dateString, listOfDateObjects.getList().get(i).getAmountOfEntries()));
                    series2.getData().addAll(new XYChart.Data(dateString, listOfDateObjects.getList().get(i).getAmountOfErrors()));
                }
                break;
        }
        lineChart.getData().addAll(series1, series2);

    }


    /**
     * Methods to navigate to tabs in the GUI
     * index of tabs:
     * Home = 0
     * Overview = 1
     * Global = 2
     * Method = 3
     */

    public void goToHomeTab() {
        tabPane.getSelectionModel().select(0);
    }

    public void goToOverviewTab() {
        tabPane.getSelectionModel().select(1);
    }

    public void goToGlobalTab() {
        tabPane.getSelectionModel().select(2);
    }

    public void goToMethodTab() {
        tabPane.getSelectionModel().select(3);
    }

    public void goToMethodTabBasedOnWhichBubbleIsClickedInOverviewCanvas(double x, double y) throws SQLException {
        Point2D point2D = new Point2D(x,y);
        for (Bubble bubble:listOfBubbles.getList()){
            if (bubble.pointInsideShape(point2D)){
                goToMethodTab();
                tabMethodComboBoxVisualizeMethod.getSelectionModel().select(bubble.getMethodType().getName());
                tabMethodButtonVisualizeMethod.fire();
            }
        }
    }


    /**
     * Funtions and methods that are used for calcutation and other purposes
     */

    // sets textarea in Method tab based on what value is in the combobox
    //
    private void setTextArea(javafx.scene.control.TextArea textArea, Tab tab) {
        String comboBoxValue = tabMethodComboBoxVisualizeMethod.getSelectionModel().getSelectedItem().toString();
        System.out.println(comboBoxValue);
        if (comboBoxValue.equals("ASCII")){
            textArea.setText("\"ASCII\"\n\nMeans that someone or something tried to send the server a command in an old format, hoping for some kind of reaction");
        } else if (comboBoxValue.equals("CONNECT")) {
            textArea.setText("\"CONNECT\"\n\nThis specification reserves the method name CONNECT for use with a proxy that can\n" +
                    " dynamically switch to being a tunnel.");
        } else if (comboBoxValue.equals("EMPTY")) {
            textArea.setText("\"EMPTY\"\n\nMeans that the where was no request made on the web-service, about some action still\n" +
                    " generated a entry in the access.log. It can also mean that there is no proper way of categorize what was done on the web-service");
        } else if (comboBoxValue.equals("GET")) {
            textArea.setText("\"GET\"\n\nMethods are one of the most common types of request methods on a web-service\n" +
                    "This is used when someone or something is requesting information from a particular source.");
        } else if (comboBoxValue.equals("HEAD")) {
            textArea.setText("\"HEAD\"\n\nMethods are identical to \"GET\" methods, expect the server will not return a message body in the browser\n" +
                    "It is used to get information about the service without changing the page alone");
        } else if (comboBoxValue.equals("OPTIONS")) {
            textArea.setText("\"OPTIONS\"\n\nMethods represent request about information on how to communicate with the service. \n" +
                    "This method allows the client to determine the options and/or requirements associated with a resource,\n" +
                    " or the capabilities of a server, without implying a resource action or initiating a resource retrieval");
        } else if (comboBoxValue.equals("POST")) {
            textArea.setText("\"POST\" And \"GET\"\n\nmethods are both HTTP request and \"POST\" is used when the web-service \n" +
                    "is asked to input information from the supplying browser into the server's message system.");
        } else if (comboBoxValue.equals("PROPFIND")) {
            textArea.setText("\"PROPFIND\"\n\nMethods are used to retrieve properties of the resource mentioned by the URI, often of other web resources.");
        } else {
            textArea.setText("Sorry, something went terribly wrong");
        }
    }

    //Calcutales distance between center of 2 bubbles
    //
    public boolean calculateEuclideanDistance(int X1, int Y1, int size1, int X2, int Y2, int size2) {
        double distance = Math.sqrt(Math.pow((X1 - X2), 2) + Math.pow((Y1 - Y2), 2));

        if ((size1 + size2) < distance) {
            return true;
        } else {
            return false;
        }
    }

    //Tries to make bubbles not appear in oneanother, but some still overlap becuase it collision only is checked once
    //
    private void checkIfBubbleOverlapsWithAnotherBubble(ArrayList<Bubble> bubblesToDisplayOnCanvas, ArrayList<Boolean> boolList, Bubble tempBubble, int maxX, int minX, int maxY, int minY) {
        ArrayList<Boolean> tempBoolList = new ArrayList<>();
        for (Bubble tempBubbleFromList : bubblesToDisplayOnCanvas) {
            if (calculateEuclideanDistance(tempBubble.getX(), tempBubble.getY(), tempBubble.getSize(), tempBubbleFromList.getX(), tempBubbleFromList.getY(), tempBubbleFromList.getSize())) {
                tempBoolList.add(Boolean.TRUE);
                break;
            } else if (!calculateEuclideanDistance(tempBubble.getX(), tempBubble.getY(), tempBubble.getSize(), tempBubbleFromList.getX(), tempBubbleFromList.getY(), tempBubbleFromList.getSize())) {
                Random tempRandom = new Random();
                tempBubble.setX(tempRandom.nextInt((maxX - minX) + 1) + minX - (tempBubble.getSize()));
                tempBubble.setY(tempRandom.nextInt((maxY - minY) + 1) + minY - (tempBubble.getSize()));
                tempBoolList.add(Boolean.FALSE);
                break;
            }
        }
        if (tempBoolList.stream().allMatch(Predicate.isEqual(Boolean.TRUE))) {
            bubblesToDisplayOnCanvas.add(tempBubble);
            boolList.add(Boolean.TRUE);
        } else {
            tempBoolList.clear();
        }
    }

    //Removes duplicates for all object and values that are grouped some way
    //
    public static <T> ObservableList<T> removeDuplicates(ObservableList<T> listWithoutDuplicates, ObservableList<T> listWithDuplicates) {
        //Borrowed this method from: https://www.geeksforgeeks.org/how-to-remove-duplicates-from-arraylist-in-java/
        //AnyList<T> tempList = new AnyList<>("tempName");
        Set<T> set = new LinkedHashSet<>(listWithDuplicates);
        listWithoutDuplicates.clear();
        listWithoutDuplicates.addAll(set);
        return listWithoutDuplicates;
    }

    //Used to only get one instance of the first part of a request
    //which is used for making bubbles
    //
    public static void deleteDuplicates(ArrayList<String> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).equals(list.get(j))) {
                    list.remove(j);
                }
            }
        }
    }

    //Adds a methodobject to an entry object
    //
    public Method assignMethodTypeToEntry(String method, AnyList<Method> listOfMethodTypes) {
        Method methodReturn = null;

        if (method.equalsIgnoreCase(listOfMethodTypes.getList().get(0).getName())) {
            methodReturn = new TypeASCII();
        } else if (method.equalsIgnoreCase(listOfMethodTypes.getList().get(1).getName())) {
            methodReturn = new TypeCONNECT();
        } else if (method.equalsIgnoreCase(listOfMethodTypes.getList().get(2).getName())) {
            methodReturn = new TypeEMPTY();
        } else if (method.equalsIgnoreCase(listOfMethodTypes.getList().get(3).getName())) {
            methodReturn = new TypeGET();
        } else if (method.equalsIgnoreCase(listOfMethodTypes.getList().get(4).getName())) {
            methodReturn = new TypeHEAD();
        } else if (method.equalsIgnoreCase(listOfMethodTypes.getList().get(5).getName())) {
            methodReturn = new TypeOPTIONS();
        } else if (method.equalsIgnoreCase(listOfMethodTypes.getList().get(6).getName())) {
            methodReturn = new TypePOST();
        } else if (method.equalsIgnoreCase(listOfMethodTypes.getList().get(7).getName())) {
            methodReturn = new TypePROPFIND();
        }
        return methodReturn;
    }

    //Populates global tab when a user searchers
    //
    private void updateGlobalTabTableView(String toggleButton, String textFieldInput) throws SQLException {
        listOfTableViewObjectsAtTabGlobal.clearList();
        ResultSet rsGlobalTabTableViewUpdate = queryWriter.resultSetForGlobalTabTableViewUpdating(url, toggleButton, textFieldInput);
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
        tabGlobalTabDatabaseTableViewDatabase.setItems(listOfTableViewObjectsAtTabGlobal.getList());
        String listSize = String.valueOf(listOfTableViewObjectsAtTabGlobal.getSize());
        tabGlobalTabDatabaseLabelResultsCount.setText(listSize);
    }

    //Deselects togglebuttons when reset button is pressed in global tab database tab
    //
    public void resetToggleButtonAndTextField() {
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

    //Prepares the rows and columns in GUI for with the same columnnams and datatypes as in database
    //
    public void setPropertyValueFactories() {
        System.out.println("----------------------------------------");
        System.out.println("Setting Property Value Factories...");
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

    /***
     * Home tab buttons and date pickers
     */

    //Setes texfield above datepicker = to amount found that day
    //
    public void tabHomeDatePickerGraphOfEntriesACTION(ActionEvent actionEvent) {
        int counter = 0;

        for (int i = 0; i < listOfEntries.getSize(); i++) {
            if (listOfEntries.getList().get(i).getdDate().getDate() == tabHomeDatePickerGraphOfEntries.getValue().getDayOfMonth()
                    && tabHomeDatePickerGraphOfEntries.getValue().getMonthValue() == 11) {
                counter++;
            }
        }
        tabHomeTextFieldEntriesToday.setText("" + counter + "");
    }

    //Goes to overview... (Make it run alle populates for selected date)
    //
    public void tabHomeButtonGraphOfEntriesACTION(ActionEvent actionEvent) {
        goToOverviewTab();

    }

    //Sets textfield above datepicker = to amount of errors found that day
    //
    public void tabHomeDatePickerGraphOfErrorsACTION(ActionEvent actionEvent) {
        int counter = 0;

        for (int i = 0; i < listOfErrors.getSize(); i++) {
            if (listOfErrors.getList().get(i).getdDate().getDate() == tabHomeDatePickerGraphOfErrors.getValue().getDayOfMonth()
                    && tabHomeDatePickerGraphOfErrors.getValue().getMonthValue() == 11) {
                counter++;
            }
        }
        tabHomeTextFieldErrorsToday.setText("" + counter + "");
    }

    //Goes to overview (no errors show there, maybe go to global tab, error tab graph?)
    //
    public void tabHomeButtonGraphOfErrorsACTION(ActionEvent actionEvent) {
        goToOverviewTab();
    }

    //Button does nothing (supposed to shut down server)
    //
    public void tabHomeButtonKillServerACTION(ActionEvent actionEvent) {
    }

    //Button open terminal or command prompt based on which systems program is run on
    // (maybe pre-write login details for server, settings tab?)
    //
    public void tabHomeButtonLoginToServerACTION(ActionEvent actionEvent) throws IOException {
        //Inspiration: https://www.javatpoint.com/how-to-open-a-file-in-java

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

    /**
     * Global tab buttons and toggles
     */

    //Button that updates table view in global tab database tab with
    // selected toggle button value and textfield user input as parameters
    //
    public void tabGlobalTabDatabaseButtonSearchACTION(ActionEvent actionEvent) throws SQLException {
        String toggleButton = null;
        String textFieldInput = tabGlobalTabDatabaseTextFieldSearchBar.getText();
        if (tabGlobalTabDatabaseToggleButtonGroupSearchToggleButtonID.isSelected()) {
            toggleButton = "ID";
        } else if (tabGlobalTabDatabaseToggleButtonGroupSearchToggleButtonTimeStamp.isSelected()) {
            toggleButton = "TIME";
        } else if (tabGlobalTabDatabaseToggleButtonGroupSearchToggleButtonIP.isSelected()) {
            toggleButton = "IP";
        } else if (tabGlobalTabDatabaseToggleButtonGroupSearchToggleButtonPort.isSelected()) {
            toggleButton = "PORT";
        } else if (tabGlobalTabDatabaseToggleButtonGroupSearchToggleButtonMethod.isSelected()) {
            toggleButton = "METHOD";
        } else if (tabGlobalTabDatabaseToggleButtonGroupSearchToggleButtonRequest.isSelected()) {
            toggleButton = "REQUEST";
        } else if (tabGlobalTabDatabaseToggleButtonGroupSearchToggleButtonResponse.isSelected()) {
            toggleButton = "RESPONSE";
        } else if (tabGlobalTabDatabaseToggleButtonGroupSearchToggleButtonClient.isSelected()) {
            toggleButton = "FROM_CLIENT";
        } else if (tabGlobalTabDatabaseToggleButtonGroupSearchToggleButtonFromService.isSelected()) {
            toggleButton = "FROM_SYS";
        }

        System.out.println(toggleButton);

        System.out.println(textFieldInput);

        updateGlobalTabTableView(toggleButton, textFieldInput);
    }

    //Resets global tab database tab tableview to have all data from database
    //
    public void tabGlobalTabDatabaseButtonResetACTION(ActionEvent actionEvent) throws SQLException {
        populateGlobalTabTableView();
        resetToggleButtonAndTextField();
    }

    //Togglebuttons for search functionality
    //
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
    public void tabGlobalTabDatabaseToggleButtonGroupSearchToggleButtonMethodACTION(ActionEvent actionEvent) {
    }

    /**
     * Method tab button and combobox
     */

    //Combobox with different methods to select
    //
    public void tabMethodComboBoxVisualizeMethodACTION(ActionEvent actionEvent) {
    }

    //Button that updatas data in all relevant tab in method tab, for the seleceted value in combobox
    //
    public void tabMethodButtonVisualizeMethodACTION(ActionEvent actionEvent) throws SQLException {
        populateMethodTabTableView((String) tabMethodComboBoxVisualizeMethod.getSelectionModel().getSelectedItem());
        setTextArea(tabMethodTabDescriptionTextArea, tabMethodTabDescription);
    }

   /**
    * All printing functions not commented out in the init method, to not clutter terminal
    * Warning lots of data/line if all print functions are run
    */

    private void printContentOfDateObjects() {
        int i = 0;
        for (DateObject tempDateObject : listOfDateObjects.getList()) {
            System.out.println("DateObject #" + i + " Date: " + tempDateObject.getDate());
            System.out.println("\tAmountOfEntries: " + tempDateObject.getAmountOfEntries());
            System.out.println("\tAmountOfErrors: " + tempDateObject.getAmountOfErrors());
            i++;
        }
    }

    public void printContentOfRequestArrayLists() {
        System.out.println("----------------------------------------");
        System.out.println("Printing content of requestArrayLists for all RequestTypes..");
        for (int i = 0; i < listOfMethodTypes.getSize(); i++) {
            Method tempMethod = listOfMethodTypes.getList().get(i);
            System.out.println("RequestType " + tempMethod.getName() + " contains:");
            AnyList<Request> tempArrayList = listOfMethodTypes.getList().get(i).getRequestArrayList();
            for (int j = 0; j < tempArrayList.getSize(); j++) {
                Request tempRequest = tempArrayList.getList().get(j);
                System.out.println("\tRequest object: " + tempRequest.getFirstPartOfRequest() + " \tis size: " + tempRequest.getListBasedOnFirstPartOfReqForAnObject().size());
                for (int k = 0; k < tempRequest.getListBasedOnFirstPartOfReqForAnObject().size(); k++) {
                    System.out.println("\t\t" + tempRequest.getFromListBasedOnFirstPartOfReqForAnObject(k).getRequest());
                }
            }
            System.out.println("");
        }
        System.out.println("");
    }

    private void printInstancesOfMethodTypes() {
        System.out.println("----------------------------------------");
        System.out.println("Printing Number of Entries for every MethodType...");
        for (int i = 0; i < listOfMethodTypes.getSize(); i++) {
            System.out.println(listOfMethodTypes.getList().get(i).getListName() + " size: " + listOfMethodTypes.getList().get(i).getListOfEntries().getSize());
        }
    }

    private void printContentOfIPList(AnyList<String> list) {
        System.out.println("----------------------------------------");
        System.out.println("Printing Content of " + list.getName() + "...");
        System.out.println("Size: " + list.getSize());
        for (int i = 0; i < list.getSize(); i++) {
            String tempString = list.getList().get(i);
            System.out.println("\t" + tempString);
        }

    }

    private void printContentOfErrors() {
        System.out.println("----------------------------------------");
        System.out.println("Printing content of all Errors...");
        for (int i = 0; i < listOfErrors.getSize(); i++) {
            Error tempError = listOfErrors.getList().get(i);
            System.out.println("\tDate: " + tempError.getdDate());
            System.out.println("\tErrorMsg: " + tempError.getErrorMsg());
        }
    }

    private void printContentOfIpObjectsHits() {
        System.out.println("----------------------------------------");
        System.out.println("Printing amount of hits from IP Objects...");
        for (IP ip : listOfIpObjects.getList()) {
            System.out.println("IP: " + ip.getIpAsString() + "\tHits: " + ip.getHitsFromThisIp());
        }
    }

    public void printContentOfExtractionList() {
        System.out.println("----------------------------------------");
        System.out.println("Size of extractionList: " + extractionList.size());
        System.out.println("Content of extractionList:");
        for (int k = 0; k < extractionList.size(); k++) {
            System.out.println("\t" + extractionList.get(k));
        }
        System.out.println("");
    }

    //Controller Class end
}
