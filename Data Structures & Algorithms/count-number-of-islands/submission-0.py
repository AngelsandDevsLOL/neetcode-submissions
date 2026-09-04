class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:

        def inBounds(x, y, n, m) -> bool:
            return n > x >= 0 and m > y >= 0
        d = [[0] * len(grid[0]) for _ in range(len(grid))]
        q = deque()
        count = 0
        n = [[1, 0], [-1, 0], [0, 1], [0, -1]]
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if d[i][j] == 0 and grid[i][j] == "1":
                    count += 1
                    d[i][j] = count
                    q.append(i)
                    q.append(j)
                    while q:
                        x = q.popleft()
                        y = q.popleft()
                        for dx, dy in n:
                            nextX, nextY = x + dx, y + dy
                            if inBounds(nextX, nextY, len(grid), len(grid[0])) and d[nextX][nextY] == 0 and grid[nextX][nextY] == "1":
                                q.append(nextX)
                                q.append(nextY)
                                d[nextX][nextY] = count
                
        return count