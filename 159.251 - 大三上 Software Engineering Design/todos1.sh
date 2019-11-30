#!/bin/bash
check(){
firstLine=$(head -1 $1)       # Firstline of markdown file.
#echo $firstLine
filename=$(basename $1 .md)   # filename of markdown file
judge="# $filename"
#echo $judge

if [ "$firstLine" != "$judge" ];
	then 
		mv $1 errors
		echo "!=,move completed"
fi
}

for x in alice/*.md
do 
check $x
done
echo "alice directory completed"

for x in bob/*.md
do 
check $x
done
echo "bob directory completed"

for x in olivia/*.md
do 
check $x
done
echo "olivia directory completed"
