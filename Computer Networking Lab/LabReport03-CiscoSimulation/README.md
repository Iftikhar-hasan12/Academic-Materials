# Inter-University Network Setup using RIP and NAT

This project is a simulation of network infrastructure between three universities: **GUB**, **BUET**, and **KUET** using **Cisco Packet Tracer**. Each university has three devices (server, PC, laptop), and the routing is done using **RIP v2** along with **NAT configuration** for external communication.

## 🔧 Technologies & Tools
- Cisco Packet Tracer
- RIP (Routing Information Protocol v2)
- NAT (Network Address Translation)

## 🧠 What I Learned
- How to set up and test dynamic routing using RIP.
- First-time experience with serial cable connections.
- Troubleshooting NAT — had to dig a bit using ChatGPT and the internet 😅.

## 🗂️ Folder Contents
- `topology.pkt`: Packet Tracer simulation file.
- `Lab_Report.pdf`: My detailed lab report.
- `Screenshots/`: Folder containing step-by-step screenshots.

## 🚦 Subnet Info

| University | Inside Network     | Outside Network  |
|------------|--------------------|------------------|
| GUB        | 192.168.10.0/24    | 10.0.0.0/24      |
| BUET       | 192.168.20.0/24    | 20.0.0.0/24      |
| KUET       | 192.168.30.0/24    | 30.0.0.0/24      |

## 📡 Summary
The goal was to build a working and scalable inter-university network where departments can access services and communicate efficiently. Despite some NAT issues at first, everything runs smoothly now.

