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
