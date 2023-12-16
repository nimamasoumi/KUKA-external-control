public class ConnectionControl
{
    public static void main(String[] args)
    {
        // arg[0] is the ip address
        // arg[1] is the port to connect
        String hostname = args[0];
        int port = Integer.parseInt(args[1]);

        System.out.printf("\n %s %d\n",hostname, port);
    }
}