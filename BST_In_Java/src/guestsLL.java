import java.util.LinkedList;

public class guestsLL implements ISet{

    LinkedList<ISet> guests = new LinkedList<ISet>();
    public guestsLL(){

    }
    public void addElt(ISet guest){
        guests.add(guest);
    }


    public boolean hasElt(ISet guest) {
        for(ISet guestCurrent : guests){
            if(guestCurrent == guest) {
                return true;
            }
        }
        return false;
    }


    public int size(){
        return this.guests.size();
    }
}
