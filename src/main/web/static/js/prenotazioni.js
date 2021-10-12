let form = document.querySelector('#preForm')
let fields = document.querySelectorAll(".required")
let selectReparto = document.getElementById("id_reparto")
let selectMedico = document.getElementById("id_medico")
let primoId = document.getElementById("primo")
let secondoId = document.getElementById("secondo")
let scala = document.querySelector('#data_prenotazione')
let letueprediv = document.getElementById("letueprenot")
let dataFetchOrari;

window.addEventListener('load', function (event) {
    selectReparto.addEventListener("change", mediciSelect);
    selectMedico.addEventListener("change", orariSelect);
    letueprediv.addEventListener("load", letuepredivLoad);
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

    let id_reparto = document.querySelector("#id_reparto");
    let id_medico = document.querySelector("#id_medico");
    let id_utente_confermato = document.querySelector("#id_utente_confermato");
    // let id_utente = 1;
    // let id_medico = 1;
    console.log(id_utente_confermato)
    console.log(id_medico)
    let data_prenotazione = document.querySelector("#data_prenotazione");
    var data = JSON.stringify({
        // id_reparto: id_reparto.value,
        id_medico: id_medico.value,
        id_utente: id_utente_confermato.value,
        data_prenotazione: data_prenotazione.value
    });

    fetch('http://localhost:8080/api/save-visite', {
        method: 'POST',
        body: data,
        headers: {
            "Content-Type": "application/json",
        },
    })
        .then(resp => {
            console.log(data)
            if (resp.status !== 200) {
                console.log("Status: " + resp.status)
                return Promise.reject("server")
            } else {
                console.log("Input registrato, attenzione ai null")
            }
        })
        .catch(err => {
            if (err === "server")
                console.log("")
        })
    event.preventDefault()
})

function mediciSelect() {
    let repartoId = document.getElementById("id_reparto").value;
    let urlGetMediciByIdReparto = 'http://localhost:8080/api/get-medici-by-reparto/' + repartoId;

    fetch(urlGetMediciByIdReparto).then(function (response) {
        return response.json()
    }).then(function (data) {
        let dat = Object.values(data)
        console.log(dat)
        primoId.innerHTML = `${dat[0].nome} ${dat[0].cognome}`
        secondoId.innerHTML = `${dat[1].nome} ${dat[1].cognome}`
        primoId.value = `${dat[0].id_medico}`;
        secondoId.value = `${dat[1].id_medico}`;
    })
}

function orariSelect() {
    let medicoId = document.getElementById("id_medico").value;
    let urlGetListaOrariMedico = 'http://localhost:8080/api/get-lista-orari-medico/' + medicoId;

    fetch(urlGetListaOrariMedico).then(function (response) {
        return response.json()
    }).then(function (data) {
        dataFetchOrari = data;
        let dat = Object.values(data)
        console.log(dat)

        for(let i = 0; i < dat.length; i++) {
            let optionX = document.createElement("option")
            optionX.innerHTML = `${dat[i]}`
            scala.appendChild(optionX)
        }
    })
}

function letuepredivLoad() {
    let urlGetPrenotazioni = 'http://localhost:8080/api/get-visite-by-user/1';
    fetch(urlGetPrenotazioni).then(function (response) {
        return response.json()
    }).then(function (data) {
        let dat = Object.values(data)
        console.log(dat)

        for(let i = 0; i < dat.length; i++) {
            let div = document.createElement("div")
            div.innerHTML = '<div class="d-flex flex-column"><h3>Prenotazione ' + `${dat[i]}` + ":</h3><span>Orario: ' + `${dat[i].data_prenotazione` + '</span></div>"
            scala.appendChild(div)
        }
    })
}