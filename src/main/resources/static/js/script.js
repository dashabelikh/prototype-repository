$( document ).ready(function() {
    $("#slider").slider({
        min: 0,
        max: 10000,
        value: 0,
        step: 1,
        slide: function( event, ui ) {
            $("#sliderLabel").text(ui.value);
          },
    });
});

$(document).on("click", "#generateButton", function(){
    $.ajax({
        type: "POST",
        url: '/generate',
        data: {numberOfEvents: $('#slider').slider("option", "value")},
        success: function (data, textStatus) {
            window.location.reload();
        }
      });
});

$(document).on("click", "#deleteButton", function(){
    $.ajax({    
        type: "POST",
        url: '/delete/all',
        success: function (data, textStatus) {
            window.location.reload();
        }
      });
});
