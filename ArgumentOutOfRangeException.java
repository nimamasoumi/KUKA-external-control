public class ArgumentOutOfRangeException extends IllegalArgumentException {
    public ArgumentOutOfRangeException(){}
    public ArgumentOutOfRangeException(String _msg){
        super(_msg);
    }
    public ArgumentOutOfRangeException(String _msg, Throwable e)
    {
        super(_msg,e);
    }
}
