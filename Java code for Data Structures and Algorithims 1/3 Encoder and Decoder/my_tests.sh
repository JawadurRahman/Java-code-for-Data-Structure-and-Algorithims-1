#my_tests.sh
java -jar EncoderDecoder.jar e s1.txt s1.out
echo Comparing s1.enc and s1.out ...
diff s1.enc s1.out
read -p "(Pause from testing script) Press Enter to continue ... "

java -jar EncoderDecoder.jar d s1.enc s1.ptx
echo Comparing s1.txt and s1.ptx ...
diff s1.txt s1.ptx
read -p "(Pause from testing script) Press Enter to continue ... "

java -jar EncoderDecoder.jar e s2.txt s2.out
echo Comparing s2.enc and s2.out ...
diff s2.enc s2.out
read -p "(Pause from testing script) Press Enter to continue ... "

java -jar EncoderDecoder.jar d s2.enc s2.ptx
echo Comparing s2.txt and s2.ptx ...
diff s2.txt s2.ptx
read -p "(Pause from testing script) Press Enter to continue ... "

java -jar EncoderDecoder.jar e s3.txt s3.out
echo Comparing s3.enc and s3.out ...
diff s3.enc s3.out
read -p "(Pause from testing script) Press Enter to continue ... "

java -jar EncoderDecoder.jar d s3.enc s3.ptx
echo Comparing s3.txt and s3.ptx ...
diff s3.txt s3.ptx
read -p "(Pause from testing script) Press Enter to continue ... "

java -jar EncoderDecoder.jar e s4.txt s4.out
echo Comparing s4.enc and s4.out ...
diff s4.enc s4.out
read -p "(Pause from testing script) Press Enter to continue ... "

java -jar EncoderDecoder.jar d s4.enc s4.ptx
echo Comparing s4.txt and s4.ptx ...
diff s4.txt s4.ptx
read -p "(Pause from testing script) Press Enter to continue ... "

java -jar EncoderDecoder.jar e s5.txt s5.out
echo Comparing s5.enc and s5.out ...
diff s5.enc s5.out
read -p "(Pause from testing script) Press Enter to continue ... "

java -jar EncoderDecoder.jar d s5.enc s5.ptx
echo Comparing s5.txt and s5.ptx ...
diff s5.txt s5.ptx
read -p "(Pause from testing script) Press Enter to continue ... "




