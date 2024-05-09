#DFS
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






#BFS
def bfs(visited, graph, node):
    visited.append(node)
    queue.append(node)
    while queue:
        m = queue.pop(0)
        print (m, end = " ")
        for neighbour in graph[m]:
            if neighbour not in visited:
                visited.append(neighbour)
                queue.append(neighbour)
graph = {
    '5' : ['3','7'],
    '3' : ['2', '4'],
    '7' : ['8'],
    '2' : [],
    '4' : ['8'],
    '8' : []
    }
visited = []
queue = []
print("Following is the Breadth-First Search")
bfs(visited, graph, '5')
