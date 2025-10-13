public class EndStation extends Station {

    public EndStation(String color, String name) {
        super(color, name);
    }

    public void makeEnd() {
        // if one end is null, make both point to the non-null one
        if (next != null && prevStation == null) {
            prevStation = next;
        } else if (prevStation != null && next == null) {
            next = prevStation;
        }
    }

    @Override
    public String toString() {
        String prevName = (prevStation == null) ? "none" : prevStation.getName();
        String nextName = (next == null) ? "none" : next.getName();
        return "ENDSTATION " + name + ": " + color + " line, in service: " + inService
                + ", previous station: " + prevName
                + ", next station: " + nextName;
    }
}
