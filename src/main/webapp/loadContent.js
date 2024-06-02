document.addEventListener('DOMContentLoaded', function() {
    fetch('pages/principalpage.html')
        .then(response => response.text())
        .then(html => document.getElementById('content').innerHTML = html)
        .catch(error => console.error('Error to load page:', error));
});
