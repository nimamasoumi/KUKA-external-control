public class ConnectionControl
{
    public ConnectionControl(){}
    private static NetworkConfig NetConfig = new NetworkConfig();
    private static LbrMedNetworkSource NetSource = new LbrMedNetworkSource();
    public static void main(String[] args)
    {
        // arg[0] is the ip address
        // arg[1] is the port to connect
        String hostname = args[0];
        int port = Integer.parseInt(args[1]);

        System.out.printf("\nConnecting to %s using port %d\n",hostname, port);
        
        NetConfig.Hostname = hostname;
        NetConfig.Port = port;

        // Try connecting
        if (!NetSource.Connect(NetConfig))
        {
            System.out.printf("\nFailed to connect to %s:%d",hostname,port);
            return;
        }
        System.out.printf("\nConnected to %s:%d",hostname,port);
    }
}