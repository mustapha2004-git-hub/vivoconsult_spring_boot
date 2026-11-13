document.addEventListener("DOMContentLoaded", function () {
    const section = document.querySelector(".main");
    const prevBtn = document.getElementById("left-btn");
    const nextBtn = document.getElementById("right-btn");
    const circles = document.querySelectorAll(".circles .circle"); // Corrected selector
    let currentTheme = 1;
    const totalThemes = 3;

    function changeTheme(theme) {
        section.className = "main"; // Remove all existing theme classes
        section.classList.add(`theme${theme}`); // Add new theme class

        circles.forEach((circle, index) => {
            if (index + 1 === theme) {
                circle.classList.add('active');
            } else {
                circle.classList.remove('active');
            }
        });
    }

    prevBtn.addEventListener("click", function () {
        currentTheme = currentTheme === 1 ? totalThemes : currentTheme - 1;
        changeTheme(currentTheme);
    });

    nextBtn.addEventListener("click", function () {
        currentTheme = currentTheme === totalThemes ? 1 : currentTheme + 1;
        changeTheme(currentTheme);
    });

    // Initially set the first theme
    changeTheme(currentTheme);
});


//google maps image 

$(document).ready(function () {
    $('#map-thumbnail').click(function () {
        var mapIframe = $('<iframe id="map-iframe" frameborder="0" style="border:0" allowfullscreen></iframe>');
        mapIframe.attr('src', 'https://www.google.com/maps/embed/v1/place?key=AIzaSyAdvJhuiPBjDq0Y306LbJm89gHiLwaMmUA&q=30.344765,-9.499572');
        $('#map-container').empty().append(mapIframe);
        mapIframe.fadeIn();
    });
});

// alert message 




