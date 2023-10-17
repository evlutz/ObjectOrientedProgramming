import java.util.LinkedList;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map.Entry;

/*
Class for a PollingDevice
Handles, input/output, screen, and printing the ballot
 */
public class PollingDevice {

    private Scanner keyboard = new Scanner(System.in);
    VotingData vd;

    public PollingDevice(VotingData vd) {
        this.vd = vd;
    }

    public void printBallot() {
        System.out.println("The candidates are ");
        for (String s : this.vd.getBallot()) {
            System.out.println(s);
        }
    }

    public void screen() {
        this.printBallot();
        System.out.println("Who do you want to vote for?");
        String candidate = keyboard.next();
        this.vd.addVote(candidate);
        System.out.println("You voted for " + candidate);
    }

    /*
    Submits a vote for the voter calls to @submitVoter in @VotingData
    @Param takes in 3 Strings of three candidate
    @throws CandidateChosenMoreThanOnceException if a voter votes for a
    candidate more than once, restarts vote
    @throws CandidateNotFoundException if the candidate is not on the ballot
    asks if the user would like to add candidate to the ballot
     */
    public void submitVote(String choice1, String choice2, String choice3) throws CandidateNotFoundException, CandidateChosenMoreThanOnceException, RedundantCandidateException {
        try{this.vd.submitVote(choice1, choice2, choice3);}
        catch(CandidateNotFoundException e) {
            System.out.print("This candidate was not found on the ballot \n Would you like to add this candidate (press 'Y' if yes) \n" );
            String response = keyboard.next();

            if(response.equals("Y") || response.equals("y")){
                addWriteIn(e.candidateGet()); //CHECK #####################
                screen();
            }

        }
        catch(CandidateChosenMoreThanOnceException e) {
            System.out.print("This Candidate is already on the ballot" );
            screen();
        }



    }

    /*
    Called if @Exception CandidateNotFoundException is caught
    Adds member to the ballot and restarts voting process
    @Param String candidates name
     */
    public void addWriteIn(String newCand) throws RedundantCandidateException{
        this.vd.nominateCandidate(newCand);
        System.out.print("Your candidate was successfully added to the ballot!" );
    }
}