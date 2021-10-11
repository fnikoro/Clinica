window.addEventListener('load', function (event) {
    let form = document.querySelector('#preForm')
    let fields = document.querySelectorAll(".required")
    let selectReparto = document.getElementById("id_reparto")
    let selectMedico = document.getElementById("id_medico")
    let primoId = document.getElementById("primo")
    let secondoId = document.getElementById("secondo")

    selectReparto.addEventListener("change", function(event) {
        let urlGetMediciByIdReparto = 'http://localhost:8080/api/get-medici-by-reparto/1';
        // let urlGetOrariByMediciDisponibili = 'http://localhost:8080/api/';

        fetch(urlGetMediciByIdReparto).then(function (response) {
            return response.json()
        }).then(function (data) {
            let dat = Object.values(data)
            console.log(dat)

            /*var result = [];

            for(var i in data)
                result.push([i, data [i]]);


            var dat = new google.visualization.DataTable();
            dat.addColumn('string', 'Topping');
            dat.addColumn('number', 'Slices');
            dat.addRows(result);*/
            primoId.innerHTML = `${dat[0].nome} ${dat[0].cognome}`
            secondoId.innerHTML = `${dat[1].nome} ${dat[1].cognome}`
        })
    })

    /*form.addEventListener('submit', function (event) {
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

        let id_reparto = document.querySelector("#id_reparto");
        let id_medico = document.querySelector("#id_medico");
        let data_prenotazione = document.querySelector("#data_prenotazione");
        var data = JSON.stringify({
            id_reparto: id_reparto.value,
            id_medico: id_medico.value,
            data_prenotazione: data_prenotazione.value
        });

        /*fetch('http://localhost:8080/api/save-pazienti', {
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
                    console.log("")
                }
            })
            .catch(err => {
                if (err === "server")
                    console.log("")
            })
        event.preventDefault()
    })*/
})