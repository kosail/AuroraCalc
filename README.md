# AuroraCalc
### Clean, simple, and modern. Inspired by Windows 11’s "Mica" aesthetic.

![AuroraCalc screenshot](repo_images/main.png)


AuroraCalc is a Windows 11-inspired calculator built with **Kotlin + JavaFX**, aiming to provide a sleek, modern, and minimalistic user experience. The goal is to faithfully recreate the look and feel of the native Windows 11 calculator while leveraging the power of JavaFX for cross-platform compatibility.

## 🚀 Current Status

- **Development Stage:** Early Development (GUI 80% complete, Logic not implemented yet)
- **Functionality:** Currently, the app runs but lacks operational logic. The interface is mostly in place, but additional features and logic need to be implemented.
- **Usability:** At this stage, the calculator is non-functional and serves as a UI prototype.

## 🎯 Features (Planned)

✅ **Windows 11-inspired UI** with a clean and modern design  
✅ **Smooth Animations** and aesthetic transitions  
✅ **Basic Arithmetic Operations** (+, -, ×, ÷)  
✅ **Scientific Functions** (trigonometry, logarithms, etc.)  
✅ **History & Memory Functions**  
✅ **Keyboard Shortcuts Support**  
✅ **Dark Mode / Theming Support** (by now, it only supports dark theme)

## 🛠️ Technologies Used

- **Kotlin** – Main programming language
- **JavaFX** – GUI framework
- **CSS** – Custom styling for modern aesthetics
- **FXML** – UI structure

## 📂 Project Structure
```
AuroraCalc/
├── src/main/kotlin/com/korealm/         # Kotlin source code
│   ├── Main.kt                           # Entry point of the app
│   ├── InitController.kt                 # Handles UI interactions
│   └── ...                               # Other Controller classes
├── src/main/resources/com/korealm/      # UI resources
│   ├── main.fxml                          # UI layout
│   ├── styles/                            # CSS files
│   ├── icons/                             # Icons used in the app
│   └── ...
├── README.md                             # This file
├── LICENSE                               # GPLv3 (GNU General Public License v3)
└── ...
```

## 🔧 How to Run

1. Clone the repository:
   ```sh
   git clone https://github.com/kosail/AuroraCalc.git
   cd AuroraCalc
   ```
2. Open the project in **IntelliJ IDEA** (recommended) or another IDE with Kotlin support. Just keep in mind that **this project does not uses gradle or maven**. It was build with pure IntelliJ.
3. Run the `Main.kt` file to launch the application.

## 📌 Roadmap
- [ ] Finalize UI elements and layout
- [ ] Implement core calculator logic
- [ ] Add scientific calculator functions
- [ ] Enhance UI with animations and better responsiveness
- [ ] Improve keyboard accessibility
- [ ] Optimize performance

## 🤝 Contributing
Contributions are welcome! Feel free to fork the repository and submit pull requests. If you have ideas, suggestions, or bug reports, open an issue on GitHub.

## 📜 License
[GPLv3 (GNU General Public License v3)](LICENSE) – Free to use, modify, and distribute as long as this remains open source and it is not use for profitable purposes.

---
> **Note:** AuroraCalc is a personal learning project and is not affiliated with Microsoft, Windows 11 or any other brand or product.

