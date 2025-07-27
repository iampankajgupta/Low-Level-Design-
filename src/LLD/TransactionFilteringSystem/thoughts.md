
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
    
    
    }
    
    
}

     */