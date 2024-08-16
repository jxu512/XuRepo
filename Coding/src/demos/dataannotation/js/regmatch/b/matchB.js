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

const regex = /<script type="application\/json">([^<]*)<\/script>/;
const match = text.match(regex);

if (match) {
    const jsonContent = match[1].trim();
    console.log(jsonContent);
} else {
    console.log("No matching script tag found.");
}