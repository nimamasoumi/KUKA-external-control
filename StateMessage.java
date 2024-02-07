public class StateMessage 
{
    /// Data storage class for 'External Control UDP State Messages'.
    /// These type of messages are sent out by the robot as answer messages to any 
    /// command message received on its External Control UDP interface 
    /// and contain a header, status signals, current state of the default application, 
    /// and the current values of the robot's inputs App_Start and App_Enable.

    private Header header;

    private Signals signals;
    
    private StateMessage(){}
    public StateMessage(StateMessage other)
    {
        this.header.timestamp=other.header.timestamp;
        this.header.serverPacketCounter=other.header.timestamp;
        this.header.clientPacketCounter=other.header.clientPacketCounter;
        this.header.errorCode=this.header.errorCode;

        this.signals.autExtActive=other.signals.autExtActive;
        this.signals.extAppReadyToStart=other.signals.extAppReadyToStart;
        this.signals.defaultAppError=other.signals.defaultAppError;
        this.signals.stationError=other.signals.stationError;
    }

    public class Header
    {
        public long timestamp;
        public long serverPacketCounter;
        public long clientPacketCounter;
        public long errorCode;

        public Header(long _timestamp, long _serverPacketCounter
                    , long _clientPacketCounter, long _errorCode)
        {
            this.timestamp=_timestamp;
            this.serverPacketCounter=_serverPacketCounter;
            this.clientPacketCounter=_clientPacketCounter;
            this.errorCode=_errorCode;
        }
    }

    public class Signals
    {
        public boolean autExtActive;
        public boolean extAppReadyToStart;
        public boolean defaultAppError;
        public boolean stationError;

        public Signals(boolean _autExtActive, boolean _extAppReadyToStart
                        , boolean _defaultAppError, boolean _stationError)
        {
            this.autExtActive=_autExtActive;
            this.extAppReadyToStart=_extAppReadyToStart;
            this.defaultAppError=_defaultAppError;
            this.stationError=_stationError;
        }
    }
    
}
