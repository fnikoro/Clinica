function getRandomInt() {
	return (Math.floor(Math.random() * 255));
}

window.addEventListener('load', function(event){
	let elementi = document.querySelectorAll('.element')

	for(let i = 0; i < elementi.length; i++){
		elementi[i].addEventListener('click', function(event){
			elementi[i].style.backgroundColor = "rgb(" + getRandomInt() + ", " + getRandomInt() + ", " + getRandomInt() + ")"
			elementi[i].style.transition = "background-color 0.5s ease";
		})
	}

	let form = document.querySelector("#registrationForm")
	let fields = document.querySelectorAll(".required")
	
	form.addEventListener('submit', function(event){
		let formValidity = true
		let sessoScelto = document.querySelector("[name=sesso]:checked")

		fields.forEach(function(el, i, ar){
			if(el.value === ""){
				console.log("Trovato campo vuoto: " + el.name)
				let formRow = el.closest(".formRow");
				let messaggi = formRow.querySelector(".messaggi")
				messaggi.classList.remove("hidden")

				formValidity = false;
			}else if(el.name === "sesso" && sessoScelto === null){
				console.log("Trovato campo vuoto: " + el.name)
				let formRow = el.closest(".formRow");
				let messaggi = formRow.querySelector(".messaggi")
				messaggi.classList.remove("hidden")
			}
			else{
				let formRow = el.closest(".formRow");
				let messaggi = formRow.querySelector(".messaggi")
				messaggi.classList.add("hidden")
			}
		})

		let passCheck = document.querySelector("[name=password]")
		let confpassCheck = document.querySelector("[name=confpassword]")
		if(passCheck.value != confpassCheck.value){
			console.log("Le password non combaciano.")
			let formRow = confpassCheck.closest(".formRow")
			let messaggipass = formRow.querySelector(".messaggipass")
			formValidity = false;
		}

		if(formValidity === false){
            console.log("Errori trovati, impossibile proseguire con la registrazione")
            event.preventDefault()
        }else{console.log("Registrazione completata")}
	})
})
