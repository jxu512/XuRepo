import random

def create_grid():
    """Creates an empty Sudoku grid represented as a list of lists of lists."""
    return [[[1, 2, 3, 4, 5, 6, 7, 8, 9] for _ in range(9)] for _ in range(9)]

def print_grid(grid):
    """Prints the Sudoku grid in a readable format."""
    for i in range(9):
        for j in range(9):
            if not isinstance(grid[i][j], list):
                print(grid[i][j], end=" ")
            else:
                print("*", end=" ")
        print()

def find_singles(grid):
    """Finds grid locations with only one possible value."""
    singles = []
    for i in range(9):
        for j in range(9):
            if isinstance(grid[i][j], list) and len(grid[i][j]) == 1:
                singles.append((i, j))
                grid[i][j] = grid[i][j][0]      # Jeff
    return singles

def eliminate_value(grid, row, col, value):
    """Eliminates a value from the possible values of a location's row, column, and square."""
    # Eliminate from row
    for j in range(9):
        if isinstance(grid[row][j], list):
            if j != col and value in grid[row][j]:
                grid[row][j].remove(value)

    # Eliminate from column
    for i in range(9):
        if isinstance(grid[i][col], list):
            if i != row and value in grid[i][col]:
                grid[i][col].remove(value)

    # Eliminate from square
    square_row = row // 3
    square_col = col // 3
    for i in range(square_row * 3, (square_row + 1) * 3):
        for j in range(square_col * 3, (square_col + 1) * 3):
            if isinstance(grid[i][j], list):
                if (i, j) != (row, col) and value in grid[i][j]:
                    grid[i][j].remove(value)

def solve(grid):
    """Solves the Sudoku grid using Wavefront propagation."""
    while True:
        singles = find_singles(grid)
        if not singles:
            # No singles found, choose location with fewest possibilities
            min_len = 10
            min_pos = None
            for i in range(9):
                for j in range(9):
                    if isinstance(grid[i][j], list) and len(grid[i][j]) > 1 and len(grid[i][j]) < min_len:
                        min_len = len(grid[i][j])
                        min_pos = (i, j)

            if not min_pos:
                # No more possibilities, either solved or unsolvable
                break

            # Choose a random value from the possibilities
            value = random.choice(grid[min_pos[0]][min_pos[1]])
            grid[min_pos[0]][min_pos[1]] = [value]
        else:
            # Eliminate singles
            for row, col in singles:
                value = grid[row][col]  # Jeff[0]
                eliminate_value(grid, row, col, value)

    # Check if solved
    for i in range(9):
        for j in range(9):
            if isinstance(grid[i][j], list):
                return False

    return True

# Example usage:
grid = create_grid()
# Set up a starting Sudoku puzzle
grid[0][0] = [1]
grid[0][8] = [5]
grid[1][1] = [3]
# ... (set up the rest of the puzzle)

if solve(grid):
    print_grid(grid)
else:
    print("No solution found.")