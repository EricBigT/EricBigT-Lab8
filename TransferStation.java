import java.util.ArrayList;

public class TransferStation extends Station{
    protected ArrayList<Station> otherStations;
    
    public TransferStation(String s, String c){
        super(s, c);
        otherStations = new ArrayList<Station>();
    }

    public void addTransferStationPrev(Station s){
        otherStations.add(s);
        s.addNext(this);
    }

    public void addTransferStationNext(Station s){
        otherStations.add(s);
        s.addPrev(this);
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

        String output =  "TRANSFERSTATION "+ getName() + ": " + getColor() + "line, in service: " + isAvailable() + ", previous station: " + prevName + 
                ", next station: " + nextName + "\n\tTransfers: \n\t";

                for (Station Transfer : otherStations){
                    output += "\t" + Transfer.toString() + "\n";
                }

                return output;
                // "TRANSFERSTATION Museum: pink line, in service: true, previous station: none, next station: none\n\tTransfers: \n" + 
                //           "\tSTATION Square: blue line, in service: true, previous station: none, next station: Museum\n" + 
                //           "\tENDSTATION Plaza: green line, in service: true, previous station: Museum, next station: none\n";
    }
}
