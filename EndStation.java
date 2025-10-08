public class EndStation extends Station{

    public EndStation(String s, String c){
        super(s, c);
    }

    public void makeEnd(){
        if (next != null){
            prevStation = next;
        }
        if (prevStation != null){
            next = prevStation;
        }
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

        return "ENDSTATION "+ getName() + ": " + getColor() + " line, in service: " + isAvailable() + ", previous station: " + prevName + 
                ", next station: " + nextName;
        // "ENDSTATION Museum: pink line, in service: true, previous station: Square, next station: Square"
    }
}
