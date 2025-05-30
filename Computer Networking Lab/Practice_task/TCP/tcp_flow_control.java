
package fun;

import static java.lang.Math.random;
import java.util.Scanner;
import java.util.Random;

/**
 * @author Md. Ehsan Shahmi Chowdhury,
 * Lecturer, CSE, Green University of Bangladesh
 */
public class TCP {

    public static int generateFrame(int winSize) {
        Random random = new Random();
        int noOfGeneratedFrame = random.nextInt(500) % winSize;

        if (noOfGeneratedFrame == 0)
            return winSize;
        else
            return noOfGeneratedFrame;
    }

    public static int generateAck(int noOfSent) {
        Random random = new Random();
        int noOfAckFrame = (int) (random.nextInt(500) % noOfSent);
        return noOfAckFrame;
    }

    public static void main(String[] args) {
        int noOfFrame, winSize, startByte = 0, endByte = 0, noOfAck = 0, noOfSent = 0;

        Scanner scn = new Scanner(System.in);

        System.out.println("Enter the total no of frame: ");
        noOfFrame = scn.nextInt();

        System.out.println("Enter the window size: ");
        winSize = scn.nextInt();

        int dueFrame = noOfFrame;

        while (dueFrame >= 0) {
            noOfSent = generateFrame(winSize);
            endByte += noOfSent;

            if (endByte > noOfFrame)
                endByte = noOfFrame;

            for (int i = startByte + 1; i <= endByte; i++) {
                System.out.println("Sending frame " + i);
            }

            noOfAck = generateAck(noOfSent);
            startByte += noOfAck;

            if (startByte > noOfFrame)
                startByte = noOfFrame;

            System.out.println("Acknowledgement for the frame upto " + startByte);

            dueFrame -= noOfAck;
            endByte = startByte;
        }

        System.out.println("\nThe Sliding Window Protocol concludes here.");
    }
}

