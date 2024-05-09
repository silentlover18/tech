class NQueens:

    def __init__(self, n):
        self.n = n
        self.board = [['.' for _ in range(n)] for _ in range(n)]
        self.solutions = []

    def is_safe(self, row, col):
        # Check if a queen can be placed at the given position without conflicting with previous queens

        # Check for queens in the same column
        for i in range(row):
            if self.board[i][col] == 'Q':
                return False

        # Check for queens in the upper diagonal
        i, j = row, col
        while i >= 0 and j >= 0:
            if self.board[i][j] == 'Q':
                return False
            i -= 1
            j -= 1

        # Check for queens in the lower diagonal
        i, j = row, col
        while i >= 0 and j < self.n:
            if self.board[i][j] == 'Q':
                return False
            i -= 1
            j += 1

        return True

    def solve_nqueens(self, row=0):
        if row == self.n:
            self.solutions.append([''.join(row) for row in self.board])
            return

        for col in range(self.n):
            if self.is_safe(row, col):
                self.board[row][col] = 'Q'
                self.solve_nqueens(row + 1)
                self.board[row][col] = '.'

    def get_solutions(self):
        return self.solutions


# Test the implementation
n = 8  # Number of queens and board size
queens = NQueens(n)
queens.solve_nqueens()
solutions = queens.get_solutions()
print(f"Number of solutions for {n}-Queens: {len(solutions)}")
for idx, solution in enumerate(solutions):
    print(f"Solution {idx + 1}:")
    for row in solution:
        print(row)
    print()
