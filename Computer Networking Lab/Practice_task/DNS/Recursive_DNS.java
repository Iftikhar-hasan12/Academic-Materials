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

class Recursive {

    DNS_Record[] record = new DNS_Record[3];
    String name;
    String ip;

    void info_collect() {
        for (int i = 0; i < 3; i++) {
            Scanner scan = new Scanner(System.in);
            System.out.print("Enter domain name : ");
            name = scan.nextLine();

            System.out.print("Enter IP : ");
            ip = scan.nextLine();

            DNS_Record ob = new DNS_Record(ip, name);

            record[i] = ob;
        }

    }

    String findIP(String name, int index) {

        if (index > record.length) {
            return "Not found";
        }

        if (record[index].name.equalsIgnoreCase(name)) {
            return record[index].ip;

        }

             return  findIP(name, index+1);
    }

}

public class IDNS {

    public static void main(String[] args) {

        Recursive it = new Recursive();
        it.info_collect();

        String ip = it.findIP("Facebook.com", 0);
        System.out.println("Facebook.com : " + ip);

    }

}
