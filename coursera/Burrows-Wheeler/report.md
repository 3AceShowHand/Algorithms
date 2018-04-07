Test 1b: check main() on text files

*   java BurrowsWheeler + < abra.txt.bwt

    *   student length = 48
    *   reference length = 12
    *   entry 0 of the two sequences are not equal
    *   student entry = 00
    *   reference entry = 41
    *   student: 00 00 00 03 00 00 00 06 00 .. 00 00 00 00 01 00 00 00 00
    *   reference: 41 42 52 41 43 41 44 41 42 52 41 21

*   java BurrowsWheeler + < zebra.txt.bwt

    *   student length = 20
    *   reference length = 5
    *   entry 0 of the two sequences are not equal
    *   student entry = 00
    *   reference entry = 7a
    *   student: 00 00 00 04 00 00 00 03 00 00 00 01 00 00 00 00 00 00 00 02
    *   reference: 7a 65 62 72 61

*   java BurrowsWheeler + < cadabra.txt.bwt

    *   student length = 48
    *   reference length = 12
    *   entry 0 of the two sequences are not equal
    *   student entry = 00
    *   reference entry = 43
    *   student: 00 00 00 00 00 00 00 06 00 .. 00 00 00 00 01 00 00 00 00
    *   reference: 43 41 44 41 42 52 41 21 41 42 52 41

*   java BurrowsWheeler + < amendments.txt.bwt
    *   student length = 73476
    *   reference length = 18369
    *   entry 0 of the two sequences are not equal
    *   student entry = 00
    *   reference entry = 41
    *   student: 00 00 0e 2b 00 00 00 00 00 .. 00 00 00 00 00 00 00 00 00
    *   reference: 41 72 74 69 63 6c 65 20 49 .. 65 72 76 65 6e 65 64 2e 0a

==> FAILED

Test 4a: check inverseTransform() on text files

*   abra.txt.bwt

    *   student length = 48
    *   reference length = 12
    *   entry 0 of the two sequences are not equal
    *   student entry = 00
    *   reference entry = 41
    *   student: 00 00 00 03 00 00 00 06 00 .. 00 00 00 00 01 00 00 00 00
    *   reference: 41 42 52 41 43 41 44 41 42 52 41 21

*   zebra.txt.bwt

    *   student length = 20
    *   reference length = 5
    *   entry 0 of the two sequences are not equal
    *   student entry = 00
    *   reference entry = 7a
    *   student: 00 00 00 04 00 00 00 03 00 00 00 01 00 00 00 00 00 00 00 02
    *   reference: 7a 65 62 72 61

*   cadabra.txt.bwt

    *   student length = 48
    *   reference length = 12
    *   entry 0 of the two sequences are not equal
    *   student entry = 00
    *   reference entry = 43
    *   student: 00 00 00 00 00 00 00 06 00 .. 00 00 00 00 01 00 00 00 00
    *   reference: 43 41 44 41 42 52 41 21 41 42 52 41

*   amendments.txt.bwt
    *   student length = 73476
    *   reference length = 18369
    *   entry 0 of the two sequences are not equal
    *   student entry = 00
    *   reference entry = 41
    *   student: 00 00 0e 2b 00 00 00 00 00 .. 00 00 00 00 00 00 00 00 00
    *   reference: 41 72 74 69 63 6c 65 20 49 .. 65 72 76 65 6e 65 64 2e 0a

==> FAILED

Test 4b: check inverseTransform() on corner-case text files

*   alphanum.txt.bwt

    *   student length = 144
    *   reference length = 36
    *   entry 0 of the two sequences are not equal
    *   student entry = 00
    *   reference entry = 61
    *   student: 00 00 00 01 00 00 00 02 00 .. 22 00 00 00 23 00 00 00 00
    *   reference: 61 62 63 64 65 66 67 68 69 .. 31 32 33 34 35 36 37 38 39

*   a.txt.bwt

    *   student length = 4
    *   reference length = 1
    *   entry 0 of the two sequences are not equal
    *   student entry = 00
    *   reference entry = 61
    *   student: 00 00 00 00
    *   reference: 61

*   stars.txt.bwt

    *   student length = 52
    *   reference length = 13
    *   entry 0 of the two sequences are not equal
    *   student entry = 00
    *   reference entry = 2a
    *   student: 00 00 00 00 00 00 00 00 00 .. 00 00 00 00 00 00 00 00 00
    *   reference: 2a 2a 2a 2a 2a 2a 2a 2a 2a 2a 2a 2a 2a

*   couscous.txt.bwt
    *   student length = 32
    *   reference length = 8
    *   entry 0 of the two sequences are not equal
    *   student entry = 00
    *   reference entry = 63
    *   student: 00 00 00 02 00 00 00 00 00 .. 00 00 00 00 04 00 00 00 00
    *   reference: 63 6f 75 73 63 6f 75 73

==> FAILED

Test 4c: check inverseTransform() on binary files

*   us.gif.bwt

    *   student length = 49600
    *   reference length = 12400
    *   entry 0 of the two sequences are not equal
    *   student entry = 00
    *   reference entry = 47
    *   student: 00 00 00 00 00 00 00 00 00 .. 00 00 00 00 00 00 00 00 00
    *   reference: 47 49 46 38 39 61 8e 01 01 .. 7f 03 1e 38 cc 41 00 00 3b

*   CS_bricks.jpg.bwt

    *   student length = 98268
    *   reference length = 24567
    *   entry 0 of the two sequences are not equal
    *   student entry = 00
    *   reference entry = ff
    *   student: 00 00 00 00 00 00 00 00 00 .. 00 00 00 00 00 00 00 00 00
    *   reference: ff d8 ff e1 00 16 45 78 69 .. 46 8d 01 a3 46 8d 07 ff d9

*   rand10K.bin.bwt
    *   student length = 40000
    *   reference length = 10000
    *   entry 0 of the two sequences are not equal
    *   student entry = 00
    *   reference entry = 1a
    *   student: 00 00 00 00 00 00 00 00 00 .. 00 00 00 00 00 00 00 00 00
    *   reference: 1a de 9d f2 73 73 0c 05 e1 .. 46 04 ae 11 4f d4 bc 2d b4

==> FAILED

Test 4d: check inverseTransform() of transform() on random inputs

*   10 random characters from unary alphabet

    *   student length = 40
    *   reference length = 10
    *   entry 0 of the two sequences are not equal
    *   student entry = 00
    *   reference entry = 41
    *   student: 00 00 00 00 00 00 00 00 00 .. 00 00 00 00 00 00 00 00 00
    *   reference: 41 41 41 41 41 41 41 41 41 41

    *   failed on trial 1 of 2
    *   input = 'AAAAAAAAAA'

*   10 random characters from binary alphabet

    *   student length = 40
    *   reference length = 10
    *   entry 0 of the two sequences are not equal
    *   student entry = 00
    *   reference entry = 41
    *   student: 00 00 00 05 00 00 00 00 00 .. 00 00 00 00 08 00 00 00 00
    *   reference: 41 41 41 42 42 41 41 41 41 41

    *   failed on trial 1 of 100
    *   input = 'AAABBAAAAA'

*   10 random characters from DNA alphabet

    *   student length = 40
    *   reference length = 10
    *   entry 0 of the two sequences are not equal
    *   student entry = 00
    *   reference entry = 47
    *   student: 00 00 00 05 00 00 00 00 00 .. 00 00 00 00 00 00 00 00 00
    *   reference: 47 41 41 43 41 47 41 43 41 43

    *   failed on trial 1 of 100
    *   input = 'GAACAGACAC'

*   10 random characters from uppercase alphabet

    *   student length = 40
    *   reference length = 10
    *   entry 0 of the two sequences are not equal
    *   student entry = 00
    *   reference entry = 42
    *   student: 00 00 00 09 00 00 00 08 00 .. 01 00 00 00 07 00 00 00 02
    *   reference: 42 56 4d 42 43 47 4a 44 41 58

    *   failed on trial 1 of 100
    *   input = 'BVMBCGJDAX'

*   100 random characters from unary alphabet

    *   student length = 400
    *   reference length = 100
    *   entry 0 of the two sequences are not equal
    *   student entry = 00
    *   reference entry = 41
    *   student: 00 00 00 00 00 00 00 00 00 .. 00 00 00 00 00 00 00 00 00
    *   reference: 41 41 41 41 41 41 41 41 41 .. 41 41 41 41 41 41 41 41 41

    *   failed on trial 1 of 2

*   1000 random characters from binary alphabet

    *   student length = 4000
    *   reference length = 1000
    *   entry 0 of the two sequences are not equal
    *   student entry = 00
    *   reference entry = 41
    *   student: 00 00 00 00 00 00 00 00 00 .. 00 00 00 00 00 00 00 00 00
    *   reference: 41 41 41 41 41 41 41 41 41 .. 42 41 42 41 42 41 42 41 42

    *   failed on trial 1 of 100

*   1000 random characters from DNA alphabet

    *   student length = 4000
    *   reference length = 1000
    *   entry 0 of the two sequences are not equal
    *   student entry = 00
    *   reference entry = 47
    *   student: 00 00 02 0a 00 00 00 00 00 .. 00 00 00 00 00 00 00 00 00
    *   reference: 47 41 54 54 41 54 47 41 43 .. 41 47 47 47 41 47 41 41 41

    *   failed on trial 1 of 100

*   1000 random characters from uppercase alphabet

    *   student length = 4000
    *   reference length = 1000
    *   entry 0 of the two sequences are not equal
    *   student entry = 00
    *   reference entry = 52
    *   student: 00 00 00 00 00 00 00 00 00 .. 00 00 00 00 00 00 00 00 00
    *   reference: 52 58 42 57 4b 49 56 58 4f .. 42 5a 52 42 4b 42 50 47 48

    *   failed on trial 1 of 100

==> FAILED

Test 4e: check inverseTransform() of transform() on more random inputs

*   1000 random characters from ASCII alphabet

    *   student length = 4000
    *   reference length = 1000
    *   entry 0 of the two sequences are not equal
    *   student entry = 00
    *   reference entry = 52
    *   student: 00 00 00 00 00 00 00 00 00 .. 00 00 00 00 00 00 00 00 00
    *   reference: 52 24 18 6f 59 2a 32 5e 02 .. 3a 53 3e 24 43 3e 5c 25 49

    *   failed on trial 1 of 100

*   1000 random characters from extended ASCII alphabet

    *   student length = 4000
    *   reference length = 1000
    *   entry 0 of the two sequences are not equal
    *   student entry = 00
    *   reference entry = 5c
    *   student: 00 00 00 00 00 00 00 00 00 .. 00 00 00 00 00 00 00 00 00
    *   reference: 5c c3 ac cc 42 12 89 6b bb .. de e7 b3 af 0d 4f 94 77 c4

    *   failed on trial 1 of 100

*   1000 random characters from extended ASCII alphabet (excluding 0x00)

    *   student length = 4000
    *   reference length = 1000
    *   entry 0 of the two sequences are not equal
    *   student entry = 00
    *   reference entry = 34
    *   student: 00 00 00 00 00 00 00 00 00 .. 00 00 00 00 00 00 00 00 00
    *   reference: 34 a9 d4 54 1c 6a 43 61 d3 .. b2 d5 ee 56 63 2b c3 6a 1f

    *   failed on trial 1 of 100

*   1000 random characters from extended ASCII alphabet (excluding 0xFF)

    *   student length = 4000
    *   reference length = 1000
    *   entry 0 of the two sequences are not equal
    *   student entry = 00
    *   reference entry = 6b
    *   student: 00 00 00 00 00 00 00 00 00 .. 00 00 00 00 00 00 00 00 00
    *   reference: 6b d8 3f 65 35 6a f3 70 3d .. c6 d4 24 7c ab 6c 1b 4f 91

    *   failed on trial 1 of 100

==> FAILED

Test 5a: check that inverseTransform(transform()) = original on text files

*   abra.txt

    *   student length = 48
    *   reference length = 12
    *   entry 0 of the two sequences are not equal
    *   student entry = 00
    *   reference entry = 41
    *   student: 00 00 00 03 00 00 00 06 00 .. 00 00 00 00 01 00 00 00 00
    *   reference: 41 42 52 41 43 41 44 41 42 52 41 21

*   zebra.txt

    *   student length = 20
    *   reference length = 5
    *   entry 0 of the two sequences are not equal
    *   student entry = 00
    *   reference entry = 7a
    *   student: 00 00 00 04 00 00 00 03 00 00 00 01 00 00 00 00 00 00 00 02
    *   reference: 7a 65 62 72 61

*   cadabra.txt

    *   student length = 48
    *   reference length = 12
    *   entry 0 of the two sequences are not equal
    *   student entry = 00
    *   reference entry = 43
    *   student: 00 00 00 00 00 00 00 06 00 .. 00 00 00 00 01 00 00 00 00
    *   reference: 43 41 44 41 42 52 41 21 41 42 52 41

*   amendments.txt
    *   student length = 73476
    *   reference length = 18369
    *   entry 0 of the two sequences are not equal
    *   student entry = 00
    *   reference entry = 41
    *   student: 00 00 0e 2b 00 00 00 00 00 .. 00 00 00 00 00 00 00 00 00
    *   reference: 41 72 74 69 63 6c 65 20 49 .. 65 72 76 65 6e 65 64 2e 0a

==> FAILED

Test 5b: check that inverseTransform(transform()) = original on corner-case text files

*   alphanum.txt

    *   student length = 144
    *   reference length = 36
    *   entry 0 of the two sequences are not equal
    *   student entry = 00
    *   reference entry = 61
    *   student: 00 00 00 01 00 00 00 02 00 .. 22 00 00 00 23 00 00 00 00
    *   reference: 61 62 63 64 65 66 67 68 69 .. 31 32 33 34 35 36 37 38 39

*   a.txt

    *   student length = 4
    *   reference length = 1
    *   entry 0 of the two sequences are not equal
    *   student entry = 00
    *   reference entry = 61
    *   student: 00 00 00 00
    *   reference: 61

*   stars.txt

    *   student length = 52
    *   reference length = 13
    *   entry 0 of the two sequences are not equal
    *   student entry = 00
    *   reference entry = 2a
    *   student: 00 00 00 00 00 00 00 00 00 .. 00 00 00 00 00 00 00 00 00
    *   reference: 2a 2a 2a 2a 2a 2a 2a 2a 2a 2a 2a 2a 2a

*   couscous.txt
    *   student length = 32
    *   reference length = 8
    *   entry 0 of the two sequences are not equal
    *   student entry = 00
    *   reference entry = 63
    *   student: 00 00 00 02 00 00 00 00 00 .. 00 00 00 00 04 00 00 00 00
    *   reference: 63 6f 75 73 63 6f 75 73

==> FAILED

Test 5c: check that inverseTransform(transform()) = original on binary files

*   us.gif

    *   student length = 49600
    *   reference length = 12400
    *   entry 0 of the two sequences are not equal
    *   student entry = 00
    *   reference entry = 47
    *   student: 00 00 00 00 00 00 00 00 00 .. 00 00 00 00 00 00 00 00 00
    *   reference: 47 49 46 38 39 61 8e 01 01 .. 7f 03 1e 38 cc 41 00 00 3b

*   CS_bricks.jpg

    *   student length = 98268
    *   reference length = 24567
    *   entry 0 of the two sequences are not equal
    *   student entry = 00
    *   reference entry = ff
    *   student: 00 00 00 00 00 00 00 00 00 .. 00 00 00 00 00 00 00 00 00
    *   reference: ff d8 ff e1 00 16 45 78 69 .. 46 8d 01 a3 46 8d 07 ff d9

*   rand10K.bin
    *   student length = 40000
    *   reference length = 10000
    *   entry 0 of the two sequences are not equal
    *   student entry = 00
    *   reference entry = 1a
    *   student: 00 00 00 00 00 00 00 00 00 .. 00 00 00 00 00 00 00 00 00
    *   reference: 1a de 9d f2 73 73 0c 05 e1 .. 46 04 ae 11 4f d4 bc 2d b4

==> FAILED

Test 5d: check that inverseTransform(tranform()) = original on random inputs

*   10 random characters from binary alphabet

    *   student length = 40
    *   reference length = 10
    *   entry 0 of the two sequences are not equal
    *   student entry = 00
    *   reference entry = 41
    *   student: 00 00 00 08 00 00 00 00 00 .. 00 00 00 00 00 00 00 00 00
    *   reference: 41 41 41 41 41 42 41 41 41 42

    *   failed on trial 1 of 100
    *   input = 'AAAAABAAAB'

*   10 random characters from DNA alphabet

    *   student length = 40
    *   reference length = 10
    *   entry 0 of the two sequences are not equal
    *   student entry = 00
    *   reference entry = 43
    *   student: 00 00 00 05 00 00 00 00 00 .. 00 00 00 00 03 00 00 00 00
    *   reference: 43 54 43 41 41 43 47 47 54 41

    *   failed on trial 1 of 100
    *   input = 'CTCAACGGTA'

*   10 random characters from uppercase alphabet

    *   student length = 40
    *   reference length = 10
    *   entry 0 of the two sequences are not equal
    *   student entry = 00
    *   reference entry = 44
    *   student: 00 00 00 02 00 00 00 00 00 .. 03 00 00 00 09 00 00 00 06
    *   reference: 44 42 45 4e 53 4c 4d 59 5a 51

    *   failed on trial 1 of 100
    *   input = 'DBENSLMYZQ'

*   1000 random characters from binary alphabet

    *   student length = 4000
    *   reference length = 1000
    *   entry 0 of the two sequences are not equal
    *   student entry = 00
    *   reference entry = 42
    *   student: 00 00 00 00 00 00 00 00 00 .. 00 00 00 00 00 00 00 00 00
    *   reference: 42 42 41 42 42 42 41 42 41 .. 41 41 41 41 41 41 41 41 42

    *   failed on trial 1 of 100

*   1000 random characters from DNA alphabet

    *   student length = 4000
    *   reference length = 1000
    *   entry 0 of the two sequences are not equal
    *   student entry = 00
    *   reference entry = 43
    *   student: 00 00 02 ef 00 00 00 00 00 .. 00 00 00 00 00 00 00 00 00
    *   reference: 43 47 43 43 43 43 41 43 43 .. 47 54 41 54 41 41 54 43 54

    *   failed on trial 1 of 100

*   1000 random characters from uppercase alphabet

    *   student length = 4000
    *   reference length = 1000
    *   entry 0 of the two sequences are not equal
    *   student entry = 00
    *   reference entry = 43
    *   student: 00 00 00 00 00 00 00 00 00 .. 00 00 00 00 00 00 00 00 00
    *   reference: 43 5a 4f 49 4a 4b 4d 58 46 .. 41 56 56 47 41 44 55 53 5a

    *   failed on trial 1 of 100

==> FAILED

Test 5e: check that inverseTransform(tranform()) = original on random inputs

*   1000 random characters from ASCII alphabet
    *   student length = 4000
    *   reference length = 1000

...

WARNING: the grading output was truncated due to excessive length.
Typically, this is because you have a method that has an unanticipated side effect
(such as printing to standard output or throwing an exception). A large amount of output
can also arise from failing many tests.
