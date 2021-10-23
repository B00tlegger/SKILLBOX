$(function(){

//    const appendToDo = function(data){
//        var toDoCode = '<a href="#" class="event-link" data-id="' +
//            data.id + '">' + data.name + '</a><br>';
//        $('#todo-list')
//            .append('<div>' + toDoCode + '</div>');
//    };

    //Loading books on load page
//    $.get('/books/', function(response)
//    {
//        for(i in response) {
//            appendBook(response[i]);
//        }
//    });

    //Show adding book form
    $('#show-add-todo-form').click(function(){
        $('#todo-form').css('display', 'flex');
    });

    //Closing adding book form
    $('#todo-form').click(function(event){
        if(event.target === this) {
            $(this).css('display', 'none');
        }
    });

    //Getting book
    $(document).on('click', '.event-link', function(){
        var link = $(this);
        var eventId = link.data('id');
        $.ajax({
            method: "GET",
            url: '/things/' + eventId,
            success: function(response)
            {
                var code = '<br><span>Дата:' + response.date + '</span><br>';
                link.parent().append(code);
                var code = '<span>Место: ' + response.place + '</span><br>';
                link.parent().append(code);
            },
            error: function(response)
            {
                if(response.status == 404) {
                    alert('Книга не найдена!');
                }
            }
        });
        return false;
    });

    //Adding book
//    $('#save-book').click(function()
//    {
//        var data = $('#todo-form form').serialize();
//        $.ajax({
//            method: "POST",
//            url: '/things/',
//            data: data,
//            success: function(response)
//            {
//                $('#todo-form').css('display', 'none');
//                var book = {};
//                toDo.id = response;
//                var dataArray = $('#todo-form form').serializeArray();
//                for(i in dataArray) {
//                    toDo[dataArray[i]['name']] = dataArray[i]['value'];
//                }
//                appendToDo(toDo);
//            }
//        });
//        return false;
//    });

});