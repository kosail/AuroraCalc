# AuroraCalc
### Clean, simple, and modern. Inspired by Windows 11’s "Mica" aesthetic.

![AuroraCalc screenshot](repo_images/main.png)


AuroraCalc is a Windows 11-inspired calculator built with **Kotlin + JavaFX**, aiming to provide a sleek, modern, and minimalistic user experience. The goal is to recreate the look and feel of the native Windows 11 calculator while leveraging the power of JavaFX for cross-platform compatibility.

## 🚀 Current Status

- **Development Stage:** Mid-Development. The GUI is fully functional with one exception: the menu sidebar. Even though it opens up and you are able to change the theme between dark and light mode, it has a bug were it does not display entirely. I'm working on that.

- **Functionality:** All operations are possible. App buttons and keyboard as input work. Due the powerful library this calculator uses beneath (exp4j) it is capable of doing cientific calculations. However, they are not yet implemented and they will be not until I figure out how to make the menu work well. No menu = no chance to change modes, unfortunately.

- **Usability:** At this stage, the calculator is functional for developers and for end users (although it is limited to be a simple calculator) due to the things I already mentioned.

- **Known bugs:** When using the buttons in the app all works fine (for instance, overwriting ^6 for ⁶ which is more eye-candy), but when using the keyboard as input... oh boi, I burned down my head trying to remove the default behavior from the TextField when receiving numbers from 0-9 and handle it myself. It was... hard. I got to the resolution that I would need to rethink the entire design of the GUI, changing the listeners to the main StackPane instead of the VBox containing all of the elements, and maybe changing the TextField for a Label which gives me more fine control. But that would be insanely difficult for me at this point, so I will just go ahead. Let's say keyboard input is handled well, but is not as polished as I planned it to be.

## 🎯 Features (Planned)

✅ **Windows 11-inspired UI** with a clean and modern design  
✅ **Smooth Animations** and aesthetic transitions  
✅ **Basic Arithmetic Operations** (+, -, ×, ÷)  
⚠️ **Scientific Functions** (trigonometry, logarithms, etc.)  
✅ **History & Memory Functions**  
✅ **Keyboard Shortcuts Support**  
✅ **Dark Mode / Theming Support**

![Themes screenshot](repo_images/themes.png)

## 🛠️ Technologies Used

- **Kotlin** – Main programming language
- **JavaFX** – GUI framework
- **CSS** – Custom styling for modern aesthetics
- **FXML** – UI structure

## 📂 Project Structure
```
AuroraCalc/
├── src/main/kotlin/com/korealm/         # Kotlin source code
│   ├── Main.kt                          # Entry point of the app
│   ├── InitController.kt                # Main config file
│   ├── NumPadController.kt              # Handles UI interactions
│   ├── HistorySidebar.kt                
│   ├── MenuSidebar.kt                   
├── src/main/resources/com/korealm/      # UI resources
│   ├── main.fxml                          # UI layout
│   ├── styles/                            # CSS files
│   ├── fonts/                            
│   ├── icons/                             # Icons used in the app
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
2. Open the project in **IntelliJ IDEA** (recommended) or another IDE with Kotlin support. Make sure you have installed JavaFX (OpenJFX).
3. Run the `Main.kt` file to launch the application, if using IntelliJ, or run it with maven from the terminal or your preferred IDE.

## 📌 Roadmap
- [-] Finalize UI elements and layout
- [X] Implement core calculator logic
- [ ] Add scientific calculator functions
- [-] Enhance UI with animations and better responsiveness
- [ ] Improve keyboard accessibility
- [ ] Optimize performance

## 🤝 Contributing
Contributions are welcome! Feel free to fork the repository and submit pull requests. If you have ideas, suggestions, or bug reports, open an issue on GitHub.

## 🎒 Resources
* Font: [Selawik](https://github.com/microsoft/Selawik), by Microsoft
* Icons: [Win11 Icon Theme](https://store.kde.org/p/1546069), by yeyushengfan258
* Libraries: [exp4j](https://www.objecthunter.net/exp4j/), by objecthunter


## 📜 License
[GPLv3 (GNU General Public License v3)](LICENSE.txt) – Free to use, modify, and distribute as long as this remains open source, and it is not use for profitable purposes.

---
> **Note:** AuroraCalc is a personal learning project and is not affiliated with Microsoft, Windows 11 or any other brand or product.

