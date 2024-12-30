# aoc2024day11

Here are my solutions for Day 11 of Advent of Code 2024.

During the active AoC 2024 period, I only managed to solve the first part. 

While solving Part 1 with a straightforward brute-force approach wasn't hard, but a 75-level deep recursion...
Even with 8GB heap size it allowed to dive a 43-level with input list length of 3.
I think a better solution would involve using a non-recursive DFS/BFS algorithm that counts created nodes without storing them in a list (as ordering turned out to be somewhat misleading). 
However, this puzzle also presents a great opportunity to experiment with kotlinx.benchmark and explore parallel processing solutions. 
I'm looking forward to testing different approaches, both for fun and practice.

It's not a better the next step, but I'd like to check different ways of finding the next nodes. Here some benchmark result for a 40-level recursion with my initial solution: 

No opt:
19257.030 ±(99.9%) 445.684 ms/op [Average]
(min, avg, max) = (18575.117, 19257.030, 19542.890), stdev = 294.792
CI (99.9%): [18811.345, 19702.714] (assumes normal distribution)

1st optimization:
14720.293 ±(99.9%) 245.833 ms/op [Average]
(min, avg, max) = (14306.824, 14720.293, 14872.628), stdev = 162.603
CI (99.9%): [14474.460, 14966.126] (assumes normal distribution)

2nd optimization:
13843.657 ±(99.9%) 212.672 ms/op [Average]
(min, avg, max) = (13712.049, 13843.657, 14188.000), stdev = 140.669
CI (99.9%): [13630.985, 14056.329] (assumes normal distribution)