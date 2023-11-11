const darkModeToggle = document.getElementById('dark-mode-toggle');
const body = document.body;

function toggleDarkMode() {
    body.classList.toggle('light-mode');
    if (body.classList.contains('light-mode')) {
        // Set the mode preference in local storage
        localStorage.setItem('dark-mode-preference', 'light');
    } else {
        localStorage.setItem('dark-mode-preference', 'dark');
    }
}

const preferredMode = localStorage.getItem('dark-mode-preference');
if (preferredMode === 'light') {
    toggleDarkMode(); // Switch to light mode if preferred
}

darkModeToggle.addEventListener('click', toggleDarkMode);
