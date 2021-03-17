#!/bin/bash
cd /home/superaccess/bascula/Core_LPR/
screen -dmS bascula -t reconocimiento java -Xss1000m -jar Core_LPR.jar
screen -S bascula -X screen -t postgres sudo -u postgres psql
sleep 5
cd /home/superaccess/visitantes/sincronizadores-zfb/
screen -dmS control_acceso -t visitantes java -jar SincronizadorZFB.jar
screen -S control_acceso -X screen -t postgres sudo -u postgres psql
sleep 2
sudo chmod -R 777 /home/superaccess/bascula/Logs