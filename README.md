# RomanConverter

I have two algorithms that I used to solve the problem:

### Algo-1
based on two cell scan
- if cell[i+1] <cell[i]

 -  Perform subtraction (cell[i+1] - cell[i])
 -  Increment counter value with absolute Evaluate

- Else, carry on normally by converting the value of
  the Roman numeral to it's decimal  equivalent

### Algo-2:

1- Convert the Roman numerals to decimals

2- Add decimals signs based on the relation between numbers, e.g., III => +1+1+1, IV => +1-4

3- Evaluate the equation based on the operation precedence, e.g., 1+1-4 => 1+(1-5)
