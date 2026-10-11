<div align="center">

# 📸 ScreenShotter

**A lightweight Java desktop tool that captures screenshots with a global keyboard shortcut.**

![Java](https://img.shields.io/badge/Java-21-orange?logo=openjdk&logoColor=white)
![Maven](https://img.shields.io/badge/Build-Maven-C71A36?logo=apachemaven&logoColor=white)
![Platform](https://img.shields.io/badge/Platform-Windows-0078D6?logo=windows&logoColor=white)
![Status](https://img.shields.io/badge/Status-In%20Development-yellow)

</div>

---

## 📖 Table of Contents

- [About](#-about)
- [Features](#-features)
- [Tech Stack](#-tech-stack)
- [Project Structure](#-project-structure)
- [Getting Started](#-getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
  - [Running the App](#running-the-app)
- [Usage](#-usage)
- [How It Works](#-how-it-works)
- [Configuration](#-configuration)
- [Roadmap](#-roadmap)
- [Contributing](#-contributing)
- [Author](#-author)

---

## 🧭 About

**ScreenShotter** is a simple desktop utility written in pure Java. It listens for global keyboard (and mouse) events in the background, so you can take a screenshot from anywhere without switching to the app window.

It was built as a personal learning project to practice:

- Working with native system hooks from Java
- Using the `java.awt` imaging APIs
- Structuring a Maven project

---

## ✨ Features

- ⌨️ **Global hotkey capture**: works even when the app is not focused
- 🖥️ **Full-screen screenshots**
- 💾 **Automatic saving** to a local folder
- 🪶 **Lightweight**: a single dependency, no heavy frameworks
- ☕ **Pure Java 21**

> <!-- TODO: edit this list to match exactly what your app does (region capture, clipboard copy, timestamped filenames, etc.) -->

---

## 🛠 Tech Stack

| Technology | Purpose |
|---|---|
| **Java 21** | Core language |
| **Maven** | Build and dependency management |
| **[system-hook 3.8](https://github.com/kristian/system-hook)** (`lc.kra.system`) | Global keyboard & mouse hooks |
| **java.awt.Robot** | Screen capture |
| **javax.imageio** | Saving images to disk |

---

## 📂 Project Structure

```
ScreenShotter/
├── src/
│   └── main/
│       └── java/          # Application source code
├── .gitignore
├── pom.xml                # Maven configuration
└── README.md
```

---

## 🚀 Getting Started

### Prerequisites

Make sure you have the following installed:

- **JDK 21** or newer: [Download](https://adoptium.net/)
- **Apache Maven 3.8+**: [Download](https://maven.apache.org/download.cgi)
- **Windows OS** (the `system-hook` library relies on native Windows hooks)

Verify your setup:

```bash
java -version
mvn -version
```

### Installation

1. **Clone the repository**

   ```bash
   git clone https://github.com/nvxist/ScreenShotter.git
   cd ScreenShotter
   ```

2. **Build the project**

   ```bash
   mvn clean package
   ```

### Running the App

**From your IDE (IntelliJ IDEA):**

1. Open the project folder as a Maven project.
2. Wait for dependencies to download.
3. Run the `main` class.

**From the terminal:**

```bash
mvn compile exec:java -Dexec.mainClass="com.nvxist.Main"
```

> <!-- TODO: replace com.nvxist.Main with your real main class -->

---

## 🎮 Usage

1. Launch the application.
2. Press the configured **hotkey** from anywhere on your system.
3. The screenshot is captured and saved automatically.
4. Check the output folder to find your image.

| Action | Shortcut |
|---|---|
| Take screenshot | `<!-- TODO: e.g. PrintScreen / Ctrl+Shift+S -->` |
| Exit | `<!-- TODO: e.g. Esc -->` |

---

## ⚙️ How It Works

```
┌──────────────┐   key event   ┌───────────────┐   trigger   ┌───────────────┐
│  Windows OS  │ ────────────▶ │  system-hook  │ ──────────▶ │  Screenshot   │
│ (global input)│               │ (key listener)│             │  logic (Robot)│
└──────────────┘               └───────────────┘             └───────┬───────┘
                                                                     │
                                                                     ▼
                                                           ┌───────────────────┐
                                                           │ Save PNG to disk  │
                                                           └───────────────────┘
```

1. `system-hook` registers a low-level global keyboard listener.
2. When the hotkey is detected, the capture logic is triggered.
3. `Robot.createScreenCapture()` grabs the screen as a `BufferedImage`.
4. `ImageIO.write()` saves it as a PNG file.

---

## 🔧 Configuration

| Setting | Default | Description |
|---|---|---|
| Output folder | `<!-- TODO -->` | Where screenshots are saved |
| Image format | `PNG` | Output image format |
| Hotkey | `<!-- TODO -->` | Key that triggers the capture |

---

## 🗺 Roadmap

- [x] Global hotkey listener
- [x] Full-screen capture
- [ ] Region / area selection
- [ ] Copy screenshot to clipboard
- [ ] Custom hotkey configuration
- [ ] System tray icon
- [ ] Multi-monitor support
- [ ] Cross-platform support (Linux / macOS)
- [ ] Simple GUI settings window

---

## 🤝 Contributing

Contributions, issues, and feature requests are welcome!

1. Fork the project
2. Create your feature branch: `git checkout -b feature/amazing-feature`
3. Commit your changes: `git commit -m "Add amazing feature"`
4. Push to the branch: `git push origin feature/amazing-feature`
5. Open a Pull Request

---

## 👤 Author

**nvxist**

- GitHub: [@nvxist](https://github.com/nvxist)

---

<div align="center">

⭐ If you found this project useful, consider giving it a star!

</div>
