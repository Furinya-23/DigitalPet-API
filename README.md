🐾 DigitalPetAPI

DigitalPetAPI is a backend application based on Hexagonal Architecture with a Screaming Architecture approach, developed in Java 24 using Spring Boot 3.4.5 and MapStruct 1.6.3

🏗️ Project Structure
```text
com.digipet.digitalpetapi
├── [feature]                        # 🏷️ Feature (e.g. pet, user)
│    ├── application                 # 🚀 Application Layer
│    │   └── service                 # ⚙️ Business use case services
│    ├── domain                      # 🏰 Domain Layer (Pure Logic)
│    │   ├── model                   # 🪶 Domain models/entities
│    │   ├── exception               # 🚨 Domain-specific exceptions
│    │   └── ports                   # 🔌 Hexagonal Ports
│    │       ├── input               # ⬆️ Use case input interfaces
│    │       └── output              # ⬇️ Persistence output interfaces
│    └── infrastructure.adapters     # 🛠️ Infrastructure Layer
│       ├── input.rest               # 🌐 REST Input Adapter
│       │   ├── controller           # 🎮 REST controllers
│       │   ├── dto                  # 📦 Request/response DTOs
│       │   └── mapper               # 🗺️ REST mappers (MapStruct)
│       └── output.persistence       # 💾 Persistence Output Adapter
│           ├── entity               # 🏷️ JPA entities
│           ├── mapper               # 🗺️ Persistence mappers (MapStruct)
│           └── repository
│               ├── interfaces       # 📜 Repository interfaces
│               └── implementation   # ⚡ Repository implementations
│
├── shared                           # 📦 Shared Resources
│   ├── conf                         # ⚙️ General configuration
│   └── security.jwt                 # 🔐 JWT security config and utils
└── DigitalPetApiApplication         # 🚀 Spring Boot main application class
```

⚖️ Technologies Used

Java 24

Spring Boot 3.4.5

MapStruct 1.6.3

Hexagonal Architecture (Ports & Adapters)

Screaming Architecture Naming

👀 Key Principles

Domain-Centric Design: Core business logic lives in the domain package.

Decoupling: The application logic does not depend on frameworks or technologies.

Separation of Concerns: Each layer has a clear responsibility.

Pluggability: Infrastructure concerns (e.g., REST, persistence) are swappable.

🔒 JWT and Security

JWT configuration and related classes are located in:

shared/security.jwt

This package handles token generation, validation, and user authentication integration.


DigitalPetAPI © 2025
