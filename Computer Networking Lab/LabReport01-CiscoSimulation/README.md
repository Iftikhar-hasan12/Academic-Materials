**Lab 4: Network Services Implementation (SMTP, FTP, and DNS)
Overview**
This lab exercise focuses on configuring and testing three essential network services:

SMTP (Simple Mail Transfer Protocol) – For sending and receiving emails.

FTP (File Transfer Protocol) – For file sharing between client and server.

DNS (Domain Name System) – For resolving domain names to IP addresses.

The network topology is implemented in Cisco Packet Tracer, featuring multiple servers, PCs, and a router to simulate real-world networking scenarios.

**Topology**
The network consists of two subnetworks:

**Subnet 1 (192.168.1.0/24)**

DNS Server: 192.168.1.4

Mail Server (Yahoo.com): 192.168.1.1

FTP Server: 192.168.1.3

PCs and Laptops: Various IPs

**Subnet 2 (192.168.2.0/24)**

DNS Server2: 192.168.2.4

Mail Server (Gmail.com): 192.168.2.3

PCs and Laptops: Various IPs

A Router (2811) connects both networks and enables intercommunication.

Configuration Steps
DNS Configuration

Set up DNS servers for domain name resolution.

Verify with nslookup commands.

FTP Server Setup

Configure the FTP server to allow file transfers.

Test access using FTP client commands (get).

SMTP Mail Server Configuration

Set up the mail servers ( Gmail).

Send test emails between clients.






Follow the Lab_Report.pdf for configuration details and testing.


