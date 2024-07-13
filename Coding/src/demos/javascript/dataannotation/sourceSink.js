/* pipes: '═', '║', '╔', '╗', '╚', '╝', '╠', '╣', '╦', '╩' */
const fs = require('fs');
let nodes = [];
let cols = -1, rows = -1;
let answer = '';

function findConnectedSinks (file) {
    nodes = loadNodesFromFile(file);
    let grid = createGrid();
    bfs(grid);
    console.log(answer);
    return answer;
}

function bfs(grid) {
    let queue = [];
    let source = getSource(grid);
    queue.push(source);
    while (queue.length != 0) {
        let node = queue.shift();
        let r = node.row;
        let c = node.col;
        if (grid[r][c] >= 'A' && grid[r][c] <= 'Z') {
            answer += grid[r][c];
            //console.log('Answer: ' + answer);
        }
        let connected = getConnected(grid, r, c);
        connected.forEach(node => { queue.push(node)});
        //console.log('queue size: ' + queue.length);
        grid[r][c] = ' ';           // Mark as processed
    }
}
function getConnected(grid, r, c) {
    let node = new Object();
    let connected = [];
    if (grid[r][c] == ' ') return connected;

    if (isLeftConnected(grid, r, c)) connected.push({row: r, col: c-1})
    if (isRightConnected(grid, r, c)) connected.push({row: r, col: c+1})
    if (isUpConnected(grid, r, c)) connected.push({row: r+1, col: c})
    if (isDownConnected(grid, r, c)) connected.push({row: r-1, col: c})

    return connected;
}

function isLeftConnected(grid, r, c) {
    if (c < 1) return false;
    let ch = grid[r][c];
    let left = grid[r][c-1];
    if ((['*', '═', '╗', '╝', '╣', '╦', '╩'].includes(ch) || (ch >= 'A' && ch <= 'Z'))
        && (['═', '╔', '╚', '╠', '╦', '╩'].includes(left) || (left >= 'A' && left <= 'Z'))) return true;
}
function isRightConnected(grid, r, c) {
    if (c >= cols-1) return false;
    let ch = grid[r][c];
    let right = grid[r][c+1];
    if ( (['*', '═', '╔', '╚', '╠', '╦', '╩'].includes(ch) || (ch >= 'A' && ch <= 'Z'))
        && (['═', '╗', '╝', '╣', '╦', '╩'].includes(right) || (right >= 'A' && right <= 'Z'))) return true;
}
function isUpConnected(grid, r, c) {
    if (r >= rows-1) return false;
    let ch = grid[r][c];
    let up = grid[r+1][c];
    if ( (['*', '║', '╚', '╝', '╠', '╣', '╩'].includes(ch) || (ch >= 'A' && ch <= 'Z'))
        && (['║', '╔', '╗', '╠', '╣', '╦'].includes(up) || (up >= 'A' && up <= 'Z'))) return true;
}
function isDownConnected(grid, r, c) {
    if (r < 1 ) return false;
    let ch = grid[r][c];
    let down = grid[r-1][c];
    if ( (['*', '║', '╔', '╗', '╠', '╣', '╦'].includes(ch) || (ch >= 'A' && ch <= 'Z'))
        && ([ '║', '╚', '╝', '╠', '╣', '╩'].includes(down) || (down >= 'A' && down <= 'Z'))) return true;
}
function getSource(grid) {
    let source = new Object();
    for (let r=0;r<rows;r++) {
        for (let c=0;c<cols;c++) {
            if (grid[r][c] == '*') {
                source.row = r;
                source.col = c;
            }
        }
    }
    //console.log('Source: (' + source.row + ', ' + source.col + ')');
    return source;
}
function loadNodesFromFile (file) {
    let nodes = [];
    let lines = fs.readFileSync(file, 'utf-8').split('\n');
    lines.forEach(line => {
        let parts = line.split(" ");
        let x = parseInt(parts[1]);
        let y = parseInt(parts[2]);
        let node = new Object();
        node.col = x;
        node.row = y;
        node.pipe = parts[0];
        nodes.push(node);
    });
    return nodes;
}

function createGrid() {
    nodes.forEach(node => {
        if (cols < node.col) cols = node.col;
        if (rows < node.row) rows = node.row;
    });
    cols++;
    rows++;
    let grid = Array(rows)
        .fill()
        .map(() => Array(cols).fill(' '));

    nodes.forEach(node => {
        grid[node.row][node.col] = node.pipe;
    });

    return grid;
}

findConnectedSinks ('g:/tmp/coding_qual_input.txt');
