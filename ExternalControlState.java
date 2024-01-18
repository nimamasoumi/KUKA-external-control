import javax.swing.JTextArea;

public class ExternalControlState {
    public ExternalControlState(){}
    private ExternalControl controller = new ExternalControl();
    private boolean active = false;
    private JTextArea logger = null;
    public boolean isActive()
    {
        return this.active;
    }
    public void setLogger(JTextArea _logger)
    {
        this.logger = _logger;
    }

    public boolean BeginControl(String _hostname)
    {        
        if (_hostname=="")
        {
            this.logger.append("[ExternalControlState] Hostname cannot be empty!\n");
            return false;
        }
        controller.setLogger(logger);
        controller.Open(_hostname);
        
        return true;
    }
}
