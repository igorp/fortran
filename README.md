Fortran Notes
======
Fortran is one of the first programming languages ever invented back in 1954 by IBM. Fortran is also faster and more efficient than any other programming language, which makes it well-suited for tasks such as scientific simulations and large-scale numerical modeling. These notes are based on the book *"FORTRAN 77 for Humans"* written by Rex L. Page and Richard L. Didday and published in 1980.

General
-------

- `g95 -o NAME SOURCE.f`      compile source files into executable named NAME
- program code must start on 7th column (for historical reasons)
- comments start with `C`

Arithmetic Expressions
----------------------

- `INTEGER`           standard signed integer, can have +/- in front
- `REAL`              signed floating point numbers, can use scientific notation
                    eg. 6.0123E+23
- `CHARACTER*n`       string of character enclosed by single quotes
                    must specify n, which is length of string when declaring         

Operations
----------

- `PRINT *, list`     prints each of the values in the list of a line
- `READ *, list`      places data into list from the data line (user input)
- `END`               tells the compiler to stop doing statements in program
- Operations are `+`, `-`, `*`, `/`, `**` (last is exponentation)         
- If your line is too long, then put `&` in 6th column of next line:

      PRINT *, 'THIS LONG LINE IS',
      &'CONTINUED HERE'

Loops
-----

- `IF (e1 rel e2) GOTO s`     e1 and e2 are expressions, both of the same type
                    `rel` is relational operator
                    `s` is statement label (line number)
                    decide if relationship is true, if yes proceed to line `s`
- Relational operators:
    `.LT.`            less than
    `.LE.`            less than or equal to
    `.EQ.`            equal to
    `.NE.`            not equal to
    `.GE.`            greater than or equal to
    `.GT.`            greater than
- indent if loop blocks, so starting after `IF` and going until last `GOTO`:

      100  IF (test for exit) GOTO 200
               fortran operation
               .
               .
               GOTO 100
      200 continue program  

- can do while loops (if statement at beginning) or do-while (if statement end) 
- pre-test loops are safer and clearer
- Do loops are like for loops:
    
            INTEGER TOP = 5
            DO 10 N=1, TOP,1
      10    PRINT *, N
    
  Code above loops ten times. After `DO` the first value is line number after
  which the loop goes to the next iteration. `N` is the iterator that increases
  or deacreases, top is ending value and last integer is increment.
- `CONTINUE`          statement that does nothing, used as terminal statement
                    in the range of `DO`-loops
- Nested loops are possible. Note that both line statements point to line 10:

          DO 10 I=1, 10, 1
              DO 10 J=1, 10, 1
      10          PRINT *, I*J
       
Logical operators
-----------------
       
- If-else structure in fortran: 

      IF (test condition) THEN
          fortran operation 1
      ELSE
          fortran operation 2
      ENDIF

- Can also use multiple else-if with `ELSE IF` structure. Add `THEN` after each `ELIF`
- `.EQV.`             equivalence operator, used to compare boolean values
- `.NEQV.`            nonequivalence operator
- May omit `ELSE` in `IF-THEN` statement.
- `LOGICAL`           data type to hold booleans
- Use `INT(x)` to truncate real number `x` or `NINT(x)` to round
- `MOD(x, n)` is modulus operator

Arrays
------

- `INTEGER ARR(n)`    declare an array of length n
- `ARR(1)`            access first element (indexing starts from 1 not 0)
- `MUL(3,3)`          to create 2-dimensional array. first row, then column
- To loop arrays use the following structure (reads 20 ints from user):

          DO 100 I=1,20
              READ *, ARR(I)
      100     CONTINUE            

Character Strings
-----------------

- Substrings can be accessed with `STR(j:k)`. `STR` is string, `j` and `k` are indices
- multiline code can be written with `+` sign in between:
  
      IF (PHRASE .EQ. 'HECK'
      + .OR. PHRASE .EQ. 'DARN')

- when assigning substrings, can't reference same portions eg. `N(1:9) = N(5:15)`
- `INDEX('ABCDEF', 'C')` operator returns 3 as a result. Returns 0 if not found.
-` A = B // C`        concatenates `B` with `C` and stores it in `A`

Subprograms
-----------

- Fortran uses subroutines and functions
- `CALL AVG(a1, a2)`      calls subroutine AVG with arguments a1 and a2
- `SUBROUTINE AVG(a1)`    declaration of subroutine  
- Subroutines must end with `RETURN` and `END statements
- Function returns one value, subroutines can return any number of values
  through it's arguments. Choosing which to use is matter of taste.
- `type FUNCTION f(p1)`   declares function f that takes in one parameter
                        returns variable with name f at RETURN statement
- first write main program, then function/subroutine definitions                        

Line Spacing
------------

- Format `PRINT` statement by replacing `*` by line where `FORMAT` is stated:

          PRINT 10, SNGLSP, 'STRING'            
      10  FORMAT(A,T25, A)        

  This will print the text `STRING` in 25th column.
- `SNGLSP` is carriage control character that can be the following:
  - ` `       move down the page one line before printing
  - `0`       move down two lines
  - `1`       move to the top of next page
  - `+`       overprint previous line
- Looks like `SNGLSP` is not needed when printing to terminal, so this is enough:

          PRINT 10, 'STRING'            
      10  FORMAT(T25, A)        

- Different data descriptors: `A` for chars, `I` for ints, `F` for reals (`I4` or `F6.2`)
 
Files
-----

- `OPEN(speclist)`        open files with this command
- `CLOSE()`               disconnect file
- `READ/WRITE()`          read or write files
