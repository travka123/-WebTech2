javac -d temp ../task9/*

cd temp
MD ..\out
jar cfm ../out/Bucket.jar ../manifest.mf *
cd ..
RD /S /Q temp

java -jar out/Bucket.jar

pause