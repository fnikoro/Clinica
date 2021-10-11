window.addEventListener("load", function(e){
    document.querySelector('.userMenu').addEventListener('click', function (e){
        e.preventDefault()
        document.querySelector("#loggedUserMenu").classList.toggle("open")
    })
})