import javax.swing.JTextArea;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ExternalControlState {
    public ExternalControlState(){}
    private ExternalControl controller = new ExternalControl();
    private boolean active = false;
    private JTextArea logger = null;
    private final Lock latestStateLock = new ReentrantLock();
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

        // Check if the robot is responding
        if(!RefreshState())
        {
            logger.append("[ExternalControlState] Robot application not responding!");
            controller.Close();
            return false;
        }
        
        return true;
    }

    private boolean RefreshState()
    {
        latestStateLock.lock();
        try
        {
            // method body to be completed 
        }
        finally
        {
            latestStateLock.unlock();

        }
        return true;
    }
}
