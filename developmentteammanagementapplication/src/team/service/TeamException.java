package team.service;

//User Defined Exceptions
public class TeamException extends Exception{
    //I just copy the static variable from Exception lol
    //The purpose of creating TeamException is to see can the program can show the info(message) I want
    static final long serialVersionUID = -3387516993124229948L;

    public TeamException() {
    }

    public TeamException(String message) {
        super(message);
    }
}
