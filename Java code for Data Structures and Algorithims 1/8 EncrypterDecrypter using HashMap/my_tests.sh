java -jar EncrypterDecrypter.jar e sample1.txt sample1.enc "Police investigating 10 suspicious packages"
read -p "(Pause from testing script) Press Enter to continue ... "

java -jar EncrypterDecrypter.jar d sample1.enc sample1.dec "Police investigating 10 suspicious packages"
read -p "(Pause from testing script) Press Enter to continue ... "
diff sample1.txt sample1.dec

java -jar EncrypterDecrypter.jar e sample2.txt sample2.enc "Police investigating 10 suspicious packages"
read -p "(Pause from testing script) Press Enter to continue ... "

java -jar EncrypterDecrypter.jar d sample2.enc sample2.dec "Police investigating 10 suspicious packages"
read -p "(Pause from testing script) Press Enter to continue ... "
diff sample2.txt sample2.dec

java -jar EncrypterDecrypter.jar e sample3.txt sample3.enc "Police investigating 10 suspicious packages"
read -p "(Pause from testing script) Press Enter to continue ... "

java -jar EncrypterDecrypter.jar d sample3.enc sample3.dec "Police investigating 10 suspicious packages"
read -p "(Pause from testing script) Press Enter to continue ... "
diff sample3.txt sample3.dec

java -jar EncrypterDecrypter.jar e gettysburg.txt gettysburg.enc "Police investigating 10 suspicious packages"
read -p "(Pause from testing script) Press Enter to continue ... "

java -jar EncrypterDecrypter.jar d gettysburg.enc gettysburg.dec "Police investigating 10 suspicious packages"
read -p "(Pause from testing script) Press Enter to continue ... "
diff gettysburg.txt gettysburg.dec
