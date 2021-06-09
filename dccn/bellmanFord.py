import sys

def printPath(parent, vertex, n = None):
    if vertex < 0:
        return
 
    printPath(parent, parent[vertex])
    print(vertex, end=' ')
    if vertex>=0:
        print('->', end = ' ')

 
 
# Function to run the Bellman–Ford algorithm from a given source
def bellmanFord(edges, N,source, dest):
    distance = [sys.maxsize] * N
    parent = [-1] * N
    distance[source] = 0
    for k in range(N - 1):
        for (u, v, w) in edges:
            if distance[u] + w < distance[v]:
                distance[v] = distance[u] + w
                parent[v] = u
    for (u, v, w) in edges:
        if distance[u] + w < distance[v]:
            print("Negative-weight cycle is found!!")
            return
    print("\nThe distance of vertex", dest,\
         "from the source is", distance[dest], end='.\n')
    print("Its path is ", end='')
    printPath(parent, dest)
    print('\n')
 
 
if __name__ == '__main__':
    N = int(input("Enter number of Node : "))
    E = int(input("Enter number of Edges : "))
    edges = []
    for i in range(E):
        x,y,w = map(int,input(f"Enter Source,Dest. "+
             f"and weight for edge {i+1} : ").split())
        edges.append((x,y,w))
    S = int(input("Enter Source : "))
    D = int(input("Enter Destination : "))
    bellmanFord(edges, N, S, D)