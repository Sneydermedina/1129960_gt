$(document).ready(function () {

    $('#eliminarEvento').click(function () {

        swal("Here's a message!");

    });


    $('#calendar').fullCalendar({
        defaultDate: '2015-02-02',
        firstDay: 1,
        editable: true,
        eventLimit: true,
        eventStartEditable: true,
        eventDurationEditable: true,
        height: 570,
        selectable: true,
        selectHelper: true,
        navLinks: true, // can click day/week names to navigate views

        select: function (start, end) {

            swal({
                title: "Disponibilidad",
                type: "input",
                showCancelButton: true,
                closeOnConfirm: false,
                animation: "slide-from-top",
                inputPlaceholder: "Nombre del eventoDisponibilidad"
            },
                    function (inputValue) {

                        if (inputValue === false)
                            return false;

                        if (inputValue === "") {
                            swal.showInputError("Escribe el nombre del evento");
                            return false
                        }
                        var title = inputValue;

                        var eventData;
                        if (title) {
                            eventData = {
                                title: title,
                                start: start,
                                end: end,
                                backgroundColor: '#337AB7'
                            };
                            $('#calendar').fullCalendar('renderEvent', eventData, true); // stick? = true
                        }
                        $('#calendar').fullCalendar('unselect');
                        console.log(eventData.start._d);
                        console.log(eventData.end._d);
                        console.log(title);
                        swal("Nuevo evento", inputValue, "success");
                    });

        },
        droppable: true,
        drop: function (date) {
            alert("Dropped on " + dateTime.format());
        },
        buttonText: {
            today: 'Hoy',
            month: 'Mes',
            week: 'Semana',
            day: 'Día',
            listWeek: 'Agenda'
        },
        monthNames:
                ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio',
                    'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'],
        monthNamesShort:
                ['Ene', 'Feb', 'Mar', 'Abr', 'May', 'Jun',
                    'Jul', 'Ago', 'Sep', 'Oct', 'Nov', 'Dic'],
        dayNames:
                ['Domingo', 'Lunes', 'Martes', 'Miércoles',
                    'Jueves', 'Viernes', 'Sábado'],
        dayNamesShort:
                ['Dom', 'Lun', 'Mar', 'Mie', 'Jue', 'Vie', 'Sáb'],
        eventLimit: true, // for all non-agenda views
                views: {
                    agenda: {
                        eventLimit: 6 // adjust to 6 only for agendaWeek/agendaDay
                    }
                },
        buttonIcons:
                {
                    prev: 'angle-left',
                    next: 'angle-right',
                    prevYear: 'angle-double-left',
                    nextYear: 'angle-double-right'
                },
        eventDrop: function (event, delta, revertFunc) {

            var letras = event.start.format().toString();
            var cant = letras.length;
            console.log(event.title + " ha sido movido a: " + letras.substring(0, 10) + " a las " + letras.substring(11, cant));

        },
        eventResize: function (event, delta, revertFunc) {

            var letras = event.end.format().toString();
            var cant = letras.length;
            console.log(event.title + " La fecha final cambió a: " + letras.substring(0, 10));
            console.log(event.title + " La hora final cambió a: " + letras.substring(11, cant));

        },
        eventClick: function (calEvent, jsEvent, view) {

            swal({
                title: calEvent.title,
                type: "input",
                inputType: 'input',
                showCancelButton: true,
                closeOnConfirm: false,
                confirmButtonText: 'Guardar',
                cancelButtonText: 'Eliminar',
                confirmButtonColor: '#2895cc',
                animation: "slide-from-top",
                inputPlaceholder: "Nuevo nombre del evento"
            },
                    function (inputValue) {

                        if (inputValue === false)
                            return false;

                        if (inputValue === "") {
                            swal.showInputError("Escribe el nombre del evento");
                            return false
                        }
                        var title = inputValue;

                        if (title) {
                            calEvent.title = title;
                            $('#calendar').fullCalendar('updateEvent', calEvent);
                        }

                        swal("Listo", "El evento cambió a: " + inputValue, "success");
                    });
        }
    });

});

