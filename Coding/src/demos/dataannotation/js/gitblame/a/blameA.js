const { spawnSync } = require('child_process');

function getGitBlame(filePath) {
    // Execute git blame command
    const result = spawnSync('git', ['blame', '--line-porcelain', filePath], {
        encoding: 'utf8',
    });

    if (result.error) {
        console.error('Error executing git blame:', result.error);
        return null;
    }

    // Parse git blame output
    const blameInfo = {};
    const lines = result.stdout.split('\n');
    let currentLineNumber = 1;

    for (const line of lines) {
        if (line.startsWith('author-mail')) {
            const authorEmail = line.split(' ')[1].trim();
            blameInfo[currentLineNumber] = authorEmail;
            currentLineNumber++;
        }
    }

    return blameInfo;
}

// Example usage
const filePath = '../Test.java'; // Replace with your file path
const blameData = getGitBlame(filePath);

if (blameData) {
    console.log(JSON.stringify(blameData, null, 2));
}