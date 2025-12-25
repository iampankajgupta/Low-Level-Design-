User -> done
Group -> done
Expense -> done
Split -> done
SplitType -> 
ExpenseService
GroupService
SplitRequest

User
id
name
groupList: List<Group> // can be lazily loaded bi-directional Mapping and handle using cascading else can get StackOverflow Exception as User -> Group, Group -> User
balanceSheet: BalanceSheet

BalanceSheet
balanceSheetId: Long
totalOwe : double  // this fields can be avoided as we can calculate this from OweGetUserMapping
totalGet : double  // this fields can be avoided as we can calculate this from OweGetUserMapping
totalSpent: double // this fields can be avoided as we can calculate this from OweGetUserMapping
OweGetUserMapping: Map<Long, Double>

Expense
id: Long
description: String
userSplits: List<Split> 
amount: double
splitTye: <enum> SplitType
paidUser: User
groupId: Long // 0 means created for individual


Split
user: User
amount: Double


SplitType
EQUAL
PERCENTAGE

Group
groupId: Long
name: String
description: String
users : List<User>
expenseList: List<Expense>
balanceSheet: BalanceSheet

SplitRequest
name : String
description
paidUser 
userList : List<User>
amount
splitType: <enum> SplitType

UserService
userList: List<Users>
----------------------------

getUserById(userId: Long): User


ExpenseService
expenseList : List<Expense> 

---------------
addExpense(splitRequest: SplitRequest) : Expense 
updateExpense(userId: Long, splitRequest: SplitRequest): Expense
deleteExpense(userId: long, expenseId: long, groupId: long): void

GroupService
expenseService: ExpenseService
expenses: List<Expenses>

-----------------------
addExpense(SplitRequest splitRequest): Expense
updateExpense(userId: long, splitRequest: SplitRequest): Expense;
deleteExpense(user: long, expenseId: long): void


------------------------
SplitTypeDetail

EqualSplitDetail

user: userList

PercentageSplitDetail

userSplitMap: Map<User, Double>

SplitTypeFactory

SplitType
EqualSplit -> process(splitRequest: SplitRequest) and validate method
PercentageSplit -> process(splitRequest: SplitRequest) and validate method


SettlementService

SettleStrategy:<interface>
settle(): void

IndividualSettlement
expenseId: Long
user: User
individualSettlement(user: User, expenseId): void


GroupSettlement
expenseId: Long
user: User
groupId: Long
groupSettlement(user: User, expenseId, groupId: Long) : void


Minimise the Number of transaction


Expense Flow

User -> Select the type of Expense to be created -> fill all the details and create Expense -> 
Once the expense is being created -> Update the balanceSheet of people involved.





