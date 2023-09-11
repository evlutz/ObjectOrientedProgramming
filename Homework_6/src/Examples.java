import static org.junit.Assert.*;
import org.junit.Test;

public class Examples {
    // method to set up a ballot and cast votes

    VotingData setup1() {

        VotingData vd = new VotingData();

        // put candidates on the ballot
        try {

            vd.nominateCandidate("gompei");
            vd.nominateCandidate("husky");
            vd.nominateCandidate("ziggy");

        } catch (Exception e) {}

        // cast votes

        try {

            vd.submitVote("gompei", "husky", "ziggy");
            vd.submitVote("gompei", "ziggy", "husky");
            vd.submitVote("husky", "gompei", "ziggy");

        } catch (Exception e) {}

        return(vd);
    }
    //TEST for setup1()
    @Test
    public void testMostFirstWinnerSetup1 () {
        assertEquals("gompei", this.setup1().pickWinnerMostFirstChoice());
    }

    @Test
    public void testWinnerMostAgreeableSetup1(){
        assertEquals("gompei", this.setup1().pickWinnerMostAgreeable());
    }

    //Setup2()
    VotingData setup2() {

        VotingData vd = new VotingData();

        // put candidates on the ballot
        try {

            vd.nominateCandidate("evan");
            vd.nominateCandidate("ben");
            vd.nominateCandidate("sam");

        } catch (Exception e) {}

        // cast votes

        try {

            vd.submitVote("sam", "ben", "evan");
            vd.submitVote("sam", "ben", "evan");
            vd.submitVote("evan", "ben", "sam");

        } catch (Exception e) {}

        return(vd);
    }

    //Tests for setup2()
    @Test
    public void testMostFirstWinnerSetup2 () {

        assertEquals("sam", this.setup2().pickWinnerMostFirstChoice());
    }

    @Test
    public void testWinnerMostAgreeableSetup2(){
        assertEquals("ben", this.setup2().pickWinnerMostAgreeable());
    }


    //setup3()
    VotingData setup3() {

        VotingData vd = new VotingData();

        // put candidates on the ballot
        try {

            vd.nominateCandidate("john");
            vd.nominateCandidate("matt");
            vd.nominateCandidate("luke");

        } catch (Exception e) {}

        // cast votes

        try {

            vd.submitVote("john", "luke", "matt");
            vd.submitVote("matt", "john", "luke");
            vd.submitVote("luke", "matt", "john");

        } catch (Exception e) {}

        return(vd);
    }

    @Test
    public void testMostFirstWinnerSetup3 () {
        assertEquals("*Requires Runoff Poll*", this.setup3().pickWinnerMostFirstChoice());
    }

    @Test
    public void testWinnerMostAgreeableSetup3(){
        assertEquals("luke", this.setup3().pickWinnerMostAgreeable());
    }


    //setup4()
    VotingData setup4() {

        VotingData vd = new VotingData();

        // put candidates on the ballot
        try {

            vd.nominateCandidate("andy");
            vd.nominateCandidate("pat");
            vd.nominateCandidate("alex");
            vd.nominateCandidate("john");
            vd.nominateCandidate("james");
            vd.nominateCandidate("richards");

        } catch (Exception e) {}

        // cast votes

        try {

            vd.submitVote("andy", "pat", "alex");
            vd.submitVote("andy", "alex", "pat");
            vd.submitVote("james", "richards", "john");
            vd.submitVote("andy", "richards", "pat");
            vd.submitVote("andy", "richards", "james");
            vd.submitVote("pat", "richards", "john");
            vd.submitVote("alex", "richards", "james");


        } catch (Exception e) {}

        return(vd);
    }

    //Tests for setup4()
    @Test
    public void testMostFirstWinnerSetup4 () {
        assertEquals("andy", this.setup4().pickWinnerMostFirstChoice());
    }

    @Test
    public void testWinnerMostAgreeableSetup4(){
        assertEquals("richards", this.setup4().pickWinnerMostAgreeable());
    }



    //setup4()
    VotingData setup5() {

        VotingData vd = new VotingData();

        // put candidates on the ballot
        try {

            vd.nominateCandidate("andy");
            vd.nominateCandidate("pat");
            vd.nominateCandidate("alex");
            vd.nominateCandidate("john");
            vd.nominateCandidate("james");
            vd.nominateCandidate("richards");
            vd.nominateCandidate("kyle");

        } catch (Exception e) {}

        // cast votes

        try {

            vd.submitVote("kyle", "kyle", "kyle");
            vd.submitVote("andy", "alex", "pat");
            vd.submitVote("james", "richards", "john");
            vd.submitVote("andy", "richards", "pat");
            vd.submitVote("andy", "richards", "james");
            vd.submitVote("pat", "richards", "john");
            vd.submitVote("alex", "richards", "james");


        } catch (Exception e) {}



        return(vd);
    }

    //Test CandidateChosenMoreThanOnceException

    @Test(expected=CandidateChosenMoreThanOnceException.class)
    public void testCandidateChosenMoreThanOnceException() throws CandidateChosenMoreThanOnceException, CandidateNotFoundException, RedundantCandidateException {
        VotingData vd = new VotingData();

        vd.nominateCandidate("andy");
        vd.nominateCandidate("pat");
        vd.nominateCandidate("alex");
        vd.nominateCandidate("john");
        vd.nominateCandidate("james");
        vd.nominateCandidate("richards");
        vd.nominateCandidate("kyle");


        vd.submitVote("kyle", "kyle", "kyle");
    }


    @Test(expected=CandidateNotFoundException.class)
    public void testCandidateNotFoundException() throws CandidateChosenMoreThanOnceException, CandidateNotFoundException, RedundantCandidateException {
        VotingData vd = new VotingData();

        vd.nominateCandidate("andy");
        vd.nominateCandidate("pat");
        vd.nominateCandidate("alex");
        vd.nominateCandidate("john");
        vd.nominateCandidate("james");
        vd.nominateCandidate("richards");
        vd.nominateCandidate("kyle");


        vd.submitVote("jesus", "whippity", "ground");
    }


    @Test(expected=RedundantCandidateException.class)
    public void testRedundantCandidateException() throws CandidateChosenMoreThanOnceException, CandidateNotFoundException, RedundantCandidateException {
        VotingData vd = new VotingData();

        vd.nominateCandidate("kyle");
        vd.nominateCandidate("kyle");

    }



    public Examples() {
        // now run a test on a specific election

    }
}
