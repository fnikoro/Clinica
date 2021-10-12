Per poter avviare il progetto in locale è necessario eseguire questi step:

1) Scaricare il file "clinica.sql"

2) Creare uno schema in locale intitolato "clinica"

3) Importare il file "clinica.sql" all'interno dello schema "clinica"

4) Scaricare il file zip del progetto

5) Estrarre il contenuto all'interno di una cartella

6) Avviare Intellij

7) Open new project

8) Localizzare il pom del progetto e selezionare "Open as Project"

9) Avviare l'applicazione spring  (Attenzione, se non si sta utilizzando Xampp con MariaDB, si prega di rivolgersi al punto 9.5, altrimenti passare avanti)

9.5) Qualora si stia usando MySQL, andare su "clinicaNNMM\src\main\resources" e aprire il file "application.properties" per modificare i parametri della connessione (#Connection parameters), presenti sulle linee 2, 3, 4 e 5

10) Estendere l'albero del progetto e cliccare con tasto destro su web, localizzare "open in", entrare nel ramo e cliccare su "terminal"

11) Immettere il comando "npm start" 

12) Enjoy