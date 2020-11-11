# CaseStudy2-ATM

## Rules to follow for execution : 
Use these commands in the main directory - 

>javac CaseStudy2.java


Then use this command for Windows :


>java -classpath ".;sqlite-jdbc-3.32.3.2.jar" CaseStudy2


Or use this command for MacOS and Linux :


>java -classpath ".:sqlite-jdbc-3.32.3.2.jar" CaseStudy2 


You can follow this link to the official documentation : [Xerial](https://github.com/xerial/sqlite-jdbc/blob/master/README.md)

For Plagiarism : I followed the above documentation to implement SQLite Database since I am doing it for the first time. And I also followed this website to know [more about SQLite](https://www.sqlitetutorial.net/sqlite-update/)

The two files used for database are : './BankCustomers.db' and './AllBankCustomers.db' and the way in which this is stored is present in a text file './Database/Bank_and_All_Database.txt'

I have implemented ATM class where the menu driven program is located.
Other than this I have implemented a databaseinterface which is implemented by BankDatabase and AllDatabase class.
The last class is Customer Class representing a customer.

The Password to dissolve the bank (terminate the program) is : GOD

You can also view [my repository](https://github.com/sgr98/CaseStudy2-ATM) at this link. 

For GUI : I used javax.swing and I referred to several websites to know how the basic syatax and methods function. Hence in many places I have just copied the code and try to mold it accourding to my needs. The sites I have refered to are [The website you provided](https://beginnersbook.com/2015/07/java-swing-tutorial/), [StackOverflow](https://stackoverflow.com/questions/21879243/how-to-create-on-click-event-for-buttons-in-swing), [Code Academy](https://discuss.codecademy.com/t/simple-username-password-validation-problem/304247), [Tutorials Point](https://www.tutorialspoint.com/what-is-the-use-of-setbounds-method-in-java), [Learning About Electronics](http://www.learningaboutelectronics.com/Articles/How-to-check-if-a-button-is-clicked-in-Java-swing.php#:~:text=We%20create%20a%20method%20actionPerformed,button%20is%20clicked%20using%20Java.) and various other sites.

Made some updates to the database.
Also deleted the BankDatabase.

### Caution: 
After a few runs the swing window is becomig extremely slow and always repeating a process multiple times. I do not know its cause. I might be causing it because I do know how exactly it works. Personally I like the modern method where you can dag and drop and set its xml attributes, the way that had been done in Android Studio and how you are able to add a function to onClick and change AppComp.


The decided rate for charging other ATM cards is 2%.

