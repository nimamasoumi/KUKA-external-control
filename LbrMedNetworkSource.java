import java.net.Socket;

import javax.swing.JTextArea;

public class LbrMedNetworkSource
{
    private Socket tcpClient;
    private String IP = "";
    private int Port = 0;
    private boolean EnableExternalControl = true;
    private ExternalControlState externalController = new ExternalControlState();
    private JTextArea logger = null;
    
    public void setExternalControl(boolean _ed)
    {
        this.EnableExternalControl = _ed;
    }
    public boolean getExternalControl()
    {
        return this.EnableExternalControl;
    }
    public void setIP(String _IP)
    {
        this.IP = _IP;
    }
    public String getIP()
    {
        return this.IP;
    }
    public void setPort(int _port)
    {
        this.Port = _port;
    }
    public int getPort()
    {
        return this.Port;
    }
    public void setLogger(JTextArea _logger)
    {
        this.logger = _logger;
    }

    public boolean Connect(NetworkConfig _nc)
    {        
        // if(tcpClient.isConnected())
        // {
        //     this.logger.append("Already Connected!\n");
        //     return false;
        // }

        this.IP = _nc.Hostname;
        this.Port = _nc.Port;
        
        /* There are background communications with the robot
        before the actual socket initialization */
        if(this.EnableExternalControl && !InitilizeExternalControl(_nc))
        {
            this.logger.append("The external control enabling didn't go well");
            return false;
        }
        // return tcpClient.isConnected();
        return true;
    }

    private boolean InitilizeExternalControl(NetworkConfig _nc)
    {
        this.logger.append("Initializing the external control.\n");
        externalController.setLogger(logger);
        if(!externalController.BeginControl(_nc.Hostname))
        {
            this.logger.append("The external control enabling didn't go well");
            return false;
        }
        return true;
    }
}