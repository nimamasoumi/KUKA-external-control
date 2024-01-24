import java.net.DatagramSocket;
import java.net.InetAddress;
import javax.swing.JTextArea;

public class ExternalControl
{    
    public ExternalControl(){}
    private DatagramSocket socket = null;
    private JTextArea logger = null;
    private InetAddress ip = null;
    
    /*  
    Local port to open and communicate with the robot. This should be the same port number 
    as set in the status receivers setting in the robot project properties under ExternalControl
    */
    private final int LOCAL_PORT = 30333;
    private final int ROBOT_EXT_CTRL_PORT = 30300;
    private final int SOCKET_TIMEOUT = 50;
    private long clientCounter = 0;

    public void setLogger(JTextArea _logger)
    {
        this.logger = _logger;
    }
    public void Open(String _robotIP)
    {
        Close();
        try{
            socket = new DatagramSocket(LOCAL_PORT);
            socket.setSoTimeout(SOCKET_TIMEOUT);
            ip = InetAddress.getByName(_robotIP);
        }
        catch(Exception e)
        {
            this.logger.append("[ExternalControl] Problem opening a UDP socket.\n");
            return;
        }
        clientCounter = 0;
    }
    public void Close()
    {
        if (socket != null)
        {
            socket.close();
        }
        socket = null;
    }
}