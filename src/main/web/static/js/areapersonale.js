let form = document.querySelector('#preForm')
let fields = document.querySelectorAll(".required")
let selectPrenotazioni = document.getElementById("prenotazione")
let primoId = document.getElementById("primo")
let scala = document.querySelector('#prenotazione')
let schiacciaStoBottone = document.querySelector('#schiacciaschiaccia')
let id_utente_confermato = document.querySelector("#id_utente_confermato").value;


window.addEventListener('load', function (event) {
    schiacciaStoBottone.addEventListener("click", prenotazioniSelect);
    // event.preventDefault();
})

form.addEventListener('submit', function (event) {
    let formValidity = true;
    // event.preventDefault();

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

    let infoPrenotazione = document.querySelector("#informazionePrenotazione");
    // var data = JSON.stringify({
    //     // id_reparto: id_reparto.value,
    //     data_prenotazione: data_prenotazione.value
    // });
})

function prenotazioniSelect() {

    let urlGetVisiteById = 'http://localhost:8080/api/get-visite-by-user/' + id_utente_confermato;

    fetch(urlGetVisiteById).then(function (response) {
        return response.json()
    }).then(function (data) {
        let dat = Object.values(data)
        for(let i = 0; i < dat.length; i++) {
            let optionX = document.createElement("option")
            optionX.innerHTML = `${dat[i].id_visita}, ${dat[i].id_medico}, ${dat[i].id_paziente}, ${dat[i].data_prenotazione}`
            scala.appendChild(optionX)
        }
    })
}
