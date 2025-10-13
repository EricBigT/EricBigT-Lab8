import java.util.ArrayList;

public class TransferStation extends Station {
    protected ArrayList<Station> otherStations;

    public TransferStation(String color, String name) {
        super(color, name);
        otherStations = new ArrayList<>();
    }

    // add a transfer that is BEFORE this transfer on that other line
    // i.e., other station's next should point to this
    public void addTransferStationPrev(Station s) {
        if (s == null) return;
        otherStations.add(s);
        s.next = this; // other station is before this transfer
    }

    // add a transfer that is AFTER this transfer on that other line
    // i.e., other station's prev should point to this
    public void addTransferStationNext(Station s) {
        if (s == null) return;
        otherStations.add(s);
        s.prevStation = this; // other station is after this transfer
    }

    @Override
    public String toString() {
        String prevName = (prevStation == null) ? "none" : prevStation.getName();
        String nextName = (next == null) ? "none" : next.getName();

        String result = "TRANSFERSTATION " + name +
            ": " + color + " line, in service: " + inService +
            ", previous station: " + prevName +
            ", next station: " + nextName +
            "\n\tTransfers: \n";

    for (Station s : otherStations) { //account for all connecting lines
        result += "\t" + s.toString() + "\n";
    }

    return result;
    }
}

