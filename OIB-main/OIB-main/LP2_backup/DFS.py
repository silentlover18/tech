def dfs(graph, root):
    visited=[]
    if root not in visited:
        print (root)
        visited.append(root)
        for neighbour in graph[root]:
            dfs( graph, neighbour)
graph = {
        5 : [3,7],
        3 : [2, 4],
        7: [8],
        2 : [],
        4 : [8],
        8 : []
        }
print("Following is the Depth-First Search")
dfs(graph, 5)


