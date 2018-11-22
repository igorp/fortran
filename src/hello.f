      PROGRAM HELLO
C
C hello.f by Igor Podsechin, November 2018
C This program reads in and prints out the user's name.
C
      CHARACTER NAME*20
      PRINT *, 'Type in your name, up to 20 characters'
      READ *, NAME
      PRINT *,'Hello ', NAME
      END
