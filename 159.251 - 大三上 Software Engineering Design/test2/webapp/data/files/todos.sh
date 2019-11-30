#!/bin/bash
check(){
firstLine=$(head -1 $1)       # Firstline of markdown file.
#echo $firstLine
filename=$(basename $1 .md)   # filename of markdown file
judge="# $filename"
#echo $judge

have_due=0						# 
while read line 
do
	if [[ $line =~ "due:" ]]              # If there's due: existing in the line -> vertify that there's time in this data (won't be copy to no_duedates).
		then
			echo "$line contain"
			have_due=1
	else
		echo "$line not contain"
	fi
done < $1

echo "have_due: $have_due. Needn't move"
if [ $have_due = 0 ]
	then 
		cp $1 no_duedates
		echo "$1 copy completed"
fi

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
######combine markdown files into single.md#######
cat alice/*.md > alice.md
echo "alice moved completed"

cat bob/*.md > bob.md
echo "bob moved completed"

cat olivia/*.md > olivia.md
echo "olivia moved completed"

cat alice.md bob.md olivia.md >single.md
echo "all moved completed"
###################################################
rm -f alice.md       #delete alice.md
rm -f bob.md
rm -f olivia.md
echo "all completed"
