#my_tests.sh
java Decoder s1.enc s1.ptx
echo Comparing s1.txt and s1.ptx ...
diff s1.txt s1.ptx
read -p "(Pause from testing script) Press Enter to continue ... "

java Decoder s2.enc s2.ptx
echo Comparing s2.txt and s2.ptx ...
diff s2.txt s2.ptx
read -p "(Pause from testing script) Press Enter to continue ... "

java Decoder s3.enc s3.ptx
echo Comparing s3.txt and s3.ptx ...
diff s3.txt s3.ptx
read -p "(Pause from testing script) Press Enter to continue ... "

java Decoder s4.enc s4.ptx
echo Comparing s4.txt and s4.ptx ...
diff s4.txt s4.ptx
read -p "(Pause from testing script) Press Enter to continue ... "

java Decoder s5.enc s5.ptx
echo Comparing s5.txt and s5.ptx ...
diff s5.txt s5.ptx
read -p "(Pause from testing script) Press Enter to continue ... "





