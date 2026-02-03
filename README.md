===============================================================
Redis String Data Structure :- 
===============================================================

The Redis String type is the simplest type of value you can associate with a Redis key.
String is not the best term for this type because it is used to hold numeric types as well.
Internally it is held as a byte array.
A string is a simple scalar that can hold a
single value or
it can hold an XML or
a JSON document as well
A string value can't be bigger than 512 MB.

===================================
String Commands :-
===================================
SET, SETNX, MSET, MSETNX :---------------------
Set value, Set value if key does not exist, Set multiple values, Set multiple values if none of the keys exist

GET, MGET, GETSET :-------------------
Get value, Get multiple values, Set value, return old value

PSETEX, SETEX :------------------
Set with expiry in seconds and milliseconds

INCR, INCRBY, INCRBYFLOAT :-----------------
Increment integer, Add to integer, Add to float

======================================================
List Data Structure :-
======================================================

A list is just a sequence of ordered elements.
What's the downside? Accessing an element by index is very fast in lists implemented with an Array (constant time indexed access) and not so fast in lists implemented by linked lists (where the operation requires an amount of work proportional to the index of the accessed element).

You can think of list as an array
List are designed in such a way that adding new elements at the end of a list, is really fast.
The downside is that indexing into the list can be slow.
When this is required, Sorted Sets are a better option

========================
List Commands :-
========================
LPUSH, RPUSH :--------------
Add Value at beginning, Add value at the end

LPUSHX, RPUSHX :----------------
Only push if key already exists

LLEN, LRANGE :-----------
Get number of values, Get values from Start to Stop

LINDEX, LSET, LINSERT :------------------
Get a value by index, Set a value by index, Add a value before or after another

LREM, LTRIM :----------------
Delete element from list, Trim list by range

LPOP, RPOP :-----------
Delete and Get the first element, Delete and Get the last element


DECR, DECRBY :-----------
Decrement integer, Subtract from integer

===================================================
Redis Hashes Data Structure :-
===================================================

hashes are useful for representing objects
Hashes contain one or more fields.

============================
Hashes Commands :-
============================

HSET, HSETNX, HMSET :------------------
Set field value, Set field value if field does not exist, Set multiple field values

HGET, HMGET :------------
Get field value, Get multiple field values

HLEN, HKEYS, HVALS, HGETALL :-----------
Get Number of fields, Get all field keys, Get all field values, Get all fields and values

HEXISTS, HDEL :-----------
Check field exists, delete field

HINCRBY, HINCRBYFLOAT :---------
Increment field integer value, Increment field float value


======================================================
Redis Sets Data Structure :-
======================================================

Redis Sets are unordered collections of strings.
They cannot have duplicate values
Sets are good for expressing relations between objects

================================
Sets Commands :-
===============================

SADD, SMOVE, SREM, SPOP :----------------
Add one or more members, Move a member from one set to another, Remove one or more members, Remove and return one or multiple random members

SCARD, SMEMBERS, SISMEMBER, SRANDMEMBER :--------
Get number of members, Get all members, Test if member exists, Get one or more random members

SUNION, SUNIONSTORE :-----------
Get all keys from all sets, no duplicates, same operation but store results in a new key

SINTER, SINTERSTORE :-----------
Get keys that exist in all sets only, same operation but store results in a new key

SDIFF, SDIFFSTORE :----------
Return keys from the first set that are not in the subsequent sets, same operation but store results in a new key
