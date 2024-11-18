// --- EVALUATION RULES ---
def example1 = 3                    // evaluated when called
val example2 = 2                    // evaluated immediately
lazy val example3 = 2               // evaluated once when needed

def squareByValue(x: Double): Unit = ???     // call by value
def squareByName(x: => Double): Unit = ???    // call by name
def myFct(binding: Int*) = ???


// --- HIGHER ORDER FUNCTIONS ---
// sum() takes a function that takes an integer and returns an integer then
// returns a function that takes two integers and returns an integer
def sum1(f: Int => Int): (Int, Int) => Int = 
    def sumf(a: Int, b: Int): Int = f(a) + f(b)
    sumf

// Same as above: it's type is (Int => Int) => (Int, Int) => Int
def sum2(f: Int => Int)(a: Int, b: Int): Int = ???

// Called like this
// sum1((x: Int) => x * x * x)          // Anonymous function, i.e., is does not have a nem
// sum2(x => x * x * x)                 // Also anonymous function with type inference

def cube(x: Int) = 
    x * x * x
// sum1(x => x * x * x)(1, 10)          // Sum of 1 cubed and 10 cubed   
// sum(cube)(1, 10)                     // Same as above


// --- CURRYING ---
// Name for converting a function with multiple arguments into a function with a single
// argument that returns another function
def f = ???
val f2: (Int, Int) => Int = f           // uncurried version
val f3: Int => Int => Int = f2.curried  // curried version
val f4: (Int, Int) => Int = Function.uncurried(f3)      // back to the uncurried version


// --- CLASSES ---
class MyClass(x: Int, val y: Int, var z: Int):     
    // 'x' is private, 'y' is public but immutable and 'z' is public and mutable, i.e., it has a getter and a setter
    require(y < 0, "y must be negative")
    def this(x: Int) = 
        this(x, (x * x), (x * x * x))

    def nb1 = x                         // computed every time its called
    private def test(a: Int): Int = ???
    val nb3 = x + y                     // computed only once

    override def toString = 
        x + ", " + y
end MyClass                             // explicit declaration of body end

val class1 = new MyClass(1, 2, 3)


// --- OPERATORS ---
// myObject myMethod 1 == myObject.myMethod(1)


// --- CLASS HIERARCHIES ---
abstract class TopLevel:
    def method1(x: Int): Int                // abstract method
    def method2(x: Int): Int = x * x        // method with implementation
end TopLevel

class Level1 extends TopLevel:
    def method1(x: Int): Int = x * x * x
    override def method2(x: Int): Int = ???
end Level1

// object MyObject extends TopLevel:
//     ???                                     // singleton object. No other instance can be created


// --- TYPE PARAMETERS ---
class MyClass2[T](arg1: T):
    ???
end MyClass2

val t1 = new MyClass2[Int](1)               
val t2 = new MyClass2(1)                    // type inference

def myFct2[T <: TopLevel](arg: T): T = ???              // must derive from TopLevel or be TopLevel
def myFct3[T >: Level1](arg: T): T = ???                // must be a supertype of Level1
def myFct4[T >: Level1 <: TopLevel](arg: T): T = ???


// --- PATTERN MATCHING ---
// (someList: List[T]) match
//     case Nil => ???                 // empty list
//     case x :: Nil => ???            // list with only one element
//     case List(x) => ???             // ||    ||   ||   ||   ||
//     case x :: xs => ???             // list wiht at least 1 element where x is the beggining and xs is the tail
//     case 1 :: 2 :: cs => ???        // list that starts with 1 and then 2 
//     case (x, y) :: ps => ???        // list where the head is a pair
//     case _ => ???                   // default case

// - Options -
val myMap = Map("a" -> 42, "b" -> 43)
def getMapValue(s: String): String =
    myMap get s match
        case Some(nb) => ("Value found: " + nb)
        case None => "No value found"

def getMapValue2(s: String): String = 
    myMap.get(s).map("Value found: " + _).getOrElse("No value found")

val a1 = getMapValue("a")  // returns "Value found: 42"
val a2 = getMapValue("c")  // returns "No value found"

// - P.M. in Anonymous Functions -
val pairs = "adddbdddc"
val options: List[Option[Char]] = Some('a') :: None :: Some('b') :: Nil
// val chars: List[Char] = pairs.map(p => p match {
//     case Some(ch) => ch
//     case None => 'z'
// })


// --- COLLECTIONS ---
class CollectionTest:
    val fruitList = List("apples", "oranges", "pears")
    // Alternative syntax for lists
    val fruit = "apples" :: ("oranges" :: ("pears" :: Nil)) // parens optional, :: (pronounced cons) is right-associative
    fruit.head   // "apples"
    fruit.tail   // List("oranges", "pears")
    val empty = List()
    // val empty = Nil

    val nums = Vector("louis", "frank", "hiromi")
    nums(1)                     // element at index 1, returns "frank", complexity O(log(n))
    nums.updated(2, "helena")   // new vector with a different string at index 2, complexity O(log(n))

    val fruitSet = Set("apple", "banana", "pear", "banana")
    fruitSet.size    // returns 3: there are no duplicates, only one banana

    val r: Range = 1 until 5 // 1, 2, 3, 4
    val s1: Range = 1 to 5    // 1, 2, 3, 4, 5
    1 to 10 by 3  // 1, 4, 7, 10
    6 to 1 by -2  // 6, 4, 2

    val set1 = (1 to 6).toSet
    set1.map(_ + 2) // adds 2 to each element of the set

    val s2 = "Hello World"
    s2.filter(c => c.isUpper) // returns "HW"; strings can be treated as Seq[Char]

    // Just to remove errors
    val n = ???       // temp
    val x = ???       // temp
    val ys = ???       // temp
    val p = ???       // temp
    val op = ???       // temp
    val z = ???       // temp
    val x1 = ???       // temp
    val xn = ???       // temp

    // Operations on sequences
    val xs = List(???)
    xs.length         // number of elements, complexity O(n)
    xs.last           // last element (exception if xs is empty), complexity O(n)
    xs.init           // all elements of xs but the last (exception if xs is empty), complexity O(n)
    xs.take(n)        // first n elements of xs
    xs.drop(n)        // the rest of the collection after taking n elements
    xs.splitAt(n)     // same as (xs take n, xs drop n)
    xs(n)             // the nth element of xs, complexity O(n)
    xs ++ ys          // concatenation, complexity O(n)
    xs.reverse        // reverse the order, complexity O(n)
    xs.updated(n, x)  // same list than xs, except at index n where it contains x, complexity O(n)
    xs.indexOf(x)     // the index of the first element equal to x (-1 otherwise)
    xs.contains(x)    // same as xs indexOf x >= 0
    xs.filter(p)      // returns a list of the elements that satisfy the predicate p
    xs.filterNot(p)   // filter with negated p
    xs.partition(p)   // same as (xs filter p, xs filterNot p)
    xs.takeWhile(p)   // the longest prefix consisting of elements that satisfy p
    xs.dropWhile(p)   // the remainder of the list after any leading element satisfying p have been removed
    xs.span(p)        // same as (xs takeWhile p, xs dropWhile p)

    List(x1, xn).reduceLeft(op)   // (...(x1 op x2) op x3) op ...) op xn
    List(x1, xn).foldLeft(z)(op)  // (...( z op x1) op x2) op ...) op xn
    List(x1, xn).reduceRight(op)  // x1 op (... (x{n-1} op xn) ...)
    List(x1, xn).foldRight(z)(op) // x1 op (... (    xn op  z) ...)

    xs.exists(p)   // true if there is at least one element for which predicate p is true
    xs.forall(p)   // true if p(x) is true for all elements
    xs.zip(ys)     // returns a list of pairs which groups elements with same index together
    xs.unzip       // opposite of zip: returns a pair of two lists
    xs.flatMap(f)  // applies the function to all elements and concatenates the result
    // xs.sum         // sum of elements of the numeric collection
    // xs.product     // product of elements of the numeric collection
    // xs.max         // maximum of collection
    // xs.min         // minimum of collection
    xs.flatten     // flattens a collection of collection into a single-level collection
    xs.groupBy(f)  // returns a map which points to a list of elements
    xs.distinct    // sequence of distinct entries (removes duplicates)

    x +: xs  // creates a new collection with leading element x
    xs :+ x  // creates a new collection with trailing element x

    // Operations on maps
    val myMap2 = Map("I" -> 1, "V" -> 5, "X" -> 10)  // create a map
    myMap2("I")      // => 1
    myMap2("A")      // => java.util.NoSuchElementException
    myMap2.get("A")  // => None
    myMap2.get("I")  // => Some(1)
    myMap2.updated("V", 15)  // returns a new map where "V" maps to 15 (entry is updated)
                            // if the key ("V" here) does not exist, a new entry is added

    // Operations on LazyLists
    val xs1 = LazyList(1, 2, 3)
    val xs2 = LazyList.cons(1, LazyList.cons(2, LazyList.cons(3, LazyList.empty))) // same as above
    (1 to 1000).to[LazyList[Int]] // => Stream(1, ?)
    x #:: xs1 // Same as LazyList.cons(x, xs)
                // In the LazyList's cons operator, the second parameter (the tail)
                // is defined as a "call by name" parameter.
                // Note that x::xs always produces a List
    def integers(start: Int = 0): LazyList[Int] = start #:: integers(start + 1) // infinite sequence of integers starting at "start"
    integers(0).drop(10).take(100) // New lazylist starting at 10