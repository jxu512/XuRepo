// JavaScript implementation, run with node

const fs = require('fs');
let nodes = [];
let cols = -1, rows = -1;

function findConnectedSinks (file) {
    nodes = loadNodesFromFile(file);
    let matrix = createMatrix();
    return bfsSearch(matrix);
}

function bfsSearch(matrix) {
    let queue = [];
    let answer = '';
    let source = getSource(matrix);
    queue.push(source);
    while (queue.length != 0) {
        let node = queue.shift();
        let r = node.row;
        let c = node.col;
        if (matrix[r][c] >= 'A' && matrix[r][c] <= 'Z') {
            answer += matrix[r][c];
        }
        let neighbors = getNeighbors(matrix, r, c);
        neighbors.forEach(node => { queue.push(node)});
        matrix[r][c] = ' ';           // Mark as processed
    }
    console.log("Reachable sinks: " + answer);
    return answer;
}
function getNeighbors(matrix, r, c) {
    let node = new Object();
    let neighbors = [];
    if (matrix[r][c] == ' ') return neighbors;

    if (isLeftConnected(matrix, r, c)) neighbors.push({row: r, col: c-1})
    if (isRightConnected(matrix, r, c)) neighbors.push({row: r, col: c+1})
    if (isUpConnected(matrix, r, c)) neighbors.push({row: r+1, col: c})
    if (isDownConnected(matrix, r, c)) neighbors.push({row: r-1, col: c})

    return neighbors;
}

function isLeftConnected(matrix, r, c) {
    if (c < 1) return false;
    let ch = matrix[r][c];
    let left = matrix[r][c-1];
    if ((['*', '═', '╗', '╝', '╣', '╦', '╩'].includes(ch) || (ch >= 'A' && ch <= 'Z'))
        && (['═', '╔', '╚', '╠', '╦', '╩'].includes(left) || (left >= 'A' && left <= 'Z'))) return true;
}
function isRightConnected(matrix, r, c) {
    if (c >= cols-1) return false;
    let ch = matrix[r][c];
    let right = matrix[r][c+1];
    if ( (['*', '═', '╔', '╚', '╠', '╦', '╩'].includes(ch) || (ch >= 'A' && ch <= 'Z'))
        && (['═', '╗', '╝', '╣', '╦', '╩'].includes(right) || (right >= 'A' && right <= 'Z'))) return true;
}
function isUpConnected(matrix, r, c) {
    if (r >= rows-1) return false;
    let ch = matrix[r][c];
    let up = matrix[r+1][c];
    if ( (['*', '║', '╚', '╝', '╠', '╣', '╩'].includes(ch) || (ch >= 'A' && ch <= 'Z'))
        && (['║', '╔', '╗', '╠', '╣', '╦'].includes(up) || (up >= 'A' && up <= 'Z'))) return true;
}
function isDownConnected(matrix, r, c) {
    if (r < 1 ) return false;
    let ch = matrix[r][c];
    let down = matrix[r-1][c];
    if ( (['*', '║', '╔', '╗', '╠', '╣', '╦'].includes(ch) || (ch >= 'A' && ch <= 'Z'))
        && ([ '║', '╚', '╝', '╠', '╣', '╩'].includes(down) || (down >= 'A' && down <= 'Z'))) return true;
}
function getSource(matrix) {
    let source = new Object();
    for (let r=0;r<rows;r++) {
        for (let c=0;c<cols;c++) {
            if (matrix[r][c] == '*') {
                source.row = r;
                source.col = c;
            }
        }
    }
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

function createMatrix() {
    nodes.forEach(node => {
        if (cols < node.col) cols = node.col;
        if (rows < node.row) rows = node.row;
    });
    cols++;
    rows++;
    let matrix = Array(rows).fill().map(() => Array(cols).fill(' '));

    nodes.forEach(node => {
        matrix[node.row][node.col] = node.pipe;
    });

    return matrix;
}

findConnectedSinks ('g:/tmp/coding_qual_input.txt');
