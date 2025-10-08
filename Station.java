public class Station{
    private String name;
    private String color;
    private boolean inService;
    protected Station next;
    protected Station prevStation;

    public Station(String n, String c){
        this.name = c;
        this.color = n;
        inService = true;
        next = null;
        prevStation = null;

    }

    public String getName(){
        return name;
    }

    public String getColor(){
        return color;
    }

    public void addNext(Station s){
        this.next = s;
    }

    public void addPrev(Station s){
        prevStation = s;
    }

    public boolean isAvailable(){
        return inService;
    }

    public void switchAvailable(){
        if (!inService){
            inService = true;
        }
        else{
            inService = false;
        }
    }

    public void connect(Station s){
        this.addNext(s);
        s.addPrev(this);
    }

    public boolean equals(Station s){
        if (this.name.equals(s.getName()) && this.color.equals(s.getColor())){
            return true;
        }
        return false;
    }

    public int recursiveHelper(Station current, Station dest, int count){
        if (current == null){
            return -1;
        }

        if (current.equals(dest)){
            return count;
        }

        return recursiveHelper(current.next, dest, count + 1);
    }

    public int tripLength(Station dest){
        return 0;//recursiveHelper(this, dest, 0);
    }

    public String toString(){
        String prevName = prevStation.getName();
        String nextName = next.getName();

        if (prevStation == null){
            prevName = "none";
        }
        if (next == null){
            nextName = "none";
        }


        return "STATION "+ getName() + ": " + getColor() + " line, in service: " + isAvailable() + ", previous station: " + prevName + 
                ", next station: " + nextName;
        // "STATION Museum: pink line, in service: true, previous station: none, next station: Square";
    }
}
