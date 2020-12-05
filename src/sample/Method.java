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

    public abstract String getListName();
}

class TypeGET extends Method{
        private String name = "GET";
        private int ID = 0;
        private AnyList<Entry> list = new AnyList<>("methodAsBubble_GET");

    public TypeGET() {
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
        this.addToList(entry);

    }

    @Override
    public void removeFromList(Entry entry) {
        this.removeFromList(entry);
    }

    @Override
    public String getListName() {
        return this.list.getName();
    }
}

class TypePOST extends Method{
    private String name = "POST";
    private int ID = 1;
    private AnyList<Entry> list = new AnyList<>("methodAsBubble_POST");

    public TypePOST(){
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
        list.addToList(entry);
    }

    @Override
    public void removeFromList(Entry entry) {
        list.removeFromList(entry);
    }

    @Override
    public String getListName() {
        return this.list.getName();
    }
}

class TypeCONNECTION extends Method{
    private String name = "CONNECTION";
    private int ID = 2;
    private AnyList<Entry> list = new AnyList<>("methodAsBubble_CONNECTION");

    public TypeCONNECTION(){
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
        list.addToList(entry);
    }

    @Override
    public void removeFromList(Entry entry) {
        list.removeFromList(entry);
    }

    @Override
    public String getListName() {
        return this.list.getName();
    }
}

class TypeHEAD extends Method{
    private String name = "HEAD";
    private int ID = 3;
    private AnyList<Entry> list = new AnyList<>("methodAsBubble_HEAD");

    public TypeHEAD(){
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
        list.addToList(entry);
    }

    @Override
    public void removeFromList(Entry entry) {
        list.removeFromList(entry);
    }

    @Override
    public String getListName() {
        return this.list.getName();
    }
}

class TypePROPFIND extends Method{
    private String name = "PROPFIND";
    private int ID = 4;
    private AnyList<Entry> list = new AnyList<>("methodAsBubble_PROPFIND");

    public TypePROPFIND(){
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
        list.addToList(entry);
    }

    @Override
    public void removeFromList(Entry entry) {
        list.removeFromList(entry);
    }

    @Override
    public String getListName() {
        return this.list.getName();
    }
}

class TypeASCII extends Method{
    private String name = "ASCII";
    private int ID = 5;
    private AnyList<Entry> list = new AnyList<>("methodAsBubble_ASCII");

    public TypeASCII(){
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
        list.addToList(entry);
    }

    @Override
    public void removeFromList(Entry entry) {
        list.removeFromList(entry);
    }

    @Override
    public String getListName() {
        return this.list.getName();
    }
}

class TypeOPTIONS extends Method{
    private String name = "OPTIONS";
    private int ID = 6;
    private AnyList<Entry> list = new AnyList<>("methodAsBubble_OPTIONS");

    public TypeOPTIONS(){
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
        list.addToList(entry);
    }

    @Override
    public void removeFromList(Entry entry) {
        list.removeFromList(entry);
    }

    @Override
    public String getListName() {
        return this.list.getName();
    }
}

class TypeEMPTY extends Method{
    private String name = "EMPTY";
    private int ID = 7;
    private AnyList<Entry> list = new AnyList<>("methodAsBubble_EMPTY");

    public TypeEMPTY(){
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
        list.addToList(entry);
    }

    @Override
    public void removeFromList(Entry entry) {
        list.removeFromList(entry);
    }

    @Override
    public String getListName() {
        return this.list.getName();
    }
    }