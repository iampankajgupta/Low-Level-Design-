
Learning 
Can use switch or if else during object creation i.e factory pattern and OCP principle would not be violated or it is okay
Can be removed using Map to make OCP compliant

But if Behaviour or business logic used in if else or  switch case then OCP is being violated.

How to make any class OCP Compliant
Create an interface/abstract class and let other implement / extend the behaviour

Liskov Substitution Principle 
if B is a subtype of A then B should be substitutable by A 
basically means depend on abstraction and if creating interface then create/segregate interfaces properly

Ex 
1.Bird with Fly method -> Pigeon is bird it extend then it is ok
2.Ostrich is also a bird but it cannot fly, so here this principle is being violated and when override need to throw some exception as Ostrich cannot fly.

interface Bird.
interface flyable extends Bird
interface nonFlyable extends Bird

Pigeon implements flyable
Ostrich implements method of NonFlyable






Generics 
Wildcards







Build a Transaction Filtering System

My Understanding 

User will perform a transaction and there will be one api which can be used to filter the transaction

Object 

User
Tramsaction
TransactionService -> List<Transaction> 
UserService



User
id 
name
age 
address

Pair
T field
String operator;




Transaction
id : Pair
user : Pair 
merchant - Pair
date - Pair 
amount 
paidType - credit, debit
productId


UserService

List<User> users;

createUser
updateUser
deleteUser

TransactionService
// looks like read Operation would be more 
List<Transaction> = new CopyOnWeriteLi

createTransaction(int id, User user, String merechant, LocalDate date, double amount, PaymentType, int productZId)
updateTransaction()
getAllTransaction(id, user, merchant, date, amount, paymentType, productId)




To make it generic 


    FilterCriteria<T> {
        T field;
        Operator operator
        T value;
    }

? known as Unbound wildcard
List<FilterCriteria<?>> 


public List<Transaction> getFilterTransaction(List<FilterCriteria<?>> filterCriterias) {

    for(FilterCriteria<?> filterCriteria : filterCriteria) {

        // for each filterCriteria Call the operator which
    
    }
    
    
}

     */