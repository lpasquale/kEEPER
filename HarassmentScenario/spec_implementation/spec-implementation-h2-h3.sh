#!/bin/bash

currentDate=""
#tcpflow -r nitroba.pcap -o nitroba
cd nitroba
find . > list
#cat list | while read file
#do
#    if [[ $file == *"-"* ]];then
#        echo "file: "$file
#        if grep -a "Set-Cookie:" $file ;then
#            cat $file | while read line
#            do
#                date=$(echo $line | grep -o "Date: ..., [0-9][0-9] ........ ........")
#                echo "date before: "$date
#                if [[ $date != "" ]];then
#                    day=$(echo $date  | grep -o " [0-9][0-9] " | grep -o "[0-9][0-9]")
#                    month=$(echo $date | grep -o "[A-z][a-z][a-z] " | grep -o "[A-z][a-z][a-z]" )
#                    if [[ $month == "Jan" ]];then
#                        month="01"
#                        else if [[ $month == "Feb" ]];then
#                            month="02"
#                            else if [[ $month == "Mar" ]];then
#                                month="03"
#                                else if [[ $month == "Apr" ]];then
#                                    month="04"
#                                    else if [[ $month == "May" ]]; then
#                                        month="05"
#                                        else if [[ $month == "Jun" ]]; then
#                                            month="06"
#                                            else if [[ $month == "Jul" ]]; then
#                                                month="07"
#                                                else if [[ $month == "Aug" ]]; then
#                                                    month="08"
#                                                    else if [[ $month == "Sep" ]]; then
#                                                        month="09"
#                                                        else if [[ $month == "Oct" ]]; then
#                                                            month="10"
#                                                            else if [[ $month == "Nov" ]]; then
#                                                                month="11"
#                                                                else if [[ $month == "Dec" ]]; then
#                                                                    month="12"
#                                                                    fi
#                                                                fi
#                                                            fi
#                                                        fi
#                                                    fi
#                                                fi
#                                            fi
#                                        fi
#                                    fi
#                                fi
#                            fi
#                        fi
#                        year=$(echo $date | grep -o "[0-9][0-9][0-9][0-9]" )
#                        h=$(echo $date | grep -o " [0-9][0-9]:"  | grep -o "[0-9][0-9]")
#                        m=$(echo $date | grep -o ":[0-9][0-9]:" | grep -o "[0-9][0-9]")
#                        s=$(echo $date | grep -o ":[0-9][0-9][:][0-9][0-9]"  | grep -o "[0-9][0-9][:][0-9][0-9]" | grep -o "[:][0-9][0-9]" | grep -o "[0-9][0-9]" )
#                        currentDate=$year"-"$month"-"$day"T"$h":"$m":"$s
#                    fi
#                email=$(echo $line | grep -ao "Set-Cookie: [A-Za-z0-9_][A-Za-z0-9_]*=[A-Za-z0-9_][A-Za-z0-9_]*@[A-Za-z0-9_]*\.[A-Za-z]*[\.[A-Za-z]*]*" )
#                if [[ $email == *"@"* ]];then
#                    email=$(echo $email | grep -ao "=[A-Za-z0-9_][A-Za-z0-9_]*@[A-Za-z0-9_]*\.[A-Za-z]*[\.[A-Za-z]*]*")
#                    email=$(echo $email | grep -ao "[A-Za-z0-9_][A-Za-z0-9_]*@[A-Za-z0-9_]*\.[A-Za-z]*[\.[A-Za-z]*]*")
#                    echo " email "$email
#                    recIP=$(echo $file | grep -o "\-[0-9][0-9]*\.[0-9][0-9]*\.[0-9][0-9]*\.[0-9][0-9]*")
#                    recIP=$(echo $recIP | grep -o "[0-9][0-9]*\.[0-9][0-9]*\.[0-9][0-9]*\.[0-9][0-9]*")
#                    sendIP=$(echo $file | grep -o "[0-9][0-9]*\.[0-9][0-9]*\.[0-9][0-9]*\.[0-9][0-9]*\.[0-9][0-9]*\-")
#                    sendIP=$(echo $sendIP | grep -o "[0-9][0-9]*\.[0-9][0-9]*\.[0-9][0-9]*\.[0-9][0-9]*")
#                    echo "email = "$email" sendIp = "$sendIP" recIP = "$recIP" time = "$currentDate >>set_cookie
#               fi
#            done
#        fi
#    fi

#done


#



#cat list | while read file
#do
#    if [[ $file == *"-"* ]];then
#        if grep -a "User-Agent:" $file ;then
#            echo $file
#            cat $file | while read line
#            do
#                sendIP=$(echo $file | grep -o "[0-9][0-9]*\.[0-9][0-9]*\.[0-9][0-9]*\.[0-9][0-9]*\.[0-9][0-9]*\-")
#                sendIP=$(echo $sendIP | grep -o "[0-9][0-9]*\.[0-9][0-9]*\.[0-9][0-9]*\.[0-9][0-9]*")
#                date=$(echo $line | grep -ao "Date: ..., [0-9][0-9] ........ ........")
#                echo "date before: "$date
#                if [[ $date != "" ]];then
#                    day=$(echo $date  | grep -o " [0-9][0-9] " | grep -o "[0-9][0-9]")
#                    month=$(echo $date | grep -o "[A-z][a-z][a-z] " | grep -o "[A-z][a-z][a-z]" )
#                    if [[ $month == "Jan" ]];then
#                        month="01"
#                        else if [[ $month == "Feb" ]];then
#                            month="02"
#                            else if [[ $month == "Mar" ]];then
#                                month="03"
#                                else if [[ $month == "Apr" ]];then
#                                    month="04"
#                                    else if [[ $month == "May" ]]; then
#                                        month="05"
#                                        else if [[ $month == "Jun" ]]; then
#                                            month="06"
#                                            else if [[ $month == "Jul" ]]; then
#                                                month="07"
#                                                else if [[ $month == "Aug" ]]; then
#                                                    month="08"
#                                                    else if [[ $month == "Sep" ]]; then
#                                                        month="09"
#                                                        else if [[ $month == "Oct" ]]; then
#                                                            month="10"
#                                                            else if [[ $month == "Nov" ]]; then
#                                                                month="11"
#                                                                else if [[ $month == "Dec" ]]; then
#                                                                    month="12"
#                                                                    fi
#                                                                fi
#                                                            fi
#                                                        fi
#                                                   fi
#                                                fi
#                                            fi
#                                        fi
#                                    fi
#                                fi
#                            fi
#                        fi
#                        year=$(echo $date | grep -o "[0-9][0-9][0-9][0-9]" )
#                        h=$(echo $date | grep -o " [0-9][0-9]:"  | grep -o "[0-9][0-9]")
#                        m=$(echo $date | grep -o ":[0-9][0-9]:" | grep -o "[0-9][0-9]")
#                        s=$(echo $date | grep -o ":[0-9][0-9][:][0-9][0-9]"  | grep -o "[0-9][0-9][:][0-9][0-9]" | grep -o "[:][0-9][0-9]" | grep -o "[0-9][0-9]" )
#                        currentDate=$year"-"$month"-"$day"T"$h":"$m":"$s
#                    fi
#                if grep -q "recIP = "$sendIP set_cookie; then
#                    browser=$(echo $line | grep -a -m 1 "User-Agent:" | grep -o " [A-Za-z0-9_/\.;,\(\) ][A-Za-z0-9_/\.;,\(\) ]*" | grep -o "[A-Za-z0-9_/\.;,\(\)][A-Za-z0-9_/\.;,\(\) ]*[\)]")
#                    if [[ $browser != "" ]];then
#                        recIP=$(echo $file | grep -o "\-[0-9][0-9]*\.[0-9][0-9]*\.[0-9][0-9]*\.[0-9][0-9]*")
#                        recIP=$(echo $recIP | grep -o "[0-9][0-9]*\.[0-9][0-9]*\.[0-9][0-9]*\.[0-9][0-9]*")
#                        echo "browser = "$browser
#                        echo "sendIp = "$sendIP" recIP = "$recIP" browser = "$browser" time = "$currentDate >> exchange_msg
#                    fi
#                fi
#            done
#        fi
#    fi
#done


cat list | while read file
do
    if [[ $file == *"-"* ]];then
        if grep -q "anonymousemail" $file; then
            echo $file
            cat $file | while read line
            do
                date=$(echo $line | grep -ao "Date: ..., [0-9][0-9] ........ ........")
                echo "date before: "$date
                if [[ $date != "" ]];then
                    day=$(echo $date  | grep -o " [0-9][0-9] " | grep -o "[0-9][0-9]")
                    month=$(echo $date | grep -o "[A-z][a-z][a-z] " | grep -o "[A-z][a-z][a-z]" )
                    if [[ $month == "Jan" ]];then
                        month="01"
                        else if [[ $month == "Feb" ]];then
                            month="02"
                            else if [[ $month == "Mar" ]];then
                                month="03"
                                else if [[ $month == "Apr" ]];then
                                    month="04"
                                    else if [[ $month == "May" ]]; then
                                        month="05"
                                        else if [[ $month == "Jun" ]]; then
                                            month="06"
                                            else if [[ $month == "Jul" ]]; then
                                                month="07"
                                                else if [[ $month == "Aug" ]]; then
                                                    month="08"
                                                    else if [[ $month == "Sep" ]]; then
                                                        month="09"
                                                        else if [[ $month == "Oct" ]]; then
                                                            month="10"
                                                            else if [[ $month == "Nov" ]]; then
                                                                month="11"
                                                                else if [[ $month == "Dec" ]]; then
                                                                    month="12"
                                                                fi
                                                            fi
                                                        fi
                                                    fi
                                                fi
                                            fi
                                        fi
                                    fi
                                fi
                            fi
                        fi
                    fi
                    year=$(echo $date | grep -o "[0-9][0-9][0-9][0-9]" )
                    h=$(echo $date | grep -o " [0-9][0-9]:"  | grep -o "[0-9][0-9]")
                    m=$(echo $date | grep -o ":[0-9][0-9]:" | grep -o "[0-9][0-9]")
                    s=$(echo $date | grep -o ":[0-9][0-9][:][0-9][0-9]"  | grep -o "[0-9][0-9][:][0-9][0-9]" | grep -o "[:][0-9][0-9]" | grep -o "[0-9][0-9]" )
                    currentDate=$year"-"$month"-"$day"T"$h":"$m":"$s
                fi
                browser=$(echo $line | grep -a -m 1 "User-Agent:" | grep -o " [A-Za-z0-9_/\.;,\(\) ][A-Za-z0-9_/\.;,\(\) ]*" | grep -o "[A-Za-z0-9_/\.;,\(\)][A-Za-z0-9_/\.;,\(\) ]*[\)]")
                if [[ $browser != "" ]];then
                    sendIP=$(echo $file | grep -o "[0-9][0-9]*\.[0-9][0-9]*\.[0-9][0-9]*\.[0-9][0-9]*\.[0-9][0-9]*\-")
                    sendIP=$(echo $sendIP | grep -o "[0-9][0-9]*\.[0-9][0-9]*\.[0-9][0-9]*\.[0-9][0-9]*")
                    recIP=$(echo $file | grep -o "\-[0-9][0-9]*\.[0-9][0-9]*\.[0-9][0-9]*\.[0-9][0-9]*")
                    recIP=$(echo $recIP | grep -o "[0-9][0-9]*\.[0-9][0-9]*\.[0-9][0-9]*\.[0-9][0-9]*")
                    echo "sendIp = "$sendIP" recIP = "$recIP" browser = "$browser" time = "$currentDate >> send_anon_email
                fi
            done
        fi
    fi
done

#sendIP="192.168.015.004"
#if grep -q "recIP = "$sendIP set_cookie; then
#    echo "sei sfigato"
#fi


#cd nitroba
#find . > list
#cat list | while read line
#do
#    if [[ $line == *"-074.125.019.104"* ]];then
#        sendIP=$(echo $line | grep -o "[0-9][0-9]*\.[0-9][0-9]*\.[0-9][0-9]*\.[0-9][0-9]*\.[0-9][0-9]*\-")
#        sendIP=$(echo $sendIP | grep -o "[0-9][0-9]*\.[0-9][0-9]*\.[0-9][0-9]*\.[0-9][0-9]*")
#        recIP=$(echo $line | grep -o "\-[0-9][0-9]*\.[0-9][0-9]*\.[0-9][0-9]*\.[0-9][0-9]*")
#        recIP=$(echo $recIP | grep -o "[0-9][0-9]*\.[0-9][0-9]*\.[0-9][0-9]*\.[0-9][0-9]*")
#        echo "recIP = "$recIP
#        echo "sendIp = "$sendIP
#        browser=$(grep -a -m 1 "User-Agent:" $line | grep -o " [A-Za-z0-9_/\.;,\(\) ][A-Za-z0-9_/\.;,\(\) ]*" | grep -o "[A-Za-z0-9_/\.;,\(\)][A-Za-z0-9_/\.;,\(\) ]*[\)]")
#        echo "browser = "$browser
#    fi
#done


#tcpflow -r nitroba.pcap -o nitroba
#cd nitroba
#find . > list
#cat list | while read line
#do
#    if [[ $line == *"-"* ]];then
#        grep -a "Cookie:" $line | grep -v "Set-Cookie:" | grep "jcoach@gmail.com"
#  email=$(grep -ao "Cookie: [A-Za-z0-9_][A-Za-z0-9_]*=[A-Za-z0-9_][A-Za-z0-9_]*@[A-Za-z0-9_]*\.[A-Za-z]*[\.[A-Za-z]*]*" $line)
#        if [[ $email == *"@"* ]];then
#            email=$(echo $email | grep -ao "=[A-Za-z0-9_][A-Za-z0-9_]*@[A-Za-z0-9_]*\.[A-Za-z]*[\.[A-Za-z]*]*")
#            email=$(echo $email | grep -ao "[A-Za-z0-9_][A-Za-z0-9_]*@[A-Za-z0-9_]*\.[A-Za-z]*[\.[A-Za-z]*]*")
#            echo $email
#            sendIP=$(echo $line | grep -o "[0-9][0-9]*\.[0-9][0-9]*\.[0-9][0-9]*\.[0-9][0-9]*\.[0-9][0-9]*\-")
#            sendIP=$(echo $sendIP | grep -o "[0-9][0-9]*\.[0-9][0-9]*\.[0-9][0-9]*\.[0-9][0-9]*")
#            recIP=$(echo $line | grep -o "\-[0-9][0-9]*\.[0-9][0-9]*\.[0-9][0-9]*\.[0-9][0-9]*")
#            recIP=$(echo $recIP | grep -o "[0-9][0-9]*\.[0-9][0-9]*\.[0-9][0-9]*\.[0-9][0-9]*")
#            echo "exchange_msg"
#            echo "email = "$email
#            echo "sendIp = "$sendIP
#            echo "recIP = "$recIP
#            echo "time = "$time
#            time=$((time+1))
#        fi
#    fi
#done



