# Vivoconsult Website

A corporate website for **Vivoconsult**, a consulting company based in Agadir, Morocco, built with **Spring Boot** and **Thymeleaf**. The public site is in French. It comes with a built-in **admin dashboard** that lets the owner edit the site's content (texts, images, services) and read messages from visitors without touching the code.

> Built in 2024 as a full-stack learning and client project.

<!-- Add screenshots here, e.g.
![Home page](docs/screenshots/home.png)
![Admin dashboard](docs/screenshots/admin.png)
-->

## Features

**Public website**
- Home, Services, About (*Notre entreprise*) and Contact pages
- Hero section with a theme/slide switcher
- Contact form with server-side validation (name, email, and a minimum message length)
- Partner logos and an embedded Google Maps location

**Admin dashboard**
- Edit the home page content (headings, descriptions, image)
- Edit the About page content (header, text, photo)
- Full CRUD for services: add, edit (with image upload) and delete
- Inbox for contact-form messages: mark as read, star and delete, with an unread counter
- All content and uploaded images are stored in the database, so changes go live instantly

## Tech Stack

| Layer | Technology |
|-------|-----------|
| Language | Java 17 |
| Framework | Spring Boot 3.2.5 (Web, Data JPA, Validation) |
| Templating | Thymeleaf |
| Database | MySQL 8 (via Hibernate / JPA) |
| Frontend | HTML, CSS, vanilla JS, jQuery, Font Awesome |
| Build tool | Maven (wrapper included) |

## Project Structure

```
src/main/java/com/vivoconsult/vivoconsultWebsite/
├── *Controller.java      # Web layer (public pages + admin pages)
├── *Service.java         # Business logic
├── *Repository.java      # Spring Data JPA repositories
└── *Content.java, UserMessage.java   # JPA entities

src/main/resources/
├── templates/            # Public pages (index, services, about, contact)
│   └── adminPages/       # Admin dashboard pages
├── static/               # CSS, JS, images, webfonts
└── application.properties
```

## Getting Started

### Prerequisites
- JDK 17+
- MySQL 8+
- Maven (or just use the included `./mvnw`)

### 1. Create the database

```sql
CREATE DATABASE vivoconsultdatabase CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
```

### 2. Configure the connection

Edit `src/main/resources/application.properties` with your own MySQL details:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/vivoconsultdatabase
spring.datasource.username=your_username
spring.datasource.password=your_password
```

Tables are created automatically on first run (`spring.jpa.hibernate.ddl-auto=update`).

### 3. Run the app

```bash
./mvnw spring-boot:run
```

The site starts on **http://localhost:8080**. Open `/index` for the home page.

### 4. Seed the editable content

The home and About pages read the row with `id = 1`, so insert one row in each table after the first run, then fill in the real content from the admin dashboard:

```sql
INSERT INTO index_table (h1, home_description) VALUES ('Welcome', 'Edit me from the admin dashboard');
INSERT INTO about_table (header2, about_text)  VALUES ('About us', 'Edit me from the admin dashboard');
```

## Routes

| Route | Description |
|-------|-------------|
| `/index` | Home page |
| `/services` | Services page |
| `/about` | About page |
| `/contact` | Contact page |
| `/admin` | Admin dashboard |
| `/indexContent` | Edit home page content |
| `/aboutcontent` | Edit About page content |
| `/servicesContent` | Manage services |
| `/messages` | Visitor messages inbox |

## Known Limitations / Roadmap

- [ ] **Add authentication.** The admin routes are currently open and should be protected with Spring Security before any real deployment.
- [ ] Move database credentials and API keys to environment variables
- [ ] Map `/` to the home page
- [ ] Store uploaded images on disk or object storage instead of BLOBs in the database
- [ ] Add pagination for the messages inbox
- [ ] Add unit and integration tests
- [ ] Add multi-language support

## License

This project is provided for portfolio purposes. Add a license of your choice (e.g. MIT) if you want others to reuse it.

## Author

Created by **YOUR NAME** · [GitHub](https://github.com/YOUR_USERNAME)
