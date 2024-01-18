import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

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

        // frame is the window and panel is where the components are placed
        var ui = new JFrame("KUKA External Control");
        var panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
        panel.setLayout(new GridLayout(0,1));
        ui.setSize(777,626);
        ui.setLocationRelativeTo(null);
        
        var logger = new JTextArea("Initilizing the application: \n"); 
        //logger.setBounds(100,100,500,500);               
        panel.add(logger);        
        ui.add(panel, BorderLayout.CENTER);
        try{
            ui.setDefaultCloseOperation(ui.EXIT_ON_CLOSE);
        }
        catch(SecurityException e){
            logger.append("Security exception caught bythe security manager "+e);
        }
        ui.setVisible(true);
        
        logger.append(String.format("Connecting to %s using port %d\n",hostname, port));
        
        NetConfig.Hostname = hostname;
        NetConfig.Port = port;
        NetSource.setLogger(logger);

        // Try connecting
        if (!NetSource.Connect(NetConfig))
        {
            logger.append(String.format("Failed to connect to %s:%d",hostname,port));
            return;
        }
        logger.append(String.format("Connected to %s:%d",hostname,port));
    }
}