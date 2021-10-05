window.addEventListener('load', function(event) {
    let form = document.querySelector('#signUpForm')
    let fields = document.querySelectorAll(".required")

    form.addEventListener('submit', function(event) {
        let formValidity = true;

        fields.forEach(function(el, i, ar) {
            if(el.value === "") {
                console.log("Trovato campo vuoto: " + el.name)
                let formRow = el.closest(".form-row")
                let messaggi = formRow.querySelector(".msg")
                messaggi.classList.remove("d-none")

                formValidity = false;
            } else {
                let formRow = el.closest(".form-row")
                let messaggi = formRow.querySelector(".msg")
                messaggi.classList.add("d-none")
            }
        })

        if(formValidity === false) {
            console.log("Errori trovati, impossibile proseguire con la registrazione")
            event.preventDefault()
        } else {
            console.log("Registrazione completata")
        }
    })
})