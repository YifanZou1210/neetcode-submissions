class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        r, c = len(board), len(board[0])
        rowset = [set() for _ in range(r)]
        colset = [set() for _ in range(c)]
        blockset = [set() for _ in range(9)]
        for i in range(r):
            for j in range(c): 
                v = board[i][j]
                if v == '.': continue # ? 
                if v in rowset[i]: 
                    return False 
                if v in colset[j]: 
                    return False 
                # 5, 4, (5%3-1)*3+(4%3) = 3+1 = 4 
                # 1, 1 (1//3)*3+(y//3)
                idx = (i//3)*3+(j//3) 
                if v in blockset[idx]: 
                    return False 
                # if every set has no duplicates, added 
                rowset[i].add(v)
                colset[j].add(v)
                blockset[idx].add(v)
        return True 
    # n^2, n^2

        