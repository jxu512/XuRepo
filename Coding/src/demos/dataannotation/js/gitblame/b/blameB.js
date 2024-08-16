const { execSync } = require('child_process');

function getGitBlame(filePath) {
    const blameOutput = execSync(`git blame -e ${filePath}`).toString();
    const blameLines = blameOutput.split('\n');
    const blameData = {};

    blameLines.forEach((line) => {
        if (line) {
            const [commitHash, authorEmail, lineNumber] = line.split(' ')[0, 2, 2];
            blameData[lineNumber] = authorEmail;
        }
    });

    return blameData;
}

const filePath = '../Test.java'; // Replace with your file path
const blameData = getGitBlame(filePath);
console.log(JSON.stringify(blameData, null, 2));