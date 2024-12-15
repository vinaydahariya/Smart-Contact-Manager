console.log("Script loaded");

let currentTheme = getTheme();

document.addEventListener("DOMContentLoaded", () => {
    changeTheme();
});

// Function to handle theme change
function changeTheme() {
    // Set initial theme on the webpage
    changePageTheme(currentTheme, currentTheme);

    // Set the listener for the change theme button
    const changeThemeButton = document.querySelector("#theme_change_button");

    changeThemeButton.addEventListener("click", (event) => {
        console.log("change theme button clicked");
        const oldTheme = currentTheme;
        
        // Toggle theme
        currentTheme = currentTheme === "dark" ? "light" : "dark";
        
        // Update the page theme
        changePageTheme(currentTheme, oldTheme);
    });
}

// Set theme in local storage
function setTheme(theme) {
    localStorage.setItem("theme", theme);
}

// Get theme from local storage
function getTheme() {
    let theme = localStorage.getItem("theme");
    return theme ? theme : "light";
}

// Change current page theme
function changePageTheme(newTheme, oldTheme) {
    // Update theme in local storage
    setTheme(newTheme);

    // Remove the previous theme and add the new theme
    document.querySelector("html").classList.remove(oldTheme);
    document.querySelector("html").classList.add(newTheme);

    // Update the button text
    document
        .querySelector("#theme_change_button")
        .querySelector("span").textContent = newTheme === "light" ? "Dark" : "Light";
}
