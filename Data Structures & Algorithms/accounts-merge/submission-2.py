class Solution:
    def accountsMerge(self, accounts: List[List[str]]) -> List[List[str]]:
        index = {}
        ar = []
        name = {}
        adjacencyList = []
        for account in accounts:
            ind = len(ar)
            name[ind] = account[0]
            for i, email in enumerate(account[1:]):
                print(i)
                ar += [email]
                tmp = []
                if i >= 1:
                    tmp += [len(ar) - 2]
                    adjacencyList[len(ar) - 2] += [len(ar) - 1]
                if email in index:
                    tmp += [index[email]]
                    adjacencyList[index[email]] += [len(ar) - 1]
                index[email] = len(ar) - 1
                adjacencyList += [tmp]
        # for each email, add to ar and give it an index, make edges between emails in the same account in an adjacency list with edges
        # name map - {index, name} for some index of an email
        # check that it isn't already in index
            # if in index, connect the two edges using an adjacency list ..?
            # if not in index, add to index
        # loop through each email, run BFS on email if not visited previously -- add to queue
        ret = []
        visited = set() # set of indexes that we've already visited
        for i, email in enumerate(ar):
            if i not in visited:
                accName = name.get(i, "")
                visited.add(i)
                queue = deque([i])
                emails = set()
                emails.add(email)
                while queue:
                    cur = queue.popleft()
                    for next in adjacencyList[cur]: 
                        if next not in visited:
                            queue.append(next)
                            visited.add(next)
                            emails.add(ar[next])
                            accName = name.get(next, accName)
                ret.append([accName] + sorted(emails))
        return ret