class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        n = len(board)
        rowset = [set() for _ in range(n)]
        colset = [set() for _ in range(n)]
        blocks = [set() for _ in range(n)]
        for i in range(n): 
            for j in range(n): 
                num = board[i][j] 
                if num == '.': continue 
                if num in rowset[i] or num in colset[j]: return False 
                b = i//3*3+j//3 
                if num in blocks[b]: return False 
                rowset[i].add(num)
                colset[j].add(num)
                blocks[b].add(num)
        return True 
