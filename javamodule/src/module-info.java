module test {
	requires com.google.gson;
	// option 1: "opens" to all type to be reflected, such as gson releaction based adapter
	opens demo1 to com.google.gson;
}