package fun;

import java.util.Scanner;

class DNS_Record {

    String ip;
    String name;

    DNS_Record(String ip, String name) {
        this.ip = ip;
        this.name = name;

    }

}

class Iterative {

    DNS_Record[] record = new DNS_Record[1];
    String name;
    String ip;

    void info_collect() {
        for (int i = 0; i < 1; i++) {
            Scanner scan = new Scanner(System.in);
            System.out.print("Enter domain name : ");
            name = scan.nextLine();

            System.out.print("Enter IP : ");
            ip = scan.nextLine();

            DNS_Record ob = new DNS_Record(ip, name);

            record[i] = ob;
        }

    }

    String findIP(String name) {
        for (DNS_Record x : record) {
            if (x.name.equalsIgnoreCase(name)) {
                return x.ip;
            }
        }

        return "Not Found";

    }

}

public class IDNS {

    public static void main(String[] args) {

        Iterative it = new Iterative();
        it.info_collect();

        String ip = it.findIP("Facebook.com");
        System.out.println("Facebook.com : " + ip);

    }

}
