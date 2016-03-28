First, compile java files:
  $ javac src/*.java

Then, run the program with 3 arguments: dataset filename, k, output filename
  $ java -cp "src" Main datasets/wholesale_customers.data 10 output
  $ java -cp "src" Main datasets/student_assessment.data 10 output
