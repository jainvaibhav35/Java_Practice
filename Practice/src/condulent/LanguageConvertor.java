package condulent;

/**
 * Created by linchpin on 10/6/18.
 */
public class LanguageConvertor {

    public String convertFromOtherToNormal(String normalString){

        String convertedString = "" ;

        for(int i = 0 ; i < normalString.length() ; i++){
            convertedString += (char) ((int) normalString.charAt(i) - 3) ;
        }

        System.out.println(convertedString);

        return convertedString ;
    }


    public String convertFromNormalToOther(String normalString){

        String convertedString = "" ;

        for(int i = 0 ; i < normalString.length() ; i++){
            convertedString += (char) ((int) normalString.charAt(i) + 3) ;
        }

        System.out.println(convertedString);

        return convertedString ;
    }

    public static void main(String[] args) {
        new LanguageConvertor().convertFromNormalToOther("Hi") ;
        new LanguageConvertor().convertFromOtherToNormal("Kl") ;
    }


}
