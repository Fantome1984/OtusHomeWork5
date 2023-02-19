package exeptions;

public class BrowserNotSupportedExeption extends Exception{
    public BrowserNotSupportedExeption(String browserName){
        super(String.format("Браузер %s не поддерживается", browserName));
    }

}
