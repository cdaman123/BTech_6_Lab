from itertools import chain, combinations
def powerset(iterable):
    "powerset([1,2,3]) --> () (1,) (2,) (3,) (1,2) (1,3) (2,3) (1,2,3)"
    s = list(iterable)
    return chain.from_iterable(combinations(s, r) for r in range(len(s) + 1))


coins = [10, 50, 100]
quantity = [1, 2, 1]
c_new = []
def possibleSums(coins, quantity):
    possible_sums = {0}
    for c, q in zip(coins, quantity):
        print(f"p_sum = {possible_sums}")
        possible_sums = {x + c * i for x in possible_sums for i in range(q + 1)}
        print(f"p_sum = {possible_sums}\n")
    
    return len(possible_sums) - 1
possibleSums(coins, quantity);