package Helpers;

import java.util.Scanner;

public class GetMessageFromUser {

    public static String GetMessage(String messageToShow)
    {
        Scanner _scan = new Scanner(System.in);
        boolean isCorrect = false;
        String answer = "";

        while(!isCorrect)
        {
            try {
                System.out.println(messageToShow);
                answer = _scan.nextLine();
                if(answer.isEmpty())
                {
                    isCorrect = false;
                    System.out.println("Bad input! Try again.");
                }
                else
                {
                    isCorrect = true;
                }
            }catch (Exception e)
            {
                System.out.println("Bad input! Try again.");
                _scan.next();
            }
        }

        return answer;
    }
}
