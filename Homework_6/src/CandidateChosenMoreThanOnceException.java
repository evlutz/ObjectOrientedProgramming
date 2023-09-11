public class CandidateChosenMoreThanOnceException extends Exception{

    String candidate;

    public CandidateChosenMoreThanOnceException(String candidate){
        this.candidate = candidate;
    }
}
