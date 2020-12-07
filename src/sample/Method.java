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

    public abstract AnyList<Entry> getList();

    public abstract String getListName();
}

class TypeGET extends Method{
        private String name;
        private int ID;
        private AnyList<Entry> list;

    public TypeGET() {
        this.name = "GET";
        this.ID = 0;
        this.list = new AnyList<>("listOfEntryObjects@_GET");
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
        this.list.addToList(entry);
    }

    @Override
    public void removeFromList(Entry entry) {
        this.removeFromList(entry);
    }

    @Override
    public AnyList<Entry> getList() {
        return this.list;
    }


    @Override
    public String getListName() {
        return this.list.getName();
    }
}

class TypePOST extends Method{
    private String name;
    private int ID;
    private AnyList<Entry> list;

    public TypePOST(){
        this.name = "POST";
        this.ID = 1;
        this.list = new AnyList<>("listOfEntryObjects@_POST");
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
        this.list.addToList(entry);
    }

    @Override
    public void removeFromList(Entry entry) {
        list.removeFromList(entry);
    }

    @Override
    public AnyList<Entry> getList() {
        return this.list;
    }

    @Override
    public String getListName() {
        return this.list.getName();
    }
}

class TypeCONNECT extends Method{
    private String name;
    private int ID;
    private AnyList<Entry> list;

    public TypeCONNECT() {
        this.name = "CONNECT";
        this.ID = 2;
        this.list = new AnyList<>("listOfEntryObjects@_CONNECT");
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
        this.list.addToList(entry);
    }

    @Override
    public void removeFromList(Entry entry) {
        list.removeFromList(entry);
    }

    @Override
    public AnyList<Entry> getList() {
        return this.list;
    }

    @Override
    public String getListName() {
        return this.list.getName();
    }
}

class TypeHEAD extends Method{
    private String name;
    private int ID;
    private AnyList<Entry> list;

    public TypeHEAD(){
        this.name = "HEAD";
        this.ID = 3;
        this.list = new AnyList<>("listOfEntryObjects@_HEAD");
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
        this.list.addToList(entry);
    }

    @Override
    public void removeFromList(Entry entry) {
        list.removeFromList(entry);
    }

    @Override
    public AnyList<Entry> getList() {
        return this.list;
    }

    @Override
    public String getListName() {
        return this.list.getName();
    }
}

class TypePROPFIND extends Method{
    private String name;
    private int ID;
    private AnyList<Entry> list;

    public TypePROPFIND(){
        this.name = "PROPFIND";
        this.ID = 4;
        this.list = new AnyList<>("listOfEntryObjects@_PROPFIND");
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
        this.list.addToList(entry);
    }

    @Override
    public void removeFromList(Entry entry) {
        list.removeFromList(entry);
    }

    @Override
    public AnyList<Entry> getList() {
        return this.list;
    }

    @Override
    public String getListName() {
        return this.list.getName();
    }
}

class TypeASCII extends Method{
    private String name;
    private int ID;
    private AnyList<Entry> list;

    public TypeASCII(){
        this.name = "ASCII";
        this.ID = 5;
        this.list = new AnyList<>("listOfEntryObjects@_ASCII");
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
        this.list.addToList(entry);
    }

    @Override
    public void removeFromList(Entry entry) {
        list.removeFromList(entry);
    }

    @Override
    public AnyList<Entry> getList() {
        return this.list;
    }

    @Override
    public String getListName() {
        return this.list.getName();
    }
}

class TypeOPTIONS extends Method{
    private String name ;
    private int ID;
    private AnyList<Entry> list;

    public TypeOPTIONS(){
        this.name = "OPTIONS";
        this.ID = 6;
        this.list = new AnyList<>("listOfEntryObjects@_OPTIONS");
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
        this.list.addToList(entry);
    }

    @Override
    public void removeFromList(Entry entry) {
        list.removeFromList(entry);
    }

    @Override
    public AnyList<Entry> getList() {
        return this.list;
    }

    @Override
    public String getListName() {
        return this.list.getName();
    }
}

class TypeEMPTY extends Method{
    private String name;
    private int ID;
    private AnyList<Entry> list;

    public TypeEMPTY(){
        this.name = "EMPTY";
        this.ID = 7;
        this.list = new AnyList<>("listOfEntryObjects@_EMPTY");
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
        this.list.addToList(entry);
    }

    @Override
    public void removeFromList(Entry entry) {
        list.removeFromList(entry);
    }

    @Override
    public AnyList<Entry> getList() {
        return this.list;
    }

    @Override
    public String getListName() {
        return this.list.getName();
    }
    }