package Email;

/**
 * Create by Yinsheng
 */

/**
 * This class will return an confirmation code randomly
 */
public class GetRandomCode
{

    private String confirmationCode;
    public String generatePIN()
    {
        int randomPIN = (int)(Math.random()*9000)+1000;
        confirmationCode = ""+randomPIN;
        return confirmationCode;
    }

    public static void main(String arg[])
    {
        GetRandomCode getRandomCode = new GetRandomCode();
        System.out.println(getRandomCode.generatePIN());
    }
}
