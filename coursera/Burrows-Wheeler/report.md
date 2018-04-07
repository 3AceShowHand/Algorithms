See the Assessment Guide for information on how to interpret this report.

ASSESSMENT SUMMARY

Compilation:  PASSED
API:          PASSED

Findbugs:     PASSED
PMD:          PASSED
Checkstyle:   FAILED (0 errors, 4 warnings)

Correctness:  17/64 tests passed
Memory:       10/10 tests passed
Timing:       100/159 tests passed

Aggregate score: 48.52%
[Compilation: 5%, API: 5%, Findbugs: 0%, PMD: 0%, Checkstyle: 0%, Correctness: 60%, Memory: 10%, Timing: 20%]

ASSESSMENT DETAILS

The following files were submitted:
----------------------------------
2.5K Apr  7 10:56 BurrowsWheeler.java
1.7K Apr  7 10:56 CircularSuffixArray.java
2.1K Apr  7 10:56 MoveToFront.java


********************************************************************************
*  COMPILING                                                                    
********************************************************************************


% javac CircularSuffixArray.java
*-----------------------------------------------------------

% javac BurrowsWheeler.java
*-----------------------------------------------------------

% javac MoveToFront.java
*-----------------------------------------------------------


================================================================


Checking the APIs of your programs.
*-----------------------------------------------------------
CircularSuffixArray:

BurrowsWheeler:

MoveToFront:

================================================================


********************************************************************************
*  CHECKING STYLE AND COMMON BUG PATTERNS                                       
********************************************************************************


% findbugs *.class
*-----------------------------------------------------------


================================================================


% pmd .
*-----------------------------------------------------------


================================================================


% checkstyle *.java
*-----------------------------------------------------------
[WARN] CircularSuffixArray.java:6:19: Use the primitive type instead of the corresponding wrapper type 'Integer'. For example, use 'boolean' instead of 'Boolean'. [WrapperType]
[WARN] CircularSuffixArray.java:34:28: Use the primitive type instead of the corresponding wrapper type 'Integer'. For example, use 'boolean' instead of 'Boolean'. [WrapperType]
[WARN] CircularSuffixArray.java:34:39: Use the primitive type instead of the corresponding wrapper type 'Integer'. For example, use 'boolean' instead of 'Boolean'. [WrapperType]
Checkstyle ends with 0 errors and 3 warnings.

% custom checkstyle checks for CircularSuffixArray.java
*-----------------------------------------------------------

% custom checkstyle checks for BurrowsWheeler.java
*-----------------------------------------------------------
[WARN] BurrowsWheeler.java:44:20: You will probably not meet the performance requirement for 'inverseTransform()' if you call 'Arrays.sort()'. [Performance]
Checkstyle ends with 0 errors and 1 warning.

% custom checkstyle checks for MoveToFront.java
*-----------------------------------------------------------


================================================================


********************************************************************************
*  TESTING CORRECTNESS
********************************************************************************

Testing correctness of CircularSuffixArray
*-----------------------------------------------------------
Running 15 total tests.

Test 1: check index() and length() with random binary strings
  * length = 10
  * length = 100
  * length = 1000
==> passed

Test 2: check index() and length() with random uppercase strings
  * length = 10
  * length = 100
  * length = 1000
==> passed

Test 3: check index() and length() with random ASCII strings
  * length = 10
  * length = 100
  * length = 1000
==> passed

Test 4: check index() and length() with random extended ASCII strings
  * length = 10
  * length = 100
  * length = 1000
==> passed

Test 5: check index() and length() with strings from text files
  * cadabra.txt
  * amendments.txt
  * moby1.txt
  * dickens1000.txt
==> passed

Test 6: check index() and length() with strings from binary files
  * us.gif
  * CS_bricks.jpg
  * rand1K.bin
==> passed

Test 7: check index() and length() with random strings of length 0, 1, and 2
  * length = 0
  * length = 1
  * length = 2
==> passed

Test 8: check that index() throws an exception when argument is out of bounds
  * string of length 10
  * string of length 100
  * string of length 2
  * string of length 1
  * string of length 0
==> passed

Test 9: check that constructor throws an exception when argument is null
==> passed

Test 10: check that two CircularSuffixArray objects can be created at the same time
  * cadabra.txt and amendments.txt
  * amendments.txt and cadabra.txt
  * dickens1000.txt and cadabra.txt
==> passed

Test 11: check that CircularSuffixArray is immutable
  * string = "ZYXLRMDNGTNLPNHVCDGMYMOOHHFZSL"
  * string = "BAABABBBBBAAAABABAAABBABBBBABB"
  * string = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"
  * string = hex representation: b8 41 e5 fb d8 6d 18 dc 4d 1f fa 63 7a 8f d4 
==> passed

Test 12: check index() and length() with corner-case strings
  * a.txt
  * nomatch.txt
  * zebra.txt
  * alphanum.txt
==> passed

Test 13: check index() and length() with strings that are nontrivial circular
         that are nontrivial circular suffixes of themselves
  * stars.txt
  * couscous.txt
==> passed

Test 14: check index() and length() with unary strings
  * length 10 string over unary alphabet
  * length 100 string over unary alphabet
  * length 1000 string over unary alphabet
==> passed

Test 15: check index() and length() with random strings
         that are nontrivial circular suffixes of themselves
  * length 2 string over binary alphabet, repeated 2 times
  * length 2 string over binary alphabet, repeated 10 times
  * length 5 string over binary alphabet, repeated 2 times
  * length 5 string over binary alphabet, repeated 3 times
  * length 5 string over binary alphabet, repeated 5 times
  * length 7 string over uppercase alphabet, repeated 2 times
  * length 7 string over uppercase alphabet, repeated 3 times
  * length 7 string over uppercase alphabet, repeated 5 times
==> passed

Total: 15/15 tests passed!


================================================================
Testing correctness of MoveToFront
*-----------------------------------------------------------
Running 23 total tests.

Test 1a: check main() on text files
  * java MoveToFront - < abra.txt
    - entry 8 of the two sequences are not equal
    - student   entry = 06
    - reference entry = 04
    - student:   41 42 52 02 44 01 45 01 06 06 02 2c 
    - reference: 41 42 52 02 44 01 45 01 04 04 02 26 

  * java MoveToFront - < zebra.txt
    - entry 4 of the two sequences are not equal
    - student   entry = 64
    - reference entry = 65
    - student:   7a 66 64 73 64 
    - reference: 7a 66 64 73 65 

  * java MoveToFront - < amendments.txt
    - entry 12 of the two sequences are not equal
    - student   entry = ff
    - reference entry = 4a
    - student:   41 72 74 6b 66 6e 69 27 4f .. 04 1a 07 02 05 01 53 ff 25 
    - reference: 41 72 74 6b 66 6e 69 27 4f .. 04 0a 06 02 04 01 14 1b 0f 

  * java MoveToFront - < aesop.txt
    - entry 7 of the two sequences are not equal
    - student   entry = 27
    - reference entry = 26
    - student:   41 65 73 70 71 2c 03 27 4b .. 22 05 12 10 1c 02 ff ff 1f 
    - reference: 41 65 73 70 71 2c 03 26 4a .. 10 05 0b 0b 0f 02 36 1c 11 

==> FAILED

Test 1b: check main() on text files
  * java MoveToFront + < abra.txt.mtf
    - entry 8 of the two sequences are not equal
    - student   entry = 41
    - reference entry = 42
    - student:   41 42 52 41 43 41 44 41 41 41 41 1e 
    - reference: 41 42 52 41 43 41 44 41 42 52 41 21 

  * java MoveToFront + < zebra.txt.mtf
    - entry 4 of the two sequences are not equal
    - student   entry = 62
    - reference entry = 61
    - student:   7a 65 62 72 62 
    - reference: 7a 65 62 72 61 

  * java MoveToFront + < amendments.txt.mtf
    - entry 12 of the two sequences are not equal
    - student   entry = 44
    - reference entry = 43
    - student:   41 72 74 69 63 6c 65 20 49 .. 6e 6e 6e 6e 6e 1f 1f 6e 1f 
    - reference: 41 72 74 69 63 6c 65 20 49 .. 65 72 76 65 6e 65 64 2e 0a 

  * java MoveToFront + < aesop.txt.mtf
    - entry 7 of the two sequences are not equal
    - student   entry = 1f
    - reference entry = 20
    - student:   41 65 73 6f 70 27 73 1f 45 .. 52 77 52 77 52 52 52 52 77 
    - reference: 41 65 73 6f 70 27 73 20 46 .. 72 20 73 75 6e 73 3f 22 0a 

==> FAILED

Test 2a: check that main() is consistent with encode() on text files
  * abra.txt
  * zebra.txt
  * amendments.txt
  * aesop.txt
==> passed

Test 2b: check that main() is consistent with decode() on text files
  * abra.txt.mtf
  * zebra.txt.mtf
  * amendments.txt.mtf
  * aesop.txt.mtf
==> passed

Test 3a: check encode() on text files
  * abra.txt
    - entry 8 of the two sequences are not equal
    - student   entry = 06
    - reference entry = 04
    - student:   41 42 52 02 44 01 45 01 06 06 02 2c 
    - reference: 41 42 52 02 44 01 45 01 04 04 02 26 

  * zebra.txt
    - entry 4 of the two sequences are not equal
    - student   entry = 64
    - reference entry = 65
    - student:   7a 66 64 73 64 
    - reference: 7a 66 64 73 65 

  * amendments.txt
    - entry 12 of the two sequences are not equal
    - student   entry = ff
    - reference entry = 4a
    - student:   41 72 74 6b 66 6e 69 27 4f .. 04 1a 07 02 05 01 53 ff 25 
    - reference: 41 72 74 6b 66 6e 69 27 4f .. 04 0a 06 02 04 01 14 1b 0f 

  * aesop.txt
    - entry 7 of the two sequences are not equal
    - student   entry = 27
    - reference entry = 26
    - student:   41 65 73 70 71 2c 03 27 4b .. 22 05 12 10 1c 02 ff ff 1f 
    - reference: 41 65 73 70 71 2c 03 26 4a .. 10 05 0b 0b 0f 02 36 1c 11 

  * stars.txt
  * alphanum.txt
  * a.txt
==> FAILED

Test 3b: check encode() on binary files
  * us.gif
    - entry 11 of the two sequences are not equal
    - student   entry = 08
    - reference entry = 09
    - student:   47 49 48 3b 3c 61 8e 08 00 .. d5 1e ff 99 ff ff ff 00 ff 
    - reference: 47 49 48 3b 3c 61 8e 08 00 .. c3 1b 84 88 d3 d6 f3 00 77 

  * CS_bricks.jpg
    - entry 3 of the two sequences are not equal
    - student   entry = e3
    - reference entry = e2
    - student:   ff d9 01 e3 04 1a 49 7c 6e .. ff 03 03 02 ff 03 dd ff 7a 
    - reference: ff d9 01 e2 03 19 48 7b 6d .. 03 03 03 03 03 03 79 19 10 

  * rand10K.bin
    - entry 14 of the two sequences are not equal
    - student   entry = 58
    - reference entry = 59
    - student:   1a de 9e f2 76 00 11 0b e2 .. 88 55 b0 d2 7b a3 25 8a 0d 
    - reference: 1a de 9e f2 76 00 11 0b e2 .. 81 4f a3 46 76 9a 27 83 0f 

==> FAILED

Test 3c: check encode() on random inputs
  * 10 random characters from { A } alphabet
  * 10 random characters from { A, B } alphabet
  * 10 random characters from { A, T, C, G } alphabet
    - entry 8 of the two sequences are not equal
    - student   entry = 47
    - reference entry = 45
    - student:   47 00 42 54 02 00 00 01 47 00 
    - reference: 47 00 42 54 02 00 00 01 45 00 

    - failed on trial 3 of 100
    - input = 'GGATGGGTCC'

  * 10 random characters from uppercase letter alphabet
    - entry 7 of the two sequences are not equal
    - student   entry = 57
    - reference entry = 58
    - student:   48 52 57 5a 4b 5a 59 57 53 56 
    - reference: 48 52 57 5a 4b 5a 59 58 53 57 

    - failed on trial 1 of 100
    - input = 'HRWZGYVTMQ'

  * 1000 random characters from { A } alphabet
  * 1000 random characters from { A, B } alphabet
  * 1000 random characters from { A, T, C, G } alphabet
    - entry 7 of the two sequences are not equal
    - student   entry = ff
    - reference entry = 44
    - student:   47 54 45 01 01 01 01 ff 02 .. 06 03 00 00 00 02 01 01 00 
    - reference: 47 54 45 01 01 01 01 44 02 .. 03 03 00 00 00 02 01 01 00 

    - failed on trial 1 of 100

  * 1000 random characters from uppercase letter alphabet
    - entry 5 of the two sequences are not equal
    - student   entry = ff
    - reference entry = 52
    - student:   49 58 01 51 59 ff 47 4e ff .. 02 13 05 37 10 0a 24 46 01 
    - reference: 49 58 01 51 59 52 46 4e 4d .. 02 0d 04 16 0b 08 12 17 01 

    - failed on trial 1 of 100

==> FAILED

Test 3d: check encode() on more random inputs
  * 1000 random characters from ASCII alphabet 
    - entry 14 of the two sequences are not equal
    - student   entry = 17
    - reference entry = 18
    - student:   55 37 62 4e 5b 1f 75 16 25 .. 52 06 61 ff 07 ff ff ff 12 
    - reference: 55 37 62 4e 5b 1f 75 16 25 .. 58 06 47 58 07 4f 69 5f 13 

    - failed on trial 1 of 100

  * 1000 random characters from extended ASCII alphabet
    - entry 4 of the two sequences are not equal
    - student   entry = 43
    - reference entry = 42
    - student:   ad 97 9f 02 43 b1 bd 4c 30 .. ff 09 49 d2 62 b4 ff f4 81 
    - reference: ad 97 9f 02 42 b1 bd 4b 2f .. ac 0a 4c b2 67 97 81 e7 7a 

    - failed on trial 1 of 100

  * 1000 random characters from extended ASCII alphabet (excluding 0x00)
    - entry 6 of the two sequences are not equal
    - student   entry = ff
    - reference entry = 2f
    - student:   d9 2c 30 da fe 0f ff 51 e0 .. ff c6 81 ff ff ff ad ff 0e 
    - reference: d9 2c 30 da fe 0f 2f 51 e0 .. 66 b9 81 f5 7e 73 68 ee 0e 

    - failed on trial 1 of 100

  * 1000 random characters from extended ASCII alphabet (excluding 0xFF)
    - entry 15 of the two sequences are not equal
    - student   entry = 0d
    - reference entry = 0e
    - student:   f4 33 e3 9c 9f 65 95 24 08 .. ff 74 26 52 26 ff ff 66 62 
    - reference: f4 33 e3 9c 9f 65 95 24 08 .. f4 77 25 55 25 e2 e3 6c 67 

    - failed on trial 1 of 100

==> FAILED

Test 4a: check decode() on move-to-front-encoded text files
  * abra.txt.mtf
    - entry 8 of the two sequences are not equal
    - student   entry = 41
    - reference entry = 42
    - student:   41 42 52 41 43 41 44 41 41 41 41 1e 
    - reference: 41 42 52 41 43 41 44 41 42 52 41 21 

  * zebra.txt.mtf
    - entry 4 of the two sequences are not equal
    - student   entry = 62
    - reference entry = 61
    - student:   7a 65 62 72 62 
    - reference: 7a 65 62 72 61 

  * amendments.txt.mtf
    - entry 12 of the two sequences are not equal
    - student   entry = 44
    - reference entry = 43
    - student:   41 72 74 69 63 6c 65 20 49 .. 6e 6e 6e 6e 6e 1f 1f 6e 1f 
    - reference: 41 72 74 69 63 6c 65 20 49 .. 65 72 76 65 6e 65 64 2e 0a 

  * aesop.txt.mtf
    - entry 7 of the two sequences are not equal
    - student   entry = 1f
    - reference entry = 20
    - student:   41 65 73 6f 70 27 73 1f 45 .. 52 77 52 77 52 52 52 52 77 
    - reference: 41 65 73 6f 70 27 73 20 46 .. 72 20 73 75 6e 73 3f 22 0a 

  * stars.txt.mtf
  * alphanum.txt.mtf
  * a.txt.mtf
==> FAILED

Test 4b: check decode() on move-to-front encoded binary files
  * us.gif.mtf
    - entry 11 of the two sequences are not equal
    - student   entry = 01
    - reference entry = 00
    - student:   47 49 46 38 39 61 8e 01 01 .. 92 73 96 73 cc 96 31 31 31 
    - reference: 47 49 46 38 39 61 8e 01 01 .. 7f 03 1e 38 cc 41 00 00 3b 

  * CS_bricks.jpg.mtf
    - entry 3 of the two sequences are not equal
    - student   entry = e0
    - reference entry = e1
    - student:   ff d8 ff e0 ff 14 43 76 67 .. bc f4 b9 ef bc f4 bc f4 ef 
    - reference: ff d8 ff e1 00 16 45 78 69 .. 46 8d 01 a3 46 8d 07 ff d9 

  * rand10K.bin.mtf
    - entry 14 of the two sequences are not equal
    - student   entry = 51
    - reference entry = 50
    - student:   1a de 9d f2 73 73 0c 05 e1 .. c4 33 6a 2a 2a 2a c3 c4 ea 
    - reference: 1a de 9d f2 73 73 0c 05 e1 .. 46 04 ae 11 4f d4 bc 2d b4 

==> FAILED

Test 4c: check decode() on random inputs
  * 10 random characters from { A } alphabet
    - entry 2 of the two sequences are not equal
    - student   entry = 40
    - reference entry = 3f
    - student:   41 40 40 40 40 40 40 40 40 40 
    - reference: 41 40 3f 3e 3d 3c 3b 3a 39 38 

    - failed on trial 1 of 2
    - input = 'AAAAAAAAAA'

  * 10 random characters from { A, B } alphabet
    - entry 2 of the two sequences are not equal
    - student   entry = 41
    - reference entry = 40
    - student:   42 41 41 41 3f 41 3e 41 3c 41 
    - reference: 42 41 40 3f 3d 3e 3b 3c 39 3a 

    - failed on trial 1 of 100
    - input = 'BBBBABABAB'

  * 10 random characters from { A, T, C, G } alphabet
    - entry 4 of the two sequences are not equal
    - student   entry = 3e
    - reference entry = 3d
    - student:   47 42 46 40 3e 46 46 54 53 42 
    - reference: 47 42 46 40 3d 45 44 54 53 3f 

    - failed on trial 1 of 100
    - input = 'GCGCAGGTTG'

  * 10 random characters from uppercase letter alphabet
    - entry 6 of the two sequences are not equal
    - student   entry = 3f
    - reference entry = 3e
    - student:   47 59 49 5a 3f 58 3f 4d 52 54 
    - reference: 47 59 49 5a 3f 58 3e 4d 52 54 

    - failed on trial 2 of 100
    - input = 'GYJZCZDPUW'

  * 1000 random characters from { A } alphabet
    - entry 2 of the two sequences are not equal
    - student   entry = 40
    - reference entry = 3f
    - student:   41 40 40 40 40 40 40 40 40 .. 40 40 40 40 40 40 40 40 40 
    - reference: 41 40 3f 3e 3d 3c 3b 3a 39 .. 40 3f 3e 3d 3c 3b 3a 39 38 

    - failed on trial 1 of 100

  * 1000 random characters from { A, B } alphabet
    - entry 2 of the two sequences are not equal
    - student   entry = 41
    - reference entry = 40
    - student:   42 41 41 3f 41 41 3e 3e 3e .. 3f 3e 3f 3e 3e 3f 3f 3e 3e 
    - reference: 42 41 40 3e 3f 3d 3b 3a 39 .. 10 04 06 0a 18 09 42 0b 03 

    - failed on trial 1 of 100

  * 1000 random characters from { A, T, C, G } alphabet
    - entry 2 of the two sequences are not equal
    - student   entry = 53
    - reference entry = 52
    - student:   54 53 53 45 40 3e 3e 53 53 .. 30 1d 3b 3b 30 1d 3b 3b 3b 
    - reference: 54 53 52 44 3f 3c 3b 51 50 .. 0d 3f 4c 49 1e 2c 4a 38 12 

    - failed on trial 1 of 100

  * 1000 random characters from uppercase letter alphabet
    - entry 4 of the two sequences are not equal
    - student   entry = 41
    - reference entry = 40
    - student:   50 57 4c 42 41 48 58 54 4d .. 0e 1d 0e 10 4d 1d 33 0e 1d 
    - reference: 50 57 4c 42 40 48 58 54 4d .. 02 41 5a 3f 11 08 4d 4b 55 

    - failed on trial 1 of 100

==> FAILED

Test 4d: check decode() on more random inputs
  * 1000 random characters from ASCII alphabet 
    - entry 16 of the two sequences are not equal
    - student   entry = 21
    - reference entry = 1f
    - student:   69 08 3b 71 6d 20 50 25 2d .. 25 13 2d 12 55 12 12 55 12 
    - reference: 69 08 3b 71 6d 20 50 25 2d .. 76 16 5f 10 60 7d 10 07 69 

    - failed on trial 1 of 100

  * 1000 random characters from extended ASCII alphabet
    - entry 8 of the two sequences are not equal
    - student   entry = cb
    - reference entry = ca
    - student:   53 86 a7 4a cd 33 cb 02 cb .. e3 cb 5e 31 c2 cb 33 6c 44 
    - reference: 53 86 a7 4a cd 33 cb 02 ca .. 42 ba 2c 57 8b 8d ca fc 56 

    - failed on trial 1 of 100

  * 1000 random characters from extended ASCII alphabet (excluding 0x00)
    - entry 11 of the two sequences are not equal
    - student   entry = 54
    - reference entry = 53
    - student:   25 9f 87 00 ba 08 76 13 9c .. 2f cd 26 d9 e3 2a 9e b0 1b 
    - reference: 25 9f 87 00 ba 08 76 13 9c .. 4b 6a d9 22 0c ef e6 ca f4 

    - failed on trial 1 of 100

  * 1000 random characters from extended ASCII alphabet (excluding 0xFF)
    - entry 20 of the two sequences are not equal
    - student   entry = 24
    - reference entry = 23
    - student:   6f b2 1e b0 8e 19 c2 6b 87 .. 3a 85 b8 94 33 9e a9 22 9c 
    - reference: 6f b2 1e b0 8e 19 c2 6b 87 .. 31 8d 91 10 93 d6 dd 62 66 

    - failed on trial 1 of 100

==> FAILED

Test 4e: check decode() on random inputs
         that were encoded with move-to-front
  * 10 random characters from { A } alphabet
    - entry 2 of the two sequences are not equal
    - student   entry = 40
    - reference entry = 3f
    - student:   41 40 40 40 40 40 40 40 40 40 
    - reference: 41 40 3f 3e 3d 3c 3b 3a 39 38 

    - failed on trial 1 of 2
    - input = 'AAAAAAAAAA'

  * 10 random characters from { A, B } alphabet
    - entry 2 of the two sequences are not equal
    - student   entry = 41
    - reference entry = 40
    - student:   42 41 41 3f 41 3e 41 41 41 41 
    - reference: 42 41 40 3e 3f 3c 3d 3b 3a 39 

    - failed on trial 1 of 100
    - input = 'BBBABABBBB'

  * 10 random characters from { A, T, C, G } alphabet
    - entry 3 of the two sequences are not equal
    - student   entry = 53
    - reference entry = 52
    - student:   54 42 53 53 3e 53 53 3d 53 3c 
    - reference: 54 42 53 52 3d 51 50 3a 4f 38 

    - failed on trial 1 of 100
    - input = 'TCTTATTATA'

  * 10 random characters from uppercase letter alphabet
    - entry 7 of the two sequences are not equal
    - student   entry = 42
    - reference entry = 41
    - student:   4a 50 5a 46 42 58 56 42 44 40 
    - reference: 4a 50 5a 46 42 58 56 41 43 3d 

    - failed on trial 1 of 100
    - input = 'JPZIFYXHIF'

  * 1000 random characters from { A } alphabet
    - entry 2 of the two sequences are not equal
    - student   entry = 40
    - reference entry = 3f
    - student:   41 40 40 40 40 40 40 40 40 .. 40 40 40 40 40 40 40 40 40 
    - reference: 41 40 3f 3e 3d 3c 3b 3a 39 .. 40 3f 3e 3d 3c 3b 3a 39 38 

    - failed on trial 1 of 100

  * 1000 random characters from { A, B } alphabet
    - entry 4 of the two sequences are not equal
    - student   entry = 3e
    - reference entry = 3d
    - student:   42 40 41 3e 3e 41 41 3d 41 .. 3e 3e 3e 3e 3d 3e 3e 3d 3d 
    - reference: 42 40 41 3e 3d 3f 3c 3a 3b .. 0c 0b 09 06 04 00 07 08 02 

    - failed on trial 1 of 100

  * 1000 random characters from { A, T, C, G } alphabet
    - entry 3 of the two sequences are not equal
    - student   entry = 46
    - reference entry = 45
    - student:   47 46 3f 46 3e 54 3f 3f 43 .. 1f 3c 37 37 37 37 1f 37 37 
    - reference: 47 46 3f 45 3d 54 3e 3c 43 .. 22 2b 2f 3e 26 3d 11 06 04 

    - failed on trial 1 of 100

  * 1000 random characters from uppercase letter alphabet
    - entry 5 of the two sequences are not equal
    - student   entry = 40
    - reference entry = 3f
    - student:   4e 57 40 4f 52 40 3f 42 49 .. 59 31 59 49 26 31 26 0c 0c 
    - reference: 4e 57 40 4f 52 3f 3d 42 49 .. 53 21 51 0f 23 37 54 10 30 

    - failed on trial 1 of 100

==> FAILED

Test 4f: check decode() on more random inputs
         that were encoded with move-to-front
  * 1000 random characters from ASCII alphabet 
    - entry 14 of the two sequences are not equal
    - student   entry = 58
    - reference entry = 57
    - student:   15 4e 5e 4c 38 6d 0d 74 24 .. 7e 67 58 0b 10 7e 10 46 10 
    - reference: 15 4e 5e 4c 38 6d 0d 74 24 .. 4c 47 0e 5d 50 0b 44 14 71 

    - failed on trial 1 of 100

  * 1000 random characters from extended ASCII alphabet
    - entry 16 of the two sequences are not equal
    - student   entry = 6b
    - reference entry = 6a
    - student:   d8 2f 00 98 a6 f3 76 18 9b .. c2 35 4a 4a 52 7a 4b 2b c5 
    - reference: d8 2f 00 98 a6 f3 76 18 9b .. ca b1 dd dd b4 3e c3 81 d3 

    - failed on trial 1 of 100

  * 1000 random characters from extended ASCII alphabet (excluding 0x00)
    - entry 10 of the two sequences are not equal
    - student   entry = a8
    - reference entry = a7
    - student:   bc d4 09 52 e6 78 3c 91 a8 .. 59 1f 58 bc 1f 1f 7f ef e1 
    - reference: bc d4 09 52 e6 78 3c 91 a8 .. b7 00 fa da b2 d9 7c 77 2f 

    - failed on trial 1 of 100

  * 1000 random characters from extended ASCII alphabet (excluding 0xFF)
    - entry 13 of the two sequences are not equal
    - student   entry = b4
    - reference entry = b3
    - student:   10 cb 22 4d b4 2c 59 00 1d .. 38 09 c2 ba 30 c2 bb c2 19 
    - reference: 10 cb 22 4d b4 2c 59 00 1d .. 88 cd 6c b4 07 27 39 19 11 

    - failed on trial 1 of 100

==> FAILED

Test 5a: check whether decode(encode()) = original on text files
  * abra.txt
  * zebra.txt
  * amendments.txt
    - entry 12 of the two sequences are not equal
    - student   entry = ff
    - reference entry = 43
    - student:   41 72 74 69 63 6c 65 20 49 .. 35 70 70 d4 d4 70 d4 d4 35 
    - reference: 41 72 74 69 63 6c 65 20 49 .. 65 72 76 65 6e 65 64 2e 0a 

  * aesop.txt
    - entry 16 of the two sequences are not equal
    - student   entry = ff
    - reference entry = 72
    - student:   41 65 73 6f 70 27 73 20 46 .. 0c c1 0c 0c 0c 0c 0c 0c 0c 
    - reference: 41 65 73 6f 70 27 73 20 46 .. 72 20 73 75 6e 73 3f 22 0a 

  * stars.txt
  * alphanum.txt
  * a.txt
==> FAILED

Test 5b: check whether decode(encode()) = original on binary files
  * us.gif
    - entry 37 of the two sequences are not equal
    - student   entry = ff
    - reference entry = 42
    - student:   47 49 46 38 39 61 8e 01 01 .. fe df fe 18 fe fe fe fe fe 
    - reference: 47 49 46 38 39 61 8e 01 01 .. 7f 03 1e 38 cc 41 00 00 3b 

  * CS_bricks.jpg
    - entry 27 of the two sequences are not equal
    - student   entry = fc
    - reference entry = fe
    - student:   ff d8 ff e1 00 16 45 78 69 .. d8 ba d8 d8 d8 d6 d8 d8 ba 
    - reference: ff d8 ff e1 00 16 45 78 69 .. 46 8d 01 a3 46 8d 07 ff d9 

  * rand10K.bin
    - entry 28 of the two sequences are not equal
    - student   entry = ff
    - reference entry = 70
    - student:   1a de 9d f2 73 73 0c 05 e1 .. 65 d6 33 86 33 33 86 7f 0c 
    - reference: 1a de 9d f2 73 73 0c 05 e1 .. 46 04 ae 11 4f d4 bc 2d b4 

==> FAILED

Test 5c: check that decode(encode()) = original on random inputs
  * 10 random characters from { A } alphabet
  * 10 random characters from { A, B } alphabet
  * 10 random characters from { A, T, C, G } alphabet
    - entry 7 of the two sequences are not equal
    - student   entry = ff
    - reference entry = 41
    - student:   43 54 43 43 43 43 43 ff 54 54 
    - reference: 43 54 43 43 43 43 43 41 54 54 

    - failed on trial 5 of 100
    - input = 'CTCCCCCATT'

  * 10 random characters from uppercase letter alphabet
    - entry 9 of the two sequences are not equal
    - student   entry = ff
    - reference entry = 4b
    - student:   49 43 57 4a 57 4d 4a 50 59 ff 
    - reference: 49 43 57 4a 57 4d 4a 50 59 4b 

    - failed on trial 1 of 100
    - input = 'ICWJWMJPYK'

  * 100 random characters from { A } alphabet
  * 1000 random characters from { A, B } alphabet
  * 1000 random characters from { A, T, C, G } alphabet
    - entry 13 of the two sequences are not equal
    - student   entry = ff
    - reference entry = 43
    - student:   41 41 54 41 41 41 54 47 54 .. ff ff 47 41 41 47 54 47 54 
    - reference: 41 41 54 41 41 41 54 47 54 .. 43 43 47 41 41 47 54 47 54 

    - failed on trial 3 of 100

  * 1000 random characters from uppercase letter alphabet
    - entry 3 of the two sequences are not equal
    - student   entry = ff
    - reference entry = 50
    - student:   53 46 51 ff 43 4b 51 44 49 .. ef 4a ef 4a 4a 4a ef 4a ef 
    - reference: 53 46 51 50 43 4b 52 44 49 .. 41 4e 41 51 4c 4c 51 5a 4f 

    - failed on trial 1 of 100

==> FAILED

Test 5d: check that decode(encode()) = original on random inputs
  * 1000 random characters from ASCII alphabet 
    - entry 18 of the two sequences are not equal
    - student   entry = ff
    - reference entry = 03
    - student:   12 0b 1d 36 17 52 10 36 39 .. 7a fe fe fe fe 76 fe fe 76 
    - reference: 12 0b 1d 36 17 52 10 36 39 .. 4a 1c 58 78 3f 55 4f 0f 27 

    - failed on trial 1 of 100

  * 1000 random characters from extended ASCII alphabet
    - entry 18 of the two sequences are not equal
    - student   entry = ff
    - reference entry = 76
    - student:   89 82 e4 c3 2b a0 58 c1 e0 .. b6 ca b6 b6 b6 b6 fb b6 fb 
    - reference: 89 82 e4 c3 2b a0 58 c1 e0 .. e2 af 39 96 7f 6a 89 13 bd 

    - failed on trial 1 of 100

  * 1000 random characters from extended ASCII alphabet (excluding 0x00)
    - entry 15 of the two sequences are not equal
    - student   entry = ff
    - reference entry = 67
    - student:   72 31 a2 84 b2 d2 54 0e 40 .. fe a4 a4 a4 a4 a4 a4 a4 a4 
    - reference: 72 31 a2 84 b2 d2 54 0e 40 .. 4f 98 3f 88 2f 72 78 c3 2d 

    - failed on trial 1 of 100

  * 1000 random characters from extended ASCII alphabet (excluding 0xFF)
    - entry 17 of the two sequences are not equal
    - student   entry = ff
    - reference entry = 5c
    - student:   84 09 da 9a b3 cf 43 c6 65 .. fe fe 31 fe fe fe 0c ee fe 
    - reference: 84 09 da 9a b3 cf 43 c6 65 .. 83 cc 23 08 dd 29 65 04 41 

    - failed on trial 1 of 100

==> FAILED

Test 6a: check that encode() calls either close() or flush()
  * amendments.txt
    - entry 12 of the two sequences are not equal
    - student   entry = ff
    - reference entry = 4a
    - student:   41 72 74 6b 66 6e 69 27 4f .. 04 1a 07 02 05 01 53 ff 25 
    - reference: 41 72 74 6b 66 6e 69 27 4f .. 04 0a 06 02 04 01 14 1b 0f 

  * aesop.txt
    - entry 7 of the two sequences are not equal
    - student   entry = 27
    - reference entry = 26
    - student:   41 65 73 70 71 2c 03 27 4b .. 22 05 12 10 1c 02 ff ff 1f 
    - reference: 41 65 73 70 71 2c 03 26 4a .. 10 05 0b 0b 0f 02 36 1c 11 

==> FAILED

Test 6b: check that decode() calls either close() or flush()
  * amendments.txt.mtf
    - entry 12 of the two sequences are not equal
    - student   entry = 44
    - reference entry = 43
    - student:   41 72 74 69 63 6c 65 20 49 .. 6e 6e 6e 6e 6e 1f 1f 6e 1f 
    - reference: 41 72 74 69 63 6c 65 20 49 .. 65 72 76 65 6e 65 64 2e 0a 

  * aesop.txt.mtf
    - entry 7 of the two sequences are not equal
    - student   entry = 1f
    - reference entry = 20
    - student:   41 65 73 6f 70 27 73 1f 45 .. 52 77 52 77 52 52 52 52 77 
    - reference: 41 65 73 6f 70 27 73 20 46 .. 72 20 73 75 6e 73 3f 22 0a 

==> FAILED

Test 7a: check encode() on large files
  * rand100K.bin
    - entry 9 of the two sequences are not equal
    - student   entry = a0
    - reference entry = a1
    - student:   73 fe bf 6f 9f a5 86 ec 66 .. ff 66 2f 01 60 ff 4f e1 ff 
    - reference: 73 fe bf 6f 9f a5 86 ec 66 .. f3 6c 2e 01 64 d8 4c 9b 95 

  * world192.txt
    - entry 16 of the two sequences are not equal
    - student   entry = 51
    - reference entry = 50
    - student:   2a 00 00 00 54 68 66 24 53 .. 0a 09 0b 0f 73 2a 29 01 01 
    - reference: 2a 00 00 00 54 68 66 24 53 .. 0a 09 0a 0b 1f 18 18 01 01 

==> FAILED

Test 7b: check decode() on large files
  * rand100K.bin.mtf
    - entry 9 of the two sequences are not equal
    - student   entry = 9d
    - reference entry = 9c
    - student:   73 fe be 6c 9d a3 82 eb 5e .. 00 00 00 00 00 00 00 00 00 
    - reference: 73 fe be 6c 9d a3 82 eb 5e .. f5 60 4f 60 99 82 d5 72 38 

  * world192.txt.mtf
    - entry 16 of the two sequences are not equal
    - student   entry = 46
    - reference entry = 47
    - student:   2a 2a 2a 2a 54 68 65 20 50 .. 77 7d 7d 77 7d 7d 7d 77 7d 
    - reference: 2a 2a 2a 2a 54 68 65 20 50 .. 72 6c 61 6e 64 0d 0a 0d 0a 

==> FAILED

Test 7c: check whether decode(encode()) = original on large files
  * rand100K.bin
    - entry 17 of the two sequences are not equal
    - student   entry = ff
    - reference entry = ec
    - student:   73 fe be 6c 9d a3 82 eb 5e .. fd 93 93 fd 93 fd 93 93 fd 
    - reference: 73 fe be 6c 9d a3 82 eb 5e .. f5 60 4f 60 99 82 d5 72 38 

  * world192.txt
    - entry 20 of the two sequences are not equal
    - student   entry = ff
    - reference entry = 6e
    - student:   2a 2a 2a 2a 54 68 65 20 50 .. 6a ed 6a ed 6a 6a ed 6a ed 
    - reference: 2a 2a 2a 2a 54 68 65 20 50 .. 72 6c 61 6e 64 0d 0a 0d 0a 

==> FAILED


Total: 2/23 tests passed!


================================================================
********************************************************************************
*  TESTING CORRECTNESS (substituting reference CircularSuffixArray)
********************************************************************************

Testing correctness of BurrowsWheeler
*-----------------------------------------------------------
Running 26 total tests.

Test 1a: check main() on text files
  * java BurrowsWheeler - < abra.txt
  * java BurrowsWheeler - < zebra.txt
  * java BurrowsWheeler - < cadabra.txt
  * java BurrowsWheeler - < amendments.txt
==> passed

Test 1b: check main() on text files
  * java BurrowsWheeler + < abra.txt.bwt

    java.lang.IllegalArgumentException: Illegal 8-bit char = ?

    edu.princeton.cs.algs4.BinaryStdOut.write(BinaryStdOut.java:346)
    BurrowsWheeler.inverseTransform(BurrowsWheeler.java:59)
    BurrowsWheeler.main(BurrowsWheeler.java:79)
    TestBurrowsWheeler.checkMain(TestBurrowsWheeler.java:144)
    TestBurrowsWheeler.test1b(TestBurrowsWheeler.java:487)
    TestBurrowsWheeler.main(TestBurrowsWheeler.java:739)

  * java BurrowsWheeler + < zebra.txt.bwt

    java.lang.IllegalArgumentException: Illegal 8-bit char = ?

    edu.princeton.cs.algs4.BinaryStdOut.write(BinaryStdOut.java:346)
    BurrowsWheeler.inverseTransform(BurrowsWheeler.java:59)
    BurrowsWheeler.main(BurrowsWheeler.java:79)
    TestBurrowsWheeler.checkMain(TestBurrowsWheeler.java:144)
    TestBurrowsWheeler.test1b(TestBurrowsWheeler.java:488)
    TestBurrowsWheeler.main(TestBurrowsWheeler.java:739)

  * java BurrowsWheeler + < cadabra.txt.bwt

    java.lang.IllegalArgumentException: Illegal 8-bit char = ?

    edu.princeton.cs.algs4.BinaryStdOut.write(BinaryStdOut.java:346)
    BurrowsWheeler.inverseTransform(BurrowsWheeler.java:59)
    BurrowsWheeler.main(BurrowsWheeler.java:79)
    TestBurrowsWheeler.checkMain(TestBurrowsWheeler.java:144)
    TestBurrowsWheeler.test1b(TestBurrowsWheeler.java:489)
    TestBurrowsWheeler.main(TestBurrowsWheeler.java:739)

  * java BurrowsWheeler + < amendments.txt.bwt

    java.lang.IllegalArgumentException: Illegal 8-bit char = ?

    edu.princeton.cs.algs4.BinaryStdOut.write(BinaryStdOut.java:346)
    BurrowsWheeler.inverseTransform(BurrowsWheeler.java:59)
    BurrowsWheeler.main(BurrowsWheeler.java:79)
    TestBurrowsWheeler.checkMain(TestBurrowsWheeler.java:144)
    TestBurrowsWheeler.test1b(TestBurrowsWheeler.java:490)
    TestBurrowsWheeler.main(TestBurrowsWheeler.java:739)

==> FAILED

Test 2a: check that main() is consistent with transform() on text files
  * abra.txt
  * zebra.txt
  * cadabra.txt
  * amendments.txt
==> passed

Test 2b: check that main() is consistent with inverseTransform() on text files
  * abra.txt.bwt

    java.lang.IllegalArgumentException: Illegal 8-bit char = ?

    edu.princeton.cs.algs4.BinaryStdOut.write(BinaryStdOut.java:346)
    BurrowsWheeler.inverseTransform(BurrowsWheeler.java:59)
    BurrowsWheeler.main(BurrowsWheeler.java:79)
    TestBurrowsWheeler.checkMainConsistentWithInverseTransform(TestBurrowsWheeler.java:203)
    TestBurrowsWheeler.test2b(TestBurrowsWheeler.java:507)
    TestBurrowsWheeler.main(TestBurrowsWheeler.java:745)

  * zebra.txt.bwt

    java.lang.IllegalArgumentException: Illegal 8-bit char = ?

    edu.princeton.cs.algs4.BinaryStdOut.write(BinaryStdOut.java:346)
    BurrowsWheeler.inverseTransform(BurrowsWheeler.java:59)
    BurrowsWheeler.main(BurrowsWheeler.java:79)
    TestBurrowsWheeler.checkMainConsistentWithInverseTransform(TestBurrowsWheeler.java:203)
    TestBurrowsWheeler.test2b(TestBurrowsWheeler.java:508)
    TestBurrowsWheeler.main(TestBurrowsWheeler.java:745)

  * cadabra.txt.bwt

    java.lang.IllegalArgumentException: Illegal 8-bit char = ?

    edu.princeton.cs.algs4.BinaryStdOut.write(BinaryStdOut.java:346)
    BurrowsWheeler.inverseTransform(BurrowsWheeler.java:59)
    BurrowsWheeler.main(BurrowsWheeler.java:79)
    TestBurrowsWheeler.checkMainConsistentWithInverseTransform(TestBurrowsWheeler.java:203)
    TestBurrowsWheeler.test2b(TestBurrowsWheeler.java:509)
    TestBurrowsWheeler.main(TestBurrowsWheeler.java:745)

  * amendments.txt.bwt

    java.lang.IllegalArgumentException: Illegal 8-bit char = ?

    edu.princeton.cs.algs4.BinaryStdOut.write(BinaryStdOut.java:346)
    BurrowsWheeler.inverseTransform(BurrowsWheeler.java:59)
    BurrowsWheeler.main(BurrowsWheeler.java:79)
    TestBurrowsWheeler.checkMainConsistentWithInverseTransform(TestBurrowsWheeler.java:203)
    TestBurrowsWheeler.test2b(TestBurrowsWheeler.java:510)
    TestBurrowsWheeler.main(TestBurrowsWheeler.java:745)

==> FAILED

Test 3a: check transform() on text files
  * abra.txt
  * zebra.txt
  * cadabra.txt
  * amendments.txt
==> passed

Test 3b: check transform() on corner-case text files
  * alphanum.txt
  * a.txt
==> passed

Test 3c: check transform() on binary files
  * us.gif
  * CS_bricks.jpg
  * rand10K.bin
==> passed

Test 3d: check transform() on random inputs
  * 10 random characters from binary alphabet
  * 10 random characters from DNA alphabet
  * 10 random characters from uppercase alphabet
  * 1000 random characters from binary alphabet
  * 1000 random characters from DNA alphabet
  * 1000 random characters from uppercase alphabet
==> passed

Test 3e: check transform() on more random inputs
  * 1000 random characters from ASCII alphabet 
  * 1000 random characters from extended ASCII alphabet
  * 1000 random characters from extended ASCII alphabet (excluding 0x00)
  * 1000 random characters from extended ASCII alphabet (excluding 0xFF)
==> passed

Test 3f: check tranform() on random inputs that are circular
         shifts of themselves
  * 5 random strings from unary alphabet
  * 5 random strings from binary alphabet
  * 5 random strings from DNA alphabet
  * 5 random strings from uppercase alphabet
==> passed

Test 4a: check inverseTransform() on text files
  * abra.txt.bwt

    java.lang.IllegalArgumentException: Illegal 8-bit char = ?

    edu.princeton.cs.algs4.BinaryStdOut.write(BinaryStdOut.java:346)
    BurrowsWheeler.inverseTransform(BurrowsWheeler.java:59)
    TestBurrowsWheeler.checkInverseTransform(TestBurrowsWheeler.java:350)
    TestBurrowsWheeler.checkInverseTransform(TestBurrowsWheeler.java:332)
    TestBurrowsWheeler.checkInverseTransform(TestBurrowsWheeler.java:326)
    TestBurrowsWheeler.test4a(TestBurrowsWheeler.java:576)
    TestBurrowsWheeler.main(TestBurrowsWheeler.java:766)

  * zebra.txt.bwt

    java.lang.IllegalArgumentException: Illegal 8-bit char = ?

    edu.princeton.cs.algs4.BinaryStdOut.write(BinaryStdOut.java:346)
    BurrowsWheeler.inverseTransform(BurrowsWheeler.java:59)
    TestBurrowsWheeler.checkInverseTransform(TestBurrowsWheeler.java:350)
    TestBurrowsWheeler.checkInverseTransform(TestBurrowsWheeler.java:332)
    TestBurrowsWheeler.checkInverseTransform(TestBurrowsWheeler.java:326)
    TestBurrowsWheeler.test4a(TestBurrowsWheeler.java:577)
    TestBurrowsWheeler.main(TestBurrowsWheeler.java:766)

  * cadabra.txt.bwt

    java.lang.IllegalArgumentException: Illegal 8-bit char = ?

    edu.princeton.cs.algs4.BinaryStdOut.write(BinaryStdOut.java:346)
    BurrowsWheeler.inverseTransform(BurrowsWheeler.java:59)
    TestBurrowsWheeler.checkInverseTransform(TestBurrowsWheeler.java:350)
    TestBurrowsWheeler.checkInverseTransform(TestBurrowsWheeler.java:332)
    TestBurrowsWheeler.checkInverseTransform(TestBurrowsWheeler.java:326)
    TestBurrowsWheeler.test4a(TestBurrowsWheeler.java:578)
    TestBurrowsWheeler.main(TestBurrowsWheeler.java:766)

  * amendments.txt.bwt

    java.lang.IllegalArgumentException: Illegal 8-bit char = ?

    edu.princeton.cs.algs4.BinaryStdOut.write(BinaryStdOut.java:346)
    BurrowsWheeler.inverseTransform(BurrowsWheeler.java:59)
    TestBurrowsWheeler.checkInverseTransform(TestBurrowsWheeler.java:350)
    TestBurrowsWheeler.checkInverseTransform(TestBurrowsWheeler.java:332)
    TestBurrowsWheeler.checkInverseTransform(TestBurrowsWheeler.java:326)
    TestBurrowsWheeler.test4a(TestBurrowsWheeler.java:579)
    TestBurrowsWheeler.main(TestBurrowsWheeler.java:766)

==> FAILED

Test 4b: check inverseTransform() on corner-case text files
  * alphanum.txt.bwt

    java.lang.IllegalArgumentException: Illegal 8-bit char = ?

    edu.princeton.cs.algs4.BinaryStdOut.write(BinaryStdOut.java:346)
    BurrowsWheeler.inverseTransform(BurrowsWheeler.java:59)
    TestBurrowsWheeler.checkInverseTransform(TestBurrowsWheeler.java:350)
    TestBurrowsWheeler.checkInverseTransform(TestBurrowsWheeler.java:332)
    TestBurrowsWheeler.checkInverseTransform(TestBurrowsWheeler.java:326)
    TestBurrowsWheeler.test4b(TestBurrowsWheeler.java:586)
    TestBurrowsWheeler.main(TestBurrowsWheeler.java:769)

  * a.txt.bwt

    java.lang.IllegalArgumentException: Illegal 8-bit char = ?

    edu.princeton.cs.algs4.BinaryStdOut.write(BinaryStdOut.java:346)
    BurrowsWheeler.inverseTransform(BurrowsWheeler.java:59)
    TestBurrowsWheeler.checkInverseTransform(TestBurrowsWheeler.java:350)
    TestBurrowsWheeler.checkInverseTransform(TestBurrowsWheeler.java:332)
    TestBurrowsWheeler.checkInverseTransform(TestBurrowsWheeler.java:326)
    TestBurrowsWheeler.test4b(TestBurrowsWheeler.java:587)
    TestBurrowsWheeler.main(TestBurrowsWheeler.java:769)

  * stars.txt.bwt

    java.lang.IllegalArgumentException: Illegal 8-bit char = ?

    edu.princeton.cs.algs4.BinaryStdOut.write(BinaryStdOut.java:346)
    BurrowsWheeler.inverseTransform(BurrowsWheeler.java:59)
    TestBurrowsWheeler.checkInverseTransform(TestBurrowsWheeler.java:350)
    TestBurrowsWheeler.checkInverseTransform(TestBurrowsWheeler.java:332)
    TestBurrowsWheeler.checkInverseTransform(TestBurrowsWheeler.java:326)
    TestBurrowsWheeler.test4b(TestBurrowsWheeler.java:588)
    TestBurrowsWheeler.main(TestBurrowsWheeler.java:769)

  * couscous.txt.bwt

    java.lang.IllegalArgumentException: Illegal 8-bit char = ?

    edu.princeton.cs.algs4.BinaryStdOut.write(BinaryStdOut.java:346)
    BurrowsWheeler.inverseTransform(BurrowsWheeler.java:59)
    TestBurrowsWheeler.checkInverseTransform(TestBurrowsWheeler.java:350)
    TestBurrowsWheeler.checkInverseTransform(TestBurrowsWheeler.java:332)
    TestBurrowsWheeler.checkInverseTransform(TestBurrowsWheeler.java:326)
    TestBurrowsWheeler.test4b(TestBurrowsWheeler.java:589)
    TestBurrowsWheeler.main(TestBurrowsWheeler.java:769)

==> FAILED

Test 4c: check inverseTransform() on binary files
  * us.gif.bwt

    java.lang.IllegalArgumentException: Illegal 8-bit char = ?

    edu.princeton.cs.algs4.BinaryStdOut.write(BinaryStdOut.java:346)
    BurrowsWheeler.inverseTransform(BurrowsWheeler.java:59)
    TestBurrowsWheeler.checkInverseTransform(TestBurrowsWheeler.java:350)
    TestBurrowsWheeler.checkInverseTransform(TestBurrowsWheeler.java:332)
    TestBurrowsWheeler.checkInverseTransform(TestBurrowsWheeler.java:326)
    TestBurrowsWheeler.test4c(TestBurrowsWheeler.java:596)
    TestBurrowsWheeler.main(TestBurrowsWheeler.java:772)

  * CS_bricks.jpg.bwt

    java.lang.IllegalArgumentException: Illegal 8-bit char = ?

    edu.princeton.cs.algs4.BinaryStdOut.write(BinaryStdOut.java:346)
    BurrowsWheeler.inverseTransform(BurrowsWheeler.java:59)
    TestBurrowsWheeler.checkInverseTransform(TestBurrowsWheeler.java:350)
    TestBurrowsWheeler.checkInverseTransform(TestBurrowsWheeler.java:332)
    TestBurrowsWheeler.checkInverseTransform(TestBurrowsWheeler.java:326)
    TestBurrowsWheeler.test4c(TestBurrowsWheeler.java:597)
    TestBurrowsWheeler.main(TestBurrowsWheeler.java:772)

  * rand10K.bin.bwt

    java.lang.IllegalArgumentException: Illegal 8-bit char = ?

    edu.princeton.cs.algs4.BinaryStdOut.write(BinaryStdOut.java:346)
    BurrowsWheeler.inverseTransform(BurrowsWheeler.java:59)
    TestBurrowsWheeler.checkInverseTransform(TestBurrowsWheeler.java:350)
    TestBurrowsWheeler.checkInverseTransform(TestBurrowsWheeler.java:332)
    TestBurrowsWheeler.checkInverseTransform(TestBurrowsWheeler.java:326)
    TestBurrowsWheeler.test4c(TestBurrowsWheeler.java:598)
    TestBurrowsWheeler.main(TestBurrowsWheeler.java:772)

==> FAILED

Test 4d: check inverseTransform() of transform() on random inputs
  * 10 random characters from unary alphabet

    java.lang.IllegalArgumentException: Illegal 8-bit char = ?

    edu.princeton.cs.algs4.BinaryStdOut.write(BinaryStdOut.java:346)
    BurrowsWheeler.inverseTransform(BurrowsWheeler.java:59)
    TestBurrowsWheeler.checkInverseTransform(TestBurrowsWheeler.java:350)
    TestBurrowsWheeler.checkInverseTransform(TestBurrowsWheeler.java:382)
    TestBurrowsWheeler.test4d(TestBurrowsWheeler.java:604)
    TestBurrowsWheeler.main(TestBurrowsWheeler.java:775)

    - failed on trial 1 of 2
    - input = 'AAAAAAAAAA'

  * 10 random characters from binary alphabet

    java.lang.IllegalArgumentException: Illegal 8-bit char = ?

    edu.princeton.cs.algs4.BinaryStdOut.write(BinaryStdOut.java:346)
    BurrowsWheeler.inverseTransform(BurrowsWheeler.java:59)
    TestBurrowsWheeler.checkInverseTransform(TestBurrowsWheeler.java:350)
    TestBurrowsWheeler.checkInverseTransform(TestBurrowsWheeler.java:382)
    TestBurrowsWheeler.test4d(TestBurrowsWheeler.java:605)
    TestBurrowsWheeler.main(TestBurrowsWheeler.java:775)

    - failed on trial 1 of 100
    - input = 'BBABBABAAB'

  * 10 random characters from DNA alphabet

    java.lang.IllegalArgumentException: Illegal 8-bit char = ?

    edu.princeton.cs.algs4.BinaryStdOut.write(BinaryStdOut.java:346)
    BurrowsWheeler.inverseTransform(BurrowsWheeler.java:59)
    TestBurrowsWheeler.checkInverseTransform(TestBurrowsWheeler.java:350)
    TestBurrowsWheeler.checkInverseTransform(TestBurrowsWheeler.java:382)
    TestBurrowsWheeler.test4d(TestBurrowsWheeler.java:606)
    TestBurrowsWheeler.main(TestBurrowsWheeler.java:775)

    - failed on trial 1 of 100
    - input = 'AATTCCCAAG'

  * 10 random characters from uppercase alphabet

    java.lang.IllegalArgumentException: Illegal 8-bit char = ?

    edu.princeton.cs.algs4.BinaryStdOut.write(BinaryStdOut.java:346)
    BurrowsWheeler.inverseTransform(BurrowsWheeler.java:59)
    TestBurrowsWheeler.checkInverseTransform(TestBurrowsWheeler.java:350)
    TestBurrowsWheeler.checkInverseTransform(TestBurrowsWheeler.java:382)
    TestBurrowsWheeler.test4d(TestBurrowsWheeler.java:607)
    TestBurrowsWheeler.main(TestBurrowsWheeler.java:775)

    - failed on trial 1 of 100
    - input = 'KYGBOEQNAC'

  * 100 random characters from unary alphabet

    java.lang.IllegalArgumentException: Illegal 8-bit char = ?

    edu.princeton.cs.algs4.BinaryStdOut.write(BinaryStdOut.java:346)
    BurrowsWheeler.inverseTransform(BurrowsWheeler.java:59)
    TestBurrowsWheeler.checkInverseTransform(TestBurrowsWheeler.java:350)
    TestBurrowsWheeler.checkInverseTransform(TestBurrowsWheeler.java:382)
    TestBurrowsWheeler.test4d(TestBurrowsWheeler.java:608)
    TestBurrowsWheeler.main(TestBurrowsWheeler.java:775)

    - failed on trial 1 of 2

  * 1000 random characters from binary alphabet

    java.lang.IllegalArgumentException: Illegal 8-bit char = ?

    edu.princeton.cs.algs4.BinaryStdOut.write(BinaryStdOut.java:346)
    BurrowsWheeler.inverseTransform(BurrowsWheeler.java:59)
    TestBurrowsWheeler.checkInverseTransform(TestBurrowsWheeler.java:350)
    TestBurrowsWheeler.checkInverseTransform(TestBurrowsWheeler.java:382)
    TestBurrowsWheeler.test4d(TestBurrowsWheeler.java:609)
    TestBurrowsWheeler.main(TestBurrowsWheeler.java:775)

    - failed on trial 1 of 100

  * 1000 random characters from DNA alphabet

    java.lang.IllegalArgumentException: Illegal 8-bit char = ?

    edu.princeton.cs.algs4.BinaryStdOut.write(BinaryStdOut.java:346)
    BurrowsWheeler.inverseTransform(BurrowsWheeler.java:59)
    TestBurrowsWheeler.checkInverseTransform(TestBurrowsWheeler.java:350)
    TestBurrowsWheeler.checkInverseTransform(TestBurrowsWheeler.java:382)
    TestBurrowsWheeler.test4d(TestBurrowsWheeler.java:610)
    TestBurrowsWheeler.main(TestBurrowsWheeler.java:775)

    - failed on trial 1 of 100

  * 1000 random characters from uppercase alphabet

    java.lang.IllegalArgumentException: Illegal 8-bit char = ?

    edu.princeton.cs.algs4.BinaryStdOut.write(BinaryStdOut.java:346)
    BurrowsWheeler.inverseTransform(BurrowsWheeler.java:59)
    TestBurrowsWheeler.checkInverseTransform(TestBurrowsWheeler.java:350)
    TestBurrowsWheeler.checkInverseTransform(TestBurrowsWheeler.java:382)
    TestBurrowsWheeler.test4d(TestBurrowsWheeler.java:611)
    TestBurrowsWheeler.main(TestBurrowsWheeler.java:775)

    - failed on trial 1 of 100

==> FAILED

Test 4e: check inverseTransform() of transform() on more random inputs
  * 1000 random characters from ASCII alphabet 

    java.lang.IllegalArgumentException: Illegal 8-bit char = ?

    edu.princeton.cs.algs4.BinaryStdOut.write(BinaryStdOut.java:346)
    BurrowsWheeler.inverseTransform(BurrowsWheeler.java:59)
    TestBurrowsWheeler.checkInverseTransform(TestBurrowsWheeler.java:350)
    TestBurrowsWheeler.checkInverseTransform(TestBurrowsWheeler.java:382)
    TestBurrowsWheeler.test4e(TestBurrowsWheeler.java:617)
    TestBurrowsWheeler.main(TestBurrowsWheeler.java:778)

    - failed on trial 1 of 100

  * 1000 random characters from extended ASCII alphabet

    java.lang.IllegalArgumentException: Illegal 8-bit char = ?

    edu.princeton.cs.algs4.BinaryStdOut.write(BinaryStdOut.java:346)
    BurrowsWheeler.inverseTransform(BurrowsWheeler.java:59)
    TestBurrowsWheeler.checkInverseTransform(TestBurrowsWheeler.java:350)
    TestBurrowsWheeler.checkInverseTransform(TestBurrowsWheeler.java:382)
    TestBurrowsWheeler.test4e(TestBurrowsWheeler.java:618)
    TestBurrowsWheeler.main(TestBurrowsWheeler.java:778)

    - failed on trial 1 of 100

  * 1000 random characters from extended ASCII alphabet (excluding 0x00)

    java.lang.IllegalArgumentException: Illegal 8-bit char = ?

    edu.princeton.cs.algs4.BinaryStdOut.write(BinaryStdOut.java:346)
    BurrowsWheeler.inverseTransform(BurrowsWheeler.java:59)
    TestBurrowsWheeler.checkInverseTransform(TestBurrowsWheeler.java:350)
    TestBurrowsWheeler.checkInverseTransform(TestBurrowsWheeler.java:382)
    TestBurrowsWheeler.test4e(TestBurrowsWheeler.java:619)
    TestBurrowsWheeler.main(TestBurrowsWheeler.java:778)

    - failed on trial 1 of 100

  * 1000 random characters from extended ASCII alphabet (excluding 0xFF)

    java.lang.IllegalArgumentException: Illegal 8-bit char = ?

    edu.princeton.cs.algs4.BinaryStdOut.write(BinaryStdOut.java:346)
    BurrowsWheeler.inverseTransform(BurrowsWheeler.java:59)
    TestBurrowsWheeler.checkInverseTransform(TestBurrowsWheeler.java:350)
    TestBurrowsWheeler.checkInverseTransform(TestBurrowsWheeler.java:382)
    TestBurrowsWheeler.test4e(TestBurrowsWheeler.java:620)
    TestBurrowsWheeler.main(TestBurrowsWheeler.java:778)

    - failed on trial 1 of 100

==> FAILED

Test 5a: check that inverseTransform(transform()) = original on text files
  * abra.txt

    java.lang.IllegalArgumentException: Illegal 8-bit char = ?

    edu.princeton.cs.algs4.BinaryStdOut.write(BinaryStdOut.java:346)
    BurrowsWheeler.inverseTransform(BurrowsWheeler.java:59)
    TestBurrowsWheeler.checkTransformConsistentWithInverseTransform(TestBurrowsWheeler.java:422)
    TestBurrowsWheeler.checkTransformConsistentWithInverseTransform(TestBurrowsWheeler.java:401)
    TestBurrowsWheeler.test5a(TestBurrowsWheeler.java:628)
    TestBurrowsWheeler.main(TestBurrowsWheeler.java:781)

  * zebra.txt

    java.lang.IllegalArgumentException: Illegal 8-bit char = ?

    edu.princeton.cs.algs4.BinaryStdOut.write(BinaryStdOut.java:346)
    BurrowsWheeler.inverseTransform(BurrowsWheeler.java:59)
    TestBurrowsWheeler.checkTransformConsistentWithInverseTransform(TestBurrowsWheeler.java:422)
    TestBurrowsWheeler.checkTransformConsistentWithInverseTransform(TestBurrowsWheeler.java:401)
    TestBurrowsWheeler.test5a(TestBurrowsWheeler.java:629)
    TestBurrowsWheeler.main(TestBurrowsWheeler.java:781)

  * cadabra.txt

    java.lang.IllegalArgumentException: Illegal 8-bit char = ?

    edu.princeton.cs.algs4.BinaryStdOut.write(BinaryStdOut.java:346)
    BurrowsWheeler.inverseTransform(BurrowsWheeler.java:59)
    TestBurrowsWheeler.checkTransformConsistentWithInverseTransform(TestBurrowsWheeler.java:422)
    TestBurrowsWheeler.checkTransformConsistentWithInverseTransform(TestBurrowsWheeler.java:401)
    TestBurrowsWheeler.test5a(TestBurrowsWheeler.java:630)
    TestBurrowsWheeler.main(TestBurrowsWheeler.java:781)

  * amendments.txt

    java.lang.IllegalArgumentException: Illegal 8-bit char = ?

    edu.princeton.cs.algs4.BinaryStdOut.write(BinaryStdOut.java:346)
    BurrowsWheeler.inverseTransform(BurrowsWheeler.java:59)
    TestBurrowsWheeler.checkTransformConsistentWithInverseTransform(TestBurrowsWheeler.java:422)
    TestBurrowsWheeler.checkTransformConsistentWithInverseTransform(TestBurrowsWheeler.java:401)
    TestBurrowsWheeler.test5a(TestBurrowsWheeler.java:631)
    TestBurrowsWheeler.main(TestBurrowsWheeler.java:781)

==> FAILED

Test 5b: check that inverseTransform(transform()) = original on corner-case text files
  * alphanum.txt

    java.lang.IllegalArgumentException: Illegal 8-bit char = ?

    edu.princeton.cs.algs4.BinaryStdOut.write(BinaryStdOut.java:346)
    BurrowsWheeler.inverseTransform(BurrowsWheeler.java:59)
    TestBurrowsWheeler.checkTransformConsistentWithInverseTransform(TestBurrowsWheeler.java:422)
    TestBurrowsWheeler.checkTransformConsistentWithInverseTransform(TestBurrowsWheeler.java:401)
    TestBurrowsWheeler.test5b(TestBurrowsWheeler.java:638)
    TestBurrowsWheeler.main(TestBurrowsWheeler.java:784)

  * a.txt

    java.lang.IllegalArgumentException: Illegal 8-bit char = ?

    edu.princeton.cs.algs4.BinaryStdOut.write(BinaryStdOut.java:346)
    BurrowsWheeler.inverseTransform(BurrowsWheeler.java:59)
    TestBurrowsWheeler.checkTransformConsistentWithInverseTransform(TestBurrowsWheeler.java:422)
    TestBurrowsWheeler.checkTransformConsistentWithInverseTransform(TestBurrowsWheeler.java:401)
    TestBurrowsWheeler.test5b(TestBurrowsWheeler.java:639)
    TestBurrowsWheeler.main(TestBurrowsWheeler.java:784)

  * stars.txt

    java.lang.IllegalArgumentException: Illegal 8-bit char = ?

    edu.princeton.cs.algs4.BinaryStdOut.write(BinaryStdOut.java:346)
    BurrowsWheeler.inverseTransform(BurrowsWheeler.java:59)
    TestBurrowsWheeler.checkTransformConsistentWithInverseTransform(TestBurrowsWheeler.java:422)
    TestBurrowsWheeler.checkTransformConsistentWithInverseTransform(TestBurrowsWheeler.java:401)
    TestBurrowsWheeler.test5b(TestBurrowsWheeler.java:640)
    TestBurrowsWheeler.main(TestBurrowsWheeler.java:784)

  * couscous.txt

    java.lang.IllegalArgumentException: Illegal 8-bit char = ?

    edu.princeton.cs.algs4.BinaryStdOut.write(BinaryStdOut.java:346)
    BurrowsWheeler.inverseTransform(BurrowsWheeler.java:59)
    TestBurrowsWheeler.checkTransformConsistentWithInverseTransform(TestBurrowsWheeler.java:422)
    TestBurrowsWheeler.checkTransformConsistentWithInverseTransform(TestBurrowsWheeler.java:401)
    TestBurrowsWheeler.test5b(TestBurrowsWheeler.java:641)
    TestBurrowsWheeler.main(TestBurrowsWheeler.java:784)

==> FAILED

Test 5c: check that inverseTransform(transform()) = original on binary files
  * us.gif

    java.lang.IllegalArgumentException: Illegal 8-bit char = ?

    edu.princeton.cs.algs4.BinaryStdOut.write(BinaryStdOut.java:346)
    BurrowsWheeler.inverseTransform(BurrowsWheeler.java:59)
    TestBurrowsWheeler.checkTransformConsistentWithInverseTransform(TestBurrowsWheeler.java:422)
    TestBurrowsWheeler.checkTransformConsistentWithInverseTransform(TestBurrowsWheeler.java:401)
    TestBurrowsWheeler.test5c(TestBurrowsWheeler.java:648)
    TestBurrowsWheeler.main(TestBurrowsWheeler.java:787)

  * CS_bricks.jpg

    java.lang.IllegalArgumentException: Illegal 8-bit char = ?

    edu.princeton.cs.algs4.BinaryStdOut.write(BinaryStdOut.java:346)
    BurrowsWheeler.inverseTransform(BurrowsWheeler.java:59)
    TestBurrowsWheeler.checkTransformConsistentWithInverseTransform(TestBurrowsWheeler.java:422)
    TestBurrowsWheeler.checkTransformConsistentWithInverseTransform(TestBurrowsWheeler.java:401)
    TestBurrowsWheeler.test5c(TestBurrowsWheeler.java:649)
    TestBurrowsWheeler.main(TestBurrowsWheeler.java:787)

  * rand10K.bin

    java.lang.IllegalArgumentException: Illegal 8-bit char = ?

    edu.princeton.cs.algs4.BinaryStdOut.write(BinaryStdOut.java:346)
    BurrowsWheeler.inverseTransform(BurrowsWheeler.java:59)
    TestBurrowsWheeler.checkTransformConsistentWithInverseTransform(TestBurrowsWheeler.java:422)
    TestBurrowsWheeler.checkTransformConsistentWithInverseTransform(TestBurrowsWheeler.java:401)
    TestBurrowsWheeler.test5c(TestBurrowsWheeler.java:650)
    TestBurrowsWheeler.main(TestBurrowsWheeler.java:787)

==> FAILED

Test 5d: check that inverseTransform(tranform()) = original on random inputs
  * 10 random characters from binary alphabet

    java.lang.IllegalArgumentException: Illegal 8-bit char = ?

    edu.princeton.cs.algs4.BinaryStdOut.write(BinaryStdOut.java:346)
    BurrowsWheeler.inverseTransform(BurrowsWheeler.java:59)
    TestBurrowsWheeler.checkTransformConsistentWithInverseTransform(TestBurrowsWheeler.java:422)
    TestBurrowsWheeler.checkTransformConsistentWithInverseTransform(TestBurrowsWheeler.java:444)
    TestBurrowsWheeler.test5d(TestBurrowsWheeler.java:657)
    TestBurrowsWheeler.main(TestBurrowsWheeler.java:790)

    - failed on trial 1 of 100
    - input = 'ABABBAABAB'

  * 10 random characters from DNA alphabet

    java.lang.IllegalArgumentException: Illegal 8-bit char = ?

    edu.princeton.cs.algs4.BinaryStdOut.write(BinaryStdOut.java:346)
    BurrowsWheeler.inverseTransform(BurrowsWheeler.java:59)
    TestBurrowsWheeler.checkTransformConsistentWithInverseTransform(TestBurrowsWheeler.java:422)
    TestBurrowsWheeler.checkTransformConsistentWithInverse

...

WARNING: the grading output was truncated due to excessive length.
Typically, this is because you have a method that has an unanticipated side effect
(such as printing to standard output or throwing an exception). A large amount of output
can also arise from failing many tests.