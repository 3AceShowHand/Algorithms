
Test 1b: check main() on text files
  * java BurrowsWheeler + < abra.txt.bwt
    - entry 0 of the two sequences are not equal
    - student   entry = 21
    - reference entry = 41
    - student:   21 41 41 41 41 41 41 41 41 41 41 41 
    - reference: 41 42 52 41 43 41 44 41 42 52 41 21 

  * java BurrowsWheeler + < zebra.txt.bwt
    - entry 0 of the two sequences are not equal
    - student   entry = 61
    - reference entry = 7a
    - student:   61 7a 7a 7a 7a 
    - reference: 7a 65 62 72 61 

  * java BurrowsWheeler + < cadabra.txt.bwt
    - entry 0 of the two sequences are not equal
    - student   entry = 41
    - reference entry = 43
    - student:   41 43 43 43 43 43 43 43 43 43 43 43 
    - reference: 43 41 44 41 42 52 41 21 41 42 52 41 

  * java BurrowsWheeler + < amendments.txt.bwt
    - entry 0 of the two sequences are not equal
    - student   entry = 0a
    - reference entry = 41
    - student:   0a 41 41 41 41 41 41 41 41 .. 41 41 41 41 41 41 41 41 41 
    - reference: 41 72 74 69 63 6c 65 20 49 .. 65 72 76 65 6e 65 64 2e 0a 

==> FAILED

Test 2a: check that main() is consistent with transform() on text files
  * abra.txt
  * zebra.txt
  * cadabra.txt
  * amendments.txt
==> passed

Test 2b: check that main() is consistent with inverseTransform() on text files
  * abra.txt.bwt
  * zebra.txt.bwt
  * cadabra.txt.bwt
  * amendments.txt.bwt
==> passed

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
    - entry 0 of the two sequences are not equal
    - student   entry = 21
    - reference entry = 41
    - student:   21 41 41 41 41 41 41 41 41 41 41 41 
    - reference: 41 42 52 41 43 41 44 41 42 52 41 21 

  * zebra.txt.bwt
    - entry 0 of the two sequences are not equal
    - student   entry = 61
    - reference entry = 7a
    - student:   61 7a 7a 7a 7a 
    - reference: 7a 65 62 72 61 

  * cadabra.txt.bwt
    - entry 0 of the two sequences are not equal
    - student   entry = 41
    - reference entry = 43
    - student:   41 43 43 43 43 43 43 43 43 43 43 43 
    - reference: 43 41 44 41 42 52 41 21 41 42 52 41 

  * amendments.txt.bwt
    - entry 0 of the two sequences are not equal
    - student   entry = 0a
    - reference entry = 41
    - student:   0a 41 41 41 41 41 41 41 41 .. 41 41 41 41 41 41 41 41 41 
    - reference: 41 72 74 69 63 6c 65 20 49 .. 65 72 76 65 6e 65 64 2e 0a 

==> FAILED

Test 4b: check inverseTransform() on corner-case text files
  * alphanum.txt.bwt
    - entry 0 of the two sequences are not equal
    - student   entry = 39
    - reference entry = 61
    - student:   39 61 61 61 61 61 61 61 61 .. 61 61 61 61 61 61 61 61 61 
    - reference: 61 62 63 64 65 66 67 68 69 .. 31 32 33 34 35 36 37 38 39 

  * a.txt.bwt
  * stars.txt.bwt
  * couscous.txt.bwt
    - entry 0 of the two sequences are not equal
    - student   entry = 73
    - reference entry = 63
    - student:   73 63 63 63 63 63 63 63 
    - reference: 63 6f 75 73 63 6f 75 73 

==> FAILED

Test 4c: check inverseTransform() on binary files
  * us.gif.bwt
    - entry 0 of the two sequences are not equal
    - student   entry = 3b
    - reference entry = 47
    - student:   3b 47 47 47 47 47 47 47 47 .. 47 47 47 47 47 47 47 47 47 
    - reference: 47 49 46 38 39 61 8e 01 01 .. 7f 03 1e 38 cc 41 00 00 3b 

  * CS_bricks.jpg.bwt
    - entry 0 of the two sequences are not equal
    - student   entry = d9
    - reference entry = ff
    - student:   d9 ff ff ff ff ff ff ff ff .. ff ff ff ff ff ff ff ff ff 
    - reference: ff d8 ff e1 00 16 45 78 69 .. 46 8d 01 a3 46 8d 07 ff d9 

  * rand10K.bin.bwt
    - entry 0 of the two sequences are not equal
    - student   entry = b4
    - reference entry = 1a
    - student:   b4 1a 1a 1a 1a 1a 1a 1a 1a .. 1a 1a 1a 1a 1a 1a 1a 1a 1a 
    - reference: 1a de 9d f2 73 73 0c 05 e1 .. 46 04 ae 11 4f d4 bc 2d b4 

==> FAILED

Test 4d: check inverseTransform() of transform() on random inputs
  * 10 random characters from unary alphabet
  * 10 random characters from binary alphabet
    - entry 0 of the two sequences are not equal
    - student   entry = 42
    - reference entry = 41
    - student:   42 41 41 41 41 41 41 41 41 41 
    - reference: 41 41 41 42 42 41 42 41 42 42 

    - failed on trial 1 of 100
    - input = 'AAABBABABB'

  * 10 random characters from DNA alphabet
    - entry 0 of the two sequences are not equal
    - student   entry = 47
    - reference entry = 43
    - student:   47 43 43 43 43 43 43 43 43 43 
    - reference: 43 41 47 41 43 43 43 54 47 47 

    - failed on trial 1 of 100
    - input = 'CAGACCCTGG'

  * 10 random characters from uppercase alphabet
    - entry 0 of the two sequences are not equal
    - student   entry = 59
    - reference entry = 41
    - student:   59 41 41 41 41 41 41 41 41 41 
    - reference: 41 52 41 4c 4a 4d 4a 56 4c 59 

    - failed on trial 1 of 100
    - input = 'ARALJMJVLY'

  * 100 random characters from unary alphabet
  * 1000 random characters from binary alphabet
    - entry 1 of the two sequences are not equal
    - student   entry = 41
    - reference entry = 42
    - student:   41 41 41 41 41 41 41 41 41 .. 41 41 41 41 41 41 41 41 41 
    - reference: 41 42 42 41 42 42 41 42 42 .. 42 41 42 41 42 41 42 41 41 

    - failed on trial 1 of 100

  * 1000 random characters from DNA alphabet
    - entry 1 of the two sequences are not equal
    - student   entry = 43
    - reference entry = 41
    - student:   43 43 43 43 43 43 43 43 43 .. 43 43 43 43 43 43 43 43 43 
    - reference: 43 41 43 41 47 54 41 41 43 .. 54 41 41 47 54 43 47 54 43 

    - failed on trial 1 of 100

  * 1000 random characters from uppercase alphabet
    - entry 0 of the two sequences are not equal
    - student   entry = 55
    - reference entry = 5a
    - student:   55 5a 5a 5a 5a 5a 5a 5a 5a .. 5a 5a 5a 5a 5a 5a 5a 5a 5a 
    - reference: 5a 48 4c 44 4a 49 47 54 51 .. 42 44 49 4c 5a 4a 48 41 55 

    - failed on trial 1 of 100

==> FAILED

Test 4e: check inverseTransform() of transform() on more random inputs
  * 1000 random characters from ASCII alphabet 
    - entry 0 of the two sequences are not equal
    - student   entry = 0c
    - reference entry = 72
    - student:   0c 72 72 72 72 72 72 72 72 .. 72 72 72 72 72 72 72 72 72 
    - reference: 72 5c 0a 27 17 1f 41 62 16 .. 1b 6a 7d 2f 29 24 03 0f 0c 

    - failed on trial 1 of 100

  * 1000 random characters from extended ASCII alphabet
    - entry 0 of the two sequences are not equal
    - student   entry = a6
    - reference entry = fe
    - student:   a6 fe fe fe fe fe fe fe fe .. fe fe fe fe fe fe fe fe fe 
    - reference: fe d7 b4 07 b3 1a cf 8b a4 .. 68 76 30 f3 a0 95 e1 e1 a6 

    - failed on trial 1 of 100

  * 1000 random characters from extended ASCII alphabet (excluding 0x00)
    - entry 0 of the two sequences are not equal
    - student   entry = 3f
    - reference entry = 79
    - student:   3f 79 79 79 79 79 79 79 79 .. 79 79 79 79 79 79 79 79 79 
    - reference: 79 3c 9c ce 4b 68 db 89 ac .. db 4c eb a2 4f e8 01 5c 3f 

    - failed on trial 1 of 100

  * 1000 random characters from extended ASCII alphabet (excluding 0xFF)
    - entry 0 of the two sequences are not equal
    - student   entry = 4f
    - reference entry = d7
    - student:   4f d7 d7 d7 d7 d7 d7 d7 d7 .. d7 d7 d7 d7 d7 d7 d7 d7 d7 
    - reference: d7 a9 f7 bc 3d 37 93 d6 c9 .. f7 66 9c 06 2d 7d bd 1d 4f 

    - failed on trial 1 of 100

==> FAILED

Test 5a: check that inverseTransform(transform()) = original on text files
  * abra.txt
    - entry 0 of the two sequences are not equal
    - student   entry = 21
    - reference entry = 41
    - student:   21 41 41 41 41 41 41 41 41 41 41 41 
    - reference: 41 42 52 41 43 41 44 41 42 52 41 21 

  * zebra.txt
    - entry 0 of the two sequences are not equal
    - student   entry = 61
    - reference entry = 7a
    - student:   61 7a 7a 7a 7a 
    - reference: 7a 65 62 72 61 

  * cadabra.txt
    - entry 0 of the two sequences are not equal
    - student   entry = 41
    - reference entry = 43
    - student:   41 43 43 43 43 43 43 43 43 43 43 43 
    - reference: 43 41 44 41 42 52 41 21 41 42 52 41 

  * amendments.txt
    - entry 0 of the two sequences are not equal
    - student   entry = 0a
    - reference entry = 41
    - student:   0a 41 41 41 41 41 41 41 41 .. 41 41 41 41 41 41 41 41 41 
    - reference: 41 72 74 69 63 6c 65 20 49 .. 65 72 76 65 6e 65 64 2e 0a 

==> FAILED

Test 5b: check that inverseTransform(transform()) = original on corner-case text files
  * alphanum.txt
    - entry 0 of the two sequences are not equal
    - student   entry = 39
    - reference entry = 61
    - student:   39 61 61 61 61 61 61 61 61 .. 61 61 61 61 61 61 61 61 61 
    - reference: 61 62 63 64 65 66 67 68 69 .. 31 32 33 34 35 36 37 38 39 

  * a.txt
  * stars.txt
  * couscous.txt
    - entry 0 of the two sequences are not equal
    - student   entry = 73
    - reference entry = 63
    - student:   73 63 63 63 63 63 63 63 
    - reference: 63 6f 75 73 63 6f 75 73 

==> FAILED

Test 5c: check that inverseTransform(transform()) = original on binary files
  * us.gif
    - entry 0 of the two sequences are not equal
    - student   entry = 3b
    - reference entry = 47
    - student:   3b 47 47 47 47 47 47 47 47 .. 47 47 47 47 47 47 47 47 47 
    - reference: 47 49 46 38 39 61 8e 01 01 .. 7f 03 1e 38 cc 41 00 00 3b 

  * CS_bricks.jpg
    - entry 0 of the two sequences are not equal
    - student   entry = d9
    - reference entry = ff
    - student:   d9 ff ff ff ff ff ff ff ff .. ff ff ff ff ff ff ff ff ff 
    - reference: ff d8 ff e1 00 16 45 78 69 .. 46 8d 01 a3 46 8d 07 ff d9 

  * rand10K.bin
    - entry 0 of the two sequences are not equal
    - student   entry = b4
    - reference entry = 1a
    - student:   b4 1a 1a 1a 1a 1a 1a 1a 1a .. 1a 1a 1a 1a 1a 1a 1a 1a 1a 
    - reference: 1a de 9d f2 73 73 0c 05 e1 .. 46 04 ae 11 4f d4 bc 2d b4 

==> FAILED

Test 5d: check that inverseTransform(tranform()) = original on random inputs
  * 10 random characters from binary alphabet
    - entry 0 of the two sequences are not equal
    - student   entry = 42
    - reference entry = 41
    - student:   42 41 41 41 41 41 41 41 41 41 
    - reference: 41 42 42 42 42 42 42 42 42 42 

    - failed on trial 1 of 100
    - input = 'ABBBBBBBBB'

  * 10 random characters from DNA alphabet
    - entry 1 of the two sequences are not equal
    - student   entry = 47
    - reference entry = 41
    - student:   47 47 47 47 47 47 47 47 47 47 
    - reference: 47 41 41 43 43 54 41 47 43 47 

    - failed on trial 1 of 100
    - input = 'GAACCTAGCG'

  * 10 random characters from uppercase alphabet
    - entry 0 of the two sequences are not equal
    - student   entry = 46
    - reference entry = 50
    - student:   46 50 50 50 50 50 50 50 50 50 
    - reference: 50 47 4c 56 4a 54 41 47 4c 46 

    - failed on trial 1 of 100
    - input = 'PGLVJTAGLF'

  * 1000 random characters from binary alphabet
    - entry 1 of the two sequences are not equal
    - student   entry = 42
    - reference entry = 41
    - student:   42 42 42 42 42 42 42 42 42 .. 42 42 42 42 42 42 42 42 42 
    - reference: 42 41 41 41 41 41 42 42 42 .. 42 42 41 41 41 42 41 41 42 

    - failed on trial 1 of 100

  * 1000 random characters from DNA alphabet
    - entry 0 of the two sequences are not equal
    - student   entry = 41
    - reference entry = 43
    - student:   41 43 43 43 43 43 43 43 43 .. 43 43 43 43 43 43 43 43 43 
    - reference: 43 47 47 54 43 41 43 47 43 .. 43 41 54 47 41 47 47 47 41 

    - failed on trial 1 of 100

  * 1000 random characters from uppercase alphabet
    - entry 0 of the two sequences are not equal
    - student   entry = 43
    - reference entry = 4e
    - student:   43 4e 4e 4e 4e 4e 4e 4e 4e .. 4e 4e 4e 4e 4e 4e 4e 4e 4e 
    - reference: 4e 41 44 54 4d 51 57 4a 45 .. 53 44 4b 59 4a 4c 55 49 43 

    - failed on trial 1 of 100

==> FAILED

Test 5e: check that inverseTransform(tranform()) = original on random inputs
  * 1000 random characters from ASCII alphabet 
    - entry 0 of the two sequences are not equal
    - student   entry = 22
    - reference entry = 45
    - student:   22 45 45 45 45 45 45 45 45 .. 45 45 45 45 45 45 45 45 45 
    - reference: 45 4b 2e 04 42 2d 48 5a 76 .. 53 4c 0a 24 79 37 6a 2f 22 

    - failed on trial 1 of 100

  * 1000 random characters from extended ASCII alphabet
    - entry 0 of the two sequences are not equal
    - student   entry = 3f
    - reference entry = 02
    - student:   3f 02 02 02 02 02 02 02 02 .. 02 02 02 02 02 02 02 02 02 
    - reference: 02 e4 17 6f 3e d1 dd 68 5f .. 3c 4e 93 0d 28 04 a3 fb 3f 

    - failed on trial 1 of 100

  * 1000 random characters from extended ASCII alphabet (excluding 0x00)
    - entry 0 of the two sequences are not equal
    - student   entry = e7
    - reference entry = a9
    - student:   e7 a9 a9 a9 a9 a9 a9 a9 a9 .. a9 a9 a9 a9 a9 a9 a9 a9 a9 
    - reference: a9 a1 72 a5 0f 43 ca 97 fa .. 8d ae 5d 6e 4a 79 1c 13 e7 

    - failed on trial 1 of 100

  * 1000 random characters from extended ASCII alphabet (excluding 0xFF)
    - entry 0 of the two sequences are not equal
    - student   entry = 69
    - reference entry = f2
    - student:   69 f2 f2 f2 f2 f2 f2 f2 f2 .. f2 f2 f2 f2 f2 f2 f2 f2 f2 
    - reference: f2 4e ae 09 24 20 e8 39 60 .. f5 f4 bb 7e 6d d1 fc 57 69 

    - failed on trial 1 of 100

==> FAILED

Test 5f: check that inverseTransform(tranform()) = original
         on random inputs that are circular shifts of themselves
  * random strings from unary alphabet
  * random strings from binary alphabet
    - entry 0 of the two sequences are not equal
    - student   entry = 42
    - reference entry = 41
    - student:   42 41 41 41 41 41 41 41 41 41 41 41 41 41 41 41 41 41 41 41 
    - reference: 41 42 42 42 42 41 42 42 42 42 41 42 42 42 42 41 42 42 42 42 

    - failed on trial 1 of 100
    - input = 'ABBBBABBBBABBBBABBBB'

  * random strings from DNA alphabet
    - entry 0 of the two sequences are not equal
    - student   entry = 54
    - reference entry = 47
    - student:   54 47 47 47 47 47 47 47 47 .. 47 47 47 47 47 47 47 47 47 
    - reference: 47 41 41 47 54 47 41 41 47 .. 41 41 47 54 47 41 41 47 54 

    - failed on trial 1 of 100
    - input = 'GAAGTGAAGTGAAGTGAAGTGAAGT'

  * random strings from uppercase alphabet
    - entry 0 of the two sequences are not equal
    - student   entry = 50
    - reference entry = 5a
    - student:   50 5a 5a 5a 5a 5a 5a 5a 5a 5a 5a 5a 5a 5a 5a 5a 5a 5a 5a 5a 
    - reference: 5a 50 46 55 50 5a 50 46 55 50 5a 50 46 55 50 5a 50 46 55 50 

    - failed on trial 1 of 100
    - input = 'ZPFUPZPFUPZPFUPZPFUP'

==> FAILED

Test 6a: check that transform() calls either close() or flush()
  * amendments.txt
  * aesop.txt
==> passed

Test 6b: check that inverseTransform() calls either close() or flush()
  * amendments.txt.bwt
    - entry 0 of the two sequences are not equal
    - student   entry = 0a
    - reference entry = 41
    - student:   0a 41 41 41 41 41 41 41 41 .. 41 41 41 41 41 41 41 41 41 
    - reference: 41 72 74 69 63 6c 65 20 49 .. 65 72 76 65 6e 65 64 2e 0a 

  * aesop.txt.bwt
    - entry 0 of the two sequences are not equal
    - student   entry = 0a
    - reference entry = 41
    - student:   0a 41 41 41 41 41 41 41 41 .. 41 41 41 41 41 41 41 41 41 
    - reference: 41 65 73 6f 70 27 73 20 46 .. 72 20 73 75 6e 73 3f 22 0a 

==> FAILED

Test 7a: check transform() on large files
  * rand100K.bin
  * world192.txt
==> passed

Test 7b: check inverseTransform() on large files
  * rand100K.bin.bwt
    - entry 0 of the two sequences are not equal
    - student   entry = 38
    - reference entry = 73
    - student:   38 73 73 73 73 73 73 73 73 .. 73 73 73 73 73 73 73 73 73 
    - reference: 73 fe be 6c 9d a3 82 eb 5e .. f5 60 4f 60 99 82 d5 72 38 

  * world192.txt.bwt
    - entry 0 of the two sequences are not equal
    - student   entry = 0a
    - reference entry = 2a
    - student:   0a 2a 2a 2a 2a 2a 2a 2a 2a .. 2a 2a 2a 2a 2a 2a 2a 2a 2a 
    - reference: 2a 2a 2a 2a 54 68 65 20 50 .. 72 6c 61 6e 64 0d 0a 0d 0a 

==> FAILED

Test 7c: check that inverseTransform(transform()) = original on large files
  * rand100K.bin
    - entry 0 of the two sequences are not equal
    - student   entry = 38
    - reference entry = 73
    - student:   38 73 73 73 73 73 73 73 73 .. 73 73 73 73 73 73 73 73 73 
    - reference: 73 fe be 6c 9d a3 82 eb 5e .. f5 60 4f 60 99 82 d5 72 38 

  * world192.txt
    - entry 0 of the two sequences are not equal
    - student   entry = 0a
    - reference entry = 2a
    - student:   0a 2a 2a 2a 2a 2a 2a 2a 2a .. 2a 2a 2a 2a 2a 2a 2a 2a 2a 
    - reference: 2a 2a 2a 2a 54 68 65 20 50 .. 72 6c 61 6e 64 0d 0a 0d 0a 

==> FAILED


Total: 11/26 tests passed!


================================================================
********************************************************************************
*  MEMORY
********************************************************************************

Analyzing memory of CircularSuffixArray
*-----------------------------------------------------------
Running 10 total tests.

Memory usage of a CircularSuffixArray for a random string of length n.
Maximum allowed memory is 64n + 128.

                 n        bytes
-------------------------------
=> passed       16          560
=> passed       32         1072
=> passed       64         2096
=> passed      128         4144
=> passed      256         8240
=> passed      512        16432
=> passed     1024        32816
=> passed     2048        65584
=> passed     4096       131120
=> passed     8192       262192
==> 10/10 tests passed

Total: 10/10 tests passed!

Estimated student memory (bytes) = 32.00 n + 48.00   (R^2 = 1.000)
================================================================



********************************************************************************
*  TIMING
********************************************************************************

Timing CircularSuffixArray
*-----------------------------------------------------------
Running 26 total tests.

Tests  1-13: time to create a circular suffix array for the first
             n character of dickens.txt and call index(i) for each i

            [ max allowed time = 10 seconds and <= 12x reference ]

                 n    student  reference      ratio
---------------------------------------------------
=> passed     1000       0.01       0.00      11.30
=> passed     2000       0.00       0.00       3.60
=> passed     4000       0.01       0.00       3.77
=> passed     8000       0.01       0.00       2.83
=> passed    16000       0.01       0.01       2.53
=> passed    32000       0.04       0.01       5.06
=> passed    64000       0.09       0.01      14.77
=> passed   128000       0.15       0.02       9.25
=> passed   256000       0.25       0.03       9.39
=> passed   512000       0.47       0.05       9.36
=> passed  1024000       1.07       0.11       9.88
=> passed  2048000       2.42       0.28       8.70
=> passed  4096000       5.76       0.64       9.01

Estimated running time (using last 6 measurements)
    = 4.49e-07 * n^1.07  (R^2 = 0.99)


Tests 14-26: time to create circular suffix array for n random ASCII characters
            and call index(i) for each i

            [ max allowed time = 10 seconds and <= 20x reference ]

                 n    student  reference      ratio
---------------------------------------------------
=> passed     1000       0.00       0.00       9.04
=> passed     2000       0.00       0.00       5.67
=> passed     4000       0.00       0.00       3.58
=> passed     8000       0.00       0.00       5.47
=> passed    16000       0.01       0.00       5.45
=> passed    32000       0.01       0.00       7.55
=> passed    64000       0.03       0.00       7.58
=> passed   128000       0.06       0.01       7.22
=> passed   256000       0.12       0.03       4.50
=> passed   512000       0.27       0.06       4.27
=> passed  1024000       0.61       0.06      10.73
=> passed  2048000       1.41       0.14      10.22
=> passed  4096000       3.45       0.31      10.99

Estimated running time (using last 6 measurements)
    = 4.77e-08 * n^1.19  (R^2 = 1.00)


Total: 26/26 tests passed!


================================================================



********************************************************************************
*  TIMING
********************************************************************************

Timing MoveToFront
*-----------------------------------------------------------
Running 38 total tests.

Test 1: count calls to methods in BinaryStdOut from encode()
  * abra.txt
  * amendments.txt
==> passed

Test 2: count calls to methods in BinaryStdOut from decode()
  * abra.txt.mtf
  * amendments.txt.mtf
==> passed

Tests  3-12: Timing encode() with first n character of dickens.txt
             [ max allowed time = 2 seconds and <= 4x reference ]

                 n    student  reference      ratio
---------------------------------------------------
=> passed     1000       0.00       0.00       1.83
=> passed     2000       0.01       0.00       2.60
=> passed     4000       0.01       0.00       2.53
=> passed     8000       0.02       0.01       2.41
=> passed    16000       0.04       0.02       2.30
=> passed    32000       0.08       0.04       2.25
=> passed    64000       0.16       0.08       2.09
=> passed   128000       0.31       0.14       2.16
=> passed   256000       0.59       0.28       2.07

Estimated running time (using last 6 measurements)
     = 4.88e-06 * n^0.94  (R^2 = 1.00)


Tests  13-20: Timing encode() with first n character of abab.txt
             [ max allowed time = 2 seconds and <= 4x reference ]

                 n    student  reference      ratio
---------------------------------------------------
=> passed     1000       0.00       0.00       1.47
=> passed     2000       0.00       0.00       1.35
=> passed     4000       0.01       0.00       1.27
=> passed     8000       0.01       0.01       1.18
=> passed    16000       0.02       0.02       1.16
=> passed    32000       0.04       0.03       1.16
=> passed    64000       0.07       0.06       1.16
=> passed   128000       0.14       0.12       1.15
=> passed   256000       0.29       0.27       1.07

Estimated running time (using last 6 measurements)
     = 1.13e-06 * n^1.00  (R^2 = 1.00)


Tests 21-29: Timing decode() with first n character of dickens.txt
             [ max allowed time = 2 seconds and <= 4x reference ]

                 n    student  reference      ratio
---------------------------------------------------
=> passed     1000       0.00       0.00       3.51
=> passed     2000       0.01       0.00       3.39
=> passed     4000       0.01       0.00       3.27
=> passed     8000       0.03       0.01       3.11
=> passed    16000       0.05       0.02       2.99
=> passed    32000       0.09       0.03       2.88
=> passed    64000       0.18       0.07       2.78
=> passed   128000       0.35       0.13       2.76
=> passed   256000       0.68       0.25       2.67

Estimated running time (using last 6 measurements)
     = 5.32e-06 * n^0.94  (R^2 = 1.00)


Tests 30-38: Timing decode() with first n character of abab.txt
             [ max allowed time = 2 seconds and <= 4x reference ]

                 n    student  reference      ratio
---------------------------------------------------
=> passed     1000       0.00       0.00       1.96
=> passed     2000       0.00       0.00       1.79
=> passed     4000       0.01       0.00       1.75
=> passed     8000       0.01       0.01       1.71
=> passed    16000       0.03       0.02       1.70
=> passed    32000       0.05       0.03       1.70
=> passed    64000       0.10       0.06       1.69
=> passed   128000       0.20       0.12       1.69
=> passed   256000       0.40       0.24       1.69

Estimated running time (using last 6 measurements)
     = 1.67e-06 * n^1.00  (R^2 = 1.00)


Total: 38/38 tests passed!


================================================================



********************************************************************************
*  TIMING (substituting reference CircularSuffixArray)
********************************************************************************

Timing BurrowsWheeler
*-----------------------------------------------------------
Running 95 total tests.

Test 1: count calls to methods in CircularSuffixArray from transform()
  * abra.txt
  * amendments.txt
==> passed

Test 2: count calls to methods in CircularSuffixArray from inverseTransform()
  * abra.txt.bwt
  * amendments.txt.bwt
==> passed

Test 3: count calls to methods in BinaryStdOut from transform()
  * abra.txt
  * amendments.txt
==> passed

Test 4: count calls to methods in BinaryStdOut from inverseTransform()
  * abra.txt.bwt
  * amendments.txt.bwt
==> passed

Tests  5-17: timing transform() with first n character of dickens.txt
             [ max allowed time = 2 seconds and <= 8x reference ]

                 n    student  reference      ratio
---------------------------------------------------
=> passed     1000       0.00       0.00       0.10
=> passed     2000       0.00       0.00       0.65
=> passed     4000       0.00       0.00       0.67
=> passed     8000       0.00       0.00       0.82
=> passed    16000       0.00       0.01       0.56
=> passed    32000       0.01       0.01       0.86
=> passed    64000       0.01       0.01       0.69
=> passed   128000       0.02       0.02       0.98
=> passed   256000       0.04       0.04       0.99
=> passed   512000       0.08       0.08       1.00
=> passed  1024000       0.16       0.16       0.99
=> passed  2048000       0.40       0.39       1.02
=> passed  4096000       0.89       0.91       0.97

Estimated running time as a function of n (using last 6 measurements)
    = 2.81e-08 * n^1.13  (R^2 = 1.00)


Tests 18-30: timing transform() with first n character of random.bin
             [ max allowed time = 2 seconds and <= 8x reference ]

                 n    student  reference      ratio
---------------------------------------------------
=> passed     1000       0.00       0.00       0.65
=> passed     2000       0.00       0.00       0.94
=> passed     4000       0.00       0.00       0.92
=> passed     8000       0.00       0.00       0.86
=> passed    16000       0.00       0.00       0.96
=> passed    32000       0.01       0.00       1.30
=> passed    64000       0.01       0.01       0.95
=> passed   128000       0.02       0.02       0.98
=> passed   256000       0.04       0.04       0.98
=> passed   512000       0.08       0.08       0.98
=> passed  1024000       0.18       0.18       0.99
=> passed  2048000       0.42       0.43       0.97
=> passed  4096000       1.02       1.00       1.02

Estimated running time as a function of n (using last 6 measurements)
    = 2.82e-08 * n^1.14  (R^2 = 1.00)


Tests 31-43: timing transform() with first n character of abab.txt
             [ max allowed time = 2 seconds and <= 8x reference ]

                 n    student  reference      ratio
---------------------------------------------------
=> passed     1000       0.00       0.00       0.78
=> passed     2000       0.00       0.00       0.94
=> passed     4000       0.00       0.00       0.90
=> passed     8000       0.00       0.00       1.01
=> passed    16000       0.00       0.00       0.97
=> passed    32000       0.00       0.00       0.98
=> passed    64000       0.00       0.00       0.90
=> passed   128000       0.01       0.00       1.76
=> passed   256000       0.01       0.01       0.69
=> passed   512000       0.02       0.01       1.44
=> passed  1024000       0.02       0.03       0.82
=> passed  2048000       0.05       0.05       0.89
=> passed  4096000       0.10       0.11       0.87

Estimated running time as a function of n (using last 6 measurements)
    = 2.95e-07 * n^0.83  (R^2 = 0.96)


Tests 44-56: timing inverseTransform() with first n character of dickens.txt
             [ max allowed time = 2 seconds and <= 8x reference ]

                 n    student  reference      ratio
---------------------------------------------------
=> passed     1000       0.00       0.00       0.41
=> passed     2000       0.00       0.00       0.30
=> passed     4000       0.00       0.00       0.20
=> passed     8000       0.00       0.00       0.19
=> passed    16000       0.00       0.00       0.18
=> passed    32000       0.00       0.00       0.60
=> passed    64000       0.00       0.00       0.48
=> passed   128000       0.00       0.01       0.44
=> passed   256000       0.00       0.01       0.63
=> passed   512000       0.01       0.02       0.52
=> passed  1024000       0.02       0.04       0.44
=> passed  2048000       0.05       0.12       0.40
=> passed  4096000       0.14       0.36       0.39

Estimated running time as a function of n (using last 6 measurements)
    = 3.58e-09 * n^1.13  (R^2 = 0.99)


Tests 57-69: timing inverseTransform() with first n character of random.bin
             [ max allowed time = 2 seconds and <= 8x reference ]

                 n    student  reference      ratio
---------------------------------------------------
=> passed     1024       0.00       0.00       0.99
=> passed     2048       0.00       0.00       1.01
=> passed     4096       0.00       0.00       1.02
=> passed     8192       0.00       0.00       0.93
=> passed    16384       0.00       0.00       0.98
=> passed    32768       0.00       0.00       1.04
=> passed    65536       0.00       0.00       0.85
=> passed   131072       0.00       0.01       0.79
=> passed   262144       0.01       0.01       0.76
=> passed   524288       0.02       0.03       0.67
=> passed  1048576       0.02       0.05       0.41
=> passed  2097152       0.04       0.11       0.36
=> passed  4194304       0.08       0.34       0.25

Estimated running time as a function of n (using last 6 measurements)
    = 4.38e-07 * n^0.79  (R^2 = 0.98)


Tests 70-82: timing inverseTransform() with first n character of abab.txt
             [ max allowed time = 2 seconds and <= 8x reference ]

                 n    student  reference      ratio
---------------------------------------------------
=> passed     1000       0.00       0.00       0.77
=> passed     2000       0.00       0.00       0.83
=> passed     4000       0.00       0.00       0.89
=> passed     8000       0.00       0.00       0.73
=> passed    16000       0.00       0.00       0.88
=> passed    32000       0.00       0.00       0.86
=> passed    64000       0.00       0.00       0.86
=> passed   128000       0.00       0.00       0.90
=> passed   256000       0.01       0.01       0.94
=> passed   512000       0.01       0.01       0.90
=> passed  1024000       0.02       0.02       0.90
=> passed  2048000       0.04       0.04       0.90
=> passed  4096000       0.08       0.09       0.91

Estimated running time as a function of n (using last 6 measurements)
    = 2.09e-08 * n^1.00  (R^2 = 1.00)


Tests 83-95: timing inverseTransform() with first n character of cyclic.bin
             [ max allowed time = 2 seconds and <= 8x reference ]

                 n    student  reference      ratio
---------------------------------------------------
=> passed     1024       0.00       0.00       0.78
=> passed     2048       0.00       0.00       0.90
=> passed     4096       0.00       0.00       0.86
=> passed     8192       0.00       0.00       0.88
=> passed    16384       0.00       0.00       0.85
=> passed    32768       0.00       0.00       0.87
=> passed    65536       0.00       0.00       0.67
=> passed   131072       0.00       0.00       0.61
=> passed   262144       0.01       0.01       0.58
=> passed   524288       0.01       0.02       0.41
=> passed  1048576       0.02       0.05       0.40
=> passed  2097152       0.04       0.11       0.36
=> passed  4194304       0.08       0.26       0.32

Estimated running time as a function of n (using last 6 measurements)
    = 1.94e-08 * n^1.00  (R^2 = 1.00)


Total: 95/95 tests passed!