import java.net.Socket;

public class LbrMedNetworkSource
{
    private Socket tcpClient;
    private String IP = "";
    private int Port = 0;
    private boolean EnableExternalControl = true;
    
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

    public boolean Connect(NetworkConfig _nc)
    {
        if(tcpClient.isConnected())
        {
            System.out.println("Already Connected!");
            return false;
        }

        this.IP = _nc.Hostname;
        this.Port = _nc.Port;
        
        if(this.EnableExternalControl)
        {

        }
        return false;
    }

    private boolean InitilizeExternalControl(NetworkConfig _nc)
    {
        return false;
    }
}