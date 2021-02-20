#my_tests.sh
java Encoder s1.txt s1.out
echo Comparing s1.enc and s1.out ...
diff s1.enc s1.out
read -p "(Pause from testing script) Press Enter to continue ... "

java Encoder s2.txt s2.out
echo Comparing s2.enc and s2.out ...
diff s2.enc s2.out
read -p "(Pause from testing script) Press Enter to continue ... "

java Encoder s3.txt s3.out
echo Comparing s3.enc and s3.out ...
diff s3.enc s3.out
read -p "(Pause from testing script) Press Enter to continue ... "

java Encoder s4.txt s4.out
echo Comparing s4.enc and s4.out ...
diff s4.enc s4.out
read -p "(Pause from testing script) Press Enter to continue ... "

java Encoder s5.txt s5.out
echo Comparing s5.enc and s5.out ...
diff s5.enc s5.out
read -p "(Pause from testing script) Press Enter to continue ... "





