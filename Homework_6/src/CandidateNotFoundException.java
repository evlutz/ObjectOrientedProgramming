public class CandidateNotFoundException extends Exception{

    private String candidate;

    public CandidateNotFoundException(String candidate){
        this.candidate = candidate;
    }

    public String candidateGet(){
        return this.candidate;
    }
}
