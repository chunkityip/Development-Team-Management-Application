package domain;

public class Window implements Equipment {

    private String model;

    public Window() {
    }

    public Window(String model) {
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
