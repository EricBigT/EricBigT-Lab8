import java.util.HashSet;

public class Station {
    protected String color;
    protected String name;
    protected boolean inService;
    protected Station next;
    protected Station prevStation;

    public Station(String color, String name) {
        this.color = color;
        this.name = name;
        this.inService = true;
        this.next = null;
        this.prevStation = null;
    }

    public String getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    public Station getNext() {
        return next;
    }

    public Station getPrev() {
        return prevStation;
    }

    public boolean isAvailable() {
        return inService;
    }

    public void switchAvailable() {
        inService = !inService;
    }

    public void addNext(Station s) {
        this.next = s;
        if (s != null){
            s.prevStation = this;
        }
    }

    public void addPrev(Station s) {
        this.prevStation = s;
        if (s != null){
            s.next = this;
        }
    }

    public void connect(Station s) {
        this.next = s;

        if(s.prevStation == null){
            s.prevStation = this;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) { 
            return true;
        }
        if (!(o instanceof Station)){
            return false;
        }
        Station s = (Station) o;
        return this.color.equals(s.color) && this.name.equals(s.name);
    }

    @Override
    public String toString() {
        String prevName = (prevStation == null) ? "none" : prevStation.getName();
        String nextName = (next == null) ? "none" : next.getName();
        return "STATION " + name + ": " + color + " line, in service: " + inService
                + ", previous station: " + prevName
                + ", next station: " + nextName;
    }

    // recursive method
    public int tripLength(Station dest) {
    return tripLengthHelper(dest, new HashSet<>());
}

// recurive method helper
private int tripLengthHelper(Station dest, HashSet<Station> visited) {
    if (this.equals(dest)){ //check if this equals the destination station
        return 0;
    }

    if (visited.contains(this)){ //sanity check
        return -1;
    }
    visited.add(this); //add the visited station to the hashset

    int min = Integer.MAX_VALUE; // set a minimum number 

    if (next != null) {
        int d = next.tripLengthHelper(dest, visited); //recursive call 
        if (d >= 0){
            min = Math.min(min, d + 1); //record the shortest new distance
        }
    }

    if (this instanceof TransferStation) { //if this is a transferstation must explore every branch from that station
        for (Station s : ((TransferStation) this).otherStations) {
            int d = s.tripLengthHelper(dest, visited);
            if (d >= 0){
                min = Math.min(min, d + 1); //record the new shortest distance
            }
        }
    }

    return (min == Integer.MAX_VALUE) ? -1 : min; //return the shortest distance
}

}

