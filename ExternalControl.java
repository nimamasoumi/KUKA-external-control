import java.net.DatagramSocket;
import java.net.SocketException;

import javax.swing.JTextArea;

public class ExternalControl
{    
    public ExternalControl(){}
    private DatagramSocket socket = null;
    private JTextArea logger = null;

    public void setLogger(JTextArea _logger)
    {
        this.logger = _logger;
    }
    public void Open(String _robotIP)
    {
        Close();
        try{
            socket = new DatagramSocket();
        }
        catch(SocketException e)
        {
            this.logger.append("[ExternalControl] Problem opening a UDP socket.\n");
            return;
        }
        
    }
    public void Close()
    {

    }
}