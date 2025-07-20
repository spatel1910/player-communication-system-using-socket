# Player Communication System

This system enables communication between `Player` instances via two modes:

- Single-Process Mode: Players communicate using threads and `BlockingQueue`.
- Multi-Process Mode:Players run in separate JVMs and communicate using simple sockets.

In Project directory two separate modules have been created:  
    -singleprocess  
    -multiprocess
---

**#Features**

- Thread-based communication in a single JVM
- Socket-based communication between separate JVM processes
- Runnable via simple shell scripts

**#Steps-to-run**  
1- Unzip the file  
2- Open gitbash terminal and go to the project folder  
`ex-/c/Users/Patel-Ji/player-communication-system`  
3- Run Single Process Module, just type and hit enter  
` ./SingleProcess.sh`

4- Run Multi Process Module, just type and hit enter  
`./MultiProcess.sh`



---

