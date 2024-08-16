const text = `
  <div>Some HTML</div>
  <script type="application/json">
  {
    "name": "John Doe",
    "age": 30
  }
  </script>
  <p>More HTML</p>
`;

const regex = /<script type="application\/json">([\s\S]*?)</;
const match = text.match(regex);

if (match) {
    const jsonContent = match[1];
    console.log(jsonContent);
} else {
    console.log("No matching script tag found.");
}

