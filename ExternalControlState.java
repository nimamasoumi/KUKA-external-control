public class ExternalControlState {
    public ExternalControlState(){}
    private ExternalControl controller = new ExternalControl();

    public boolean BeginControl(String _hostname)
    {
        return true;
    }
}
