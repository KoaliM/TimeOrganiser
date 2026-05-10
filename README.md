Time Organiser
==============

Integrated Spring Boot + Vue project for assignments, tasks, goals, hobbies,
friend search, and calendar/meeting views.

Project structure
-----------------

- `src/main/java` - Spring Boot backend source.
- `src/main/resources/application.properties` - backend database/JWT config.
- `TimeOrganiserFrontend/time-organiser` - Vue/Vite frontend app.
- `TimeOrganiserFrontend/package.json` - wrapper dependency file copied with the frontend.
- `pom.xml` - primary backend build file.
- `build.gradle` and `settings.gradle` also exist, but Maven is the working backend path in this repository.

Requirements
------------

- Java 17 or newer. The Maven build was validated with Java 21.
- Maven 3.6+.
- Node `^20.19.0` or `>=22.12.0`, from the frontend `package.json`.
- npm.

Backend
-------

Run from the repository root:

```powershell
mvn spring-boot:run
```

Run tests:

```powershell
mvn -q test
```

The backend starts on `http://localhost:8080`.

Frontend
--------

Run from `TimeOrganiserFrontend/time-organiser`:

```powershell
npm.cmd install
npm.cmd run dev
```

PowerShell may block `npm` scripts depending on ExecutionPolicy. Use `npm.cmd`
as shown above.

Build:

```powershell
npm.cmd run build
```

The Vite dev server normally starts on `http://localhost:5173`.

API base URL
------------

The frontend uses `src/services/api.ts` as a central API client.

Set the backend URL with:

```powershell
$env:VITE_API_BASE_URL="http://localhost:8080/api"
```

If unset, the frontend defaults to `http://localhost:8080/api`.

Implemented frontend-facing endpoints
-------------------------------------

- `POST /api/auth/register`
- `POST /api/auth/login`
- `GET /api/users`
- `GET /api/users/search`
- `PUT /api/users/{userId}`
- `DELETE /api/users/{userId}`
- `GET /api/friends`
- `GET /api/friends/users`
- `POST /api/friends/requests`
- `DELETE /api/friends/requests/{friendId}`
- `GET /api/friends/{friendId}/availability`
- `GET /api/assignments`
- `GET /api/assignments/all`
- `POST /api/assignments`
- `PUT /api/assignments/{title}/status`
- `DELETE /api/assignments/{title}`
- `GET /api/tasks`
- `POST /api/tasks`
- `PUT /api/tasks/{title}/status`
- `DELETE /api/tasks/{title}`
- `GET /api/goals`
- `POST /api/goals`
- `PUT /api/goals/{title}/status`
- `DELETE /api/goals/{title}`
- `GET /api/hobbies`
- `POST /api/hobbies`
- `PUT /api/hobbies/{title}/status`
- `DELETE /api/hobbies/{title}`
- `GET /api/calendar/me/week`
- `GET /api/calendar/google/status`
- `GET /api/calendar/google/connect`
- `GET /api/meet/{userId}`
- `GET /api/meet/count:{userId}`

Integration notes
-----------------

- `TimeOrganiserFrontend` was converted from a Git gitlink/submodule-style entry into normal tracked files.
- Frontend generated artifacts are ignored: `node_modules`, `dist`, `build`, and `.env*`.
- Maven `target/` output is ignored and removed from the Git index.
- The integration endpoints currently use a small in-memory data store so the Vue app can run end-to-end while the database model is cleaned up.
- JWTs are returned by auth endpoints, but API routes are currently permitted for local integration. Add a real JWT authentication filter before production use.
- Google Calendar endpoints are placeholders: they report disconnected status and return a Google Calendar URL.
- The existing PostgreSQL configuration points at the current `application.properties` database. Replace it for local/private environments as needed.
