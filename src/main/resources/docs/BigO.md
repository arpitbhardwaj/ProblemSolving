O(1) < O(log(n)) < O(n) < O(nlog(n)) < O(n pow 2) < O(2 pow n) < O(n factorial)

**Big O Notation:**
*    Upper bound
*    For an algorithm if you say time complexity is O(n)
*    then it means the complexity cannot exceed O(n) means given algorithm can be solved in O(1) or O(log(n) etc.
*    f(n) = O(g(n)) then f(n)≤c.g(n)

**Big Ω Notation:**
*    Lower bound
*    For an algorithm if you say time complexity is Ω(n)
*    then it means the algorithm takes Ω(n), means given algorithm can be solved in Ω(nlog(n)) or Ω(n pow 2) etc.
*    f(n) = O(g(n)) then f(n)≥c.g(n)

**Θ Notation:**
*    Combination of upper and lower bound
*    For an algorithm if you say time complexity is Θ(n)
*    then it means the algorithm upper and lower bounds are Θ(n).

**Little o Notation:**
*    Upper bound (but not strict it's a loose upper bound)
*    f(n) = O(g(n)) then f(n)<c.g(n) means f will be strictly slower then g

**Little Ω Notation:**
* Lower bound (but not strict it's a loose lower bound)
* f(n) = O(g(n)) then f(n)>c.g(n) means f will be strictly greater then g


O(1)        Constant    Accessing a specific element in array

O(LogN)     Logarithmic Find an element in sorted array

O(N)        Linear      Loop through array elements

O(NLogN)     

O(N2)       Quadratic   Looking ar a every index in the array twice

O(2N)       Exponential Double recursion in Fibonacci

O(N!)       Factorial