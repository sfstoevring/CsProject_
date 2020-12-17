package sample;

public abstract class Method {

    public Method() {
    }

    public abstract String getName();

    public abstract void setName(String name);

    public abstract int getID();

    public abstract void setID(int ID);

    public abstract void addToList(Entry entry);

    public abstract void removeFromList(Entry entry);

    public abstract AnyList<Entry> getListOfEntries();

    public abstract String getListName();

    public abstract AnyList<Request> getRequestArrayList();

    public abstract Request getRequestFromRequestArrayList(int index);

    public abstract void addRequestToRequestArrayList(Request request);

    public abstract void addEntryToRequestInRequestArrayList(Entry e, int listIndex);


}

class TypeGET extends Method{
        private String name;
        private int ID;
        private AnyList<Entry> listOfEntries;
        private AnyList<Request> requestArrayList;

    public TypeGET() {
        this.name = "GET";
        this.ID = 0;
        this.listOfEntries = new AnyList<>("listOfEntryObjects@_GET");
        this.requestArrayList = new AnyList<>("listOfRequests@_GET");
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getID() {
        return this.ID;
    }

    @Override
    public void setID(int ID) {
        this.ID = ID;
    }

    @Override
    public void addToList(Entry entry) {
        this.listOfEntries.addToList(entry);
    }

    @Override
    public void removeFromList(Entry entry) {
        this.removeFromList(entry);
    }

    @Override
    public AnyList<Entry> getListOfEntries() {
        return this.listOfEntries;
    }


    @Override
    public String getListName() {
        return this.listOfEntries.getName();
    }

    @Override
    public AnyList<Request> getRequestArrayList() {
        return this.requestArrayList;
    }

    @Override
    public Request getRequestFromRequestArrayList(int index) {
        return this.requestArrayList.getList().get(index);
    }

    @Override
    public void addRequestToRequestArrayList(Request request) {
        this.requestArrayList.addToList(request);
    }

    @Override
    public void addEntryToRequestInRequestArrayList(Entry e, int listIndex) {
        this.requestArrayList.getList().get(listIndex).addToListBasedOnFirstPartOfReqForAnObject(e);

    }
}

class TypePOST extends Method {
    private String name;
    private int ID;
    private AnyList<Entry> listOfEntries;
    private AnyList<Request> requestArrayList;

    public TypePOST() {
        this.name = "POST";
        this.ID = 1;
        this.listOfEntries = new AnyList<>("listOfEntryObjects@_POST");
        this.requestArrayList = new AnyList<>("listOfRequests@_POST");
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getID() {
        return this.ID;
    }

    @Override
    public void setID(int ID) {
        this.ID = ID;
    }

    @Override
    public void addToList(Entry entry) {
        this.listOfEntries.addToList(entry);
    }

    @Override
    public void removeFromList(Entry entry) {
        this.removeFromList(entry);
    }

    @Override
    public AnyList<Entry> getListOfEntries() {
        return this.listOfEntries;
    }


    @Override
    public String getListName() {
        return this.listOfEntries.getName();
    }

    @Override
    public AnyList<Request> getRequestArrayList() {
        return this.requestArrayList;
    }

    @Override
    public Request getRequestFromRequestArrayList(int index) {
        return this.requestArrayList.getList().get(index);
    }

    @Override
    public void addRequestToRequestArrayList(Request request) {
        this.requestArrayList.addToList(request);
    }

    @Override
    public void addEntryToRequestInRequestArrayList(Entry e, int listIndex) {
        this.requestArrayList.getList().get(listIndex).addToListBasedOnFirstPartOfReqForAnObject(e);

    }
}

class TypeCONNECT extends Method{
    private String name;
    private int ID;
    private AnyList<Entry> listOfEntries;
    private AnyList<Request> requestArrayList;

    public TypeCONNECT() {
        this.name = "CONNECT";
        this.ID = 2;
        this.listOfEntries = new AnyList<>("listOfEntryObjects@_CONNECT");
        this.requestArrayList = new AnyList<>("listOfRequests@_CONNECT");
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getID() {
        return this.ID;
    }

    @Override
    public void setID(int ID) {
        this.ID = ID;
    }

    @Override
    public void addToList(Entry entry) {
        this.listOfEntries.addToList(entry);
    }

    @Override
    public void removeFromList(Entry entry) {
        this.removeFromList(entry);
    }

    @Override
    public AnyList<Entry> getListOfEntries() {
        return this.listOfEntries;
    }


    @Override
    public String getListName() {
        return this.listOfEntries.getName();
    }

    @Override
    public AnyList<Request> getRequestArrayList() {
        return this.requestArrayList;
    }

    @Override
    public Request getRequestFromRequestArrayList(int index) {
        return this.requestArrayList.getList().get(index);
    }

    @Override
    public void addRequestToRequestArrayList(Request request) {
        this.requestArrayList.addToList(request);
    }

    @Override
    public void addEntryToRequestInRequestArrayList(Entry e, int listIndex) {
        this.requestArrayList.getList().get(listIndex).addToListBasedOnFirstPartOfReqForAnObject(e);

    }
}

class TypeHEAD extends Method{
    private String name;
    private int ID;
    private AnyList<Entry> listOfEntries;
    private AnyList<Request> requestArrayList;

    public TypeHEAD() {
        this.name = "HEAD";
        this.ID = 3;
        this.listOfEntries = new AnyList<>("listOfEntryObjects@_HEAD");
        this.requestArrayList = new AnyList<>("listOfRequests@_HEAD");
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getID() {
        return this.ID;
    }

    @Override
    public void setID(int ID) {
        this.ID = ID;
    }

    @Override
    public void addToList(Entry entry) {
        this.listOfEntries.addToList(entry);
    }

    @Override
    public void removeFromList(Entry entry) {
        this.removeFromList(entry);
    }

    @Override
    public AnyList<Entry> getListOfEntries() {
        return this.listOfEntries;
    }


    @Override
    public String getListName() {
        return this.listOfEntries.getName();
    }

    @Override
    public AnyList<Request> getRequestArrayList() {
        return this.requestArrayList;
    }

    @Override
    public Request getRequestFromRequestArrayList(int index) {
        return this.requestArrayList.getList().get(index);
    }

    @Override
    public void addRequestToRequestArrayList(Request request) {
        this.requestArrayList.addToList(request);
    }

    @Override
    public void addEntryToRequestInRequestArrayList(Entry e, int listIndex) {
        this.requestArrayList.getList().get(listIndex).addToListBasedOnFirstPartOfReqForAnObject(e);

    }
}

class TypePROPFIND extends Method{
    private String name;
    private int ID;
    private AnyList<Entry> listOfEntries;
    private AnyList<Request> requestArrayList;

    public TypePROPFIND() {
        this.name = "PROPFIND";
        this.ID = 4;
        this.listOfEntries = new AnyList<>("listOfEntryObjects@_PROPFIND");
        this.requestArrayList = new AnyList<>("listOfRequests@_PROPFIND");
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getID() {
        return this.ID;
    }

    @Override
    public void setID(int ID) {
        this.ID = ID;
    }

    @Override
    public void addToList(Entry entry) {
        this.listOfEntries.addToList(entry);
    }

    @Override
    public void removeFromList(Entry entry) {
        this.removeFromList(entry);
    }

    @Override
    public AnyList<Entry> getListOfEntries() {
        return this.listOfEntries;
    }


    @Override
    public String getListName() {
        return this.listOfEntries.getName();
    }

    @Override
    public AnyList<Request> getRequestArrayList() {
        return this.requestArrayList;
    }

    @Override
    public Request getRequestFromRequestArrayList(int index) {
        return this.requestArrayList.getList().get(index);
    }

    @Override
    public void addRequestToRequestArrayList(Request request) {
        this.requestArrayList.addToList(request);
    }

    @Override
    public void addEntryToRequestInRequestArrayList(Entry e, int listIndex) {
        this.requestArrayList.getList().get(listIndex).addToListBasedOnFirstPartOfReqForAnObject(e);

    }
}

class TypeASCII extends Method{
    private String name;
    private int ID;
    private AnyList<Entry> listOfEntries;
    private AnyList<Request> requestArrayList;

    public TypeASCII() {
        this.name = "ASCII";
        this.ID = 5;
        this.listOfEntries = new AnyList<>("listOfEntryObjects@_ASCII");
        this.requestArrayList = new AnyList<>("listOfRequests@_ASCII");
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getID() {
        return this.ID;
    }

    @Override
    public void setID(int ID) {
        this.ID = ID;
    }

    @Override
    public void addToList(Entry entry) {
        this.listOfEntries.addToList(entry);
    }

    @Override
    public void removeFromList(Entry entry) {
        this.removeFromList(entry);
    }

    @Override
    public AnyList<Entry> getListOfEntries() {
        return this.listOfEntries;
    }


    @Override
    public String getListName() {
        return this.listOfEntries.getName();
    }

    @Override
    public AnyList<Request> getRequestArrayList() {
        return this.requestArrayList;
    }

    @Override
    public Request getRequestFromRequestArrayList(int index) {
        return this.requestArrayList.getList().get(index);
    }

    @Override
    public void addRequestToRequestArrayList(Request request) {
        this.requestArrayList.addToList(request);
    }

    @Override
    public void addEntryToRequestInRequestArrayList(Entry e, int listIndex) {
        this.requestArrayList.getList().get(listIndex).addToListBasedOnFirstPartOfReqForAnObject(e);

    }
}

class TypeOPTIONS extends Method{
    private String name;
    private int ID;
    private AnyList<Entry> listOfEntries;
    private AnyList<Request> requestArrayList;

    public TypeOPTIONS() {
        this.name = "OPTIONS";
        this.ID = 6;
        this.listOfEntries = new AnyList<>("listOfEntryObjects@_OPTIONS");
        this.requestArrayList = new AnyList<>("listOfRequests@_OPTIONS");
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getID() {
        return this.ID;
    }

    @Override
    public void setID(int ID) {
        this.ID = ID;
    }

    @Override
    public void addToList(Entry entry) {
        this.listOfEntries.addToList(entry);
    }

    @Override
    public void removeFromList(Entry entry) {
        this.removeFromList(entry);
    }

    @Override
    public AnyList<Entry> getListOfEntries() {
        return this.listOfEntries;
    }


    @Override
    public String getListName() {
        return this.listOfEntries.getName();
    }

    @Override
    public AnyList<Request> getRequestArrayList() {
        return this.requestArrayList;
    }

    @Override
    public Request getRequestFromRequestArrayList(int index) {
        return this.requestArrayList.getList().get(index);
    }

    @Override
    public void addRequestToRequestArrayList(Request request) {
        this.requestArrayList.addToList(request);
    }

    @Override
    public void addEntryToRequestInRequestArrayList(Entry e, int listIndex) {
        this.requestArrayList.getList().get(listIndex).addToListBasedOnFirstPartOfReqForAnObject(e);

    }
}

class TypeEMPTY extends Method{
    private String name;
    private int ID;
    private AnyList<Entry> listOfEntries;
    private AnyList<Request> requestArrayList;

    public TypeEMPTY() {
        this.name = "EMPTY";
        this.ID = 7;
        this.listOfEntries = new AnyList<>("listOfEntryObjects@_EMPTY");
        this.requestArrayList = new AnyList<>("listOfRequests@_EMPTY");
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getID() {
        return this.ID;
    }

    @Override
    public void setID(int ID) {
        this.ID = ID;
    }

    @Override
    public void addToList(Entry entry) {
        this.listOfEntries.addToList(entry);
    }

    @Override
    public void removeFromList(Entry entry) {
        this.removeFromList(entry);
    }

    @Override
    public AnyList<Entry> getListOfEntries() {
        return this.listOfEntries;
    }


    @Override
    public String getListName() {
        return this.listOfEntries.getName();
    }

    @Override
    public AnyList<Request> getRequestArrayList() {
        return this.requestArrayList;
    }

    @Override
    public Request getRequestFromRequestArrayList(int index) {
        return this.requestArrayList.getList().get(index);
    }

    @Override
    public void addRequestToRequestArrayList(Request request) {
        this.requestArrayList.addToList(request);
    }

    @Override
    public void addEntryToRequestInRequestArrayList(Entry e, int listIndex) {
        this.requestArrayList.getList().get(listIndex).addToListBasedOnFirstPartOfReqForAnObject(e);

    }
}
