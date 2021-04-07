var = {'E':0,'X':1,'T':2,'Y':3,'F':4}
ter = {'i':0,'+':1,'*':2,'(':3,')':4,'$':5}
exp = {0:['E','TX'],1:['X','+TX'],2:['X','Z'],3:['T','FY'],4:['Y','+FY'],5:['Y','Z'],6:['F','i'],7:['F','(E)']}
table = [[0,-1,-1,0,-1,-1],
        [-1,1,-1,-1,2,2],
        [3,-1,-1,3,-1,-1],
        [-1,5,4,-1,5,5],
        [6,-1,-1,7,-1,-1]]


def is_accept(S,stack):
    output_l = []
    for a in S:
        if stack[-1] == a and a == '$':
            return True
        elif stack[-1] == a:
            stack.pop()
        else:
            output = table[var[stack.pop()]][ter[a]]
            output_l.append(output)
            if output == -1:
                return False
            else:
                if exp[output][1][0] != 'Z':
                    stack+= list(exp[output][1])[::-1]
        print(output)


stack = []
stack.append('$')
stack.append(exp[0][0])
print(is_accept("i+i*i$",stack))




