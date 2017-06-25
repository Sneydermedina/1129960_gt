function detailFormatter(index, row) {
    var html = [];
    $.each(row, function (key, value) {
        html.push('<p><b>' + key + ':</b> ' + value + '</p>');
    });
    return html.join('');
}

$().ready(function () {


    var alturaDispositivo = document.body.scrollHeight;
    $('.menu-lateral').css('height', alturaDispositivo);

    $('#eliminar').click(function () {

        var seleccionados = JSON.stringify($('table').bootstrapTable('getSelections'));

        if (seleccionados != '[]') {
            var ids = $.map($('#table').bootstrapTable('getSelections'), function (row) {
                return row.tiquet;
            });
            $('#table').bootstrapTable('remove', {
                field: 'tiquet',
                values: ids
            });
        } else {

        }

    });

    $('#boton').click(function () {
        var datosSeleccionados = JSON.stringify($('table').bootstrapTable('getSelections'));
        swal('getSelections: ' + datosSeleccionados);
    });
    console.log($('table').bootstrapTable('getSelections').ids);

    // $('#table').bootstrapTable('insertRow', {
    //       index: 0, 
    //       row: {
    //         check:'',
    //         tiquet: 123,
    //         tipo: 'Instalación',
    //         descripcion: 'Instalación cámaras',
    //         valor: '$ 100000',
    //         estado: 'Realizado',
    //         archivo: '<button class="btn btn-primary"><span class="fa fa-download"></span> Descargar</button>',
    //         garantia: '2 años',
    //         fecha: '10/10/2010'
    //       }
    //     });

    $('.icono-menu-lateral').click(function () {
        $('.menu-lateral').toggleClass('ocultar-menu-lateral');
        $('.menu-lateral').toggleClass('mostrar-menu-lateral');
        $('.contenido').toggleClass('col-md-offset-2');
        $('.contenido').toggleClass('col-sm-offset-1');
        $('.contenido').toggleClass('col-md-10');
        $('.contenido').toggleClass('col-md-12');
        $('.contenido').toggleClass('col-sm-11');
        $('.contenido').toggleClass('col-sm-12');
        $('.contenido').toggleClass('hidden-xs');
        $('.contenido').toggleClass('visible-xs');
        $('.value').toggleClass('.value');
        $('.value').toggleClass('.value2');

    });

    $('#borrarFilas').click(function () {

        if ($('#borrarFilas').hasClass('disabled')) {
        } else {
            swal({
                title: "Eliminar",
                text: "¿Seguro que deseas eliminar este registro?",
                type: "warning",
                showCancelButton: true,
                confirmButtonColor: "#DD6B55",
                confirmButtonText: "Eliminar",
                cancelButtonText: "Cancelar",
                closeOnConfirm: false
            },
                    function () {
                        // $('table').bootstrapTable('removeAll');
                        // $('table').bootstrapTable('removeByUniqueId', 1);
                        $('table').bootstrapTable('getAllSelections');

                        $('#borrarFilas').addClass('disabled');
                        swal("Eliminado", "Su registro ha sido eliminado", "success");
                    });
        }
    });

    // Responsive

    if ($(window).width() <= 980) {
        $('#table').bootstrapTable('toggleView');
        $('#table').attr('data-show-toggle', 'false');

    }

});
