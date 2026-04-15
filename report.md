# Capital Market Technology Lab Report

## Introduction
This project implements a trading system capable of handling high-frequency orders using FIX protocol. The system is designed based on microservices architecture and supports real-time processing.

## Objectives
- Implement FIX connectivity
- Design matching engine
- Persist trade data
- Perform option pricing using Black-Scholes

## System Architecture
FIX Client → Order Service → Matching Engine → Database → UI

## Implementation

### FIX Connectivity
QuickFIX/J is used to establish sessions and process messages.

### Order Processing
Incoming NewOrderSingle messages are parsed and validated.

### Matching Engine
Price-Time Priority algorithm is implemented:
- Buy matches lowest sell
- Sell matches highest buy

### Persistence
Orders are stored asynchronously using BlockingQueue.

### Execution
Execution reports are generated for each trade.

### Black-Scholes Model
Used for option pricing based on stock price.

## Results
- Successfully handled multiple orders
- Matching executed correctly
- Data persisted without latency issues

## Conclusion
The system demonstrates a scalable and efficient trading architecture.