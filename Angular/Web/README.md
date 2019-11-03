Am adaugat boilerplate-ul pentru Angular. Acesta expune deja o metoda de autentificare si are un backend mock-uit.

!!!NECESAR!!!
-> ide:
visual studio code

-> biblioteci:
sudo apt-get update
sudo apt-get install nodejs
sudo apt-get install npm
sudo npm install -g n
sudo n stable
sudo apt-get install build-essential
npm install -g @angular/cli
mkdir ~/.npm-global
npm config set prefix '~/.npm-global'
export PATH=~/.npm-global/bin:$PATH
source ~/.profile

-> deschideti folder-ul in vscode, porniti terminalul in-built si rulati:
npm install  // doar prima data cand luati proiectul pentru a instala dependintele
npm start SAU ng serve --open   // de fiecare data dupa ce modificati codul si reporniti serverul

Tutorial pentru boilerplate:
https://jasonwatmore.com/post/2019/08/06/angular-8-role-based-authorization-tutorial-with-example


-> nu ne vom preocupa de etapa de testare in momentul de fata
-> vom modifica doar in src/app


TODO:
- separa view-urile
- rezolva routing-ul
- mapare entitati db in models
- no unit testing for web - functional testing only
