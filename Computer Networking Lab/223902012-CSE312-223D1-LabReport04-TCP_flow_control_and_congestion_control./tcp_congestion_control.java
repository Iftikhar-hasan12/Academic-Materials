package fun;

import java.util.Random;
import java.util.Scanner;

class Congestion {
    Random rand = new Random();

   
    boolean isAckReceived() {
        int chance = rand.nextInt(10);  
        if (chance < 8) {
            return true; 
        } else {
            return false; 
        }
    }
}

public class TCP_congestion {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Congestion ob = new Congestion();

        System.out.print("Enter total number of packets to send: ");
        int totalPackets = scan.nextInt();

        int cwnd = 1;           
        int ssthresh = 8;       
        int sentPackets = 0;

        while (sentPackets < totalPackets) {
            System.out.println("\nCurrent Congestion Window Size: " + cwnd);

            
            for (int i = 0; i < cwnd && sentPackets < totalPackets; i++) {
                int packetNo = sentPackets + 1;
                System.out.print("Sending packet " + packetNo + "... ");

                if (ob.isAckReceived()) {
                    System.out.println("ACK received.");
                    sentPackets++;
                } else {
                    System.out.println("Packet lost! Congestion detected.");
                    ssthresh = cwnd / 2;
                    if (ssthresh < 1) ssthresh = 1;
                    cwnd = 1; 
                    break;
                }
            }

           
            if (cwnd < ssthresh) {
                cwnd = cwnd * 2;  
            } else {
                cwnd = cwnd + 1;  
            }
        }

        System.out.println("\nAll packets sent successfully!");
    }
}
