# [Semesteroppgave 1: “Rogue One oh one”](https://retting.ii.uib.no/inf101.v18.sem1/blob/master/SEM-1.md)


* **README**
* [Oversikt](SEM-1.md) – [Praktisk informasjon 5%](SEM-1.md#praktisk-informasjon)
* [Del A: Bakgrunn, modellering og utforskning 15%](SEM-1_DEL-A.md)
* [Del B: Fullfør basisimplementasjonen 40%](SEM-1_DEL-B.md)
* [Del C: Videreutvikling 40%](SEM-1_DEL-C.md)

Dette prosjektet inneholder [Semesteroppgave 1](SEM-1.md). Du kan også [lese oppgaven online](https://retting.ii.uib.no/inf101.v18.oppgaver/inf101.v18.sem1/blob/master/SEM-1.md) (kan evt. ha små oppdateringer i oppgaveteksten som ikke er med i din private kopi).

**Innleveringsfrist:**
* Del A + minst to deloppgaver av Del B skal være ferdig til **fredag 9. mars kl. 2359**. 
* Hele oppgaven skal være ferdig til **onsdag 14. mars kl. 2359**

(Kryss av under her, i README.md, så kan vi følge med på om du anser deg som ferdig med ting eller ikke. Hvis du er helt ferdig til den første fristen, eller før den andre fristen, kan du si fra til gruppeleder slik at de kan begynne å rette.)

**Utsettelse:** Hvis du trenger forlenget frist er det mulig å be om det (spør gruppeleder – evt. foreleser/assistenter hvis det er en spesiell situasjon). Hvis du ber om utsettelse bør du helst være i gang (ha gjort litt ting, og pushet) innen den første fristen.
   * Noen dagers utsettelse går helt fint uten begrunnelse, siden oppgaven er litt forsinket.
   * Hvis du jobber med labbene fremdeles, si ifra om det, og så kan du få litt ekstra tid til å gjøre ferdig labbene før du går i gang med semesteroppgaven. Det er veldig greit om du er ferdig med Lab 4 først.
   * Om det er spesielle grunner til at du vil trenge lengre tid, så er det bare å ta kontakt, så kan vi avtale noe. Ta også kontakt om du [trenger annen tilrettelegging](http://www.uib.no/student/49241/trenger-du-tilrettelegging-av-ditt-studiel%C3%B8p). 
   

# Fyll inn egne svar/beskrivelse/kommentarer til prosjektet under
* Levert av:   Tom Rune Saeveras (Yap006)
* Del A: [ ] helt ferdig, [ ] delvis ferdig
* Del B: [ ] helt ferdig, [ ] delvis ferdig
* Del C: [ ] helt ferdig, [ ] delvis ferdig
* [ ] hele semesteroppgaven er ferdig og klar til retting!

# Del A
a) The state of objects that implements the different interfaces have their state defined by the paramters that are put into the different methods. For example, IGame is defined by the map it gets in, with IActors on said map.

b)  It appears that between the interfaces, IItem is the connection. This returns all the different items that can be added and removed and exists in the map.    
    
c) IMapView is the ground pillar of the mapping itself, which contains all the basic things a map needs. IGameMap builds on the IMapView with some extra additions of spicy abilities. 

d) I think iNonPlayer and IPlayer are different so we can separete objects that the user interacts with, and the objects that the programe deals with. This is mostly because the player gets his orders from the keyboard, and when you seperate players/non-players you don't risk them getting mixed up. 
At first glance I wouldn't do it differently, but who knows, maybe I end up loathing it the more I work with it. 

e) I think the implementation was fairly accurate based on my previous thoughts. You have both Rabbit and Carrot that are placed on a map. You between the two of them they both interfere with eachother, as the carrot is food for the rabbit as an item, and the rabit is a Non Player that doesn't get interference from the keyboard, and are looking for carrots to eat.

f) THe rabbit finds out its position when it goeas through the local items in the map. Because the call returns things nearby the CURRENT location of the rabbit. This is also where it finds out what items that are on a certain spot. The legal moves of the rabit is decided when the rabbit looks for possible moves. All moves are legal as long as it's not a player or wall.

g) The game knows there the rabbit is when it asks with the line "currentLocation = map.getLocation(currentActor);". This also lets the game know which rabbit asks for the location

# Del B
a) In the labs the cells and stuff have been handled by updating x and y coordinates. In this task we have only called upon a direction (north, south etc). This is much easier for me because you have made methods that handles the positioning on the board :) 

b) Everything runs through game because this is the easiest way to keep controll over all objects in the map. It's easier for one class to keep track of everything, and that all the other classes can just call on that one boss-class. As far as I can tell there are no real disadvanteges, but the biggest advantage is that there's no need for all the classes to communicate directly with each other, all the communication happens through the board.

c) When dropping stuff, there should be a check if the square that is going to have an item dropped on it, is free. I did this myself, but it should definitly be done.

d) I still think the same of the questions from part A.



As a comment in general of this task, I think the knowledge level required to do many of the tasks are to high based on what we have learned in earlier labs and in the lectures. Especially on he time limit and the amount of code we have to orient us-self in, Of course, this could just be me that thinks this, but I still think the level was to high for what we are supposed to have learned. 
# Del C
## Oversikt over designvalg og hva du har gjort
* ... blah, blah, er implementert i klassen [KurtMario](src/inf101/v18/rogue101/player/KurtMario.java), blah, blah `ITurtleShell` ...
 
