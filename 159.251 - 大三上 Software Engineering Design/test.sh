#!/bin/bash
mkdir error_files
mkdir no_duedates				#建立文件夹  // 建立文档 touch "${file1}"



FunStep(){

First=$(head -1 $1)
echo $First

Second=$(basename $1 .md)
echo $Second

last=$(tail -1 $1)
echo $last

str="due:"
result=$(echo $last | grep "${str}" )
echo $result
 

if [ $First != $Second ]
then 
   mv $1 /d/sh文件/error_files		#move to
   echo $1 moved to error_files      #表达上一行移动成功
   unset myfiles[index]
else
   echo $1 No Problem
fi                                       #end if

if [ "$result" = "" ];then
   mv $1 /d/sh文件/no_duedates			#move to
   echo $1 moved to no_duedates       #表达上一行移动成功
   unset myfiles[index]
else
   echo $1 No Problem
fi        								#end if
}

for x in *.md 
do 
FunStep $x
done

cat *.md > /d/sh文件/SingFile.md       #创建新文件，不是编辑已有文件。

cp no_duedates/*.md /d/sh文件         #拷贝文件