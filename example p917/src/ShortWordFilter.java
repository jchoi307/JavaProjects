
public class ShortWordFilter implements Filter {
    
    public ShortWordFilter(){}
    
    @Override
    public boolean accept(Object x){
        boolean vfy;
        vfy = x.toString().length() >= 5;
        return vfy;
    }
    
}
