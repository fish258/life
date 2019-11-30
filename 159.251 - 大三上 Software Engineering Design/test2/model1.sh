#!/bin/bash
#str="this is a string"
#echo "3"
#if [[ $str =~ "this" ]]
#then 
#	echo "1"
#else
#	echo "2"
#fi 
#echo "4"

#a=$1
#b=$2
#echo "a: $a"
#echo "b: $b"
#if [ $a == $b ]
#then
#   echo "a 等于 b"
#elif [ $a -gt $b ]
#then
#   echo "a 大于 b"
#elif [ $a -lt $b ]
#then
#   echo "a 小于 b"
#else
#   echo "没有符合的条件"
#fi
cat alice/*.md > alice.md
echo "alice completed"

cat bob/*.md > bob.md
echo "bob completed"

cat olivia/*.md > olivia.md
echo "olivia completed"

cat alice.md bob.md olivia.md >single.md
rm -f alice.md       #delete alice.md
rm -f bob.md
rm -f olivia.md
echo "all completed"