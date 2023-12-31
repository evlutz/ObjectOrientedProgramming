// A class for storing guests at a (potentially large) event
//ewlutz
//Evan Lutz
class EventGuests {

    ISet guests;



    EventGuests(ISet guests) {

        this.guests = guests;

    }



    // record a new guest as coming (add the guest to the set)

    void addGuest(ISet newGuestName) {

        this.guests.addElt(newGuestName);

    }



    // check whether a guest is coming (use hasElt() to see if
    // the guest is in the set)

    boolean isComing(ISet name) {

        return this.guests.hasElt(name);

    }

    // return the number of guests in the guest list 
    int numGuests(){

        return this.guests.size();

    }

}