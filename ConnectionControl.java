public class ConnectionControl
{
    public ConnectionControl(){}
    private NetworkConfig NetConfig = new NetworkConfig();
    public static void main(String[] args)
    {
        // arg[0] is the ip address
        // arg[1] is the port to connect
        String hostname = args[0];
        int port = Integer.parseInt(args[1]);

        System.out.printf("\nConnecting to %s using port %d\n",hostname, port);
    }
}