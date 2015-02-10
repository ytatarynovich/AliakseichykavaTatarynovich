Implement without frameworks application manages the cinema ticket life cycle. 
Please use transaction design patterns ACID, 
Composite Transaction, 
Two Phase Commit and 
Audit trail pattern. 
The application should have possibilities to be deployed to jboss and build with using maven.



Make a single object responsible for coordinate otherwise independent ACID transactions participating in a composite
transaction so that the composite transaction has the ACID properties.

 The object responsible for the coordination is called the coordinator. 
 The coordinator coordinates the completion of the composite transaction in two phases. First, it determines if each
component transaction has completed it work successfully or not. If any of the component transactions complete unsuccessfully,
then the coordinator causes all of the component transactions to abort. If all of the component transactions complete successfully,
the coordinator causes all of the component transactions to commit their results.


Make sure you have assertions enabled when you run (-ea at the command line)