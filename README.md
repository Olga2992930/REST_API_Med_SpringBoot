Applikationen som följer vissa REST principer:

Uniform Interface med hypermedia (och Springs inbyggda HATEOAS med RepresentationModel bland annat)
Layered systems (controller-service-repository arkitektur)
Stateless (ingen lokal state sparas, allt lagras i databas)

Utöver REST implementerar applikationen också OpenID-connect autentisering med  GitHub. Det går att logga in genom GitHub
och skapa filer med GitHub kontot. Det finns följande funktionalitet:

Registrering av användare (genom OpenID-connect)
Inloggning av användare (genom OpenID-connect)
Alla mappar och filer är kopplade till en användare
Användare kan inte se andras filer och mappar
Om man inte är inloggad kan man inte göra något, förutom att registrera en användare och logga in
