#Nikolaou Ioannis AM 4504 Martios 2015
#!/bin/bash

cd $HOME/NetBeansProjects/clasificationJava-master/trainDat
Size="$(ls -1 | wc -l)"
Size=$(expr $Size - 1)
echo $Size
cd ..
portSt=9200
echo $portSt
localIP="$(curl ifconfig.me/ip)"
echo $localIP
#read -r b
# echo "checking ports....."
# ts="$(nc -z $localIp $portSt; echo $?)"
# if [ $ts -eq 1]
# then
#	echo "port $portSt is available"
# fi
if [  -f port.list ]; then
    #echo "File not found!"
    rm port.list
fi
for ((c=1; c<=$Size; c++))
do
	echo "Staring Server Instance on Port $portSt"
	source /root/local/share/jubatus/jubatus.profile
	echo $portSt >> port.list
	jubaanomaly --configpath jubaanomaly-config.json --rpc-port $portSt&
	portSt=$(expr $portSt + 1)
done
cd target
java -Xms1G -Xmx7G -jar anomaly-0.1.jar
