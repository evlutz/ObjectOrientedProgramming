
import java.util.LinkedList;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map.Entry;

public class VotingData {

    private HashMap<String, Integer> firstPlace = new HashMap<String, Integer>();

    private HashMap<String, Integer> secondPlace = new HashMap<String, Integer>();

    private HashMap<String, Integer> thirdPlace = new HashMap<String, Integer>();

    private LinkedList<String> ballot = new LinkedList<String>();

    /*
    Ballot getter
    @Returns LinkedList<String> ballot
     */
    public LinkedList<String> getBallot(){
        return this.ballot;
    }

    private LinkedList<String> votes = new LinkedList<String>();

    public void addVote(String vote){
        votes.add(vote);
    }


    VotingData() {
        this.ballot.add("Gompei");
        this.ballot.add("Husky");
    }

    /*
    Adds a canidate to the ballot
    @Param string of canidates name
    @Return void
    @throws RedundantCandidateException if canidate is already on the ballot
     */
    public void nominateCandidate(String newCandidate) throws RedundantCandidateException {

            if (this.ballot.contains(newCandidate)) {
                throw new RedundantCandidateException(newCandidate);
            }
            else {
                this.ballot.add(newCandidate);
        }
    }

    /*
    Submits a vote for the voter
    @Param takes in 3 Strings of three candidate
    @throws CandidateChosenMoreThanOnceException if a voter votes for a
    candidate more than once
    @throws CandidateNotFoundException if the candidate is not on the ballot
     */
    public void submitVote(String choice1, String choice2, String choice3) throws CandidateChosenMoreThanOnceException, CandidateNotFoundException {

        LinkedList<String> filledBallot = new LinkedList<String>();

        filledBallot.add(choice1);
        filledBallot.add(choice2);
        filledBallot.add(choice3);


        //Trying to vote for same candidate?
        for (String current : ballot) {

            if (current.equals(choice1) || current.equals(choice2) || current.equals(choice3)) {

                //Check for multiple names
                if (current.equals(choice1) && current.equals(choice2)) {
                    throw new CandidateChosenMoreThanOnceException(current);
                } else if (current.equals(choice2) && current.equals(choice3)) {
                    throw new CandidateChosenMoreThanOnceException(current);
                } else if (current.equals(choice1) && current.equals(choice3)) {
                    throw new CandidateChosenMoreThanOnceException(current);
                }
            }
        }

        //Voter exists?
        if (!(ballot.contains(choice1))) {
            throw new CandidateNotFoundException(choice1);
        } else if (!(ballot.contains(choice2))) {
            throw new CandidateNotFoundException(choice2);
        } else if (!(ballot.contains(choice3))) {
            throw new CandidateNotFoundException(choice3);
        }

        //If candidate DOES NOT exist in (x)Place creat new candidate && set votes = 1
        if(!firstPlace.containsKey(choice1)){
            firstPlace.put(choice1, 1);
        }
        //if Candidate does exist add 1 vote onto their existing
        else{
            firstPlace.put(choice1, firstPlace.get(choice1) + 1);
        }

        if(!secondPlace.containsKey(choice2)){
            secondPlace.put(choice2, 1);
        }
        else{
            secondPlace.put(choice2, secondPlace.get(choice2) + 1);
        }

        if(!thirdPlace.containsKey(choice3)){
            thirdPlace.put(choice3, 1);
        }
        else{
            thirdPlace.put(choice3, thirdPlace.get(choice3) + 1);
        }

    }


    /*
        Determines the winning candidate with more than 50% first place votes
        @Returns winning candidate or if no candidate has won returns "*Requires Runoff Poll*"
     */
    public String pickWinnerMostFirstChoice() {
        int totalVotes = 0;
        int winning = 0;
        String winningCandidate = "";

        for (Entry<String, Integer> vote : firstPlace.entrySet()) {
            totalVotes = totalVotes + vote.getValue();
            if (vote.getValue() > winning) {
                winning = vote.getValue();
                winningCandidate = vote.getKey();
            }
        }

        if ((float)winning / (float)totalVotes > .5) {
            return (winningCandidate);
        } else {
            return "*Requires Runoff Poll*";
        }
    }

    /*
    Determines the candidate with the most votes in either firstChoice secondChoice or thirdChoice
    @Return String of winning candidate
     */
    public String pickWinnerMostAgreeable(){
        int winning = 0;
        String winningCandidate = "";

        for (Entry<String, Integer> vote : firstPlace.entrySet()) {
            if (vote.getValue() > winning) {
                winning = vote.getValue();
                winningCandidate = vote.getKey();
            }
        }
        for (Entry<String, Integer> vote : secondPlace.entrySet()) {
            if (vote.getValue() > winning) {
                winning = vote.getValue();
                winningCandidate = vote.getKey();
            }
        }
        for (Entry<String, Integer> vote : thirdPlace.entrySet()) {
            if (vote.getValue() > winning) {
                winning = vote.getValue();
                winningCandidate = vote.getKey();
            }
        }
        return(winningCandidate);
    }
}

