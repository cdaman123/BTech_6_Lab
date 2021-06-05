import sys
 
class Graph(): 
    def __init__(self, vertices):
        self.V = vertices
        self.graph = [[0 for column in range(vertices)]
                      for row in range(vertices)]
 
    def printSolution(self, dist, destination):
        print("Distance from source  to destination is : ",end = " ")
        print(dist[destination])
 

    def minDistance(self, dist, sptSet):
 
        min = sys.maxsize
        for v in range(self.V):
            if dist[v] < min and sptSet[v] == False:
                min = dist[v]
                min_index = v
 
        return min_index
 
    
    def dijkstra(self, src, dest): 
        dist = [sys.maxsize] * self.V
        dist[src] = 0
        sptSet = [False] * self.V 
        for cout in range(self.V):
            u = self.minDistance(dist, sptSet)
            sptSet[u] = True
            for v in range(self.V):
                if self.graph[u][v] > 0 and \
                sptSet[v] == False and \
                dist[v] > dist[u] + self.graph[u][v] : 
                    dist[v] = dist[u] + self.graph[u][v] 
        self.printSolution(dist,dest)

def get_input(path):
    f = open(path,'r')
    txt = f.read()
    txt = txt.split("\n")
    n = int(txt[0])
    arr = []
    for i in range(n):
        temp = txt[i+1].split(",")
        temp = list(map(int,temp))
        arr.append(temp)
    s = int(txt[n+1])
    d = int(txt[n+2])

    return n,arr,s,d 
 

n_vertices,graph,source,destination = get_input(sys.argv[1])
print(f"No of vertices in Graph : {n_vertices}\n")
print("Graph Matrix : ")
print(*graph,sep="\n")
print(f"\nSource = {source}\nDestination = {destination}\n")

g = Graph(n_vertices)
g.graph = graph 
g.dijkstra(source,destination)