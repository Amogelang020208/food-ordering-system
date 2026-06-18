RESEARCH-DAY-01.md - Concepts
Q1. What does CRUD stand for?  
CRUD is Create, Read, Update, Delete. They’re the 4 basic things you do with data. In REST: POST creates, GET reads, PUT/PATCH updates, DELETE removes.
Q2. Difference between POST, PUT, PATCH, DELETE?  
•  POST: Makes a new resource. Server picks the id. Send twice = 2 records.
•  PUT: Replaces the whole resource. You must send all fields. Send twice = same result.
•  PATCH: Updates only some fields. Use when you don’t want to send the whole object.
•  DELETE: Removes the resource. Send twice = still gone, so it’s idempotent.
Q3. Status codes:  
a. Created: 201 Created  
b. Deleted ok: 204 No Content  
c. ID not found: 404 Not Found  
d. Missing field: 400 Bad Request  
e. Logged in but no permission: 403 Forbidden
Q4. @RequestBody vs @RequestParam vs @PathVariable  
•  @PathVariable: From URL path. /api/categories/5 → @PathVariable Long id gets 5.
•  @RequestParam: From query string. /search?name=pizza → @RequestParam String name gets pizza.
•  @RequestBody: From JSON body. POST {"name":"Drinks"} → @RequestBody CategoryDto dto gets the whole object.
Q5. Jakarta Bean Validation + @Valid, @NotBlank, @Size  
Jakarta Bean Validation checks data before it hits my service.  
•  @Valid: Tells Spring to actually run the checks on this object.  
•  @NotBlank: Field can’t be null/empty/spaces only.  
•  @Size(min=2, max=50): String must be 2-50 characters long.
Q6. Why DTO not entity? 2 reasons
1.  Security: Entity might have password or internalId that I don’t want to expose to the frontend.
2.  Flexibility: If I change my DB table, my API response stays the same. DTO separates API from database.
    Q7. What is Optional<T>? Why findById returns Optional?  
    Optional is a box that might have a value or be empty. It forces me to handle “not found” cases instead of getting NullPointerException. findById returns Optional because the id might not exist in the DB.
    Self-Quiz
    Q1. Why ResponseEntity instead of returning object?  
    So I can control the status code and headers. Returning just CategoryDto always gives 200 OK. With ResponseEntity I can return 201 Created or 204 No Content.
    Q2. What status should successful DELETE return? Why?  
    204 No Content. The delete worked but there’s nothing to send back. It’s the REST standard for delete.
    Q3. Update one field - PUT or PATCH? Defend.  
    PATCH. PUT is supposed to replace the whole resource. If I only send one field with PUT, other fields could become null. PATCH means “just update this part”.
    Q4. What happens if you forget @Valid?  
    Validation won’t run. Spring will accept invalid data like an empty name and save it to the DB. No 400 error happens.
    Q5. Why must update/delete have {id} in URL but create does not?  
    Create makes something new, so the client doesn’t know the id yet. Server generates it. For update/delete I need to tell the server exactly which record to change, so the id goes in the URL.
