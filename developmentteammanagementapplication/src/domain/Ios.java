package domain;

public class Ios implements Equipment{

    private String model;

    public Ios() {
    }

    public Ios(String model) {
        this.model = model;
    }

    @Override
    public String getDescription() {
        return model;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

}
