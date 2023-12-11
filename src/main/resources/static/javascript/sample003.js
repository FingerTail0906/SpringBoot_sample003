function insertBtnClick(){
	const saveWrap = document.getElementById("save-wrap");
	const saveInputWrap = document.getElementById("save-input-wrap");
	const dbDisplayBtnWrap = document.getElementById("db-display-btn-wrap");
	const updateWrap = document.getElementById("update-wrap");
	
	saveWrap.classList.remove("d-block");
	saveWrap.classList.add("d-none");
	saveInputWrap.classList.remove("d-none");
	saveInputWrap.classList.add("d-block");
	dbDisplayBtnWrap.classList.remove("d-none");
	dbDisplayBtnWrap.classList.add("d-block");
	updateWrap.classList.remove("d-block");
	updateWrap.classList.add("d-none");
	
}

function editBtnClick(){
	const saveWrap = document.getElementById("save-wrap");
	const saveInputWrap = document.getElementById("save-input-wrap");
	const dbDisplayBtnWrap = document.getElementById("db-display-btn-wrap");
	const updateWrap = document.getElementById("update-wrap");
	
	saveWrap.classList.add("d-block");
	saveWrap.classList.remove("d-none");
	saveInputWrap.classList.add("d-none");
	saveInputWrap.classList.remove("d-block");
	dbDisplayBtnWrap.classList.add("d-none");
	dbDisplayBtnWrap.classList.remove("d-block");
	updateWrap.classList.add("d-block");
	updateWrap.classList.remove("d-none");
	
}