#!/bin/bash
tshark -Y smtp  -r nitroba.pcap > out
sFound="false"
rFound="false"
time=0

cat out | while read line
do
    if [[ $line == *"MAIL FROM:"* && $sFound == "false"  ]];then
        sender=$(echo $line | grep -o "[A-Za-z0-9_]*@[A-Za-z0-9_]*\.[A-Za-z]*[\.[A-Za-z]*]*")
        if [[ $sender != [A-Za-z0-9_]*"@nitroba.org" ]];then
            sFound="true"
        fi
    fi
    if [[ $line == *"RCPT TO:"* && $rFound == "false"  ]];then
        recipient=$(echo $line | grep -o "[A-Za-z0-9_]*@[A-Za-z0-9_]*\.[A-Za-z]*[\.[A-Za-z]*]*")
        if [[ $recipient == [A-Za-z0-9_]*"@nitroba.org" ]];then
            rFound="true"
        else
            sFound="false"
        fi
    fi
    if [[ $line == *"from:"* && $rFound == "true"  ]];then
        ipsender=$(echo $line | grep -o "[0-9][0-9]*\.[0-9][0-9]*\.[0-9][0-9]*\.[0-9][0-9]* ->" | grep -o "[0-9][0-9]*\.[0-9][0-9]*\.[0-9][0-9]*\.[0-9][0-9]*")
        message=$(echo $line | grep -o "from:.*")
        echo "sender = "$sender
        echo "recipient = "$recipient
        echo "sender ip = "$ipsender
        echo "message = "$message
        echo "time = "$time
        sFound="false"
        rFound="false"
        time=$((time+1))
    fi
done


