# ICE
Operating System: Windows 10
Server: Tomcat 7.0
Front End : JSP, JSTL, HTML
Language Used: Java Servlets
My Sql :My SQL 5.7 Command Line Client

Dependencies:

1) Create the following Environment Variables:

CATALINA_HOME - location of ur tomcat folder (ex: C:\documents\tomcat)
CLASS_PATH - C:\Users\Documents\tomcat\lib\servlet-api.jar;C:\Users\Documents\tomcat\lib\jsp-api.jar;
             C:\Users\Documents\tomcat\webapps\StockQuotes\WEB-INF\lib\json-simple-1.1.1.jar;C:\Users\Documents\tomcat                           \webapps\StockQuotes\WEB-INF\classes;C:\Program Files\MySQL\MySQL Server 5.7\bin(All based on where you store the jars)
JAVA_HOME -  C:\Program Files\Java\jdk1.8.0_65

2) i)Create a stocks database in my Sql command line (create database stocks;)
   ii) use it (use stocks;)
   iii) Create a stocksymbols table(create table stocksymbols(symbol varchar(25) primary key not null);)

Running the Application:

1) Open cmd
2) go to(cd) \tomcat\bin folder
3) Type 'startup' and click enter
4) Go to http://localhost:8080/StockQuotes/index.jsp in your browser while ur server is running.



