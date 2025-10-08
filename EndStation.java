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
        return "ENDSTATION "+ getName() + ": " + getColor() + ", in service: " + isAvailable() + ", previous station: " + prevStation + 
                ", next station: " + next;
        // "ENDSTATION Museum: pink line, in service: true, previous station: Square, next station: Square"
    }
}
