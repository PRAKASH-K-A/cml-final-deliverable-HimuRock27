[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/aQj7XJJr)

# Capital Market Technology Lab

## Overview
This project implements a simplified Order Management System (OMS) based on FIX 4.4 protocol.

It supports:
- Order ingestion using QuickFIX/J
- Order validation and processing
- Matching Engine (Price-Time Priority)
- Trade execution
- Database persistence (MySQL)
- WebSocket broadcasting
- Black-Scholes option pricing

## Tech Stack
- Java 8+
- MySQL
- QuickFIX/J
- WebSocket
- Angular (conceptual)

## Features Implemented
- FIX connectivity (Lab 2)
- Order parsing (Lab 3)
- Matching Engine (Lab 7)
- Persistence (Lab 5)
- Execution reporting (Lab 8)
- Black-Scholes model (Lab 11)

## How to Run
1. Configure MySQL
2. Run AppLauncher.java
3. Connect MiniFix to port 9876
4. Send orders

## Conclusion
The system simulates a high-frequency trading environment handling order flow, matching, and execution.
