var callService = function(){
    var url = document.location.origin;
    $.ajax({url: url+"/service/library/books/",
        type: 'GET',
        success: function (data, textStatus, jqXHR) {
            alert(data);
        }
    });
};

