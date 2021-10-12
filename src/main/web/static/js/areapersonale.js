let form = document.querySelector('#preForm')
let fields = document.querySelectorAll(".required")
let scala = document.querySelector('#prenotazione')
let id_utente_confermato = document.querySelector("#id_utente_confermato").value;
let name = document.querySelector('#fullname')
let email = document.querySelector('#email')
let phone = document.querySelector('#telefono')
let id_visita_selezionata;

window.addEventListener('load', function (event) {
    userInfo();
    prenotazioniSelect();
})

form.addEventListener('submit', function (event) {
    let formValidity = true;
    event.preventDefault()

    fields.forEach(function (el, i, ar) {
        if (el.value === 0) {
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

    if (formValidity === false) {
        console.log("Erorri trovati, qualquadra che non rotonda")
        event.preventDefault()
    }

    let urlDeleteVisitaById = 'http://localhost:8080/api/delete-visite/' + id_visita_selezionata;

    fetch(urlDeleteVisitaById, {
      method: 'DELETE',
        mode: 'cors',
        headers: {
            "Content-Type": "application/json ,Access-Control-Allow-Origin",

        },
    })
        .then(function (response) {
            return response.json()
        }).then(function (data3) {

        })
})

function userInfo() {
    let urlGetPazienteById = 'http://localhost:8080/api/get-paziente-by-id/' + id_utente_confermato;

    fetch(urlGetPazienteById).then(function (response) {
        return response.json()
    }).then(function (data3) {
        name.innerHTML = `${data3.nome}, ${data3.cognome}`
        email.innerHTML = `${data3.email}`
        phone.innerHTML = `${data3.numero_cellulare}`
    })
}

function prenotazioniSelect() {

    let urlGetVisiteById = 'http://localhost:8080/api/get-visite-by-user/' + id_utente_confermato;

    fetch(urlGetVisiteById).then(function (response) {
        return response.json()
    }).then(function (data2) {
        let data = Object.values(data2)

        for(let i = 0; i < data.length; i++) {
            let optionX = document.createElement("option")
            optionX.innerHTML = 'Id visita: ' + `${data[i].id_visite}` + ' / Id medico: ' +  `${data[i].medici_id}` + ' / Data prenotazione: ' + `${data[i].data_prenotazione}`

            // optionX.id = "id-opzione"+i

            id_visita_selezionata = `${data[i].id_visite}`

            scala.appendChild(optionX)
        }
    })
}
