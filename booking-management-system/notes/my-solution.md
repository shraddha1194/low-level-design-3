### Requirements gathering:
* Can we have multiple cities?
* Can we have multiple theaters?
* Can we have multiple shows?
* Can we have movie in multiple languages?
* Can user book multiple tickets?
* What are different payment mode?
* how user books a ticket?


Create a movie booking management system like BookMyShow to allow a user to search and book movie tickets.

### Requirements

Build an online movie ticket booking system that can support the following requirements:

* Support for multiple **cities**
* Each city will have multiple **theater**
* Each theater can have multiple **screens**
* Each screens will play one **movie** at a time
* A theater will play multiple movies
* Each screens can have multiple _types_ of **seats**
    * GOLD
    * DIAMOND
    * PLATINUM
* Allow the user to **_search_** a movie by name
* Allow the user to **_filter_** movies by the following _fields_
    * Location
    * Cinema
    * Language
    * Rating
    * Category
* Each movie can have multiple **shows**
* **Users** can book **tickets** and **_pay_** via multiple **payment** **methods**
    * UPI
    * Credit Card
    * Netbanking
* A user can apply a **coupon** or a promo code at checkout
* A user can see the **_availability of seats_** in a screen
* The _price_ of a ticket will be decided by multiple _parameters_
    * Seat Type
    * Day of the week
    * Time of the Day
    * Movie
    * Cinema hall
* A user can also **_cancel or update_** a **booking**
* A user cannot book or cancel after the cutoff time which is 1 hour before the movie starts


### Uses cases

```plantuml
@startuml
left to right direction
actor User
actor Admin

rectangle booking-mgmt-system {
Admin --> (Create a city)
Admin --> (Add a movie)
Admin --> (Add/Remove/Update a show)
Admin --> (Add/Remove theater and screens)

User --> (Select a city)
User --> (Search for a movie)
User --> (Book a movie)
User --> (Pay)
User --> (Cancel/Update a booking)

(Net banking) .> (Pay): extends
(UPI) .> (Pay): extends
(Book a movie) .> (Check availability): includes
(Pay) .> (Update booking status): includes  
}
@enduml
```

### Class diagrams

```mermaid
classDiagram
    
    class City {
        - name: String
        - theater: List<Theater>
    }
    
    class Theater {
        - name : String
        - screen: List<Screen>
        - show : List<Show>
        - address: String
    }
    
    class Screen {
        - name : String
        - show : List<Show>
        - seats : List<Seat>
    }
    
    class Seat {
        - seatNumber : String
        - type : SeatType
    }
    
    class SeatType {
        <<enumeration>>
        PLATIMUN, DIAMOND, GOLD
    }
    
    class Show {
        - startTime : Date
        - duration : Integer
        - movie : Movie
        - language : Language
        - screen : Screen
        - feature : List<Feature>
    }
    
    class ShowSeat {
        - show : Show
        - seat: Seat
        - status: SeatStatus
    }
    
    class Movie {
        - name : String
        - genre: List<Genre>
        - language : List<Language>
        - rating: Double
        - feature : List<Feature>
    }
    
    class User {
        - name : String
        - email : String
    }
    
    class Ticket {
        - show : Show
        - amount : Double
        - user : User
        - status : TicketStatus
        - date: Date
    }

    class TicketStatus {
        <<enumeration>>
        CONFIRMED, CANCELED,
    }
    
    class Payment {
        - paymentId : Long
        - paymentMethod: PaymentMethod
        - paymentStatus : PaymentStatus
        - date : Date
        - ticket : List<Ticket>
        - amount : Double
        
    }
    
    class PaymentStatus {
        <<enumeration>>
        CONFIRMED, PROCESSING, FAILED
    }
    
    class Feature {
        <<enumeration>>
        2D, 3D, IMAX, DOLBY
    }
    
    class SeatStatus {
        <<enumeration>>
        BOOKED, AVAILABLE, OUT_OF_ORDER
    }
    
    class PaymentMethod {
        <<enumeration>>
        UPI, NET_BANKING, CREDIT_CARD, WALLET
    }
    
    class Language {
        <<enumeration>>
        ENGLISH, HINDI
    }
    
    class Genre {
        <<enumeration>>
        HORRER, ACTION, COMEDY, ROMANCE, SUSPENSE
    }
    
    City "1"--*"m" Theater 
    Theater "1"--*"m" Screen
    Screen "1" --* "m" Seat
    Seat "m" --o "1" SeatType
    Show "m" --o "1" Movie
    Show "1" --o "1" Language
    Show "m" --o "1" Screen
    Show "m" --o "n"Feature
    ShowSeat "1"--* "1" Show
    ShowSeat "1" --* "1" Seat
    ShowSeat "m" --o "1" SeatStatus
    Movie "m" --o "n"  Genre
    Movie "m" --o "n" Language
    Movie "m" --o "n" Feature
    Ticket "m" --* "1" User
    Ticket "m" --o "1" TicketStatus
    Payment "1" --* "m" Ticket 
    Payment "m" --o "1" PaymentMethod
    Payment "m"--o "1" PaymentStatus
```