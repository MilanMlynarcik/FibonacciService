Instructions to Run:

1.Drop ds.war into Apache webapps directory
2.Start RMI Service by executing: java -cp crypto.jar ie.gmit.FibService from the folder with crypto.jar
3.point your browser to http://localhost:8080/ds/



Main Features:

1.RMI service computing Fibonacci Numbers
2.Client polling server every 10s with ajax JSON  call to servlet expecting JSON in response, displaying result or call again 
3.Timer Class set to 10s intervals to retrieve jobs from inQueue, send then remote Service and put the result to outQueue
4. Servlet to manage requests(return Jobnumber to client) and call Fibservice class to check if sequence was already computed
================
