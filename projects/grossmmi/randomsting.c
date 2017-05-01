/*
In order to develop the solution, I needed to identify just what was being askd for.
To retrieve a single char, I looked up the ASCII table to find the numerical values
for the 127 characters of the base set. I then set a random number generator with
modulus to return one of these characters.

Once I saw that was functioning, I would implement the same logic for the string problem.
First I generated a random number for length between 1 and 10 since the test appeared
to only be checking for strings of length up to 9. With that in place, I dynamically
allocated memory to a string of the random length. I then filled each element with a
random char.

After playing around with a couple different syntaxes, I saw results in terminal that
returned the expected values and showed that both 'c' and 's' were getting legitmate values.
*/
