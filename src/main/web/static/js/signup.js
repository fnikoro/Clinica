window.addEventListener('load', function (event) {
    let form = document.querySelector('#signUpForm')
    let fields = document.querySelectorAll(".required")

    form.addEventListener('submit', function (event) {
        let formValidity = true;

        fields.forEach(function (el, i, ar) {
            if (el.value === "") {
                console.log("Trovato campo uotvo: " + el.name)
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

        if (formValidity === false) {

            console.log("Erorri trovati, qualquadra che non rotonda")
            event.preventDefault()
        }

        let nome = document.querySelector("#nome");
        let cognome = document.querySelector("#cognome");
        let indirizzo = document.querySelector("#indirizzo");
        let localita = document.querySelector("#localita");
        let cap = document.querySelector("#cap");
        let numero_cellulare = document.querySelector("#numero_cellulare");
        let email = document.querySelector("#email");
        let password = document.querySelector("#password");
        var data = JSON.stringify({
            nome: nome.value,
            cognome: cognome.value,
            indirizzo: indirizzo.value,
            localita: localita.value,
            cap: cap.value,
            numero_cellulare: numero_cellulare.value,
            email: email.value,
            password: password.value
        });


        fetch('http://localhost:8080/api/save-pazienti', {
            method: 'POST',
            body: data,
            headers: {
                "Content-Type": "application/json",
            },
        })
            .then(resp => {
                if (resp.status !== 200) {
                    console.log("Status: " + resp.status)
                    return Promise.reject("server")
                } else {
                    console.log("Registrazione cacata")
                }
            })
            .catch(err => {
                if (err === "server")
                    console.log("Email gia' esistente, errore, suca")
            })
        event.preventDefault()

    })
})