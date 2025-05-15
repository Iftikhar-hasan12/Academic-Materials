## TCP Flow Control and Congestion Control Simulation (Java)

This repository contains two simple Java programs that simulate the key mechanisms of **TCP Flow Control** and **TCP Congestion Control**. These simulations are written as part of a Computer Networking Lab assignment at Green University of Bangladesh (GUB).

## 📌 Objective

To understand and demonstrate how TCP ensures reliable data transfer by dynamically adjusting the sending rate using:

- **Flow Control** (based on the receiver’s buffer capacity using `rwnd`)
- **Congestion Control** (based on network condition using `cwnd`)

---

## 🚀 Programs Included

### 1. TCP Flow Control

This program simulates the TCP sliding window flow control mechanism. The sender adjusts the number of frames it sends based on acknowledgment received from the receiver.

**File:** `TCP.java`

#### Key Features:
- Random frame generation per round.
- Simulated acknowledgment generation.
- Demonstrates how the sender adapts to receiver feedback.

### 2. TCP Congestion Control

This program simulates congestion control using TCP's slow start and congestion avoidance techniques. It reacts to ACKs and packet loss by adjusting the congestion window size.

**File:** `TCP_congestion.java`

#### Key Features:
- Implements slow start and additive increase.
- Reduces `cwnd` on packet loss.
- Demonstrates congestion detection and recovery.

---

## 💡 How to Run

1. Make sure Java is installed on your system.
2. Open terminal/command prompt in the project directory.
3. Compile the files:


