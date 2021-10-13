# Progetto Clinica

Questo progetto è stato creato secondo le richieste che ci sono state presentate sulla traccia.

Per poter realizzare questo progetto abbiamo utilizzato **IntelliJ IDEA** come IDE, **XAMPP** come DBMS, **NodeJS** come 
server in locale per il Front-end del nostro progetto, **GitHub** come piattaforma online per organizzare ed unire i nostri codici,
permettedonci di lavorare assieme e rimanere sempre aggiornati.

Il progetto è stato scritto con **Java 11**, **HTML5**, **CSS3**, **Javascript**, **MySQL** ed **HQL**, inoltre abbiamo fatto uso di due
framework, **Spring Boot v2.3.5**, **Bootstrap v5.1.2** e diverse librerie base appartenenti ai rispettivi linguaggi.

Per gestire il livello ORM è stato utilizzato **Hibernate**, attraverso Spring Boot, con cui ci siamo occupati di gestire le 
dipendenze lato **Maven**, invece, per gestire le dipendenze lato Front-end, è stato utilizzato **NPM** tramite NodeJS.

Tramite Spring Boot abbiamo anche gestito diverse API che abbiamo sfruttato per effettuare passaggi di dati tra 
Front-End e Back-End, facendoli prima passare da Java.

---

#### Per poter avviare il progetto in locale è necessario eseguire questi step:

1) Scaricare il file "clinica.sql"
2) Creare uno Schema in locale intitolato "clinica"
3) Importare il file "clinica.sql" all'interno dello schema "clinica"
4) Scaricare il file zip del Progetto
5) Avviare Intellij ed aprire il Progetto dal file pom.xml come Progetto
6) Se si sta utilizzando un DBMS diverso da XAMPP, si prega di rivolgersi al punto 7, altrimenti passare al punto 8
7) Localizzare percorso "clinicaNNMM\src\main\resources" e aprire il file "application.properties" per modificare i parametri della connessione (#Connection parameters), presenti sulle linee 2, 3, 4 e 5.
8) Estendere l'albero del progetto e cliccare con tasto destro su web, localizzare "open in", entrare nel ramo e cliccare su "terminal"
9) Immettere il comando "npm start"
10) Il Progetto è adesso operativo
