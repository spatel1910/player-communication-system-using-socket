#!/bin/bash

PROJECT_DIR=$(pwd)

# Start ServerMain in new Git Bash window
/c/Program\ Files/Git/usr/bin/mintty.exe -w max /bin/bash -c "cd '$PROJECT_DIR'; mvn compile exec:java -Dexec.mainClass=com.player.multiprocess.ServerMain; exec bash" &

# Wait a bit for the server to start
sleep 3

# Start ClientMain in new Git Bash window
/c/Program\ Files/Git/usr/bin/mintty.exe -w max /bin/bash -c "cd '$PROJECT_DIR'; mvn compile exec:java -Dexec.mainClass=com.player.multiprocess.ClientMain; exec bash" &
