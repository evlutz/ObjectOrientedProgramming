public class RedundantCandidateException extends Exception{

    private String candidate;

    /*
    Throws an exception if someone tries to add the
    same person twice to the ballot
     */
    public RedundantCandidateException(String candidate){
        this.candidate = candidate;
    }

}
