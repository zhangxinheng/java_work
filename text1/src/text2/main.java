package text2;

public class main {
    public static  void main(String args[]){
        String str = "Hello  I'm your        String";//空格可以任意多个
        String[] splited = str.split("\\s+");//这样写就可以了
        for(int i=0;i<splited.length;i++){
            System.out.println(splited[i]);
        }

    }
}
