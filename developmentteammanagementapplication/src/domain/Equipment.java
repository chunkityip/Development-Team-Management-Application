package domain;

//The reason I used interface is because Equipment is [capable] to many things such as Window ,IOS
public interface Equipment {

    //Before Java 7.0 , it needs to define public static final
    //After 8.0, it already default it.
    String getDescription();

}
