$(document).ready(function() {
    $.ajax({
        url: "http://api.geonames.org/citiesJSON"
    }).then(function(data) {
       $('.citiesJSON-message').append(data.status.message);
       $('.citiesJSON-value').append(data.status.value);
    });
});