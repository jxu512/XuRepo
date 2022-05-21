const columnDefs = [
  { field: "make" },
  { field: "model" },
  { field: "price" }
];

// specify the data
const rowData = [
  { make: "Toyota", model: "Corolla", price: 35000 },
  { make: "Ford", model: "Taurus", price: 32000 },
  { make: "Honda", model: "Accord", price: 34000 },
  { make: "Porsche", model: "Boxster", price: 72000 },
  { make: "GM", model: "gm", price: 34000 }
];

// let the grid know which columns and what data to use
const gridOptions = {
  columnDefs: columnDefs,
  rowData: rowData
};

// setup the grid after the page has finished loading
document.addEventListener('DOMContentLoaded', () => {
    const gridDiv = document.querySelector('#myGrid');
    new agGrid.Grid(gridDiv, gridOptions);
});

function addGrid() {
	const gridDiv = document.querySelector('#myGrid1');
    new agGrid.Grid(gridDiv, gridOptions);

}