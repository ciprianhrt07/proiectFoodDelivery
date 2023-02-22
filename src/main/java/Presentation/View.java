package Presentation;

public class View {

    private FirstWindow firstWindow;
    private SecondWindow secondWindow;
    private ThirdWindow thirdWindow;
    private Decission decission;

    public View()
    {
        firstWindow = new FirstWindow();
        secondWindow = new SecondWindow();
        thirdWindow = new ThirdWindow();
        decission  = new Decission();
        decission.getFrmFereastraprincipala().setVisible(true);

    }

    public FirstWindow getFirstWindow() {
        return firstWindow;
    }

    public void setFirstWindow(FirstWindow firstWindow) {
        this.firstWindow = firstWindow;
    }

    public SecondWindow getSecondWindow() {
        return secondWindow;
    }

    public void setSecondWindow(SecondWindow secondWindow) {
        this.secondWindow = secondWindow;
    }

    public ThirdWindow getThirdWindow() {
        return thirdWindow;
    }

    public void setThirdWindow(ThirdWindow thirdWindow) {
        this.thirdWindow = thirdWindow;
    }

    public Decission getDecission() {
        return decission;
    }

    public void setDecission(Decission decission) {
        this.decission = decission;
    }
}
