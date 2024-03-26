function validateForm() {
    // Read the form data
    var proId = document.getElementById("proId").value;
    var proName = document.getElementById("proName").value;
    var proPrice = document.getElementById("proPrice").value;
    var proBrand = document.getElementById("proBrand").value;
    var proMadeIn = document.getElementById("proMadeIn").value;
    var proMfg = document.getElementById("proMfg").value;
	var proExp = document.getElementById("proExp").value;
	

    // Trim the values and check if any field is empty
    if (proId.trim() ==="" || proName.trim() ==="" || proPrice.trim() ==="" || proBrand.trim() ==="" || proMadeIn.trim() ==="") {
        alert("All fields must be filled out");
        return false;
    }
    

    // Check if proPrice is a valid non-negative number
    if (parseFloat(proPrice) < 0 ) {
        alert("ProPrice must be a non-negative value");
        return false;
    }
    if(proName.length > 24 || proBrand.length > 24){
		alert("Product name and proBrand must be less than 24 characters");
		return false;
			}
	
	
	// convert into date format
	var manufacturingDateObj = new Date(proMfg);
	var expiryDateObj = new Date(proExp);
	
	//check the validation of dates
	if (manufacturingDateObj > expiryDateObj){
		alert("Manufacturing date cannot be greater than expiry date");
		return false;
		
	}


    // Form is valid
    return true;
}
