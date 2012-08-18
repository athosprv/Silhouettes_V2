Silhouettes 2

Output:

As discussed in class, your output in reply to reading in a list of buildings is the single silhouette that would result from a scene containing all the buildings.  You output should consist of en even number of integers, one per line, followed by a blank line that will mark the end of your answer.

End of all Input:

The end of all input will be marked by an additional blank line after the blank line marking the end of the last problem.  Once this extra blank line is reached on the input, you may return control to the caller of your run function.

Example:

For example, the input might look like:

100 200 50
<blank line here>
24 4 4
2 6 5
19 18 3
3 13 6
12 7 4
14 3 11
1 11 4
23 13 6
<blank line here>
<blank line here>


Your output would then look like:

100
200
150
0
<blank line here>
1
11
3
13
9
0
12
7
16
3
19
18
22
3
23
13
29
0

You will need to use divide and conquer on this problem.  If you use the merge algorithm to iteratively add buildings into "the silhouette so far", your solution will timeout on the larger problems.
A valid silhouette has an even number of integers, has at least 4 integers, and ends in 0.  My Merge.merge() function will throw a RuntimeException if either argument violates these necessary conditions for a valid silhouette.
 

 