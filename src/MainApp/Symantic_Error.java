package MainApp;

public class Symantic_Error {
    private Error_Type name;
    private String type;
    private String number;
    public Symantic_Error(){

    }

    public Error_Type getName() {
        return name;
    }

    public void setName(Error_Type name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
    public String getError(){
        String error ="Error Name : "+getName()
                +",Error Description :"+getType()
                +",Error Location :"+getNumber();
        return error;
    }
    public void addError(Error_Type name,String desc , String line){
        this.name=name;
        this.type=desc;
        this.number=line;
    }
}
